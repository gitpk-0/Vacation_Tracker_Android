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
import wgu.patrick_kell_d308.Entities.Vacation;
import wgu.patrick_kell_d308.R;

/**
 * @author Patrick Kell
 */
public class VacationDetails extends AppCompatActivity {

    EditText vacationTitle;
    EditText lodgingType;
    String title;
    String lodging;
    int id;
    String startDate;
    String endDate;

    Button startDatePickerBtn;
    Button endDatePickerBtn;

    Repository repo = new Repository(getApplication());

    String dateFormat = "MM/dd/yyyy";
    SimpleDateFormat sdf = new SimpleDateFormat(dateFormat, Locale.US);
    final Calendar calendar = Calendar.getInstance();
    DatePickerDialog.OnDateSetListener startDateListener;
    DatePickerDialog.OnDateSetListener endDateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vacation_details);

        vacationTitle = findViewById(R.id.vacationTitle);
        lodgingType = findViewById(R.id.lodgingType);
        startDatePickerBtn = findViewById(R.id.startDatePickerBtn);
        endDatePickerBtn = findViewById(R.id.endDatePickerBtn);

        title = getIntent().getStringExtra("title");
        lodging = getIntent().getStringExtra("lodging type");
        startDate = getIntent().getStringExtra("start date");
        endDate = getIntent().getStringExtra("end date");

        vacationTitle.setText(title);
        lodgingType.setText(lodging);
        startDatePickerBtn.setText(startDate);
        endDatePickerBtn.setText(endDate);

        startDatePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dateSelection = startDatePickerBtn.getText().toString();
                try {
                    calendar.setTime(sdf.parse(dateSelection));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                new DatePickerDialog(VacationDetails.this, startDateListener,
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        startDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateLabel(startDatePickerBtn);
            }
        };


        endDatePickerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dateSelection = endDatePickerBtn.getText().toString();
                try {
                    calendar.setTime(sdf.parse(dateSelection));
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                new DatePickerDialog(VacationDetails.this, endDateListener,
                        calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        endDateListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, monthOfYear);
                calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                updateLabel(endDatePickerBtn);
            }
        };
    }

    private void updateLabel(Button datePicker) {
        datePicker.setText(sdf.format(calendar.getTime()));
    }

    public void onSave(View view) {
        id = getIntent().getIntExtra("id", -1);
        title = vacationTitle.getText().toString();
        lodging = lodgingType.getText().toString();
        startDate = startDatePickerBtn.getText().toString();
        endDate = endDatePickerBtn.getText().toString();

        if (id == -1) {
            Vacation newVacation = new Vacation(0, title, lodging, startDate, endDate);
            repo.insert(newVacation);
            Toast.makeText(this, "New Vacation Added", Toast.LENGTH_LONG).show();
        } else {
            Vacation updatedVacation = new Vacation(id, title, lodging, startDate, endDate);
            repo.update(updatedVacation);
            Toast.makeText(this, "Vacation Updated", Toast.LENGTH_LONG).show();
        }


        Intent backToDashboard = new Intent(VacationDetails.this, VacationDashboard.class);
        startActivity(backToDashboard);
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



}
