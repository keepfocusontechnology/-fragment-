package com.noname.titlebarfragment;

import java.util.ArrayList;
import java.util.List;
import com.noname.titlebarfragment.fragment.FirstFragment;
import com.noname.titlebarfragment.fragment.SecondFragment;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

	private Button bt1;
	private Button bt2;
	private FragmentManager fragmentManager;
	private FragmentTransaction beginTransaction;

	private Fragment contentFragment;
	private List<Fragment> fragmentTask;

	// private View view;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		fragmentManager = getFragmentManager();
		setContentView(R.layout.activity_main);
		bt1 = (Button) findViewById(R.id.bt_1);
		bt2 = (Button) findViewById(R.id.bt_2);
		fragmentTask = new ArrayList<Fragment>();
		// view = findViewById(R.id.content);

		bt1.setOnClickListener(this);
		bt2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.bt_1) {
			switchFragment(FirstFragment.class.toString());
		} else if (v.getId() == R.id.bt_2) {
			switchFragment(SecondFragment.class.toString());
		}
	}

	void switchFragment(String tag) {

		boolean hasFirstFragment = false;
		boolean hasSecondFragment = false;
		beginTransaction = fragmentManager.beginTransaction();
		hideFragment();
		if (tag.equals(FirstFragment.class.toString())) {
			for (Fragment fragment : fragmentTask) {
				if (fragment instanceof FirstFragment) {
					contentFragment = fragment;
					hasFirstFragment = true;
				}
			}
			if (hasFirstFragment) {
				beginTransaction.show(contentFragment);
			} else {
				contentFragment = new FirstFragment();
				beginTransaction.add(R.id.content, contentFragment);
				fragmentTask.add(contentFragment);
			}

		} else if (tag.equals(SecondFragment.class.toString())) {
			for (Fragment fragment : fragmentTask) {
				if (fragment instanceof SecondFragment) {
					contentFragment = fragment;
					hasSecondFragment = true;
				}
			}
			if (hasSecondFragment) {
				beginTransaction.show(contentFragment);
			} else {
				contentFragment = new SecondFragment();
				beginTransaction.add(R.id.content, contentFragment);
				fragmentTask.add(contentFragment);
			}
		}
		beginTransaction.commitAllowingStateLoss();
	}

	private void hideFragment() {
		if (contentFragment != null)
			beginTransaction.hide(contentFragment);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {

		if (keyCode == KeyEvent.KEYCODE_BACK) {
			if (fragmentTask.size() > 0) {
				beginTransaction = fragmentManager.beginTransaction();
				beginTransaction.hide(contentFragment);
				beginTransaction
						.remove(fragmentTask.get(fragmentTask.size() - 1));
				fragmentTask.remove(fragmentTask.size() - 1);
				if (fragmentTask.size() > 0) {
					contentFragment = fragmentTask.get(fragmentTask.size() - 1);
					beginTransaction.show(contentFragment);
				}
				beginTransaction.commitAllowingStateLoss();
				return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
}
