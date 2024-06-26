public interface ITaskList
{

    void addTask(ITask taskToAdd);
    void removeTask(ITask taskToRemove);
    void completeTask(ITask taskToComplete);
    void renameList(String name);
    void displayAllTasks();

   //Getters
    ITask getTask(int index);
    String getName();


}
