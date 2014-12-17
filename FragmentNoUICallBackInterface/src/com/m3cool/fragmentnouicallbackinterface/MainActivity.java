package com.m3cool.fragmentnouicallbackinterface;

import java.util.ArrayList;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;

public class MainActivity extends Activity implements NewItemFragment.OnNewItemAddListener {
	private ArrayAdapter<String> aa;
	private ArrayList<String> todoItems;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		// Inflate your view.
		setContentView(R.layout.main);
		
		// Get reference to the fragments.
		FragmentManager fm = getFragmentManager();
		ToDoListFragment todoListFragment =
				(ToDoListFragment)fm.findFragmentById(R.id.TodoListFragment);
		
		// Create the array list of to do items.
		todoItems = new ArrayList<String>();
		
		// Create the array adapter to bind the array to the listview
		aa = new ArrayAdapter<String>(this,
									  android.R.layout.simple_list_item_1,
									  todoItems);
		
		// Bind the array adapter to the listview.
		todoListFragment.setListAdapter(aa);
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.m3cool.fragmentnouicallbackinterface.NewItemFragment.OnNewItemAddListener#onNewItemAdd(java.lang.String)
	 */
	public void onNewItemAdd(String newItem) {
		todoItems.add(newItem);
		aa.notifyDataSetChanged();
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
