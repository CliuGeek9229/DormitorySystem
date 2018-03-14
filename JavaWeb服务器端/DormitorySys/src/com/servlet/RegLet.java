package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.User;
import com.json.jsonTools;
import com.service.Service;

public class RegLet extends HttpServlet {

	private static final long serialVersionUID = -4415294210787731608L;

	/**
	 * The doGet method of the Server let.
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 //request.setCharacterEncoding("utf-8");
		//request.setCharacterEncoding("UTF-8");
		 //request.setCharacterEncoding("UTF-8");
	     //response.setCharacterEncoding("UTF-8");
		
		// 新建服务对象
		Service serv = new Service();
		
		// 接收注册信息
		
		User user = new User();
		//user = jsonTools.getUser(request.getc, User.class);

		String tmp = request.getParameter("stuID");
		tmp= new String(tmp.getBytes("iso-8859-1"),"UTF-8");
		System.out.println(tmp);
		
		user = jsonTools.getUser(tmp, User.class);
		
		String stuID = user.getStuID();
		String username = user.getRealname();
		
		System.out.println(username);
		
		String password = user.getStuPW();
		
		String sex = user.getSex();
		
		String school = user.getSchool();
		
		String major = user.getMajor();
		
		String apartment = user.getApartment()+"";
		
		String dormitory = user.getDormitory()+"";
		
		
		String confirm;

		
		
		System.out.println(stuID + "--" + username + "--" + password + "--" + sex + "--" + school + "--" + major + "--" + apartment + "--" + dormitory);
		// 验证处理
		
		
		boolean reged = serv.register(stuID,password,username,sex,school,major,apartment,dormitory);
		System.out.println("test" + reged);
		if (reged) {
			System.out.println("RegisterSuccss");
			confirm="YES";
			request.getSession().setAttribute("username", username);
			//response.sendRedirect("welcome.jsp");
		}else {
			System.out.println("RegisterFailed");
			confirm="NO";
		}

		// 返回信息
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.print(confirm);
		out.flush();
		out.close();
	}

	/**
	 * The doPost method of the Server let.
	 */

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		测试为何手机端中文乱码，电脑正常
//		System.out.println("u1--"+username);
//		System.out.println("u2--"+username);

	}

}