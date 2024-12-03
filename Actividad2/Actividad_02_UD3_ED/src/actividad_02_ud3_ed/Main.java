/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package actividad_02_ud3_ed;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * La clase Main es el punto de entrada de la aplicación que simula operaciones bancarias.
 * El programa permite realizar operaciones como ingresar dinero, retirar dinero o finalizar la ejecución.
 * 
 * @author Juan López
 * @version 1.0
 */
public class Main {
    
    /** 
     * Objeto de tipo BufferedReader para leer la entrada del usuario desde la consola.
     */
    static BufferedReader dato = new BufferedReader(new InputStreamReader(System.in));

    /**
     * El método principal de la aplicación que ejecuta el menú interactivo de operaciones.
     * Solicita al usuario qué operación desea realizar (ingresar, retirar o finalizar) y ejecuta las
     * operaciones correspondientes en la cuenta bancaria.
     * 
     * @param args No se utiliza en esta aplicación.
     */
    public static void main(String[] args) {
        CCuenta cuenta1; // Objeto de tipo CCuenta
        double saldoActual;
        int opcion = 0;
        cuenta1 = new CCuenta("Juan López", "1000-2365-85-123456789", 2500, 0); 

        do {
            try {
                // Menú de operaciones
                System.out.println("MENÚ DE OPERACIONES");
                System.out.println("-------------------");
                System.out.println("1 - Ingresar");
                System.out.println("2 - Retirar");
                System.out.println("3 - Finalizar");
                opcion = Integer.parseInt(dato.readLine());

                if (opcion == 1) {
                    System.out.println("¿Cuánto desea ingresar?: ");
                    float ingresar = Integer.parseInt(dato.readLine()); 
                    operativa_cuenta(cuenta1, ingresar, opcion);
                } else if (opcion == 2) {
                    System.out.println("¿Cuánto desea retirar?: ");
                    float retirar = Integer.parseInt(dato.readLine());
                    operativa_cuenta(cuenta1, retirar, opcion);
                } else if (opcion == 3) {
                    System.out.println("Finalizamos la ejecución");
                } else {
                    System.err.println("Opción errónea");
                }
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } while (opcion != 3);

        saldoActual = cuenta1.estado();
        System.out.println("El saldo actual es: " + saldoActual);
    }

    /**
     * Método que realiza la operativa bancaria de ingresar o retirar dinero de una cuenta.
     * 
     * @param cuenta1 La cuenta sobre la que se realizarán las operaciones.
     * @param cantidad La cantidad de dinero que se desea ingresar o retirar.
     * @param opcion La opción seleccionada por el usuario (1 para ingresar, 2 para retirar).
     */
    public static void operativa_cuenta(CCuenta cuenta1, float cantidad, int opcion) {
        if (opcion == 2) {
            try {
                cuenta1.retirar(cantidad);
            } catch (Exception e) {
                System.out.print("Fallo al retirar");
            }
        } else if (opcion == 1) {
            try {
                System.out.println("Ingreso en cuenta");
                cuenta1.ingresar(cantidad);
            } catch (Exception e) {
                System.out.print("Fallo al ingresar");
            }
        }
    }
}
