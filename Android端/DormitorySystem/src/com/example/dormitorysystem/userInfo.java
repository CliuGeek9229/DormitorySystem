package com.example.dormitorysystem;



import com.example.dormitorysystem.app.MyApplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class userInfo extends Activity implements OnClickListener{
	private MyApplication app;
	
	private ImageView back;
	private Button exitsys;
	private TextView modifyInfo;
	
	private TextView stuID;
	private TextView realname;
	private TextView sex;
	private TextView school;
	private TextView major;
	private TextView apartment;
	private TextView dormitory;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.user_info);
        
        init();
        
        Log.e("USERINFO",app.getStuID());
        Log.e("USERINFO",app.getStuPW());
        Log.e("USERINFO",app.getRealname());
        Log.e("USERINFO",app.getSex());
        Log.e("USERINFO",app.getSchool());
        Log.e("USERINFO",app.getMajor());
        Log.e("USERINFO",app.getApartment()+"");
        Log.e("USERINFO",app.getDormitory()+"");
        
        stuID.setText(app.getStuID());
        realname.setText(app.getRealname());
        sex.setText(app.getSex());
        school.setText(app.getSchool());
        major.setText(app.getMajor());
        apartment.setText(app.getApartment()+"");
        dormitory.setText(app.getDormitory()+"");
        
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		 stuID.setText(app.getStuID());
	        realname.setText(app.getRealname());
	        sex.setText(app.getSex());
	        school.setText(app.getSchool());
	        major.setText(app.getMajor());
	        apartment.setText(app.getApartment()+"");
	        dormitory.setText(app.getDormitory()+"");
	}

	private void init(){
		back = (ImageView) findViewById(R.id.BackToMain);
		exitsys = (Button) findViewById(R.id.Logout);
		modifyInfo = (TextView) findViewById(R.id.M_myActivity);
		
		app = (MyApplication) getApplication();
		
		stuID = (TextView) findViewById(R.id.M_name);
		realname = (TextView) findViewById(R.id.M_realname);
		sex = (TextView) findViewById(R.id.M_sex);
		school = (TextView) findViewById(R.id.M_school);
		major = (TextView) findViewById(R.id.M_profession);
		apartment = (TextView) findViewById(R.id.M_buliding);
		dormitory = (TextView) findViewById(R.id.M_room);
		
		back.setOnClickListener(userInfo.this);
		exitsys.setOnClickListener(userInfo.this);
		modifyInfo.setOnClickListener(userInfo.this);
	}
	private void clickBack(){

		finish();
	}
	
	private void clickLogout(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);  //先得到构造器
        builder.setTitle("提示"); //设置标题
        builder.setMessage("是否确认退出?"); //设置内容
       // builder.setIcon(R.drawable.ic_launcher);//设置图标，图片id即可
        builder.setPositiveButton("确定", new DialogInterface.OnClickListener() { //设置确定按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss(); //关闭dialog
//                Toast.makeText(MineActivity.this, "确认" + which, Toast.LENGTH_SHORT).show();
                Intent i = new Intent();

				i.setClass(userInfo.this, LoginActivity.class);
				startActivity(i);
				
				MainActivity.A11.finish();
				finish();
               // finish();
            }
        });
        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() { //设置取消按钮
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
//                Toast.makeText(MineActivity.this, "取消" + which, Toast.LENGTH_SHORT).show();
            }
        });
        //参数都设置完成了，创建并显示出来
        builder.create().show();
    }
	private void clickModify(){
		Intent intent = new Intent();
		intent.setClass(userInfo.this, modifyInfoActivity.class);
		startActivity(intent);
		//finish();
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.BackToMain:
			clickBack();
			break;
		case R.id.Logout:
			clickLogout();
			break;
		case R.id.M_myActivity:
			clickModify();
			break;
		default:
			break;
		}
	}
	
	
	
}
