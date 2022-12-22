import lombok.Data;
import lombok.SneakyThrows;
import model.Producer;
import model.Souvenir;

import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.util.*;

@Data
public class Service {
    Scanner scan = new Scanner(System.in);
    private String folder;
    private Serialization<Producer> producerSerialized;
    private Serialization<Souvenir> souvenirsSerialized;
    private List<Producer> producers = new ArrayList<>();
    private List<Souvenir> souvenirs = new ArrayList<>();

    public void run() {
        findFolder();

        producerSerialized = new Serialization<>(folder + "/" + "producers.bin");
        souvenirsSerialized = new Serialization<>(folder + "/" + "souvenirs.bin");

        producers = producerSerialized.read();
        souvenirs = souvenirsSerialized.read();


        System.out.print("\nWelcome to admin panel!\n");
        int choice;
        do {
            System.out.print("""
                    \u001B[32m--------------------\u001B[0m
                    1. Add new producer
                    2. Add new souvenir
                    3. Edit producer
                    4. Edit souviner
                    5. Show all producers and souvenirs
                    6. Show all producers
                    7. Show all souvenirs
                    8. Show souvenirs by entered producer
                    9. Show souvenirs by entered country
                    10. Show souvenirs where price less than quoted
                    11. Show producers and their souvenirs
                    12. Show producers by entered souvenirs year
                    13. Show souvenirs by entered year
                    14. Delete producer and his souvenirs
                    Your choice:\040""");
            choice = scan.nextInt();

            switch (choice) {
                case 1 -> addProducer();
                case 2 -> addSouvenir();
                case 3 -> editProducer();
                case 4 -> editSouvenir();
                case 5 -> showAll();
                case 6 -> showAllProducers();
                case 7 -> showAllSouvenirs();
                case 8 -> showSouvenirsByProducer();
                case 9 -> showSouvenirsByCountry();
                case 10 -> showSouvenirsByQuotedPrice();
                case 11 -> showProducersAndTheirSouvenirs();
                case 12 -> showProducersBySouvenirsYear();
                case 13 -> showSouvenirsByYear();
                case 14 -> removeProducer();
                default -> {
                }
            }
            System.out.print("\n⇢ For continue enter any number / for exit enter '0': ");
            choice = scan.nextInt();
        } while (choice != 0);
        System.out.println("\n✓ Work with the admin panel is completed!");

    }

    @SneakyThrows
    private void findFolder() {
        Properties properties = new Properties();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("config.properties"));
        properties.load(bufferedReader);
        folder = properties.getProperty("data");
    }

    private void addProducer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter new name: ");
        String name = scan.nextLine();
        System.out.println("Enter new country: ");
        String country = scan.nextLine();
        System.out.println("Enter new id:  ");
        int id = scan.nextInt();

        Producer p = new Producer(id, name, country);
        if (!isProducerExist(id)) {
            producers.add(p);
            producerSerialized.save(producers);
        } else System.out.println("Error");
    }

    private void addSouvenir() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter new title");
        String title = scan.nextLine();
        System.out.println("Enter new producerId");
        int producerId = scan.nextInt();
        System.out.println("Enter new year");
        int year = scan.nextInt();
        System.out.println("Enter new month");
        int month = scan.nextInt();
        System.out.println("Enter new day");
        int day = scan.nextInt();
        System.out.println("Enter new price");
        double price = scan.nextDouble();
        System.out.println("Enter new id");
        int id = scan.nextInt();

        Souvenir s = new Souvenir(id, title, producerId, LocalDate.of(year, month, day), price);
        if (isProducerExist(producerId)) {
            if (!isSouvenirExist(id)) {
                souvenirs.add(s);
                souvenirsSerialized.save(souvenirs);
            } else System.out.println("Entered id has already existed");
        } else System.out.println("Producer is not exist!");
    }

    private void editProducer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter new name: ");
        String name = scan.nextLine();
        System.out.println("Enter new country: ");
        String country = scan.nextLine();
        System.out.println("Enter new id:  ");
        int id = scan.nextInt();

        Producer p = new Producer(id, name, country);
        if (isProducerExist(id)) {
            p.setId(id);
            p.setName(name);
            p.setCountry(country);
            producerSerialized.save(producers);
        } else System.out.println("Error");
    }

    private void editSouvenir() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter new title");
        String title = scan.nextLine();
        System.out.println("Enter new producerId");
        int producerId = scan.nextInt();
        System.out.println("Enter new year");
        int year = scan.nextInt();
        System.out.println("Enter new month");
        int month = scan.nextInt();
        System.out.println("Enter new day");
        int day = scan.nextInt();
        System.out.println("Enter new price");
        double price = scan.nextDouble();
        System.out.println("Enter new id");
        int id = scan.nextInt();

        Souvenir s = new Souvenir(id, title, producerId, LocalDate.of(year, month, day), price);
        if (isProducerExist(producerId)) {
            if (isSouvenirExist(id)) {
                s.setId(id);
                s.setTitle(title);
                s.setProducerId(producerId);
                s.setDate(LocalDate.of(year, month, day));
                s.setPrice(price);
                souvenirsSerialized.save(souvenirs);
            } else System.out.println("Error");
        }
        addSouvenir();
    }

    private void showAll() {
        producers.stream()
                .sorted(Comparator.comparing(Producer::getId))
                .forEach(System.out::println);
        souvenirs.stream()
                .sorted(Comparator.comparing(Souvenir::getId))
                .forEach(System.out::println);
    }

    private void showAllProducers() {
        producers.stream()
                .sorted(Comparator.comparing(Producer::getId))
                .forEach(System.out::println);
    }

    private void showAllSouvenirs() {
        souvenirs.stream()
                .sorted(Comparator.comparing(Souvenir::getId))
                .forEach(System.out::println);
    }

    private void showSouvenirsByProducer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter id of producer");
        int number = scan.nextInt();
        souvenirs.stream()
                .filter(x -> Objects.equals(number, x.getProducerId()))
                .distinct()
                .forEach(System.out::println);

    }

    private void showSouvenirsByCountry() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter country");
        String country = scan.nextLine();
        getSouvenirsByCountry(country).forEach(System.out::println);

    }

    private void showSouvenirsByQuotedPrice() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter price");
        int price = scan.nextInt();
        List<Souvenir> souvenirsLessPrice = souvenirs.stream()
                .filter(x -> x.getPrice() < price)
                .toList();
        for (Producer producer : producers) {
            for (Souvenir souvenir : souvenirsLessPrice) {
                if (souvenir.getProducerId() == producer.getId()) {
                    System.out.println(producer);
                    System.out.println("\t" + souvenir);
                }
            }
        }
    }

    private List<Souvenir> getSouvenirsByCountry(String country) {
        List<Souvenir> souvenirsByCountry = new ArrayList<>();
        for (Souvenir s : souvenirs) {
            if (getProducerById(s.getProducerId()).getCountry().equalsIgnoreCase(country)) {
                souvenirsByCountry.add(s);
            }
        }
        return souvenirsByCountry;
    }

    private void showProducersAndTheirSouvenirs() {
        for (Producer producer : producers) {
            System.out.println(producer.getName());
            for (Souvenir souvenir : souvenirs) {
                if (producer.getId() == souvenir.getProducerId()) {
                    System.out.println(souvenir);
                }
            }
        }
    }

    private void showProducersBySouvenirsYear() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter year");
        int year = scan.nextInt();
        for (Producer producer : producers) {
            for (Souvenir souvenir : souvenirs) {
                if (year == souvenir.getDate().getYear()) {
                    System.out.println(getProducerById(souvenir.getProducerId()));
                } else System.out.println("Souvenir with entered year has not existed!");
            }
        }
    }

    private void showSouvenirsByYear() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter year");
        int year = scan.nextInt();
        for (Souvenir souvenir : souvenirs) {
            if (year == souvenir.getDate().getYear()) {
                System.out.println(souvenir);
            } else System.out.println("Souvenir with entered year has not existed!");
        }
    }

    private void removeProducer() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter id of producer");
        int id = scan.nextInt();
        if (isProducerExist(id)) {
            producers.remove(getProducerById(id));
            producerSerialized.save(producers);
        } else {
            System.out.println("This id is not exist!");
        }

        souvenirs.removeIf(x -> x.getProducerId() == id);
        souvenirsSerialized.save(souvenirs);
    }

    private Producer getProducerById(int id) {
        for (Producer producer : producers) {
            if (producer.getId() == id) {
                return producer;
            }
        }
        return null;
    }

    private boolean isProducerExist(int id) {
        for (Producer p : producers) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    private boolean isSouvenirExist(int id) {
        for (Souvenir s : souvenirs) {
            if (s.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
