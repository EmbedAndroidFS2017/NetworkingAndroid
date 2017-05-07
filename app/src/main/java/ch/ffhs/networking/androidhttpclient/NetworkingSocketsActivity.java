package ch.ffhs.networking.androidhttpclient;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class NetworkingSocketsActivity extends Activity {
    TextView mTextView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        mTextView = (TextView) findViewById(R.id.textView1);

        final Button loadButton = (Button) findViewById(R.id.button1);
        loadButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                new HttpGetTask().execute();

            }
        });
    }

    private class HttpGetTask extends AsyncTask<Void, Void, String> {

        private static final String HOST = "samples.openweathermap.org";

        private static final String HTTP_GET_COMMAND = "GET /data/2.5/find?q=London&type=like&mode=xml&appid=b1b15e88fa797225412429c1c50c122a1"
                + " HTTP/1.1"
                + "\n"
                + "Host: "
                + HOST
                + "\n"
                + "Connection: close" + "\n\n";

        private static final String TAG = "HttpGet";

        @Override
        protected String doInBackground(Void... params) {
            Socket socket = null;
            String data = "";

            // TODO:
            /* socket erstellen.
               readStream aufrufen mit socket's input stream => data
               socket richtig schliessen.
             */
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO:
            /*
                mClient abschliessen.
                Der Text der mTextView mit dem Resultat setzen.
             */
        }

        private String readStream(InputStream in) {
            BufferedReader reader = null;
            StringBuffer data = new StringBuffer();

            // TODO:
            /*
              Zeile durch Zeile auslesen und data erstellen.
              Nachdem Lesen reader schliessen.
             */
            return data.toString();
        }
    }
}