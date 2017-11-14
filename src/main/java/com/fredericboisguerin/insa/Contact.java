package com.fredericboisguerin.insa;

public class Contact {

    String name;
    String mail;
    String phone;

    public Contact(String name, String mail, String phone) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void printContact(){

        System.out.printf("%s, %s, %s", this.name, this.mail, this.phone);
    }
}


