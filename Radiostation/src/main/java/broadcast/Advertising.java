package broadcast;

public class Advertising implements BroadcastRubric {

    private String product;
    private int  length;
    private static final int price = 5;

    public Advertising(String product, int length) {
        this.product = product;
        this.length = length;
    }

    @Override
    public double getPrice() {
        return price *length;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    @Override
    public int getLength() {
        return length;
    }

    @Override
    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Advertising:  " + " " +
                 product  + " " +
                 length + " min" ;
    }
}
