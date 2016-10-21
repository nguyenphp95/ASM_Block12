package asm_block1.com;

import java.util.ArrayList;
import java.util.zip.Inflater;

import Adapter.com.LibraryAdapter;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.PopupMenu.OnMenuItemClickListener;
import model.com.ConnectDB;
import model.com.LibraryDB;

public class DanhSachDaThem extends Activity {
	ListView listViewLibrary;
	ArrayList<LibraryDB> danhmucsach = null;
	LibraryAdapter libraryadapter;
	ConnectDB db;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_danhsachdathem);
			db = new ConnectDB(this);
			listViewLibrary = (ListView) findViewById(R.id.listViewLibrary);
			final LibraryDB thuvien = new LibraryDB();
			
		try{		
			//Nhận các gói với tên tương ứng sau khi nhấn nút btnThem
			String tentacgia = getIntent().getExtras().getString("TenTacGia");
			String nhaxuatban = getIntent().getExtras().getString("NXB");
			String Link= getIntent().getExtras().getString("Link");
			String TheLoai= getIntent().getExtras().getString("TheLoai");
			String TenSach = getIntent().getExtras().getString("TenSach");
			
			//Set vào đối tượng "thuvien"
			thuvien.setTheLoai(TheLoai);
			thuvien.setTenSach(TenSach);
			thuvien.setTenTacGia(tentacgia);
			thuvien.setNXB(nhaxuatban);
			thuvien.setLink(Link);
			//Thêm vào đối tượng "thuvien"
			db.addLibrary(thuvien);
		}catch(Exception e){}
		//Hiển thị các mục sau khi đã thêm vào đối tượng "thuvien"
		danhmucsach=db.GetAllLibraryDB();
		libraryadapter = new LibraryAdapter(getApplicationContext(), R.layout.activity_item, danhmucsach);
		listViewLibrary.setAdapter(libraryadapter);
		
		listViewLibrary.setOnItemLongClickListener(new OnItemLongClickListener() {
			
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				PopupMenu popup = new PopupMenu(DanhSachDaThem.this, view);
				popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
				popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						// TODO Auto-generated method stub
						Toast.makeText(getApplicationContext(), "Thông Báo" + item.getTitle(), Toast.LENGTH_SHORT).show();
						return false;
					}	
				});
				return false;
//				try {
//					popup.show();
//				} catch (Exception e) {
//					Toast.makeText(DanhSachDaThem.this, e.getMessage().toString(), Toast.LENGTH_SHORT).show();
//				}
				
			}
		
				
		}); // Close setOnItemLongClick
		
	}
//	public void alertDialog(final int id){
//		final LibraryDB lib = new LibraryDB();
//		Dialog dialogSua;
//		dialogSua = new Dialog(getApplicationContext());
//		dialogSua.setContentView(R.layout.activity_sua);
//		dialogSua.setTitle("Sửa Thông Tin");
//		lib.setID(id);
//		
//		final EditText edtSuaTheLoai;
//		final EditText edtSuaTenSach;
//		final EditText edtSuaTenTacGia;
//		final EditText edtSuaNXB;
//		final EditText edtSuaLink;
//		Button btnSuaDialog,btnThoatDialog;
//		
//		edtSuaTheLoai =(EditText) findViewById(R.id.edtSuaTheLoai);
//		edtSuaTenSach = (EditText) findViewById(R.id.edtSuaTenSach);
//		edtSuaTenTacGia = (EditText) findViewById(R.id.edtSuaTenTacGia);
//		edtSuaNXB = (EditText) findViewById(R.id.edtSuaNXB);
//		edtSuaLink = (EditText) findViewById(R.id.edtSuaLink);
//		btnSuaDialog = (Button) findViewById(R.id.btnSuaDialog);
//		btnThoatDialog = (Button) findViewById(R.id.btnThoatDialog);
//		
//		btnSuaDialog.setOnClickListener(new View.OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				lib.setTheLoai(edtSuaTheLoai.getText().toString());
//				lib.setTenSach(edtSuaTenSach.getText().toString());
//				lib.setTenTacGia(edtSuaTenTacGia.getText().toString());
//				lib.setNXB(edtSuaNXB.getText().toString());
//				lib.setLink(edtSuaLink.getText().toString());
//				db.updateLibrary(lib);
//				danhmucsach=db.GetAllLibraryDB();
//				libraryadapter.reloadlist(danhmucsach);
//				Toast.makeText(getApplicationContext(), "Sửa Thành Công", Toast.LENGTH_SHORT).show();								
//			}
//		});
//		
//		dialogSua.show();
//		
//	}
	
	
}
