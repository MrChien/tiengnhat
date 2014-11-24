package com.example.nihon;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.PopupMenu;

/**
 * A simple {@link Fragment} subclass.
 * 
 */
@SuppressLint("NewApi") public class AboutUsFragment extends Fragment implements PopupMenu.OnMenuItemClickListener {

	Adapter.WordList2Adapter mAdapter;
	public AboutUsFragment() {
		// Required empty public constructor
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// Inflate the layout for this fragment
		View view = inflater.inflate(R.layout.fragment_about_us, container, false);
		mAdapter = new Adapter.WordList2Adapter(this.getActivity());
		mAdapter.loadData();
		ListView lv = (ListView) view.findViewById(R.id.lvWordList);
		lv.setAdapter(mAdapter);
		
		lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {

			@Override
			public boolean onItemLongClick(AdapterView<?> parent, View view,
					int position, long id) {
				showMenu(view);
				return true;
			}
			
		});
		
		return view;
	}


	
	public void showMenu(View v) {
	    PopupMenu popup = new PopupMenu(getActivity(), v);

	    // This activity implements OnMenuItemClickListener
	    popup.setOnMenuItemClickListener(this);
	    popup.inflate(R.menu.word_list_context_menu);
	    popup.show();
	}

	@Override
	public boolean onMenuItemClick(MenuItem item) {
	    switch (item.getItemId()) {
	        case R.id.menuUpdate:
	            udpate(item);
	            return true;
	        case R.id.menuDelete:
	            delete(item);
	            return true;
	        default:
	            return false;
	    }
	}

	private void udpate(MenuItem item) {
		// TODO Auto-generated method stub
		
	}

	private void delete(MenuItem item) {
		// TODO Auto-generated method stub
		
	}
}
