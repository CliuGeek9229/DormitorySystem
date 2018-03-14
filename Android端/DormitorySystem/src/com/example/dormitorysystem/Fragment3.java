package com.example.dormitorysystem;

import android.content.Intent;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment3 extends Fragment {
	private View view;
	
	private TextView safeAgreement;
	private TextView feedBack;
	private TextView aboutUs;
	
	
    @Override
    public View onCreateView(LayoutInflater inflater,
            ViewGroup container, Bundle savedInstanceState) {
    	view = inflater.inflate(R.layout.fragmentsetting, container,
				false);
    	
    	init();
    	
    	safeAgreement.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),safeActivity.class);
				startActivity(intent);
				//getActivity().finish();
			}
		});
    	feedBack.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),FeedbackActivity.class);
				startActivity(intent);
				//getActivity().finish();
			}
		});
    	aboutUs.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getActivity(),AboutUsActivity.class);
				startActivity(intent);
				//getActivity().finish();
			}
		});
    	
    	
    	
        return view;
    }
    
    private void init(){
    	safeAgreement = (TextView) view.findViewById(R.id.safeagreement);
    	feedBack = (TextView) view.findViewById(R.id.Feedback);
    	aboutUs = (TextView) view.findViewById(R.id.AboutUS);
    	
    }

}