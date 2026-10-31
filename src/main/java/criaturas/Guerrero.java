package criaturas;

// El Guerrero es una Criatura (herencia con extends).
// Ataca con su fuerza usando su espada y se defiende con un escudo.
public class Guerrero extends Criatura {

    // Atributo propio del guerrero
    private String espada;

    public Guerrero(String nombre, int salud, int fuerza, String espada) {
        super(nombre, salud, fuerza); // llama al constructor de Criatura
        this.espada = espada;
    }

    // El guerrero ataca con su fuerza usando su espada
    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza();
        System.out.println(getNombre() + " swinge su " + espada + " contra "
                + objetivo.getNombre() + " y hace " + daño + " de daño");
        objetivo.defender(daño);
    }

    // El escudo del guerrero reduce 4 puntos de daño (mínimo recibe 1)
    @Override
    public void defender(int daño) {
        int dañoFinal = daño - 4;
        if (dañoFinal < 1) {
            dañoFinal = 1;
        }
        System.out.println("   El escudo de " + getNombre()
                + " bloquea parte del ataque, recibe " + dañoFinal);
        setSalud(getSalud() - dañoFinal);
    }

    public String getEspada() {
        return espada;
    }
}