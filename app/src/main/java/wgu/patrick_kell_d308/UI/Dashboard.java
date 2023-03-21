package wgu.patrick_kell_d308.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import wgu.patrick_kell_d308.R;

public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
    }

    public void launchAddVacation(View view) {
        Intent addVacation = new Intent(Dashboard.this, AddVacation.class);
        startActivity(addVacation);
    }
}