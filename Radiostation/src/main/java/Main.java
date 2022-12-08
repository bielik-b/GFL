import broadcast.Advertising;
import broadcast.Broadcast;
import broadcast.Interview;
import broadcast.Song;
import presenter.Presenters;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        new Main().run();

    }

    private void run() {
        Broadcast broadcast = new Broadcast("Radio Sharmanka", 120);
        List<Broadcast> broadcastArch = new ArrayList<>();
        broadcastArch.add(broadcast);

        Presenters presenter1 = new Presenters.Builder()
                .name("Bohdan Bielik").experience(5).broadcasts(broadcastArch).build();
        Presenters presenter2 = new Presenters.Builder()
                .name("Serhi Prytula").CV("Host,comic").broadcasts(broadcastArch).build();

        broadcast.addHeading(new Song("Eminem","Superman", 3));
        broadcast.addHeading(new Song("50 Cent","Album 2010", 20));
        broadcast.addHeading(new Song("Beyonce","Hits 90", 35));
        broadcast.addHeading(new Advertising("coffee",2));
        broadcast.addHeading(new Interview("Tina Karol",20));
        broadcast.addHeading(new Interview("Oleh Skrypka", 20));
        broadcast.addHeading(new Song("Tina Karol", "Skandal", 5));
        broadcast.addHeading(new Song("T-fest", "Skandal", 5));
        broadcast.addHeading(new Song("Basta", "Sansara", 5));
        broadcast.addHeading(new Song("Skriptonite", "Privychka", 3));
        broadcast.addHeading(new Advertising("Film", 2));

        broadcast.showInfo();

        System.out.println(presenter1);
        System.out.println(presenter2);




    }


}
