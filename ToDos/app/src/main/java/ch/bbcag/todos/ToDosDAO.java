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

    public void createToDo(String title, String description, String date, int pushmessage) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ToDosEntry.TODOS_TITLE, title);
        contentValues.put(ToDosEntry.TODOS_DESCRIPTION, description);
        contentValues.put(ToDosEntry.TODOS_DATE, date);
        contentValues.put(ToDosEntry.TODOS_PUSHMESSAGE, pushmessage);
        contentValues.put(ToDosEntry.TODOS_ISOPEN, 1);

        db.insert(
                ToDosEntry.TABLE_TODOS,
                null,
                contentValues
        );
    }

    // Hier wird ein ToDo gelöscht
    public void deleteToDo(int todoId) {

        String selection = ToDosEntry.TODOS_ID + " = " + todoId ;
        db.delete(
                ToDosEntry.TABLE_TODOS,
                selection,
                null
        );
    }

    // Hier werden alle ToDos angezeigt

    public List<ToDos> getToDos(Integer isopen) {

        List<ToDos> todolist = new ArrayList<ToDos>();

        String[] tableColumns = new String[]{ToDosEntry.TODOS_ID, ToDosEntry.TODOS_TITLE, ToDosEntry.TODOS_DESCRIPTION, ToDosEntry.TODOS_DATE, ToDosEntry.TODOS_PUSHMESSAGE, ToDosEntry.TODOS_ISOPEN};
        String selection = ToDosEntry.TODOS_ISOPEN + " =? ";
        String[] selectionargs = new String[] {String.valueOf(isopen)};
        String sortOrder = ToDosEntry.TODOS_DATE + " ASC, " + ToDosEntry.TODOS_TITLE + " ASC";



        // Um nicht zwei querys zu schreiben wird muss isopen mitgegeben werden was dann hier bei isopen =? aussortiert wird
        Cursor cursor = db.query(
                ToDosEntry.TABLE_TODOS,
                tableColumns,
                selection,
                selectionargs,
                null,
                null,
                sortOrder
        );

        cursor.moveToFirst();

        // Der Cursor überfliegt jede Zeile der Datenbank und schreibt die Werte in die todolist
        while (!cursor.isAfterLast()) {
            ToDos todo = new ToDos();

            todo.setId(cursor.getInt(0));
            todo.setTitle(cursor.getString(1));
            todo.setDescription(cursor.getString(2));
            todo.setDate(cursor.getString(3));
            todo.setPushmessage(cursor.getInt(4) == 0 ? false : true);
            todo.setIsopen(cursor.getInt(5) == 0 ? false : true);

            //  Das ToDo wird der todolist geaddet und der cursor geht eine zeile weiter
            todolist.add(todo);
            cursor.moveToNext();

        }
        return todolist;
    }


    // Hier wird ein ToDo updated, die ID und das isopen bleiben jedoch gleich
    public void updateToDo(Integer id, String title, String description, String date, Integer pushmessage) {

        ContentValues contentValues = new ContentValues();
        contentValues.put(ToDosEntry.TODOS_TITLE, title);
        contentValues.put(ToDosEntry.TODOS_DESCRIPTION, description);
        contentValues.put(ToDosEntry.TODOS_DATE, date);
        contentValues.put(ToDosEntry.TODOS_PUSHMESSAGE, pushmessage);

        String selection = ToDosEntry.TODOS_ID + " =? ";
        String[] selectionargs = new String[] {String.valueOf(id)};

        db.update(
                ToDosEntry.TABLE_TODOS,
                contentValues,
                selection,
                selectionargs
        );

    }

    //Hier wird ein ToDo geschlossen
    public void closeToDo(Integer id) {

        ContentValues contenValues = new ContentValues();
        contenValues.put(ToDosEntry.TODOS_ISOPEN, 0);
        String selection = ToDosEntry.TODOS_ID + " = ?";
        String[] selectionargs = new String[] {String.valueOf(id)};
        db.update(
                ToDosEntry.TABLE_TODOS,
                contenValues,
                selection,
                selectionargs
        );
    }

    //Hier wird ein ToDo geöffnet
    public void reopenToDo(Integer id) {

        ContentValues contentValues = new ContentValues();
        contentValues.put("isopen", 1);
        String selection = ToDosEntry.TODOS_ID + " =?";
        String[] selectionArgs = new String[] {String.valueOf(id)};
        db.update(
                ToDosEntry.TABLE_TODOS,
                contentValues,
                selection,
                selectionArgs
        );
    }

    public ToDos getToDoByID(int id){
        String[] tableColumns = new String[]{ToDosEntry.TODOS_ID, ToDosEntry.TODOS_TITLE, ToDosEntry.TODOS_DESCRIPTION, ToDosEntry.TODOS_DATE, ToDosEntry.TODOS_PUSHMESSAGE, ToDosEntry.TODOS_ISOPEN};

        String selection = ToDosEntry.TODOS_ID + " =?";
        String[] selectionArgs = new String[]{String.valueOf(id)};
        Cursor cursor = db.query(
                ToDosEntry.TABLE_TODOS,
                tableColumns,
                selection,
                selectionArgs,
                null,
                null,
                null
        );


        cursor.moveToFirst();

        ToDos todo = new ToDos();
        todo.setId(id);
        todo.setTitle(cursor.getString(1));
        todo.setDescription(cursor.getString(2));
        todo.setDate(cursor.getString(3));
        todo.setPushmessage(cursor.getInt(4) == 0 ? false : true);
        todo.setIsopen(cursor.getInt(5) == 0 ? false : true);

        return todo;
    }
}
