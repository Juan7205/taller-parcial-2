package criaturas;

// Clase abstracta: es el molde de todas las criaturas.
// No se puede crear una Criatura directamente, solo Dragon, Mago o Guerrero.
public abstract class Criatura {

    private String nombre;
    private int salud;
    private int fuerza;

    // Constructor: guarda los datos que tienen todas las criaturas
    public Criatura(String nombre, int salud, int fuerza) {
        this.nombre = nombre;
        this.salud = salud;
        this.fuerza = fuerza;
    }

    // Métodos abstractos: cada criatura los hace a su manera
    public abstract void atacar(Criatura objetivo);

    public abstract void defender(int daño);

    // Método concreto: sirve igual para todas las criaturas
    public boolean estaViva() {
        return salud > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getSalud() {
        return salud;
    }

    public int getFuerza() {
        return fuerza;
    }

    // Cambia la salud. Si queda negativa la dejamos en 0.
    public void setSalud(int salud) {
        if (salud < 0) {
            this.salud = 0;
        } else {
            this.salud = salud;
        }
    }
}
