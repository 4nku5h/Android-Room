package com.ankush.shrivastava.room.Fragment_Main;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ankush.shrivastava.room.R;

public class ListFrag extends ListFragment {
    ListFragListener listFragListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.listFragListener=(ListFragListener) activity;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        if(listFragListener!=null)
            listFragListener.itemClicked(id);

        super.onListItemClick(l, v, position, id);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String[] arr={"add","remove","Update"};
        setListAdapter(new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arr));
        return inflater.inflate(R.layout.activity_main2,container,false);
    }
}
