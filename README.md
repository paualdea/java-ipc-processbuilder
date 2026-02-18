# Comunicación entre procesos (Calculadora Padre-Hijo)

Este proyecto es una aplicación de consola en Java desarrollada como parte de la **Actividad 2: "Creación de procesos: comunicación padre–hijo mediante ProcessBuilder"** de la asignatura de Programación de Servicios y Procesos.

El sistema consiste en un **proceso Padre** que gestiona la interacción con el usuario y supervisa el ciclo de vida de un **proceso Hijo** especializado en realizar operaciones aritméticas. La transferencia de datos se realiza en tiempo real a través de los flujos de entrada y salida estándar.

El objetivo principal es poner en práctica la creación de procesos subordinados, el uso de la clase `ProcessBuilder` y la redirección de flujos de datos en aplicaciones multiproceso.

## Características Principales

* **Comunicación IPC Robusta**: Uso de `InputStream` y `OutputStream` para el intercambio de información entre procesos independientes.
* **Gestión de Procesos con ProcessBuilder**: Configuración del entorno de ejecución del proceso hijo, incluyendo el manejo del *Classpath*.
* **Validación Lógica**: El proceso Hijo detecta e informa sobre errores matemáticos, como la división por cero, utilizando el canal de error estándar `System.err`.

___
Este proyecto sirve como control de versiones y evidencia del trabajo realizado para la asignatura.
