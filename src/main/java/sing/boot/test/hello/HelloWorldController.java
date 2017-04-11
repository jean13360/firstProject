package sing.boot.test.hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api(value="helloworld", tags = {"Operation apr défaut"})
public class HelloWorldController {

    @RequestMapping(name="helloworld", value="/", method=RequestMethod.GET)	 
    public String index() {
        return "Greetings from Spring Boot!";
    }

}