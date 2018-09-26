package com.example.aw.sync;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;

public class MediaObserver extends ContentObserver {
	
	public MediaObserver(Handler handler) {
		super(handler);
	}
	
	@Override
	public void onChange(boolean selfChange) {
		super.onChange(selfChange);
		Util.log(this,"onChange: selfChange=" + selfChange);
	}
	
	@Override
	public void onChange(boolean selfChange,Uri uri) {
		super.onChange(selfChange,uri);
		Util.log(this,"onChange: uri=" + uri);
	}
}
