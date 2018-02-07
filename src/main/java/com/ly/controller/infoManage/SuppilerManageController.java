package com.ly.controller.infoManage;

import com.ly.bean.Customer;
import com.ly.bean.CustomerContactMan;
import com.ly.bean.Supplier;
import com.ly.bean.SupplierContactMan;
import com.ly.service.*;
import com.ly.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/suppiler")
public class SuppilerManageController {

    @Autowired
    private SupplierService supplierService;

    @Autowired
    private SupplierContactManService supplierContactManService;

    @RequestMapping("querySupplier")
    public R querySupplier(String supplierSimpleName, Integer page, Integer limit){
        return supplierService.querySupplier(supplierSimpleName,page,limit);
    }

    @RequestMapping("querySupplierContactById")
    public R querySupplierContactById(SupplierContactMan supplierContactMan){
        List<SupplierContactMan> supplierContactMEN = supplierContactManService.queryByExample(supplierContactMan);
        return R.ok().put("data",supplierContactMEN);
    }

    @RequestMapping("queryAllSupplier")
    public R queryAllSupplier(){
        List<Supplier> suppliers = supplierService.queryAll(null);
        return R.ok().put("data",suppliers);
    }
}
