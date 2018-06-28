package f_samp.listservice;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UserList {


    private static List<MyUser> UserList = new ArrayList<MyUser>();

    static {
       UserList.add(new MyUser("Nooo", "$2a$10$pdj2bP8tKAVT8C45BOrZ6uZJihh2tqGQreGYW7gGAZGmxPO3prAzC"));
        UserList.add(new MyUser("User", "$2a$10$6mf3CesQx9eRGB4B3sjr8e1eSr5cYO/zt87bwYVdA4O8rmjDMDdHO"));
 }

    public MyUser addUser(String login, String hash) {
      MyUser NewUser=new MyUser(login,hash);
        UserList.add(NewUser);
        return NewUser;
   }


   public boolean deleteUser(String login) {
        Iterator<MyUser> iterator = UserList.iterator();
        while (iterator.hasNext()) {
            MyUser currentProfile = iterator.next();

            if (currentProfile.getLogin().toLowerCase().equals(login.toLowerCase())) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

   public MyUser searchUser( String login) {
       MyUser result= new MyUser("","");
       if ((login==null) || (login=="undefined")) return result;

        //if (Surname==null) return result;
        for (MyUser profile:UserList) {
            if (profile.getLogin().toLowerCase().equals(login.toLowerCase()))
                 result = new MyUser(profile.getLogin(),profile.getHash());
        }
        return  result;
    }

    public List<MyUser> getUserList() {
        return UserList;
    }

}
