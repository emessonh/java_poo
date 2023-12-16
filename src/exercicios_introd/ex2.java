package exercicios_introd;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ex2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Integer> numeros = new ArrayList<>();
        for (int c = 0; c < 5; c++){
            System.out.printf("Digite o %dº número: %n", c+1);
            int n = input.nextInt();
            numeros.add(n);
        }
        imprimiArray(numeros);
        input.close();
    }

    public static void imprimiArray(List<Integer> array){
        Collections.sort(array);
        Collections.reverse(array);
        for (int numero : array){
            System.out.println(numero);
        }
    }

}
