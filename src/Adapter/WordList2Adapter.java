package Adapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import com.example.nihon.data.Database;
import com.example.nihon.wordlist.WordListItem;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Lớp quản lý dữ liệu sẽ được hiển thị trên danh sách từ cơ sở dư liệu. Hình
 * ảnh hiển thị sẽ được lấy từ thư mục assets của ứng dụng.
 * 
 * @author Nguyễn Ngọc Anh - Tel: 0905. 119948 - Email: anhnnst@yahoo.com -
 *         Facebook: anhnnst
 * @CreatedDate: 18/10/2014
 * 
 * @Purpose: Nhằm tạo một đồ án mẫu giúp cho sinh viên Fpoly Đà Nẵng có thể hiểu
 *           và vận dụng vào làm một đồ án thực tế
 * @version 1.0.1
 * @Reference: Chương trình có sử dụng một số tài nguyên của đồ án tốt nghiệp
 *             của nhóm TaxiCalling thuộc FU Đà Nẵng
 */
public class WordList2Adapter extends BaseAdapter {
	ArrayList<WordListItem> mList;
	Context mContext;

	public WordList2Adapter(Context context) {
		mList = new ArrayList<WordListItem>();
		mContext = context;
	}

	public void loadData() {
		Database adapter = new Database(mContext);

		try {
			adapter.openDataBase();
			Cursor cursor = adapter.getAll();
			while (cursor.moveToNext()) {
				WordListItem ccc = new WordListItem();
				ccc.setId(cursor.getInt(0));
				ccc.setEnglish(cursor.getString(1));
				ccc.setPinyin(cursor.getString(2));
				ccc.setJapanese(cursor.getString(3));
				ccc.setVietnamese(cursor.getString(4));

				mList.add(ccc);
			}
		} catch (Exception e) {
			Toast.makeText(mContext, "There is an error.", Toast.LENGTH_SHORT)
					.show();
		}

	}

	@Override
	public int getCount() {
		return mList.size();
	}

	@Override
	public Object getItem(int position) {
		return mList.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			LayoutInflater inflater = (LayoutInflater) mContext
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

			convertView = inflater.inflate(com.example.nihon.R.layout.wordlist,
					null);
			TextView tv_eng = (TextView) convertView
					.findViewById(com.example.nihon.R.id.english);
			TextView tv_chu = (TextView) convertView
					.findViewById(com.example.nihon.R.id.pinyin);
			TextView tv_japan = (TextView) convertView
					.findViewById(com.example.nihon.R.id.japanese);
			TextView tv_vietnam = (TextView) convertView
					.findViewById(com.example.nihon.R.id.vietnamese);

			tv_eng.setText(mList.get(position).getEnglish());
			tv_chu.setText(mList.get(position).getPinyin());

			tv_japan.setText(mList.get(position).getJapanese());
			tv_vietnam.setText(mList.get(position).getVietnamese());

		}

		return convertView;
	}

}
