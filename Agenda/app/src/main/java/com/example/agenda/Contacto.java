package com.example.agenda;

public class Contacto {
    private String name;
    private String company;
    private String telephone;

    public Contacto(String name, String company, String telephone) {
        this.name = name;
        this.company = company;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


}

