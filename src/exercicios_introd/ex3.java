package exercicios_introd;
import java.util.Scanner;

/**
 * Ano Bissexto
 */

public class ex3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite um ano válido: ");
        int ano = input.nextInt();
        if (ano % 4 == 0){
            if (ano % 100 == 0 && ano % 400 == 0){
                System.out.println(ano+" é ano bissexto");
            }
            else if (ano % 100 != 0 && ano % 400 != 0){
                System.out.println(ano+" é ano bissexto");
            }
            else{
                System.out.println(ano+" não é ano bissexto");
            }
        }
        else{
            System.out.println(ano+" não é ano bissexto");
        }
        input.close();
    }
}