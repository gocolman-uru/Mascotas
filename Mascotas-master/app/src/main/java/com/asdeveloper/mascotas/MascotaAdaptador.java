package com.asdeveloper.mascotas;
import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {
    ArrayList<Mascota> mascotas;
    Activity activity;
    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview1,parent,false);
        return new MascotaViewHolder(v);
    }
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, final int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.ivFoto.setImageResource(mascota.get_foto());
        mascotaViewHolder.tvNombre.setText(mascota.get_nombre());
        mascotaViewHolder.tvLike.setText(Integer.toString(mascota.get_like()));
        mascotaViewHolder.ivBtnSetLike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                mascotas.get(position).set_like(1);
                mascotaViewHolder.tvLike.setText(Integer.toString(mascotas.get(position).get_like()));
                Toast.makeText(activity,mascota.get_nombre(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return mascotas.size();
    }
    public static class MascotaViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivFoto;
        private TextView tvNombre;
        private TextView  tvLike;
        private ImageView ivBtnSetLike;
        private ImageView ivBtnLike;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.ivFoto);
            tvNombre = (TextView) itemView.findViewById(R.id.tvNombre);
            tvLike = (TextView) itemView.findViewById(R.id.tvLike);
            ivBtnLike = (ImageView) itemView.findViewById(R.id.ivBtnLike);
            ivBtnSetLike = (ImageView) itemView.findViewById(R.id.ivBtnSetLike);
        }
    }
}