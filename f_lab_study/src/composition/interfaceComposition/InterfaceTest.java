package composition.interfaceComposition;

import java.util.logging.Level;
import java.util.logging.Logger;

public class InterfaceTest {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger(InterfaceTest.class.getName());
        logger.info("hello");
        logger.log(Level.WARNING, "위험한 상태!");
        Connection connection = new AConnection();
        System.out.println(connection.connection());
    }
}
