import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MessageSortAndPrint {
    public static void main(String[] args) throws UnsupportedEncodingException {
        String text = " Мама мыла-мыла-мыла раму!";
        ByteArrayInputStream textInput = new ByteArrayInputStream(text.getBytes());
        System.setIn(textInput);
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            reader.lines().map(String::toLowerCase).map(s -> s.replaceAll("\\p{Punct}", " ")
                            .replaceAll("[^А-яЁёA-z 8-9]", " "))
                    .flatMap(c -> Arrays.stream(c.split("\\s+")))
                    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                    .entrySet().stream().sorted((a, b) -> a.getValue() == b.getValue() ?
                            a.getKey().compareTo(b.getKey()) :
                            (int) (b.getValue() - a.getValue())).map(Map.Entry::getKey).limit(10)
                    .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
