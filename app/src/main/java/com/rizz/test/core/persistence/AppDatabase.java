package com.rizz.test.core.persistence;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.rizz.test.feature.user.data.local.UserDao;
import com.rizz.test.feature.user.data.model.GithubUser;

@Database(entities = {GithubUser.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
}
