package com.mailsending;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
//import android.view.Menu;
//import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeildsActivity extends Activity {

	EditText etRecipient;
	EditText etBody;
	EditText etSubject;
	Button btnSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feilds_layout);
		etRecipient = (EditText) findViewById(R.id.etRecipient);
		etBody = (EditText) findViewById(R.id.etBody);
		etSubject = (EditText) findViewById(R.id.etSubject);
		btnSend = (Button) findViewById(R.id.btnSend);
		if ((etSubject == null) || (etRecipient == null) || (etBody == null)) {
			Toast.makeText(getApplicationContext(), "All Feilds Are Requied",
					Toast.LENGTH_LONG).show();
		}
		btnSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				sendEmail();
				etRecipient.setText("");
				etBody.setText("");
				etSubject.setText("");
			}
		});
	}

	public void sendEmail() {
		String[] recipients = { etRecipient.getText().toString() };
		Intent email = new Intent(Intent.ACTION_SEND, Uri.parse("mailto:"));
		email.setType("text/plain");
		email.putExtra(Intent.EXTRA_EMAIL, recipients);
		email.putExtra(Intent.EXTRA_SUBJECT, etSubject.getText().toString());
		email.putExtra(Intent.EXTRA_TEXT, etBody.getText().toString());
		try {

			startActivity(Intent.createChooser(email,
					"Choose an email client from..."));
		} catch (android.content.ActivityNotFoundException ex) {
			Toast.makeText(getApplicationContext(),
					"No email client installed.", Toast.LENGTH_LONG).show();
		}

	}
}
