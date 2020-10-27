package com.asdeveloper.mascotas;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {
    ArrayList<Mascota> mascoFavo;
    private int i,j;
    Toolbar toolbar;
    ArrayList<Integer>  aLfotos = new ArrayList<Integer>();
    ArrayList<Integer>  aLLikes = new ArrayList<Integer>();
    ArrayList<String>   aLNombres = new ArrayList<String>();
    private RecyclerView rvwListaFavoritos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        rvwListaFavoritos = (RecyclerView) findViewById(R.id.rvFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        rvwListaFavoritos.setLayoutManager(llm);
        initToolBar();
        Bundle parametros = getIntent().getExtras();
        aLfotos = parametros.getIntegerArrayList("ListaFotos");
        aLLikes = parametros.getIntegerArrayList("ListaLike");
        aLNombres = parametros.getStringArrayList("ListaNombres");
        incialiazarMascotasFavoritas();
        inicializaAdaptador();
    }
    public  void incialiazarMascotasFavoritas(){
        mascoFavo = new ArrayList<Mascota>();
        for(i = 0; i < 5; i++)
        {
            mascoFavo.add(new Mascota(aLNombres.get(i),aLLikes.get(i),aLfotos.get(i)));
        }
    }
    public void inicializaAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascoFavo,this);
        rvwListaFavoritos.setAdapter(adaptador);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(Main2Activity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        return super.onKeyDown(keyCode, event);
    }
    public void initToolBar() {
        toolbar = (Toolbar) findViewById(R.id.miActionBar);
        ImageView imgEstrella = (ImageView) findViewById(R.id.ivEstrella);
        TextView  tvTitulo = (TextView)  findViewById(R.id.tvNombreAB);
        tvTitulo.setText("PETAGRAM");
        toolbar.setNavigationIcon(R.drawable.ic_action_arrow_left);
        toolbar.setNavigationOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(Main2Activity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                }
        );
    }

}
