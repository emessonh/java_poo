package exercicios_poo;
import java.util.List;
import java.util.ArrayList;
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
        String nome_dvd = input.nextLine();
        this.dvds.add(nome_dvd);
        System.out.println("Digite o preço de alocação: ");
        Float preco = input.nextFloat();
        this.precos.add(preco);
        System.out.println("DVD adicionado com sucesso");
//        input.close();
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

                if (operacao == 3){
                    input.close();
                }
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
                locadora.addDVD(input);
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


