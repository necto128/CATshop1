package com.company.model;

public class Cat {
    private int IdCat;
    private String NameCat;
    private int IdDad;
    private int IdMam;
    private String gender;

    public int getIdCat() {
        return IdCat;
    }

    public void setIdCat(int idCat) {
        this.IdCat = idCat;
    }

    public String getNameCat() {
        return NameCat;
    }

    public void setNameCat(String nameCat) {
        this.NameCat = nameCat;
    }

    public int getIdDad() {
        return IdDad;
    }

    public void setIdDad(int idDad) {
        this.IdDad = idDad;
    }

    public int getIdMam() {
        return IdMam;
    }

    public void setIdMam(int idMam) {
        this.IdMam = idMam;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        if (IdCat == 0) {
            return "Запись не найдена";
        } else {
            return "Cat{ " +
                    "Id Кота=" + IdCat +
                    ", Имя='" + NameCat + '\'' +
                    ", Id Отца=" + IdDad +
                    ", Id Матери=" + IdMam +
                    ", пол='" + gender + '\'' +
                    " }";
        }

    }

}
