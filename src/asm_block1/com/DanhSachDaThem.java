package asm_block1.com;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;


import Adapter.com.LibraryAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
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
	LibraryDB item;
	List<LibraryDB> ar;
	
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
		
		
		item = new LibraryDB();
	

		
		listViewLibrary.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
	
			
			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
				// TODO Auto-generated method stub
				PopupMenu popup = new PopupMenu(DanhSachDaThem.this, view);
				popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());
				popup.setOnMenuItemClickListener(new OnMenuItemClickListener() {
					
					@Override
					public boolean onMenuItemClick(MenuItem item) {
						// TODO Auto-generated method stub
			
						switch (item.getItemId()) {
						case R.id.xoa:
							deleteDialog(danhmucsach.get(position).getID());
							break;
						case R.id.sua:
							alertDialog(danhmucsach.get(position).getID());
							break;

						default:
							break;
						}
						return false;
					}	
				});
				popup.show();
				return false;
				
				
			}
		
				
		}); // Close setOnItemLongClick
		
	}
	
	// Sửa Dialog
	public void alertDialog(final int id){
		final LibraryDB lib = new LibraryDB();
		Dialog dialogSua;
		dialogSua = new Dialog(getApplicationContext());
		dialogSua.setContentView(R.layout.activity_sua);
		dialogSua.setTitle("Sửa Thông Tin");
		lib.setID(id);
		
		final EditText edtSuaTheLoai;
		final EditText edtSuaTenSach;
		final EditText edtSuaTenTacGia;
		final EditText edtSuaNXB;
		final EditText edtSuaLink;
		Button btnSuaDialog,btnThoatDialog;
		
		edtSuaTheLoai =(EditText) findViewById(R.id.edtSuaTheLoai);
		edtSuaTenSach = (EditText) findViewById(R.id.edtSuaTenSach);
		edtSuaTenTacGia = (EditText) findViewById(R.id.edtSuaTenTacGia);
		edtSuaNXB = (EditText) findViewById(R.id.edtSuaNXB);
		edtSuaLink = (EditText) findViewById(R.id.edtSuaLink);
		btnSuaDialog = (Button) findViewById(R.id.btnSuaDialog);
		btnThoatDialog = (Button) findViewById(R.id.btnThoatDialog);
		
		btnSuaDialog.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				lib.setTheLoai(edtSuaTheLoai.getText().toString());
				lib.setTenSach(edtSuaTenSach.getText().toString());
				lib.setTenTacGia(edtSuaTenTacGia.getText().toString());
				lib.setNXB(edtSuaNXB.getText().toString());
				lib.setLink(edtSuaLink.getText().toString());
				db.updateLibrary(lib);
				danhmucsach=db.GetAllLibraryDB();
				libraryadapter.reloadlist(danhmucsach);
				Toast.makeText(getApplicationContext(), "Sửa Thành Công", Toast.LENGTH_SHORT).show();								
			}
		});
		
		dialogSua.show();
		
	}
	
	//Thông Báo Delete Dialog
	public void deleteDialog(int id){
		AlertDialog.Builder del = new AlertDialog.Builder(getApplicationContext());
		del.setTitle("Thông báo");
		del.setMessage("Bạn có muốn xóa thật không?");
		item.setID(id);
		del.setPositiveButton("Có", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface arg0, int arg1) {
				deleteLibrary(arg1);
				arg0.cancel();
			}
		});
		del.setNegativeButton("Không", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		del.show();
	}
	
	// Hàm xóa trong danh mục sách
	public void deleteLibrary(int id){
		db.deleteLibrary(item);
		danhmucsach = db.GetAllLibraryDB();
		libraryadapter = new LibraryAdapter(getApplicationContext(), R.layout.activity_item,danhmucsach);
		listViewLibrary.setAdapter(libraryadapter);
		Toast.makeText(getApplicationContext(), "Xoa"+item.getID(), Toast.LENGTH_SHORT).show();
	}

}
