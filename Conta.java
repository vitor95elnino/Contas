package com.mycompany.trabalhopratico2vitorjoao;

// Classe pai, pois todas as outras contas herdam as variavesis e os metodos desta classe.
// Classe abstrata que representa uma conta genérica
// Serve como base para os tipos de conta a prazo, ordem e ordenado
public abstract class Conta {
    protected String numeroConta;
    protected String nomeConta;
    protected Morada morada;
    protected double saldo;

    //Construtur da classe Conta
    public Conta(String numeroConta, String nomeConta, Morada morada, double saldo) {
    this.numeroConta = numeroConta;
    this.nomeConta = nomeConta;
    this.morada = morada;
    this.saldo = saldo;
}

    // Métodos getters 
    // Método para obter os dados da conta (getters )
    public String getNumeroConta() {
        return numeroConta;
    }

    public String getNomeConta() {
        return nomeConta;
    }

    public Morada getMorada() {
        return morada;
    }

    public double getSaldo() {
        return saldo;
    }

    // Métodos setters
    // Método para alterar os dados da conta (setters )
    public void setNomeConta(String nomeConta) {
        this.nomeConta = nomeConta;
    }

    public void setMorada(Morada morada) {
        this.morada = morada;
    }

    // Métodos para depositos
    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
    }

    public abstract boolean levantar(double valor); // método abstrato (cada tipo de conta terá regras diferentes)
}


