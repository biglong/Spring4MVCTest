package com.hsl.test.controller;

import com.hsl.test.model.Spittle;
import com.hsl.test.repository.SpittleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by huangshaolong on 2017/8/30.
 *
 */
@Controller
@RequestMapping({"/spittles"})
public class SpittleController {

    private final static String MAX_LONG_AS_STRING = "9223372036854775807";
    private SpittleRepository repository;

    @Autowired
    public SpittleController(SpittleRepository repository) {
        this.repository = repository;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max
            , @RequestParam(value = "count", defaultValue = "20") int count) {
        return repository.findSpittles(max, count);
    }

    @RequestMapping(value = "/show",method = RequestMethod.GET)
    public String showSpittle(
            @RequestParam(value = "spittle_id") long spittleId
            , Model model
    ) {
        model.addAttribute(repository.findOne(spittleId));
        return "spittle";
    }


    @RequestMapping(value = "/{spittleId}",method = RequestMethod.GET)
    public String spittle(@PathVariable long spittleId,Model model){
        model.addAttribute(repository.findOne(spittleId));
        return "spittle";
    }

    public static void main(String[] args) {
        System.out.println(Long.toString(Long.MAX_VALUE));
    }
}
