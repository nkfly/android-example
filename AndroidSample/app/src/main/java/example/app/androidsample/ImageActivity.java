package example.app.androidsample;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.json.JSONObject;

import example.app.androidsample.util.JSONParser;

public class ImageActivity extends AppCompatActivity {

    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        ImageView image = (ImageView)findViewById(R.id.picture);

        Picasso.with(getApplicationContext()).load("https://scontent-hkg3-1.xx.fbcdn.net/hprofile-xpa1/v/t1.0-1/1506021_10152205537319780_497147534_n.jpg?oh=d923a2faa9cd6ee45783355956c974bb&oe=5782F9FE")
                .fit()
                .into(image);





    }
}
