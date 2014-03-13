package com.example.testapp;

import android.os.Bundle;

import com.example.testapp.RESTServices.*;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;

public class RegisterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		// Show the Up button in the action bar.
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void onClickRegister(View view){
		Log.d("REST","Inside Click Register");
		EditText et = (EditText)findViewById(R.id.editText5);    
		String email = et.getText().toString().trim();
		et = (EditText)findViewById(R.id.editText1);    
		String username = et.getText().toString().trim();
		et = (EditText)findViewById(R.id.editText2);    
		String pwd = et.getText().toString().trim();
		et = (EditText)findViewById(R.id.editText4);    
		String address = et.getText().toString().trim();    
		String blood_grp = "A+";
		String url = RESTDriver.generateUrl(username,pwd,email,address,blood_grp);
		RESTDriver http = new RESTDriver(url, this, MainActivity.class, "Success");
		http.execute("");
		/*Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);*/
	}

}
