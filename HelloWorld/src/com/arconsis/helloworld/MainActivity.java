package com.arconsis.helloworld;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private Button sayHello;
	private EditText name;
	private TextView output;
	private EditText count;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		name = (EditText) findViewById(R.id.name);
		count = (EditText) findViewById(R.id.count);
		output = (TextView) findViewById(R.id.output);
		sayHello = (Button) findViewById(R.id.say_hello);
		sayHello.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String enteredName = name.getText().toString();
				output.setText("");
				String enteredCount = count.getText().toString();
				int countAsInt = Integer.parseInt(enteredCount);
				for(int i = 0; i < countAsInt; i++){
					output.append("Hello " + enteredName);
					output.append("\n");
				}
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
