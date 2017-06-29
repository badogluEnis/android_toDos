package ch.bbcag.todos;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ToDosDAO {

    private SQLiteDatabase db;
    private static ToDosDAO instance;

    // Der Konstruktor der Klasse ToDosDAO
    private ToDosDAO(Context context) {

        ToDosHelper dbHelper = new ToDosHelper(context);
        db = dbHelper.getWritableDatabase();
    }

    // Hier ist das getInstance von ToDosDAO, es dient dazu, dass nur eine Instanz gemacht werden kann

    public static ToDosDAO getInstance(Context context) {
        if (instance == null) {
            instance = new ToDosDAO(context.getApplicationContext());
        }
        return instance;
    }

    // Hier wird die datenbank geschlossen
    public void close() {
        db.close();
    }

    // Hier wird ein ToDO erstellt

    public void createToDo(String title, String description, String date, Integer pushmessage) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("description", description);
        contentValues.put("date", date);
        contentValues.put("pushmessage", pushmessage);

        db.insert("ToDos", null, contentValues);
    }

    // Hier wird ein ToDo gelösch
    public void deleteToDo(int todoId) {
        db.delete("ToDos", "id = " + todoId, null);
    }

    // Hier werden alle ToDos angezeigt

    public List<ToDos> getToDos(Integer isopen) {
        List<ToDos> todolist = new ArrayList<ToDos>();

        String[] tableColumns = new String[]{"id", "title", "description", "date", "pushmessage", "isopen"};
        String sortOrder = String.format("%s ASC", "title");

        // Um nicht zwei querys zu schreiben wird muss isopen mitgegeben werden was dann hier bei isopen =? aussortiert wird
        Cursor cursor = db.query("ToDos", tableColumns, "isopen" + "=?", new String[]{isopen.toString()}, null, null, sortOrder);

        cursor.moveToFirst();

        // Der Cursor überfliegt jede Zeile der Datenbank und schreibt die Werte in die todolist
        while (!cursor.isAfterLast()) {
            ToDos todo = new ToDos();


            todo.setTitle(cursor.getString(1));
            todo.setDescription(cursor.getString(2));
            todo.setDate(cursor.getString(3));
            todo.setPushmessage(cursor.getInt(4) == 0 ? false : true);
            todo.setIsopen(cursor.getInt(5) == 0 ? false : true);

            todolist.add(todo);

            cursor.moveToNext();

        }
        return todolist;
    }


    public void updateToDo(Integer id, String title, String description, String date, Integer pushmessage) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("description", description);
        contentValues.put("date", date);
        contentValues.put("pushmessage", pushmessage);

        db.update("ToDos", contentValues, "id =?", new String[]{id.toString()});

    }

    //Hier wird ein ToDo geschlossen
    public void closeToDo(Integer id) {
        ContentValues contenValues = new ContentValues();
        contenValues.put("isopen", 0);
        db.update("ToDos", contenValues, "id =?", new String[]{id.toString()});
    }

    //Hier wird ein ToDo geöffnet
    public void reopenToDo(Integer id){
        ContentValues contentValues = new ContentValues();
        contentValues.put("isopen", 1);
        db.update("", contentValues, "id=?", new String[]{id.toString()});
    }
}
