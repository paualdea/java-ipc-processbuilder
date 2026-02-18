package ut1.act2;

// IMPORTS
import java.util.Scanner;

public class Hijo {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        double n1, n2, suma, resta, mult, div;

        // Pedimos los dos numeros al scanner
        String n1_aux = sc.next();
        String n2_aux = sc.next();
        sc.close();

        // Obtenemos el valor Double del String
        n1 = Double.parseDouble(n1_aux);
        n2 = Double.parseDouble(n2_aux);

        // Realizamos las operaciones
        if (n2 == 0) {
            // Mandamos el aviso mediante error (err)
            System.err.println("No se puede dividir por 0");
            div = 0;
        } else {
            div = n1 / n2;
        }

        suma = n1 + n2;
        resta = n1 - n2;
        mult = n1 * n2;

        // Imprimimos los resultados al padre
        System.out.println(suma);
        System.out.println(resta);
        System.out.println(mult);
        System.out.println(div);
    }
}
