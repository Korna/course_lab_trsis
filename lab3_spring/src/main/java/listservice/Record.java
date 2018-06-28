package listservice;

public class Record {

    String id = "";
    String author;
    String client;
    String Mcv;
    String RDW;
    String date;

    public Record(String id, String addedByUser, String client, String MCV, String RDW, String date) {
        this.id = id;
        this.author = addedByUser;
        this.client = client;
        this.Mcv = MCV;
        this.RDW = RDW;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public String getMcv() {
        return Mcv;
    }

    public void setMcv(String mcv) {
        this.Mcv = mcv;
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
