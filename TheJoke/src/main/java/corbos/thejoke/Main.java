package corbos.thejoke;

public class Main {
    public static void main(String[] args) {
        JokeTeller teller = new JokeTeller();
        Joke joke = new FunniestUniveralJoke();
        teller.tellJoke(joke);
    }
}
