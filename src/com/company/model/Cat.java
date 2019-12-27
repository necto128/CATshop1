package com.company.model;

public class Cat {
    private int idCat;
    private String nameCat;
    private int idDad;
    private int idMam;
    private String gender;

    public  Cat(int idCat,String nameCat,int idDad,int idMam,String gender){
        this.idCat = idCat;
        this.nameCat = nameCat;
        this.idDad = idDad;
        this.idMam = idMam;
        this.gender = gender;
    }
    public  Cat(String nameCat,int idDad,int idMam,String gender){
        this.idCat = idCat;
        this.nameCat = nameCat;
        this.idDad = idDad;
        this.idMam = idMam;
        this.gender = gender;
    }
    public  Cat(){}
    public int getIdCat() {
        return idCat;
    }

    public void setIdCat(int idCat) {
        this.idCat = idCat;
    }

    public String getNameCat() {
        return nameCat;
    }

    public void setNameCat(String nameCat) {
        this.nameCat = nameCat;
    }

    public int getIdDad() {
        return idDad;
    }

    public void setIdDad(int idDad) {
        this.idDad = idDad;
    }

    public int getIdMam() {
        return idMam;
    }

    public void setIdMam(int idMam) {
        this.idMam = idMam;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        if (idCat == 0) {
            return "Запись не найдена";
        } else {
            return "Cat{ " +
                    "Id Кота=" + idCat +
                    ", Имя='" + nameCat + '\'' +
                    ", Id Отца=" + idDad +
                    ", Id Матери=" + idMam +
                    ", пол='" + gender + '\'' +
                    " }";
        }

    }

}
