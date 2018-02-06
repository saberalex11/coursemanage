package com.ly.controller.infoManage;

import com.ly.service.CustomerService;
import com.ly.service.SalesManService;
import com.ly.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salesMan")
public class SalesManController {

    @Autowired
    private SalesManService salesManService;

    @RequestMapping("querySalesMan")
    public R querySalesMan(String chineseName, Integer page, Integer limit){
        return salesManService.querySalesMan(chineseName,page,limit);
    }
}
