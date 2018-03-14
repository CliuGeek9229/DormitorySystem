package com.example.dormitorysystem;

import com.example.dormitorysystem.app.MyApplication;
import com.example.dormitorysystem.service.WebServiceGet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class modifyInfoActivity extends Activity implements OnClickListener{
	private ImageView back;
	
	private MyApplication app;
	
	//private MyApplication app;
	//创建等待框
			private ProgressDialog dialog;
			//返回信息
			private String info;
			// 返回主线程更新数据
			private static Handler handler = new Handler();
	
	private TextView stuID;
	private TextView stuPW;
	private TextView realname;
	private TextView school;
	private TextView major;
	private TextView apartment;
	private TextView dormitory;
	
	private RadioGroup sex;
	private RadioButton man;
	private RadioButton woman;
	private Button Modify;
	
	private String sex2 = "";
	
	private String s_stuID;
	private String s_realname;
	private String s_pw;
	private String s_major;
	private String s_sex;
	private String s_school;
	private String s_apartment;
	private String s_dormitory;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_modifyinfo);
		
		init();
		
		stuID.setEnabled(false);
		apartment.setEnabled(false);
		dormitory.setEnabled(false);
		school.setEnabled(false);
		
		stuID.setText(app.getStuID());
		realname.setText(app.getRealname());
		school.setText(app.getSchool());
		major.setText(app.getMajor());
		apartment.setText(app.getApartment()+"");
		dormitory.setText(app.getDormitory()+"");
		
		 if(app.getSex().equals("男")){
	        	sex2 = "男";
	        	man.setChecked(true);
	        }else{
	        	sex2 = "女";
	        	woman.setChecked(true);
	        }
		
		sex.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if(modifyInfoActivity.this.man.getId() == arg1){
					sex2 = "男";
				}
				if(modifyInfoActivity.this.woman.getId() == arg1){
					sex2 = "女";
				}
			}
		});
	}
	private void init(){
		back = (ImageView) findViewById(R.id.BackToMain);
		
		app = (MyApplication) getApplication();
		
		stuID = (TextView) findViewById(R.id.M_name1);
		realname = (TextView) findViewById(R.id.M_realname1);
		stuPW = (TextView) findViewById(R.id.M_pwd1);
		school = (TextView) findViewById(R.id.M_school1);
		major = (TextView) findViewById(R.id.M_profession1);
		dormitory = (TextView) findViewById(R.id.M_dormitory1);
		apartment = (TextView) findViewById(R.id.M_apartment1);
		
		back.setOnClickListener(modifyInfoActivity.this);
		
		sex = (RadioGroup) findViewById(R.id.sex);
		man = (RadioButton) findViewById(R.id.M_man1);
		woman = (RadioButton) findViewById(R.id.M_woman1);
		Modify = (Button) findViewById(R.id.modify);
		
		Modify.setOnClickListener(modifyInfoActivity.this);
	}
	private void clickBack(){
		finish();
	}
	private void clickModify(){
		dialog = new ProgressDialog(this);
		dialog.setTitle("提示");
		dialog.setMessage("正在给服务器提交修改申请！请稍后。。。");
		dialog.setCancelable(false);
		dialog.show();
		// 创建子线程，分别进行Get和Post传输
		new Thread(new MyThread()).start();
	}
	// 子线程接收数据，主线程修改数据
		public class MyThread implements Runnable {
				@Override
				public void run() {
					s_stuID = app.getStuID();
					s_realname = realname.getText().toString();
					s_pw = stuPW.getText().toString();
					s_major = major.getText().toString();
					s_sex = sex2;
					s_school = school.getText().toString();
					s_apartment = apartment.getText().toString();
					s_dormitory = dormitory.getText().toString();
					
					info = WebServiceGet.executeModify("ModifyLet",s_stuID,s_realname,s_pw,s_major,s_sex,Integer.parseInt(s_apartment),Integer.parseInt(s_dormitory),s_school);
					
					handler.post(new Runnable() {
						@Override
						public void run() {
							// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
							
							dialog.dismiss();
							if(info.equals("YES")){
								
								
		 						Toast toast = Toast.makeText(modifyInfoActivity.this, "个人信息修改申请成功！", Toast.LENGTH_SHORT);
		 	 					toast.setGravity(Gravity.CENTER, 0, 0);
		 	 					toast.show();
		 	 					
		 	 					app.setStuID(s_stuID);
		 	 					app.setRealname(s_realname);
		 	 					app.setStuPW(s_pw);
		 	 					app.setMajor(s_major);
		 	 					app.setSex(s_sex);
		 	 					
		 	 					finish();
		 	 					
		 	 					//ed1.setText("");
		 	 					
		 					}
		 					else if(info.equals("No")){
		 						Toast toast = Toast.makeText(modifyInfoActivity.this, "个人信息修改申请失败！请稍后重试", Toast.LENGTH_SHORT);
		 	 					toast.setGravity(Gravity.CENTER, 0, 0);
		 	 					toast.show();
		 					}
		 					else{
		 						Toast toast = Toast.makeText(modifyInfoActivity.this, "服务器连接超时！请检查您的网络！", Toast.LENGTH_SHORT);
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
		case R.id.modify:
			
				clickModify();
			break;
		default:
			break;
		}
	}

}
