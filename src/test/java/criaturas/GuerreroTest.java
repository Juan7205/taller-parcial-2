package criaturas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la subclase Guerrero.
 * El guerrero ataca con su fuerza (espada) y su escudo
 * reduce 4 puntos de daño.
 */
public class GuerreroTest {

    @Test
    void atacarHaceLaFuerza() {
        Criatura guerrero = new Guerrero("Conan", 90, 18, "espada Excalibur");
        Criatura objetivo = new Mago("Gandalf", 80, 15, "hechizo");

        guerrero.atacar(objetivo);

        // Daño = fuerza = 18. El mago reduce 3 (escudo mágico): recibe 15.
        assertEquals(80 - 15, objetivo.getSalud());
    }

    @Test
    void defenderReduceCuatroPuntosDeDaño() {
        Criatura guerrero = new Guerrero("Conan", 90, 18, "espada Excalibur");

        guerrero.defender(30);

        // 30 - 4 = 26
        assertEquals(90 - 26, guerrero.getSalud());
    }

    @Test
    void defenderNuncaRecibeMenosDeUno() {
        Criatura guerrero = new Guerrero("Conan", 90, 18, "espada Excalibur");

        guerrero.defender(1);

        // 1 - 4 = -3, se ajusta a 1
        assertEquals(90 - 1, guerrero.getSalud());
    }

    @Test
    void getEspadaDevuelveLaEspada() {
        Guerrero guerrero = new Guerrero("Conan", 90, 18, "espada Excalibur");
        assertEquals("espada Excalibur", guerrero.getEspada());
    }
}