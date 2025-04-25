package com.david;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

class MenuTest {

    @Test
    void testMenuFlujoBasico() throws Exception {
        // Simulamos las entradas del usuario
        String input = "\n" +         // Pulsar Enter para comenzar
                "1\nDavid\n" + // Crear cuenta con nombre David
                "2\n100\n" +   // Ingresar 100€
                "3\n1\n50\n" + // Gasto en Vacaciones por 50€
                "4\n" +        // Mostrar saldo
                "5\n";         // Salir

        // Redirigimos System.in
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // Capturamos System.out
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(out));

        // Ejecutamos el menú
        Menu menu = new Menu();
        menu.mostrar();

        // Restauramos System.out e in
        System.setOut(originalOut);
        System.setIn(System.in);

        String output = out.toString();

        // Verificamos que ciertas salidas esperadas estén presentes
        assertTrue(output.contains("David, tu cuenta ha sido creada con éxito"));
        assertTrue(output.contains("ingresaste 100.0"));
        assertTrue(output.contains("has gastado 50.0 € en Vacaciones"));
        assertTrue(output.contains("Saldo restante: 50.0"));
        assertTrue(output.contains("Has salido del programa"));
    }
}
