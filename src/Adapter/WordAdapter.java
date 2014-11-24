package Adapter;

import java.util.Locale;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.example.nihon.R;
import com.example.nihon.wordlist.WordListItem;

public class WordAdapter extends MyBaseAdapter {
	String toSpeak ;
	int  pos;
	TextView txteng, txtpinyin, txtjapanese, txtvietnamese;
	Button btP;
	TextToSpeech tts;
	Context cont;
	public WordAdapter(Context context) {
		super(context);
		cont=m_Context;
		//
	}

	@Override
	public View getLayout(Object obj, View v, int position) {
		final WordListItem cc = (WordListItem) obj;
		tts = new TextToSpeech(cont,
				new TextToSpeech.OnInitListener() {
					@Override
					public void onInit(int status) {
						if (status != TextToSpeech.ERROR) {
							tts.setLanguage(Locale.JAPAN);
						}
					}
				});

		if (v == null) {
			v = (View) m_Inflater.inflate(R.layout.item, null);
		}

		txteng = (TextView) v.findViewById(R.id.english);
		txtpinyin = (TextView) v.findViewById(R.id.pinyin);
		txtjapanese = (TextView) v.findViewById(R.id.japanese);
		txtvietnamese = (TextView) v.findViewById(R.id.vietnamese);

		txteng.setText(cc.getEnglish());
		txtpinyin.setText(cc.getPinyin());
		txtjapanese.setText(cc.getJapanese());
		txtvietnamese.setText(cc.getVietnamese());
		btP=(Button) v.findViewById(R.id.btPlay);
	//	btP.setTag(position);
		pos=position;
		
		
		btP.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				toSpeak = cc.getJapanese().toString();
				tts.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
			}
		});
		return v;
	}

}
