package com.example.mvc_unit_test.controller;

import com.example.mvc_unit_test.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Properties;

@Controller
@Slf4j
public class UtilsController {

    @RequestMapping(value = "/properties")
    @ResponseBody
    public Properties getProperties() {
        return Utils.getProperties();
    }


}
