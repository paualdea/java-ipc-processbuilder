package ut1.act2;

// IMPORTS
import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Padre {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        double n1, n2;
        String suma = null, resta = null, mult = null, div = null;

        // Creamos el creador de procesos y el proceso hijo
        Process p = null;
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "-cp", "target/classes", "ut1.act2.Hijo");
            pb.redirectError(ProcessBuilder.Redirect.INHERIT);
            p = pb.start();
        } catch (IOException e) {
            System.err.println("Error en la creación del proceso hijo");
        }

        // Si el proceso se crea seguimos, sino acabamos
        if (p != null) {
            try {
                // Pedimos los dos numeros por Scanner
                System.out.print("Numero 1: ");
                n1 = sc.nextDouble();
                System.out.print("Numero 2: ");
                n2 = sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Introduce sólo números");

                // Cerramos el programa
                return;
            } finally {
                sc.close();
            }

            // Creamos el objeto que mandara el mensaje al hijo
            PrintWriter pw = null;
            try {
                pw = new PrintWriter(new OutputStreamWriter(p.getOutputStream()), true);
            } catch (Exception e){
                System.err.println("Error en la creación del PrintWriter");
            }

            // Comprobamos que el mensajero no este en null
            if (pw != null) {
                // Mandamos los mensajes
                pw.println(n1);
                pw.println(n2);
                // Limpiamos y cerramos conexión
                pw.flush();
                pw.close();
            }

            // Leemos la respuesta del hijo usando BufferedReader
            try {
                BufferedReader bf = new BufferedReader(new InputStreamReader(p.getInputStream()));

                // Obtenemos los resultados
                suma = bf.readLine();
                resta = bf.readLine();
                mult = bf.readLine();
                div = bf.readLine();
            } catch (IOException e) {
                System.err.println("Error al obtener las respuestas del hijo");
            }

            // Imprimimos los resultados por pantalla
            System.out.println("\nSuma = " + suma);
            System.out.println("Resta = " + resta);
            System.out.println("Multiplicación = " + mult);
            System.out.println("División = " + div);
        }
    }
}