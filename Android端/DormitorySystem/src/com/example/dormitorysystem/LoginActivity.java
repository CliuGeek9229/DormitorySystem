package com.example.dormitorysystem;

import com.example.dormitorysystem.R;
import com.example.dormitorysystem.app.MyApplication;
import com.example.dormitorysystem.entity.user;
import com.example.dormitorysystem.json.JsonTools;
import com.example.dormitorysystem.service.WebServiceGet;


import android.net.ConnectivityManager;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.Gravity;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity implements OnClickListener{
	
	static Activity B11;
	//private Button TLogin;
	private Button SLogin;
	private Button Register;
	private EditText typein_name;
	private EditText typein_pwd;
	
	private ProgressDialog dialog;
	// 返回的数据
	private String info;
	// 返回主线程更新数据
	private static Handler handler = new Handler();
	
	private MyApplication app;
	private String name;
	private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_login);
        
        init();
        B11 = this;
        
     
    }
    
    
    
    @Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		
		B11 = this;
	}



	void init(){
		
		SLogin = (Button) findViewById(R.id.Studlogin);
		Register = (Button) findViewById(R.id.register);
		typein_name = (EditText) findViewById(R.id.name);
		typein_pwd = (EditText) findViewById(R.id.password);
		
		SLogin.setOnClickListener(LoginActivity.this);
		Register.setOnClickListener(LoginActivity.this);
		app = (MyApplication) getApplication();
		name = typein_name.getText().toString();
		password = typein_pwd.getText().toString();
		//X = app.getPagenum();
	}


   
 // 子线程接收数据，主线程修改数据
 	public class MyThread implements Runnable {
 		@Override
 		public void run() {
 			info = WebServiceGet.executeHttpGet("LogLet",typein_name.getText().toString(), typein_pwd.getText().toString());
 			Log.e("Login!!!!!!!!!!!!!!", info);
 			
 			// info =
 			// WebServicePost.executeHttpPost(username.getText().toString(),
 			// password.getText().toString());
 			handler.post(new Runnable() {
 				@Override
 				public void run() {
 					// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
 					//infotv.setText(info);
 					
 					
 					dialog.dismiss();
 					user USer = new user();
 					USer = JsonTools.getUser(info,user.class);
 					Log.e("!!!Login!!!!", USer.getStuID());
 					Log.e("!!!Login!!!!", USer.getStuPW());
 					Log.e("!!!Login!!!!", USer.getRealname());
 					Log.e("!!!Login!!!!", USer.getSex());
 					Log.e("!!!Login!!!!", USer.getMajor());
 					String a = USer.getApartment()+"";
 					Log.e("!!!Login!!!!", a);
 					Log.e("!!!Login!!!!", USer.getSchool());
 					Log.e("!!!Login!!!!", USer.getDormitory()+"");
 					
 					
 					if((USer.getStuID())!=null){
 						app.setStuID(USer.getStuID());
 						app.setStuPW(USer.getStuPW());
 						app.setRealname(USer.getRealname());
 						app.setSex(USer.getSex());
 						app.setSchool(USer.getSchool());
 						app.setMajor(USer.getMajor());
 						app.setApartment(USer.getApartment());
 						app.setDormitory(USer.getDormitory());
 						
 						Log.e("Login", app.getStuID());
 						Log.e("Login", app.getStuPW());
 						Log.e("Login", app.getRealname());
 						Log.e("Login", app.getSex());
 						Log.e("Login", app.getSchool());
 						Log.e("Login", app.getMajor());
 						Log.e("Login", app.getApartment()+"");
 						Log.e("Login", app.getDormitory()+"");
 						
 						
 						Toast toast = Toast.makeText(LoginActivity.this, "欢迎登录宿舍管理系统！", Toast.LENGTH_SHORT);
 	 					toast.setGravity(Gravity.CENTER, 0, 0);
 	 					toast.show();
 	 					
 	 					//app.setName(name);
 	 					//app.setPassword(password);
 	 					
 						Intent intent = new Intent(LoginActivity.this,MainActivity.class);
 	 					startActivity(intent);
 	 					LoginActivity.this.finish();
 					}
 					else if(info.equals("No")){
 						Toast toast = Toast.makeText(LoginActivity.this, "账号或密码错误！", Toast.LENGTH_SHORT);
 	 					toast.setGravity(Gravity.CENTER, 0, 0);
 	 					toast.show();
 					}
 					else{
 						Toast toast = Toast.makeText(LoginActivity.this, "连接超时！", Toast.LENGTH_SHORT);
 	 					toast.setGravity(Gravity.CENTER, 0, 0);
 	 					toast.show();
 					}
// 					if(info == 1){
// 					
// 					Intent intent = new Intent(LoginActivity.this,MainActivity.class);
// 					startActivity(intent);
// 					LoginActivity.this.finish();
// 					}
 					
 				}
 			});
 		}
 	}
    
    
 private void clickLogin(){
 	// 检测网络 这里我用的Wlan测试，但此方法只允许网络流量，只能先禁掉。
//		if (!checkNetwork()) {
//			Toast toast = Toast.makeText(Login.this,"网络未连接", Toast.LENGTH_SHORT);
//			toast.setGravity(Gravity.CENTER, 0, 0);
//			toast.show();
//			break;
//		}
		// 提示框
 		if(typein_name.getText().toString().equals("")){
 			Toast toast = Toast.makeText(LoginActivity.this,"用户名不能为空！", Toast.LENGTH_SHORT);
 			toast.show();
 		}
 		else if(typein_pwd.getText().toString().equals("")){
 			Toast toast = Toast.makeText(LoginActivity.this,"密码不能为空！", Toast.LENGTH_SHORT);
 			toast.show();
 		}
 		else{
		dialog = new ProgressDialog(this);
		dialog.setTitle("提示");
		dialog.setMessage("正在登陆，请稍后...");
		dialog.setCancelable(false);
		dialog.show();
		// 创建子线程，分别进行Get和Post传输
		new Thread(new MyThread()).start();
 		}
 	}
 	private void clickRegister(){
 		Intent intent = new Intent(LoginActivity.this,RegisterAvticity.class);
		startActivity(intent);
 	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.Studlogin:
			clickLogin();
			break;
		case R.id.register:
			clickRegister();
			break;
		default:
			break;
		
		
		}
	}
    
}
