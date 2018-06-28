package f_samp.listservice;

public class MyUser {

    private Long id;

    private String login;

    private String hash;

    public MyUser(String login, String hash) {
        this.login = login;
        this.hash = hash;
        this.id= Long.valueOf(1);
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }





}
