package com.example.nihon;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
/**
 * Chứa các tiện ích giúp hiển thị các hộp thoại dùng để hiển thị thông điệp 
 * 
 * @author Nguyễn Ngọc Anh - Tel: 0905. 119948 - Email: anhnnst@yahoo.com - Facebook: anhnnst
 * @CreatedDate: 18/10/2014
 * 
 * @Purpose: Nhằm tạo một đồ án mẫu giúp cho sinh viên Fpoly Đà Nẵng có thể hiểu và vận dụng vào làm một đồ án thực tế
 * @version 1.0.1
 * @Reference: Chương trình có sử dụng một số tài nguyên của đồ án tốt nghiệp của nhóm TaxiCalling thuộc FU Đà Nẵng
 */
public class MessageDialog {
	boolean isOk = false;
	public boolean showConfirmDialog(Context context, String title,
			String message, String positiveButtonTitle,
			String negativeButtonTitle, boolean isCancelable, DialogInterface.OnClickListener onPositiveHandler) {

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		
		// set title
		alertDialogBuilder.setTitle(title);

		// set dialog message
		alertDialogBuilder
				.setMessage(message)
				.setCancelable(isCancelable)
				.setPositiveButton(positiveButtonTitle,onPositiveHandler)
				.setNegativeButton(negativeButtonTitle,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {

								isOk = false;
								dialog.cancel();
							}
						});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
		
		return isOk;
	}
	
	public void showAlertDialog(Context context, String title,
			String message, String positiveButtonTitle, boolean isCancelable) {

		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
				context);
		
		// set title
		alertDialogBuilder.setTitle(title);

		// set dialog message
		alertDialogBuilder
				.setMessage(message)
				.setCancelable(isCancelable)
				.setPositiveButton(positiveButtonTitle,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								isOk = true;
								dialog.cancel();
							}
						});

		// create alert dialog
		AlertDialog alertDialog = alertDialogBuilder.create();

		// show it
		alertDialog.show();
	}
}
