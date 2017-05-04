package dachman.lucas.letsgoapp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Nihar on 4/3/2017.
 * Java code that connects and establishes local database for app
 */

public class CreateDatabase extends SQLiteOpenHelper{

    public static final String TABLE_EVENTS = "events";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_ORGANIZER = "organizer";
    public static final String COLUMN_CATEGORY = "category";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_DATE = "date";
    public static final String COLUMN_STAR = "star";
    public static final String COLUMN_LOCATION = "location";
    public static final String COLUMN_TEMP = "temp" ;

    private static final String DATABASE_NAME = "events.db";
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_CREATE = "create table "
            + TABLE_EVENTS + "( " +
            COLUMN_ID + " integer primary key autoincrement, " +
            COLUMN_NAME + " text , " +
            COLUMN_ORGANIZER + " text, " +
            COLUMN_CATEGORY + " text , " +
            COLUMN_DESCRIPTION + " text , " +
            COLUMN_DATE + " text , " +
            COLUMN_LOCATION + " text , " +
            COLUMN_STAR + "integer , " +
            COLUMN_TEMP + " text );";

    private static final String DATABASE_DELETE = "drop table" + TABLE_EVENTS ;

    /**
     *
     * @param context
     * creates the context for DB
     */
    public CreateDatabase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /**
     *
     * @param database
     * creates/delete DB
     */
    @Override
    public void onCreate(SQLiteDatabase database){
        //database.execSQL(DATABASE_DELETE);
        database.execSQL(DATABASE_CREATE);

    }
    /**
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     * upgrades DB once user logins if it doesn't exist
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w(CreateDatabase.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_EVENTS);
        onCreate(db);
    }

    /**
     * star repo created by Jasmine 4/8
     */
    /**
     * @param id
     * @return boolean
     * this function queries out to the database to fill in the binary
     * field for column_star when a suer favorites an event
     */
    public int UpdateDatabaseStar (String id,String name)
    {
        SQLiteDatabase star_db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        //Just testing with switching Name in db
        //tried with COLUMN_STAR and gave it 1 and it didn't work either
        //values.put(COLUMN_NAME, "jasmine");
        String[] whereArgs = {name};
        int co = star_db.update(TABLE_EVENTS, values, COLUMN_NAME +"=?",whereArgs);

        return co ;


    }
}
