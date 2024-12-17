interface AuthorPrize {
    String awardMsg(String author, int books);
}

public class LambdaAuthorPrize {

    public static void main(String[] args) {
        String aName1 = "Sir Arthur Conan Doyle";
        int books1 = 12;

        AuthorPrize prize = (a, b) -> {
            return (b > 10) 
                ? "Congrats, " + a + "! You won for writing " + b + " books!" 
                : "Sorry, " + a + ", write more than 10 books to win.";
        };

        System.out.println(prize.awardMsg(aName1, books1));

        String aName2 = "John Doe";
        int books2 = 8;
        System.out.println(prize.awardMsg(aName2, books2));
    }
}
