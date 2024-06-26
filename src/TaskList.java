import java.util.ArrayList;
import java.util.List;

public class TaskList implements ITaskList
{
    private String listName;
    private List<ITask> tasks = new ArrayList();


    //Constructor
    public TaskList(String listNameP){listName = listNameP;}


    //Interface methods implemented


    public void addTask(ITask taskToAdd)
    {
        tasks.add(taskToAdd);
        System.out.println("Task Added.");
    }


    public void removeTask(ITask taskToRemove)
    {
        tasks.remove(taskToRemove);
        System.out.println("Task removed.");

    }


    public void completeTask(ITask taskToComplete)
    {
        tasks.remove(taskToComplete);
        System.out.println("Task Complete. Well done!");
    }

    public void renameList(String name)
    {
        listName = name;
        System.out.println("List renamed.");
    }

    public void displayAllTasks()
    {
        for (int i = 0; i < tasks.size(); i++)
        {

            System.out.println("Task Number:    " + (i + 1));
            tasks.get(i).viewDetails();
            System.out.println("-----------------------------");
        }
    }

    public ITask getTask(int index){return tasks.get(index);}
    public String getName() {return listName;}












}
