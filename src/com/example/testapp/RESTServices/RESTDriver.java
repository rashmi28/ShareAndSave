package com.example.testapp.RESTServices;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
import javax.net.ssl.HttpsURLConnection;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.example.testapp.SettingActivity;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
 

public class RESTDriver extends AsyncTask<String, Void, String> {

	String url;
	Class intentClass;
	Context context;
	String responseString;
	
	private static String serverip = "54.186.114.204";
	
	public String getResponseString() {
		return responseString;
	}
	
	public RESTDriver(String url, Context context, Class intentClass, String response) {
		this.url = url;
		this.intentClass = intentClass;
		this.context = context;
		responseString = response;
	}
	
	public static String generateUrl(String u_name, String password, String email, String address, String blood_grp) {
		return "http://"+serverip+"/insert.php?user_name="+u_name+"&user_pwd="+password+"&user_email="+email+"&user_address="+address+"&user_grp="+blood_grp;	
	}
	
	public static String generateUrl (String u_name, String password ) {
		return "http://"+serverip+"/login.php?user_name="+u_name+"&user_pwd="+password;
	}
	
	public static String generateUrl (String u_name, String address, String frequency, String distance) {
		return "http://"+serverip+"/update.php?user_name="+u_name+"&user_address="+address+"&user_frequency="+frequency+"&user_distance="+distance;
	}

		
    @Override
    protected String doInBackground(String... urls) {
    	String final_response = "";
        Log.d("REST","In background");
        Log.d("REST",url);
            DefaultHttpClient client = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(url);
            try {
            	URL obj = new URL(url);
        		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
         
        		// optional default is GET
        		con.setRequestMethod("GET");
         
        		//add request header
        		con.setRequestProperty("User-Agent", "Android");
         
        		//int responseCode = con.getResponseCode();
        		System.out.println("\nSending 'GET' request to URL : " + url);
        		//Log.d("REST response code","Response Code : " + responseCode);
         
        		BufferedReader in = new BufferedReader(
        		        new InputStreamReader(con.getInputStream()));
        		String inputLine;
        		StringBuffer response = new StringBuffer();
         
        		while ((inputLine = in.readLine()) != null) {
        			response.append(inputLine);
        		}
        		final_response = response.toString();
        		in.close();
                Log.d("REST response",response.toString());

            } catch (Exception e) {
                e.printStackTrace();
            }

        return final_response;
    }


    @Override
    protected void onPostExecute(String result) {
    	if (result.equalsIgnoreCase(responseString)) {
	    	Intent myIntent = new Intent(context, intentClass);
	    	context.startActivity(myIntent);
    	}
    	// how do I pass this result back to the thread, that created me?
    }


}

/*	
	// HTTP POST request Template
	private void sendPost() throws Exception {
 
		String url = "Put your url here";
		URL obj = new URL(url);
		HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
 
		//add reuqest header
		con.setRequestMethod("POST");
		con.setRequestProperty("User-Agent", USER_AGENT);
		con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
 
		String urlParameters = "sn=C02G8416DRJM&cn=&locale=&caller=&num=12345";
 
		// Send post request
		con.setDoOutput(true);
		DataOutputStream wr = new DataOutputStream(con.getOutputStream());
		wr.writeBytes(urlParameters);
		wr.flush();
		wr.close();
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'POST' request to URL : " + url);
		System.out.println("Post parameters : " + urlParameters);
		System.out.println("Response Code : " + responseCode);
 
		BufferedReader in = new BufferedReader(
		        new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();
 
		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
 
		//print result
		System.out.println(response.toString());
 
	}
 
}*/