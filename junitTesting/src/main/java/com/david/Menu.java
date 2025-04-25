package com.david;

import java.util.Scanner;

/** Clase creada para mostrar el menú de opciones al usuario.
 *  Este menú está adaptado al ejercicio de control de ingresos y gastos.
 *  Permite introducir un nombre de usuario, registrar ingresos y gastos,
 *  y consultar el saldo. Todo desde aquí, para mantener el Main limpio. */

public class Menu {

    public void mostrar() {
        Scanner leer = new Scanner(System.in);
        CuentaUsuario cuenta = null; // Aquí se guardará el usuario que creemos

        int opcion;

        // Mensaje inicial de bienvenida
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║      BIENVENIDO AL GESTOR DE CUENTAS       ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("Este programa permite controlar ingresos y gastos.");
        System.out.println("Primero deberás crear tu cuenta de usuario.");
        System.out.println("Pulsa ENTER para comenzar...");
        leer.nextLine();

        // Bucle principal del menú
        do {
            System.out.println("\n╔════════════════════════════════════╗");
            System.out.println("║              MENÚ                  ║");
            System.out.println("╚════════════════════════════════════╝");
            System.out.println("1. Crear cuenta de usuario");
            System.out.println("2. Introducir ingreso");
            System.out.println("3. Introducir gasto");
            System.out.println("4. Mostrar saldo");
            System.out.println("5. Salir");
            System.out.print("\nElige una opción: ");

            opcion = leer.nextInt();
            leer.nextLine(); // Limpieza de buffer

            switch (opcion) {
                case 1:
                    System.out.print("Introduce tu nombre para crear la cuenta: ");
                    String nombre = leer.nextLine();
                    cuenta = new CuentaUsuario(nombre, 0); // Creamos cuenta con saldo inicial 0
                    break;

                case 2:
                    if (cuenta == null) {
                        System.out.println("⚠️ Primero debes crear una cuenta.");
                        break;
                    }
                    System.out.print("Introduce el ingreso (nómina): ");
                    double ingreso = leer.nextDouble();
                    leer.nextLine(); // Limpieza de buffer
                    cuenta.ingresarDinero(ingreso);
                    break;

                case 3:
                    if (cuenta == null) {
                        System.out.println("⚠️ Primero debes crear una cuenta.");
                        break;
                    }

                    System.out.println("Elige el concepto del gasto:");
                    System.out.println("1. Vacaciones");
                    System.out.println("2. Alquiler");
                    System.out.println("3. Vicios variados");
                    System.out.print("Opción: ");
                    int tipoGasto = leer.nextInt();
                    leer.nextLine(); // limpiar buffer

                    String concepto = "";

                    switch (tipoGasto) {
                        case 1:
                            concepto = "Vacaciones";
                            break;
                        case 2:
                            concepto = "Alquiler";
                            break;
                        case 3:
                            concepto = "Vicios variados";
                            break;
                        default:
                            System.out.println("Opción de concepto no válida.");
                            return;
                    }

                    System.out.print("Introduce la cantidad del gasto: ");
                    double cantidad = leer.nextDouble();
                    leer.nextLine();
                    cuenta.añadirGasto(concepto, cantidad);

                    break;

                case 4:
                    if (cuenta == null) {
                        System.out.println("⚠️ Primero debes crear una cuenta.");
                        break;
                    }
                    cuenta.getSaldo(); // Mostramos el saldo
                    break;

                case 5:
                    System.out.println("Has salido del programa. ¡Gracias por usarlo!");
                    break;

                default:
                    System.out.println("⚠️ Opción no válida. Prueba otra vez.");
                    break;
            }

        } while (opcion != 5);

        leer.close(); // Cerramos el Scanner
    }
}
