package com.example.app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class FoodDB extends SQLiteOpenHelper {
    public static final String DB_NAME = "OrderFood.db";
    public static final int DB_VERSION = 1;
    public static final String TB_NAME = "food";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String DESCRIPTION = "description";
    public static final String PICTURE = "picture";
    public static final String PRICE = "price";
    Context context;

    public FoodDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //Write the creation table query
        String sql = "CREATE TABLE " + TB_NAME +
                " ("
                + ID + " INTEGER PRIMARY KEY, "
                + NAME + " TEXT, "
                + DESCRIPTION + " TEXT, "
                + PICTURE + " INTEGER, "
                + PRICE + " INTEGER)";
        //excute sql statement
        db.execSQL(sql);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TB_NAME);
        onCreate(db);
    }

    public int getDbCount() {
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM " + TB_NAME, null);
        return cursor.getCount();
    }

    public void initData() {
        //Check database has data
        int count = getDbCount();
        if(count == 0) {

            //create data
            Food food1 = new Food("Bún giò", "Giò lụa, bún, rau sống, nước mắm, mỡ hành, hành lá, hành khô, hành ngâm, đậu phộng, chả, mướp đắng, rau sống, mè rang, tỏi, chanh, ớt, gia vị, nước mắm, tiêu, hành phi.", R.drawable.bun_gio, 25000);
            Food food2 = new Food("Cá rán", "Cá rán là món ăn nổi tiếng, cá được chiên giòn, ngoài giòn, trong mềm, thường được chế biến với gia vị hấp dẫn, có hương vị đậm đà và thơm ngon.", R.drawable.ca_ran, 30000);
            Food food3 = new Food("Chả nem", "Thịt heo, tôm, nấm mèo, bún tàu, hành, tỏi, bột năng, nước mắm, đường, muối, tiêu, trứng, bánh tráng, lá chuối, dừa, rau sống, dưa leo, giá đỗ, ngò gai, hành phi.", R.drawable.cha_nem, 40000);
            Food food4 = new Food("Cuốn", "Bánh tráng, thịt heo hoặc tôm, bún tàu, rau sống, dưa leo, giá đỗ, ngò gai, hành, tỏi, mỡ heo, nước mắm, đường, muối, tiêu, hành phi, mè rang, chả, trứng, dừa, bắp chuối.", R.drawable.cuon, 25000);
            Food food5 = new Food("Gà luộc", "Gà luộc là món ăn đơn giản nhưng ngon miệng, gà được luộc chín mềm, thịt mềm mịn, ngọt ngào, thường được dùng kèm nước mắm gừng, hành, tỏi.", R.drawable.ga_luoc, 150000);
            Food food6 = new Food("Hải sản", "Tôm , hàu, ốc biển được kết hợp với nhau trong 1 món hấp, món ăn được chế biến trực tiếp tại quán, hải sản tươi sống được lấy từ vùng biển Hạ Long thân yêu", R.drawable.hai_san_hap, 250000);
            Food food7 = new Food("Lẩu", "Nước lẩu, thịt bò hoặc thịt gà, hải sản (tôm, mực, cá...), rau sống, nấm, đậu hũ, bắp cải, bông cải xanh, hành, tỏi, gừng, hành tây, gia vị, mì hoặc bún, trứng, mỡ heo, bột ngọt, tiêu, nước mắm, hành phi.", R.drawable.lau, 259000);
            Food food8 = new Food("Nuộm", "Nuộm là một món ăn truyền thống của miền Trung Việt Nam, thành phần thường gồm thịt heo, thịt bò hoặc gà, nước mắm, đường, muối, tiêu, tỏi, ớt, lá chanh, rau sống, bún, bánh tráng, hành, ớt, hành tây, dứa, ngò gai, mắm tôm, mỡ heo, gia vị.", R.drawable.nuom, 30000);
            Food food9 = new Food("Nướng", "Thịt nướng là món ăn truyền thống, thịt được chiên hoặc nướng đến khi chín, có mùi thơm hấp dẫn, vị ngọt mặn, mềm mịn. Thường được ướp gia vị như tỏi, hành, ớt, muối, tiêu, nước mắm, đường.", R.drawable.nuong, 100000);

        }
    }
    public long insFood(Food food) {
        ContentValues values = new ContentValues();
        values.put(NAME, food.getName());
        values.put(DESCRIPTION, food.getDescription());
        values.put(PICTURE, food.getResourceIdPicture());
        values.put(PRICE, food.getPrice());
        //Executing insert data;
        return this.getWritableDatabase().insert(TB_NAME, null, values);
    }

    //query data from database
    public List<Food> getData() {
        List<Food> foods = new ArrayList<Food>();
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM " + TB_NAME, null);

        //traversal
        if(cursor.getCount() > 0) {
            if(cursor.moveToFirst()) {
                do {
                    Food food = new Food();
                    food.setId(cursor.getInt(0));
                    food.setName(cursor.getString(1));
                    food.setDescription(cursor.getString(2));
                    food.setResourceIdPicture(cursor.getInt(3));
                    food.setPrice(cursor.getInt(4));
                } while (cursor.moveToNext());
            }
        }
        cursor.close();
        return foods;
    }
}
