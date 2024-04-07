import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        ClasificacionAnimales programa = new ClasificacionAnimales();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bienvenido al programa de clasificación de animales.");

        while (true) {
            System.out.println("Ingrese el nombre del animal (o escriba 'fin' para terminar): ");
            String nombre = scanner.nextLine();
            if (nombre.equalsIgnoreCase("fin")) {
                break;
            }

            System.out.println("Ingrese el tipo del animal (terrestre, aéreo, acuático): ");
            String tipo = scanner.nextLine();

            System.out.println("Ingrese el género del animal (masculino, femenino): ");
            String genero = scanner.nextLine();

            Animal animal = new Animal(nombre, tipo, genero);
            programa.agregarAnimal(animal);
        }

        System.out.println("Clasificación de animales:");
        for (String tipo : programa.getClasificacion().keySet()) {
            System.out.println("Tipo: " + tipo);
            System.out.println("Animales:");
            for (Animal animal : programa.getClasificacion().get(tipo)) {
                System.out.println(" - " + animal.getNombre());
            }
            System.out.println();
        }

        scanner.close();
    }
}
