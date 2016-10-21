package asm_block1.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.*;
import android.widget.Toast;


public class MainActivity extends Activity implements OnClickListener {
	Button btnHienThi;
	ImageView imgMenu,imgThem,imgThuVien;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		imgThem = (ImageView) findViewById(R.id.imgThem);
		imgThuVien = (ImageView) findViewById(R.id.imgThuVien);
		btnHienThi = (Button) findViewById(R.id.btnHienThi);
		
		
		
		imgThuVien.setOnClickListener(this);
		imgThem.setOnClickListener(this);
		btnHienThi.setOnClickListener(this);


	}
	@Override
	public void onClick(View v) {
		if (v==imgThem) {
			Intent intent = new Intent(MainActivity.this,ThemSach.class);
			startActivity(intent);
		}
		if (v==imgThuVien) {
			Intent intent = new Intent(this,ThuVien.class);
			startActivity(intent);
		}
		if(v==btnHienThi){
			try {
				Intent intent = new Intent(getApplicationContext(),DanhSachDaThem.class);
				startActivity(intent);
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(), "Loi"+e.getMessage(), Toast.LENGTH_LONG).show();
				
			}

		}
		
	}
}
