package com.example.dormitorysystem;

import com.example.dormitorysystem.app.MyApplication;
import com.example.dormitorysystem.service.WebServiceGet;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class AnnounceActivity extends Activity implements OnClickListener{
	private ImageView back;
	private TextView content;
	private String A = "";
	
	private MyApplication app;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_announce);
		
		init();
	
		A = app.getAnnounce();
		
		
		content.setText(A);
		
	}
	private void init(){
		back = (ImageView) findViewById(R.id.BackToMain);
		content = (TextView) findViewById(R.id.details_2222);
		
		back.setOnClickListener(AnnounceActivity.this);
		
		app = (MyApplication) getApplication();
	}
	private void clickBack(){
//		Bundle bundle = new Bundle();
//		bundle.putInt("X", 1);
//		Intent intent = new Intent();
//		intent.putExtras(bundle);
//		intent.setClass(AnnounceActivity.this, MainActivity.class);
//		startActivity(intent);
		finish();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.BackToMain:
			clickBack();
			break;
		default:
			break;
		}
	}

}
