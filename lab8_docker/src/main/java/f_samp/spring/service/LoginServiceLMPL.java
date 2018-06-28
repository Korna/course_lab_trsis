package f_samp.spring.service;

import f_samp.listservice.MyUser;
import f_samp.listservice.UserList;
import org.springframework.stereotype.Service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Service
public class LoginServiceLMPL implements LoginService {

   // @Autowired
    private UserList myUserList = new UserList();

    @Override
    public UserDetails loadUserByUsername(String string) throws UsernameNotFoundException {
        MyUser login = myUserList.searchUser(string);
        if (login == null) {
            throw new UsernameNotFoundException("user not found");
        }

        return new MyLogin(login);
    }



}