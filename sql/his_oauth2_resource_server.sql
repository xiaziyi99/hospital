/*
Navicat MySQL Data Transfer

Source Server         : his
Source Server Version : 50716
Source Host           : localhost:3306
Source Database       : his_oauth2_resource_server

Target Server Type    : MYSQL
Target Server Version : 50716
File Encoding         : 65001

Date: 2020-04-13 21:59:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_content
-- ----------------------------
DROP TABLE IF EXISTS `tb_content`;
CREATE TABLE `tb_content` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `sub_title` varchar(255) DEFAULT NULL,
  `title_desc` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `pic` varchar(255) DEFAULT NULL,
  `pic2` varchar(255) DEFAULT NULL,
  `content` varchar(1024) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_content
-- ----------------------------
INSERT INTO `tb_content` VALUES ('1', '1', '测试1', '子标题', '标题秒杀', 'http://a.com', '1.jpg', '2.png', '内容太丰富了', '2020-04-07 00:00:00', '2020-04-08 00:00:00');
INSERT INTO `tb_content` VALUES ('2', '1', '阿斯蒂芬', '啊啊', '少的地方', 'a.com', 'a.jpg', 'b.jpg', 'sss是否', '2020-04-02 00:00:00', '2020-04-05 00:00:00');
