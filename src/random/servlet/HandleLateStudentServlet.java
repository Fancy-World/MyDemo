package random.servlet;

import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HandleLateStudentServlet
 */
public class HandleLateStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String params [] = request.getParameterValues("lateStudents");
		for(String tempStr : params) {
			System.out.println("旷课:"+tempStr);
		}
		
		//设置response的返回类型
		response.setCharacterEncoding("utf-8");
		response.addHeader("content-Type","text/plain");
		String fileName="lateStudents.txt";
		response.addHeader("content-Disposition","attachment;filename="+fileName);
		OutputStream os = response.getOutputStream();
		//向输出流中写
		//写逃课名单前几行的内容
		String header = "旷课学生名单\r\n";
		byte newByte[] = header.getBytes("utf-8");
		os.write(newByte);
		int sum = params.length;
		header = "共:"+sum+"人\r\n\r\n";
		newByte = header.getBytes("utf-8");
		os.write(newByte);
		//往输出流中写逃课名单
		for(String tempStr : params) {
			tempStr=tempStr+"\r\n";
			newByte = tempStr.getBytes("utf-8");
			os.write(newByte);
		}
		os.close();
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
