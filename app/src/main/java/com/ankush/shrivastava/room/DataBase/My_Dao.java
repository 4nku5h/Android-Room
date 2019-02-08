package com.ankush.shrivastava.room.DataBase;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface My_Dao {


    @Insert
    public void addUser(User_Entity userEntity);

    @Query("SELECT * FROM users")
    public List<User_Entity> getUser();

    @Delete
    public void delete(User_Entity user);

    @Update
    public void Update(User_Entity user);
}
