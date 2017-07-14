package com.controller;

import com.service.PeriodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by sa on 2017-06-18.
 */
@Controller
@RequestMapping(value = "/period")
public class PeriodController {


    @Autowired
    private PeriodService periodService;




}
