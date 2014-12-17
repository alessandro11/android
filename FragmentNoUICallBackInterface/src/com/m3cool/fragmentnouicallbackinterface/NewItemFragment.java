package com.m3cool.fragmentnouicallbackinterface;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

public class NewItemFragment extends Fragment {
	private OnNewItemAddListener onNewItemAddListener;
	
	public interface OnNewItemAddListener {
		public void onNewItemAdd(String newItem);
	}
	
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		
		try {
			onNewItemAddListener = (OnNewItemAddListener)activity;
		}catch( ClassCastException e ) {
			throw new ClassCastException(activity.toString() + 
					" must implement OnNewItemAddListener");
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.new_item_fragment, container, false);
		
		final EditText myEditText = (EditText)view.findViewById(R.id.myEditText);
		
		myEditText.setOnKeyListener( new View.OnKeyListener() {
			
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				// TODO Auto-generated method stub
				if( event.getAction() == KeyEvent.ACTION_DOWN ) {
					if( (keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
							(keyCode == KeyEvent.KEYCODE_ENTER) ) {
						String newItem = myEditText.getText().toString();
						onNewItemAddListener.onNewItemAdd(newItem);
						myEditText.setText("");
						return true;
					}
				}
				return false;
			}
		});
		
		return view;
	}
}
