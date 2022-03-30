package com.stevade;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Priority {
    private final PriorityQueue<Student> priorityQueue = new PriorityQueue<>(new StudentComparator());

    public List<Student> getStudentList(List<String> events) {
        events.forEach(event -> {
            if (event.startsWith("ENTER")) addStudentToQueue(event);
            if (event.equals("SERVED")) removeStudentFromQueue();
        });

        List<Student> result = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            result.add(priorityQueue.poll());
        }
        if(result.size() == 0) System.out.println("EMPTY");
        return result;
    }

    private void removeStudentFromQueue() {
        priorityQueue.poll();
    }

    private void addStudentToQueue(String event) {
        priorityQueue.add(convertEventToStudent(event));
    }

    private Student convertEventToStudent(String event) {
        String[] splitEvent = event.split(" "); //Event, name, cgpa, id;
        return new Student(
                Integer.parseInt(splitEvent[3]),
                splitEvent[1],
                Double.parseDouble(splitEvent[2])
        );
    }
}
