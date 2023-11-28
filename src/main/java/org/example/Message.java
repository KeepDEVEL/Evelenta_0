package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path="/message")
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @PostMapping(path="/update")
    public @ResponseBody String updateMessage(@RequestParam Integer id, @RequestParam String content) {
        Message message = new Message();
        message.setId(id);
        message.setContent(content);

        Message updatedMessage = messageRepository.merge(message);

        if(updatedMessage != null) {
            return "Сообщение успешно обновлено!";
        } else {
            return "Сообщение не отправлено";
        }
    }
}
