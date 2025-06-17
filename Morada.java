package com.mycompany.trabalhopratico2vitorjoao;
public class Morada {
    private String rua;
    private String cidade;
    private String codigoPostal;

    public Morada(String rua, String cidade, String codigoPostal) {
        this.rua = rua;
        this.cidade = cidade;
        this.codigoPostal = codigoPostal;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    @Override
    public String toString() {
        return rua + ", " + codigoPostal + " " + cidade;
    }
}
