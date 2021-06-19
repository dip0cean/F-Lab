package composition;

public class CompositionTest {
    public static void main(String[] args) {
        // 빅맥 세트만들기
        // 코크 > 다이어트 콜라로 변경
        // 프렌치프라이 > 치즈 프렌치프라이 변경
        Hamburger   bigMac            = new BigMac();
        Coke        dietCoke          = new DietCoke();
        FrenchFries cheeseFrenchFries = new CheeseFrenchFries();

        HamburgerSet bigMacSet = new HamburgerSet(bigMac, dietCoke, cheeseFrenchFries);
        bigMacSet.getHamburger();
        bigMacSet.getCoke();
        bigMacSet.getFrenchFries();

        System.out.println();

        // 치즈버거
        // 기본 구성
        Hamburger    cheeseBurger    = new CheeseBurger();
        Coke         coke            = new Coke();
        FrenchFries  frenchFries     = new FrenchFries();
        HamburgerSet cheeseBurgerSet = new HamburgerSet(cheeseBurger, coke, frenchFries);
        cheeseBurgerSet.getHamburger();
        cheeseBurgerSet.getCoke();
        cheeseBurgerSet.getFrenchFries();
    }
}
