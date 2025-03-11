import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();  // Lê o número de entradas
        int h = scanner.nextInt();  // Lê a altura limite
        
        scanner.nextLine();  // Consome a quebra de linha restante
        
        String alturas = scanner.nextLine();  // Lê todas as alturas numa única linha
        String[] altura = alturas.split(" ");  // Divide as alturas pelos espaços
        
        int[] min = new int[n];  // Cria o array para armazenar as alturas
        int c = 0;

        // Preenche o array min com as alturas convertidas para inteiros
        for (int i = 0; i < n; i++) {
            min[i] = Integer.parseInt(altura[i]);
        }

        // Conta quantos valores são menores ou iguais a h
        for (int i = 0; i < min.length; i++) {
            if (min[i] <= h) {
                c++;
            }
        }

        System.out.println(c);  // Imprime o resultado
        scanner.close();
    }

    
}
