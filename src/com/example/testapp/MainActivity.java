package com.example.testapp;

import com.example.testapp.RESTServices.RESTDriver;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;

public class MainActivity extends Activity {
	
	public static String EXTRA_MESSAGE = "com.example.testapp.MESSAGE";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void onClickSignup(View view){
		Intent intent = new Intent(this, RegisterActivity.class);
	    startActivity(intent);
	}
	
	public void onClickLogin(View view){
		Log.d("REST Login", "Inside Login method");
		EditText nameText = (EditText) findViewById(R.id.editText1);
	    String message = nameText.getText().toString();
	    EditText nameText2 = (EditText) findViewById(R.id.editText2);
	    String message2 = nameText2.getText().toString();
	    EXTRA_MESSAGE = message;
	    String url = RESTDriver.generateUrl(message,message2);
		RESTDriver http = new RESTDriver(url, this, HomeActivity.class, "Success");
		http.execute("");
	}

}
