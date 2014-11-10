package com.example.anty;

import android.app.Application;
import android.util.Log;

public class AntyApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		Log.d("tapTest", "Application is started");
	}

}
