package com.example.dormitorysystem;



import com.example.dormitorysystem.Fragment1.MyThread;
import com.example.dormitorysystem.app.MyApplication;
import com.example.dormitorysystem.service.WebServiceGet;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Fragment2 extends Fragment{
	private View view;
	
	private ProgressDialog dialog;
	// 返回的数据
	private String info;
	// 返回主线程更新数据
	private static Handler handler = new Handler();
	
	private MyApplication app;

	private TextView personInfo;
	private TextView signlate;
	private TextView mycallfix;
	private TextView mycallstay;
	private TextView mycalllost;
	private TextView mycallexchange;
	
	
    @Override
    public View onCreateView(LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
    	view = inflater.inflate(R.layout.fragmentme, container,
				false);
    	
    	initme();
    	
    	personInfo.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),userInfo.class);
				startActivity(intent);
				//getActivity().finish();
			}
		});
    	signlate.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),SignlateActivity.class);
				startActivity(intent);
				//getActivity().finish();
			}
		});
    	mycallfix.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog = new ProgressDialog(getActivity());
				dialog.setTitle("提示");
				dialog.setMessage("正在提取信息，请稍后...");
				dialog.setCancelable(false);
				dialog.show();
				
				// 创建子线程，分别进行Get和Post传输
				new Thread(new MyThread()).start();
			}
		});
    	mycallstay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog = new ProgressDialog(getActivity());
				dialog.setTitle("提示");
				dialog.setMessage("正在提取信息，请稍后...");
				dialog.setCancelable(false);
				dialog.show();
				
				// 创建子线程，分别进行Get和Post传输
				new Thread(new MyThread1()).start();
			}
		});
    	mycalllost.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog = new ProgressDialog(getActivity());
				dialog.setTitle("提示");
				dialog.setMessage("正在提取信息，请稍后...");
				dialog.setCancelable(false);
				dialog.show();
				
				// 创建子线程，分别进行Get和Post传输
				new Thread(new MyThread2()).start();
			}
		});
    	mycallexchange.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				dialog = new ProgressDialog(getActivity());
				dialog.setTitle("提示");
				dialog.setMessage("正在提取信息，请稍后...");
				dialog.setCancelable(false);
				dialog.show();
				
				// 创建子线程，分别进行Get和Post传输
				new Thread(new MyThread3()).start();
			}
		});
    	
    	
        return view;
    }
 // 子线程接收数据，主线程修改数据
   	public class MyThread implements Runnable {
   		@Override
   		public void run() {
   			info = WebServiceGet.executeGetMyFix("GetMyfixLet",app.getStuID());
   			Log.e("GetMyfix!!!!!!!!!!!!!!", info);
   			
   			handler.post(new Runnable() {
   				@Override
   				public void run() {
   					// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
   					//infotv.setText(info);
   					
   					
   					dialog.dismiss();
   					app.setMyFixInfo(info);
   					
   					
   					if(!(info.equals("服务器连接超时..."))){
   	 					
   						Intent intent = new Intent(getActivity(),MycallfixActivity.class);
   						startActivity(intent);
   					}
   					else if(info.equals("No")){
   						Toast toast = Toast.makeText(getActivity(), "尚无报修记录", Toast.LENGTH_SHORT);
   	 					toast.setGravity(Gravity.CENTER, 0, 0);
   	 					toast.show();
   					}
   				}
   			});
   		}
   	}
	public class MyThread1 implements Runnable {
   		@Override
   		public void run() {
   			info = WebServiceGet.executeGetMyApply("GetMyapplyLet",app.getStuID());
   			Log.e("GetMyapply!!!!!!!!!!!!!!", info);
   			
   			handler.post(new Runnable() {
   				@Override
   				public void run() {
   					// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
   					//infotv.setText(info);
   					
   					
   					dialog.dismiss();
   					app.setMyStayInfo(info);
   					
   					
   					if(!(info.equals("服务器连接超时..."))){
   	 					
   						Intent intent = new Intent(getActivity(),MycallstayActivity.class);
   						startActivity(intent);
   					}
   					else if(info.equals("No")){
   						Toast toast = Toast.makeText(getActivity(), "尚无报修记录", Toast.LENGTH_SHORT);
   	 					toast.setGravity(Gravity.CENTER, 0, 0);
   	 					toast.show();
   					}
   				}
   			});
   		}
   	}
	public class MyThread2 implements Runnable {
   		@Override
   		public void run() {
   			info = WebServiceGet.executeGetMyLost("GetMylostLet",app.getStuID());
   			Log.e("GetMylost!!!!!!!!!!!!!!", info);
   			
   			handler.post(new Runnable() {
   				@Override
   				public void run() {
   					// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
   					//infotv.setText(info);
   					
   					
   					dialog.dismiss();
   					app.setMyLostInfo(info);
   					
   					
   					if(!(info.equals("服务器连接超时..."))){
   	 					
   						Intent intent = new Intent(getActivity(),MycallostActivity.class);
   						startActivity(intent);
   					}
   					else if(info.equals("No")){
   						Toast toast = Toast.makeText(getActivity(), "尚无报修记录", Toast.LENGTH_SHORT);
   	 					toast.setGravity(Gravity.CENTER, 0, 0);
   	 					toast.show();
   					}
   				}
   			});
   		}
   	}
	public class MyThread3 implements Runnable {
   		@Override
   		public void run() {
   			info = WebServiceGet.executeGetMyExchange("GetMyexchangeLet",app.getStuID());
   			Log.e("GetMyexchange!!!!!!!!!!!!!!", info);
   			
   			handler.post(new Runnable() {
   				@Override
   				public void run() {
   					// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
   					//infotv.setText(info);
   					
   					
   					dialog.dismiss();
   					app.setMyExchangeInfo(info);
   					
   					
   					if(!(info.equals("服务器连接超时..."))){
   	 					
   						Intent intent = new Intent(getActivity(),MycallExchange.class);
   						startActivity(intent);
   					}
   					else if(info.equals("No")){
   						Toast toast = Toast.makeText(getActivity(), "尚无报修记录", Toast.LENGTH_SHORT);
   	 					toast.setGravity(Gravity.CENTER, 0, 0);
   	 					toast.show();
   					}
   				}
   			});
   		}
   	}
    
    
   
    private void initme(){
		personInfo = (TextView) view.findViewById(R.id.personal_info);
		signlate = (TextView) view.findViewById(R.id.signForlate);
		mycallfix = (TextView) view.findViewById(R.id.MyCallforFix);
		mycallstay = (TextView) view.findViewById(R.id.MyCallforstayschool);
		mycalllost = (TextView) view.findViewById(R.id.MySignforlost);
		mycallexchange = (TextView) view.findViewById(R.id.MyCallforExchange);
		
		app = (MyApplication) getActivity().getApplication();
	}

}