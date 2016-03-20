package example.app.androidsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.go_to_another_activity);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, AnotherActivity.class);
                startActivity(myIntent);

            }
        });

        Button network = (Button)findViewById(R.id.network);
        network.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, NetworkActivity.class);
                startActivity(myIntent);

            }
        });

        Button head = (Button)findViewById(R.id.head);
        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ImageActivity.class);
                startActivity(myIntent);

            }
        });

        Button map = (Button)findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, GoogleMapActivity.class);
                startActivity(myIntent);

            }
        });

        Button pager = (Button)findViewById(R.id.pager);
        pager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, PagerSlidingTabActivity.class);
                startActivity(myIntent);

            }
        });

        Button qrcode = (Button)findViewById(R.id.qrcode);
        qrcode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, QRCodeScannerActivity.class);
                startActivityForResult(myIntent, IntentIntegrator.REQUEST_CODE);

            }
        });

        Button sharepreference = (Button)findViewById(R.id.share_preference);
        sharepreference.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, SharePreferenceActivity.class);
                startActivity(myIntent);

            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == IntentIntegrator.REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                final String scan_result = intent.getStringExtra("SCAN_RESULT");
                System.out.println(scan_result);
                Toast.makeText(MainActivity.this, scan_result, Toast.LENGTH_SHORT).show();

            }
        }
    }
}
