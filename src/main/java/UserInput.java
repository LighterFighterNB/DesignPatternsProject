import java.util.Scanner;

public class UserInput {
    public UserInput()
    {

    }

    public String getInput(String Question)
    {
        Scanner userInput = new Scanner(System.in);
        boolean hasInput = false;
        String input ="";
        while(!hasInput) {
            System.out.println(Question);

            input = userInput.nextLine();

            if (!input.isEmpty())
            {
                hasInput = true;
            }
        }
        return input;
    }
}
