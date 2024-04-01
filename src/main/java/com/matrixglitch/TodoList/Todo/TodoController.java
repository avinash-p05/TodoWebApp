package com.matrixglitch.TodoList.Todo;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class TodoController {


    private TodoService todoService;

    public TodoController(TodoService todoService) {
        super();
        this.todoService = todoService;
    }

    @RequestMapping("list-todos")
    public String  listAllTodos(ModelMap model){
        List<Todo> todos =todoService.findByUser("Avinash");
        model.addAttribute("todos",todos);
        return "listTodo";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String  showNewTodoPage(ModelMap model){
        String username =  (String) model.get("name");
        Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "Todo";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    public String  addNewTodoPage(ModelMap model, @Valid Todo todo , BindingResult result){
        if(result.hasErrors()){
            return "Todo";
        }

        String username =(String) model.get("name");
        todoService.addTodo(username,todo.getDescription(), todo.getTargetDate(),false);
        return "redirect:list-todos";
    }


    @RequestMapping("delete-todo")
    public String  deleteTodo(@RequestParam int id){
        todoService.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo" , method = RequestMethod.GET)
    public String  showUpdateTodo(@RequestParam int id,ModelMap model){
        Todo todo = todoService.findById(id);
        model.addAttribute("todo",todo);
        return "Todo";
    }

    @RequestMapping(value = "update-todo",method = RequestMethod.POST)
    public String  updateTodo(ModelMap model, @Valid Todo todo , BindingResult result){
        if(result.hasErrors()){
            return "Todo";
        }
        String username =(String) model.get("name");
        todo.setUsername(username);
        todoService.updateTodo(todo);
        return "redirect:list-todos";
    }
}
