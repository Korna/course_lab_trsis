package f_samp.spring.rest;

import f_samp.listservice.UserList;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;


@RestController
@RequestMapping("/rest/Persons/fuck")
public class UserRest {

    //@Autowired
    private UserList UL= new UserList();


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> browse() {
        return ResponseEntity.ok(UL.getUserList());
    }

    @RequestMapping(value = "/delete/{login}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("login") String login, @AuthenticationPrincipal Principal principal) {

        if (principal == null) {
            throw new ForbiddenException();
        }

        UL.deleteUser(login);
    }

    @RequestMapping(value = "/mockdelete/{login}", method = RequestMethod.GET)
    public void mockdelete(@PathVariable("login") String login, @AuthenticationPrincipal Principal principal) {
        if (principal == null) {
            throw new ForbiddenException();
        }

        UL.deleteUser(login);
    }
    @RequestMapping(value = "/add/{login}/{hash}", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@PathVariable("login") String login, @PathVariable("hash") String hash, @AuthenticationPrincipal Principal principal) {
        if (principal == null) {
            throw new ForbiddenException();
        }

        return ResponseEntity.ok(UL.addUser(login, hash));
    }

}
