package com.example.testapp.RESTServices;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
 
import javax.net.ssl.HttpsURLConnection;
 
public class RESTDriver {
 
	private final String USER_AGENT = "Android";
 
	public static void main(String[] args) throws Exception {
		
		// Example usage of the REST API
		RESTDriver http = new RESTDriver();
 		String user_name = "user"+Math.random();
		System.out.println("Testing 1 - Inserting new user");
		http.insertNewUser(user_name,"hie","hie", "hie","hie");
		http.login(user_name,"hie");
		http.login(user_name,"hello");
		http.updatePage(user_name,"address", (float)6, (float)2.5);
 
	}

	private void insertNewUser(String u_name, String password, String email, String address, String blood_grp) throws Exception{
		String url = "http://54.218.21.198/test.php?user_name="+u_name+"&user_password="+password+"&user_email="+email+"&user_address="+address+"&user_blood_grp="+blood_grp;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
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
		System.out.println("Final Response: "+response.toString());
		if (response.toString().equalsIgnoreCase("Entered data successfully")) {
			System.out.println("Insert Success");
		}
		else {
			System.out.println("Insert Failure");
		}

		//"http://54.218.21.198/login.php?user_name=hi&user_password=hell";
	}

	private boolean login (String u_name, String password) throws Exception {
		String url = "http://54.218.21.198/login.php?user_name="+u_name+"&user_password="+password;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
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
		System.out.println("Final Response: "+response.toString());
		if (response.toString().equalsIgnoreCase("Success")) {
			System.out.println("Login Success");
			return true;
		}
		else {
			System.out.println("Login Failure");
			return false;
		}
	}

	private void updatePage (String u_name, String address, float frequency, float distance) throws Exception {
		String url = "http://54.218.21.198/update.php?user_name="+u_name+"&user_address="+address+"&user_frequency="+frequency+"&user_distance="+distance;
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
 
		// optional default is GET
		con.setRequestMethod("GET");
 
		//add request header
		con.setRequestProperty("User-Agent", USER_AGENT);
 
		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
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
		System.out.println("Final Response: "+response.toString());
		if (response.toString().equalsIgnoreCase("Updated data successfully")) {
			System.out.println("Update Success");
		}
		else {
			System.out.println("Update Failure");
		}
	}

	
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
 
}