package corbos.thejoke;

public class FunniestUniveralJoke implements Joke {

    private int ratingCount;
    private int totalRating;

    @Override
    public void tell() {
        System.out.println("Ole went to work one day. Lena was at home when there was a knock on the door.");
        System.out.println("It was Ole's friend and coworker Sven, who was quite frantic.");
        System.out.println("Sven said 'Lena, there's been a terrible tragedy. Ole is dead!'");
        System.out.println("Lena was in absolute shock! Lena said 'That's terrible, Sven! What happened?'");
        System.out.println("Sven says 'There was an accident at the Summit brewery. Ole went over there on his lunch break.");
        System.out.println("As he went on the tour, he fell into a vat of beer and drowned.'");
        System.out.println("Lena said 'Well, please tell me that he at least went quickly.'");
        System.out.println("Sven said 'Not really, Lena. He did get out three times to pee.'");
    }

    @Override
    public void rate(int rating) {
        ratingCount++;
        totalRating += rating;
        
        switch(rating)
        {
            case 1:
            case 2:
            case 3:
            case 4:
                System.out.println("You think that was a bad joke?!");
                break;
            case 5:
            case 6:
            case 7:
                System.out.println("You think the joke was decent!");
                break;
            case 8:
            case 9:
            case 10:
                System.out.println("You think that was really funny!");
                
               
        }
    }

}
