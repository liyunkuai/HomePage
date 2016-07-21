package com.homepage.app.widget;

import java.util.Calendar;
import java.util.TimeZone;

import com.homepage.app.R;
import com.homepage.app.TheApp;
import com.homepage.app.handle.UpDataHomepageUI;
import com.homepage.app.utils.LogCatUtils;

import android.os.Handler;
import android.os.Looper;

public class getDataForUI {
	private  String mYear;  
    private  String mMonth;  
    private  String mDay;  
    private  String mWay;
    private  String mHour;
    private  String mMinute;
    private  String []dataString;
    private  int mSecond=0;
    private  boolean isFirstRun=true;
    private final int[]mWeekList={
			R.string.sunday,R.string.monday,R.string.tuesday,R.string.wednesday,
			R.string.thursday,R.string.friday,R.string.saturday
	};
    public getDataForUI() {
 
    	dataString=new String[2];
	}
    public String[] StringData(){  
        final Calendar c = Calendar.getInstance();  
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));  
        mYear = String.valueOf(c.get(Calendar.YEAR)); 
        mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);
        mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));
        mHour =String.valueOf(c.get(Calendar.HOUR_OF_DAY));
        mMinute =String.valueOf(c.get(Calendar.MINUTE));
        mSecond=c.get(Calendar.SECOND);
        LogCatUtils.showString("======mSecond==="+mSecond);
        mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));  
        if("1".equals(mWay)){  
            mWay =TheApp.mApp.getString(mWeekList[0]);
        }else if("2".equals(mWay)){  
        	mWay =TheApp.mApp.getString(mWeekList[1]);  
        }else if("3".equals(mWay)){  
        	mWay =TheApp.mApp.getString(mWeekList[2]);  
        }else if("4".equals(mWay)){  
        	mWay =TheApp.mApp.getString(mWeekList[3]);  
        }else if("5".equals(mWay)){  
        	mWay =TheApp.mApp.getString(mWeekList[4]); 
        }else if("6".equals(mWay)){  
        	mWay =TheApp.mApp.getString(mWeekList[5]); 
        }else if("7".equals(mWay)){  
        	mWay =TheApp.mApp.getString(mWeekList[6]); 
        }  
        
        dataString[0]="  "+mMonth+"/"+mDay+mWay;
        if (Integer.valueOf(mHour)<10) {
			mHour="0"+mHour;
		}
        if (Integer.valueOf(mMinute)<10) {
			mMinute="0"+mMinute;
		}
        dataString[1]=mHour+mMinute;
        if (mSecond!=0) {
        	handler.sendEmptyMessageDelayed(0, (60-mSecond)*1000);
        	
        	LogCatUtils.showString("isFirstRun========="+isFirstRun);
			isFirstRun=false;
		}
        return dataString;  
    }
    private Handler handler=new Handler(Looper.getMainLooper()){
    	public void handleMessage(android.os.Message msg) {
    		LogCatUtils.showString("==============");
    		UpDataHomepageUI.getInstance().RunTask();
    	};
    };
    
}
