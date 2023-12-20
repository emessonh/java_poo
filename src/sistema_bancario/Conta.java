import java.util.Scanner;

public class Conta {

    String nomeTitular;
    float saldo = 0;

    public Conta(String nomeTitular){
        this.nomeTitular = nomeTitular;
    }

    public float getSaldo(){
        return this.saldo;
    }


    public String getTitular(){
        return this.nomeTitular;
    }

    public void sacar(float saque){
        float saldoAtual = this.getSaldo();
        if (saldoAtual == 0 || saque > saldoAtual){
            System.out.println("Operação não realizado! Saldo insuficiente.");
        }
        else{
            this.saldo -= saque;
            System.out.println("Saque realizado com sucesso! Saldo atual: "+ getSaldo());
        }
    }

    public void depositar(float deposito){
        this.saldo += deposito;
        System.out.println("Depósito realizado com sucesso");
    }

    public int menu(Scanner input){
        System.out.printf("==============Menu bancário================%n" +
                          "1 - Mostrar Saldo%n"+
                          "2 - Sacar%n"+
                          "3 - Depositar%n"+
                          "4 - Sair%n" +
                          "===========================================%n");
        int operacao = input.nextInt();
        input.nextLine(); //limpa buffer
        return operacao;
    }

    
}