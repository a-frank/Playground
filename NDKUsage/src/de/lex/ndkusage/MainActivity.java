package de.lex.ndkusage;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private EditText _z1;
	private EditText _z2;
	private TextView _result;
	static{
		System.loadLibrary("hello");
	}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        _z1 = (EditText) findViewById(R.id.z1);
        _z2 = (EditText) findViewById(R.id.z2);
        _result = (TextView) findViewById(R.id.result);
        
        Button click = (Button) findViewById(R.id.click);
        click.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				helloLog("Will call calculation native!!");
				int z1 = Integer.parseInt(_z1.getText().toString());
				int z2 = Integer.parseInt(_z2.getText().toString());
				_result.setText(getString(z1, z2));
			}

		});
    }
    
    private native void helloLog(String string);
    private native String getString(int z1, int z2);
}
