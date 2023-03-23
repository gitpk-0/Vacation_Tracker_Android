package wgu.patrick_kell_d308.UI;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import wgu.patrick_kell_d308.R;

/**
 * @author Patrick Kell
 */
public class ExcursionDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excursion_details);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_excursion_details, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
//                Intent intent=new Intent(PartDetails.this,MainActivity.class);
//                startActivity(intent);
//                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
