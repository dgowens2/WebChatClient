package tiy.webapp;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by DTG2 on 09/12/16.
 */
@RestController //Rest API is a JSON API over HTTP (uses HTTP to talk to network and the content it sends is JSON content)
public class SampleSpringAppJsonController {
    @RequestMapping(path = "/person.json", method = RequestMethod.GET)
    public Person jsonHome(String name, String city, int age) {
        return new Person(name, city, age);
//  this is an endpoint for a microservice
    }
}
