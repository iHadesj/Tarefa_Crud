import java.util.Scanner;
import java.util.List;

public class CrudExecutor {
    private final Crud crud;
    private final Scanner scanner;

    public CrudExecutor() {
        this.crud = new Crud();
        this.scanner = new Scanner(System.in);
    }

    public void execute() {
        while (true) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Adicionar pessoa");
            System.out.println("2. Ver todas as pessoas");
            System.out.println("3. Atualizar pessoa");
            System.out.println("4. Remover pessoa");
            System.out.println("5. Sair");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    addPerson();
                    break;
                case 2:
                    viewAllPersons();
                    break;
                case 3:
                    updatePerson();
                    break;
                case 4:
                    removePerson();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private void addPerson() {
        System.out.println("Digite o nome da pessoa:");
        String name = scanner.nextLine();
        System.out.println("Digite a idade da pessoa:");
        int age = scanner.nextInt();
        scanner.nextLine();

        Person person = new Person(name, age);
        crud.create(person);
    }

    private void viewAllPersons() {
        List<Person> persons = crud.read();
        for (Person person : persons) {
            System.out.println("Nome: " + person.getName() + ", Idade: " + person.getAge());
        }
    }

    private void updatePerson() {
        System.out.println("Digite o índice da pessoa que você deseja atualizar:");
        int index = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Digite o novo nome da pessoa:");
        String newName = scanner.nextLine();
        System.out.println("Digite a nova idade da pessoa:");
        int newAge = scanner.nextInt();
        scanner.nextLine();

        Person newPerson = new Person(newName, newAge);
        crud.update(index, newPerson);
    }

    private void removePerson() {
        System.out.println("Digite o índice da pessoa que você deseja remover:");
        int index = scanner.nextInt();
        scanner.nextLine();

        crud.delete(index);
    }

    public static void main(String[] args) {
        CrudExecutor executor = new CrudExecutor();
        executor.execute();
    }
}
