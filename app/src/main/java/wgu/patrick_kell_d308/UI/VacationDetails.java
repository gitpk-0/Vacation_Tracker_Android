package wgu.patrick_kell_d308.UI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import wgu.patrick_kell_d308.R;

/**
 * @author Patrick Kell
 */
public class VacationDetails extends AppCompatActivity {

    EditText vacationTitle;
    EditText lodgingType;
    String title;
    String lodging;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_details);

        vacationTitle = findViewById(R.id.vacationTitle);
        lodgingType = findViewById(R.id.lodgingType);

        title = getIntent().getStringExtra("title");
        lodging = getIntent().getStringExtra("lodging type");

        vacationTitle.setText(title);
        lodgingType.setText(lodging);


        // FloatingActionButton fab = findViewById(R.id.addVacationBtn);
        // fab.setOnClickListener(new View.OnClickListener() {
        //     @Override
        //     public void onClick(View view) {
        //         Intent excursionDetails = new Intent(VacationDetails.this, ExcursionDetails.class);
        //         startActivity(excursionDetails);
        //     }
        // });

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
        }
        return super.onOptionsItemSelected(item);
    }



    @Override
    protected void onResume() {

        super.onResume();
        Toast.makeText(VacationDetails.this, "refresh list", Toast.LENGTH_LONG).show();
    }
}
