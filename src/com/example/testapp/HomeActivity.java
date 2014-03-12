package com.example.testapp;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.support.v4.app.NavUtils;
import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import com.example.testapp.MainActivity;

public class HomeActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		// Show the Up button in the action bar.
		setupActionBar();
		TextView nameText = (TextView) findViewById(R.id.textView_name);
		nameText.setText("Welcome, " + MainActivity.EXTRA_MESSAGE);
		
		String[] values1 = new String[] { "American Red Cross", "Atlanta Blood Services", "Northside Hospital" };
		    // use your custom layout
		    ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
		        R.layout.rowlayout, R.id.label, values1);
		    ListView donationList = (ListView) findViewById(R.id.listView1); 
		    donationList.setAdapter(adapter1);
		    
		    String[] values2 = new String[] { "Emory Midtown", "Grady Atlanta", "Piedmont Atlanta" };
		    // use your custom layout
		    ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
		        R.layout.rowlayout, R.id.label, values2);
		    ListView emergencyList = (ListView) findViewById(R.id.listView2); 
		    emergencyList.setAdapter(adapter2);  
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
		getMenuInflater().inflate(R.menu.home, menu);
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
	
	public void onClickLogout(View view){
		Intent intent = new Intent(this, MainActivity.class);
	    startActivity(intent);
	}
	
	public void onClickSettings(View view){
		Intent intent = new Intent(this, SettingActivity.class);
	    startActivity(intent);
	}
	
	public void onClickRespond(View v) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);

	    builder.setTitle("Confirm");
	    builder.setMessage("Are you sure?");

	    builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {

	        public void onClick(DialogInterface dialog, int which) {
	            // Do nothing but close the dialog

	            dialog.dismiss();
	        }

	    });

	    builder.setNegativeButton("NO", new DialogInterface.OnClickListener() {

	        @Override
	        public void onClick(DialogInterface dialog, int which) {
	            // Do nothing
	            dialog.dismiss();
	        }
	    });

	    AlertDialog alert = builder.create();
	    alert.show();
	}
	

}
