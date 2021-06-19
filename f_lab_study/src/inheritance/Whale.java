package inheritance;

public class Whale extends Mammal {
    public boolean fin = true;

    public Whale() {
        super(0);
        System.out.println("나는 고래다.");
    }

    public void swim() {
        System.out.println("다리 대신 지느러미가 있어 헤엄쳐서 이동한다.");
    }

    @Override
    public void move() {
        throw new NullPointerException("다리가 없어서 걸을 수 없다.");
    }

    @Override
    public void getElements() {
        super.getElements();
        System.out.println("지느러미가 있나? : " + fin);
    }
}
