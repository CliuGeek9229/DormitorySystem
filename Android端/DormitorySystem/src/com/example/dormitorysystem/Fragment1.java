package com.example.dormitorysystem;

import com.example.dormitorysystem.LoginActivity.MyThread;
import com.example.dormitorysystem.app.MyApplication;
import com.example.dormitorysystem.entity.user;
import com.example.dormitorysystem.json.JsonTools;
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

public class Fragment1 extends Fragment {
	private View view;
	
	private ProgressDialog dialog;
	// 返回的数据
	private String info;
	// 返回主线程更新数据
	private static Handler handler = new Handler();
	
	private MyApplication app;
		
	private TextView announce;
	private TextView tip;
	private TextView oldexchange;
	private TextView callfix;
	private TextView callstay;
	private TextView lost;
	private TextView bedexchange;
    @Override
    public View onCreateView(LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
    	view = inflater.inflate(R.layout.fragmentmanage, container,
				false);
    	
    	init();
    	announce.setOnClickListener(new OnClickListener() {
			
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
    	tip.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),TipsActivity.class);
				startActivity(intent);
				//getActivity().finish();
			}
		});
    	oldexchange.setOnClickListener(new OnClickListener() {
			
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
    	callfix.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),CallForFix.class);
				startActivity(intent);
				//getActivity().finish();
			}
		});
    	callstay.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),CallForStayActivity.class);
				startActivity(intent);
				//getActivity().finish();
			}
		});
    	lost.setOnClickListener(new OnClickListener() {
			
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
    	bedexchange.setOnClickListener(new OnClickListener() {
			
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
    	
    	
    	
        return view;
    }
    
 // 子线程接收数据，主线程修改数据
  	public class MyThread implements Runnable {
  		@Override
  		public void run() {
  			info = WebServiceGet.executeGetAnnounce("GetAnnounceLet");
  			Log.e("GetAnnounce!!!!!!!!!!!!!!", info);
  			
  			handler.post(new Runnable() {
  				@Override
  				public void run() {
  					// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
  					//infotv.setText(info);
  					
  					
  					dialog.dismiss();
  					app.setAnnounce(info);
  					
  					
  					if(!(info.equals("服务器连接超时..."))){
  	 					
  						Intent intent = new Intent(getActivity(),AnnounceActivity.class);
  						startActivity(intent);
  					}
  					else if(info.equals("No")){
  						Toast toast = Toast.makeText(getActivity(), "尚无公告信息", Toast.LENGTH_SHORT);
  	 					toast.setGravity(Gravity.CENTER, 0, 0);
  	 					toast.show();
  					}
  				}
  			});
  		}
  	}
     
 // 子线程接收数据，主线程修改数据
   	public class MyThread1 implements Runnable {
   		@Override
   		public void run() {
   			info = WebServiceGet.executeGetOld("getOldIfoLet");
   			Log.e("GetOld!!!!!!!!!!!!!!", info);
   			
   			handler.post(new Runnable() {
   				@Override
   				public void run() {
   					// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
   					//infotv.setText(info);
   					
   					
   					dialog.dismiss();
   					app.setTradeInfo(info);
   					
   					
   					if(!(info.equals("服务器连接超时..."))){
   	 					
   						Intent intent = new Intent(getActivity(),OldThingActivity.class);
   						startActivity(intent);
   					}
   					else if(info.equals("No")){
   						Toast toast = Toast.makeText(getActivity(), "尚无交易信息", Toast.LENGTH_SHORT);
   	 					toast.setGravity(Gravity.CENTER, 0, 0);
   	 					toast.show();
   					}
   				}
   			});
   		}
   	}
   	
 // 子线程接收数据，主线程修改数据
   	public class MyThread2 implements Runnable {
   		@Override
   		public void run() {
   			info = WebServiceGet.executeGetOld("GetRoomLet");
   			Log.e("GetRoom!!!!!!!!!!!!!!", info);
   			
   			handler.post(new Runnable() {
   				@Override
   				public void run() {
   					// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
   					//infotv.setText(info);
   					
   					
   					dialog.dismiss();
   					app.setRoomForExange(info);
   					
   					
   					if(!(info.equals("服务器连接超时..."))){
   	 					
   						Intent intent = new Intent(getActivity(),CallExchangeActivity.class);
   						startActivity(intent);
   					}
   					else if(info.equals("No")){
   						Toast toast = Toast.makeText(getActivity(), "尚无交易信息", Toast.LENGTH_SHORT);
   	 					toast.setGravity(Gravity.CENTER, 0, 0);
   	 					toast.show();
   					}
   				}
   			});
   		}
   	}
   	
 // 子线程接收数据，主线程修改数据
   	public class MyThread3 implements Runnable {
   		@Override
   		public void run() {
   			info = WebServiceGet.executeGetLost("GetLostInfoLet");
   			Log.e("GetLostInfo!!!!!!!!!!!!!!", info);
   			
   			handler.post(new Runnable() {
   				@Override
   				public void run() {
   					// 最好返回一个固定键值，根据键值判断是否登陆成功，有键值就保存该info跳转，没键值就是错误信息直接toast
   					//infotv.setText(info);
   					
   					
   					dialog.dismiss();
   					app.setLostInfo(info);
   					
   					
   					if(!(info.equals("服务器连接超时..."))){
   	 					
   						Intent intent = new Intent(getActivity(),CalllostActivity.class);
   						startActivity(intent);
   					}
   					else if(info.equals("No")){
   						Toast toast = Toast.makeText(getActivity(), "尚无物品丢失信息", Toast.LENGTH_SHORT);
   	 					toast.setGravity(Gravity.CENTER, 0, 0);
   	 					toast.show();
   					}
   				}
   			});
   		}
   	}
    
    private void init(){
    	announce = (TextView) view.findViewById(R.id.Announce);
    	tip = (TextView) view.findViewById(R.id.tips);
    	oldexchange = (TextView) view.findViewById(R.id.oldforExchange);
    	callfix = (TextView) view.findViewById(R.id.callforFix);
    	callstay = (TextView) view.findViewById(R.id.callforStayschool);
    	lost = (TextView) view.findViewById(R.id.Signforlost);
    	bedexchange = (TextView) view.findViewById(R.id.CallforExchange);
    	
    	app = (MyApplication) getActivity().getApplication();
    	
    }
    

}