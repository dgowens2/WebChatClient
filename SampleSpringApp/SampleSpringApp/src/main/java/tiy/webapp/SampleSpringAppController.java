package tiy.webapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by DTG2 on 09/12/16.
 */
@Controller //annotation from Spring
public class SampleSpringAppController {

    @RequestMapping(path = "/person-url", method = RequestMethod.GET)
    public String person(Model model, String name, String city, int age) {
        Person p = new Person(name, city, age);
        model.addAttribute("person-object", p);
        return "person-view";
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public String home(Model model, HttpSession session) {
        model.addAttribute("name", session.getAttribute("userName"));
        return "home";
    }

    @RequestMapping(path = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("userName");
        return "redirect:/";
    }
    @RequestMapping(path = "/login", method = RequestMethod.POST)
    public String login(HttpSession session, String userName) {
        session.setAttribute("userName", userName);
        return "redirect:/";
    }

    @RequestMapping(path = "/chat", method = RequestMethod.GET)
    public String chat() {
        return "chat-view";
    }

    @RequestMapping(path = "/inputText", method = RequestMethod.POST)
    public String inputText(HttpSession session, String message) {
        WebChatClient myChatClient = new WebChatClient();
        myChatClient.sendMessage(message);
        session.getAttribute(message);
        return "redirect:/chat";
    }

    //view does not see session, view sees model
    //model exists only for that one transaction
    //session lives between connections from the same client to the same server
}

