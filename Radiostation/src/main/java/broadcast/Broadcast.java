package broadcast;

import presenter.Presenters;

import java.util.ArrayList;
import java.util.List;

public class Broadcast {
    private double length;
    private String title;
    private List<BroadcastRubric> rubrics = new ArrayList<>();
    private List<Presenters> presenters = new ArrayList<>();

    public Broadcast(String title, double length) {
        this.title = title;
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<BroadcastRubric> getRubrics() {
        return rubrics;
    }

    public void setRubrics(List<BroadcastRubric> rubrics) {
        this.rubrics = rubrics;
    }

    public List<Presenters> getPresenters() {
        return presenters;
    }

    public void setPresenters(List<Presenters> presenters) {
        this.presenters = presenters;
    }

    public void addPresenter(Presenters presenter){
        presenters.add(presenter);
    }

    public void addHeading(BroadcastRubric heading) throws IllegalArgumentException{
        if(calcRubricLenght() + heading.getLength() > length) {
            throw new IllegalArgumentException("Exceeded duration of broadcast");
        } else if (heading instanceof Advertising || heading instanceof Interview ) {
            if (calcPaidRubric()>length/2) {
                throw new IllegalArgumentException("Exceeded duration of paid content");
            } else {
                rubrics.add(heading);
            }
        } else {
            rubrics.add(heading);
        }
    }

    private int calcPaidRubric() {
        return rubrics.stream()
                .filter(x -> x instanceof Advertising || x instanceof Interview)
                .mapToInt(BroadcastRubric::getLength)
                .sum();
    }

    private int calcRubricLenght() {
        return rubrics.stream()
                .mapToInt(BroadcastRubric::getLength)
                .sum();
    }

    public double calcMoney(){
        return rubrics.stream()
                .mapToDouble(BroadcastRubric :: getPrice )
                .sum();
    }

    public void showInfo(){
        rubrics.forEach(System.out::println);
    }

    @Override
    public String toString() {
        return title + " " ;
    }
}
