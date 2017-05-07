package ch.ffhs.networking.androidhttpclient;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;

import android.app.Activity;
import android.net.http.AndroidHttpClient;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class NetworkingAndroidHttpClientActivity extends Activity {
	private TextView mTextView = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		mTextView = (TextView) findViewById(R.id.textView1);

		final Button loadButton = (Button) findViewById(R.id.button1);
		loadButton.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				new HttpGetTask().execute();
			}
		});
	}

	private class HttpGetTask extends AsyncTask<Void, Void, String> {

		private static final String URL = "http://samples.openweathermap.org/data/2.5/forecast?id=524901&appid=315dd2d724e2f0ee894c6a2e8762ff11";

		AndroidHttpClient mClient = AndroidHttpClient.newInstance("");

		@Override
		protected String doInBackground(Void... params) {

            // TODO:
            /* HttpGet, ResponseHandler<String> erstellen.
               mClient ausführen mit diesen zwei.
             */
			return null;
		}

		@Override
		protected void onPostExecute(String result) {
            // TODO:
            /*
                mClient abschliessen.
                Der Text der mTextView mit dem Resultat setzen.
             */
		}
	}
}