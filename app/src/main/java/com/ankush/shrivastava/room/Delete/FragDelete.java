package com.ankush.shrivastava.room.Delete;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.ankush.shrivastava.room.DataBase.User_Entity;
import com.ankush.shrivastava.room.MainActivity;
import com.ankush.shrivastava.room.R;

public class FragDelete extends Fragment {
    Button btn_delete;
    EditText et_id;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.activity_frag_delete,container,false);
        inititliseview(view);
        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeUser();
            }
        });
        return view;
    }

    public void inititliseview(View view){
        btn_delete=view.findViewById(R.id.btn_delete);
        et_id=view.findViewById(R.id.et_id);
    }
    public void removeUser(){
        int id=Integer.parseInt(et_id.getText().toString());
        User_Entity user_entity=new User_Entity();
        user_entity.setId(id);
       try {
           MainActivity.myDatabase.my_dao().delete(user_entity);
       }catch (Exception ex){}
        Toast.makeText(getActivity(),"Removed ",Toast.LENGTH_SHORT).show();
    }

}
