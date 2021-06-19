package inheritance;

public class Mammal extends Animal {

    public Mammal() {
        System.out.println("나는 포유류다.");
    }

    public Mammal(int legs) {
        this.legs = legs;
        System.out.println("다리가 " + this.legs + "개를 가진 포유류다.");
    }

    @Override
    public void breeding() {
        System.out.println("임신으로 자식을 낳아 세대를 잇는다.");
    }
}
