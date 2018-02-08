/*
Navicat MySQL Data Transfer

Source Server         : localhost@root
Source Server Version : 50715
Source Host           : localhost:3306
Source Database       : ly

Target Server Type    : MYSQL
Target Server Version : 50715
File Encoding         : 65001

Date: 2018-02-08 15:46:17
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for customer
-- ----------------------------
DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `customer_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `customer_simple_name` varchar(100) DEFAULT NULL COMMENT '客户公司简称',
  `customer_name` varchar(100) DEFAULT NULL COMMENT '客户公司全称',
  `owner` varchar(100) DEFAULT NULL COMMENT '负责人',
  `title` varchar(100) DEFAULT NULL COMMENT '负责人',
  `telephone` varchar(100) DEFAULT NULL COMMENT '电话',
  `mobile_phone` varchar(100) DEFAULT NULL COMMENT '移动电话',
  `fax` varchar(100) DEFAULT NULL COMMENT '传真',
  `saleman_id` varchar(100) DEFAULT NULL COMMENT '销售员编号',
  `customer_adress` varchar(100) DEFAULT NULL COMMENT '客户地址',
  `delivery_adress` varchar(100) DEFAULT NULL COMMENT '客户送货地址',
  `invoice_adress` varchar(100) DEFAULT NULL COMMENT '开票地址',
  `last_deluvery_date` datetime DEFAULT NULL COMMENT '最后送货日期',
  PRIMARY KEY (`customer_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer
-- ----------------------------
INSERT INTO `customer` VALUES ('1', '客户1', '客户1', '123', '123', '123', '123', '123', '123', '123', '123', '123', '2018-02-17 00:00:00');
INSERT INTO `customer` VALUES ('2', '客户2', '客户2', '21', '22', '2', '2', '2', '2', '2', '2', '2', '2018-02-10 00:00:00');

-- ----------------------------
-- Table structure for customer_contact_man
-- ----------------------------
DROP TABLE IF EXISTS `customer_contact_man`;
CREATE TABLE `customer_contact_man` (
  `contact_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `chinese_name` varchar(100) DEFAULT NULL COMMENT '中文名称',
  `english_name` varchar(100) DEFAULT NULL COMMENT '英文名称',
  `title` varchar(100) DEFAULT NULL COMMENT '联络人称谓',
  `telephone` varchar(100) DEFAULT NULL COMMENT '电话',
  `mobile_phone` varchar(100) DEFAULT NULL COMMENT '移动电话',
  `customer_id` int(8) DEFAULT NULL COMMENT '客户编号',
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of customer_contact_man
-- ----------------------------
INSERT INTO `customer_contact_man` VALUES ('1', '123', '123', '123', '123', '123', '1');
INSERT INTO `customer_contact_man` VALUES ('2', '22', '22', '123', '22', '2222', '1');

-- ----------------------------
-- Table structure for delivery_detail
-- ----------------------------
DROP TABLE IF EXISTS `delivery_detail`;
CREATE TABLE `delivery_detail` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '序列',
  `delivery_id` int(8) NOT NULL COMMENT '销售单单号',
  `product_id` varchar(100) DEFAULT NULL COMMENT '产品编号',
  `sales_quantity` varchar(100) DEFAULT NULL COMMENT '销售数量',
  `sales_unit_price` double DEFAULT NULL COMMENT '单价(元)',
  `sales_amount` double DEFAULT NULL COMMENT '金额(元)',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery_detail
-- ----------------------------
INSERT INTO `delivery_detail` VALUES ('7', '5', '3', '2', '2', '4');
INSERT INTO `delivery_detail` VALUES ('8', '5', '4', '2', '2', '4');
INSERT INTO `delivery_detail` VALUES ('9', '6', '3', '2', '2', '4');
INSERT INTO `delivery_detail` VALUES ('10', '6', '4', '2', '2', '4');

-- ----------------------------
-- Table structure for delivery_master
-- ----------------------------
DROP TABLE IF EXISTS `delivery_master`;
CREATE TABLE `delivery_master` (
  `delivery_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '销售单单号',
  `delivery_property` varchar(100) DEFAULT NULL COMMENT '销售1，销售退货－1',
  `delivery_date` datetime DEFAULT NULL COMMENT '销售日期/退货日期',
  `customer_id` int(8) DEFAULT NULL COMMENT '客户编号',
  `sale_man_id` int(8) DEFAULT NULL COMMENT '销售员工编号',
  `delivery_address` varchar(100) DEFAULT NULL COMMENT '送货地址',
  `amount` double(10,0) DEFAULT NULL,
  PRIMARY KEY (`delivery_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of delivery_master
-- ----------------------------
INSERT INTO `delivery_master` VALUES ('5', '1', '2018-02-10 00:00:00', '2', '2', '撒打算', '8');
INSERT INTO `delivery_master` VALUES ('6', '-1', '2018-02-17 00:00:00', '1', '1', '234234三顿饭', '8');

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) DEFAULT NULL,
  `quantity` int(11) unsigned zerofill DEFAULT NULL,
  `safe_stock` int(11) DEFAULT NULL,
  `suggest_buy_price` double DEFAULT NULL,
  `suggest_sale_price` double DEFAULT NULL,
  `last_purchase_date` datetime DEFAULT NULL,
  `last_delivery_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('3', '测试', '00000000132', '3333', '3333.333', '33.333', '2018-02-08 00:00:00', '2018-02-17 00:00:00');
INSERT INTO `product` VALUES ('4', '2222', '00000000119', '2222', '222', '22222', '2018-02-08 00:00:00', '2018-02-17 00:00:00');

-- ----------------------------
-- Table structure for purchase_detail
-- ----------------------------
DROP TABLE IF EXISTS `purchase_detail`;
CREATE TABLE `purchase_detail` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `product_id` int(11) DEFAULT NULL,
  `purchase_amount` double DEFAULT NULL,
  `purchase_id` int(11) DEFAULT NULL,
  `purchase_quantity` int(11) DEFAULT NULL,
  `purchase_unit_price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchase_detail
-- ----------------------------
INSERT INTO `purchase_detail` VALUES ('1', '3', '4', '1', '2', '2');
INSERT INTO `purchase_detail` VALUES ('2', '3', '9.9', '1', '3', '3.3');
INSERT INTO `purchase_detail` VALUES ('3', '3', '9', '1', '3', '3');
INSERT INTO `purchase_detail` VALUES ('4', '3', '4.4', '1', '2', '2.2');
INSERT INTO `purchase_detail` VALUES ('5', '3', '4', '1', '2', '2');
INSERT INTO `purchase_detail` VALUES ('6', '3', '4', '1', '2', '2');
INSERT INTO `purchase_detail` VALUES ('7', '3', '4', '5', '2', '2');
INSERT INTO `purchase_detail` VALUES ('8', '3', '4', '6', '2', '2');
INSERT INTO `purchase_detail` VALUES ('9', '3', '4', '7', '2', '2');
INSERT INTO `purchase_detail` VALUES ('10', '3', '4', '8', '2', '2');
INSERT INTO `purchase_detail` VALUES ('11', '3', '4', '9', '2', '2');
INSERT INTO `purchase_detail` VALUES ('12', '3', '9', '10', '3', '3');
INSERT INTO `purchase_detail` VALUES ('13', '4', '16', '10', '4', '4');

-- ----------------------------
-- Table structure for purchase_master
-- ----------------------------
DROP TABLE IF EXISTS `purchase_master`;
CREATE TABLE `purchase_master` (
  `purchase_id` int(11) NOT NULL AUTO_INCREMENT,
  `purchase_date` datetime DEFAULT NULL,
  `purchase_property` int(11) DEFAULT NULL,
  `supplier_id` int(11) DEFAULT NULL,
  `amount` double(10,0) DEFAULT NULL,
  PRIMARY KEY (`purchase_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of purchase_master
-- ----------------------------
INSERT INTO `purchase_master` VALUES ('1', '2018-02-07 00:00:00', '1', '1', '14');
INSERT INTO `purchase_master` VALUES ('2', '2018-02-06 00:00:00', '1', '1', '13');
INSERT INTO `purchase_master` VALUES ('3', '2018-02-08 00:00:00', '1', '1', '4');
INSERT INTO `purchase_master` VALUES ('4', '2018-02-05 00:00:00', '1', '1', '4');
INSERT INTO `purchase_master` VALUES ('5', '2018-02-22 00:00:00', '1', '1', '4');
INSERT INTO `purchase_master` VALUES ('6', '2018-02-08 00:00:00', '1', '1', '4');
INSERT INTO `purchase_master` VALUES ('7', '2018-02-08 00:00:00', '-1', '1', '4');
INSERT INTO `purchase_master` VALUES ('8', '2018-02-08 00:00:00', '-1', '1', '4');
INSERT INTO `purchase_master` VALUES ('9', '2018-02-08 00:00:00', '-1', '1', '4');
INSERT INTO `purchase_master` VALUES ('10', '2018-02-08 00:00:00', '-1', '1', '25');

-- ----------------------------
-- Table structure for sales_man
-- ----------------------------
DROP TABLE IF EXISTS `sales_man`;
CREATE TABLE `sales_man` (
  `sales_man_id` int(11) NOT NULL AUTO_INCREMENT,
  `chinese_name` varchar(255) DEFAULT NULL,
  `contact_address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `english_name` varchar(255) DEFAULT NULL,
  `mobile_phone` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`sales_man_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sales_man
-- ----------------------------
INSERT INTO `sales_man` VALUES ('1', '销售员1', '2', '123', '123', '123', '123');
INSERT INTO `sales_man` VALUES ('2', '销售员2', '33', '33', '33', '33', '33');

-- ----------------------------
-- Table structure for supplier
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `supplier_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `supplier_simple_name` varchar(100) DEFAULT NULL COMMENT '供应商简称',
  `supplier_name` varchar(100) DEFAULT NULL COMMENT '供应商全称',
  `owner` varchar(100) DEFAULT NULL COMMENT '负责人',
  `title` varchar(100) DEFAULT NULL COMMENT '负责人',
  `telephone` varchar(100) DEFAULT NULL COMMENT '电话',
  `mobile_phone` varchar(100) DEFAULT NULL COMMENT '移动电话',
  `fax` varchar(100) DEFAULT NULL COMMENT '传真',
  `company_address` varchar(100) DEFAULT NULL COMMENT '公司地址',
  `factory_address` varchar(100) DEFAULT NULL COMMENT '工厂地址',
  `last_purchase_date` datetime DEFAULT NULL COMMENT '最后进货日期',
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', '供货商简称', '供货商全程', '负责人', '称谓', '15928962630', '15928962630', null, '123', '123', '2018-02-06 21:15:51');
INSERT INTO `supplier` VALUES ('2', '供货商简称2', '供货商简称2', '1', '1', '11', '11', null, '111', '111', null);

-- ----------------------------
-- Table structure for supplier_contact_man
-- ----------------------------
DROP TABLE IF EXISTS `supplier_contact_man`;
CREATE TABLE `supplier_contact_man` (
  `contact_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `chinese_name` varchar(100) DEFAULT NULL COMMENT '中文名称',
  `english_name` varchar(100) DEFAULT NULL COMMENT '英文名称',
  `title` varchar(100) DEFAULT NULL COMMENT '联络人称谓',
  `telephone` varchar(100) DEFAULT NULL COMMENT '电话',
  `mobile_phone` varchar(100) DEFAULT NULL COMMENT '移动电话',
  `supplier_id` int(8) DEFAULT NULL COMMENT '供应商编号',
  PRIMARY KEY (`contact_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier_contact_man
-- ----------------------------
INSERT INTO `supplier_contact_man` VALUES ('1', 'me', 'me', 'me', '15928962630', '15928962630', '1');
INSERT INTO `supplier_contact_man` VALUES ('2', 'me2', 'me2', 'me2', '15928962630', '15928962630', '1');

-- ----------------------------
-- Table structure for tbl_sys_menu
-- ----------------------------
DROP TABLE IF EXISTS `tbl_sys_menu`;
CREATE TABLE `tbl_sys_menu` (
  `menu_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `parent_id` bigint(20) DEFAULT NULL COMMENT '父菜单ID，一级菜单为0',
  `name` varchar(50) DEFAULT NULL COMMENT '菜单名称',
  `url` varchar(200) DEFAULT NULL COMMENT '菜单URL',
  `perms` varchar(500) DEFAULT NULL COMMENT '授权(多个用逗号分隔，如：user:list,user:create)',
  `type` int(11) DEFAULT NULL COMMENT '类型  1：菜单   2：按钮',
  `icon` varchar(50) DEFAULT NULL COMMENT '菜单图标',
  `order_num` int(11) DEFAULT NULL COMMENT '排序',
  `level` int(11) DEFAULT '-1' COMMENT '菜单的级别 1 一级菜单 2 二级菜单 3 三级菜单 按钮暂时定为-1',
  `status` tinyint(2) DEFAULT '1' COMMENT ' 0 删除 1正常',
  PRIMARY KEY (`menu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10039 DEFAULT CHARSET=utf8 COMMENT='菜单管理';

-- ----------------------------
-- Records of tbl_sys_menu
-- ----------------------------
INSERT INTO `tbl_sys_menu` VALUES ('10024', '0', '资料维护', null, null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10025', '10024', '商品资料管理', 'infoManage/productManage.jsp', null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10026', '10024', '供应商资料管理', 'infoManage/supplierManage.jsp', null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10027', '0', '采购管理', null, null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10028', '0', '销售管理', null, null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10029', '0', '库存管理', null, null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10030', '0', '报表导出', null, null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10031', '10024', '客户资料管理', 'infoManage/cutomerManage.jsp', null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10032', '10024', '员工资料管理', 'infoManage/salesManManage.jsp', null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10033', '10027', '采购入库', 'pruchaseManage/addPurchase.jsp', null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10034', '10027', '采购出库', 'pruchaseManage/reducePurchase.jsp', null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10035', '10028', '商品销售', 'salesManage/addSales.jsp', null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10036', '10028', '商品退货', 'salesManage/backSales.jsp', null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10037', '10029', '查询库存', 'stockManage/queryStock.jsp', null, '1', null, '0', '1', '1');
INSERT INTO `tbl_sys_menu` VALUES ('10038', '10030', '报表导出', 'reportManage/exportReport.jsp', null, '1', null, '0', '1', '1');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `user_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_account` varchar(100) DEFAULT NULL COMMENT '账号',
  `password` varchar(100) DEFAULT NULL COMMENT '密码',
  `is_use` int(8) DEFAULT NULL COMMENT '正常1，禁用－1',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10005 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES ('10001', '123', '123', '1');
INSERT INTO `user_info` VALUES ('10002', '222', '9b871512327c09ce91dd649b3f96a63b7408ef267c8cc5710114e629730cb61f', '1');
INSERT INTO `user_info` VALUES ('10003', '2132', 'a665a45920422f9d417e4867efdc4fb8a04a1f3fff1fa07e998e86f7f7a27ae3', '1');
INSERT INTO `user_info` VALUES ('10004', '111', '8d969eef6ecad3c29a3a629280e686cf0c3f5d5a86aff3ca12020c923adc6c92', '1');
