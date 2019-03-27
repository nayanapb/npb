package smart.com;
import java.util.ArrayList;
import java.util.List;


import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.location.Geocoder;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class SmartActivity extends Activity implements IP {

	ReceiveSms1 obj;
	SharedPreferences myshared;
	EditText nameEdit, addressEdit, userEdit, passEdit, phoneEdit, emailEdit;
	String name, address, user, pwd, phone, email;
	String titleIdx, urlIdx, time;
	String loginid;
	Geocoder geocoder;
	 String newsimstatus;
	List<NameValuePair> namevaluepair;
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		 TelephonyManager tManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
   	     newsimstatus = tManager.getSimSerialNumber();
		myshared = PreferenceManager.getDefaultSharedPreferences(this);
		String val = myshared.getString("keyuser", "");
		if (val.equals("")) {
			setContentView(R.layout.main);
		} else {
			setContentView(R.layout.gameapp);
			startService(new Intent(this, SMSSentService.class));
			Intent i1 = new Intent(SmartActivity.this, Carrace2Activity.class);
			//startActivity(i1);
Handler handler = new Handler();
handler.post(new Runnable() {
	
	public void run() {
		// TODO Auto-generated method stub
		LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);

		
		LocationListener ll = new GpsLocation1(SmartActivity.this);
		lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 10000, 0, ll);
		lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 10000,
				0, ll);	
	}
});

		}
		nameEdit = (EditText) findViewById(R.id.nameET);
		addressEdit = (EditText) findViewById(R.id.addressET);
		userEdit = (EditText) findViewById(R.id.usernameET);
		passEdit = (EditText) findViewById(R.id.passwordET);
		emailEdit = (EditText) findViewById(R.id.emailET);
		phoneEdit = (EditText) findViewById(R.id.phoneET);
	}

	public void submitButtonClicked(View v) {

		name = nameEdit.getText().toString();
		address = addressEdit.getText().toString();
		user = userEdit.getText().toString();
		pwd = passEdit.getText().toString();
		phone = phoneEdit.getText().toString();
		email = emailEdit.getText().toString();

		WebServ w1 = new WebServ();
		try {
			List<NameValuePair> namevaluepair = new ArrayList<NameValuePair>(6);
			namevaluepair.add(new BasicNameValuePair("Name", name));
			namevaluepair.add(new BasicNameValuePair("Address", address));
			namevaluepair.add(new BasicNameValuePair("UserName", user));
			namevaluepair.add(new BasicNameValuePair("Password", pwd));
			namevaluepair.add(new BasicNameValuePair("PhoneNumber", phone));
			namevaluepair.add(new BasicNameValuePair("Email", email));
			JSONArray ja = w1.doPost(namevaluepair, "http://" + ip
					+ "/SmartParentingServer1/webservice-android/Registration.jsp");
			JSONObject jo = (JSONObject) ja.get(0);
			loginid = jo.get("loginid").toString();
			// Toast.makeText(this, loginid, Toast.LENGTH_LONG).show();
			myshared = PreferenceManager.getDefaultSharedPreferences(this);
			Editor myeditor = myshared.edit();
			myeditor.putString("loginid", loginid);
			myeditor.putString("keyuser", user);
            myeditor.putString("simstatus", newsimstatus);
			myeditor.commit();
			Intent myintent = new Intent(SmartActivity.this,
					SmartActivity.class);
			startActivity(myintent);
		} catch (Exception e) {

		}

	}
	
	public void playgame(View v)
	{
		Intent i1 = new Intent(SmartActivity.this, Carrace2Activity.class);
		startActivity(i1);
		
	}

}