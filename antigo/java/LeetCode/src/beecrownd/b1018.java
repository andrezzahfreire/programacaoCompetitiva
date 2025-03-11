package beecrownd;

import java.util.Scanner;

/**
 * 1018
 */
public class b1018 {
    public static void main(String[] args) throws Exception {
       Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();

        int[] notas = {100,50,20,10,5,2,1};

        for (int i : notas) {
            int qtd = numero / i;
            System.out.println(qtd + " nota(s) de R$ " + i + ",00");
            numero %= i;
            
        }
      //  scanner.close();
    }
    
}