package exercicios_poo;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class LocadoraDVD {
    String nome;
    String endereco;
    List<String> dvds;
    List<Float> precos;

    public LocadoraDVD(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
    }

    public static int menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("========Menu========");
        System.out.printf("1 - Alugar DVD%n" +
                          "2 - Devolver DVD%n" +
                           "====================%n");
        System.out.println("Digite a operação: ");
        int operacao = input.nextInt();
        input.close();
        return operacao;
    }

    public static void main(String[] args) {
        LocadoraDVD locadora = new LocadoraDVD("90's movie", "Av. Fernandes Lima, nº 134, Maceió - AL");
        System.out.println("Bem-vindo a locadora: "+locadora.nome);
        locadora.menu();
    }
}


