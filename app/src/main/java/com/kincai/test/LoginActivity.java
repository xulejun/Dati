package com.kincai.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kincai.db.User;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.SaveListener;

/**
 * 登录界面
 * @author kincai
 *
 */
public class LoginActivity extends Activity implements View.OnClickListener {
	private Button login;
	private Button register;
	private EditText username,passwor;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//没标题栏
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.login);
		findViewId();
		listener();
	}
	
	private void findViewId() {
		login = (Button) findViewById(R.id.login_activity_login);
		register= (Button) findViewById(R.id.login_activity_register);
		username = (EditText) findViewById(R.id.username);
		passwor = (EditText) findViewById(R.id.password);
		register.setOnClickListener(this);
	}

	@Override
	public void onClick(View view) {
		switch (view.getId()){
			case R.id.login_activity_register:
				Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
				startActivity(intent);
				break;
		}
	}

	private void listener() {
		login.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String name = username.getText().toString().trim();
				String pass = passwor.getText().toString().trim();

				if(!name.trim().equals("")&&!pass.trim().equals("")) {

				//登录
					User user=new User();
					user.setUsername(name);
					user.setPassword(pass);
					user.login(getApplicationContext(), new SaveListener() {
						@Override
						public void onSuccess() {
							Toast.makeText(getApplicationContext(),"登录成功！",Toast.LENGTH_SHORT).show();

							startActivity(new Intent(LoginActivity.this,MainActivity.class));
						}
						@Override
						public void onFailure(int i, String s) {
							Toast.makeText(getApplicationContext(),"登录失败！"+s.toString(),Toast.LENGTH_SHORT).show();
						}
					});


					} else {
						Toast.makeText(getApplicationContext(),"输入为空！", Toast.LENGTH_SHORT).show();
					}
			}
		});
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {  
			finish();
		    return true;  
	      }  
		 return super.onKeyDown(keyCode, event);
	}
}
