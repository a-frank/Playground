package com.arconsis.chromecast;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class CastExample extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cast_example);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cast_example, menu);
		return true;
	}

}
