package com.matrixglitch.TodoList.Todo;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private  static List<Todo> todos = new ArrayList<>();
    static {
        todos.add(new Todo(
                1,"Avinash","Learn Spring boot", LocalDate.now().plusYears(1),false));
        todos.add(new Todo(
                2,"Avinash","Learn Spring ", LocalDate.now().plusYears(2),false));
        todos.add(new Todo(
                3,"Avinash","Learn Spring AWS", LocalDate.now().plusYears(3),false));
    }

    public List<Todo> findByUser(String userName){
        return todos;
    }


}
