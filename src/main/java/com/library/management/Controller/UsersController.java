package com.library.management.Controller;

import com.library.management.Manager.JsonManager;
import com.library.management.Model.UserModel;
import org.json.simple.parser.ParseException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

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

    @RequestMapping(method = RequestMethod.GET , produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserModel> getUsers(@RequestParam(required = false) Integer id) throws IOException, ParseException {

        return JsonManager.getUsers(id);
    }
}
