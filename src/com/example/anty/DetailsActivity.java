package com.example.anty;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class DetailsActivity extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_details);
		setupActionBar();

		Button button2 = (Button) findViewById(R.id.button2);
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Log.d("tapTest", "button 2 was tapped");
			}
		});

		// Button 3 is created in code
		LinearLayout linearLayout = (LinearLayout) findViewById(R.id.linear);
		Button button3 = new Button(this);
		button3.setText("Button 3");
		button3.setOnClickListener(new ButtonThreeListener());
		linearLayout.addView(button3);

		// Button 4 is created in code
		Button button4 = new Button(this);
		button4.setText("Button 4");
		button4.setOnClickListener(this);
		linearLayout.addView(button4);
	}

	private void setupActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.details, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void button1Tap(View v) {
		Log.d("tapTest", "button 1 was tapped");
	}

	@Override
	public void onClick(View v) {
		Log.d("tapTest", "button 4 was tapped");
	}

	// Example of inner class button listener
	private class ButtonThreeListener implements View.OnClickListener {

		@Override
		public void onClick(View v) {
			Log.d("tapTest", "button 3 was tapped");
		}
	}
}
