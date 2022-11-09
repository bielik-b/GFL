public class Main {
    public static void main(String[] args) {
        Instrument drum = new Drum();
        Instrument guitar = new Guitar();
        Instrument saxophone = new Saxophone();

        saxophone.play("trututu");
        guitar.play("brynBryn");
        drum.play("BamBam");
    }
}
