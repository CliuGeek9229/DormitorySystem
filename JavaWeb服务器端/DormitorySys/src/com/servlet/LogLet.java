package com.servlet;
  
  import java.io.IOException;
  import java.io.PrintWriter;
  
  import javax.servlet.ServletException;
  import javax.servlet.http.Cookie;
  import javax.servlet.http.HttpServlet;
  import javax.servlet.http.HttpServletRequest;
  import javax.servlet.http.HttpServletResponse;
  
  import org.omg.CORBA.PUBLIC_MEMBER;

import com.domain.User;
import com.google.gson.Gson;
import com.service.Service;
  
  public class LogLet extends HttpServlet {
  
  	private static final long serialVersionUID = 369840050351775312L;
  
  	/**
  	 * The doGet method of the Server let.
  	 */
  
  	public void doGet(HttpServletRequest request, HttpServletResponse response)
  			throws ServletException, IOException {
  		request.setCharacterEncoding("UTF-8");
	     response.setCharacterEncoding("UTF-8");
  		// 接收信息
  		String username = request.getParameter("username");
  		String password = request.getParameter("password");
  		String confirm;
  		System.out.println(username + "--" + password);
  		// 新建服务对象
  		Service serv = new Service();
  		// 验证处理
  		User user = serv.login(username, password);
  		if ((user.getStuID())!=null) {
  			System.out.println("Succss1111111");
  			//User user = new User();
  			Gson gson = new Gson();
  			confirm = gson.toJson(user);
  			System.out.println(confirm);
  			request.getSession().setAttribute("username", username);
  		} else {
  			System.out.print("Failed");
  			confirm = "NO";
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
  
  		// 测试为何手机端中文乱码，电脑正常
  		// System.out.println("u1--"+username);
  		// System.out.println("u2--"+username);
  
  	}
  
  }