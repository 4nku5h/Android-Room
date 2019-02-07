package com.ankush.shrivastava.room.DataBase;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;


@Database(entities = User_Entity.class,version = 1)
public abstract class MyDatabase extends RoomDatabase {

    public abstract My_Dao my_dao();
}
