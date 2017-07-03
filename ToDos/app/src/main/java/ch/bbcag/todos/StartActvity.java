package ch.bbcag.todos;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartActvity extends AppCompatActivity {

    private ToDosAdapter ToDosAdapter;
    // isOpenShown ist hier extra auf 1 gestellt da die erste Liste die die ListView anzeigen soll die offenen ToDos sein sollen
    private int isOpenShown = 1;

    // Der getter um aus anderen Klassen auf isOpenShown zugreifen zu können
    public int getIsOpenShown() {
        return isOpenShown;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Hier wird das Activity gemacht und der Toolbar gesetzt
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_actvity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // Hier wird ein glickListener auf fab gesetzt(um ein neues ToDO zu erstellen)
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToDo(view);
            }
        });


        // Die beiden Button sind um die Liste mit den Datenbankeinträgen zu zeigen
        Button open = (Button) findViewById(R.id.buttonOpen);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOpenShown = 1;
                showToDos();

            }
        });

        Button closed = (Button) findViewById(R.id.buttonClosed);
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isOpenShown = 0;
                showToDos();
            }
        });

        showToDos();

    }

    // Hier wird die Liste reloaded
    private void reloadList() {
        ToDosAdapter.refreshData();
    }

    // Hier wird ein neues Activity gemacht
    private void addToDo(View view) {
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

    // Hier werden die ToDOs gezeigt
    private void showToDos() {
        ListView listView = (ListView) findViewById(R.id.listview);

        ToDosAdapter = new ToDosAdapter(this);
        listView.setAdapter(ToDosAdapter);

        reloadList();
    }


}
