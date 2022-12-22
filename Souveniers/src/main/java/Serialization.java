import lombok.Data;
import lombok.SneakyThrows;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Data
public class Serialization<T> implements Serializable {
    private String path;

    public Serialization(String path) {
        this.path = path;
    }

    @SneakyThrows
    public void save(List<T> objects) {
        ObjectOutputStream write = new ObjectOutputStream(new FileOutputStream(path));
        write.writeObject(objects);
    }

    @SneakyThrows
    public List<T> read() {
        List<T> list;
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(path));
        list = (ArrayList<T>) reader.readObject();
        return list;
    }

}
