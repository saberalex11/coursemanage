package com.ly.service;

import com.ly.bean.Supplier;
import com.ly.utils.R;

public interface SupplierService extends BasicService<Supplier> {
    R querySupplier(String supplierSimpleName, Integer page, Integer limit);
}
