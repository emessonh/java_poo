package exercicios_introd;
import java.util.Scanner;

/**
 * Dia da semana
 */
public class ex1 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite um número: ");
        int n = input.nextInt();
        if (n == 1){
            System.out.println("Domingo");
        }
        else if (n == 2){
            System.out.println("Segunda-feira");
        }
        else if (n == 3){
            System.out.println("Terça-feira");
        }
        else if (n == 4){
            System.out.println("Quarta-feira");
        }
        else if (n == 5){
            System.out.println("Quinta-feira");
        }
        else if (n == 6){
            System.out.println("Sexta-feira");
        }
        else if (n == 7){
            System.out.println("Sábado");
        }
        else{
            System.out.println("Número inválido! Não há dia da semana com esse número.");
        }
        input.close();
    }
}
