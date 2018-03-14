package com.example.dormitorysystem;

import com.example.dormitorysystem.app.MyApplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class MycallstayActivity extends Activity implements OnClickListener{
	private ImageView back;
	private TextView record;
	private MyApplication app;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mycallstay);
        init();
        record.setText(app.getMyStayInfo());
	}
	private void init(){
		back = (ImageView) findViewById(R.id.BackToMain);
		record = (TextView) findViewById(R.id.details_2222);
		app = (MyApplication) getApplication();
		
		back.setOnClickListener(MycallstayActivity.this);
	}
	
	private void backtoMain(){

		finish();
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.BackToMain:
			backtoMain();
			break;
		
		
		default:
				break;
				
		}
	}
	
	
}
