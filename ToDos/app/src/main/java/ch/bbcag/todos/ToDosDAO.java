package ch.bbcag.todos;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ToDosDAO {

    private SQLiteDatabase db;
    private ToDosHelper dbHelper;
    Integer id;

    public ToDosDAO(Context context) {
        db = dbHelper.getInstance(context).getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public void createToDo(String title, String description, String date, Integer pushmessage, Integer isopen) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("description", description);
        contentValues.put("date", date);
        contentValues.put("pushmessage", pushmessage);
        contentValues.put("isopen", isopen);

        db.insert("ToDos", null, contentValues);
    }

    public void deleteToDo(int todoId) {
        db.delete("ToDos", "id = " + todoId, null);
    }

    public List<ToDos> getToDos(Integer isopen) {
        List<ToDos> todolist = new ArrayList<ToDos>();

        String[] tableColumns = new String[]{"id", "title", "description", "date", "pushmessage", "isopen"};

        Cursor cursor = db.query("ToDos", tableColumns, "isopen" + "=?", new String[] {isopen.toString()}, null, null, null);

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            ToDos todo = new ToDos();


            todo.setTODOS_TITLE(cursor.getString(1));
            todo.setTODOS_DESCRIPTION(cursor.getString(2));
            todo.setTODOS_DATE(cursor.getString(3));
            todo.setTODO_PUSHMESSAGE(cursor.getString(4));
            todo.setTODOS_ISOPEN(cursor.getString(5));

            todolist.add(todo);

            cursor.moveToNext();

        }
        return todolist;
    }



    public void updateToDo(Integer id, String title, String description, String date, Integer pushmessage, Integer isopen) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("description", description);
        contentValues.put("date", date);
        contentValues.put("pushmessage", pushmessage);
        contentValues.put("isopen", isopen);

        db.update("ToDos", contentValues, "id =?", new String[] {id.toString()});

    }

    public void updateIsOpen(Integer id){
        ContentValues contenValues = new ContentValues();
        contenValues.put("isopen", 0);
        db.update("ToDos",contenValues, "id =?", new String[] {id.toString()});
    }




}
