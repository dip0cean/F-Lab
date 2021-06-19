package composition;

public class CheeseBurger extends Hamburger {
    public CheeseBurger() {
        this.name = "치즈버거";
        this.price = this.getPrice() + 1000;
    }
}
