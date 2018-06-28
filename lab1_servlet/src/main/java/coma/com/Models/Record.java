package coma.com.Models;

public class Record {
    String addedByUser;
    String client;
    String MCV;
    String RDW;
    String date;

    public Record(String addedByUser, String client, String MCV, String RDW, String date) {
        this.addedByUser = addedByUser;
        this.client = client;
        this.MCV = MCV;
        this.RDW = RDW;
        this.date = date;
    }

    public String getAddedByUser() {
        return addedByUser;
    }

    public void setAddedByUser(String addedByUser) {
        this.addedByUser = addedByUser;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getMCV() {
        return MCV;
    }

    public void setMCV(String MCV) {
        this.MCV = MCV;
    }

    public String getRDW() {
        return RDW;
    }

    public void setRDW(String RDW) {
        this.RDW = RDW;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
