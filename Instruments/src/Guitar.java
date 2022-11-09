public class Guitar extends Instrument {
    @Override
    protected void playNote(char note) {
        System.out.println("g: " + note);
    }
}
