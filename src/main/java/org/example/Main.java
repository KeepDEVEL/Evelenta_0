package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/person")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @PostMapping(path="/update")
    public @ResponseBody String updatePerson(@RequestParam Integer id, @RequestParam String name, @RequestParam Integer age) {
        Person person = new Person();
        person.setId(id);
        person.setName(name);
        person.setAge(age);

        Person updatedPerson = personRepository.merge(person);

        if(updatedPerson != null) {
            return "Person updated successfully!";
        } else {
            return "Failed to update person.";
        }
    }
}