package com.kincai.Util;

import com.kincai.test.ResultActivity;

import android.app.Activity;
import android.content.Intent;
import android.widget.Toast;
/**
 * ��Ŀ�ж�
 * @author kincai
 *
 */
public class SendResult {
	public SendResult(Activity context, String one_topic,String two_topic,
			String three_topic,String four_topic,String five_topic,String testType) {
		// TODO Auto-generated constructor stub
		if(!one_topic.equals("")&&!two_topic.equals("")&&!three_topic.equals("")&&four_topic.length()>=1&&five_topic.length()>=1) {
			Intent intents = new Intent(context, ResultActivity.class);
			
			intents.putExtra("flag", testType);
			intents.putExtra("one_topic",one_topic );
			intents.putExtra("two_topic",two_topic );
			intents.putExtra("three_topic",three_topic );
			intents.putExtra("four_topic",four_topic );
			intents.putExtra("five_topic",five_topic );
			
			context.startActivity(intents);
			context.finish();
		} else if(one_topic.equals("")&&!two_topic.equals("")&&!three_topic.equals("")&&four_topic.length()>0&&five_topic.length()>0) {
			Toast.makeText(context, "��һ��û��Ŷ������", Toast.LENGTH_SHORT).show();
		} else if(!one_topic.equals("")&&two_topic.equals("")&&!three_topic.equals("")&&four_topic.length()>0&&five_topic.length()>0) {
			Toast.makeText(context, "�ڶ���û��Ŷ������", Toast.LENGTH_SHORT).show();
		} else if(!one_topic.equals("")&&!two_topic.equals("")&&three_topic.equals("")&&four_topic.length()>0&&five_topic.length()>0) {
			Toast.makeText(context, "������û��Ŷ������", Toast.LENGTH_SHORT).show();
		} else if(!one_topic.equals("")&&!two_topic.equals("")&&!three_topic.equals("")&&four_topic.length()==0&&five_topic.length()>0) {
			Toast.makeText(context, "������û��Ŷ������", Toast.LENGTH_SHORT).show();
		} else if(!one_topic.equals("")&&!two_topic.equals("")&&!three_topic.equals("")&&four_topic.length()>0&&five_topic.length()==0) {
			Toast.makeText(context, "������û��Ŷ������", Toast.LENGTH_SHORT).show();
		} else if(!one_topic.equals("")&&!two_topic.equals("")&&!three_topic.equals("")&&four_topic.length()==0&&five_topic.length()==0) {
			Toast.makeText(context, "��ѡ��û��Ŷ������", Toast.LENGTH_SHORT).show();
		} else if(one_topic.equals("")&&two_topic.equals("")&&three_topic.equals("")&&four_topic.length()==0&&five_topic.length()==0) {
			Toast.makeText(context, "�뽻�׾��𣿣���", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(context, "����û����Ŷ������", Toast.LENGTH_SHORT).show();
		}
	}
}
