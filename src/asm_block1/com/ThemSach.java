package asm_block1.com;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

public class ThemSach extends Activity implements OnClickListener {
	//Khai báo các đối tượng cần tương tác
	EditText edtTacGia,edtLink,edtNXB,edtTenSach;
	Spinner spinner1;
	Button btnThem;
	ImageView imgBack;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_themsach);
		//Set id cho từng đối tượng đã khai báo ở trên
		btnThem = (Button) findViewById(R.id.btnThem);	
		
		imgBack = (ImageView) findViewById(R.id.imgBack);
		
		edtTacGia = (EditText) findViewById(R.id.edtTacGia);
		edtLink = (EditText) findViewById(R.id.edtLink);
		edtNXB = (EditText) findViewById(R.id.edtSuaNXB);
		edtTenSach = (EditText) findViewById(R.id.edtTenSach);
		
		spinner1 = (Spinner) findViewById(R.id.spinner1);

		
		
		btnThem.setOnClickListener(this);
		imgBack.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v==imgBack) {
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
		}
		if (v==btnThem) {
			Intent intent = new Intent(this,DanhSachDaThem.class);
			intent.putExtra("TenTacGia",edtTacGia.getText().toString());
			intent.putExtra("NXB",edtNXB.getText().toString());
			intent.putExtra("Link", edtLink.getText().toString());
			intent.putExtra("TenSach", edtTenSach.getText().toString());
			intent.putExtra("TheLoai", spinner1.getSelectedItem().toString());
			startActivity(intent);
			Toast.makeText(getApplicationContext(),"Thêm thành công", Toast.LENGTH_LONG).show();
		}
		
	}

}
