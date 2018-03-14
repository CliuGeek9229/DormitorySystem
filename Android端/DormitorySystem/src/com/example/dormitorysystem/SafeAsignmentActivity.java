package com.example.dormitorysystem;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class SafeAsignmentActivity extends Activity implements OnClickListener{
	private ImageView back;
	private TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_safesignment);
        
        init();
        tv1.setText(R.string.safeAsignment);
		
	}
	private void init(){
		back = (ImageView) findViewById(R.id.BackToMain);
		tv1 = (TextView) findViewById(R.id.details_2222);
		
		back.setOnClickListener(SafeAsignmentActivity.this);
	}
	private void clickBack(){
//		Bundle bundle = new Bundle();
//		bundle.putInt("X", 2);
//		Intent intent = new Intent();
//		intent.putExtras(bundle);
//		intent.setClass(userInfo.this, MainActivity.class);
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
