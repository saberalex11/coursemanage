package com.ly.mapper;

import com.ly.service.vo.DeliveryDetailExport;
import com.ly.service.vo.DeliveryMasterExport;
import com.ly.service.vo.PurchaseDetailExport;
import com.ly.service.vo.PurchaseMasterExport;

import java.util.List;

public interface ExportMapper {

    List<DeliveryMasterExport> deliveryMasterExport();

    List<DeliveryDetailExport> deliveryDetailExport();

    List<PurchaseMasterExport> purchaseMasterExport();

    List<PurchaseDetailExport> purchaseDetailExport();
}
