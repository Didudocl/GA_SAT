> [!NOTE]
> Tarea desarrollada para la asignatura de **Algoritmos y Estructuras de Datos Avanzados** de la carrera de Magíster en Ciencias de la Computación.

## 📘 Tarea: Problema de Satisfacibilidad con Algoritmos Genéticos

Este código implementa un algoritmo genético para resolver el **problema de satisfacibilidad booleana (SAT)**. Se generan expresiones booleanas aleatorias en forma de conjunciones de cláusulas (CNF), y se busca una asignación de variables que satisfaga todas las cláusulas usando evolución genética.

## ⚙️ Instrucciones de Compilación y Ejecución

Asegúrate de tener **Java JDK 11 o superior** instalado en tu sistema. Luego, sigue los siguientes pasos para compilar y ejecutar el código:

### 1. Compilación

Ubícate en el directorio donde están los archivos `.java` y ejecuta:

```bash
javac *.java
```

### 2. Limpieza de Compilación

En caso de querer eliminar los archivos .class generados:

```bash
rm *.class
```

### 3. Ejecución

```bash
java GA
```

Se te pedirá ingresar por consola los siguientes parámetros:
- Número de variables.
- Número de cláusulas.
- Literales por cláusula.
- Tamaño de la población.

## 📁 Estructura del Código

- `GA.java`: Clase principal que contiene el método `main()`. Se encarga de recibir los parámetros desde consola, generar las cláusulas aleatorias, inicializar la población y ejecutar el ciclo evolutivo del algoritmo genético.

- `Algorithm.java`: Contiene la lógica del algoritmo genético, incluyendo:
    - **Selección** por torneo.
    - **Cruce** uniforme entre individuos.
    - **Mutación** aleatoria.
    - **Elitismo** opcional para conservar al mejor individuo.

- `FitnessCalc.java`: Evalúa la aptitud (fitness) de un individuo. Determina cuántas cláusulas de la expresión booleana son satisfechas por un arreglo de valores booleanos.

- `Individual.java`: Representa un individuo (una posible asignación de valores booleanos a las variables). Contiene su arreglo de genes, su fitness y métodos para mutarlo y cruzarlo.

- `Population.java`: Maneja una colección de individuos. Permite inicializar la población, obtener el individuo más apto, acceder a individuos por índice y guardar nuevos individuos.



## 👥 Autor

⌨️ with ❤️ by [@Didudocl](https://github.com/Didudocl)