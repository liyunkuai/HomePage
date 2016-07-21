package com.homepage.app;

import android.app.Application;

public class TheApp extends Application{
	public static TheApp mApp;
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		mApp=this;
	}

}
