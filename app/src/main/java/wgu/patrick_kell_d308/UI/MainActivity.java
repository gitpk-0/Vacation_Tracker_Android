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
        Repository repo = new Repository(getApplication());
        switch (item.getItemId()) {
            case R.id.addSampleData:

                Vacation vacation = new Vacation(0, "Costa Rica", "AirBnB", "07/23/2021", "07/30/2021");
                repo.insert(vacation);
                Vacation vacation2 = new Vacation(1, "Thailand", "Hotel", "08/02/2022", "09/28/2022");
                repo.insert(vacation2);
                Vacation vacation3 = new Vacation(2, "North Pole", "Santa's House", "12/23/2023", "12/30/2023");
                repo.insert(vacation3);

                Excursion excursion = new Excursion(0, "Surfing", "07/24/2021", 0);
                repo.insert(excursion);
                return true;

            case R.id.removeSampleData:
                for (Vacation vaca : repo.getAllVacations()) {
                    repo.delete(vaca);
                }

                for (Excursion excur: repo.getAllExcursions()) {
                    repo.delete(excur);
                }
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void launchDashboard(View view) {

        Intent dashboard = new Intent(MainActivity.this, DashboardVacation.class);
        startActivity(dashboard);
    }
}