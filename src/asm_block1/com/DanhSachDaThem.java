package asm_block1.com;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;


import Adapter.com.LibraryAdapter;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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

public class DanhSachDaThem extends Activity implements OnClickListener {
	ListView listViewLibrary;
	ArrayList<LibraryDB> danhmucsach = null;
	LibraryAdapter libraryadapter;
	ConnectDB db;
	LibraryDB item;
	List<LibraryDB> ar;
	ImageView imgBack,imgAdd;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_danhsachdathem);
		imgBack = (ImageView) findViewById(R.id.imgBack);
		imgAdd = (ImageView) findViewById(R.id.imgAdd);
		
		imgBack.setOnClickListener(this);
		imgAdd.setOnClickListener(this);
		
		
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
		try {
			final LibraryDB lib = new LibraryDB();
			final Dialog dialogSua;
			dialogSua = new Dialog(DanhSachDaThem.this);
			dialogSua.setContentView(R.layout.activity_sua);
			dialogSua.setTitle("Sửa Thông Tin");
			lib.setID(id);
			
			final EditText edtSuaTheLoai;
			final EditText edtSuaTenSach;
			final EditText edtSuaTenTacGia;
			final EditText edtSuaNXB;
			final EditText edtSuaLink;
			final Button btnSuaDialog;
			Button btnThoatDialog;
			dialogSua.show();
			
			edtSuaTheLoai =(EditText) dialogSua.findViewById(R.id.edtSuaTheLoai);
			edtSuaTenSach = (EditText) dialogSua.findViewById(R.id.edtSuaTenSach);
			edtSuaTenTacGia = (EditText) dialogSua.findViewById(R.id.edtSuaTenTacGia);
			edtSuaNXB = (EditText) dialogSua.findViewById(R.id.edtSuaNXB);
			edtSuaLink = (EditText) dialogSua.findViewById(R.id.edtSuaLink);
			btnSuaDialog = (Button) dialogSua.findViewById(R.id.btnSuaDialog);
			btnThoatDialog = (Button) dialogSua.findViewById(R.id.btnThoatDialog);
//			Dua du lieu len control
			LibraryDB lb = db.GetLibraryDB(id);
			edtSuaTheLoai.setText(lb.getTheLoai());
			edtSuaTenSach.setText(lb.getTheLoai());
			edtSuaTenTacGia.setText(lb.getTenTacGia());
			edtSuaNXB.setText(lb.getNXB());
			edtSuaLink.setText(lb.getLink());
			
			
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
			btnThoatDialog = (Button) dialogSua.findViewById(R.id.btnThoatDialog);
			btnThoatDialog.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					dialogSua.dismiss();
				}
			});
			
			
			
		} catch (Exception e) {
			// TODO: handle exception
			Toast.makeText(getApplicationContext(), "Thông Báo Lỗi"+e.getMessage(), Toast.LENGTH_LONG).show();
		}
		
		
	}
	
	//Thông Báo Delete Dialog
	
	public void deleteDialog(int id){
		try {
			AlertDialog.Builder del = new AlertDialog.Builder(DanhSachDaThem.this);
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
		} catch (Exception e) {
			Toast.makeText(getApplicationContext(), "Thông báo xóa"+e.getMessage(), Toast.LENGTH_LONG).show();
		}
		
	}
	
	// Hàm xóa trong danh mục sách
	public void deleteLibrary(int id){
		db.deleteLibrary(item);
		danhmucsach = db.GetAllLibraryDB();
		libraryadapter = new LibraryAdapter(getApplicationContext(), R.layout.activity_item,danhmucsach);
		listViewLibrary.setAdapter(libraryadapter);
		Toast.makeText(getApplicationContext(), "Xoa"+item.getID(), Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onClick(View v) {
		if (v==imgBack) {		
				Intent intent = new Intent(this,MainActivity.class);
				startActivity(intent);
		}
		if (v==imgAdd) {
				Intent intent = new Intent(this,ThemSach.class);
				startActivity(intent);
			
		}
		
	}

}
