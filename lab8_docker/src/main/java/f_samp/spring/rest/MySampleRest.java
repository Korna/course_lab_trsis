package f_samp.spring.rest;


import f_samp.database.dao.PersonRepository;
import f_samp.database.model.Persons;
import f_samp.database.dao.PositionRepository;
import f_samp.database.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import org.springframework.context.annotation.ComponentScan;
import f_samp.database.dao.PersonRepository;


import java.security.Principal;
import java.util.Collection;
import java.util.List;

/**
 * Created by Sonad on 19.09.17.
 */
@RestController
@RequestMapping("/rest/Persons")
//@ComponentScan(basePackages = "f_samp.database.dao")
public class MySampleRest {

    @Autowired
    private PersonRepository myPersonList;
    @Autowired
    private PositionRepository myPositionList;


    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> loadPage( @AuthenticationPrincipal Principal principal) {
       List<Persons> list = (List<Persons>)myPersonList.findAll();

        return new ResponseEntity<Object>(list, HttpStatus.OK);
    }



    @RequestMapping(value = "/add/{Name}/{Surname}/{Patronymic}/{Passport}/{Position}/{Tolerance_level}", method = RequestMethod.POST)
    public ResponseEntity<Object> addPerson(@PathVariable("Name") String name,
                                            @PathVariable("Surname") String surname,
                                            @PathVariable("Patronymic") String patronymic,
                                            @PathVariable("Passport") String passport,
                                            @PathVariable("Position") String position,
                                            @PathVariable("Tolerance_level") String tolerance_level,
                                            @AuthenticationPrincipal Principal principal) {

        if (principal == null) {
            throw new ForbiddenException();
        }

       Position newPos=myPositionList.save(new Position(position, tolerance_level));
        return ResponseEntity.ok(myPersonList.save(new Persons(surname, name, patronymic, passport, newPos)));//, position, tolerance_level


    }

    @RequestMapping(value = "/delete/{Passport}", method = RequestMethod.DELETE)
    public  void deletePerson(@PathVariable("Passport") String passport, @AuthenticationPrincipal Principal principal) {

       myPersonList.deleteByPassport(passport);


    }


        @RequestMapping(value = "/position", method = RequestMethod.GET)
        public ResponseEntity<Object> searchPerson() {
            Collection<Position> searchResult =(Collection<Position>)myPositionList.findAll();
            return ResponseEntity.ok(searchResult);
        }




}