//project copyright
package com.easyhome.demo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.easyhome.framework.activity.BaseActivity;

/**
 * 
 * @author Jimmy.Z
 * @since 2012-6-20
 */
public class MainActivity extends BaseActivity {

	protected static final boolean DEBUG = true;
	protected static final String TAG = "MainActivity";

	private String[] mainList = { "组件测试", "音效测试", };

	private Class<?>[] activityAction = { ModuleTestDemo.class, AudioEffectDemo.class, };

	private ListView mList;
	private ArrayAdapter<String> mAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
	}

	@Override
	public void onFirstLoadData() {
	}

	@Override
	public void onInitViews() {
		mList = (ListView) findViewById(R.id.list);
		mAdapter = new MainListAdapter(this, R.layout.list_textview_item, R.id.textview, mainList);
		mList.setAdapter(mAdapter);
	}

	class MainListAdapter extends ArrayAdapter<String> {

		private int mTextViewResourceId;

		public MainListAdapter(Context context, int resource, int textViewResourceId, String[] objects) {
			super(context, resource, textViewResourceId, objects);
			mTextViewResourceId = textViewResourceId;
		}

		private OnClickListener itemClick = new OnClickListener() {

			@Override
			public void onClick(View view) {
				Intent intent = new Intent(MainActivity.this, activityAction[(Integer) view.getTag()]);
				MainActivity.this.startActivity(intent);
			}

		};

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			View view = super.getView(position, convertView, parent);
			View textView = view.findViewById(mTextViewResourceId);
			textView.setTag(position);
			textView.setOnClickListener(itemClick);
			return view;
		}

	}
}
