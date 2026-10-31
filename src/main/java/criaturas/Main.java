package criaturas;

// Clase Principal: crea instancias de criaturas y simula batallas.
// Demuestra polimorfismo al tratar a todas las criaturas como "Criatura".
public class Main {

    public static void main(String[] args) {
        // Crear instancias de las diferentes criaturas
        Dragon dragon = new Dragon("Smaug", 100, 20, "escamas de diamante");
        Mago mago = new Mago("Gandalf", 80, 15, "fuego de Athelas");
        Guerrero guerrero = new Guerrero("Conan", 90, 18, "espada Excalibur");

        System.out.println("=== SIMULADOR DE BATALLAS ===\n");

        // Batalla 1: Dragon vs Mago
        System.out.println("--- Batalla 1: " + dragon.getNombre() + " vs " + mago.getNombre() + " ---");
        batalla(dragon, mago);

        System.out.println();

        // Batalla 2: Guerrero vs Dragon
        Guerrero guerrero2 = new Guerrero("Arthur", 95, 20, "espada Caliburn");
        System.out.println("--- Batalla 2: " + guerrero2.getNombre() + " vs " + dragon.getNombre() + " ---");
        batalla(guerrero2, dragon);

        System.out.println();

        // Batalla 3: Mago vs Guerrero
        Mago mago2 = new Mago("Merlin", 85, 18, "hechizo de hielo");
        System.out.println("--- Batalla 3: " + mago2.getNombre() + " vs " + guerrero.getNombre() + " ---");
        batalla(mago2, guerrero);

        System.out.println("\n=== FIN DE LAS SIMULACIONES ===");
    }

    /**
     * Simula una batalla entre dos criaturas hasta que una quede sin salud.
     * Utiliza polimorfismo: ambos parámetros son de tipo Criatura,
     * pero el comportamiento real depende de la subclase concreta.
     */
    public static void batalla(Criatura criatura1, Criatura criatura2) {
        System.out.println(criatura1.getNombre() + " (Salud: " + criatura1.getSalud()
                + ", Fuerza: " + criatura1.getFuerza() + ")");
        System.out.println(criatura2.getNombre() + " (Salud: " + criatura2.getSalud()
                + ", Fuerza: " + criatura2.getFuerza() + ")");
        System.out.println();

        int round = 1;
        // La batalla continúa mientras ambas criaturas estén vivas
        while (criatura1.estaViva() && criatura2.estaViva()) {
            System.out.println("--- Ronda " + round + " ---");

            // Criatura 1 ataca a criatura 2
            criatura1.atacar(criatura2);

            // Verificar si criatura2 sigue viva antes de que ataque
            if (criatura2.estaViva()) {
                // Criatura 2 ataca a criatura 1
                criatura2.atacar(criatura1);
            }

            // Mostrar salud actual después de la ronda
            System.out.println("Salud actual -> " + criatura1.getNombre() + ": " + criatura1.getSalud()
                    + " | " + criatura2.getNombre() + ": " + criatura2.getSalud());
            System.out.println();

            round++;
        }

        // Determinar el ganador
        Criatura ganador = criatura1.estaViva() ? criatura1 : criatura2;
        Criatura perdedor = criatura1.estaViva() ? criatura2 : criatura1;
        System.out.println(">>> " + ganador.getNombre() + " ha ganado la batalla!");
        System.out.println(">>> " + perdedor.getNombre() + " ha sido derrotado.");
        System.out.println();
    }
}