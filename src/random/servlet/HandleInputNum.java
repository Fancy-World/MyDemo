package random.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import random.service.GetRandomStudent;
import random.service.HandleExcel;

/**
 * Servlet implementation class HandleInputNum
 */
public class HandleInputNum extends HttpServlet {
       
    /**
     * 处理用户在customize中输入的数字（生成多少个人）
     */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String person = request.getParameter("number");
		int personNum = 0;
		if(person.length()>0) {
			personNum = Integer.parseInt(person);
		}
		if(personNum<=0) {
			//如果用户没有什么有没有输入，却点了提交，则返回
			response.sendRedirect("customize.jsp");
		}else {
			System.out.println("输入的数为:"+personNum);
			//将输入的人数存入session中
			request.getSession().setAttribute("personNum",personNum);
			//实例处理excel的类
			HandleExcel handle  = new HandleExcel();
			String path = (String)request.getSession().getAttribute("path");
			//根据从request域中获得的路径（在服务器上的excel的路径），用excel处理类
			List<String> list = handle.handleExcel(path);
//			获得学生总数（并非java数组那样计数的总数）（即10就是10）
			int sumNum = handle.getSumNum(); //这条必须放在这里(handleExcle的后面)
			//检测是否输入的学生数大于总的学生数
			if(sumNum<personNum) {
				//如果用户输入的人数大于花名册中的学生总人数，则返回输入页（并携带错误参数用做显示）。
				response.sendRedirect("customize.jsp?num="+sumNum);
			}else {
				GetRandomStudent getRandomStudents = new GetRandomStudent();
				//得到随机学生名单.
				String [] studentsArr = getRandomStudents.getRandomStudent(personNum, list,sumNum);
				request.setAttribute("studentsArr", studentsArr);
				request.getRequestDispatcher("result.jsp").forward(request,response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
