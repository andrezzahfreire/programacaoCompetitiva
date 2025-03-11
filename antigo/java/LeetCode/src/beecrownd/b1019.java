package beecrownd;

import java.util.Scanner;

public class b1019 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int entrada = scanner.nextInt();
        String hora = new String();

        int[] conversor = {3600,60,1};

        for (int i : conversor) {
            int temp = entrada / i;
            hora = hora + temp + ":"; 
            entrada %= i;
        }
        hora = hora.substring(0,hora.length()-1);
        System.out.println(hora);
        scanner.close();
    }
}
