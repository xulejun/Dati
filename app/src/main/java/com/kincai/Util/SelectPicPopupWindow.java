package com.kincai.Util;
import com.kincai.test.R;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.PopupWindow;

/**
 * 自定义菜单
 * @author kincai
 *
 */
public class SelectPicPopupWindow extends PopupWindow {


	public static Activity at;
	private Button help, exit, cancle,about;
	private View mMenuView;
    public SelectPicPopupWindow() {
	// TODO Auto-generated constructor stub
    }
	public SelectPicPopupWindow(Activity context,OnClickListener itemsOnClick) {
		super(context);
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		mMenuView = inflater.inflate(R.layout.menu, null);
		findViewId();
		listener(itemsOnClick);
		
		//设置SelectPicPopupWindow的View
		this.setContentView(mMenuView);
		//设置弹出窗体的宽
		this.setWidth(LayoutParams.MATCH_PARENT);
		//设置弹出窗体的高
		this.setHeight(LayoutParams.WRAP_CONTENT);
		//设置弹出窗体可点击
		this.setFocusable(true);
		//设置弹出窗体动画效果
		this.setAnimationStyle(R.style.AnimBottom);
		//颜色为半透明
		ColorDrawable dw = new ColorDrawable(0xb0000000);
		//设置SelectPicPopupWindow弹出窗体的背景
		this.setBackgroundDrawable(dw);
		//触屏监听
		mMenuView.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				
				int height = mMenuView.findViewById(R.id.pop_layout).getTop();
				int y=(int) event.getY();
				if(event.getAction()==MotionEvent.ACTION_UP){
					if(y<height){
						dismiss();
					}
				}				
				return true;
			}
		});

	}
	private void findViewId() {
		help = (Button) mMenuView.findViewById(R.id.help);
		exit = (Button) mMenuView.findViewById(R.id.exit);
		cancle = (Button) mMenuView.findViewById(R.id.cancel);
		about = (Button) mMenuView.findViewById(R.id.about);
	}
	private void listener(OnClickListener onClickListener) {
		help.setOnClickListener(onClickListener);
		exit.setOnClickListener(onClickListener);
		cancle.setOnClickListener(onClickListener);
		about.setOnClickListener(onClickListener);
	}
	
}


