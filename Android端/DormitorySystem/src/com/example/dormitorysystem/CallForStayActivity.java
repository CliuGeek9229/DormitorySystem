package com.example.dormitorysystem;

import com.example.dormitorysystem.CallForFix.MyThread;
import com.example.dormitorysystem.app.MyApplication;
import com.example.dormitorysystem.service.WebServiceGet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class CallForStayActivity extends Activity implements OnClickListener{
	private ImageView back;
	private Button bt1;
	private CheckBox cb1;
	private TextView tv1;
	private EditText ed1;
	
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
        setContentView(R.layout.activity_callstay);
		init();
		
		cb1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean arg1) {
				// TODO Auto-generated method stub
				if(arg1){
					bt1.setEnabled(true);
				}
				else{
					bt1.setEnabled(false);
				}
			}
		});
		
		
	}

	private void init(){
		back = (ImageView) findViewById(R.id.BackToMain);
		bt1 = (Button) findViewById(R.id.button1);
		tv1 = (TextView) findViewById(R.id.safeAgree);
		cb1 = (CheckBox) findViewById(R.id.box1);
		ed1 = (EditText) findViewById(R.id.M_detail);
		
		app = (MyApplication) getApplication();
		
		back.setOnClickListener(CallForStayActivity.this);
		bt1.setOnClickListener(CallForStayActivity.this);
		tv1.setOnClickListener(CallForStayActivity.this);
		
		bt1.setEnabled(false);
		
		tv1.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}

	private void clickBack(){
		finish();
	}
	private void clickTextView(){
		Intent intent = new Intent();
		intent.setClass(CallForStayActivity.this, SafeAsignmentActivity.class);
		startActivity(intent);
	}
private void clickSubmit(){
		
		
		dialog = new ProgressDialog(this);
		dialog.setTitle("提示");
		dialog.setMessage("正在给服务器提交留校申请！请稍后。。。");
		dialog.setCancelable(false);
		dialog.show();
		// 创建子线程，分别进行Get和Post传输
		new Thread(new MyThread()).start();
		
		
	}
	// 子线程接收数据，主线程修改数据
		public class MyThread implements Runnable {
				@Override
				public void run() {
					info = WebServiceGet.executeCallStay("CallStayLet",app.getStuID(),app.getRealname(),app.getApartment(),app.getDormitory(),ed1.getText().toString());
					
					handler.post(new Runnable() {
						@Override
						public void run() {
							// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
							
							dialog.dismiss();
							if(info.equals("YES")){
								
								
		 						Toast toast = Toast.makeText(CallForStayActivity.this, "留校申请成功！", Toast.LENGTH_SHORT);
		 	 					toast.setGravity(Gravity.CENTER, 0, 0);
		 	 					toast.show();
		 	 					
		 	 					ed1.setText("");
		 	 					
		 					}
		 					else if(info.equals("No")){
		 						Toast toast = Toast.makeText(CallForStayActivity.this, "留校申请失败！请稍后重试", Toast.LENGTH_SHORT);
		 	 					toast.setGravity(Gravity.CENTER, 0, 0);
		 	 					toast.show();
		 					}
		 					else{
		 						Toast toast = Toast.makeText(CallForStayActivity.this, "服务器连接超时！请检查您的网络！", Toast.LENGTH_SHORT);
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
			clickSubmit();
			break;
		case R.id.safeAgree:
			clickTextView();
			break;
		default:
			break;
		}
	}

}
