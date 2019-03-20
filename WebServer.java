 

public class WebServer {
	public JSONArray doPost(List<NameValuePair> namevaluepair, String url) {
		JSONArray myjsonarray = null;

		try {
			HttpClient myclient = new DefaultHttpClient();
			HttpPost newhttppost = new HttpPost(url);
			newhttppost.setEntity(new UrlEncodedFormEntity(namevaluepair));
			HttpResponse myresponse = myclient.execute(newhttppost);
			Log.i("post response", "" + myresponse);
			String line = "";
			StringBuilder total = new StringBuilder();
			BufferedReader br = new BufferedReader(new InputStreamReader(
					myresponse.getEntity().getContent()));

			while ((line = br.readLine()) != null) {
				total.append(line);
			}

			myjsonarray = new JSONArray(total.toString());
			Log.i("array", "" + myjsonarray);
			// Log.i("msg", "hai");
		} catch (Exception e) {
			// Log.i("e",""+e);
			e.printStackTrace();
		}
		return myjsonarray;

	}

}
