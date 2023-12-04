import java.util.NoSuchElementException;
import java.util.Objects;


public class LikeOptional {
    public static void main(String[] args) {
        Pair<Integer, String> pair = Pair.of(1, "hello");
        Integer i = pair.getFirst(); // 1
        String s = pair.getSecond(); // "hello"
        Pair<Integer, String> pair2 = Pair.of(1, "hello");
        boolean mustBeTrue = pair.equals(pair2); // true!
        boolean mustAlsoBeTrue = pair.hashCode() == pair2.hashCode(); // true!
        System.out.println(mustAlsoBeTrue);
        System.out.println(mustBeTrue);
        System.out.println(i);
        System.out.println(s);
    }
    public static class Pair <T, V> {
        private Pair (T value, V value2) {

            this.value = value;
            this.value2 = value2;
        }

        private static final Pair <?,?> EMPTY = new Pair<>(null,null);

        private final T value;

        private final V value2;

        public T getFirst() {
            if (value == null) {
                throw new NoSuchElementException("No value present");
            }
            return value;
        }
        public V getSecond() {
            if (value2 == null) {
                throw new NoSuchElementException("No value present");
            }
            return value2;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair<?, ?> pair = (Pair<?, ?>) o;
            if (!Objects.equals(value, pair.value)) return false;
            return Objects.equals(value2, pair.value2);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, value2);
        }

        public static <T,V> Pair<T,V> of(T value, V value2) {

            return new Pair <T,V>(value,value2);
        }
    }

}
