
# Actividad JUnit – Control de Ingresos y Gastos

Este proyecto es parte de una práctica donde se pide controlar ingresos y gastos de un usuario mediante un programa en Java.

## ¿Qué hace este programa?

- Primero pide que crees un usuario con nombre (es obligatorio antes de cualquier otra acción)
- Puedes ingresar dinero (solo se permite "nómina")
- Puedes introducir gastos (solo si el saldo alcanza), en tres conceptos: vacaciones, alquiler o vicios variados
- Muestra el saldo por pantalla con mensajes que explican lo que ocurre
- Si intentas hacer algo sin saldo o sin haber creado usuario, te lo avisa

## Estructura del proyecto

- `CuentaUsuario.java` → Aquí está toda la lógica (usuario, ingresos, gastos y saldo)
- `Menu.java` → Muestra el menú por consola y conecta con la lógica
- `Main.java` → Solo ejecuta el menú, para tenerlo lo más limpio posible

## Qué falta

En la segunda parte del ejercicio, hay que intercambiar el código con mi compañero Carlos:
- Él testeará este programa con JUnit
- Yo haré lo mismo con su programa, y escribiré un documento con posibles mejoras

## Autor

David Gutiérrez – 2025
[Perfil GitHub](https://github.com/DavidLazaro08)