/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java8project;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    // Supplier to generate a new task
    public void addTask(Supplier<Task> taskSupplier) {
        tasks.add(taskSupplier.get());
    }

    // Consumer to print a task
    public void printTask(Consumer<Task> taskConsumer) {
        tasks.forEach(taskConsumer);
    }

    // Predicate to filter tasks
    public List<Task> filterTasks(Predicate<Task> taskPredicate) {
        return tasks.stream().filter(taskPredicate).collect(Collectors.toList());
    }

    // Function to map tasks
    public <R> List<R> mapTasks(Function<Task, R> taskMapper) {
        return tasks.stream().map(taskMapper).collect(Collectors.toList());
    }

    // Sort tasks using Comparator
    public void sortTasks(Comparator<Task> taskComparator) {
        tasks.sort(taskComparator);
    }

    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Add some tasks using supplier
        manager.addTask(() -> new Task("Write a blog post", LocalDate.now().plusDays(2)));
        manager.addTask(() -> new Task("Prepare presentation", LocalDate.now().plusDays(5)));
        manager.addTask(() -> new Task("Call John", LocalDate.now().plusDays(1)));

        // Print all tasks
        manager.printTask(System.out::println);

        // Mark first task as completed
        manager.tasks.get(0).setCompleted(true);

        // Filter tasks that are not completed
        List<Task> pendingTasks = manager.filterTasks(task -> !task.isCompleted());
        System.out.println("\nPending Tasks:");
        pendingTasks.forEach(System.out::println);

        // Sort tasks by deadline
        manager.sortTasks(Comparator.comparing(Task::getDeadline));
        System.out.println("\nTasks sorted by deadline:");
        manager.tasks.forEach(System.out::println);
    }
}

