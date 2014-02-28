package com.example.testapp;

import android.os.Bundle;
import android.app.Activity;
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
		Intent intent = new Intent(this, HomeActivity.class);
	    EditText nameText = (EditText) findViewById(R.id.editText1);
	    String message = nameText.getText().toString();
	    EXTRA_MESSAGE = message;
	    startActivity(intent);
	}

}
