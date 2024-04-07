
import java.util.*;

public class Animales {
    private Map<String, List<Animal>> clasificacion;
    private List<Animal> animales;

    public Animales() {
        this.clasificacion = new HashMap<>();
        this.animales = new ArrayList<>();
    }

    public Map<String, List<Animal>> getClasificacion() {
        return clasificacion;
    }

    public List<Animal> getAnimales() {
        return animales;
    }

    public void agregarAnimal(Animal animal) {
        String tipo = animal.getTipo();
        List<Animal> listaTipo = this.clasificacion.getOrDefault(tipo, new ArrayList<>());
        listaTipo.add(animal);
        this.clasificacion.put(tipo, listaTipo);
        this.animales.add(animal);
    }

    public static void main(String[] args) {
        Animales programa = new Animales();
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
        for (Map.Entry<String, List<Animal>> entry : programa.getClasificacion().entrySet()) {
            System.out.println("Tipo: " + entry.getKey());
            System.out.println("Animales:");
            for (Animal animal : entry.getValue()) {
                System.out.println(" - " + animal.getNombre());
            }
            System.out.println();
        }

        scanner.close();
    }
}

class Animal {
    private String nombre;
    private String tipo;
    private String genero;

    public Animal(String nombre, String tipo, String genero) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public String getGenero() {
        return genero;
    }
}
