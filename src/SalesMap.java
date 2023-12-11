import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SalesMap {
    public static void main(String[] args)  {
        ByteArrayInputStream bais = new ByteArrayInputStream("������� 3000\n������� 9000\n����� 3000\n������� 7000\n����� 8000".getBytes());
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
