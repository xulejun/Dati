package com.kincai.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
/**
 * 帮助页
 * @author kincai
 *
 */
public class helpActivity extends Activity {
	private ImageButton help;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//没有标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.help);
		help = (ImageButton) findViewById(R.id.help_back);
		help.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				helpActivity.this.finish();
			}
		});
	}
	
	//返回键
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
		if(keyCode == KeyEvent.KEYCODE_BACK) {
			helpActivity.this.finish();
			return true;
		}
		return super.onKeyDown(keyCode, event);
	}
}
