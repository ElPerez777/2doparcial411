# DESAROLLO PARCIAL 2 411
Proyecto del **Parcial II de Programación II (G411)**.

Es una simulación de batallas entre diferentes criaturas implementada en Java.
Se aplican los siguientes conceptos de programación orientada a objetos:

- **Herencia** mediante la clase abstracta `Criatura`.
- **Polimorfismo** en los métodos `atacar` y `defender` redefinidos por cada subclase.
- **Interfaces** (`Volador` y `Magico`) para definir comportamientos específicos.
- **Composición** entre `Criatura` y `Arma`, donde una criatura puede equipar un arma.
- **Pruebas unitarias** con JUnit 5 (valor agregado del parcial).

## Estructura del proyecto

```
ParcialII/
├── pom.xml                         # Configuración de Maven y dependencias
├── README.md                       # Este archivo
└── src/
    ├── main/java/com/parcial2/
    │   ├── Main.java               # Clase principal (punto de entrada)
    │   ├── batalla/
    │   │   └── Simulador.java      # Lógica de simulación de batallas
    │   ├── criaturas/
    │   │   ├── Criatura.java       # Clase abstracta base
    │   │   ├── Dragon.java         # Dragón (Volador + Magico)
    │   │   ├── Mago.java           # Mago (Magico)
    │   │   └── Guerrero.java       # Guerrero (sin interfaces especiales)
    │   ├── equipamiento/
    │   │   └── Arma.java           # Arma (composición)
    │   └── interfaces/
    │       ├── Volador.java        # Interfaz para criaturas que vuelan
    │       └── Magico.java         # Interfaz para criaturas mágicas
    └── test/java/com/parcial2/
        ├── CriaturaTest.java       # Pruebas de la clase base
        ├── DragonTest.java
        ├── MagoTest.java
        ├── GuerreroTest.java
        ├── ArmaTest.java
        └── SimuladorTest.java
```

## Compilar y ejecutar

### Compilar el proyecto

```bash
mvn clean compile
```

### Ejecutar las pruebas unitarias

```bash
mvn test
```

### Empaquetar en un JAR

```bash
mvn clean package
```

### Ejecutar el programa

```bash
java -jar target/parcial-ii-criaturas-1.0.0.jar
```

O también, directamente:

```bash
mvn exec:java -Dexec.mainClass="com.parcial2.Main"
```

