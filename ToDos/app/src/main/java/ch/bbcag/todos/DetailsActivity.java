package ch.bbcag.todos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Switch;

public class DetailsActivity extends AppCompatActivity {

    EditText name;
    EditText date;
    EditText desc;

    ImageButton del;
    ImageButton edit;
    ImageButton done;

    Switch push;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        del = (ImageButton) findViewById(R.id.infoBtnDel);
        edit = (ImageButton) findViewById(R.id.infoBtnEdit);
        done = (ImageButton) findViewById(R.id.infoBtnDone);

        name.setText("test"); //aus datenbank auslesen!!
        date.setText("test"); //aus datenbank auslesen!!
        desc.setText("test"); //aus datenbank auslesen!!

        push.setChecked(false); //aus datenbank auslesen!!

        del.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //todo löschen
            }
        });

        edit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //todo editieren
            }
        });

        done.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //todo als erledigt markieren
            }
        });
    }
}
