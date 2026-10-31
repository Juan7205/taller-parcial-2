package criaturas;

// El Dragon es una Criatura (herencia con extends).
// Ataca con el doble de su fuerza y sus escamas lo protegen.
public class Dragon extends Criatura {

    // Atributo propio del dragón
    private String escamas;

    public Dragon(String nombre, int salud, int fuerza, String escamas) {
        super(nombre, salud, fuerza); // llama al constructor de Criatura
        this.escamas = escamas;
    }

    // El dragón ataca más fuerte: fuerza * 2
    @Override
    public void atacar(Criatura objetivo) {
        int daño = getFuerza() * 2;
        System.out.println(getNombre() + " lanza fuego a " + objetivo.getNombre()
                + " y hace " + daño + " de daño");
        objetivo.defender(daño);
    }

    // Las escamas le quitan 5 puntos al daño (mínimo recibe 1)
    @Override
    public void defender(int daño) {
        int dañoFinal = daño - 5;
        if (dañoFinal < 1) {
            dañoFinal = 1;
        }
        System.out.println("   Las " + escamas + " de " + getNombre()
                + " lo protegen, recibe " + dañoFinal);
        setSalud(getSalud() - dañoFinal);
    }

    public String getEscamas() {
        return escamas;
    }
}