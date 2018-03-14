package com.example.dormitorysystem;


import com.example.dormitorysystem.app.MyApplication;
import com.example.dormitorysystem.service.WebServiceGet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.InputFilter;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class RegisterAvticity extends Activity implements OnClickListener{
	private ImageView back;
	
	private EditText Rname;
	private EditText Rpw;
	private EditText RpwG;
	private EditText RealName;
	
	private EditText Rschool;
	private EditText Rmajor;
	private EditText Rapartment;
	private EditText Rdormitory;
	
	private RadioGroup sex;
	private RadioButton man;
	private RadioButton woman;
	private String RadioSelect = "男";
	
	MyApplication app;
	
	private boolean fff;
	
	private Button Regis;
	
	//创建等待框
	private ProgressDialog dialog;
	//返回信息
	private String info;
	// 返回主线程更新数据
	private static Handler handler = new Handler();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_register);
        
        init();
        
        sex.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if(RegisterAvticity.this.man.getId() == arg1){
					RadioSelect = "男";
				}
				if(RegisterAvticity.this.woman.getId() == arg1){
					RadioSelect = "女";
				}
			}
		});
	}
	private void init(){
		
		app = (MyApplication) getApplication();
		
		back = (ImageView) findViewById(R.id.BackToMain);
		Regis = (Button) findViewById(R.id.register);
		Rname = (EditText) findViewById(R.id.Rname);
		Rpw = (EditText) findViewById(R.id.Rpwd);
		RpwG = (EditText) findViewById(R.id.RTpwd);
		RealName = (EditText) findViewById(R.id.RrealName);
		Rschool = (EditText) findViewById(R.id.Rschool); 
		Rmajor = (EditText) findViewById(R.id.Rprofession);
		Rapartment = (EditText) findViewById(R.id.Rapartment);
		Rdormitory = (EditText) findViewById(R.id.Rdormitory);
		
		
		back.setOnClickListener(RegisterAvticity.this);
		Regis.setOnClickListener(RegisterAvticity.this);
		
		sex = (RadioGroup) findViewById(R.id.sex);
		man = (RadioButton) findViewById(R.id.man);
		man.setChecked(true);
		woman = (RadioButton) findViewById(R.id.woman);
		
		Rname.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
		Rpw.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});
		RpwG.setFilters(new InputFilter[]{new InputFilter.LengthFilter(16)});
		RealName.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
		Rschool.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
		Rmajor.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
		Rapartment.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
		Rdormitory.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
		
	}
	
	private void backtoMain(){
		finish();
	}
	// 子线程接收数据，主线程修改数据
	public class MyThread implements Runnable {
			@Override
			public void run() {
				info = WebServiceGet.executeRegister("RegLet", Rname.getText().toString(), Rpw.getText().toString(),RealName.getText().toString(),Rschool.getText().toString(),Rmajor.getText().toString(),Rapartment.getText().toString(),Rdormitory.getText().toString(),RadioSelect);
				// info =
				// WebServicePost.executeHttpPost(username.getText().toString(),
				// password.getText().toString());
				handler.post(new Runnable() {
					@Override
					public void run() {
						// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
						
						dialog.dismiss();
						if(info.equals("YES")){
							app.setStuID(Rname.getText().toString());
							app.setStuPW(Rpw.getText().toString());
							app.setRealname(RealName.getText().toString());
							app.setSchool(Rschool.getText().toString());
							app.setMajor(Rmajor.getText().toString());
							app.setSex(RadioSelect);
							app.setApartment(Integer.parseInt(Rapartment.getText().toString()));
							app.setDormitory(Integer.parseInt(Rdormitory.getText().toString()));
							
							Log.e("ID", app.getStuID());
							Log.e("password",app.getStuPW());
							Log.e("realname", app.getRealname());
							Log.e("school", app.getSchool());
							Log.e("sex", app.getSex());
							Log.e("major", app.getMajor());
							Log.e("apartment",app.getApartment()+"");
							Log.e("dormitory", app.getDormitory()+"");
							
	 						Toast toast = Toast.makeText(RegisterAvticity.this, "欢迎登录宿舍管理系统！", Toast.LENGTH_SHORT);
	 	 					toast.setGravity(Gravity.CENTER, 0, 0);
	 	 					toast.show();
	 	 					
	 	 					//app.setName(Rname.getText().toString());
	 	 					//app.setPassword(Rpw.getText().toString());
	 	 					
	 						Intent intent = new Intent(RegisterAvticity.this,MainActivity.class);
	 	 					startActivity(intent);
	 	 					LoginActivity.B11.finish();
	 	 					RegisterAvticity.this.finish();
	 					}
	 					else if(info.equals("No")){
	 						Toast toast = Toast.makeText(RegisterAvticity.this, "注册失败！您可能已经注册过账号！", Toast.LENGTH_SHORT);
	 	 					toast.setGravity(Gravity.CENTER, 0, 0);
	 	 					toast.show();
	 					}
	 					else{
	 						Toast toast = Toast.makeText(RegisterAvticity.this, "服务器连接超时！请检查您的网络！", Toast.LENGTH_SHORT);
	 	 					toast.setGravity(Gravity.CENTER, 0, 0);
	 	 					toast.show();
	 					}
					}
				});
			}
		}

	
	private void other_cases(String A,String B,String C,String D,String E,String F,String G,String H){
		if(A.equals("")){
			Rname.setError("请输入用户名");
			fff = false;
		}
		if(B.equals("")){
			Rpw.setError("请输入密码");
			fff = false;
		}
		if(C.equals("")){
			RpwG.setError("请再次输入密码");
			fff = false;
		}
		if(D.equals("")){
			RealName.setError("请输入真实姓名");
			fff = false;
		}
		if(E.equals("")){
			Rschool.setError("请输入校区");
			fff = false;
		}
		if(F.equals("")){
			Rmajor.setError("请输入专业");
			fff = false;
		}
		if(G.equals("")){
			Rapartment.setError("请输入楼宇号");
			fff = false;
		}
		if(H.equals("")){
			Rdormitory.setError("请输入宿舍号");
			fff = false;
		}
		if(B.length()<3){
			Rpw.setError("密码必须大于3位并小于16位！");
			fff = false;
		}
		if(C.length()<3){
			RpwG.setError("确认密码必须大于3位并小于16位！");
			fff = false;
		}
		
		if(!B.equals(C)){
			Toast.makeText(getApplicationContext(), "两次输入的密码不一致，请重新输入！", Toast.LENGTH_SHORT).show();
			fff = false;
		}
		if(!fff){
			Toast.makeText(getApplicationContext(), "请在对应项处进行修改！", Toast.LENGTH_SHORT).show();
		}
		
		dialog = new ProgressDialog(this);
		dialog.setTitle("提示");
		dialog.setMessage("正在登陆，请稍后...");
		dialog.setCancelable(false);
		dialog.show();
		// 创建子线程，分别进行Get和Post传输
		new Thread(new MyThread()).start();
		
		
		
		
		
	}
	
	private void clickRegister(){
		fff = true;
		
		String name = Rname.getText().toString();
		String pwd = Rpw.getText().toString();
		String Tpwd = RpwG.getText().toString();
		String realname = RealName.getText().toString();
		String school = Rschool.getText().toString();
		String major = Rmajor.getText().toString();
		String apartment = Rapartment.getText().toString();
		String dormitory = Rdormitory.getText().toString();
		
		other_cases(name, pwd, Tpwd, realname, school, major, apartment, dormitory);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.BackToMain:
			backtoMain();
			break;
		case R.id.register:
			clickRegister();
			break;
		default:
				break;
				
		
		}
	}

}
