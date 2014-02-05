package com.example.example;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener{

	private static final String LOG_TAG = MainActivity.class.getSimpleName();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.d(LOG_TAG, "onCreate");
		findViewById(R.id.action).setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.d(LOG_TAG, "onResume");
		Toast.makeText(this, "on ResumeToast", Toast.LENGTH_LONG).show();
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.d(LOG_TAG, "onStop");
	}
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d(LOG_TAG, "onDestroy");
	}

	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.action){
			Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show();
			Intent intent = new Intent(this, ActivtyTwo.class);
			intent.putExtra("param", "Hello from activty one");
			startActivity(intent);
		}
	}

}
