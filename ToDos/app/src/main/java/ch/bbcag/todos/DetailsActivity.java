package ch.bbcag.todos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailsActivity extends AppCompatActivity {

    EditText name;
    EditText date;
    EditText desc;

    Button del;
    Button edit;
    Button done;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        name.setText("test");
        date.setText("test");
        desc.setText("test");

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
