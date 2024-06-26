import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args)
    {

        List<ITaskList> AllLists = new ArrayList();

        List<ITask> completedTasks = new ArrayList();


        while (true)
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("-----------------------------");
            System.out.println("1. Create a new list");
            System.out.println("2. Manage existing lists");
            System.out.println("3. View all completed tasks");

            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1)
            {
                System.out.println("-----------------------------");
                System.out.println("Enter the name of the list. ");


                String listName = scanner.nextLine();
                TaskList list = new TaskList(listName); //Abstraction
                AllLists.add(list);
                System.out.println("List created. ");
            }

            else if (choice == 2)
            {

                System.out.println("-----------------------------");
                System.out.println("All Lists Available: ");
                for (int i = 0; i < AllLists.size(); i++)
                {
                    System.out.println(i + 1 + ". " + AllLists.get(i).getName());
                }

                System.out.println("Enter the list number to manage. ");
                int listNumber = scanner.nextInt() - 1;
                scanner.nextLine();

                int optionNumber = 0;

                while (optionNumber != 7)
                {
                    System.out.println("All Tasks Currently In  " + AllLists.get(listNumber).getName());
                    AllLists.get(listNumber).displayAllTasks();


                    System.out.println("1. Add Task");
                    System.out.println("2. Remove Task");
                    System.out.println("3. Complete Task");
                    System.out.println("4. Rename List");
                    System.out.println("5. Edit a task");
                    System.out.println("6. Delete a list");
                    System.out.println("7. Return to home menu");

                    optionNumber = scanner.nextInt();
                    scanner.nextLine();

                    if (optionNumber == 1) {
                        System.out.println("Enter the task description. ");
                        String description = scanner.nextLine();

                        System.out.println("Enter the task due date. ");
                        String dateDue = scanner.nextLine();

                        ITask task = new Task(description, dateDue);
                        AllLists.get(listNumber).addTask(task);
                        //AllLists.get(listNumber).displayAllTasks();
                    }
                    else if (optionNumber == 2) {
                        System.out.println("Enter the task number to remove");
                        int taskNumber = scanner.nextInt();
                        ITask taskToRemove = AllLists.get(listNumber).getTask(taskNumber - 1);
                        AllLists.get(listNumber).removeTask(taskToRemove);
                        //AllLists.get(listNumber).displayAllTasks();
                    }
                    else if (optionNumber == 3) {
                        System.out.println("Enter the task number to complete");
                        int taskNumber = scanner.nextInt();
                        scanner.nextLine();
                        ITask taskToComplete = AllLists.get(listNumber).getTask(taskNumber - 1);
                        completedTasks.add(taskToComplete);
                        AllLists.get(listNumber).completeTask(taskToComplete);
                        AllLists.get(listNumber).displayAllTasks();

                    }
                    else if (optionNumber == 4) {
                        System.out.println("Enter the new name");
                        String newName = scanner.nextLine();
                        AllLists.get(listNumber).renameList(newName);
                    }

                    else if (optionNumber == 5) {
                        System.out.println("Enter the task number to edit");
                        int taskNumber = scanner.nextInt();
                        scanner.nextLine();
                        AllLists.get(listNumber).getTask(taskNumber - 1).modifyDetails();
                    }

                    else if (optionNumber == 6) {
                        AllLists.remove(listNumber - 1);
                        System.out.println("List deleted successfully.");

                    }



                }

            }

            else if (choice == 3)
            {
                System.out.println("All completed tasks");
                for (int i = 0; i < completedTasks.size(); i++)
                {
                    completedTasks.get(i).viewDetails();
                }
            }



        }




        // List<String> items;

    }
}