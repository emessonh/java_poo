package exercicios_poo;
import java.util.List;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class LocadoraDVD {
    String nome;
    String endereco;
    List<String> dvds = new ArrayList<>();
    List<Float> precos = new ArrayList<>();

    public LocadoraDVD(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }

    public void addDVD(Scanner input){
//        Scanner input = new Scanner(System.in);
        System.out.println("Digite o nome do DVD: ");
        String nome_dvd = input.nextLine().toLowerCase();
        this.dvds.add(nome_dvd);
        System.out.println("Digite o preço de alocação: ");
        Float preco = input.nextFloat();
        this.precos.add(preco);
        System.out.println("DVD adicionado com sucesso");
//        input.close();
    }

    public void excluirDVD(Scanner input){
        System.out.println("Digite o nome do dvd para excluí-lo: ");
        String nome_dvd = input.nextLine().toLowerCase();
        if (this.dvds.contains((nome_dvd))){
            int index = this.dvds.indexOf(nome_dvd);
            this.dvds.remove(index);
            this.precos.remove(index);
            System.out.println("DVD excluido com sucesso!");
        }else{
            System.out.println("DVD não existe!");
        }
    }

    public static int menu(Scanner input){
//        Scanner input = new Scanner(System.in);
        System.out.println("========Menu========");
        System.out.printf("1 - Alugar DVD%n" +
                          "2 - Devolver DVD%n" +
                          "3 - Menu Administrativo%n" +
                          "4 - Sair do menu%n" +
                           "====================%n");
        int operacao = 1;
        while (true){
            try {
                System.out.println("Digite a operação: ");
                operacao = input.nextInt();
                break;
            }
            catch (Exception e){
                System.out.println("ATENÇÃO! Digite um número!");
                input.nextLine(); // limpa buffer
            }
        }
//        System.out.println("Digite a operação: ");
//        operacao = input.nextInt();

        input.nextLine(); // limpa buffer

        return operacao;
    }

    public void menuAdministrativo(Scanner input){
        System.out.println("=========Menu Administrativo=========");
        System.out.printf("1 - Adicionar DVD%n" +
                          "2 - Remover DVD%n" +
                          "0 - Voltar ao menu anterior%n");
        System.out.println("=====================================");
        while (true){
            System.out.println("Digite a operação desejada: ");
            int operacao = input.nextInt();
            input.nextLine(); // limpa buffer
            if (operacao == 1){
                this.addDVD(input);
            }
            else if (operacao == 2){
                this.excluirDVD(input);
            } else if (operacao == 0) {
                System.out.println("Saindo do menu administrativo...");
                break;
            } else{
                System.out.println("Operação inválida");
            }
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        LocadoraDVD locadora = new LocadoraDVD("90's movie", "Av. Fernandes Lima, nº 134, Maceió - AL");
        System.out.println("Bem-vindo a locadora: "+locadora.nome);
        while (true){
            int operacao = locadora.menu(input);
            if (operacao == 1){
                System.out.println("Entrou na opção 1");
            }
            else if (operacao == 2){
                System.out.println("Entrou na opção 2");
            }
            else if (operacao == 3){
                locadora.menuAdministrativo(input);
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


