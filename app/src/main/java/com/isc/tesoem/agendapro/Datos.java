package com.isc.tesoem.agendapro;

public class Datos {

    private String Name, Tel, Address, Email;

    public Datos() {
    }

    public Datos(String name, String tel, String address, String email) {
        Name = name;
        Tel = tel;
        Address = address;
        Email = email;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
