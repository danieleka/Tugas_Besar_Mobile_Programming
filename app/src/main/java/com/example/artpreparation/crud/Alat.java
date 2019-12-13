package com.example.artpreparation.crud;

public class Alat {
    private String _id, _nama, _jenis, _fungsi;

    public Alat(String id, String nama, String jenis, String fungsi) {
        this._id = id;
        this._nama = nama;
        this._jenis = jenis;
        this._fungsi = fungsi;
    }
    public Alat() {
    }

    public String get_id() {return _id;}
    public void set_id(String _id) {
        this._id = _id;
    }

    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }

    public String get_jenis() {
        return _jenis;
    }
    public void set_jenis(String _skill) {this._jenis= _skill;}

    public String get_fungsi() {
        return _fungsi;
    }
    public void set_fungsi(String _fungsi) {this._fungsi= _fungsi;}
}

