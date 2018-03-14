package com.example.dormitorysystem;

import com.example.dormitorysystem.app.MyApplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MycallfixActivity extends Activity implements OnClickListener{
	private ImageView back;
	
	private TextView record;
	
	private MyApplication app;
	
	//private ListView M_action;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_mycallfix);
        
        init();
        
        record.setText(app.getMyFixInfo());
        
        //number.setText(M_action.getCount());
	}
	private void init(){
		back = (ImageView) findViewById(R.id.BackToMain);
		record = (TextView) findViewById(R.id.details_2222);
		app = (MyApplication) getApplication();
		
		
		back.setOnClickListener(MycallfixActivity.this);
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
