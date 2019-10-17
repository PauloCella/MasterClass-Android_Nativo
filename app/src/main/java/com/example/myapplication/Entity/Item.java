package com.example.myapplication.Entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {

    private int id;
    private String nome;
    private String email;

    public Item(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Item(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public Item() {
    }

    protected Item(Parcel in) {
        nome = in.readString();
        email = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nome);
        dest.writeString(email);
    }
}
