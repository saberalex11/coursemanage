package com.ly.service;

import com.ly.mapper.ExportMapper;
import com.ly.service.vo.DeliveryDetailExport;
import com.ly.service.vo.DeliveryMasterExport;
import com.ly.service.vo.PurchaseDetailExport;
import com.ly.service.vo.PurchaseMasterExport;
import org.apache.poi.hssf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ExportServiceImpl implements ExportService {

    @Autowired
    private ExportMapper exportMapper;

    @Override
    public HSSFWorkbook exportPurchase() {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFDataFormat format= wb.createDataFormat();

        HSSFSheet sheet = wb.createSheet("采购主表数据");
        HSSFRow titleRow = sheet.createRow((int) 0);
        HSSFCellStyle timeStyle = wb.createCellStyle();
        timeStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        timeStyle.setDataFormat(format.getFormat("yyyy年m月d日"));

        HSSFCellStyle moneyStyle = wb.createCellStyle();
        moneyStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        moneyStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));

        HSSFCellStyle normalStyle = wb.createCellStyle();
        normalStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        // 处理表头数据
        String[] headList = {"采购单号","采购日期","采购类型","供应商名称","总金额"};
        for (int i = 0; i < headList.length; i++) {
            HSSFCell cell = titleRow.createCell(i);
            cell.setCellValue(headList[i]);
            cell.setCellStyle(normalStyle);
            sheet.autoSizeColumn(i);
        }

        //查询主表数据
        List<PurchaseMasterExport> purchaseMasterExports = exportMapper.purchaseMasterExport();
        for (int i = 0; i < purchaseMasterExports.size(); i++) {
            PurchaseMasterExport purchaseMasterExport = purchaseMasterExports.get(i);
            HSSFRow row = sheet.createRow(i + 1);

            HSSFCell cell0 = row.createCell(0);
            cell0.setCellValue(purchaseMasterExport.getPurchaseId());

            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue(purchaseMasterExport.getPurchaseDate());
            cell1.setCellStyle(timeStyle);

            HSSFCell cell2 = row.createCell(2);
            cell2 .setCellValue(purchaseMasterExport.getPurchaseType());

            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue(purchaseMasterExport.getSupplierSimpleName());

            HSSFCell cell4 = row.createCell(4);
            cell4 .setCellValue(purchaseMasterExport.getAmount());
            cell4.setCellStyle(moneyStyle);
        }


        //明细表
        HSSFSheet sheet2 = wb.createSheet("采购明细表数据");
        HSSFRow titleRow2 = sheet2.createRow((int) 0);

        // 处理表头数据
        String[] headList2 = {"采购单号","商品名称","采购单价","采购数量","总金额"};
        for (int i = 0; i < headList2.length; i++) {
            HSSFCell cell = titleRow2.createCell(i);
            cell.setCellValue(headList2[i]);
            cell.setCellStyle(normalStyle);
            sheet2.autoSizeColumn(i);
        }

        //查询明细表数据
        List<PurchaseDetailExport> purchaseDetailExports = exportMapper.purchaseDetailExport();
        for (int i = 0; i < purchaseDetailExports.size(); i++) {
            PurchaseDetailExport purchaseDetailExport = purchaseDetailExports.get(i);
            HSSFRow row = sheet2.createRow(i + 1);
            HSSFCell cell0 = row.createCell(0);
            cell0.setCellValue(purchaseDetailExport.getPurchaseId());

            HSSFCell cell1 = row.createCell(1);
            cell1 .setCellValue(purchaseDetailExport.getProductName());

            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue(purchaseDetailExport.getPurchaseUnitPrice());
            cell2.setCellStyle(moneyStyle);

            HSSFCell cell3 = row.createCell(3);
            cell3 .setCellValue(purchaseDetailExport.getPurchaseQuantity());

            HSSFCell cell4 = row.createCell(4);
            cell4 .setCellValue(purchaseDetailExport.getPurchaseAmount());
            cell2.setCellStyle(moneyStyle);
        }
        return wb;
    }

    @Override
    public HSSFWorkbook exportDelivery() {
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFDataFormat format= wb.createDataFormat();

        HSSFSheet sheet = wb.createSheet("销售主表数据");
        HSSFRow titleRow = sheet.createRow((int) 0);
        HSSFCellStyle timeStyle = wb.createCellStyle();
        timeStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        timeStyle.setDataFormat(format.getFormat("yyyy年m月d日"));

        HSSFCellStyle moneyStyle = wb.createCellStyle();
        moneyStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        moneyStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("0.00"));

        HSSFCellStyle normalStyle = wb.createCellStyle();
        normalStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);

        // 处理表头数据
        String[] headList = {"销售单号","销售日期","销售类型","客户名称","销售地址","售货员名称","总金额"};
        for (int i = 0; i < headList.length; i++) {
            HSSFCell cell = titleRow.createCell(i);
            cell.setCellValue(headList[i]);
            cell.setCellStyle(normalStyle);
            sheet.autoSizeColumn(i);
        }

        //查询主表数据
        List<DeliveryMasterExport> deliveryMasterExports = exportMapper.deliveryMasterExport();
        for (int i = 0; i < deliveryMasterExports.size(); i++) {
            DeliveryMasterExport deliveryMasterExport = deliveryMasterExports.get(i);
            HSSFRow row = sheet.createRow(i + 1);

            HSSFCell cell0 = row.createCell(0);
            cell0.setCellValue(deliveryMasterExport.getDeliveryId());

            HSSFCell cell1 = row.createCell(1);
            cell1.setCellValue(deliveryMasterExport.getDeliveryDate());
            cell1.setCellStyle(timeStyle);

            HSSFCell cell2 = row.createCell(2);
            cell2 .setCellValue(deliveryMasterExport.getDeliveryType());

            HSSFCell cell3 = row.createCell(3);
            cell3.setCellValue(deliveryMasterExport.getCustomerSimpleName());

            HSSFCell cell4 = row.createCell(4);
            cell4 .setCellValue(deliveryMasterExport.getDeliveryAddress());

            HSSFCell cell5 = row.createCell(5);
            cell5.setCellValue(deliveryMasterExport.getChineseName());

            HSSFCell cell6 = row.createCell(6);
            cell6 .setCellValue(deliveryMasterExport.getAmount());
            cell6.setCellStyle(moneyStyle);
        }


        //明细表
        HSSFSheet sheet2 = wb.createSheet("采购明细表数据");
        HSSFRow titleRow2 = sheet2.createRow((int) 0);

        // 处理表头数据
        String[] headList2 = {"销售单号","商品名称","销售单价","销售数量","总金额"};
        for (int i = 0; i < headList2.length; i++) {
            HSSFCell cell = titleRow2.createCell(i);
            cell.setCellValue(headList2[i]);
            cell.setCellStyle(normalStyle);
            sheet2.autoSizeColumn(i);
        }

        //查询明细表数据
        List<DeliveryDetailExport> deliveryDetailExports = exportMapper.deliveryDetailExport();
        for (int i = 0; i < deliveryDetailExports.size(); i++) {
            DeliveryDetailExport deliveryDetailExport = deliveryDetailExports.get(i);
            HSSFRow row = sheet2.createRow(i + 1);
            HSSFCell cell0 = row.createCell(0);
            cell0.setCellValue(deliveryDetailExport.getDeliveryId());

            HSSFCell cell1 = row.createCell(1);
            cell1 .setCellValue(deliveryDetailExport.getProductName());

            HSSFCell cell2 = row.createCell(2);
            cell2.setCellValue(deliveryDetailExport.getSalesUnitPrice());
            cell2.setCellStyle(moneyStyle);

            HSSFCell cell3 = row.createCell(3);
            cell3 .setCellValue(deliveryDetailExport.getSalesQuantity());

            HSSFCell cell4 = row.createCell(4);
            cell4 .setCellValue(deliveryDetailExport.getSalesAmount());
            cell2.setCellStyle(moneyStyle);
        }
        return wb;
    }
}
