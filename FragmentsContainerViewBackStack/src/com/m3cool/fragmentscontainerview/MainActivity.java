package com.m3cool.fragmentscontainerview;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		FragmentManager fm = getFragmentManager();
		
		/*
		 * LISTING 4-8: Populating Fragment layouts using container views Pg 122
		 * 
		 * This is the best practice.
		 * Check to see if the Fragment back stack has been populated
    	 * If not, create and populate the layout.
    	 *...
    	 * 
    	 *	DetailsFragment detailsFragment = 
      	 *	(DetailsFragment)fm.findFragmentById(R.id.details_container);
    	 *
		 *   if (detailsFragment == null) {
		 *      FragmentTransaction ft = fm.beginTransaction(); 
		 *      ft.add(R.id.details_container, new DetailsFragment());
		 *      ft.add(R.id.ui_container, new MyListFragment());
		 *      ft.commit();
		 *    }
		 *    
		 *    Below has been left as it is, for simplicity.
		 */
		FragmentTransaction ft = fm.beginTransaction();
		ft.add(R.id.list_container, new ListFragment());
		ft.add(R.id.details_container, new DetailsFragment());
		ft.commit();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
