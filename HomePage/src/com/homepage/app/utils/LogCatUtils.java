package com.homepage.app.utils;

import android.util.Log;

public class LogCatUtils {
	private static boolean IS_DEBUG=true;
	
	private static boolean TAG_DUBUG=true;
	
	private static boolean IS_WRITE=false;
	
	private static boolean IS_SCREEN=false;
	
	public static void showString(String msg){
		if (IS_DEBUG) {
				StackTraceElement mSte = new Exception().getStackTrace()[1];
				Log.i(mSte.getFileName(),"|line: " + mSte.getLineNumber() + " ---> " + msg);
				
				if (TAG_DUBUG) {
					
					Log.i("HomePage",mSte.getFileName()+"|line: " + mSte.getLineNumber() + " ---> " + msg);
					
//					LogPreview.show(mSte.getFileName()+"|line: " + mSte.getLineNumber() + " ---> " + msg);
				}
		}
		
	}
	public static void showInt(int value){
		if (IS_DEBUG) {
				StackTraceElement mSte = new Exception().getStackTrace()[1];
				Log.i(mSte.getFileName(),"|line:" + mSte.getLineNumber() + " ---> " + value);
				if (TAG_DUBUG) {
					
					Log.i("TAG",mSte.getFileName()+"|line:" + mSte.getLineNumber() + " ---> " + value);
//					LogPreview.show(mSte.getFileName()+"|line:" + mSte.getLineNumber() + " ---> " + value);
				}
		}
		
	}
	
	public static void showBoolean(boolean value){
		if (IS_DEBUG) {
				StackTraceElement mSte = new Exception().getStackTrace()[1];
				Log.i(mSte.getFileName(), "|line: " + mSte.getLineNumber() + " ---> " + value);
				
				if (TAG_DUBUG) {
					
					Log.i("TAG",mSte.getFileName()+"|line: " + mSte.getLineNumber() + " ---> " + value);
//					LogPreview.show(mSte.getFileName()+"|line: " + mSte.getLineNumber() + " ---> " + value);
				}
		}
		
	}
	public static void showException(Throwable ex){
		if (IS_DEBUG) {
				StackTraceElement[] mSte = ex.getStackTrace();
				StringBuffer sp=new StringBuffer();
				
				for (int i = 0; i < mSte.length; i++) {
					StackTraceElement element=mSte[i];
					sp.append(element.toString()+"\n");
				}
				if (TAG_DUBUG) {
					Log.e(mSte[0].getFileName(), "|line: " + mSte[0].getLineNumber() + " --->异常捕捉 =" +ex.getMessage());
					Log.e(mSte[0].getFileName(), "|line: " + mSte[0].getLineNumber() + " --->异常 详细信息=" +sp.toString());
					
					Log.i("TAG",mSte[0].getFileName()+"|line: " + mSte[0].getLineNumber() + " ---> " + sp.toString());
//					LogPreview.show(mSte[0].getFileName()+"|line: " + mSte[0].getLineNumber() + " --->异常捕捉 =" +ex.getMessage());
//					LogPreview.show(mSte[0].getFileName()+"|line: " + mSte[0].getLineNumber() + " --->异常 详细信息= " + sp.toString());
				}
				}
				
		
	}
	
}
