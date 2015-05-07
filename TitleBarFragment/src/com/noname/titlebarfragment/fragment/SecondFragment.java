package com.noname.titlebarfragment.fragment;

import android.os.Bundle;
import android.view.View;

import com.noname.titlebarfragment.R;

public class SecondFragment extends BaseFragment {

	@Override
	public int getLayoutId() {
		return R.layout.second;
	}

	@Override
	public int getTitleImageID() {
		return R.drawable.ic_launcher;
	}

	@Override
	public String getTitle() {
		return "第二个界面";
	}

	@Override
	public String getTitleRightDesc() {
		return "右2";
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.title_left_bt:

			break;

		case R.id.title_mid_desc:

			break;

		case R.id.title_right_desc:

			break;

		}
	}
	
}
