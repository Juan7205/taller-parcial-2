package criaturas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la subclase Dragon.
 * El dragón ataca con el doble de su fuerza y sus escamas
 * reducen 5 puntos de daño.
 */
public class DragonTest {

    @Test
    void atacarHaceElDobleDeLaFuerza() {
        Criatura dragon = new Dragon("Smaug", 100, 20, "escamas de diamante");
        Criatura objetivo = new Guerrero("Conan", 90, 18, "espada");

        dragon.atacar(objetivo);

        // Daño = fuerza * 2 = 40. El guerrero reduce 4 (escudo): recibe 36.
        assertEquals(90 - 36, objetivo.getSalud());
    }

    @Test
    void defenderReduceCincoPuntosDeDaño() {
        Criatura dragon = new Dragon("Smaug", 100, 20, "escamas de diamante");

        dragon.defender(30);

        // 30 - 5 = 25
        assertEquals(100 - 25, dragon.getSalud());
    }

    @Test
    void defenderNuncaRecibeMenosDeUno() {
        Criatura dragon = new Dragon("Smaug", 100, 20, "escamas de diamante");

        dragon.defender(2);

        // 2 - 5 = -3, se ajusta a 1
        assertEquals(100 - 1, dragon.getSalud());
    }

    @Test
    void getEscamasDevuelveLaEscama() {
        Dragon dragon = new Dragon("Smaug", 100, 20, "escamas de diamante");
        assertEquals("escamas de diamante", dragon.getEscamas());
    }
}