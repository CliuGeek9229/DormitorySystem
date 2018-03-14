package com.example.dormitorysystem;

import com.example.dormitorysystem.app.MyApplication;
import com.example.dormitorysystem.service.WebServiceGet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class SignlateActivity extends Activity implements OnClickListener{
	private ImageView back;
	private Button signup;
	private MyApplication app;
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
        setContentView(R.layout.activity_signlate);
        
        init();
        
        
		
	}
	private void init(){
		back = (ImageView) findViewById(R.id.BackToMain);
		signup = (Button) findViewById(R.id.signup);
		
		app = (MyApplication) getApplication();
		
		back.setOnClickListener(SignlateActivity.this);
		signup.setOnClickListener(SignlateActivity.this);
	}
	private void BackMethod(){

		finish();
	}
private void clickSubmit(){
		
		
		dialog = new ProgressDialog(this);
		dialog.setTitle("提示");
		dialog.setMessage("正在给服务器提交晚归信息！请稍后。。。");
		dialog.setCancelable(false);
		dialog.show();
		// 创建子线程，分别进行Get和Post传输
		new Thread(new MyThread()).start();
		
		
	}
	// 子线程接收数据，主线程修改数据
		public class MyThread implements Runnable {
				@Override
				public void run() {
					
					
					info = WebServiceGet.executeSignlate("SignlateLet",app.getStuID(),app.getRealname(),app.getSchool(),app.getApartment(),app.getDormitory());
					
					handler.post(new Runnable() {
						@Override
						public void run() {
							// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
							
							dialog.dismiss();
							if(info.equals("YES")){
								
								
		 						Toast toast = Toast.makeText(SignlateActivity.this, "晚归信息提交成功！", Toast.LENGTH_LONG);
		 	 					toast.setGravity(Gravity.CENTER, 0, 0);
		 	 					toast.show();
		 	 					
		 	 					BackMethod();
		 					}
		 					else if(info.equals("No")){
		 						Toast toast = Toast.makeText(SignlateActivity.this, "晚归信息提交失败！请稍后重试", Toast.LENGTH_SHORT);
		 	 					toast.setGravity(Gravity.CENTER, 0, 0);
		 	 					toast.show();
		 					}
		 					else{
		 						Toast toast = Toast.makeText(SignlateActivity.this, "服务器连接超时！请检查您的网络！", Toast.LENGTH_SHORT);
		 	 					toast.setGravity(Gravity.CENTER, 0, 0);
		 	 					toast.show();
		 					}
						}
					});
				}
			}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.BackToMain:
			BackMethod();
			break;
		case R.id.signup:
			clickSubmit();
			break;
		default:
			break;
		}
	}
	
	
	
	
}
