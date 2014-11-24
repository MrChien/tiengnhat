package com.example.nihon;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * 
 */

@SuppressLint("NewApi")
public class HomeFragment extends Fragment {
	Button homeclick1, homeclick2, homeclick3, homeclick4, homeclick5,
			homeclick6, homeclick7, homeclick8, homeclick9;

	public static HomeFragment newInstance(String param1, String param2) {
		HomeFragment fragment = new HomeFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	public HomeFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_home, container, false);
		return view;

	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		homeclick1 = (Button) getActivity().findViewById(R.id.button1);

		homeclick2 = (Button) getActivity().findViewById(R.id.button2);

		homeclick3 = (Button) getActivity().findViewById(R.id.button3);

		homeclick4 = (Button) getActivity().findViewById(R.id.button4);
		homeclick5 = (Button) getActivity().findViewById(R.id.button5);

		homeclick6 = (Button) getActivity().findViewById(R.id.button6);
		homeclick7 = (Button) getActivity().findViewById(R.id.button7);
		homeclick8 = (Button) getActivity().findViewById(R.id.button8);

		homeclick1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, new AddFragment())
						.commit();
			}
		});

		homeclick2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, new NumberFragment())
						.commit();
			}
		});

		homeclick3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, new AboutUsFragment())
						.commit();
			}
		});

		homeclick4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, new AnUongFragment())
						.commit();
			}
		});

		homeclick5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, new NgayGioFragment())
						.commit();
			}
		});

		homeclick6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, new MauSacFragment())
						.commit();
			}
		});

		homeclick7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, new DatNuocFragment())
						.commit();
			}
		});

		homeclick8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentManager fragmentManager = getFragmentManager();
				fragmentManager.beginTransaction()
						.replace(R.id.content_frame, new SucKhoeFragment())
						.commit();
			}
		});

	}

}
