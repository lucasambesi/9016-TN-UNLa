package com.example.clases;

import android.content.Context;

import com.j256.ormlite.android.apptools.OpenHelperManager;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;

import java.sql.SQLException;
import java.util.List;

public class ExamenManager {

    private static ExamenManager instancia;
    Dao<Examen, Integer> dao;

    public ExamenManager(Context context) {
        OrmLiteSqliteOpenHelper helper = OpenHelperManager.getHelper(context, DBHelper.class);
        try{
            dao = helper.getDao(Examen.class);
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static ExamenManager getInstancia(Context context){
        if(instancia == null){
            instancia = new ExamenManager(context);
        }
        return instancia;
    }

    public Dao<Examen, Integer> getDao() {
        return dao;
    }

    public void setDao(Dao<Examen, Integer> dao) {
        this.dao = dao;
    }

    public List<Examen> getExamenes() throws Exception{
        return dao.queryForAll();
    }

    public void agregarExamen(Examen examen) throws Exception{
        dao.create(examen);
    }



}
