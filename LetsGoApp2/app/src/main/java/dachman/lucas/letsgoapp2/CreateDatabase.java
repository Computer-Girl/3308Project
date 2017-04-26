package dachman.lucas.letsgoapp2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
/**
 * Created by Jasmine on 4/3/2017.
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
            COLUMN_STAR + " integer , " +
            COLUMN_LOCATION + "text );";

    public CreateDatabase(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database){
        database.execSQL(DATABASE_CREATE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        Log.w(CreateDatabase.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_EVENTS);
        onCreate(db);
    }

    //ADDED**********

    //star repo JR 4/8

    public boolean UpdateDatabaseStar (String id)
    {
        SQLiteDatabase star_db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        String Query = "Select * from " + TABLE_EVENTS + " where " + COLUMN_ID + " = " + id + " AND " + COLUMN_STAR + " = " + 0;
        Cursor cursor = star_db.rawQuery(Query, null);
        if(cursor.getCount() == 1){
            values.put(COLUMN_STAR, id);
            values.put(COLUMN_STAR, 1);
            star_db.update(TABLE_EVENTS,values,"id = ?", new String[] {id});
            cursor.close();
            return true;
        }

        return false;

    }
}