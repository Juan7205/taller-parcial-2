package criaturas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para la subclase Mago.
 * El mago ataca con su fuerza (hechizos) y su escudo mágico
 * reduce 3 puntos de daño.
 */
public class MagoTest {

    @Test
    void atacarHaceLaFuerza() {
        Criatura mago = new Mago("Gandalf", 80, 15, "fuego de Athelas");
        Criatura objetivo = new Dragon("Smaug", 100, 20, "escamas");

        mago.atacar(objetivo);

        // Daño = fuerza = 15. El dragón reduce 5 (escamas): recibe 10.
        assertEquals(100 - 10, objetivo.getSalud());
    }

    @Test
    void defenderReduceTresPuntosDeDaño() {
        Criatura mago = new Mago("Gandalf", 80, 15, "fuego de Athelas");

        mago.defender(20);

        // 20 - 3 = 17
        assertEquals(80 - 17, mago.getSalud());
    }

    @Test
    void defenderNuncaRecibeMenosDeUno() {
        Criatura mago = new Mago("Gandalf", 80, 15, "fuego de Athelas");

        mago.defender(1);

        // 1 - 3 = -2, se ajusta a 1
        assertEquals(80 - 1, mago.getSalud());
    }

    @Test
    void getHechizoDevuelveElHechizo() {
        Mago mago = new Mago("Gandalf", 80, 15, "fuego de Athelas");
        assertEquals("fuego de Athelas", mago.getHechizo());
    }
}