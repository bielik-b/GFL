public class Main {
    public static void main(String[] args) {
        Film f = new Film();
        System.out.println(f.price(5));

        f.setBonus(BonusType.REGULAR_BONUS);
        f.setType(FilmType.REGULAR);
        System.out.println(f.price(3));
    }
}
