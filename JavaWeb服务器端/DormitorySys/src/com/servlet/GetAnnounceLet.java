package com.servlet;


import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.Announce;
import com.json.jsonTools;
import com.service.Service;

public class GetAnnounceLet extends HttpServlet{
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
		//user = jsonTools.getUser(request.getc, User.class);
		String confirm;
		
		
		confirm = serv.getAnnounce();
		
		if (confirm != null) {
			System.out.println("GetAnnounce Success!!!");
			System.out.println(confirm);
			
		}else {
			System.out.println("getAnnounce failed");
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
