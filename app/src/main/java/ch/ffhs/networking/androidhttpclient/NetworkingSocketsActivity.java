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

            try {
                socket = new Socket(HOST, 80);
                PrintWriter pw = new PrintWriter(new OutputStreamWriter(
                        socket.getOutputStream()), true);
                pw.println(HTTP_GET_COMMAND);

                data = readStream(socket.getInputStream());

            } catch (UnknownHostException exception) {
                exception.printStackTrace();
            } catch (IOException exception) {
                exception.printStackTrace();
            } finally {
                if (null != socket)
                    try {
                        socket.close();
                    } catch (IOException e) {
                        Log.e(TAG, "IOException");
                    }
            }
            return data;
        }

        @Override
        protected void onPostExecute(String result) {
            mTextView.setText(result);
        }

        private String readStream(InputStream in) {
            BufferedReader reader = null;
            StringBuffer data = new StringBuffer();
            try {
                reader = new BufferedReader(new InputStreamReader(in));
                String line = "";
                while ((line = reader.readLine()) != null) {
                    data.append(line);
                }
            } catch (IOException e) {
                Log.e(TAG, "IOException");
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        Log.e(TAG, "IOException");
                    }
                }
            }
            return data.toString();
        }
    }
}