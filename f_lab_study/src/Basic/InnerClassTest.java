package Basic;

public class InnerClassTest {
    public static void main(String[] args) {
        InnerClassTest test = new InnerClassTest();
        Button button = new Button() {
            @Override
            public void clickButton() {
                System.out.println("버튼 객체 생성!");
            }
        };
        button.clickButton();
        test.setButton(button);
        test.clickEvent();
    }

    private Button button;

    public void setButton(Button button) {
        this.button = button;
    }

    public void clickEvent() {
        if (this.button != null) {
            System.out.println("클릭!");
        } else {
            System.out.println("클릭 객체 없음!");
        }
    }
}
