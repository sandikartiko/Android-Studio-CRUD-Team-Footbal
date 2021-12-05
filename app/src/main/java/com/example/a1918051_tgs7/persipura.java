package com.example.a1918051_tgs7;

public class persipura {
    private String _id, _nama_player, _posisi;
    public persipura (String id, String _nama_player, String _Posisi) {
        this._id = id;
        this._nama_player = _nama_player;
        this._posisi = _Posisi;
    }
    public persipura() {
    }
    public String get_id() {
        return _id;
    }
    public void set_id(String _id) {
        this._id = _id;
    }
    public String get_nama_player() {
        return _nama_player;
    }
    public void set_nama_player(String _nama_player) {
        this._nama_player = _nama_player;
    }
    public String get_posisi() {
        return _posisi;
    }
    public void set_posisi(String _posisi) {
        this._posisi = _posisi;
    }
}
