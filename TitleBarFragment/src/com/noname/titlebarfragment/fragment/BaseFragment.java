package com.noname.titlebarfragment.fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.noname.titlebarfragment.R;

public abstract class BaseFragment extends Fragment implements
		View.OnClickListener {

	private View view;

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		view = inflater.inflate(R.layout.base_fragment, null);
		initTitleBar();
		ViewGroup contentView = (ViewGroup) view
				.findViewById(R.id.content_fragment);
		inflater.inflate(getLayoutId(), contentView);
		return view;
	}

	@SuppressLint("NewApi")
	private void initTitleBar() {
		TextView tv_right = (TextView) view.findViewById(R.id.title_right_desc);
		TextView tv_mid = (TextView) view.findViewById(R.id.title_mid_desc);
		ImageView iv_left = (ImageView) view.findViewById(R.id.title_left_bt);

		iv_left.setBackground(getResources().getDrawable(getTitleImageID()));
		tv_mid.setText(getTitle());
		tv_right.setText(getTitleRightDesc());

		tv_right.setOnClickListener(this);
		tv_mid.setOnClickListener(this);
		iv_left.setOnClickListener(this);
	}

	public abstract int getLayoutId();

	public abstract int getTitleImageID();

	public abstract String getTitle();

	public abstract String getTitleRightDesc();

	@Override
	public void onStart() {
		super.onStart();
		System.out.println(getClass().toString() + "onStart");
	}

	@Override
	public void onStop() {
		super.onStop();
		System.out.println(getClass().toString() + "onStop");
	}

	@Override
	public void onResume() {
		super.onResume();
		System.out.println(getClass().toString() + "onResume");
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println(getClass().toString() + "onDestroy");
	}
}
