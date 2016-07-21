package com.homepage.app.handle;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import com.homepage.app.R;
import com.homepage.app.TheApp;
import com.homepage.app.fragment.HomePageFragment;
import com.homepage.app.utils.ConstantHandle;
import com.homepage.app.utils.LogCatUtils;
import com.homepage.app.widget.HomePageDataTimeLayout;
import com.homepage.app.widget.getDataForUI;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.TextView;

public class UpDataHomepageUI extends RunTimeFactory{
	
	private static UpDataHomepageUI ui;
	private Timer timer;
	private MyTimerTask task;
	private View mView;
	public TextView mCity;
	public TextView mTextime;
	public TextView mData;
	private getDataForUI getDataForUI;
	
	public UpDataHomepageUI() {
	
	}
	public static UpDataHomepageUI getInstance(){
		if (ui==null) {
			synchronized (UpDataHomepageUI.class) {
				if (ui==null) {
					ui=new UpDataHomepageUI();
				}
			}
		}
		return ui;
	}
	@Override
	public void RunTask() {
		if (task!=null) {
			task.cancel();
			task=null;
		}
		task=new MyTimerTask();
		timer=new Timer(UpDataHomepageUI.class.toString());
		timer.scheduleAtFixedRate(task, 0, 60*1000);
	}

	@Override
	public void stopTimer() {
		LogCatUtils.showString("===stopTimer");
		if (task!=null) {
			task.cancel();
			task=null;
		}
		
	}
	private String[] data;
	class MyTimerTask extends TimerTask{

		@Override
		public void run() {
			if (getDataForUI==null) {
				getDataForUI=new getDataForUI();
			}
			data=getDataForUI.StringData();
			Message message=Message.obtain();
			message.what=ConstantHandle.HOME_PAGE_UPDATA_UI;
			message.obj=data;
			if (HomePageDataTimeLayout.layout==null||HomePageDataTimeLayout.layout.handler==null) {
				return;
			}
			HomePageDataTimeLayout.layout.handler.removeMessages(ConstantHandle.HOME_PAGE_UPDATA_UI);
			HomePageDataTimeLayout.layout.handler.sendMessage(message);
			}
		}
	 
	
}
