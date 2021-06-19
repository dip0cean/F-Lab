package inheritance;

public class Bird extends Animal {

    public int wings = 2;

    public Bird() {
        this.legs = 2;
        System.out.println("나는 조류다.");
    }

    public Bird(int wings) {
        this.wings = wings;
        this.legs = 2;
        System.out.println("날개가 " + this.wings + "개를 가진 조류다.");
    }

    public void fly() {
        System.out.println("날아서 이동한다.");
    }

    @Override
    public void breeding() {
        System.out.println("알을 낳아 세대를 잇는다.");
    }

    @Override
    public void getElements() {
        super.getElements();
        System.out.println("날개 : " + wings + "개");
    }
}
