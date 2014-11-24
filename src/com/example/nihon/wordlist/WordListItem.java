package com.example.nihon.wordlist;

public class WordListItem {

	int id;
	int category_id;

	public int getCategory_id() {
		return category_id;
	}

	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}

	String english;
	String pinyin;
	String japanese;
	String vietnamese;

	public WordListItem() {
		this.id = 0;
		this.category_id = 0;
		this.english = "";
		this.pinyin = "";
		this.japanese = "";
		this.vietnamese = "";
	}

	public WordListItem(int id, String english, String pinyin, String japanese,
			String vietnamese) {

		this.id = id;
		this.english = english;
		this.pinyin = pinyin;
		this.japanese = japanese;
		this.vietnamese = vietnamese;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getPinyin() {
		return pinyin;
	}

	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}

	public String getJapanese() {
		return japanese;
	}

	public void setJapanese(String japanese) {
		this.japanese = japanese;
	}

	public String getVietnamese() {
		return vietnamese;
	}

	public void setVietnamese(String vietnamese) {
		this.vietnamese = vietnamese;
	}

}
