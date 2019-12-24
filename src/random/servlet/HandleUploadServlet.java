package random.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;



/**
 * 处理用户上传的excel文件
 */
public class HandleUploadServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory dfif = new DiskFileItemFactory();
		ServletFileUpload sfu = new ServletFileUpload(dfif);
		String extensionName = null;
		request.setCharacterEncoding("UTF-8");
		String name= null;
		try {
			List<FileItem> list = sfu.parseRequest(request);
			for(FileItem fileItem : list) {
				if(fileItem.isFormField()) {
					//啥也不做，你想做啥么
				}else {
					//是上传的表单,高度重视
					name = fileItem.getName(); //文件名
					//获取扩展名
					int dotIndex =name.lastIndexOf('.');
					extensionName =name.substring(dotIndex+1);
					System.out.println(extensionName);
					if(!(extensionName.equals("xls"))&&!(extensionName.equals("xlsx"))){
						break;
					}
					int index2 = name.lastIndexOf('\\');
					if(index2>0) {
						name=name.substring(index2+1);
					}
					System.out.println(name);
					if(name.length()<1) break;
					String path = request.getServletContext().getRealPath("/upload")+"\\"+name;
					System.out.println(path);
					InputStream inputStream = fileItem.getInputStream();
					OutputStream outPutStream = new FileOutputStream(path);
					byte [] newByte = new byte[1024];
					int len = 0;
					while((len= inputStream.read(newByte))!=-1) {
						outPutStream.write(newByte,0,len);
					}
					outPutStream.close();
					inputStream.close();
					//将路径存到session中
					request.getSession().setAttribute("path", path);
					response.sendRedirect("customize.jsp");
				}
			}
			if(name.length()<1||!(extensionName.equals("xls"))&&!(extensionName.equals("xlsx"))) {
				response.sendRedirect("index.jsp?msg=1");
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
