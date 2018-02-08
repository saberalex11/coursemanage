package com.ly.service;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public interface ExportService {
    HSSFWorkbook exportPurchase();
    HSSFWorkbook exportDelivery();
}
