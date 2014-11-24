package com.example.nihon;

import com.example.nihon.data.Database;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.database.Cursor;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
@SuppressLint("NewApi")
public class LookupFragment extends Fragment {
	Button btn;
	EditText etLookupWord;
	WebView wv;
	TextView look;
	TextView look1;
	ListView lvlook;

	public static LookupFragment newInstance(String param1, String param2) {
		LookupFragment fragment = new LookupFragment();
		Bundle args = new Bundle();
		fragment.setArguments(args);
		return fragment;
	}

	public LookupFragment() {
		// Required empty public constructor
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (getArguments() != null) {
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater
				.inflate(R.layout.fragment_lookup, container, false);
		btn = (Button) view.findViewById(R.id.btnSearch);
		etLookupWord = (EditText) view.findViewById(R.id.etLookupWord);
		wv = (WebView) view.findViewById(R.id.wvWordBoard);
		// look = (TextView) view.findViewById(R.id.look);
		// look1 = (TextView) view.findViewById(R.id.look1);

		btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				if (etLookupWord.getText().toString().trim() == "") {
					Toast.makeText(getActivity(),
							"Search word must be entered", Toast.LENGTH_LONG)
							.show();
					return;
				}
				Database adapter = null;
				try {
					adapter = new Database(getActivity());
					adapter.openDataBase();
					Cursor cursor = adapter.getWord(etLookupWord.getText()
							.toString());
					if (cursor != null && cursor.isFirst()) {
						String eng = cursor.getString(1);
						String pinyin = cursor.getString(2);
						String japanese = cursor.getString(3);
						String vietnam = cursor.getString(4);
						eng += "<blockquote>" + pinyin + "</blockquote>"
								+ "<blockquote>" + vietnam + "</blockquote>";
						// String data = cursor.getString(2);
						// String vietnam = cursor.getString(4);
						// look.setText(eng);
						// look.setText(vietnam);

						wv.loadData(eng, "text/html", "UTF-8");
						//
					} else {
						Toast.makeText(getActivity(),
								"The word doesn't exited in the dictionary",
								Toast.LENGTH_LONG).show();
					}
				} catch (Exception e) {
					Toast.makeText(getActivity(),
							"There is an error." + e.getMessage(),
							Toast.LENGTH_LONG).show();
					e.printStackTrace();
				} finally {
					try {
						adapter.close();
					} catch (Exception ex) {
					}
				}
			}
		});
		return view;
	}

}
