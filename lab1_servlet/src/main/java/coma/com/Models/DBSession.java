package coma.com.Models;

import java.util.ArrayList;

public class DBSession {
    private static DBSession instance = new DBSession();

    public static DBSession getInstance() {
        return instance;
    }

    private DBSession() {
    }

    public ArrayList<Record> list = new ArrayList<Record>();
    private String userId;

    public void setUserId(String userId){
        this.userId = userId;
    }

    public ArrayList<Record> getList() {
        return list;
    }

    public void setList(ArrayList<Record> list) {
        this.list = list;
    }

    public String getUserId() {
        return userId;
    }
}
