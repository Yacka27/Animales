import java.util.*;

public class ClasificacionAnimales {
    private Map<String, List<Animal>> clasificacion;
    private List<Animal> animales;

    public ClasificacionAnimales() {
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
}
