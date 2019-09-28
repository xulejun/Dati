package com.kincai.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.kincai.db.User;

import cn.bmob.v3.listener.SaveListener;

/**
 * Created by XLJ on 2019/9/23.
 */

public class RegisterActivity extends Activity implements View.OnClickListener {

    private EditText text1,text2,text3;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        initView();
    }

    private void initView() {

        text1= (EditText) findViewById(R.id.edit_1);
        text2= (EditText) findViewById(R.id.edit_2);
        text3= (EditText) findViewById(R.id.edit_3);
        button= (Button) findViewById(R.id.btn_1);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_1:
                String name=text1.getText().toString().trim();
                String password=text2.getText().toString().trim();
                String edPassword=text3.getText().toString().trim();

                if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(password)&&!TextUtils.isEmpty(edPassword)){

                    if (password.equals(edPassword)){

                        //注册
                        User user=new User();
                        user.setUsername(name);
                        user.setPassword(password);
                        user.signUp(this, new SaveListener() {
                            @Override
                            public void onSuccess() {
                                Toast.makeText(getApplicationContext(),"注册成功！",Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onFailure(int i, String s) {
                                Toast.makeText(getApplicationContext(),"注册失败"+s.toString(),Toast.LENGTH_SHORT).show();
                            }
                        });
                        startActivity(new Intent(RegisterActivity.this,LoginActivity.class));

                    }else {
                        Toast.makeText(this,"两次密码输入不一致！",Toast.LENGTH_SHORT).show();
                    }

                }else {
                    Toast.makeText(this,"输入不能为空！",Toast.LENGTH_SHORT).show();

                }

                break;
        }
    }
}
