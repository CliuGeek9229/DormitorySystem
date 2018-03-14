package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.domain.LostInfo;
import com.domain.StayInfo;
import com.json.jsonTools;
import com.service.Service;

public class CallStayLet extends HttpServlet{
	private static final long serialVersionUID = -4415294210787731608L;

	/**
	 * The doGet method of the Server let.
	 */

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 新建服务对象
		Service serv = new Service();
		
		// 接收注册信息
		
		StayInfo fb = new StayInfo();
		//user = jsonTools.getUser(request.getc, User.class);

		String tmp = request.getParameter("stuID");
		tmp= new String(tmp.getBytes("iso-8859-1"),"UTF-8");
		System.out.println("客户端传过来数据！");
		System.out.println(tmp);
		System.out.println("啊啊啊啊啊啊啊啊啊啊啊啊啊");
		
		fb = jsonTools.getUser(tmp, StayInfo.class);
		
		String stuID = fb.getStuID();
		String username = fb.getRealname();
		String apartment = fb.getApartment()+"";
		String dormitory = fb.getDormitory()+"";
		
		//System.out.println(username);
		
		
		
		String reason = fb.getDetail();
		
		
		String confirm;

		
		System.out.println("ppppppppppp");
		System.out.println(stuID + "--" + username + "--"+apartment+"---"+dormitory+"----"+reason);
		// 验证处理
		
		
		boolean reged = serv.CallStay(stuID, username, apartment, dormitory, reason);
		System.out.println("test" + reged);
		if (reged) {
			System.out.println("Insert callstay Info Succss");
			confirm="YES";
			//request.getSession().setAttribute("username", username);
			//response.sendRedirect("welcome.jsp");
		}else {
			System.out.println("Insert callstay Info Failed");
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
