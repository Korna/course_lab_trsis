package info.stepanoff.trsis.samples.rest.myRest;


import info.stepanoff.trsis.samples.db.model.myModel.Record;
import info.stepanoff.trsis.samples.service.myService.RecordsListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Sonad on 19.09.17.
 */
@RestController
@RequestMapping("/rest/search")
public class SearchRestService {
    private RecordsListService literatureList = new RecordsListService();

    @RequestMapping(value = "/{recordClient}", method = RequestMethod.POST)
    public ResponseEntity<Object> searchBook(@PathVariable("recordClient") String client) {
        if (client.equals("undefined"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\" : \"Invalid client name\"}");
        List<Record> searchResult = literatureList.searchRecord(client);
        if (searchResult.isEmpty())
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\" : \"Client not found\"}");

        else
            return ResponseEntity.ok(searchResult);
    }

}
