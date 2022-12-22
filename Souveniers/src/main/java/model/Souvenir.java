package model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class Souvenir implements Serializable {
    private int id;
    private String title;
    private int producerId;
    private LocalDate date;
    private double price;

    public Souvenir(int id, String title, int producerId, LocalDate date, double price) {
        this.id = id;
        this.title = title;
        this.producerId = producerId;
        this.date = date;
        this.price = price;
    }

}
