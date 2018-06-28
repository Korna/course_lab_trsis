package info.stepanoff.trsis.samples.service.myService;

import info.stepanoff.trsis.samples.db.model.myModel.Record;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Sonad on 12.09.17.
 */
public class RecordsListService {

    private static List<Record> literatureList = new ArrayList<Record>();
    public RecordsListService(){
        addRecord( "User01", "Client01", "1", "222", "14.10.2017");
        addRecord( "User02", "Client01", "100", "222", "14.10.2017");
        addRecord( "Admin", "Client04", "100", "222", "15.10.2017");
        addRecord( "Admin", "Client02", "1000", "222", "16.10.2017");
    }


    public Record addRecord(final String author, final String client, final String mcv, final String rdw, final String date) {
        String id = String.valueOf(literatureList.size() + 1);

        Record record = new Record(id,author, client, mcv, rdw, date);
        literatureList.add(record);
        return record;
    }

    public boolean deleteRecord(final String id) {
        Iterator<Record> iterator = literatureList.iterator();
        while (iterator.hasNext()) {
            Record currentRecord = iterator.next();

            if (currentRecord.getId().toLowerCase().equals(id.toLowerCase())) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    public List<Record> searchRecord(final String client) {
        List<Record> result = new LinkedList<>();
        if (client == null)
            return result;

        for (Record record : literatureList) {
            if (record.getClient().toLowerCase().equals(client.toLowerCase()))
                result.add(record);
        }
        return result;
    }

    public List<Record> getLiteratureList() {
        return literatureList;
    }
}
