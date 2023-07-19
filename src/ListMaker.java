import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{
    static ArrayList<String> list = new ArrayList<>();
    private static void displayList()
    {
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
        if (list.size() != 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("+%3d%41s+\n", i + 1, String.valueOf(list.get(i)));
            }
        } else
            System.out.println("+++           List is empty                +++");
        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++");
    }

    public static void main(String [] args)
    {
        Scanner console = new Scanner(System.in);
        final String menu = "A - Add D - Delete P - Print Q - Quit";
        boolean done = false;
        String cmd = "";

        do
        {
            // display the list
            displayList();
            // display the menu options
            // get a menu choice
            cmd = SafeInput.getRegExString(console, menu, "[AaDdPpQq]");
            //cmd = cmd.toUpperCase();


            // execute the choice
            switch(cmd)
            {
                case "A":
                case "a":
                    // Prompt the user for a list item
                    // make sure it is not an empty string using SafeInput.getNonZeroLengthString
                    String item = SafeInput.getNonZeroLenString(console, "Enter a list item ");

                    // add it to the list
                    list.add(item);
                    break;

                case "D":
                case "d":
                    // Prompt the user for the number of the item to delete
                    int itemToDelete = SafeInput.getRangedInt(console, "Enter the number of the item to delete: ", 1, list.size());

                    // Translate the number to an index by subtracting 1
                    itemToDelete--;

                    // verify index validity
                    if (itemToDelete < 0 || itemToDelete >= list.size()) {
                        System.out.println("Invalid index.");
                        break;
                    }
                    // remove the item from the list
                    list.remove(itemToDelete);
                    break;

                case "P":
                case "p":
                    for (String listItem : list)
                    {
                        if (!listItem.contains("++"))
                        {
                            System.out.println(listItem);
                        }
                    }
                    break;

                case "Q":
                case "q":
                    boolean confirmQuit = SafeInput.getYNConfirm(console, "Are you sure you want to quit?");
                    if (confirmQuit) {
                        System.exit(0);
                        break;
                    }
            }
            System.out.println("cmd is " + cmd);

        } while(!done);
    }
}
