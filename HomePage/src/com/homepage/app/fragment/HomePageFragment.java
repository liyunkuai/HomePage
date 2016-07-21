package com.homepage.app.fragment;

import com.homepage.app.R;
import com.homepage.app.handle.UpDataHomepageUI;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class HomePageFragment extends Fragment{
	public View mView;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mView=inflater.inflate(R.layout.home_page, container, false);
		return mView;
	}
	@Override
	public void onResume() {
		super.onResume();
		UpDataHomepageUI.getInstance().RunTask();
	}
	@Override
	public void onDestroy() {
		super.onDestroy();
		UpDataHomepageUI.getInstance().stopTimer();
	}
	
}
