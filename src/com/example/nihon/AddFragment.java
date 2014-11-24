package com.example.nihon;

import com.example.nihon.data.Database;

import Adapter.WordAdapter;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
@SuppressLint("NewApi")
public class AddFragment extends Fragment {
	EditText ID, category_id, english, pinyin, japanese, vietnamese;
	Button clickadd;

	public static AddFragment newInstance(String param1, String param2) {
		AddFragment fragment = new AddFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
	}

	public AddFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_add, container, false);
		
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

		Button btn = (Button) getActivity().findViewById(R.id.btPlay);
		
		btn.setOnClickListener(new OnClickListener() {
					
					@Override
					public void onClick(View v) {
						onClick_Save(v);
					}
				});
ID=(EditText)getActivity().findViewById(R.id.edtid);
category_id=(EditText)getActivity().findViewById(R.id.category_id);
english = (EditText)getActivity().findViewById(R.id.english);
pinyin=(EditText)getActivity().findViewById(R.id.pinyin);
japanese=(EditText)getActivity().findViewById(R.id.japanese);
vietnamese=(EditText)getActivity().findViewById(R.id.vietnamese);
		
	
	}
	
	public void onClick_Save(View v){
		MessageDialog msgDialog = new MessageDialog();
		DialogInterface.OnClickListener onPositiveHandler = new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				
				Database adapter = null;
				try{
					adapter = new Database(getActivity());
					adapter.openDataBase();
//					adapter.addWord(etWordKey.getText().toString(), etWordMeaning.getText().toString());
					
					Toast.makeText(getActivity(), "New word has been saved!", Toast.LENGTH_SHORT).show();
					
					ID.setText("");
					category_id.setText("");
					english.setText("");
					pinyin.setText("");
					japanese.setText("");
					vietnamese.setText("");
				}catch(Exception ex){
					Log.d("eDictionary", ex.getMessage());
					Toast.makeText(getActivity(), "There is an error.", Toast.LENGTH_SHORT).show();
				}finally{
					adapter.close();
				}
			}
		};

		if (!(msgDialog.showConfirmDialog(this.getActivity(), "Confirm","Do you want to save?", "Yes", "No", false, onPositiveHandler))){
			return;
		}
	}

}
