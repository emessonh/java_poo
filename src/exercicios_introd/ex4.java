package exercicios_introd;
import java.util.Scanner;

public class ex4 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o valor do lado 1: ");
        float a = input.nextFloat();
        System.out.println("Digite o valor do lado 2: ");
        float b = input.nextFloat();
        System.out.println("Digite o valor do lado 3: ");
        float c = input.nextFloat();

        input.close();

        if (eTriangulo(a, b, c) == true){
            if (eEscaleno(a, b, c) == true){
                System.out.println("O triângulo é escaleno");
            }
            else if (eEquilatero(a, b, c) == true){
                System.out.println("O triângulo é equilátero");
            }
            else{
                System.out.println("O triângulo é isóceles");
            }

        }
        else{
            System.out.println("Os valores informados não formam um triângulo");
        }

    }

    public static boolean eTriangulo(float a, float b, float c){
        if (a > Math.abs(c-b) && a < Math.abs(c+b)){
            if (b > Math.abs(a-c) && b < Math.abs(a+c)){
                if (c > Math.abs(a-b) && c < Math.abs(a+b)){
                    return true;
                }
                else{
                    return false;
                }
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    public static boolean eEscaleno(float a, float b, float c){
        if (a != b && a != c && c != b){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean eEquilatero(float a, float b, float c){
        if (a == b && c == b & c == a){
            return true;
        }
        else{
            return false;
        }
    }

}
