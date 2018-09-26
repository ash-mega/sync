package com.example.aw.sync;

import android.util.Log;

public class Util {
	
	public static String toString(Object any) {
		return (any == null) ? "NULL" : any.toString();
	}
	
	public static void log(Object context,Object any) {
		String msg = context.getClass().getSimpleName() + "--->" + toString(any);
		Log.e("@#@",msg);
	}
}
