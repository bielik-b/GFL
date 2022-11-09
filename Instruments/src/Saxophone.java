public class Saxophone extends Instrument {
    @Override
    protected void playNote(char note) {
        System.out.println("s: "+note);
    }
}
