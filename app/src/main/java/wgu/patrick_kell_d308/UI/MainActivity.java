package wgu.patrick_kell_d308.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import wgu.patrick_kell_d308.Database.Repository;
import wgu.patrick_kell_d308.Entities.Excursion;
import wgu.patrick_kell_d308.Entities.Vacation;
import wgu.patrick_kell_d308.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.addSampleData:
                Repository repo = new Repository(getApplication());

                Vacation vacation = new Vacation(0, "Costa Rica", "AirBnB", "July 23", "July 30");
                repo.insert(vacation);

                Excursion excursion = new Excursion(0, "Surfing", "July 24", 0);
                repo.insert(excursion);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void launchDashboard(View view) {

        Intent dashboard = new Intent(MainActivity.this, Dashboard.class);
        startActivity(dashboard);
    }
}