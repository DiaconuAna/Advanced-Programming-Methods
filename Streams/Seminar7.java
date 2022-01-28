import java.util.Arrays;
import java.util.List;

public class seminar7 {

    static void p1() {

        System.out.println("**** Problem 1 ****\n");
        List<String> words = Arrays.asList("hi", "hello", "annyeong", "hey");
        words.stream().forEach(word -> System.out.println("  " + word));

    }

    static void p2(){
        System.out.println("**** Problem 2 ****\n");
        List<String> words = Arrays.asList("hi", "hello", "annyeong", "hey");
        words.stream().forEach(System.out::println);
    }

    static void p3(){
        System.out.println("**** Problem 3 ****\n");
        List<String> words = Arrays.asList("hi", "hello", "annyeong", "hey");

        System.out.println("Part 1: exciting words\n");
        words.stream().map(word -> word + "!").forEach(System.out::println);

        System.out.println("Part 2: eye words\n");
        words.stream().map(word -> word.replace("i", "eye")).forEach(System.out::println);

        System.out.println("Part 3: uppercase words");
        words.stream().map(String::toUpperCase).forEach(System.out::println);

    }

    static void p4(){
        System.out.println("**** Problem 4 ****\n");
        List<String> words = Arrays.asList("hi", "hello", "annyeong", "hey","teddy bear");

        System.out.println("Part 1: short words\n");
        words.stream().filter(word -> word.length() < 4).forEach(System.out::println);

        System.out.println("Part 2: words with b\n");
        words.stream().filter(word -> word.contains("b")).forEach(System.out::println);

        System.out.println("Part 3: words of even length\n");
        words.stream().filter(word -> word.length()%2 == 0).forEach(System.out::println);
    }

    static void p5(){
        System.out.println("**** Problem 5 ****\n");
        List<String> words = Arrays.asList("hi", "hel", "annyeong", "hey","teddy bear","qt","qu");

        words.stream().map(String::toUpperCase).filter(word -> word.length()<4).filter(word -> word.contains("E")).findFirst().ifPresent(System.out::println);

        words.stream().map(String::toUpperCase).filter(word -> word.length()<4).filter(word -> word.indexOf("Q")!=-1).findFirst().ifPresent(System.out::println);
    }

    static void p6(){
        System.out.println("**** Problem 6 ****\n");
        List<String> words = Arrays.asList("hi", "hel", "annyeong", "hey","teddy bear","qt","qu");

        words.stream().reduce((w1, w2) -> w1.toUpperCase() + w2.toUpperCase()).ifPresent(System.out::println);

    }

    static void p7(){
        System.out.println("**** Problem 7 ****\n");
        List<String> words = Arrays.asList("hi", "hel", "annyeong", "hey","teddy bear","qt","qu");

        words.stream().map(String::toUpperCase).reduce((w1, w2) -> (w1 + w2)).ifPresent(System.out::println);

    }

    static void p8(){
        System.out.println("**** Problem 8 ****\n");
        List<String> words = Arrays.asList("hi", "hel", "annyeong", "hey","teddy bear","qt","qu");

        //String res =
        words.stream().reduce((w1,w2) -> w1 + "," + w2).ifPresent(System.out::println);//.substring(1);

        //System.out.println(res);
    }

    static void p9(){
        System.out.println("**** Problem 9 ****\n");
        List<String> words = Arrays.asList("hi", "hel", "annyeong", "hey","teddy ","bear","qt","qu");

        int s = words.stream().mapToInt(String::length).sum();
        System.out.println(s);

    }

    static void p10(){
        System.out.println("**** Problem 10 ****\n");
        List<String> words = Arrays.asList("hi", "hel", "annyeong", "hey","teddy ","bear","qt","qu");

        //int n = words.stream().filter(word -> word.contains("h")).mapToInt(word -> 1).sum();
        long n = words.stream().filter(word -> word.contains("h")).count();
        System.out.println(n);
    }

    public static void main(String[] args) {
        p1();
        p2();
        p3();
        p4();
        p5();
        p6();
        p7();
        p8();
        p9();
        p10();
    }

}
