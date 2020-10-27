package com.asdeveloper.mascotas;

public class Mascota {
    private String _nombre;
    private int _like;
    private int _foto;
    public Mascota(String nombre,int like,int foto) {
        this._nombre = nombre;
        this._like = like;
        this._foto = foto;
    }
    public String get_nombre() {
        return _nombre;
    }

    public void set_nombre(String _nombre) {
        this._nombre = _nombre;
    }

    public int get_like() {
        return _like;
    }

    public void set_like(int _like) {
        this._like += _like;
    }

    public int get_foto() {
        return _foto;
    }

    public void set_foto(int _foto) {
        this._foto = _foto;
    }
}
