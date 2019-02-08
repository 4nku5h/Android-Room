package com.ankush.shrivastava.room;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ankush.shrivastava.room.DataBase.MyDatabase;
import com.ankush.shrivastava.room.DataBase.My_Dao;
import com.ankush.shrivastava.room.DataBase.User_Entity;
import com.ankush.shrivastava.room.Delete.FragDelete;
import com.ankush.shrivastava.room.Fragment_Main.Frag1;
import com.ankush.shrivastava.room.Fragment_Main.ListFragListener;
import com.ankush.shrivastava.room.Update.FragmentUpdate;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ListFragListener,My_Dao{
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
        Toast.makeText(getApplicationContext(),String.valueOf(id),Toast.LENGTH_SHORT).show();

        int ID=Integer.parseInt(String.valueOf(id));
        switch (ID){
            case 0: {
                Frag1 frag1 = new Frag1();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frag1, frag1);
                ft.commit();
                break;
            }

            case 1: {
                FragDelete fragDelete = new FragDelete();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frag1,fragDelete);
                ft.commit();
                break;
            }
            case 2: {
                FragmentUpdate fraUpdate=new FragmentUpdate();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.frag1,fraUpdate);
                ft.commit();

            }

        }


    }

    @Override
    public void addUser(User_Entity userEntity) {

    }

    @Override
    public List<User_Entity> getUser() {
        return null;
    }

    @Override
    public void delete(User_Entity user) {

    }

    @Override
    public void Update(User_Entity user) {

    }
}
