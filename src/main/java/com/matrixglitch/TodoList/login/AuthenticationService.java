package com.matrixglitch.TodoList.login;


import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String name,String pass){
        if(name.equalsIgnoreCase("Avinash") && pass.equalsIgnoreCase("12345"))
            return true;
        return false;
    }
}
