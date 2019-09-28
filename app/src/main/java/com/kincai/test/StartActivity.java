package com.kincai.test;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
/**
 * ��������ҳ��
 * @author kincai
 *
 */
public class StartActivity extends Activity {
	private static final long SPLASH_DISPLAY_LENGHT = 2000;
	boolean isFirstIn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		//ȫ����ʾ
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.start);
		
		
		//��ȡSharedPreFerences����Ҫ������,ʹ��SharedPreFerences����¼����������ʹ�ô���
        SharedPreferences preferences = getSharedPreferences("kincai", Activity.MODE_PRIVATE);
         //ȡ����Ӧ��ֵ,���û�и�ֵ,˵����δд��,��true��ΪĬ��ֵ
        isFirstIn = preferences.getBoolean("kincai", true);
        if (!isFirstIn) {
        	 new Handler().postDelayed(new Runnable(){ 
	   	         @Override
	   	         public void run() { 
	   	             Intent Intent = new Intent(StartActivity.this,LoginActivity.class); 
	   	             startActivity(Intent); 
	   	             finish(); 
	   	             //����Ч��
	   	             overridePendingTransition(R.anim.fade_in, R.anim.fade_out); 
	   	         } 
	   	         //�ӳ�ʱ��
   		     }, SPLASH_DISPLAY_LENGHT); //new Handler().postDelayed(r, delayMillis)
        } else {
        	 new Handler().postDelayed(new Runnable(){ 
	   	         @Override
	   	         public void run() { 
	   	        	Intent intent = new Intent(StartActivity.this, NavigationActivity.class);
	   	            startActivity(intent);
	   	             finish(); 
	   	             //����Ч��
	   	             overridePendingTransition(R.anim.fade_in, R.anim.fade_out); 
	   	         } 
	   	         //�ӳ�ʱ��
   		     }, SPLASH_DISPLAY_LENGHT);
            
            
        }
		
	}
}
