package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class GetMylostLet extends HttpServlet{
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
		
		String tmp = request.getParameter("stuID");
		tmp= new String(tmp.getBytes("iso-8859-1"),"UTF-8");
		System.out.println(tmp);
		
		// 接收注册信息
		//user = jsonTools.getUser(request.getc, User.class);
		String confirm;
		
		
		confirm = serv.getMyLostInfo(tmp);
		
		if (confirm != null) {
			System.out.println("GetMyLost Success!!!");
			System.out.println(confirm);
			
		}else {
			System.out.println("GetMyLost failed");
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
}
