package com.example.example;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivtyTwo extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
 		super.onCreate(savedInstanceState);
 		setContentView(R.layout.activity_two);
 		Bundle extras = getIntent().getExtras();
 		if(extras != null){
 			TextView text = (TextView) findViewById(R.id.text);
 			text.setText(extras.getString("param"));
 		}
	}
}
