public class Film {

    private FilmType type = FilmType.PREMIER;
    private BonusType bonus = BonusType.ZERO_BONUS;

    public void setType(FilmType type) {

        this.type = type;
    }

    public void setBonus(BonusType bonus) {
        this.bonus = bonus;
    }

    public int price(int days) {
        return getPrice(days) + getBonus(days);
    }

    private int getBonus(int days) {
        if(bonus==BonusType.PREMIER_BONUS){
            return 15;
        }else if(bonus==BonusType.REGULAR_BONUS){
            return 10;
        } else if(bonus==BonusType.CHILDREN_BONUS){
            return 5;
        } else return 0;
    }

    private int getPrice(int days) {
        if (type == FilmType.PREMIER) {
            return days * 3;
        } else if (type == FilmType.REGULAR) {
            return days * 2;
        } else if (type == FilmType.CHILDREN) {
            return days;
        } else return 0;
    }
}
