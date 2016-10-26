package asm_block1.com;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

public class ThuVien extends Activity implements OnClickListener {
	ImageView imgBack,imgBoGia;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_thuvien);
		imgBack = (ImageView) findViewById(R.id.imgBack);
		imgBoGia = (ImageView) findViewById(R.id.imgBoGia);
		
		imgBack.setOnClickListener(this);
		imgBoGia.setOnClickListener(this);
		
	}

	@Override
	public void onClick(View v) {
		if (v==imgBack) {
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
		}
		if (v==imgBoGia) {
			Intent intent = new Intent(this,Webview_BoGia.class);
			startActivity(intent);
		}
		
		
	}
}
