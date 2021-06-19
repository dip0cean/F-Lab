package composition;

public class DietCoke extends Coke {
    public DietCoke() {
        this.name = "다이어트 콜라";
        this.price = this.price + 500;
    }
}
