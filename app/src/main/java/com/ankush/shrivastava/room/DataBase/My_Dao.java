package com.ankush.shrivastava.room.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;

@Dao
public interface My_Dao {

    @Insert
    public void addUser(User_Entity userEntity);
}
