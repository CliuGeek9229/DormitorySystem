package com.example.dormitorysystem;

import com.example.dormitorysystem.RegisterAvticity.MyThread;
import com.example.dormitorysystem.app.MyApplication;
import com.example.dormitorysystem.service.WebServiceGet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class FeedbackActivity extends Activity implements OnClickListener{
	private ImageView back;
	private Button submit;
	private EditText detail;
	private MyApplication app;
	
	//创建等待框
		private ProgressDialog dialog;
		//返回信息
		private String info;
		// 返回主线程更新数据
		private static Handler handler = new Handler();
	
	private String stuID;
	//private String stuPW;
	private String realname;
	//private String sex;
	private String school;
	private String major;
	private int apartment;
	private int dormitory;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_feedback);
        init();
	}
	private void init(){
		back = (ImageView) findViewById(R.id.BackToMain);
		submit = (Button) findViewById(R.id.submit);
		detail = (EditText) findViewById(R.id.M_detail);
		app = (MyApplication) getApplication();
		
		back.setOnClickListener(FeedbackActivity.this);
		submit.setOnClickListener(FeedbackActivity.this);
	}
	private void clickBack(){
		finish();
	}
	private void clickSubmit(){
		
		
		dialog = new ProgressDialog(this);
		dialog.setTitle("提示");
		dialog.setMessage("正在给服务器反馈意见！请稍后。。。");
		dialog.setCancelable(false);
		dialog.show();
		// 创建子线程，分别进行Get和Post传输
		new Thread(new MyThread()).start();
		
		
	}
	// 子线程接收数据，主线程修改数据
		public class MyThread implements Runnable {
				@Override
				public void run() {
					info = WebServiceGet.executeFeedBack("FeedbackLet",app.getStuID(),app.getRealname(),app.getSchool(),app.getApartment(),app.getDormitory(),detail.getText().toString());
					
					handler.post(new Runnable() {
						@Override
						public void run() {
							// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
							
							dialog.dismiss();
							if(info.equals("YES")){
								
								
		 						Toast toast = Toast.makeText(FeedbackActivity.this, "反馈成功！感谢您的反馈！", Toast.LENGTH_SHORT);
		 	 					toast.setGravity(Gravity.CENTER, 0, 0);
		 	 					toast.show();
		 	 					
		 	 					detail.setText("");
		 	 					
		 					}
		 					else if(info.equals("No")){
		 						Toast toast = Toast.makeText(FeedbackActivity.this, "反馈失败，请稍后重试！", Toast.LENGTH_SHORT);
		 	 					toast.setGravity(Gravity.CENTER, 0, 0);
		 	 					toast.show();
		 					}
		 					else{
		 						Toast toast = Toast.makeText(FeedbackActivity.this, "服务器连接超时！请检查您的网络！", Toast.LENGTH_SHORT);
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
			clickBack();
			break;
		case R.id.submit:
			clickSubmit();
			break;
		default:
				break;
		}
	}

}
