package com.david;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaUsuarioTest {

    private CuentaUsuario cuenta;

    @BeforeEach
    void setUp() {
        cuenta = new CuentaUsuario("David", 100.0); // saldo inicial 100€
    }

    @Test
    void testConstructorYGetters() {
        assertEquals("David", cuenta.getNombre());
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    void testSetNombreValido() {
        cuenta.setNombre("Juan");
        assertEquals("Juan", cuenta.getNombre());
    }

    @Test
    void testSetNombreInvalido() {
        cuenta.setNombre("");
        assertEquals("David", cuenta.getNombre()); // no cambia
    }

    @Test
    void testIngresarDineroValido() {
        boolean resultado = cuenta.ingresarDinero(50.0);
        assertTrue(resultado);
        assertEquals(150.0, cuenta.getSaldo());
    }

    @Test
    void testIngresarDineroInvalido() {
        boolean resultado = cuenta.ingresarDinero(-20.0);
        assertFalse(resultado);
        assertEquals(100.0, cuenta.getSaldo()); // saldo no cambia
    }

    @Test
    void testAñadirGastoValido() {
        boolean resultado = cuenta.añadirGasto("Vacaciones", 40.0);
        assertTrue(resultado);
        assertEquals(60.0, cuenta.getSaldo());
    }

    @Test
    void testAñadirGastoSaldoInsuficiente() {
        boolean resultado = cuenta.añadirGasto("Alquiler", 200.0);
        assertFalse(resultado);
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    void testAñadirGastoInvalidoPorConcepto() {
        boolean resultado = cuenta.añadirGasto("Comida", 20.0);
        assertFalse(resultado);
        assertEquals(100.0, cuenta.getSaldo());
    }

    @Test
    void testAñadirGastoInvalidoPorCantidad() {
        boolean resultado = cuenta.añadirGasto("Vicios variados", -10.0);
        assertFalse(resultado);
        assertEquals(100.0, cuenta.getSaldo());
    }
}