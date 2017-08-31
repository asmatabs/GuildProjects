package corbos.thejoke;

import java.util.Scanner;

public class JokeTeller {
    
    public void tellJoke(Joke joke) {
        
        joke.tell();
        
        System.out.println("Please rate this joke (1-10)");
        
        Scanner scanner = new Scanner(System.in);
        int rating = scanner.nextInt();
        joke.rate(rating);
    }
}
