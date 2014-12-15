package com.m3cool.fragmentscontainerview;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

public class ListFragment extends Fragment {	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.list_layout, container, false);
	}
	
	// Since we should encapsulate each functionality in each fragment
	// make a listener for event using dinamically.
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		
		Button btnOk = (Button)getActivity().findViewById(R.id.btn_OK); 
		btnOk.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				FragmentTransaction ft = getFragmentManager().beginTransaction();
				ft.replace(R.id.details_container, new DetailsFragment2());
				ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
				ft.addToBackStack(null);
				ft.commit();
			}
		});
	}
}
