package com.example.nihon;

import java.io.IOException;
import java.util.ArrayList;

import com.example.nihon.data.Database;

import Adapter.WordAdapter;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
@SuppressLint("NewApi") public class ChaoHoiFragment extends Fragment {
	ListView lvData;
	WordAdapter adapter;

	public static ChaoHoiFragment newInstance(String param1, String param2) {
		ChaoHoiFragment fragment = new ChaoHoiFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	public ChaoHoiFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view =  inflater.inflate(R.layout.fragment_chao_hoi, container, false);
		return view;
		

		
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		
		isCreateDB();

		lvData = (ListView)getView(). findViewById(R.id.listView1);
		adapter = new WordAdapter(getActivity());
		adapter.setListView(getWordbyID());
		lvData.setAdapter(adapter);
	}
	private ArrayList<Object> getWordbyID() {
//		
Database data = new Database(getActivity());
		return data.getWordById(1);
	}
	
	private boolean isCreateDB() {
		Database data = new Database(getActivity());
		try {
			return data.isCreatedDatabase();
		} catch (IOException e) {

			e.printStackTrace();
			return false;
		}

}}
