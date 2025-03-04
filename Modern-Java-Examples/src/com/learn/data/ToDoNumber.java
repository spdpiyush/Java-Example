package com.learn.data;

import java.util.ArrayList;
import java.util.List;

public class ToDoNumber {

    private static List<String> toDoNumberList = new ArrayList<>();

    public static String addNumberToList(int no) {
        String task = "Task-No-" + no;
        toDoNumberList.add(task);
        return task;
    }

    public static List<String> getToDoNumberList() {
        return toDoNumberList;
    }

}
