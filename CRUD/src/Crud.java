import java.util.ArrayList;
import java.util.List;

public class Crud {
    private List<Person> data;

    public Crud() {
        this.data = new ArrayList<>();
    }

    // Create
    public void create(Person person) {
        data.add(person);
    }

    // Read
    public List<Person> read() {
        return data;
    }

    // Update
    public void update(int index, Person newPerson) {
        if(index >= 0 && index < data.size()) {
            data.set(index, newPerson);
        } else {
            System.out.println("Indéx inválido.");
        }
    }

    // Delete
    public void delete(int index) {
        if(index >= 0 && index < data.size()) {
            data.remove(index);
        } else {
            System.out.println("Indéx inválido.");
        }
    }
}



