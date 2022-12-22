package model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Producer implements Serializable {
    private int id;
    private String name;
    private String country;

    public Producer(int id, String name, String country) {
        this.id = id;
        this.name = name;
        this.country = country;
    }
}
