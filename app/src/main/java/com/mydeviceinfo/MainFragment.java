package com.mydeviceinfo;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mydeviceinfo.data.MyData;
import com.mydeviceinfo.util.LogUtils;

import java.util.ArrayList;
import java.util.List;

public class MainFragment extends Fragment {
	public static final String TAG = "MainFragment";
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	private static final String ARG_SECTION_NUMBER = "section_number";

	private List<MyData> myDatas = new ArrayList<>();
	private RecyclerView mRecyclerView;
	private RecyclerView.LayoutManager mLayoutManager;
	private MyRecyclerAdapter adapter;

	public MainFragment() {
	}

	/**
	 * Returns a new instance of this fragment for the given section
	 * number.
	 */
	public static MainFragment newInstance(int sectionNumber) {
		MainFragment fragment = new MainFragment();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	                         Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_main, container, false);

		mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recycler_view);
		mRecyclerView.setHasFixedSize(true);

		mLayoutManager = new LinearLayoutManager(getActivity());
		mRecyclerView.setLayoutManager(mLayoutManager);

		onItemLoadComplete();
//
//		StringBuffer deviceBuildVersion = new StringBuffer();
//		deviceBuildVersion.append(Build.VERSION.SDK_INT);
//		deviceBuildVersion.append("\n");
//		deviceBuildVersion.append(Build.VERSION.CODENAME);
//		deviceBuildVersion.append("\n");
//		deviceBuildVersion.append(Build.BRAND);
//
//		textView.setText(deviceBuildVersion);
		return rootView;
	}

	private void onItemLoadComplete() {
		myDatas.add(new MyData("BRAND", Build.BOARD));
		myDatas.add(new MyData("CODENAME", Build.VERSION.CODENAME));
		adapter = new MyRecyclerAdapter(getActivity(), myDatas);
		mRecyclerView.setAdapter(adapter);
	}

	public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.CustomViewHolder> {
		private Activity mCurrentActivity;
		private List<MyData> myDatas;
		private Context mContext;

		public MyRecyclerAdapter(Context context, List<MyData> myDatas) {
			this.mContext = context;
			this.myDatas = myDatas;
			this.mContext = context;
		}

		@Override
		public CustomViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
			View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.infomation_row, viewGroup, false);
			return new CustomViewHolder(view);
		}

		@Override
		public void onBindViewHolder(final CustomViewHolder holder, int i) {
			holder.data = myDatas.get(i);

			holder.mView.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
					Context context = v.getContext();
					LogUtils.LOGD(TAG, "name:" + holder.data.getTitle());

				}
			});
			holder.title.setText("");
			holder.content.setText("");

			holder.title.setText(holder.data.getTitle());
			holder.content.setText(holder.data.getContent());
		}
		@Override
		public int getItemCount() {
			return (null != myDatas ? myDatas.size() : 0);
		}

		public class CustomViewHolder extends RecyclerView.ViewHolder {
			protected MyData data;
			public final View mView;
			public final TextView title;
			public final TextView content;
			public CustomViewHolder(View view) {
				super(view);
				this.mView = view;
				this.title = (TextView) view.findViewById(R.id.title);
				this.content = (TextView) view.findViewById(R.id.content);
			}
		}
	}
}