package com.mycompany.trabalhopratico2vitorjoao;

//Classe que representa uma conta a prazo, herda da classe conta
public class ContaPrazo extends Conta {
    private int prazoDias; //Prazo da conta em dias
    private String dataCriacao; //Data em que a conta foi criada
    private double taxaJuro; //Taxa de juro associada 

    public ContaPrazo(String numeroConta, String nomeConta, Morada morada, double saldo,
                      int prazoDias, String dataCriacao, double taxaJuro) {
        super(numeroConta, nomeConta, morada, saldo); //chamada ao construtor da superclasse
        this.prazoDias = prazoDias;
        this.dataCriacao = dataCriacao;
        this.taxaJuro = taxaJuro;
    }
    //Método que não permite o levantamente antes do prazo
    @Override
    public boolean levantar(double valor) {
        // regra simplificada: não permite levantamento antes do prazo
        System.out.println("Levantamento nao permitido numa conta a prazo.");
        return false;
    }
}
