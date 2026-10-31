# taller-parcial-2

Parcial II - Parte Práctica de Programación II (G412).
Juego de batallas entre criaturas usando **clases abstractas** y **polimorfismo**.

## Integrantes

- Juan (rama `feature/criatura-dragon`: clase abstracta `Criatura` y subclase `Dragon`).
- [Nombre del compañero] (rama `feature/criaturas-restantes`: subclases `Mago`, `Guerrero` y clase `Main`).

## Estructura del proyecto

```
src/main/java/criaturas/
├── Criatura.java    # Clase abstracta (contrato): atacar, defender, estaViva
├── Dragon.java       # Ataca con fuerza*2, escamas reducen 5 de daño
├── Mago.java         # Ataca con fuerza, escudo mágico reduce 3
├── Guerrero.java      # Ataca con fuerza, escudo reduce 4
└── Main.java          # Simula 3 batallas hasta que una criatura quede sin salud

src/test/java/criaturas/
├── CriaturaTest.java
├── DragonTest.java
├── MagoTest.java
└── GuerreroTest.java   # Pruebas unitarias con JUnit (puntos extra)
```

## Cómo se resolvió

1. **Clase abstracta `Criatura`**: define los atributos `nombre`, `salud`, `fuerza` y dos métodos abstractos (`atacar(Criatura objetivo)` y `defender(int daño)`). El método concreto `estaViva()` comprueba si `salud > 0`.
2. **Subclases**: cada criatura implementa `atacar` y `defender` a su manera:
   - `Dragon`: ataca con `fuerza * 2`; sus escamas reducen 5 puntos de daño.
   - `Mago`: ataca con su `fuerza`; su escudo mágico reduce 3 puntos.
   - `Guerrero`: ataca con su `fuerza`; su escudo reduce 4 puntos.
3. **Simulación**: `Main.batalla()` recibe dos objetos `Criatura` y alterna turnos hasta que uno quede sin salud. Al usar el tipo padre, se aplica polimorfismo: aunque el parámetro es `Criatura`, el comportamiento real depende de la subclase (dragón, mago o guerrero).
4. **Pruebas**: JUnit verifica el daño calculado, la reducción de cada defensa y los límites (salud nunca negativa, daño mínimo de 1).

## Conceptos aplicados

- **Clase abstracta**: molde que no se puede instanciar; obliga a las hijas a implementar sus métodos abstractos. Aquí `Criatura` es el contrato de todas las criaturas.
- **Polimorfismo**: un mismo método (`atacar`, `defender`) se comporta distinto según la criatura concreta. En `Main` tratamos a todas como `Criatura`.
- **Herencia**: `Dragon`, `Mago` y `Guerrero` extienden `Criatura` y reutilizan sus atributos y `estaViva()`.
- **@Override**: marca la sobrescritura de los métodos abstractos.

## Uso de inteligencia artificial

La IA se usó como apoyo para completar las clases faltantes, generar las pruebas unitarias y revisar el código. Prompts principales:

- "Completa lo que falta del ejercicio: implementa Mago y Guerrero extendiendo la clase abstracta Criatura, cada uno con una forma única de atacar y defenderse."
- "Crea la clase Main que simule batallas entre criaturas hasta que una quede sin salud, mostrando la salud tras cada ataque."
- "Genera pruebas unitarias con JUnit para Criatura, Dragon, Mago y Guerrero."

Uso crítico: se revisó cada clase generada, se ajustó el daño de cada defensa para que el juego fuera equilibrado y se verificó que el código compilara y ejecutara antes de subirlo.