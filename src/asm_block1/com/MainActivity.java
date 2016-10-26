package asm_block1.com;

import com.navdrawer.SimpleSideDrawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;



public class MainActivity extends Activity implements OnClickListener {
	SimpleSideDrawer slide_me;
	Button btnHienThi;
	ImageView imgMenu,imgThem,imgThuVien;
	TextView txt1,txt2,txt3,txt4,txt5;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	
		txt1 = (TextView) findViewById(R.id.txt1);
		txt2 = (TextView) findViewById(R.id.txt2);
		txt3 = (TextView) findViewById(R.id.txt3);
		txt4 = (TextView) findViewById(R.id.txt4);
		txt5 = (TextView) findViewById(R.id.txt5);
		
		imgMenu = (ImageView) findViewById(R.id.imgMenu);
		imgThem = (ImageView) findViewById(R.id.imgThem);
		imgThuVien = (ImageView) findViewById(R.id.imgThuVien1);
		btnHienThi = (Button) findViewById(R.id.btnHienThi);
		slide_me = new SimpleSideDrawer(this);
		slide_me.setLeftBehindContentView(R.layout.activity_leftmenu);
		
		
		
		imgThuVien.setOnClickListener(this);
		imgThem.setOnClickListener(this);
		btnHienThi.setOnClickListener(this);
		imgMenu.setOnClickListener(this);
		
		txt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(getApplicationContext(),AboutMe.class);
				startActivity(intent);
				
			}
		});

	


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
		if(v==imgMenu){
			slide_me.toggleLeftDrawer();
		}



		
	}
}
