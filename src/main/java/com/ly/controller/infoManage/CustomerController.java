package com.ly.controller.infoManage;


import com.ly.bean.Customer;
import com.ly.bean.CustomerContactMan;
import com.ly.bean.SupplierContactMan;
import com.ly.service.CustomerContactManService;
import com.ly.service.CustomerService;
import com.ly.service.SupplierContactManService;
import com.ly.service.SupplierService;
import com.ly.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerContactManService customerContactManService;

    @RequestMapping("queryCustomer")
    public R queryCustomer(String customerSimpleName, Integer page, Integer limit){
        return customerService.queryCustomer(customerSimpleName,page,limit);
    }

    @RequestMapping("queryCustomerContactById")
    public R queryCustomerContactById(CustomerContactMan customer){
        List<CustomerContactMan> infos = customerContactManService.queryByExample(customer);
        return R.ok().put("data",infos);
    }
    @RequestMapping("queryAllCustomer")
    public List<Customer> queryAllCustomer(){
        return customerService.queryAll(null);
    }

}
