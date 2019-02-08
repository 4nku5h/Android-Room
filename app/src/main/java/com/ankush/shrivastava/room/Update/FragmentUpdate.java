package com.ankush.shrivastava.room.Update;

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

public class FragmentUpdate extends Fragment implements View.OnClickListener {
    Button btn_Update;
    EditText et_Id;
    EditText et_name;
    EditText et_email;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.activity_fragment_update,container,false);
       initialiseView(view);
       btn_Update.setOnClickListener(this);
        return view;
    }
    public void initialiseView(View view){
        btn_Update=view.findViewById(R.id.btn_update);
        et_Id=view.findViewById(R.id.et_update_id);
        et_name=view.findViewById(R.id.tv_update_name);
        et_email=view.findViewById(R.id.tv_update_email);
    }

    @Override
    public void onClick(View v) {
        User_Entity user=new User_Entity();
        user.setId(Integer.parseInt(et_Id.getText().toString()));
        user.setName(et_name.getText().toString());
        user.setEmail(et_email.getText().toString());
        MainActivity.myDatabase.my_dao().Update(user);
        Toast.makeText(getActivity(),"Updated",Toast.LENGTH_SHORT).show();
    }
}
