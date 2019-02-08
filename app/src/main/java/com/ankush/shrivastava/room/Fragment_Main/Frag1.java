package com.ankush.shrivastava.room.Fragment_Main;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ankush.shrivastava.room.DataBase.My_Dao;
import com.ankush.shrivastava.room.DataBase.User_Entity;
import com.ankush.shrivastava.room.MainActivity;
import com.ankush.shrivastava.room.R;

import java.util.List;

public class Frag1 extends Fragment{

    Button btn_Save;
    Button btn_Get;
    EditText et_id;
    EditText et_name;
    EditText et_email;
    TextView tv_showData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View view=inflater.inflate(R.layout.activity_frag1,container,false);
        initialiseViews(view);
        btn_Save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                MainActivity.myDatabase.my_dao().addUser(createUserData());
                Toast.makeText(getActivity(),"DataAdded",Toast.LENGTH_SHORT).show();
            }
        });
        btn_Get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<User_Entity> users=MainActivity.myDatabase.my_dao().getUser();

                for(User_Entity user:users){
                    tv_showData.setText(String.format("Id:%d \n Name:%s \n Email:%s",user.getId(),user.getName(),user.getEmail()));
                    break;// use list view to show all data
                }
            }
        });

        return view;

    }
    public void initialiseViews(View view){
        btn_Save =view.findViewById(R.id.clicked);
        btn_Get=view.findViewById(R.id.btn_Get);
        et_id=view.findViewById(R.id.tv_id);
        et_name=view.findViewById(R.id.tv_name);
        et_email=view.findViewById(R.id.tv_email);
        tv_showData=view.findViewById(R.id.tv_showdata);
    }

    public User_Entity createUserData(){
        User_Entity user_entity=new User_Entity();
        user_entity.setEmail(et_email.getText().toString());
        user_entity.setName(et_name.getText().toString());
        user_entity.setId(Integer.parseInt(et_id.getText().toString()));
        return user_entity;
    }
}
