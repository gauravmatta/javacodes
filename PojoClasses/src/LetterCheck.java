public class LetterCheck {

    public static void main(String args[]) {
        char symbol = 'A';
        symbol = (char) (128 * Math.random());
        if (symbol >= 'A') {
            if (symbol <= 'Z') {
                System.out.println("You have got a capital Letter " + symbol);
            } else {
                if (symbol <= 'a') {
                    if (symbol <= 'z') {
                        System.out.println("You have got a small Letter " + symbol);
                    } else {
                        System.out.println("The code is greater than 'a' but its not a letter");
                    }
                } else {
                    System.out.println("The code is less than 'a' but its not a letter");
                }
            }
        }
        else
        {
            System.out.println("The code is less than 'A' but its not a letter");
        }
    }
}
