package broadcast;

public class Song implements BroadcastRubric {

   private String artist;
    private String track;
    private int length;

    public Song(String artist, String track, int length) {
        this.artist = artist;
        this.track = track;
        this.length = length;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }

    @Override
    public double getPrice() {
        return 0;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Song:  " +
                artist + " " +
                track + " " +
                length + " min"  ;
    }
}
