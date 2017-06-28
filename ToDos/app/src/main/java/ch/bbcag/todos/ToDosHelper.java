package ch.bbcag.todos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ToDosHelper extends SQLiteOpenHelper {




    public ToDosHelper(Context context) {
        super(context, ToDosEntry.DATABASE_NAME, null, ToDosEntry.DATABASE_VERSION);
    }

    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TODO_TABLE = "CREATA TABLE " + ToDosEntry.TABLE_TODOS + "(" + ToDosEntry.TODOS_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + ToDosEntry.TODOS_TITLE + "TEXT NOT NULL," + ToDosEntry.TODOS_DESCRIPTION + "TEXT," + ToDosEntry.TODOS_DATE + "TEXT," + ToDosEntry.TODOS_PUSHMESSAGE + "INTEGER NOT NULL" + ToDosEntry.TODOS_ISOPEN + "INTEGER NOT NULL" + ")";
        db.execSQL(CREATE_TODO_TABLE);
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
