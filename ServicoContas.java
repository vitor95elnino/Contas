package com.mycompany.main;

public class ServicoContas {

    private Conta conta; // Apenas uma conta ativa
    //Cria uma nova Conta
    public void criar(Conta conta) {
        this.conta = conta;
    }
    //Consulta a conta pelo numero de conta
    public Conta consultar(String numero) {
        if (conta != null && conta.getNumeroConta().equals(numero)) {
            return conta;
        }
        return null;
    }
    //Altera os dados da conta 
    public boolean alterar(String numero, String novoNome, Morada morada) {
        if (conta != null && conta.getNumeroConta().equals(numero)) {
            conta.setNomeConta(novoNome);
            conta.setMorada(morada);
            return true;
        }
        return false;
    }
    //Elimina
    public boolean eliminar(String numero) {
        if (conta != null && conta.getNumeroConta().equals(numero)) {
            conta = null;
            return true;
        }
        return false;
    }
    //Deposita um valor na conta
    public boolean depositar(String numero, double valor) {
        if (conta != null && conta.getNumeroConta().equals(numero)) {
            conta.depositar(valor);
            return true;
        }
        return false;
    }
    //Levanta valor da conta
    public boolean levantar(String numero, double valor) {
        if (conta != null && conta.getNumeroConta().equals(numero)) {
            return conta.levantar(valor);
        }
        return false;
    }
    //Transferencia entre contas
    public boolean transferir(String deConta, String paraConta, double valor) {
        // Só existe uma conta ativa, por isso não é possível transferir
        System.out.println("Transferencia não disponivel: só existe uma conta ativa.");
        return false;
    }
    public boolean alterar(String nConta, String nome, String morada) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'alterar'");
    }
}
