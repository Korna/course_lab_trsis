package spring.rest;

import listservice.RecordsListService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sonad on 19.09.17.
 */
@RestController
@RequestMapping("/rest/sample")
public class SampleRestService {

    private RecordsListService literatureList = new RecordsListService();

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> loadPage() {
        return ResponseEntity.ok(literatureList.getLiteratureList());
    }

    @RequestMapping(value= "/add/{recordAuthor}/{recordClient}/{recordMcv}/{recordRdw}/{recordDate}",method = RequestMethod.POST)
    public ResponseEntity<Object> addRecord(
                                          @PathVariable("recordAuthor") String author,
                                          @PathVariable("recordClient") String client,
                                          @PathVariable("recordMcv") String Mcv,
                                          @PathVariable("recordRdw") String Rdw,
                                          @PathVariable("recordDate") String date
    )
    {
        if (client.equals("undefined") || author.equals("undefined") || Mcv.equals("undefined")
                || Rdw.equals("undefined") || date.equals("undefined")
                )
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\" : \"Invalid input parameters\"}");
        return ResponseEntity.status(HttpStatus.CREATED).body(literatureList.addRecord(author, client, Mcv, Rdw, date));
    }

    @RequestMapping(value = "/delete/{recordId}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteRecord(@PathVariable("recordId") String id) {
        if (id.equals("undefined"))
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"message\" : \"Invalid id\"}");
        if (literatureList.deleteRecord(id))
            return ResponseEntity.ok("");
        else
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body("{\"message\" : \"Record not found\"}");
    }

}
