package com.m3cool.fragmentslayouts;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DetailsFragment extends Fragment {
	// Called once the fragment has been created in order for it to
	// create it's user interface.
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		// Create, or inflate the Fragment's UI.
		// If this fragment has no UI, return null.
		return inflater.inflate(R.layout.details_fragment, container, false);
	}
}
