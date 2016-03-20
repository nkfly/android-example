package example.app.androidsample;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.journeyapps.barcodescanner.CaptureManager;
import com.journeyapps.barcodescanner.CompoundBarcodeView;

import org.w3c.dom.Text;

/**
 * Sample Activity extending from ActionBarActivity to display a Toolbar.
 */
public class SharePreferenceActivity extends AppCompatActivity {
    TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_share_preference);

        result = (TextView) findViewById(R.id.result);
        result.setText(getName());

        Button submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = result.getText().toString();
                setName(name);
                Toast.makeText(SharePreferenceActivity.this, "Save", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public String getName() {
        SharedPreferences settings = this.getSharedPreferences("private_data", Context.MODE_PRIVATE);
        String name = settings.getString("name", "");

        return name;
    }

    public void setName(String name) {
        SharedPreferences sharedPreferences = getSharedPreferences("private_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("name", name);
        editor.apply();

    }


}