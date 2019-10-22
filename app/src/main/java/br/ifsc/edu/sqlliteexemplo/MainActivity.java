package br.ifsc.edu.sqlliteexemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNome;
    Button button;
    UsuarioControler usuarioControler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.nome_usuario);
        button = findViewById(R.id.gravar);
        usuarioControler = new UsuarioControler(getApplicationContext());
        //Configurar on Click do Button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                usuarioControler.salvar(new Usuario(editTextNome.getText().toString()));

            }
        });
    }

    //LoadListView
    public void loadListView(){
        ArrayAdapter<String> adapter = new ArrayAdapter(getApplicationContext(),
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            usuarioControler.getListaNomeUsuario());

    }
}
