package presenter;

import broadcast.Broadcast;

import java.util.List;

public class Presenters  {
    private String name;
    private int experience;
    private String CV;
    private List<Broadcast> broadcasts;

    private Presenters(){}

    public static class Builder{
        private String name;
        private int experience;
        private String CV;
        private List<Broadcast> broadcasts;

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder experience(int experience) {
            this.experience = experience;
            return this;
        }

        public Builder CV(String CV) {
            this.CV = CV;
            return this;
        }

        public Builder broadcasts(List<Broadcast> broadcasts) {
            this.broadcasts = broadcasts;
            return this;
        }

        public Presenters build() {
            Presenters presenters =  new Presenters();
            presenters.name = name;
            presenters.experience = experience;
            presenters.CV = CV;
            presenters.broadcasts = broadcasts;
            return presenters;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getCV() {
        return CV;
    }

    public void setCV(String CV) {
        this.CV = CV;
    }

    public List<Broadcast> getBroadcasts() {
        return broadcasts;
    }

    public void setBroadcasts(List<Broadcast> broadcasts) {
        this.broadcasts = broadcasts;
    }

    @Override
    public String toString() {
        return "Presenters  " +
                "Name: " + name +
                ", Experience: " + experience +
                ", CV: " + CV +
                ", Broadcasts: " + broadcasts ;
    }
}
