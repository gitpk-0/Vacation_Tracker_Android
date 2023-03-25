package wgu.patrick_kell_d308.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import wgu.patrick_kell_d308.Database.Repository;
import wgu.patrick_kell_d308.Entities.Excursion;
import wgu.patrick_kell_d308.R;

/**
 * @author Patrick Kell
 */
public class ExcursionDashboard extends AppCompatActivity {

    private Repository repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursion_dashboard);

        RecyclerView excursionRV = findViewById(R.id.excursionRV);
        final ExcursionAdapter excursionAdapter = new ExcursionAdapter(this);
        excursionRV.setAdapter(excursionAdapter);
        excursionRV.setLayoutManager(new LinearLayoutManager(this));
        repo = new Repository(getApplication());
        List<Excursion> allExcursions = repo.getAllExcursions();
        excursionAdapter.setExcursions(allExcursions);
    }

    public void launchAddExcursion(View view) {
        Intent addExcursion = new Intent(ExcursionDashboard.this, AddExcursion.class);
        startActivity(addExcursion);
    }

    @Override
    protected void onResume() {

        super.onResume();
        RecyclerView excursionRV = findViewById(R.id.excursionRV);
        final ExcursionAdapter excursionAdapter = new ExcursionAdapter(this);
        excursionRV.setAdapter(excursionAdapter);
        excursionRV.setLayoutManager(new LinearLayoutManager(this));
        repo = new Repository(getApplication());
        List<Excursion> allExcursions = repo.getAllExcursions();
        excursionAdapter.setExcursions(allExcursions);
    }
}

