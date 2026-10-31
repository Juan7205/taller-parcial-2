package criaturas;

// El Mago es una Criatura (herencia con extends).
// Ataca con su fuerza usando hechizos y se defiende con un escudo mágico.
public class Mago extends Criatura {

    // Atributo propio del mago
    private String hechizo;

    public Mago(String nombre, int salud, int fuerza, String hechizo) {
        super(nombre, salud, fuerza); // llama al constructor de Criatura
        this.hechizo = hechizo;
    }

    // El mago ataca con su fuerza (no como el dragón que duplica)
    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza();
        System.out.println(getNombre() + " lanza el hechizo \"" + hechizo + "\" a "
                + objetivo.getNombre() + " y hace " + daño + " de daño");
        objetivo.defender(daño);
    }

    // El escudo mágico reduce 3 puntos de daño (mínimo recibe 1)
    @Override
    public void defender(int daño) {
        int dañoFinal = daño - 3;
        if (dañoFinal < 1) {
            dañoFinal = 1;
        }
        System.out.println("   El escudo mágico de " + getNombre()
                + " absorbe parte del daño, recibe " + dañoFinal);
        setSalud(getSalud() - dañoFinal);
    }

    public String getHechizo() {
        return hechizo;
    }
}