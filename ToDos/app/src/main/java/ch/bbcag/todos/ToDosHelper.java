package ch.bbcag.todos;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ToDosHelper extends SQLiteOpenHelper {

    private static ToDosHelper Instance;

    private static final String DATABASE_NAME = "ToDos.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_TODOS = "ToDos";

    private static final String TODOS_ID = "id";
    private static final String TODOS_TITLE = "title";
    private static final String TODOS_DESCRIPTION = "description";
    private static final String TODOS_DATE = "date";
    private static final String TODOS_PUSHMESSAGE = "pushmessage";

    public static synchronized ToDosHelper getInstance(Context context) {
        if (Instance == null) {
            Instance = new ToDosHelper(context.getApplicationContext());
        }
        return Instance;
    }


    private ToDosHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TODO_TABLE = "CREATA TABLE " + TABLE_TODOS + "(" + TODOS_ID + "INTEGER PRIMARY KEY AUTOINCREMENT," + TODOS_TITLE + "TEXT NOT NULL," + TODOS_DESCRIPTION + "TEXT," + TODOS_DATE + "TEXT," + TODOS_PUSHMESSAGE + "INTEGER NOT NULL" + ")";
        db.execSQL(CREATE_TODO_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion != newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_TODOS);
            onCreate(db);
        }
    }

    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}
