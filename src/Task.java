
import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;


public class Task implements ITask
{
    private List<String> items;

    private String description;
    private LocalDate dateAdded;
    private LocalDate dateDue;

    public Task(String descriptionP, String dateDueP)
    {
        description = descriptionP;
        dateAdded = LocalDate.now();
        dateDue = LocalDate.parse(dateDueP);
    }

    public void viewDetails()
    {
        System.out.println("Date Added:     "+ dateAdded);
        System.out.println("Description:    "+ description);
        System.out.println("Date Due:       "+ dateDue);
    }

    public void modifyDetails()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the new task details under each field. Leave blank if no changes needed.");
        System.out.print("Description:    ");
        String newDescription = scanner.nextLine();


        System.out.print("Date:    ");
        String newDate = scanner.nextLine();

        if (newDescription != ""){description = newDescription;}
        if (newDate != ""){dateDue = LocalDate.parse(newDate);}


    }


}
