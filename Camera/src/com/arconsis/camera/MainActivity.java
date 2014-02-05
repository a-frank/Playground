package com.arconsis.camera;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView image;

	private static final int IMAGE_SIZE = 150;
	private static final String SAVED_PICTURE = "image";
	private static final int PICTURE_REQUEST = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		image = (ImageView) findViewById(R.id.image);
		loadInital();

		findViewById(R.id.take_picture).setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent capture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(capture, PICTURE_REQUEST);
			}
		});

	}

	private void loadInital() {
		image.setImageBitmap(loadBitmap(R.drawable.initial, IMAGE_SIZE, IMAGE_SIZE));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);

		try {
			HttpURLConnection http = (HttpURLConnection) new URL("").openConnection();
			http.setRequestMethod("POST");
			OutputStream outputStream = http.getOutputStream();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (savedInstanceState.containsKey(SAVED_PICTURE)) {
			image.setImageBitmap((Bitmap) savedInstanceState.get(SAVED_PICTURE));
		}
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		BitmapDrawable drawable = (BitmapDrawable) image.getDrawable();
		if (drawable != null) {
			Bitmap bitmap = drawable.getBitmap();
			Bitmap scaledBitmap = Bitmap.createScaledBitmap(bitmap, IMAGE_SIZE, IMAGE_SIZE, false);
			bitmap.recycle();
			outState.putParcelable(SAVED_PICTURE, scaledBitmap);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (requestCode == PICTURE_REQUEST && data.hasExtra("data")) {
			Bitmap captured = (Bitmap) data.getExtras().get("data");
			image.setImageBitmap(captured);
		}
	}

	private int calculateInSampleSize(BitmapFactory.Options options, int reqWidth, int reqHeight) {

		final int height = options.outHeight;
		final int width = options.outWidth;
		int inSampleSize = 1;

		if (height > reqHeight || width > reqWidth) {
			final int halfHeight = height / 2;
			final int halfWidth = width / 2;

			while ((halfHeight / inSampleSize) > reqHeight && (halfWidth / inSampleSize) > reqWidth) {
				inSampleSize *= 2;
			}
		}

		return inSampleSize;
	}

	private Bitmap loadBitmap(int resId, int reqWidth, int reqHeight) {

		final BitmapFactory.Options options = new BitmapFactory.Options();
		options.inJustDecodeBounds = true;
		BitmapFactory.decodeResource(getResources(), resId, options);

		options.inSampleSize = calculateInSampleSize(options, reqWidth, reqHeight);

		options.inJustDecodeBounds = false;
		return BitmapFactory.decodeResource(getResources(), resId, options);
	}

}
