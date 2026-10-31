package criaturas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * Pruebas unitarias para el comportamiento básico de la clase abstracta Criatura.
 */
public class CriaturaTest {

    @Test
    void unaCriaturaNuevaEstaViva() {
        Criatura criatura = new Dragon("Fuego", 100, 20, "escamas");
        assertTrue(criatura.estaViva());
    }

    @Test
    void unaCriaturaConSaludCeroNoEstaViva() {
        Criatura criatura = new Guerrero("Roca", 0, 10, "espada");
        assertFalse(criatura.estaViva());
    }

    @Test
    void setSaludNoPermiteValoresNegativos() {
        Criatura criatura = new Mago("Magia", 50, 15, "hechizo");
        criatura.setSalud(-20);
        assertEquals(0, criatura.getSalud());
    }

    @Test
    void gettersDevuelvenLosValoresDelConstructor() {
        Criatura criatura = new Dragon("Smaug", 100, 20, "escamas de diamante");
        assertEquals("Smaug", criatura.getNombre());
        assertEquals(100, criatura.getSalud());
        assertEquals(20, criatura.getFuerza());
    }

    @Test
    void setSaludActualizaLaSalud() {
        Criatura criatura = new Dragon("Smaug", 100, 20, "escamas de diamante");
        criatura.setSalud(70);
        assertEquals(70, criatura.getSalud());
    }
}