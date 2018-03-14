package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.Service;

public class getOldIfoLet extends HttpServlet{
	private static final long serialVersionUID = -4415294210787731608L;

	/**
	 * The doGet method of the Server let.
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 新建服务对象
		Service serv = new Service();
		
		// 接收注册信息
		//user = jsonTools.getUser(request.getc, User.class);
		String confirm;
		
		
		confirm = serv.getOld();
		
		if (confirm != null) {
			System.out.println("GetLodInfo Success!!!");
			System.out.println(confirm);
			
		}else {
			System.out.println("getOldInfo failed");
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
