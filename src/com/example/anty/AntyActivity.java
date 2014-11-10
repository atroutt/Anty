package com.example.anty;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class AntyActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Log.d("tapTest", "Activity created");
	}

	@Override
	protected void onStart() {
		super.onStart();

		Log.d("tapTest", "Activity started");
	}

	@Override
	protected void onStop() {
		super.onStop();

		Log.d("tapTest", "Activity stopped");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		Log.d("tapTest", "Activity destroyed");
	}
}
