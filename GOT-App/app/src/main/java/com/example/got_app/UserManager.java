package com.example.got_app;
import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class UserManager {

    private static UserManager instancia;
    Dao<User, Integer> dao;

    public UserManager(Context context) {
        OrmLiteSqliteOpenHelper helper = OpenHelperManager.getHelper(context, com.example.got_app.DBHelper.class);
        try{
            dao = helper.getDao(User.class);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static UserManager getInstancia(Context context){
        if(instancia == null){
            instancia = new UserManager(context);
        }
        return instancia;
    }

    public Dao<User, Integer> getDao() {
        return dao;
    }

    public void setDao(Dao<User, Integer> dao) {
        this.dao = dao;
    }

    public List<User> getUsers() throws Exception{
        return dao.queryForAll();
    }

    public void addUser(User user) throws Exception{
        dao.create(user);
    }

    public User getUserByName(String name) throws Exception{
        User response = null;
        List<User> users = dao.queryForEq("name",name);

        if (!users.isEmpty()){
           response = users.get(0);
        }

        return response;
    }

}
