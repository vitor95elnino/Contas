package com.mycompany.main;

//Classe que presenta uma conta Ordenado
//Herda da ContaOrdem e permite um saldo negativo limite
public class ContaOrdenado extends ContaOrdem {
    private double limiteNegativo; //limite maximo de  saldo negativo

    //Construtor da ContaOrdenado
    public ContaOrdenado(String numeroConta, String nomeConta, Morada morada, double saldo,
                         double saldoMinimo, boolean temCartaoCredito, double limiteNegativo) {
        super(numeroConta, nomeConta, morada, saldo, saldoMinimo, temCartaoCredito);
        this.limiteNegativo = limiteNegativo;
    }

    @Override
    //Métododo para levantar dinheiro, valida o saldo minimo
    public boolean levantar(double valor) {
        if (valor > 0 && saldo - valor >= -limiteNegativo) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}
