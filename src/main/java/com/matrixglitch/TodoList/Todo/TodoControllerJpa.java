package com.matrixglitch.TodoList.Todo;

import jakarta.validation.Valid;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
public class TodoControllerJpa {

    private TodoRepository todoRepository;


    public TodoControllerJpa(TodoRepository todoRepository) {
        super();
        this.todoRepository=todoRepository;
    }

    @RequestMapping("list-todos")
    public String  listAllTodos(ModelMap model){
        String username = getLoggedInUsername(model);
        List<Todo> todos =todoRepository.findByUsername(username);
        model.addAttribute("todos",todos);
        return "listTodo";
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.GET)
    public String  showNewTodoPage(ModelMap model){
        String username = getLoggedInUsername(model);
        Todo todo = new Todo(0,username,"",LocalDate.now().plusYears(1),false);
        model.put("todo",todo);
        return "Todo";
    }

    private static String getLoggedInUsername(ModelMap model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }

    @RequestMapping(value = "add-todo",method = RequestMethod.POST)
    public String  addNewTodoPage(ModelMap model, @Valid Todo todo , BindingResult result){
        if(result.hasErrors()){
            return "Todo";

        }

        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }


    @RequestMapping("delete-todo")
    public String  deleteTodo(@RequestParam int id){
        todoRepository.deleteById(id);
        return "redirect:list-todos";
    }

    @RequestMapping(value = "update-todo" , method = RequestMethod.GET)
    public String  showUpdateTodo(@RequestParam int id,ModelMap model){
        Todo todo = todoRepository.findById(id).get();
        model.addAttribute("todo",todo);
        return "Todo";
    }

    @RequestMapping(value = "update-todo",method = RequestMethod.POST)
    public String  updateTodo(ModelMap model, @Valid Todo todo , BindingResult result){
        if(result.hasErrors()){
            return "Todo";
        }
        String username = getLoggedInUsername(model);
        todo.setUsername(username);
        todoRepository.save(todo);
        return "redirect:list-todos";
    }
}
