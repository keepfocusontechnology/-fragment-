package com.noname.titlebarfragment.fragment;

import com.noname.titlebarfragment.R;

import android.os.Bundle;
import android.view.View;

public class FirstFragment extends BaseFragment{

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.title_left_bt:
			
			break;
			
		case R.id.title_mid_desc:
			
			break;
			
		case R.id.title_right_desc:
	
			break;

		}
		
	}

	@Override
	public int getLayoutId() {
		return R.layout.frist;
	}

	@Override
	public int getTitleImageID() {
		return R.drawable.ic_launcher;
	}

	@Override
	public String getTitle() {
		return "第一个界面";
	}

	@Override
	public String getTitleRightDesc() {
		return "右1";
	}
	
	

}
