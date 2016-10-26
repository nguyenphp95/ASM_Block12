package asm_block1.com;

import com.navdrawer.SimpleSideDrawer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;



public class MainActivity extends Activity{
	SimpleSideDrawer slide_me;
	ImageView imgMenu,imgThem,imgThuVien,imgHienThi,imgAboutMe;
	TextView txt1,txt4,txt3;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		imgMenu = (ImageView) findViewById(R.id.imgMenu);
		imgThuVien = (ImageView) findViewById(R.id.imgThuVien1);
		imgHienThi = (ImageView) findViewById(R.id.imgHienThi);
		imgAboutMe = (ImageView) findViewById(R.id.imgAboutMe);
		slide_me = new SimpleSideDrawer(this);
		slide_me.setLeftBehindContentView(R.layout.activity_leftmenu);
		txt4 = (TextView) findViewById(R.id.txt4);
		txt1 = (TextView) findViewById(R.id.txt1);
		txt3 = (TextView) findViewById(R.id.txt3);
		imgThem = (ImageView) findViewById(R.id.imgThem);
		
		
		

		imgThem.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),ThemSach.class);
				startActivity(intent);
			}
		});
		
		
		imgAboutMe.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),AboutMe.class);
				startActivity(intent);
				
			}
		});
		
		imgMenu.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				slide_me.toggleLeftDrawer();
				
			}
		});
		
		imgHienThi.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),DanhSachDaThem.class);
				startActivity(intent);			
			}
		});
		
		imgThuVien.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),ThuVien.class);
				startActivity(intent);
			}
		});
		
		txt4.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),AboutMe.class);
				startActivity(intent);
				
			}
		});
		
		txt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),MainActivity.class);
				startActivity(intent);
				
			}
		});
		
		txt3.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(getApplicationContext(),ThuVien.class);
				startActivity(intent);
				
			}
		});
		

	}
//	@Override
//	public void onClick(View v) {		
//		if(v==imgThem){
//			Intent intent = new Intent(getApplicationContext(),ThemSach.class);
//			startActivity(intent);
//		}
//		if (v==imgThuVien) {
//			Intent intent = new Intent(this,ThuVien.class);
//			startActivity(intent);
//		}
//		if(v==imgHienThi){
//			try {
//				Intent intent = new Intent(getApplicationContext(),DanhSachDaThem.class);
//				startActivity(intent);
//			} catch (Exception e) {
//				Toast.makeText(getApplicationContext(), "Loi"+e.getMessage(), Toast.LENGTH_LONG).show();
//				
//			}
//		}
//		if(v==imgMenu){
//			slide_me.toggleLeftDrawer();
//		}
//		if (v==imgAboutMe) {
//			Intent intent = new Intent(getApplicationContext(),AboutMe.class);
//			startActivity(intent);
//		}		
//	}
}
