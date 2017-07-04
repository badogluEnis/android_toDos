package ch.bbcag.todos;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
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

public class StartActivity extends AppCompatActivity {

    Button close;
    Button open;
    private int isOpenShown = 1;  // isOpenShown ist hier extra auf 1 gestellt da die erste Liste die die ListView anzeigen soll die offenen ToDos sein sollen
    private ToDosAdapter toDosAdapter;
    private ListView listView;

    // Der getter um aus anderen Klassen auf isOpenShown zugreifen zu können
    public int getIsOpenShown() {

        return isOpenShown;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Hier wird das Activity gemacht und der Toolbar gesetzt
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_actvity);
        listView = (ListView) findViewById(R.id.listview);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        open = (Button) findViewById(R.id.buttonOpen);
        close = (Button) findViewById(R.id.buttonClosed);

        Log.d("Database Test", ToDosDAO.getInstance(this).getToDos(1).toString());

        toDosAdapter = new ToDosAdapter(this);
        toDosAdapter.addAll(ToDosDAO.getInstance(this).getToDos(1));
        listView.setAdapter(toDosAdapter);


        // Hier wird ein glickListener auf fab gesetzt(um ein neues ToDO zu erstellen)
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToDo(view);
            }
        });


        // Die beiden Button sind um die Liste mit den Datenbankeinträgen zu zeigen
        open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                close.setBackgroundColor(0x00000000);
                open.setBackgroundResource(android.R.drawable.btn_default);
                isOpenShown = 1;
                reloadList();

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                open.setBackgroundColor(0x00000000);
                close.setBackgroundResource(android.R.drawable.btn_default);
                isOpenShown = 0;
                reloadList();
            }
        });

        reloadList();

    }

    @Override
    protected void onResume() {

        super.onResume();
        reloadList();
    }

    // Hier wird die Liste reloaded
    private void reloadList() {

        toDosAdapter.refreshData();
    }

    // Hier wird ein neues Activity gemacht
    private void addToDo(View view) {

        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }

}
