package com.homepage.app.widget;

import com.homepage.app.R;
import com.homepage.app.TheApp;
import com.homepage.app.utils.LogCatUtils;
import com.homepage.app.utils.StartActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class HomeBottonNavigationFirst extends LinearLayout{
	
	public HomeBottonNavigationFirst(Context context) {
		super(context);
		
		clickListener=new MyClickListener();
		initData(context);
	}
	LinearLayout.LayoutParams params ;
	LinearLayout mLayout;
	public MyClickListener clickListener;
	android.view.ViewGroup.LayoutParams layoutParams;
	int []suoceid={R.drawable.map_icon,R.drawable.radio_icon,R.drawable.music_icon
			,R.drawable.telephone_icon,R.drawable.air_icon,R.drawable.tire_icon};
	int []nameID={R.string.str_map,R.string.str_radio,R.string.str_music,R.string.str_tele
			,R.string.str_air,R.string.str_tire};
	/*public HomeBottonNavigation(Context context, AttributeSet attrs) {
		super(context, attrs);
		clickListener=new MyClickListener();
		initData(context);
		
	}*/

	public void initData(Context context){
		
		for(int i=0;i<6;i++){
			mLayout=new LinearLayout(context);
			mLayout.setGravity(Gravity.CENTER);
			params=new LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,120);
			params.weight=1;
			mLayout.setOrientation(LinearLayout.VERTICAL);
			mLayout.setLayoutParams(params);
			ImageButton button=new ImageButton(context);
			button.setLayoutParams(new LayoutParams(95, 95));
			button.setId(0x00+i);
			button.setOnClickListener(clickListener);
			button.setBackgroundResource(suoceid[i]);
			TextView name=new TextView(TheApp.mApp);
			name.setGravity(Gravity.CENTER);
			name.setText(nameID[i]);
			name.setTextSize(20);
			mLayout.addView(button);
			mLayout.addView(name);
			addView(mLayout);
		}
		
	}
	class MyClickListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			
			LogCatUtils.showString("======get OnClickListener id is =="+v.getId());
			switch (v.getId()) {
			
			case 0x00:
				StartActivity.startAcitivity("com.syu.dvr");
				break;
				
			case 0x01:
				
				break;
				
			case 0x02:
					
				break;
			case 0x03:
		
				break;
			case 0x04:
	
				break;
			case 0x05:
				
				break;

			default:
				break;
			}
			
		}
	}
	
}
