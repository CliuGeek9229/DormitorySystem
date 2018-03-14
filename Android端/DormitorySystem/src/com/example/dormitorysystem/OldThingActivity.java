package com.example.dormitorysystem;

import com.example.dormitorysystem.app.MyApplication;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;

import android.widget.ListView;
import android.widget.TextView;

import android.widget.ImageView;

public class OldThingActivity extends Activity implements OnClickListener{
	private ImageView back;
	private TextView number;
	private String A = "";
	private MyApplication app;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_oldthing);
        
        init();
		
		A = app.getTradeInfo();
		
		number.setText(A);
	}
	private void init(){
		back = (ImageView) findViewById(R.id.BackToMain);
		number = (TextView) findViewById(R.id.details_2222);
		
		app = (MyApplication) getApplication();
		
		back.setOnClickListener(OldThingActivity.this);
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
