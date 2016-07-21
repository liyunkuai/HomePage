package com.homepage.app.activity;

import java.util.ArrayList;
import java.util.List;

import com.homepage.app.R;
import com.homepage.app.fragment.HomePageFragment;
import com.homepage.app.fragment.RadioPageFragment;
import com.homepage.app.handle.UpDataHomepageUI;
import com.homepage.app.widget.HomeBottonNavigationFirst;
import com.homepage.app.widget.HomeBottonNavigationSecond;

import android.R.array;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MainActivity extends Activity {
	private ViewPager mViewPager;
	private List<LinearLayout>data;
	private LinearLayout mHomeLayoutFrist;
	private LinearLayout mHomeLayoutSecod;
	private View [] Views;
	private View mMainLayout;
	private LinearLayout mLayout;
	private int souceId=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		mMainLayout=this.getLayoutInflater().inflate(R.layout.activity_main, null);
		setContentView(mMainLayout);
		initVIew();
		setPageSelect(0);
		UpDataHomepageUI.getInstance().RunTask();
		
	}
	@Override
	protected void onResume() {
		super.onResume();
	}

	private void initVIew() {
		mViewPager=(ViewPager) findViewById(R.id.viewpager);
		data=new ArrayList<LinearLayout>();
		mHomeLayoutFrist=new HomeBottonNavigationFirst(this);
		mHomeLayoutSecod=new HomeBottonNavigationSecond(this);
		data.add(mHomeLayoutFrist);
		data.add(mHomeLayoutSecod);
		mViewPager.setAdapter(new MyPagerAdapter());
		mViewPager.setOnPageChangeListener(new MyOnPageChangeListener());
		mLayout=(LinearLayout) findViewById(R.id.limearlayout);
		initData();
	}
	private void initData() {
		int temp=data.size();
		Views=new View[temp];
		
	for (int i = 0; i < temp; i++) {
		
		View view=new View(this);
		Views[i]=view;
		LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(new ViewGroup.LayoutParams(18,18));
		params.rightMargin=5;
		params.leftMargin=5;
		mLayout.addView(view,params);
	}
	/*findViewById(R.id.left).setOnClickListener(new OnClickListener() {
		@Override
		public void onClick(View v) {
			if (getSouceId()==1) {
				
				setPageSelect(0);
			}
		}
	});
	findViewById(R.id.right).setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			if (getSouceId()==0) {
				
				setPageSelect(1);
			}
		}
	});*/

	}
	private void setPageSelect(int id){
		setSouceId(id);
		mViewPager.setCurrentItem(id);
		for(int i=0;i<Views.length;i++){
			if (id==i) {
				Views[i].setBackgroundResource(R.drawable.circular_p);
			}else {
				Views[i].setBackgroundResource(R.drawable.circular);
			}
		}
	}
	
	
	class MyOnPageChangeListener implements OnPageChangeListener{

		@Override
		public void onPageScrollStateChanged(int arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onPageSelected(int arg0) {
		
			setPageSelect(arg0);
		}

		
		
	}

	class MyPagerAdapter extends PagerAdapter{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return data.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			// TODO Auto-generated method stub
			return arg0==arg1;
		}
		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			// TODO Auto-generated method stub
			container.addView(data.get(position));
			return data.get(position);
		}
		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			// TODO Auto-generated method stub
			container.removeView(data.get(position));
		}
		
	}

	public int getSouceId() {
		return souceId;
	}

	public void setSouceId(int souceId) {
		this.souceId = souceId;
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
	}
	
}
