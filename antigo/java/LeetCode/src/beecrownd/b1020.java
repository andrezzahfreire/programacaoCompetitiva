package beecrownd;

import java.util.Scanner;

public class b1020 {
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
        int entrada = scanner.nextInt();
        String hora = new String();

        int[] conversor = {365,30,1};
        String[] nome = {"ano(s)"," mes(es)","dia(s)"};

        for (int i : conversor) {
            int temp = entrada / i;
            hora = hora + temp + ":"; 
            entrada %= i;
            System.out.println(hora  + nome[i]);
        }
        hora = hora.substring(0,hora.length()-1);
        
        scanner.close();  
    }
}
