package com.library.management.Controller;

import com.library.management.Manager.JsonManager;
import com.library.management.Model.UserModel;
import org.json.simple.parser.ParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping(value="/users")
public class UsersController {

    @RequestMapping(method = RequestMethod.POST , produces = MediaType.APPLICATION_JSON_VALUE)
    public Object addUsers(@RequestBody UserModel user){

        try {
            JsonManager.addToJson(user);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return user;
    }
}
