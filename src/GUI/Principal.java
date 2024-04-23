package GUI;
import Modelos.Divisa;
import Servicio.ConsultaDivisa;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

// key = 0d08555a04a8f7819024f0ef
public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcion;
        Scanner scanner = new Scanner(System.in);
        ConsultaDivisa consulta = new ConsultaDivisa();
        System.out.println(" ");
        System.out.println("          BIENVENIDO A --DIVISA EXCHANGE-- BY TESLA");
        System.out.println(" ");
        System.out.println("                 Powered by Alura Latam");
        System.out.println(" ╰───────────────────────────✧──────────────────────────────╯");
        System.out.println("                     ");

        do {
            System.out.println("                    MENÚ DE OPCIONES");
            System.out.println("                   »»————--　　-————-««");

            System.out.println("                  1) Conversor de divisa"); // enviar ars/eur -> def calculadora -> 25 ars -> eur
            System.out.println("                  2) Valor de divisa"); // enviar ars/eur -> 1 ars es igual a  x eur
            System.out.println("                  3) Salir ");
            System.out.println(" ");
            System.out.println(" ingrese una opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el codigo de divisa ");
                    System.out.println("Ejemplo : USD para Dolares");
                    String divisa1 = scanner.next();
                    String DIVISA1 = divisa1.toUpperCase();
                    System.out.println("Ingrese cantidad a convertir");
                    int num = scanner.nextInt();
                    System.out.println("Ingrese el codigo de divisa a convertir");
                    System.out.println("Ejemplo : ARS para Pesos argentinos");
                    String divisa2 = scanner.next();
                    String DIVISA2 = divisa2.toUpperCase();
                    Divisa miDivisa = consulta.buscarDivisa(DIVISA1);
                    if (miDivisa.getLista() == null) {
                        System.out.println("Primer Argumento no valido :(");
                        break;}
                    if (miDivisa.getLista().get(DIVISA2) == null){
                        System.out.println("Segundo argumento no valido :(");
                        break;}
                    System.out.println(" ");
                    Object value = miDivisa.getLista().get(DIVISA2);
                    double doubleValue = Double.parseDouble(value.toString());
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                    System.out.println(" ");
                    System.out.println("                      »»————-　CONVERSION　————-««");
                    System.out.println(" ");
                    System.out.println("                 ←« [[ $"+num+" "+miDivisa.getCodigoDivisa() +"  ]] = [[ $"+ doubleValue*num + " "+ DIVISA2 +"  ]] »→");
                    System.out.println(" ");
                    System.out.println("Este valor pertenece a la siguiente fecha: " + miDivisa.getFecha());
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------------------------------------------------------------------");

                    break;
                case 2:
                    System.out.println("Ingrese el codigo de divisa ");
                    System.out.println("Ejemplo : USD para Dolares");
                    String divisa3 = scanner.next();
                    String DIVISA3 = divisa3.toUpperCase();
                    System.out.println("Ingrese el codigo de divisa a convertir");
                    System.out.println("Ejemplo : ARS para Pesos argentinos");
                    String divisa4 = scanner.next();
                    String DIVISA4 = divisa4.toUpperCase();
                    Divisa miDivisa2 = consulta.buscarDivisa(DIVISA3);
                    if (miDivisa2.getLista() == null) {
                        System.out.println("Primer Argumento no valido :(");
                        break;}
                    if (miDivisa2.getLista().get(DIVISA4) == null){
                        System.out.println("Segundo argumento no valido :(");
                        break;}
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                    System.out.println(" ");
                    System.out.println("                      »»————-　CONVERSION　————-««");
                    System.out.println(" ");
                    System.out.println("               ←« [[ $1 "+miDivisa2.getCodigoDivisa() +"  ]] = [[ $"+ miDivisa2.getLista().get(DIVISA4) + " "+ DIVISA4 +"  ]] »→");
                    System.out.println(" ");
                    System.out.println("Este valor pertenece a la siguiente fecha: " + miDivisa2.getFecha());
                    System.out.println(" ");
                    System.out.println("-------------------------------------------------------------------------------------------------------------");

                    break;
                case 3: //salida del sistemita
                    System.out.println("               .·:*¨¨*:·. .·:*¨¨*:·.");
                    System.out.println(" ");
                    System.out.println("                Cerrando terminal...");
                    System.out.println(" ");
                    System.out.println("          GRACIAS POR USAR --DIVISA EXCHANGE--");
                    System.out.println("              Powered by Alura Latam");
                    System.out.println(" ");
                    System.out.println("               .·:*¨¨*:·. .·:*¨¨*:·.");
                    break;
                default: //caso donde no se respeta la entrada de opcion
                    System.out.println("Opción no válida. Intente de nuevo");
            }

        } while (opcion != 3);
    }
}


