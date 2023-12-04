import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/*      Напишите программу, читающую из System.in текст в кодировке UTF-8, подсчитывающую в нем частоту появления слов,
        и в конце выводящую 10 наиболее часто встречающихся слов.

        Словом будем считать любую непрерывную последовательность символов, состоящую только из букв и цифр. Например,
        в строке "Мама мыла раму 33 раза!" ровно пять слов: "Мама", "мыла", "раму", "33" и "раза".

        Подсчет слов должен выполняться без учета регистра, т.е. "МАМА", "мама" и "Мама" — это одно и то же слово.
        Выводите слова в нижнем регистре.

        Если в тексте меньше 10 уникальных слов, то выводите сколько есть.

        Если в тексте некоторые слова имеют одинаковую частоту, т.е. их нельзя однозначно упорядочить только по частоте,
         то дополнительно упорядочите слова с одинаковой частотой в лексикографическом порядке.
    */
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
