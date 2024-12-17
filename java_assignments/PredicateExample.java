import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {

        Predicate<Integer> even = n -> n % 2 == 0;
        Predicate<Integer> gt100 = n -> n > 100;

        Predicate<Integer> evenAndGt100 = even.and(gt100);
        Predicate<Integer> evenOrGt100 = even.or(gt100);
        Predicate<Integer> notEven = even.negate();

        System.out.println("Even? " + even.test(12));
        System.out.println("> 100? " + gt100.test(120));
        System.out.println("Even & > 100? " + evenAndGt100.test(120));
        System.out.println("Even or > 100? " + evenOrGt100.test(140));
        System.out.println("Not Even? " + notEven.test(120));
    }
}
