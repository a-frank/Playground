package com.arconsis.scala;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Comparison extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		findViewById(R.id.click_me).setOnClickListener(new OnClickListenerImplementation());
	}

	private final class OnClickListenerImplementation implements OnClickListener {
		@Override
		public void onClick(View v) {
			Builder builder = new AlertDialog.Builder(Comparison.this);
			builder.setTitle("The Java way");
			builder.setMessage("Hello Java!");
			builder.show();
		}
	}
}