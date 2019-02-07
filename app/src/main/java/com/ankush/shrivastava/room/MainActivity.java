package com.ankush.shrivastava.room;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ankush.shrivastava.room.DataBase.MyDatabase;
import com.ankush.shrivastava.room.Fragment_Main.Frag1;
import com.ankush.shrivastava.room.Fragment_Main.ListFragListener;

public class MainActivity extends AppCompatActivity implements ListFragListener{
    FragmentManager fm;
    public static MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm=getFragmentManager();
        fm.findFragmentById(R.id.listfrag);
        fm.beginTransaction();
        myDatabase= Room.databaseBuilder(getApplicationContext(),MyDatabase.class ,"mydb").allowMainThreadQueries().build();

    }


    @Override
    public void itemClicked(long id) {
       // String name=fm.findFragmentById(R.id.listfrag).getClass().getName();
        Toast.makeText(getApplicationContext(),"fvfv",Toast.LENGTH_SHORT).show();
        Frag1 frag1=new Frag1();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.frag1,frag1);
        ft.commit();

    }
}
