/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50717
 Source Host           : localhost
 Source Database       : ds1

 Target Server Type    : MySQL
 Target Server Version : 50717
 File Encoding         : utf-8

 Date: 12/20/2018 19:17:18 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `t_config`
-- ----------------------------
DROP TABLE IF EXISTS `t_config`;
CREATE TABLE `t_config` (
  `config_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `config_key` varchar(255) DEFAULT NULL,
  `config_value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`config_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_order`
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order` (
  `order_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_order0`
-- ----------------------------
DROP TABLE IF EXISTS `t_order0`;
CREATE TABLE `t_order0` (
  `order_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_order1`
-- ----------------------------
DROP TABLE IF EXISTS `t_order1`;
CREATE TABLE `t_order1` (
  `order_id` int(11) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `t_order1`
-- ----------------------------
BEGIN;
INSERT INTO `t_order1` VALUES ('1', '2018-12-20 17:35:39', '991');
COMMIT;

-- ----------------------------
--  Table structure for `t_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item`;
CREATE TABLE `t_order_item` (
  `order_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `order_content` varchar(255) DEFAULT NULL,
  `order_item_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_order_item0`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item0`;
CREATE TABLE `t_order_item0` (
  `order_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `order_content` varchar(255) DEFAULT NULL,
  `order_item_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Table structure for `t_order_item1`
-- ----------------------------
DROP TABLE IF EXISTS `t_order_item1`;
CREATE TABLE `t_order_item1` (
  `order_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `order_content` varchar(255) DEFAULT NULL,
  `order_item_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`order_item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 ROW_FORMAT=DYNAMIC;

-- ----------------------------
--  Records of `t_order_item1`
-- ----------------------------
BEGIN;
INSERT INTO `t_order_item1` VALUES ('1', '2018-12-20 18:30:02', 'string', '1', '1');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
