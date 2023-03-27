package wgu.patrick_kell_d308.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import wgu.patrick_kell_d308.Adapter.VacationAdapter;
import wgu.patrick_kell_d308.Database.Repository;
import wgu.patrick_kell_d308.Entities.Vacation;
import wgu.patrick_kell_d308.R;

public class DashboardVacation extends AppCompatActivity {

    private Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_dashboard);

        RecyclerView vacationRV = findViewById(R.id.vacationRV);
        final VacationAdapter vacationAdapter = new VacationAdapter(this);
        vacationRV.setAdapter(vacationAdapter);
        vacationRV.setLayoutManager(new LinearLayoutManager(this));
        repo = new Repository(getApplication());
        List<Vacation> allVacations = repo.getAllVacations();
        vacationAdapter.setVacations(allVacations);

    }

    public void launchAddVacation(View view) {
        Intent addVacation = new Intent(DashboardVacation.this, AddVacation.class);
        startActivity(addVacation);
    }

    @Override
    protected void onResume() {

        super.onResume();
        RecyclerView vacationRV = findViewById(R.id.vacationRV);
        final VacationAdapter vacationAdapter = new VacationAdapter(this);
        vacationRV.setAdapter(vacationAdapter);
        vacationRV.setLayoutManager(new LinearLayoutManager(this));
        repo = new Repository(getApplication());
        List<Vacation> allVacations = repo.getAllVacations();
        vacationAdapter.setVacations(allVacations);
        Toast.makeText(DashboardVacation.this, "List refreshed", Toast.LENGTH_LONG).show();
    }
}