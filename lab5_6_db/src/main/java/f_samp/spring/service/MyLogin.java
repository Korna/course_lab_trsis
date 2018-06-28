package f_samp.spring.service;

import f_samp.listservice.MyUser;
import org.springframework.security.core.authority.AuthorityUtils;


public class MyLogin extends org.springframework.security.core.userdetails.User {

    private static final long serialVersionUID = 1L;

   private MyUser new_user;
    public MyLogin(MyUser user) {
        super(user.getLogin(), user.getHash(), AuthorityUtils.createAuthorityList("ALL"));
        this.new_user = user;
    }


}
