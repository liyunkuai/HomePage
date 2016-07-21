package com.homepage.app.widget;

import com.homepage.app.R;
import com.homepage.app.TheApp;
import com.homepage.app.R.layout;
import com.homepage.app.utils.ConstantHandle;
import com.homepage.app.utils.LogCatUtils;

import android.R.integer;
import android.content.Context;
import android.os.Handler;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HomePageDataTimeLayout extends LinearLayout {
	
	private LinearLayout mLayoutTime;
	private LinearLayout mLayoutWeather;
	private LinearLayout includLayout;
	private LayoutParams params;
	public static HomePageDataTimeLayout layout;
	
	private  View []mTimeView=new View [6];
	private TextView mTextView[]=new TextView[3];
	private int []bk={
			R.drawable.image0,R.drawable.image1,R.drawable.image2,R.drawable.image3,
			R.drawable.image4,R.drawable.image5,R.drawable.image6,R.drawable.image7,
			R.drawable.image8,R.drawable.image9
	};

	public HomePageDataTimeLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		layout=HomePageDataTimeLayout.this;
		includLayout=new LinearLayout(context);
		includLayout.setOrientation(LinearLayout.HORIZONTAL);
		includLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
		addView(getTimeLayout(context));
		addView(getDataAndCityLayout(context));
		
		
	}
	private LinearLayout getTimeLayout(Context context){
		includLayout.removeAllViews();
		mLayoutTime=new LinearLayout(context);
		mLayoutTime.setOrientation(LinearLayout.HORIZONTAL);
		params=new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		params.weight=39;
		mLayoutTime.setLayoutParams(params);
		mLayoutTime.setGravity(Gravity.CENTER);
		for(int i=0;i<5;i++){
			params=new LayoutParams(50, 67);
			ImageView mView=new ImageView(TheApp.mApp);
			mTimeView[i]=mView;
			mView.setBackgroundResource(R.drawable.image0);	
			if (i==2) {
				params=new LayoutParams(25, 67);
				mView.setBackgroundResource(R.drawable.circularnuber);
			}
			mView.setLayoutParams(params);
			mLayoutTime.addView(mView);
		}
		includLayout.addView(mLayoutTime);
		
		params=new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		mLayoutWeather=new LinearLayout(context);
		params.weight=65;
		mLayoutWeather.setGravity(Gravity.CENTER);
		mLayoutWeather.setLayoutParams(params);
		ImageView weather=new ImageView(context);
		weather.setBackgroundResource(R.drawable.music_icon);
		weather.setLayoutParams(new LayoutParams(50, 67));
		mLayoutWeather.addView(weather);
		mTimeView[5]=weather;
		includLayout.addView(mLayoutWeather);
		
		return includLayout;
	}
	
	private LinearLayout getDataAndCityLayout(Context context){
		includLayout=new LinearLayout(context);
		includLayout.setPadding(0, 10, 0, 0);
		includLayout.setOrientation(LinearLayout.HORIZONTAL);
		includLayout.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 40));
		mLayoutTime=new LinearLayout(context);
		mLayoutTime.setOrientation(LinearLayout.HORIZONTAL);
		mLayoutTime.setGravity(Gravity.CENTER);
		params=new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		params.weight=39;
		mLayoutTime.setLayoutParams(params);
		params=new LayoutParams(50, 67);
		for(int i=0;i<2;i++){
			TextView mView=new TextView(context);
			mTextView[i]=mView;
			mView.setTextSize(20);
			mView.setGravity(Gravity.CENTER);
			mView.setTextColor(context.getResources().getColor(R.color.white));
			params=new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
					RelativeLayout.LayoutParams.MATCH_PARENT);
			params.weight=1;
			mView.setLayoutParams(params);
			mLayoutTime.addView(mView);
		}
		includLayout.addView(mLayoutTime);
		
		params=new LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
				RelativeLayout.LayoutParams.MATCH_PARENT);
		mLayoutWeather=new LinearLayout(context);
		params.weight=65;
		mLayoutWeather.setGravity(Gravity.CENTER);
		mLayoutWeather.setLayoutParams(params);
		TextView weather=new TextView(context);
		weather.setTextSize(20);
		weather.setText("32~38");
		mTextView[2]=weather;
		weather.setTextColor(context.getResources().getColor(R.color.white));
		mLayoutWeather.addView(weather);
		includLayout.addView(mLayoutWeather);
		
		return includLayout;
	}
	
	public  Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			super.handleMessage(msg);
			switch (msg.what) {
			case ConstantHandle.HOME_PAGE_UPDATA_UI:
				String []data=(String[]) msg.obj;
				if (data==null||data.length<=0) {
					return;
				}
				if (data[1].isEmpty()||mTextView==null||mTextView.length==0) {
					return;
				}
				LogCatUtils.showString("===time==="+data[1]);
				int time=Integer.valueOf(data[1]);
				mTimeView[0].setBackgroundResource(bk[time/1000]);
				mTimeView[1].setBackgroundResource(bk[(time%1000)/100]);
				mTimeView[3].setBackgroundResource(bk[(time%100)/10]);
				mTimeView[4].setBackgroundResource(bk[(time%100)%10]);
				if (data[0].isEmpty()) {
					return;
				}
				mTextView[0].setText(data[0]);
				mTextView[1].setText("深圳市");
				break;

			default:
				break;
			}
			
		};
	};

}
