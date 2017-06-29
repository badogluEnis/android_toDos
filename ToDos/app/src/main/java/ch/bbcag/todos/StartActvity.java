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

    ListView list;
    ToDosDAO dbConnection;
    private ToDosAdapter ToDosAdapter;
    private int isOpenShown = 1;

    public int getIsOpenShown() {
        return isOpenShown;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_actvity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // dbConnection = new ToDosDAO().getInstance(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addToDo(view);
            }
        });

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


    private void reloadList() {
        ToDosAdapter.refreshData();
    }

    private void addToDo(View view) {
        Intent intent = new Intent(this, CreateActivity.class);
        startActivity(intent);
    }


    private void showToDos() {
        ListView listView = (ListView) findViewById(R.id.listview);

        ToDosAdapter = new ToDosAdapter(this);
        listView.setAdapter(ToDosAdapter);

        reloadList();
    }


}
