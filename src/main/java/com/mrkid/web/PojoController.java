package com.mrkid.web;

import com.mrkid.entity.Pojo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.mrkid.service.PojoService;

import javax.validation.Valid;

/**
 * User: xudong
 * Date: 12/2/14
 * Time: 3:34 PM
 */
@Controller
public class PojoController {

    @Autowired
    private PojoService pojoService;

    @RequestMapping(value = "/pojo", method = RequestMethod.POST)
    @ResponseBody
    public RestResponse newPojo(@Valid Pojo pojo) {
        pojoService.save(pojo);
        System.out.println(pojo);
        return new RestResponse();
    }


    @RequestMapping(value = "/pojo/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public RestResponse updatePojo(@PathVariable("id") Long id, @RequestBody Pojo pojo) {
        pojo.setId(id);

        pojoService.save(pojo);
        return new RestResponse();
    }


    @RequestMapping(value = "/pojo/{id}", method = RequestMethod.GET)
    @ResponseBody
    public RestResponse get(@PathVariable("id") Long id) {
        Pojo pojo = pojoService.get(id);

        final RestResponse restResponse = new RestResponse();
        if (pojo != null) {
            restResponse.setObj(pojo);
        } else {
            restResponse.setCode(1);
        }

        return restResponse;
    }
}
