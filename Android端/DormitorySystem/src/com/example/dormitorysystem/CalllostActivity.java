package com.example.dormitorysystem;

import com.example.dormitorysystem.CallExchangeActivity.MyThread;
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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CalllostActivity extends Activity implements OnClickListener{
	private ImageView back;
	private Button bt1;
	private TextView tv1;
	private EditText ed1;
	
	private MyApplication app;

	//创建等待框
	private ProgressDialog dialog;
	//返回信息
	private String info = "";
	// 返回主线程更新数据
	private static Handler handler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_calllost);
        
        init();
        tv1.setText(app.getLostInfo());
	}
	private void init(){
		back = (ImageView) findViewById(R.id.BackToMain);
		bt1 = (Button) findViewById(R.id.button1);
		tv1 = (TextView) findViewById(R.id.details_2222);
		ed1 = (EditText) findViewById(R.id.M_detail);
		
		app = (MyApplication) getApplication();
		
		back.setOnClickListener(CalllostActivity.this);
		bt1.setOnClickListener(CalllostActivity.this);
		
	}
	private void clickBack(){
		finish();
	}
	private void clickButton(){
		dialog = new ProgressDialog(this);
		dialog.setTitle("提示");
		dialog.setMessage("正在给服务器发送物品丢失申请！请稍后。。。");
		dialog.setCancelable(false);
		dialog.show();
		// 创建子线程，分别进行Get和Post传输
		new Thread(new MyThread()).start();
	}
	// 子线程接收数据，主线程修改数据
			public class MyThread implements Runnable {
					@Override
					public void run() {
						info = WebServiceGet.executeCalllost("CallLostLet",app.getStuID(),app.getRealname(),ed1.getText().toString());
						
						handler.post(new Runnable() {
							@Override
							public void run() {
								// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
								
								dialog.dismiss();
								if(info.equals("YES")){
									
									
			 						Toast toast = Toast.makeText(CalllostActivity.this, "您的物品丢失申请已经上传！", Toast.LENGTH_SHORT);
			 	 					toast.setGravity(Gravity.CENTER, 0, 0);
			 	 					toast.show();
			 	 					
			 	 					//finish();
			 	 					ed1.setText("");
			 	 					
			 					}
			 					else if(info.equals("No")){
			 						Toast toast = Toast.makeText(CalllostActivity.this, "物品丢失申请失败！", Toast.LENGTH_SHORT);
			 	 					toast.setGravity(Gravity.CENTER, 0, 0);
			 	 					toast.show();
			 					}
			 					else{
			 						Toast toast = Toast.makeText(CalllostActivity.this, "服务器连接超时！请检查您的网络！", Toast.LENGTH_SHORT);
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
		case R.id.button1:
			clickButton();
			//Toast.makeText(getApplicationContext(), "提交", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}

}
