package f_samp.spring.controller;

import f_samp.database.dao.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PositionController {
    @Autowired
    PositionRepository PositionDB;

    @RequestMapping(value="/position", method= RequestMethod.GET)
    public ModelAndView position(){
        ModelAndView mav=new ModelAndView("position");
        mav.addObject("position",PositionDB.findAll());
        return mav;


    }
}
