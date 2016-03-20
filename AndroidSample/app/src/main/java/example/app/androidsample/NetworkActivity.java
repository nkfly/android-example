package example.app.androidsample;

import android.content.ContentValues;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import example.app.androidsample.util.JSONParser;

public class NetworkActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);

        result = (TextView)findViewById(R.id.result);

        new AsyncTask<Void, String, JSONObject>() {
            @Override
            protected JSONObject doInBackground(Void... params) {
                Uri.Builder builder = new Uri.Builder();
                //http://jsonplaceholder.typicode.com/posts/1
                builder.scheme("http")
                        .encodedAuthority("jsonplaceholder.typicode.com")
                        .appendEncodedPath("posts/1");

                String url = builder.build().toString();

                JSONParser jParser = new JSONParser();
                JSONObject json = jParser.getJSONFromUrl(url);
                return json;
            }

            @Override
            protected void onPostExecute(JSONObject json) {
                try {
                    System.out.println(json);
                    result.setText(json.toString());

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }.execute(null, null, null);






    }
}
