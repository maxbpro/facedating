package maxb.facedating.controllers;

import maxb.facedating.domain.Chat;
import maxb.facedating.domain.CompareInfo;
import maxb.facedating.domain.Message;
import maxb.facedating.domain.User;
import maxb.facedating.domain.rest.FacePlusResult;
import maxb.facedating.service.MessagesService;
import maxb.facedating.service.UserService;
import maxb.facedating.validator.NewMessageFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by MaxB on 25/11/2017.
 */
@Controller
@RequestMapping("/messages")
public class MessagesController {

    @Autowired
    private MessagesService messagesService;

    @Autowired
    private UserService userService;

    @Autowired
    private NewMessageFormValidator validator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(validator);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss.SS");
        dateFormatter.setLenient(false);
        binder.registerCustomEditor(Date.class, "createdAt", new CustomDateEditor(dateFormatter, true));
    }

    @RequestMapping(method = RequestMethod.GET)
    public String listChats(Model model) {

        int pageNumber = 0;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {

            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            User user = userService.findByUsername(userDetails.getUsername());

            Page<Chat> chatsPage = messagesService.findChats(user.getId(),
                    new PageRequest(pageNumber, 10));

            List<Chat> chats = chatsPage.getContent();

            List<User> users = new ArrayList<>();

            for (Chat chat : chats) {
                User otherUser = userService.findByUserId(chat.getSenderId());
                users.add(otherUser);
            }

            if(chats.size() > 0){

                Chat chat = chats.get(0);

                Page<Message> messagesPage = messagesService.findMessages(chat.getId(),
                        new PageRequest(pageNumber, 10, new Sort(Sort.Direction.DESC, "createdAt")));

                List<Message> messages = messagesPage.getContent();
                model.addAttribute("messages", messages);

                User otherUser = userService.findByUserId(chat.getSenderId());
                model.addAttribute("myPhoto", user.getPhotoUrl());
                model.addAttribute("otherPhoto", otherUser.getPhotoUrl());

                //can add active chat for updating UI

                model.addAttribute("chatId", chat.getId());
            }


            model.addAttribute("chats", chats);
            model.addAttribute("users", users);

        }

        model.addAttribute("messagesActive", true);
        model.addAttribute("postForm", new Message());
        return "messages/messages";
    }

    @RequestMapping(value = "/{chatId}", method = RequestMethod.GET)
    public String listChatById(@PathVariable Long chatId, Model model) {

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {

            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            User user = userService.findByUsername(userDetails.getUsername());

            Page<Chat> chatsPage = messagesService.findChats(user.getId(),
                    new PageRequest(0, 10));

            List<Chat> chats = chatsPage.getContent();

            List<User> users = new ArrayList<>();

            for (Chat chat : chats) {
                User otherUser = userService.findByUserId(chat.getSenderId());
                users.add(otherUser);
            }

            Page<Message> messagesPage = messagesService.findMessages(chatId,
                    new PageRequest(0, 10, new Sort(Sort.Direction.DESC, "createdAt")));

            List<Message> messages = messagesPage.getContent();



            model.addAttribute("chats", chats);
            model.addAttribute("users", users);
            model.addAttribute("messages", messages);

            //
            Chat activeChat = messagesService.findChatById(chatId);

            User otherUser = userService.findByUserId(activeChat.getSenderId());
            model.addAttribute("myPhoto", user.getPhotoUrl());
            model.addAttribute("otherPhoto", otherUser.getPhotoUrl());
            model.addAttribute("chatId", activeChat.getId());

        }

        model.addAttribute("messagesActive", true);
        model.addAttribute("postForm", new Message());
        return "messages/messages";
    }


    @ResponseBody
    @RequestMapping(value = "/{chatId}/{pageNumber}", method = RequestMethod.GET)
    public List<Message> getMessages(@PathVariable Long chatId, @PathVariable int pageNumber){

        Page<Message> messagesPage = messagesService.findMessages(chatId,
                new PageRequest(pageNumber, 10, new Sort(Sort.Direction.DESC, "createdAt")));

        return messagesPage.getContent();
    }




    @RequestMapping(value = "/chat/{senderId}", method = RequestMethod.GET)
    public String newChat(@PathVariable Long senderId){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {

            UserDetails userDetails = (UserDetails) auth.getPrincipal();
            User user = userService.findByUsername(userDetails.getUsername());

            Chat chat = messagesService.findChat(user.getId(), senderId);

            if(chat == null){

                chat = new Chat();
                chat.setUserId(user.getId());
                chat.setSenderId(senderId);
                messagesService.saveChat(chat);
            }else{

            }

            return "redirect:/messages/" + chat.getId();
        }

        return "redirect:/messages/";
    }

    @RequestMapping(value = "/{chatId}", method = RequestMethod.POST)
    public String newMessage(@PathVariable Long chatId,
                             @ModelAttribute("postForm") @Validated Message message,
                             BindingResult result, Model model, RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {

            redirectAttributes.addFlashAttribute("msg", "There are a few errors!");
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userForm", result);
            redirectAttributes.addFlashAttribute("postForm", message);
            return "redirect:/messages/" + chatId;

        } else {

            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            if (!(auth instanceof AnonymousAuthenticationToken)) {

                UserDetails userDetails = (UserDetails) auth.getPrincipal();
                User user = userService.findByUsername(userDetails.getUsername());

                Chat chat = messagesService.findChatById(chatId);

                message.setChatId(chat.getId());
                message.setCreatedAt(new Date());

                if(chat.getUserId().equals(user.getId())){
                    message.setAnswer(false);
                }else{
                    message.setAnswer(true);
                }

                messagesService.saveMessage(message);

            }

            return "redirect:/messages/" + chatId;

        }


    }


}
