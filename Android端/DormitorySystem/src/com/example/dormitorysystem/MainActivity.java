package com.example.dormitorysystem;



import com.example.dormitorysystem.app.MyApplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class MainActivity extends FragmentActivity implements OnClickListener {
	static Activity A11;
	private MyApplication app;
	
	
	private int X = 2;

	// 三个tab布局
	private RelativeLayout knowLayout, iWantKnowLayout, meLayout;

	// 底部标签切换的Fragment
	private Fragment knowFragment, iWantKnowFragment, meFragment,
			currentFragment;
	// 底部标签图片
	private ImageView knowImg, iWantKnowImg, meImg;
	// 底部标签的文本
	private TextView knowTv, iWantKnowTv, meTv;
	
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);

		initUI();
		initTab();
		
		A11 = this;
		
		X=getIntent().getIntExtra("X", 2);
		if(X == 1)
			clickTab1Layout();
		else if(X == 2)
			clickTab2Layout();
		else if(X == 3)
			clickTab3Layout();
		
			
		
	}
	
	

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		
		
		
		X=app.getPagenum();
		if(X == 1)
			clickTab1Layout();
		else if(X == 2)
			clickTab2Layout();
		else if(X == 3)
			clickTab3Layout();
	}



	/**
	 * 初始化UI
	 */
	private void initUI() {
		app = (MyApplication) getApplication();
		X = app.getPagenum();
		
		
		knowLayout = (RelativeLayout) findViewById(R.id.rl_know);
		iWantKnowLayout = (RelativeLayout) findViewById(R.id.rl_want_know);
		meLayout = (RelativeLayout) findViewById(R.id.rl_me);
		knowLayout.setOnClickListener(this);
		iWantKnowLayout.setOnClickListener(this);
		meLayout.setOnClickListener(this);

		knowImg = (ImageView) findViewById(R.id.iv_know);
		iWantKnowImg = (ImageView) findViewById(R.id.iv_i_want_know);
		meImg = (ImageView) findViewById(R.id.iv_me);
		knowTv = (TextView) findViewById(R.id.tv_know);
		iWantKnowTv = (TextView) findViewById(R.id.tv_i_want_know);
		meTv = (TextView) findViewById(R.id.tv_me);

		
	}

	/**
	 * 初始化底部标签
	 */
	private void initTab() {
		if (knowFragment == null) {
			knowFragment = new Fragment1();
		}

		if (!knowFragment.isAdded()) {
			// 提交事务
			getSupportFragmentManager().beginTransaction()
					.add(R.id.content_layout, knowFragment).commit();

			// 记录当前Fragment
			currentFragment = knowFragment;
			// 设置图片文本的变化
			knowImg.setImageResource(R.drawable.other_pre);
			knowTv.setTextColor(getResources()
					.getColor(R.color.bottomtab_press));
			iWantKnowImg.setImageResource(R.drawable.me_nor);
			iWantKnowTv.setTextColor(getResources().getColor(
					R.color.bottomtab_normal));
			meImg.setImageResource(R.drawable.setting_nor);
			meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

		}

	}
	

	@Override
	public void onClick(View view) {
		switch (view.getId()) {
		case R.id.rl_know: // 管理
			app.setPagenum(1);
			clickTab1Layout();
			break;
		case R.id.rl_want_know: // 设置
			app.setPagenum(2);
			clickTab2Layout();
			break;
		case R.id.rl_me: // 我的
			app.setPagenum(3);
			clickTab3Layout();
			break;
		
		default:
			break;
		}
	}
	

	/**
	 * 点击第一个tab
	 */
	private void clickTab1Layout() {
		if (knowFragment == null) {
			knowFragment = new Fragment1();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(), knowFragment);
		//app.setPagenum(1);
		
		// 设置底部tab变化
		knowImg.setImageResource(R.drawable.other_pre);
		knowTv.setTextColor(getResources().getColor(R.color.bottomtab_press));
		iWantKnowImg.setImageResource(R.drawable.me_nor);
		iWantKnowTv.setTextColor(getResources().getColor(
				R.color.bottomtab_normal));
		meImg.setImageResource(R.drawable.setting_nor);
		meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
	}

	/**
	 * 点击第二个tab
	 */
	private void clickTab2Layout() {
		if (iWantKnowFragment == null) {
			iWantKnowFragment = new Fragment2();
		}
		addOrShowFragment(getSupportFragmentManager().beginTransaction(), iWantKnowFragment);
		
		//app.setPagenum(2);
		
		knowImg.setImageResource(R.drawable.other_nor);
		knowTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
		iWantKnowImg.setImageResource(R.drawable.me_pre);
		iWantKnowTv.setTextColor(getResources().getColor(
				R.color.bottomtab_press));
		meImg.setImageResource(R.drawable.setting_nor);
		meTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));

	}

	/**
	 * 点击第三个tab
	 */
	private void clickTab3Layout() {
		if (meFragment == null) {
			meFragment = new Fragment3();
		}
		
		addOrShowFragment(getSupportFragmentManager().beginTransaction(), meFragment);
		
		//app.setPagenum(3);
		
		knowImg.setImageResource(R.drawable.other_nor);
		knowTv.setTextColor(getResources().getColor(R.color.bottomtab_normal));
		iWantKnowImg.setImageResource(R.drawable.me_nor);
		iWantKnowTv.setTextColor(getResources().getColor(
				R.color.bottomtab_normal));
		meImg.setImageResource(R.drawable.setting_pre);
		meTv.setTextColor(getResources().getColor(R.color.bottomtab_press));
		
	}

	/**
	 * 添加或者显示碎片
	 * 
	 * @param transaction
	 * @param fragment
	 */
	private void addOrShowFragment(FragmentTransaction transaction,
			Fragment fragment) {
		if (currentFragment == fragment)
			return;

		if (!fragment.isAdded()) { // 如果当前fragment未被添加，则添加到Fragment管理器中
			transaction.hide(currentFragment)
					.add(R.id.content_layout, fragment).commit();
		} else {
			transaction.hide(currentFragment).show(fragment).commit();
		}

		currentFragment = fragment;
	}

}
