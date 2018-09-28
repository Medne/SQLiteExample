package com.example.medine.ogrencikayt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {

    private static final int DATABASE_VERSİON=1;

    private static final String DATABASE_NAME ="sqllite_database";

    private static final String TABLE_NAME="ogrenci_kayit";

    private static String AD_SOYAD="ad_soyad";

    private static String ADRES="adres";

    private static String EMAİL="email";

    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSİON);
    }




    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + AD_SOYAD + " TEXT,"
                + ADRES + " TEXT,"
                + EMAİL + " TEXT" + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


    public void ogrenciEkle(String ogrenci_adı, String adres,String email) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(AD_SOYAD, ogrenci_adı);
        values.put(ADRES, adres);
        values.put(EMAİL, email);



        long r=db.insert(TABLE_NAME,null,values);//Tabloya ekleme yaptığımız fonksiyon.
        if(r>-1)
            Log.i("tag","İşlem Başarılı");//ekleme olması durumunda bu çıktıyı verir.
        else
            Log.e("tag","İşlem Başarısız");//ekleme olmaması durumunda bu çıktıyı verir.

        db.close(); //Database Bağlantısını kapattık*/
    }


    public List<String> veriListele(){
        List<String> veriler=new ArrayList<String>();//String türünde bir liste oluşturduk.
        SQLiteDatabase db=this.getWritableDatabase();//SQLiteDatabase sınıfında yazılabilir bağlantı açıyoruz.
        String[] sutunlar={AD_SOYAD,ADRES,EMAİL};
        Cursor cr=db.query(TABLE_NAME,sutunlar,null,null,null,null,null);//query fonksiyonu ile aldığımız parametreler yoluyla komutu kendi içerisinde yapılandırıyoruz.
        while(cr.moveToNext()){//sırasıyla verileri listelememizi sağlıyor.
            veriler.add(cr.getString(0)+"  "+cr.getString(1)+"   "+cr.getString(2  ));

        }
        return veriler;
    }





}
