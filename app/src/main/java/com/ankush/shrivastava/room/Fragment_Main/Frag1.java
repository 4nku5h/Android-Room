package com.ankush.shrivastava.room.Fragment_Main;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.ankush.shrivastava.room.DataBase.My_Dao;
import com.ankush.shrivastava.room.DataBase.User_Entity;
import com.ankush.shrivastava.room.MainActivity;
import com.ankush.shrivastava.room.R;

public class Frag1 extends Fragment{
    Button btn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.activity_frag1,container,false);
        btn=view.findViewById(R.id.clicked);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User_Entity user_entity=new User_Entity();
                user_entity.setId(1);
                user_entity.setName("name");
                user_entity.setEmail("sdkmikdj@jdcjbd.com");
                Toast.makeText(getActivity(),"added",Toast.LENGTH_SHORT).show();
                MainActivity.myDatabase.my_dao().addUser(user_entity);
            }
        });
        return view;

    }
}
