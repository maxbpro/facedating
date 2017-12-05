package maxb.facedating.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by MaxB on 25/11/2017.
 */
@Controller
@RequestMapping("/messages")
public class MessagesController {

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {

        model.addAttribute("messagesActive", true);
        return "messages/messages";
    }

    @RequestMapping(value = "/chat", method = RequestMethod.GET)
    public String messages(Model model) {

        model.addAttribute("messagesActive", true);
        return "messages/chat";
    }
}
