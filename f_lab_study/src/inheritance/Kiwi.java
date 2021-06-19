package inheritance;

public class Kiwi extends Bird {

    public Kiwi() {
        super(0);
        System.out.println("나는 키위새다.");
    }

    @Override
    public void fly() {
        throw new NullPointerException("날개가 없어 날 수 없다.");
    }
}
