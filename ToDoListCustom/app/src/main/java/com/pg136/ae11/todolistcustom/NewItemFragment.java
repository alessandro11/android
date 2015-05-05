package com.pg136.ae11.todolistcustom;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by ae11 on 4/9/15.
 */
public class NewItemFragment extends Fragment {
    private OnNewItemAddedListener onNewItemAddedListener;

    public interface OnNewItemAddedListener {
        public void onNewItemAdded(String newItem);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstance) {
        View view = inflater.inflate(R.layout.new_item_fragment, container, false);

    }
}
