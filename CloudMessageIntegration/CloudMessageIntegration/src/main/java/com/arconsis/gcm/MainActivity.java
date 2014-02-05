package com.arconsis.gcm;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.google.android.gms.gcm.GoogleCloudMessaging;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by alexfrank on 24.05.13.
 */
public class MainActivity extends Activity {

    public static final String SENDER_ID = "4815162342";
    private Button register;
    private TextView notRegistered;
    private RegistrationPreferences registrationPreferences;
    private Button echo;
    private GoogleCloudMessaging gcm;
    private AtomicInteger msgId = new AtomicInteger();

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        registrationPreferences = new RegistrationPreferences(this);
        gcm = GoogleCloudMessaging.getInstance(MainActivity.this);

        notRegistered = (TextView) findViewById(R.id.not_registered);
        echo = (Button) findViewById(R.id.echo);
        echo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Send().execute("Let's test this");
            }
        });
        register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (registrationPreferences.isRegistered()) {
                    new Unregister().execute();
                } else {
                    new Register().execute();
                }
            }
        });
        initUi();
    }

    private void initUi() {
        if (registrationPreferences.isRegistered()) {
            changeUiToRegistered();
        } else {
            changeUiToUnregistered();
        }
    }

    private void changeUiToUnregistered() {
        echo.setVisibility(View.GONE);
        notRegistered.setVisibility(View.VISIBLE);
        register.setText(R.string.register);
        register.setBackgroundResource(R.color.light_green);
    }

    private void changeUiToRegistered() {
        echo.setVisibility(View.VISIBLE);
        notRegistered.setVisibility(View.GONE);
        register.setText(R.string.unregister);
        register.setBackgroundResource(R.color.light_red);
    }

    private class Unregister extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                gcm.unregister();
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                changeUiToUnregistered();
                registrationPreferences.setRegistrationId("");
            } else {
                Toast.makeText(MainActivity.this, R.string.unregister_failed, Toast.LENGTH_LONG).show();
            }
        }
    }

    private class Register extends AsyncTask<Void, Void, Boolean> {
        @Override
        protected Boolean doInBackground(Void... voids) {
            try {
                gcm.register(SENDER_ID);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (success) {
                changeUiToRegistered();
                registrationPreferences.setRegistrationId(SENDER_ID);
            } else {
                Toast.makeText(MainActivity.this, R.string.register_failed, Toast.LENGTH_LONG).show();
            }
        }
    }

    private class Send extends AsyncTask<String, Void, Boolean>{
        @Override
        protected Boolean doInBackground(String... params) {
            Bundle bundle = new Bundle();
            bundle.putString("hello", params[0]);
            try {
                gcm.send(SENDER_ID+"@gcm.googleapis.com", Integer.toString(msgId.incrementAndGet()), bundle);
                return true;
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if(success){
                Toast.makeText(MainActivity.this, R.string.send_failed, Toast.LENGTH_LONG).show();
            }
        }
    }
}