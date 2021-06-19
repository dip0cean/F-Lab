package composition.interfaceComposition;

public class AConnection implements Connection {

    @Override
    public String connection() {
        return "A 데이터베이스에 연결";
    }
}
