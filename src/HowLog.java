import java.util.logging.Level;
import java.util.logging.Logger;

public class HowLog {

    public static void main(String[] args) {
        logging();
    }

    public static void logging() {
        Logger logger = Logger.getLogger("com.javamentor.logging.Test");
        logger.log(Level.INFO, "Все хорошо");
        logger.log(Level.WARNING, "Произошла ошибка");
    }
}
