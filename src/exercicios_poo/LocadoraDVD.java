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
    List<String> dvdsEmprestados = new ArrayList<>();

    public LocadoraDVD(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }

    public void addDVD(String nome_dvd, Float preco){
        this.dvds.add(nome_dvd);
        this.precos.add(preco);
        System.out.println("DVD adicionado com sucesso");
    }

    public void excluirDVD(String nome_dvd){
        if (this.dvds.contains((nome_dvd))){
            int index = this.dvds.indexOf(nome_dvd);
            this.dvds.remove(index);
            this.precos.remove(index);
            System.out.println("DVD excluido com sucesso!");
        }else{
            System.out.println("DVD não existe!");
        }
    }

    public void alugarDVD(String nomeDVD){
        if (this.dvdsEmprestados.contains(nomeDVD)){
            System.out.println("ATENÇÃO! Operação inválida, DVD já foi alugado!");
        }
        else{
            if (this.dvds.contains(nomeDVD)) {
                this.dvdsEmprestados.add(nomeDVD);
                System.out.println("Aluguel aprovado. Volte sempre!");
            }
            else if (this.dvds.isEmpty()){
                System.out.println("Desculpe, não há DVD's cadastrados");
            }
            else{
                System.out.println("Desculpe, não temos esse dvd!");
            }
        }
    }

    public void devolverDVD(String nomeDvd, int qtd_dias, Float multas){
        if (this.dvdsEmprestados.contains(nomeDvd)){
            this.dvdsEmprestados.remove(nomeDvd);
            int index = this.dvds.indexOf(nomeDvd);
            Float total_pagar = this.precos.get(index)*qtd_dias + multas;
            System.out.printf("Valor a pagar: %n" +
                              "Valor total: %.2f%n" +
                              "Valor aluguel: %.2f%n" +
                              "Multas: %.2f%n", total_pagar, total_pagar-multas, multas);
            System.out.println("Obrigado pela preferência!");
        }
        else{
            System.out.println("DVD não encontrado!");
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
                System.out.println("Digite o nome do DVD: ");
                String nome_dvd = input.nextLine().toLowerCase();
                System.out.println("Digite o preço de alocação: ");
                Float preco = input.nextFloat();
                this.addDVD(nome_dvd, preco);
            }
            else if (operacao == 2){
                System.out.println("Digite o nome do dvd para excluí-lo: ");
                String nome_dvd = input.nextLine().toLowerCase();
                this.excluirDVD(nome_dvd);
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
                System.out.println("Digite o DVD que será alugado: ");
                String nome_dvd = input.nextLine().toLowerCase();
                locadora.alugarDVD(nome_dvd);
            }
            else if (operacao == 2){
                System.out.println("Digite o DVD que será devolvido: ");
                String nome_dvd = input.nextLine().toLowerCase();
                System.out.println("Digite a quantidade de dias do aluguel: ");
                int dias = input.nextInt();
                input.nextLine(); // limpar buffer
                System.out.println("Valor de multas: ");
                Float multas = input.nextFloat();
                locadora.devolverDVD(nome_dvd, dias, multas);
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


