package model.com;

import java.util.ArrayList;



import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class ConnectDB extends SQLiteOpenHelper {

	private static final int  Data_Version=1;
	private static final String Data_Name="QuanLyThuVien";
	private static final String Table_Library="LibraryPoly";
	private static final String Library_ID ="ID";
	private static final String Library_TheLoai ="TheLoai";
	private static final String Library_TenSach ="TenSach";
	private static final String Library_TenTacGia ="TenTacGia";
	private static final String Library_NhaXuatBan ="NXB";
	private static final String Library_Link ="Link";
	
	
	public ConnectDB(Context context) {
		super(context,Data_Name, null,Data_Version);

	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String Create_Table_Library = "CREATE TABLE " + Table_Library + "(" 
				+ Library_ID + " INTEGER PRIMARY KEY ,"
				+ Library_TheLoai + " TEXT ," 
				+ Library_TenSach + " TEXT ,"
				+ Library_TenTacGia + " TEXT ,"
				+ Library_NhaXuatBan + " TEXT ,"
				+ Library_Link + " TEXT)";
		db.execSQL(Create_Table_Library);
		
	}
	public void addLibrary(LibraryDB librarydb){
		SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(Library_TheLoai, librarydb.getTheLoai());
		values.put(Library_TenSach, librarydb.getTenSach());
		values.put(Library_TenTacGia, librarydb.getTenTacGia());
		values.put(Library_NhaXuatBan, librarydb.getNXB());
		values.put(Library_Link, librarydb.getLink());
		sqLiteDatabase.insert(Table_Library, null, values);
		sqLiteDatabase.close();
	}
	public void updateLibrary(LibraryDB librarydb){
		SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(Library_TheLoai, librarydb.getTheLoai());
		values.put(Library_TenSach, librarydb.getTenSach());
		values.put(Library_TenTacGia, librarydb.getTenTacGia());
		values.put(Library_NhaXuatBan, librarydb.getNXB());
		values.put(Library_Link, librarydb.getLink());
		String cautruyvan = Library_ID +" = ? ";
		sqLiteDatabase.update(Table_Library, values, cautruyvan, new String []{String.valueOf(librarydb.getID())});
		sqLiteDatabase.close();
	}
	public void deleteLibrary(LibraryDB librarydb){
		SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
		int test=sqLiteDatabase.delete(Table_Library, Library_ID + " = ? ",new String []{String.valueOf(librarydb.getID())});
		sqLiteDatabase.close();
	}
	//Lấy hết tất cả thông tin ra để show vào ListView
	public ArrayList<LibraryDB> GetAllLibraryDB(){
		ArrayList<LibraryDB> dsThuVien = new ArrayList<LibraryDB>();
		String cautruyvan = "SELECT * FROM "+Table_Library;
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor cursor = db.rawQuery(cautruyvan, null);
		if(cursor.moveToFirst()){
			do{
				LibraryDB thuvien = new LibraryDB();
				thuvien.setID(cursor.getInt(0));
				thuvien.setTheLoai(cursor.getString(1));
				thuvien.setTenSach(cursor.getString(2));
				thuvien.setTenTacGia(cursor.getString(3));
				thuvien.setNXB(cursor.getString(4));
				thuvien.setLink(cursor.getString(5));
				dsThuVien.add(thuvien); 
			}while(cursor.moveToNext());
		}	
		return dsThuVien;
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {	
		db.execSQL("DROP IF EXISTS "+ Table_Library);
	}

}
