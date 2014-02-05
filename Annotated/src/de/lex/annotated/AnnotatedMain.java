package de.lex.annotated;

import android.app.Activity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.googlecode.androidannotations.annotations.AfterTextChange;
import com.googlecode.androidannotations.annotations.Background;
import com.googlecode.androidannotations.annotations.Click;
import com.googlecode.androidannotations.annotations.EActivity;
import com.googlecode.androidannotations.annotations.LongClick;
import com.googlecode.androidannotations.annotations.NoTitle;
import com.googlecode.androidannotations.annotations.UiThread;
import com.googlecode.androidannotations.annotations.ViewById;
import com.googlecode.androidannotations.annotations.res.StringRes;


@NoTitle
@EActivity(R.layout.main)
public class AnnotatedMain extends Activity{

	private static final String LOG_TAG = AnnotatedMain.class.getSimpleName();

	@ViewById
	protected EditText input;
	
	@StringRes(R.string.action_hint)
	protected String actionHint;
	
	@Click
	public void action(){
		runAtBack();
	}
	
	@LongClick(R.id.action)
	public void longAction(){
		Toast.makeText(this, "Long clicking on " + actionHint, Toast.LENGTH_LONG).show();
	}
	
	@AfterTextChange(R.id.input)
	public void whenInputChanged(){
		Log.i(LOG_TAG, "User changed the input to " + input.getText().toString());
	}
	
	@Background
	public void runAtBack(){
		for(int i = 0; i < 10; i++){
			progress(i);
			try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// don't care
			}
		}
	}
	
	@UiThread
	public void progress(int progress){
		Toast.makeText(this, input.getText().toString() + " #" + progress, Toast.LENGTH_SHORT).show();
	}
	
}
