package com.arief.web.entity;

public class Person {

    private int kode;
    private String nama;
    private String gender;


    public Person(){}
    public Person(int kode , String nama , String gender){
        this.kode=kode;
        this.nama=nama;
        this.gender=gender;
    }

    public Person(String nama, String gender) {
        this.nama = nama;
        this.gender = gender;
    }

    public void setKode(int kode){
        this.kode=kode;
    }
    public void setNama(String nama){
        this.nama=nama;
    }
    public void setGender(String gender){
        this.gender=gender;
    }

    public int getKode(){
        return kode;
    }
    public String getNama(){
        return nama;
    }
    public String getGender(){
        return gender;
    }

    @Override
    public String toString() {
        return "Person{" +
                "kode=" + kode +
                ", nama='" + nama + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}
