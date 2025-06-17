package com.mycompany.trabalhopratico2vitorjoao;

//Classe que representa uma conta a ordem 
//Herda da classe Conta
public class ContaOrdem extends Conta {
    protected double saldoMinimo;
    protected boolean temCartaoCredito;

    //Construtor da ContaOrdem
    public ContaOrdem(String numeroConta, String nomeConta, Morada morada, double saldo,
                      double saldoMinimo, boolean temCartaoCredito) {
        super(numeroConta, nomeConta, morada, saldo); //chamada ao construtor da superclasse
        this.saldoMinimo = saldoMinimo;
        this.temCartaoCredito = temCartaoCredito;
    }

    @Override
    //Métododo para levantar dinheiro, valida o saldo minimo
    public boolean levantar(double valor) {
        if (valor > 0 && saldo - valor >= saldoMinimo) {
            saldo -= valor;
            return true;
        }
        return false;
    }
}
