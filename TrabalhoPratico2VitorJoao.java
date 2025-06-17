/*
    Trabalho Pratico realizado por Vitor Gomes (ispg2019100579@ispgaya.pt) e João Magalhães (ispg2024101974@ispgaya.pt)

    Abstração 
    - A classe Conta é uma abstração de uma conta bancária genérica.
    - Os métodos como levantar() são definidos de forma abstrata para que cada tipo de conta implemente a sua própria lógica.

    Encapsulamento
    - Os atributos como saldo, nomeConta, etc., são protected ou private.
    - O acesso é feito através de métodos get e set.

    Herança
    - ContaOrdem, ContaPrazo e ContaOrdenado herdam de Conta.
    - ContaOrdenado herda de ContaOrdem.

    Polimorfismo 
    - O método levantar() é implementado de maneira diferente em cada tipo de conta, de acordo com as suas regras.
*/


package com.mycompany.trabalhopratico2vitorjoao;

import java.util.Scanner;

public class TrabalhoPratico2VitorJoao {
    
    public static void main(String[] args) {
        ServicoContas contaService = new ServicoContas(); // Objeto Conta Servico
        Scanner input = new Scanner(System.in);
        //Declaraçaõ de variaveis
        int opcao; 
        String nConta, nome; //nConta, Exemplo:PT500000
        String morada;
        double valor;      
        String resposta; 

        do {
            //Menu Principal
            System.out.println("\n=====MENU - GESTAO DE CONTA =====");
            System.out.println("1. Criar Conta");
            System.out.println("2. Consultar Conta");
            System.out.println("3. Alterar Conta");
            System.out.println("4. Eliminar Conta");
            System.out.println("5. Levantamentos");
            System.out.println("6. Depositos");
            System.out.println("7. Transferencias");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opcao: ");

            opcao = input.nextInt(); //Lê o numero equivalente a opção escolhida pelo utilizador
            input.nextLine(); 

            switch (opcao) { //Estrutura de dados case que permite a interação com o Utilizador
                
                case 1: // Criar uma conta e escolher o tipo de conta
                    System.out.println("Tipo de conta: 1) Prazo  2) Ordem  3) Ordenado");
                    int tipo = input.nextInt();
                    input.nextLine();
                    System.out.print("Numero da conta: (Ex:PT00...) ");
                    nConta = input.nextLine(); //PT500000
                    System.out.print("Nome do titular: ");
                    nome = input.nextLine();
                     // Pedir dados da morada
                    System.out.print("Rua: ");
                    String rua = input.nextLine();
                    System.out.print("Cidade: ");
                    String cidade = input.nextLine();
                    System.out.print("Código Postal: ");
                    String codigoPostal = input.nextLine();
                    Morada moradaObj = new Morada(rua, cidade, codigoPostal);
                    System.out.print("Saldo inicial: ");
                    valor = input.nextDouble();
                    input.nextLine();

                    Conta novaConta = null;
                    if (tipo == 1) {
                        System.out.print("Prazo em dias: ");
                        int prazo = input.nextInt(); 
                        input.nextLine();
                        System.out.print("Data de criacao: ");
                        String data = input.nextLine();
                        System.out.print("Taxa de juro: ");
                        double taxa = input.nextDouble();
                        input.nextLine();
                        novaConta = new ContaPrazo(nConta, nome, moradaObj, valor, prazo, data, taxa);
                    } else if (tipo == 2) {
                        System.out.print("Saldo minimo: ");
                        double saldoMin = input.nextDouble();
                        input.nextLine();
                        System.out.print("Tem cartao de credito? (true/false): ");
                        boolean cartao = input.nextBoolean();
                        input.nextLine();
                        novaConta = new ContaOrdem(nConta, nome, moradaObj, valor, saldoMin, cartao);
                    } else if (tipo == 3) {
                        System.out.print("Saldo minimo: ");
                        double saldoMin = input.nextDouble();
                        input.nextLine();
                        System.out.print("Tem cartao de credito? (true/false): ");
                        boolean cartao = input.nextBoolean();
                        input.nextLine();
                        System.out.print("Limite negativo: ");
                        double limite = input.nextDouble();
                        input.nextLine();
                        novaConta = new ContaOrdenado(nConta, nome, moradaObj, valor, saldoMin, cartao, limite);

                    }
                    if (novaConta != null) {
                        contaService.criar(novaConta);
                        System.out.println("Conta criada com sucesso!");
                    } else {
                        System.out.println("Erro ao criar conta.");
                    }
                    break;

                case 2: //Consultar conta
                    System.out.print("Numero da conta: (Ex:PT00...) ");
                    nConta = input.nextLine();
                    Conta conta = contaService.consultar(nConta);
                    if (conta != null) {
                        System.out.println("Nome: " + conta.getNomeConta());
                        System.out.println("Morada: " + conta.getMorada());
                        System.out.println("Saldo: " + conta.getSaldo());
                    } else {
                        System.out.println("Conta nao encontrada.");
                    }
                    System.out.print("Deseja voltar ao menu principal? (s/n)");
                    resposta = input.nextLine();
                    if ("s".equals(resposta)) {
                        break;
                    } else if ("n".equals(resposta)){
                        System.out.print("Adeus, obrigada por utilizar este programa !");
                    } else {
                        System.out.print("Opcao invalida. \n");
                    }
                        
                    
                case 3://Alterar dados da conta 
                    System.out.print("Numero da conta: (Ex:PT00...) ");
                    nConta = input.nextLine();
                    System.out.print("Novo nome: ");
                    nome = input.nextLine();
                    System.out.print("Nova morada: ");
                    morada = input.nextLine();
                    if (contaService.alterar(nConta, nome, morada)) {
                        System.out.println("Conta alterada.");
                    } else {
                        System.out.println("Conta nao encontrada.");
                    }
                    System.out.print("Deseja voltar ao menu principal? (s/n)");
                    resposta = input.nextLine();
                    if ("s".equals(resposta)) {
                        break;
                    } else if ("n".equals(resposta)){
                        System.out.print("Adeus, obrigada por utilizar este programa !");
                    } else {
                         System.out.print("Opcao invalida. \n");
                    }

                case 4: //Elimnar conta
                    System.out.print("Numero da conta: (Ex:PT00...) ");
                    nConta = input.nextLine();
                    if (contaService.eliminar(nConta)) {
                        System.out.println("Conta eliminada.");
                    } else {
                        System.out.println("Conta não encontrada.");
                    }
                    System.out.print("Deseja voltar ao menu principal? (s/n)");
                    resposta = input.nextLine();
                    if ("s".equals(resposta)) {
                        break;
                    } else if ("n".equals(resposta)){
                        System.out.print("Adeus, obrigada por utilizar este programa !");
                    } else {
                         System.out.print("Opcao invalida. \n");
                    }

                case 5: //Levantamento 
                    System.out.print("Numero da conta: (Ex:PT00...) ");
                    nConta = input.nextLine();
                    System.out.print("Valor a levantar: ");
                    valor = input.nextDouble();
                    input.nextLine();
                    if (contaService.levantar(nConta, valor)) {
                        System.out.println("Levantamento efetuado.");
                    } else {
                        System.out.println("Erro: saldo insuficiente ou conta nao encontrada.");
                    }
                    System.out.print("Deseja voltar ao menu principal? (s/n)");
                    resposta = input.nextLine();
                    if ("s".equals(resposta)) {
                        break;
                    } else if ("n".equals(resposta)){
                        System.out.print("Adeus, obrigada por utilizar este programa !");
                    } else {
                         System.out.print("Opcao invalida. \n");
                    }

                case 6: //Depositos
                    System.out.print("Numero da conta: (Ex:PT00...) ");
                    nConta = input.nextLine();
                    System.out.print("Valor a depositar: ");
                    valor = input.nextDouble();
                    input.nextLine();
                    if (contaService.depositar(nConta, valor)) {
                        System.out.println("Deposito efetuado.");
                    } else {
                        System.out.println("A sua conta não foi encontrada.");
                    }
                    System.out.print("Deseja voltar ao menu principal? (s/n)");
                    resposta = input.nextLine();
                    if ("s".equals(resposta)) {
                        break;
                    } else if ("n".equals(resposta)){
                        System.out.print("Adeus, obrigada por utilizar este programa !");
                    } else {
                         System.out.print("Opcao invalida. \n");
                    }

                case 7: //Transferências entre contas
                    System.out.print("Numero da conta de origem:(Ex:PT00...)");
                    String deConta = input.nextLine();
                    System.out.print("Numero da conta de destino:(Ex:PT00...) ");
                    String paraConta = input.nextLine();
                    System.out.print("Valor a transferir: ");
                    valor = input.nextDouble();
                    input.nextLine();
                    if (contaService.transferir(deConta, paraConta, valor)) {
                        System.out.println("Transferecia confirmada.");
                    } else {
                        System.out.println("Erro na transferencia. Verifique a contas ou  o seu saldo.");
                    }
                    System.out.print("Deseja voltar ao menu principal? (s/n)");
                    resposta = input.nextLine();
                    if ("s".equals(resposta)) {
                        break;
                    } else if ("n".equals(resposta)){
                        System.out.print("Adeus, obrigada por utilizar este programa !");
                    } else {
                         System.out.print("Opcao invalida. \n");
                    }

                case 0:
                    System.out.println("A sair do programa....");
                    break;

                default:
                    System.out.println("Opcao invalida.");
            }
        } while (opcao != 0);

        input.close();
    }
}
