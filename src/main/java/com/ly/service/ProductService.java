package com.ly.service;

import com.ly.bean.Product;
import com.ly.utils.R;

import java.util.List;

public interface ProductService extends BasicService<Product> {
    R queryProduct(String prodcutName, Integer page, Integer limit);
}
