import kronaegit.ariha.util.Hash;
import kronaegit.ariha.util.RandomGenerator;

public class Test {
    public static void main(String[] args) {
        System.out.println(new RandomGenerator(32307132790L).getRandomString(32));
        System.out.println(new RandomGenerator(999L).getRandomString(32));
        System.out.println(new RandomGenerator(887213L).getRandomString(24));
        System.out.println(Hash.SHA256(""));
    }
}
