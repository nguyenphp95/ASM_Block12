package Adapter.com;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import asm_block1.com.R;
import asm_block1.com.Sua;
import model.com.ConnectDB;
import model.com.LibraryDB;

public class LibraryAdapter extends ArrayAdapter<LibraryDB> {
	EditText edtSuaTheLoai,edtSuaTenSach,edtSuaTenTacGia,edtSuaNXB,edtSuaLink;
	TextView txtTheLoai,txtTenSach,txtTenTacGia,txtNXB,txtLink;
//	Button btnxoa,btnSuaNoiDung,btnSuaDialog;
	Button btnSuaDialog;
	List<LibraryDB> ar;
	LibraryDB item;
	public LibraryAdapter(Context context, int resource, List<LibraryDB> objects) { // Hoi thay???
		super(context, resource, objects);
		ar=objects;
	}
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = convertView;
		LayoutInflater inflater = LayoutInflater.from(getContext());
		view = inflater.inflate(R.layout.activity_item, null);
		
		item = new LibraryDB();
		item = ar.get(position);
		
		edtSuaTheLoai = (EditText) view.findViewById(R.id.edtSuaTheLoai);
		edtSuaTenSach = (EditText) view.findViewById(R.id.edtSuaTenSach);
		edtSuaTenTacGia = (EditText) view.findViewById(R.id.edtSuaTenTacGia);
		edtSuaNXB = (EditText) view.findViewById(R.id.edtSuaNXB);
		edtSuaLink = (EditText) view.findViewById(R.id.edtSuaLink);
		
		
		txtTheLoai= (TextView) view.findViewById(R.id.txtSuaNXB);
		txtTenSach = (TextView) view.findViewById(R.id.txtTenSach);
		txtTenTacGia = (TextView) view.findViewById(R.id.txtTenTacGia);
		txtNXB = (TextView) view.findViewById(R.id.txtNXB);
		txtLink = (TextView) view.findViewById(R.id.txtLink);
//		btnxoa = (Button) view.findViewById(R.id.btnxoa);
//		btnSuaNoiDung = (Button) view.findViewById(R.id.btnSuaNoiDung);
	
		
		txtTheLoai.setText(item.getTheLoai());
		txtTenSach.setText(item.getTenSach());
		txtTenTacGia.setText(item.getTenTacGia());
		txtNXB.setText(item.getNXB());
		txtLink.setText(item.getLink());
//		btnxoa.setOnClickListener(new View.OnClickListener() {
			
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				ConnectDB db=new ConnectDB(getContext());
//				LibraryDB lb=new LibraryDB();
//				lb.setID(item.getID());
//				db.deleteLibrary(lb);
//				Toast.makeText(getContext(), "Xóa"+item.getID(), Toast.LENGTH_SHORT).show();
//			}
//		});		
		return view;
	}
	
	public void reloadlist(ArrayList<LibraryDB> newlist){ //Reload lại dữ liệu sau khi đã xóa
		ar=newlist;
		notifyDataSetChanged();
	}
	

}
