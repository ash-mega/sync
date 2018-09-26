package com.example.aw.sync;

import android.content.ContentResolver;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {
	
	private TextView msg;
	
	private boolean switcher;
	
	private MediaObserver mediaObserver;
	
	private Handler handler;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		msg = findViewById(R.id.tv_msg);
		
		ContentResolver resolver = getContentResolver();
		handler = new Handler();
		mediaObserver = new MediaObserver(handler);
		resolver.registerContentObserver(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,false,mediaObserver);
	}
	
	public void sync(View view) {
		Intent intent = new Intent(this,SyncService.class);
		if (switcher) {
			stopService(intent);
		} else {
			startService(intent);
		}
		
		switcher = !switcher;
	}
	
	public void clear(View view) {
		msg.setText("");
	}
	
	public void output(Object any) {
		msg.setText(Util.toString(any));
	}
}
