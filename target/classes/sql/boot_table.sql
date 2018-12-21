/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1_3306
Source Server Version : 50723
Source Host           : 127.0.0.1:3306
Source Database       : boot_table

Target Server Type    : MYSQL
Target Server Version : 50723
File Encoding         : 65001

Date: 2018-10-15 09:00:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_goods
-- ----------------------------
DROP TABLE IF EXISTS `tb_goods`;
CREATE TABLE `tb_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `good_name` varchar(255) DEFAULT NULL,
  `size` int(11) DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_goods
-- ----------------------------
INSERT INTO `tb_goods` VALUES ('1', '衣服', '15', '124.00', '哈哈');
INSERT INTO `tb_goods` VALUES ('2', '鞋子', '22', '156.70', '还可以');

-- ----------------------------
-- Table structure for tb_student
-- ----------------------------
DROP TABLE IF EXISTS `tb_student`;
CREATE TABLE `tb_student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `age` smallint(6) DEFAULT NULL,
  `birth` date DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `hobby` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of tb_student
-- ----------------------------
INSERT INTO `tb_student` VALUES ('1', '张三', '24', '1994-08-24', null, '你好');
INSERT INTO `tb_student` VALUES ('2', '李四', '24', '1994-08-24', 'java', '打篮球');
INSERT INTO `tb_student` VALUES ('3', '王五', '24', '1994-08-24', 'java', null);
INSERT INTO `tb_student` VALUES ('4', 'jack', '24', '1994-08-24', 'java', null);
INSERT INTO `tb_student` VALUES ('5', 'mark', '24', '1994-08-24', 'java', '滴滴');
INSERT INTO `tb_student` VALUES ('6', '李四', '24', '1994-08-24', 'java', null);
INSERT INTO `tb_student` VALUES ('7', '王五', '24', '1994-08-24', 'java', null);
INSERT INTO `tb_student` VALUES ('8', 'jack', '24', '1994-08-24', 'java', null);
INSERT INTO `tb_student` VALUES ('9', 'mark', '24', '1994-08-24', 'java', null);
INSERT INTO `tb_student` VALUES ('10', '阿甘', '18', '2018-01-15', 'php', '吊死扶伤');
INSERT INTO `tb_student` VALUES ('11', '调查', '23', '2018-10-15', 'c', '地方队');
