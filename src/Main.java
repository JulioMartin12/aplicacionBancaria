import models.Cliente;
import models.Cuenta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Tony", "Stark", new Cuenta(1599.99));
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("********CITY BANK********");
            System.out.println("1-Consultar saldo.");
            System.out.println("2-Depositar.");
            System.out.println("3-Retirar.");
            System.out.println("9-Salir del Programa.");
            System.out.print("Ingrese una opción:");
            opcion = teclado.nextInt();
            seleccionOpcion(opcion, cliente, teclado);

        }while(opcion!=9);


    }

    public  static int seleccionOpcion(int opcion, Cliente cliente,Scanner teclado){
        switch (opcion){
            case 1:
                System.out.println("El Cliente" + cliente.getNombre() + " "+ cliente.getApellido() + " tiene un saldo en su cuente de $" + cliente.getCuenta().getSaldo());
                break;
            case 2:
                System.out.print("Ingrese el monto que desea depositar en su cuenta: ");
                cliente.getCuenta().depositar(teclado.nextDouble());
                System.out.println(" tiene un saldo en su cuente de $" + cliente.getCuenta().getSaldo());
                break;
            case 3:
                System.out.print("Ingrese el monto que desea retirar de su cuenta: ");
                if( cliente.getCuenta().retirar(teclado.nextDouble())){
                    System.out.println("Tansacción realizada con exito, su saldo actual es $"+cliente.getCuenta().getSaldo());
                }else{
                    System.out.println("No se pudo realizar la transacción, ingrese un monto igual o menor al saldo actual $"+cliente.getCuenta().getSaldo());
                }

                break;
            case 9:
                System.out.println("Usted a salido del programa, hasta la proxima!!! ");
                break;
            default:
                System.out.println("La opción es incorrecta , ingrese una opción válida para acceder.");
                break;
        }

        return opcion;
    }
}