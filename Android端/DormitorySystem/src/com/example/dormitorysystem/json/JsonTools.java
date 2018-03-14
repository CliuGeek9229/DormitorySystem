package com.example.dormitorysystem.json;

import org.json.JSONObject;

import com.example.dormitorysystem.entity.user;
import com.google.gson.Gson;

/**
 * 完成对json数据的解析
 * @author Cliu
 *
 */
public class JsonTools {

	public JsonTools() {
		// TODO Auto-generated constructor stub
	}
	
	public static <T> T getUser(String jsonstring,Class<T> cls){
		T t = null;
		try {
			Gson gson = new Gson(); 
			t = gson.fromJson(jsonstring, cls);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return t;
	}
	public static String createJsonString(Object value){
		Gson gson = new Gson();
		String gsonstring =  gson.toJson(value);
		return gsonstring;
	}

}
