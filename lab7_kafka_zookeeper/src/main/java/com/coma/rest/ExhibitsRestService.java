package com.coma.rest;

import com.coma.db.model.Record;
import com.coma.eda.producer.Sender;
import com.coma.service.ExhibitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

import org.springframework.security.core.annotation.AuthenticationPrincipal;

@RestController
@RequestMapping("/public/rest/exhibits")
public class ExhibitsRestService {
    @Autowired
    private Sender sender;

    @Autowired
    private ExhibitService exhibitService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> browse() {
        return ResponseEntity.ok(exhibitService.listAll());
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id, @AuthenticationPrincipal Principal principal) {

        if (principal == null) {
            throw new ForbiddenException();
        }

        exhibitService.delete(id);
    }

    @RequestMapping(value = "/mockdelete/{id}", method = RequestMethod.GET)
    public void mockdelete(@PathVariable("id") Integer id, @AuthenticationPrincipal Principal principal) {
        if (principal == null) {
            throw new ForbiddenException();
        }

        exhibitService.delete(id);
    }

    @RequestMapping(value = "/add/", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> add(@RequestBody Record record,
                                      @AuthenticationPrincipal Principal principal) {
        if (principal == null) {
            throw new ForbiddenException();
        }

        sender.send("helloworld", "SAMPLE");

        return ResponseEntity.ok(exhibitService.add(record));
    }
}
