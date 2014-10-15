package com.mailsending;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainLayoutActivity extends Activity {

	Button btnCompose;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_layout);
		btnCompose = (Button) findViewById(R.id.btnCompose);
	}

	public void Compose(View view) {
		Intent intent = new Intent(getApplicationContext(),
				FeildsActivity.class);
		startActivity(intent);
	}
}
