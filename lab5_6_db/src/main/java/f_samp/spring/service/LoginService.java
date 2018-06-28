package f_samp.spring.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface LoginService {
    UserDetails loadUserByUsername(String string) throws UsernameNotFoundException;
}
