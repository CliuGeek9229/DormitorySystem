package com.example.dormitorysystem.service;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.example.dormitorysystem.entity.ApplyInfo;
import com.example.dormitorysystem.entity.FBInfo;
import com.example.dormitorysystem.entity.FixInfo;
import com.example.dormitorysystem.entity.LateInfo;
import com.example.dormitorysystem.entity.LostInfo;
import com.example.dormitorysystem.entity.StayInfo;
import com.example.dormitorysystem.entity.user;
import com.example.dormitorysystem.json.JsonTools;

import android.util.Log;

public class WebServiceGet {
	// IP地址
	private static String IP = "192.168.1.113:8080";
	//把TOMCATURL改为你的服务器地址
	
	/**
	 * 通过Get方式获取HTTP服务器数据
	 * 
	 * @return
	 */
	public static String executeHttpGet(String url,String username, String password) {
		HttpURLConnection conn = null;
		InputStream is = null;

		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			path = path + url + "?username=" + username + "&password=" + password;

			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");

			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	public static String executeRegister(String url,String username, String password, String realname, String school,String major,String apartment,String dormitory,String sex) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		Log.e(username, "ssss");
		
		
		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			
			user User = new user();
			User.setStuID(username);
			User.setStuPW(password);
			User.setSex(sex);
			User.setRealname(realname);
			User.setSchool(school);
			User.setMajor(major);
			User.setApartment(Integer.parseInt(apartment));
			User.setDormitory(Integer.parseInt(dormitory));
			
			String infomation = JsonTools.createJsonString(User);
			
			Log.e(">>>>Json", infomation);
			path = path + url + "?stuID=" + infomation;
			//path  = path + infomation;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	
	public static String executeSignlate(String url,String username, String realname, String school,int apartment,int dormitory) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		Log.e("!!!SignLate!!!", url+username+realname+school+apartment+dormitory);
		
		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			
			LateInfo fb = new LateInfo();
			fb.setStuID(username);
			fb.setRealname(realname);
			fb.setSchool(school);
			fb.setApartment(apartment);
			fb.setDormitory(dormitory);
			
			
			String infomation = JsonTools.createJsonString(fb);
			
			Log.e(">>>>Json", infomation);
			path = path + url + "?stuID=" + infomation;
			//path  = path + infomation;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	
	public static String executeCallFix(String url,String username, String realname, String school,int apartment,int dormitory, String detail) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		//Log.e(username, "ssss");
		
		
		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			
			FixInfo fb = new FixInfo();
			fb.setStuID(username);
			fb.setRealname(realname);
			fb.setSchool(school);
			fb.setApartment(apartment);
			fb.setDormitory(dormitory);
			fb.setDetail(detail);
			
			
			String infomation = JsonTools.createJsonString(fb);
			
			Log.e(">>>>Json", infomation);
			path = path + url + "?stuID=" + infomation;
			//path  = path + infomation;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	
	public static String executeCallStay(String url,String username, String realname, int apartment,int dormitory, String detail) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		//Log.e(username, "ssss");
		
		
		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			
			StayInfo fb = new StayInfo();
			fb.setStuID(username);
			fb.setRealname(realname);
			fb.setApartment(apartment);
			fb.setDormitory(dormitory);
			fb.setDetail(detail);
			
			
			String infomation = JsonTools.createJsonString(fb);
			
			Log.e(">>>>Json", infomation);
			path = path + url + "?stuID=" + infomation;
			//path  = path + infomation;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	
	public static String executeFeedBack(String url,String username, String realname, String school,int apartment,int dormitory, String detail) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		//Log.e(username, "ssss");
		
		
		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			
			FBInfo fb = new FBInfo();
			fb.setStuID(username);
			fb.setRealname(realname);
			fb.setSchool(school);
			fb.setApartment(apartment);
			fb.setDormitory(dormitory);
			fb.setDetail(detail);
			
			
			String infomation = JsonTools.createJsonString(fb);
			
			Log.e(">>>>Json", infomation);
			path = path + url + "?stuID=" + infomation;
			//path  = path + infomation;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	
	public static String executeExchangeApply(String url,String username, String realname, String school,int apartment,int dormitory,int targetApartment, int targetRoom,String detail) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		//Log.e(username, "ssss");
		
		
		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			
			ApplyInfo fb = new ApplyInfo();
			fb.setStuID(username);
			fb.setRealname(realname);
			fb.setSchool(school);
			fb.setApartment(apartment);
			fb.setDormitory(dormitory);
			fb.setTargetApart(targetApartment);
			fb.setTargetRoom(targetRoom);
			fb.setReason(detail);
			
			
			String infomation = JsonTools.createJsonString(fb);
			
			Log.e(">>>>Json", infomation);
			path = path + url + "?stuID=" + infomation;
			//path  = path + infomation;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	public static String executeCalllost(String url,String username, String realname, String detail) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		//Log.e(username, "ssss");
		
		
		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			
			LostInfo fb = new LostInfo();
			fb.setStuID(username);
			fb.setRealname(realname);
			fb.setDetail(detail);
			
			
			String infomation = JsonTools.createJsonString(fb);
			
			Log.e(">>>>Json", infomation);
			path = path + url + "?stuID=" + infomation;
			//path  = path + infomation;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	
	
	public static String executeGetAnnounce(String url) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		
		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			
			path = path + url;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	
	public static String executeGetMyFix(String url,String stuID) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		
		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			
			path = path + url+ "?stuID=" + stuID;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	
	public static String executeGetMyApply(String url,String stuID) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		
		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			
			path = path + url+ "?stuID=" + stuID;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	
	public static String executeGetMyLost(String url,String stuID) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		
		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			
			path = path + url+ "?stuID=" + stuID;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	
	public static String executeModify(String url,String stuID,String realname,String password,String major,String sex,int apartment,int dormitory,String school) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		
		try {
			// 用户名 密码
			// URL 地址
			user fb = new user();
			fb.setStuID(stuID);
			fb.setRealname(realname);
			fb.setStuPW(password);
			fb.setApartment(apartment);
			fb.setDormitory(dormitory);
			fb.setSchool(school);
			fb.setSex(sex);
			fb.setMajor(major);
			
			
			String infomation = JsonTools.createJsonString(fb);
			
			Log.e(">>>>Json", infomation);
			
			String path = "http://" + IP + "/DormitorySys/";
			
			path = path + url+ "?stuID=" + infomation;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	
	public static String executeGetMyExchange(String url,String stuID) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		
		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			
			path = path + url+ "?stuID=" + stuID;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	
	public static String executeGetOld(String url) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		
		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			
			path = path + url;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	
	public static String executeGetLost(String url) {
		HttpURLConnection conn = null;
		InputStream is = null;
		
		
		try {
			// 用户名 密码
			// URL 地址
			String path = "http://" + IP + "/DormitorySys/";
			
			path = path + url;
			
			conn = (HttpURLConnection) new URL(path).openConnection();
			conn.setConnectTimeout(3000); // 设置超时时间
			conn.setReadTimeout(3000);
			conn.setDoInput(true);
			conn.setRequestMethod("GET"); // 设置获取信息方式
			conn.setRequestProperty("Content-Encoding", "UTF-8");
			conn.setRequestProperty("Accept-Encoding", "UTF-8"); // 设置接收数据编码格式
			conn.setRequestProperty("contentType", "UTF-8");
			
			//conn.connect();
			
			if (conn.getResponseCode() == 200) {
				is = conn.getInputStream();
				return parseInfo(is);
			}
			return null;

		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 意外退出时进行连接关闭保护
			if (conn != null) {
				conn.disconnect();
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return "服务器连接超时...";
	}
	

	// 将输入流转化为 String 型
	private static String parseInfo(InputStream inStream) throws Exception {
		byte[] data = read(inStream);
		// 转化为字符串
		return new String(data, "UTF-8");
	}

	// 将输入流转化为byte型
	public static byte[] read(InputStream inStream) throws Exception {
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		byte[] buffer = new byte[1024];
		int len = 0;
		while ((len = inStream.read(buffer)) != -1) {
			outputStream.write(buffer, 0, len);
		}
		inStream.close();
		return outputStream.toByteArray();
	}
}