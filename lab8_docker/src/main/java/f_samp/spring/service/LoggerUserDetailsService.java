package f_samp.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoggerUserDetailsService implements UserDetailsService {


   private final LoginService userService;
    @Autowired
    public LoggerUserDetailsService(LoginService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserDetails details = userService.loadUserByUsername(login);
        if (details != null) {
            return details;
        } else {
            throw new UsernameNotFoundException("Invalid user " + login);
        }
    }


}
