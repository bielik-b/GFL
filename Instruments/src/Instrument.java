public abstract class Instrument {

    protected abstract void playNote(char note);

    public void play(String melody) {
        for (int i = 0; i < melody.length(); i++) {
            playNote(melody.charAt(i));
        }
    }
}
