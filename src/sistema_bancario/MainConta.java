import java.util.Scanner;


public class MainConta {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite seu nome: ");
        String nomeTitular = input.next();
        Conta conta1 = new Conta(nomeTitular);
        while (true){
            int operacao = conta1.menu(input);
            if (operacao == 1){
                System.out.println("Saldo atual: "+ conta1.getSaldo());
            }
            else if (operacao == 2){
                System.out.println("Digite o valor do saque: ");
                float saque = input.nextFloat();
                input.nextLine(); // limpa buffer
                conta1.sacar(saque);
            }
            else if (operacao == 3){
                System.out.println("Digite o valor do depósito: ");
                float deposito = input.nextFloat();
                input.nextLine(); // limpa buffer
                conta1.depositar(deposito);
                System.out.println("Depósito realizado! Saldo atual: "+conta1.getSaldo());
            }
            else if (operacao == 4){
                System.out.println("Saindo da aplicação...");
                break;
            }
            else{
                System.out.println("Operação inválida");
            }
        }
        input.close();
    }
}
