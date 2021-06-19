package composition;

public class HamburgerSet extends Menu {
    public Hamburger   hamburger;
    public Coke        coke;
    public FrenchFries frenchFries;

    public HamburgerSet(Hamburger hamburger, Coke coke, FrenchFries frenchFries) {
        this.hamburger = hamburger;
        this.coke = coke;
        this.frenchFries = frenchFries;

        this.name = hamburger.getName() + " 세트";
        this.price = (this.hamburger.getPrice() + this.coke.getPrice() + this.frenchFries.getPrice()) - 2000;
        System.out.println(this.name + " 가격 : " + this.price + "원");
    }

    public void getHamburger() {
        System.out.println("단품 메뉴명 : " + this.hamburger.getName());
        System.out.println("단품 가격 : " + this.hamburger.getPrice() + "원");
    }

    public void getCoke() {
        System.out.println("단품 메뉴명 : " + this.coke.getName());
        System.out.println("단품 가격 : " + this.coke.getPrice() + "원");
    }

    public void getFrenchFries() {
        System.out.println("단품 메뉴명 : " + this.frenchFries.getName());
        System.out.println("단품 가격 : " + this.frenchFries.getPrice() + "원");
    }
}
