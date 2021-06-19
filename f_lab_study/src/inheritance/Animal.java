package inheritance;

public class Animal {
    public int eyes  = 2;
    public int mouse = 1;
    public int legs  = 4;

    public Animal() {
        System.out.println("나는 동물이다.");
    }

    public void move() {
        System.out.println("걸어서 이동한다.");
    }

    public void breeding() {
        System.out.println("번식한다.");
    }

    public void getElements() {
        System.out.println("눈 : " + eyes + "개");
        System.out.println("입 : " + mouse + "개");
        System.out.println("다리 : " + legs + "개");
    }
}
