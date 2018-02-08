package com.ly.controller.reportManage;

import com.ly.service.ExportService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;

@Controller
@RequestMapping("export")
public class ExportController {
    
    @Autowired
    private ExportService exportService;
    
    @RequestMapping("exportPurchase")
    public void exportPurchase(HttpServletResponse response)throws Exception{
        HSSFWorkbook wb = exportService.exportPurchase();
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=purchase-export.xls");
        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();exportService.exportPurchase();
    }

    @RequestMapping("deliveryExport")
    public void deliveryExport(HttpServletResponse response)throws Exception{
        HSSFWorkbook wb = exportService.exportPurchase();
        response.setContentType("application/vnd.ms-excel;charset=UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=delivery-export.xls");
        OutputStream ouputStream = response.getOutputStream();
        wb.write(ouputStream);
        ouputStream.flush();
        ouputStream.close();exportService.exportDelivery();
    }
}
