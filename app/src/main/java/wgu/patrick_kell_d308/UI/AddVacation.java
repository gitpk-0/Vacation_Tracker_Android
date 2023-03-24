package wgu.patrick_kell_d308.UI;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import wgu.patrick_kell_d308.R;

public class AddVacation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_vacation);

        // startDatePickerBtn.setText(currentDate);
        // endDatePickerBtn.setText(currentDate);
    }

    public void launchAddExcursion(View view) {
        Intent addExcursion = new Intent(AddVacation.this, AddExcursion.class);
        startActivity(addExcursion);
    }
}