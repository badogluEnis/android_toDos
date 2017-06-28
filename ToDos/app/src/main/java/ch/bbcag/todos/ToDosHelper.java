package ch.bbcag.todos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class ToDosHelper extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "ToDos.db";
    public static final int DATABASE_VERSION = 1;

    public ToDosHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s INTEGER,%s INTEGER)", ToDosEntry.TABLE_TODOS, ToDosEntry.TODOS_ID, ToDosEntry.TODOS_TITLE, ToDosEntry.TODOS_DESCRIPTION, ToDosEntry.TODOS_DATE, ToDosEntry.TODOS_PUSHMESSAGE, ToDosEntry.TODOS_ISOPEN));
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + ToDosEntry.TABLE_TODOS);
            onCreate(db);
        }
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}
