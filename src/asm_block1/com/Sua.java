package asm_block1.com;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class Sua extends Activity{
	Button btnSuaDialog,btnThoatDialog;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sua);
		btnSuaDialog = (Button) findViewById(R.id.btnSuaDialog);
		btnThoatDialog = (Button) findViewById(R.id.btnThoatDialog);
		
	}

}
