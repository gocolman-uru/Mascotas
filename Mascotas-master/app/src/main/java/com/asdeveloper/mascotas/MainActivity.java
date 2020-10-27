package com.asdeveloper.mascotas;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Mascota> mascotas;
    private int max_favorito;
    private int i,j;
    private int[] max_favoritos = {0,1,2,3,7};
    private RecyclerView rvMascotas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Deberia iniciar la camara", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        //
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        max_favorito = 5;
        ImageView imgEstrella = (ImageView) findViewById(R.id.ivEstrella);
        imgEstrella.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer>  aLfotos = new ArrayList<Integer>();
                ArrayList<Integer>  aLLikes = new ArrayList<Integer>();
                ArrayList<String>   aLNombres = new ArrayList<String>();
                Bundle bunParam = new Bundle();
                for(i = 0; i < max_favoritos.length; i++)
                {
                    aLfotos.add(mascotas.get(max_favoritos[i]).get_foto());
                    aLLikes.add(mascotas.get(max_favoritos[i]).get_like());
                    aLNombres.add(mascotas.get(max_favoritos[i]).get_nombre());
                }
                bunParam.putIntegerArrayList("ListaFotos",aLfotos);
                bunParam.putIntegerArrayList("ListaLike",aLLikes);
                bunParam.putStringArrayList("ListaNombres",aLNombres);
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                intent.putExtras(bunParam);
                startActivity(intent);
                finish();
            }
        });
        RecyclerView rvMascotas = (RecyclerView) findViewById(R.id.rvlMascota);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvMascotas.setLayoutManager(llm);
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Atlas",0, R.drawable.m1));
        mascotas.add(new Mascota("Ajax",0, R.drawable.m2));
        mascotas.add(new Mascota("Jupiter",0, R.drawable.m3));
        mascotas.add(new Mascota("Eros",0, R.drawable.m4));
        mascotas.add(new Mascota("Juno",0, R.drawable.m5));
        mascotas.add(new Mascota("Venus",0, R.drawable.m6));
        mascotas.add(new Mascota("Luna",0, R.drawable.m7));
        mascotas.add(new Mascota("Zeus",0, R.drawable.m8));
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        rvMascotas.setAdapter(adaptador);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
