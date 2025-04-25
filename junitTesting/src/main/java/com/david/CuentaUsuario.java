package com.david;

public class CuentaUsuario {

    // Comenzamos definiendo las variables que guarda cada cuenta.
    private String nombre;
    private double saldo;

// ---------------------------------------------------------------------------

    // CONSTRUCTOR: cuando se crea una cuenta, se da el nombre y el saldo inicial.
    public CuentaUsuario (String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
        System.out.println(nombre + ", tu cuenta ha sido creada con éxito");
    }

// ---------------------------------------------------------------------------

    // MÉTODOS GET (PARA MOSTRAR NOMBRE Y SALDO ACTUAL) Y SET.
    public String getNombre() {
        return nombre;
    }

    // Añadimos este metodo setNombre por si se quisiera actualizar (No necesario).
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
            System.out.println("Actualizaste el nombre a: " + nombre);
        } else {
            System.out.println("El nombre no puede estar vacío.");
        }
    }

    public double getSaldo() {
        System.out.println(nombre + ", tu saldo actual es: " + saldo + " €.");
        return saldo;
    }

// ---------------------------------------------------------------------------

    // METODO INGRESAR DINERO.
    //  Si la cantidad es válida, lo suma al saldo.

    public boolean ingresarDinero(double cantidad) {
        if (cantidad <= 0) {
            System.out.println("No puedes ingresar en negativo!!");
            return false;
        }
        saldo += cantidad;
        System.out.println(nombre + ", ingresaste " + cantidad + " €. Dispones de: " + saldo + " €.");
        return true;
    }

// ---------------------------------------------------------------------------

    // METODO AÑADIR GASTO
    // Tiene en cuenta si hay saldo suficiente y si está bien el "concepto".

    public boolean añadirGasto(String concepto, double cantidad) {
        if (!esConceptoValido(concepto)) {
            System.out.println("El concepto de gasto no es válido.");
            return false;
        }

        if (cantidad <= 0) {
            System.out.println("El gasto debe ser mayor que cero.");
            return false;
        }

        if (cantidad > saldo) {
            System.out.println("No tienes saldo suficiente para este gasto.");
            return false;
        }

        saldo -= cantidad;
        System.out.println(nombre + ", has gastado " + cantidad + " € en " + concepto + ". Saldo restante: " + saldo + " €.");
        return true;
    }

// ---------------------------------------------------------------------------

    // METODO PRIVADO (Para usarlo en esta clase) "ESCONCEPTOVALIDO".
    // Con éste revisamos si el concepto es uno de los permitidos según el enunciado.
    private boolean esConceptoValido(String concepto) {
        return concepto.equalsIgnoreCase("Vacaciones") ||
                concepto.equalsIgnoreCase("Alquiler") ||
                concepto.equalsIgnoreCase("Vicios variados");
    }
}
