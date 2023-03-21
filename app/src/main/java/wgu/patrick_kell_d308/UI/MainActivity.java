package wgu.patrick_kell_d308.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import wgu.patrick_kell_d308.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchDashboard(View view) {
        Intent dashboard = new Intent(MainActivity.this, Dashboard.class);
        startActivity(dashboard);
    }
}