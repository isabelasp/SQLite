package br.ifsc.edu.sqlliteexemplo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class UsuarioDao {
    SQLiteDatabase sqLiteDataBase;
    Context mContext;
    public UsuarioDao(Context c) {
        mContext = c;
        sqLiteDataBase = c.openOrCreateDatabase("IsabelaDB", c.MODE_PRIVATE, null);
        sqLiteDataBase.execSQL("CREATE TABLE IF NOT EXISTS usuario(id INTEGER PRIMARY KEY AUTOINCREMENT, "+
                "nome VARCHAR);");
    }

    public void inserir(Usuario u){
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", u.nome);
        sqLiteDataBase.insert("usuario", null,contentValues);
    }

    public ArrayList<Usuario> listaUsuarios(){
        ArrayList<Usuario> listaUsuariosResult = new ArrayList<Usuario>();

        Cursor cursor =  sqLiteDataBase.rawQuery("SELECT * FROM  usuario", null);
        cursor.moveToFirst();

        do{
            listaUsuariosResult.add(
                        new Usuario(cursor.getInt(cursor.getColumnIndex("id")),
                                   cursor.getString(cursor.getColumnIndex("nome"))
                                   )
                                 );
        }while (cursor.moveToNext());
        return listaUsuariosResult;
    }
}
