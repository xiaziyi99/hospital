/*
Navicat MySQL Data Transfer

Source Server         : his
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : his_medicine

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2020-04-13 21:58:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for his_medicine
-- ----------------------------
DROP TABLE IF EXISTS `his_medicine`;
CREATE TABLE `his_medicine` (
  `id` bigint(11) unsigned NOT NULL AUTO_INCREMENT,
  `type_id` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '药品编码',
  `barcode` varchar(255) DEFAULT NULL COMMENT '条码',
  `name` varchar(255) DEFAULT NULL,
  `spec` varchar(255) DEFAULT NULL,
  `stock` varchar(255) DEFAULT NULL,
  `otc` varchar(255) DEFAULT NULL COMMENT '是否otc药品',
  `cost_price` int(10) DEFAULT NULL COMMENT '成本价',
  `sale_price` int(10) DEFAULT NULL COMMENT '销售价',
  `factory` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of his_medicine
-- ----------------------------
INSERT INTO `his_medicine` VALUES ('1', '1', '100001', '6907992199272', '复方氯化钠注射液', '6g*11袋/盒', '100', '是', '300', '400', '上海医药（集团）有限公司');
INSERT INTO `his_medicine` VALUES ('2', '1', '100002', '6907992112098', '替硝唑氯化钠注射液', '\r\n6g*11袋/盒', '200', null, '100', '200', '山东罗欣药业股份有限公司');
INSERT INTO `his_medicine` VALUES ('3', '1', '100003', '6907992135133', '0.9%氯化钠注射液', '\r\n6g*12袋/盒', '122', null, '500', '900', '昆明制药集团');
INSERT INTO `his_medicine` VALUES ('4', '1', '100004', '6907992147212', '克林霉素磷酸酯注射液', '\r\n6g*13袋/盒', '20', null, '500', '500', '武汉五景药业');
INSERT INTO `his_medicine` VALUES ('5', '1', '100005', '6907992185245', '生脉注射液', '6g*14袋/盒', '55', null, '400', '500', '上海医药（集团）有限公司');

-- ----------------------------
-- Table structure for his_medicine_type
-- ----------------------------
DROP TABLE IF EXISTS `his_medicine_type`;
CREATE TABLE `his_medicine_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of his_medicine_type
-- ----------------------------
INSERT INTO `his_medicine_type` VALUES ('1', '注射类');
INSERT INTO `his_medicine_type` VALUES ('2', '消炎类');
INSERT INTO `his_medicine_type` VALUES ('3', '西药');
INSERT INTO `his_medicine_type` VALUES ('4', '中药');
INSERT INTO `his_medicine_type` VALUES ('5', '中成药');
