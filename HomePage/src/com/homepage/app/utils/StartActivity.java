package com.homepage.app.utils;

import com.homepage.app.TheApp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class StartActivity {
	
	public static Context context;
	private static PackageManager manager;
	
	static{
		context=TheApp.mApp;
		manager=context.getPackageManager();
		
	}
	
	public static void startAcitivity(Class<?extends Activity>target){
		Intent intent =new Intent(context, target);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
//		overridePendingTransition(R.anim.slide_bottom_in,R.anim.scale_out);
	}
	public static void startAcitivity(Class<?extends Activity>target,Bundle data){
		Intent intent =new Intent(context, target);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		intent.putExtra("TimeData", data);
		context.startActivity(intent);

	}
	public static void startAcitivity(String apkpackage){
		Intent intent=manager.getLaunchIntentForPackage(apkpackage);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
	}
}
