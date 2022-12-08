package broadcast;

public class Interview implements BroadcastRubric {
     private String name;
     private int length;
     private static final int price = 30;

    public Interview(String name, int length) {
        this.name = name;
        this.length = length;
    }

    @Override
    public double getPrice() {
        return price*length;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void setLength(int length) {
    this.length = length;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Interview:  " +
                 name + " " +
                 length + " min"  ;
    }
}
