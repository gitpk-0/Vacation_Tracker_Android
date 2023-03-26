package wgu.patrick_kell_d308.UI;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import wgu.patrick_kell_d308.Database.Repository;
import wgu.patrick_kell_d308.Entities.Excursion;
import wgu.patrick_kell_d308.R;

/**
 * @author Patrick Kell
 */
public class ExcursionDetails extends AppCompatActivity {

    EditText excursionTitle;
    String title;
    String date;
    int excursionId;
    int vacationId;

    Button excursionDatePickerBtn;

    Repository repo = new Repository(getApplication());

    String dateFormat = "MM/dd/yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
    final Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener dateListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursion_details);

        excursionTitle = findViewById(R.id.excursionTitle);
        title = getIntent().getStringExtra("title");
        excursionTitle.setText(title);

        excursionDatePickerBtn = findViewById(R.id.excursionDatePickerBtn);
        date = getIntent().getStringExtra("date");
        excursionDatePickerBtn.setText(date);

        excursionDatePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dateSelection = excursionDatePickerBtn.getText().toString();
                try {
                    calendar.setTime(sdf.parse(dateSelection));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                new DatePickerDialog(ExcursionDetails.this, dateListener,
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        dateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateLabel(excursionDatePickerBtn);
            }
        };
    }

    private void updateLabel(Button datePicker) {
        datePicker.setText(sdf.format(calendar.getTime()));
    }

    public void onSave(View view) {
        excursionId = getIntent().getIntExtra("id", -1);
        title = excursionTitle.getText().toString();
        date = excursionDatePickerBtn.getText().toString();
        vacationId = getIntent().getIntExtra("vid", -1);


        if (excursionId == -1) {
            Excursion newExcursion = new Excursion(excursionId, title, date, vacationId);
            repo.insert(newExcursion);
            Toast.makeText(this, "New Excursion Added", Toast.LENGTH_LONG).show();
        } else {
            Excursion updatedExcursion = new Excursion(excursionId, title, date, vacationId);
            repo.update(updatedExcursion);
            Toast.makeText(this, "Excursion Updated", Toast.LENGTH_LONG).show();
        }


        Intent backToExcursionDashboard = new Intent(ExcursionDetails.this, ExcursionDashboard.class);
        startActivity(backToExcursionDashboard);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_excursion_details, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
