package asm_block1.com;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;


public class Webview_BoGia extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_webview_bogia);
		
		String doc="https://drive.google.com/file/d/0B8vvzRFgLI0VTW1PNndQM09wdGc/view?usp=sharing";
		WebView wv= (WebView) findViewById(R.id.wvBoGia);
		
		wv.getSettings().setJavaScriptEnabled(true);
		wv.getSettings().setAllowFileAccess(true);
		wv.getSettings().setLoadsImagesAutomatically(true);
		
		wv.loadUrl(doc);
	}

}
