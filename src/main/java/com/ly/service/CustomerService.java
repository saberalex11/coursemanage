package com.ly.service;

import com.ly.bean.Customer;
import com.ly.utils.R;

import java.util.List;

public interface CustomerService extends BasicService<Customer> {

    R queryCustomer(String customerSimpleName, Integer page, Integer limit);
}
