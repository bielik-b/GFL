public class Drum extends Instrument {
    @Override
    protected void playNote(char note) {
        System.out.println("d : " + note);
    }
}
