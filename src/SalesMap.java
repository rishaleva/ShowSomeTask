import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SalesMap {
    public static void main(String[] args)  {
        ByteArrayInputStream bais = new ByteArrayInputStream("Алексей 3000\nДмитрий 9000\nАнтон 3000\nАлексей 7000\nАнтон 8000".getBytes());
        BufferedReader buffReader = new BufferedReader(new InputStreamReader(bais));
        System.out.println(getSalesMap(buffReader));
    }
    public static Map<String, Long> getSalesMap(Reader reader) {
        HashMap<String,Long> map = new HashMap<>();
        Scanner sc = new Scanner(reader);
        while (sc.hasNext()) {
            map.merge(sc.next(), sc.nextLong(), Long :: sum);
        }
        return map;
    }
}
