package br.ifsc.edu.sqlliteexemplo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.Iterator;

public class UsuarioControler {
    Context mContext;
    UsuarioDao usuarioDao;
    public UsuarioControler(Context mContext) {
        this.mContext = mContext;
        usuarioDao = new UsuarioDao(mContext);
    }

    public void salvar(Usuario u){
        usuarioDao.inserir(u);
    }

    public ArrayList<Usuario> listaUsuarios(){
        Iterator<Usuario> it = usuarioDao.listaUsuarios().iterator();
        while (it.hasNext()){
            Usuario u = it.next();
            //Log.d("Usuario", )
        }


        return null;
    }
}
