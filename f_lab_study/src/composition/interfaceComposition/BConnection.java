package composition.interfaceComposition;

public class BConnection implements Connection {
    @Override
    public String connection() {
        return "B 데이터베이스 연결";
    }
}
