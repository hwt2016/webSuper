/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : qd_xqjr

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2017-06-14 15:22:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for d_accept
-- ----------------------------
DROP TABLE IF EXISTS `d_accept`;
CREATE TABLE `d_accept` (
  `id` int(11) NOT NULL,
  `dealmanagerid` int(11) DEFAULT NULL,
  `dealview` varchar(255) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_accept
-- ----------------------------

-- ----------------------------
-- Table structure for d_admin
-- ----------------------------
DROP TABLE IF EXISTS `d_admin`;
CREATE TABLE `d_admin` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `adminName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_admin
-- ----------------------------
INSERT INTO `d_admin` VALUES ('2', '1', '1', '1', '2017-06-01 10:15:59', '2017-06-01 10:16:02');

-- ----------------------------
-- Table structure for d_approval
-- ----------------------------
DROP TABLE IF EXISTS `d_approval`;
CREATE TABLE `d_approval` (
  `id` int(11) NOT NULL,
  `rongtarget` varchar(50) DEFAULT NULL,
  `rongamount` varchar(50) DEFAULT NULL,
  `rongdeadline` date DEFAULT NULL,
  `rongrate` double DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_approval
-- ----------------------------

-- ----------------------------
-- Table structure for d_area
-- ----------------------------
DROP TABLE IF EXISTS `d_area`;
CREATE TABLE `d_area` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `province` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `district` varchar(30) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_area
-- ----------------------------
INSERT INTO `d_area` VALUES ('1', '山西省', '阳泉市', '冠山镇', '正常', '2017-06-05 08:22:40', '2017-06-05 08:22:40');

-- ----------------------------
-- Table structure for d_ascription
-- ----------------------------
DROP TABLE IF EXISTS `d_ascription`;
CREATE TABLE `d_ascription` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `upuserid` int(11) unsigned DEFAULT NULL,
  `upgrade` varchar(20) DEFAULT NULL,
  `downuserid` int(11) unsigned DEFAULT NULL,
  `downgrade` varchar(20) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_ascription
-- ----------------------------
INSERT INTO `d_ascription` VALUES ('6', '1', 'A', '19', 'C', '正常', '2017-06-09 21:45:30', '2017-06-09 21:45:30');
INSERT INTO `d_ascription` VALUES ('7', '1', 'A', '20', 'C', '正常', '2017-06-09 21:49:17', '2017-06-09 21:49:17');
INSERT INTO `d_ascription` VALUES ('9', '1', 'A', '2', 'B', '正常', '2017-06-10 17:09:52', '2017-06-10 17:09:52');
INSERT INTO `d_ascription` VALUES ('10', '2', 'B', '18', 'C', '正常', '2017-06-10 17:10:07', '2017-06-10 17:10:07');
INSERT INTO `d_ascription` VALUES ('11', '3', 'A', '21', 'B', '正常', '2017-06-10 19:09:27', '2017-06-10 19:09:27');
INSERT INTO `d_ascription` VALUES ('27', '1', 'A', '22', 'B', '正常', '2017-06-10 19:34:23', '2017-06-10 19:34:23');

-- ----------------------------
-- Table structure for d_house
-- ----------------------------
DROP TABLE IF EXISTS `d_house`;
CREATE TABLE `d_house` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `numOfCertificate` varchar(255) DEFAULT NULL,
  `price` float(11,0) DEFAULT NULL,
  `yearsOfHouse` int(11) DEFAULT NULL,
  `marketValue` float(11,0) DEFAULT NULL,
  `valueOfArround` float(11,0) DEFAULT NULL,
  `cityOfHouse` varchar(20) DEFAULT NULL,
  `houseType` varchar(20) DEFAULT NULL,
  `payment` float(11,0) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `area` float(11,0) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_house
-- ----------------------------
INSERT INTO `d_house` VALUES ('2', '18', '9000', '13', '89', '13', '13', '日照', '1', '13', '山东省青岛市黄岛区前湾港路579号', '90', '正常', '2017-06-06 11:09:30', '2017-06-07 20:37:14');
INSERT INTO `d_house` VALUES ('10', '18', '9002', '78', '66', null, null, '日照', '1', null, '', null, '正常', '2017-06-07 22:22:39', '2017-06-08 09:27:47');
INSERT INTO `d_house` VALUES ('11', '19', '9777', null, null, null, null, '', '', null, '', null, '正常', '2017-06-09 21:45:30', '2017-06-09 21:45:30');
INSERT INTO `d_house` VALUES ('12', '20', '', null, null, null, null, '', '', null, '', null, '正常', '2017-06-09 21:49:17', '2017-06-09 21:49:17');

-- ----------------------------
-- Table structure for d_loan
-- ----------------------------
DROP TABLE IF EXISTS `d_loan`;
CREATE TABLE `d_loan` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `sex` varchar(10) DEFAULT NULL,
  `marriage` varchar(20) DEFAULT NULL,
  `countOfChildren` int(11) DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `company` varchar(100) DEFAULT NULL,
  `position` varchar(30) DEFAULT NULL,
  `companyAddress` varchar(100) DEFAULT NULL,
  `shareRatio` float DEFAULT NULL,
  `ageOfWork` int(11) DEFAULT NULL,
  `annualIncome` float(11,0) DEFAULT NULL,
  `hiredate` int(11) DEFAULT NULL,
  `kinName` varchar(30) DEFAULT NULL,
  `kinPhone` varchar(20) DEFAULT NULL,
  `loanAmount` float(11,0) DEFAULT NULL,
  `loanTerm` int(11) DEFAULT NULL,
  `expectedLoanForm` varchar(11) DEFAULT NULL,
  `estimatedLoan` int(11) DEFAULT NULL,
  `cardholder` varchar(20) DEFAULT NULL,
  `cardNumber` varchar(20) DEFAULT NULL,
  `cardPhone` varchar(20) DEFAULT NULL,
  `cardBank` varchar(100) DEFAULT NULL,
  `state` varchar(20) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_loan
-- ----------------------------

-- ----------------------------
-- Table structure for d_monitor
-- ----------------------------
DROP TABLE IF EXISTS `d_monitor`;
CREATE TABLE `d_monitor` (
  `id` int(11) NOT NULL,
  `paymethod` varchar(30) DEFAULT NULL,
  `payamount` double DEFAULT NULL,
  `paydate` date DEFAULT NULL,
  `endofbusiness` date DEFAULT NULL,
  `status` varchar(255) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_monitor
-- ----------------------------

-- ----------------------------
-- Table structure for d_period
-- ----------------------------
DROP TABLE IF EXISTS `d_period`;
CREATE TABLE `d_period` (
  `id` int(11) NOT NULL,
  `userid` int(11) NOT NULL,
  `acceptid` int(11) DEFAULT NULL,
  `approvalid` int(11) DEFAULT NULL,
  `replyid` int(11) DEFAULT NULL,
  `monitorid` int(11) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_period
-- ----------------------------

-- ----------------------------
-- Table structure for d_reply
-- ----------------------------
DROP TABLE IF EXISTS `d_reply`;
CREATE TABLE `d_reply` (
  `id` int(11) NOT NULL,
  `replyinstitution` varchar(60) DEFAULT NULL,
  `replyamount` double DEFAULT NULL,
  `replydeadline` date DEFAULT NULL,
  `replyrate` double DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_reply
-- ----------------------------

-- ----------------------------
-- Table structure for d_service
-- ----------------------------
DROP TABLE IF EXISTS `d_service`;
CREATE TABLE `d_service` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `serviceName` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `status` varchar(20) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_service
-- ----------------------------

-- ----------------------------
-- Table structure for d_user
-- ----------------------------
DROP TABLE IF EXISTS `d_user`;
CREATE TABLE `d_user` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `nickname` varchar(40) DEFAULT NULL,
  `password` varchar(20) NOT NULL,
  `realname` varchar(40) DEFAULT NULL,
  `sex` varchar(20) DEFAULT NULL,
  `phone` varchar(20) NOT NULL,
  `province` varchar(30) DEFAULT NULL,
  `city` varchar(30) DEFAULT NULL,
  `district` varchar(30) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `cardHolder` varchar(20) DEFAULT NULL,
  `cardBank` varchar(200) DEFAULT NULL,
  `cardNumber` varchar(30) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `icon` varchar(50) DEFAULT NULL,
  `grade` varchar(10) DEFAULT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_user
-- ----------------------------
INSERT INTO `d_user` VALUES ('1', null, '1234', '公司', '', '13333333333', null, null, '', null, null, null, null, null, null, 'A', '2017-06-06 09:50:42', '2017-06-06 09:50:45', '正常');
INSERT INTO `d_user` VALUES ('2', null, '1234', '测试', 'M', '15518183999', '河北省', '秦皇岛市', '昌黎县', null, null, null, null, null, null, 'B', '2017-05-31 14:56:16', '2017-05-31 14:56:16', '正常');
INSERT INTO `d_user` VALUES ('3', null, '1234', '测试2', 'M', '13444444444', '山西省', '阳泉市', '冠山镇', null, null, null, null, null, null, 'A', '2017-06-05 08:24:45', '2017-06-05 08:24:45', '正常');
INSERT INTO `d_user` VALUES ('18', null, '666666', '政风', 'M', '18813016811', null, '日照', null, null, '天翼', '1', '1111111111111111111', '2017-06-07', null, 'C', '2017-06-06 11:09:30', '2017-06-07 19:21:40', '跟进');
INSERT INTO `d_user` VALUES ('19', null, '666666', '用户信息录入测试1', 'M', '15566668888', null, null, null, null, '天翼', '工商', '1111111111111111111', null, null, 'C', '2017-06-09 21:45:30', '2017-06-09 21:45:30', '正常');
INSERT INTO `d_user` VALUES ('20', null, '666666', '用户信息录入测试2', 'M', '13366668888', null, null, null, null, '天翼', '', '1111111111111111111', '2017-06-29', null, 'C', '2017-06-09 21:49:17', '2017-06-10 17:08:13', '跟进');
INSERT INTO `d_user` VALUES ('21', null, '1234', '张三', 'on', '15555555555', '山西省', '阳泉市', '冠山镇', null, null, null, null, null, null, 'B', '2017-06-10 19:07:51', '2017-06-10 19:07:51', '正常');
INSERT INTO `d_user` VALUES ('22', null, '1234', '李四', 'on', '16666666666', '山西省', '阳泉市', '冠山镇', null, null, null, null, null, null, 'B', '2017-06-10 19:08:27', '2017-06-10 19:08:27', '正常');

-- ----------------------------
-- Table structure for d_userinfo
-- ----------------------------
DROP TABLE IF EXISTS `d_userinfo`;
CREATE TABLE `d_userinfo` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) unsigned NOT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `cityofinfo` varchar(30) DEFAULT NULL,
  `income` varchar(20) DEFAULT NULL,
  `incomeOfHome` varchar(20) DEFAULT NULL,
  `marriage` varchar(20) DEFAULT NULL,
  `health` varchar(20) DEFAULT NULL,
  `education` varchar(20) DEFAULT NULL,
  `countOfChildren` int(11) DEFAULT NULL,
  `house_id` int(11) DEFAULT NULL,
  `vehicle_id` int(11) DEFAULT NULL,
  `companyOfNature` varchar(20) DEFAULT NULL,
  `startOfWork` date DEFAULT NULL,
  `hiredate` date DEFAULT NULL,
  `ageOfWork` varchar(20) DEFAULT NULL,
  `position` varchar(30) DEFAULT NULL,
  `professionalSkill` varchar(30) DEFAULT NULL,
  `stateOfbankOfCount` varchar(20) DEFAULT NULL,
  `stateOfSheBao` varchar(20) DEFAULT NULL,
  `creditCard` float(11,0) DEFAULT NULL,
  `guarantee` float(11,0) DEFAULT NULL,
  `litigation` varchar(20) DEFAULT NULL,
  `loan` varchar(20) DEFAULT NULL,
  `contactsOfFriends` int(20) DEFAULT NULL,
  `investmentUse` varchar(20) DEFAULT NULL,
  `onlineShoppingRecord` varchar(20) DEFAULT NULL,
  `personalCreditInquiry` varchar(20) DEFAULT NULL,
  `wife` int(11) DEFAULT NULL,
  `estimatedLoan` float(11,0) DEFAULT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  `status` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_userinfo
-- ----------------------------
INSERT INTO `d_userinfo` VALUES ('3', '18', 'M', '13', '聊城', '1', '3', '1', '1', '1', null, null, null, '', '2017-06-08', '2017-06-08', '1', '2', '中等职称', '1', '2', '44', '13', '2', '2', null, '1', '2', '2', null, '13', '2017-06-06 11:09:30', '2017-06-07 19:24:01', '正常');
INSERT INTO `d_userinfo` VALUES ('4', '19', 'M', '13', null, '', '', '', '', '', null, null, null, '', null, null, '', '', '', '', '', null, null, '', '', null, '', '', '', null, null, '2017-06-09 21:45:30', '2017-06-09 21:45:30', '正常');
INSERT INTO `d_userinfo` VALUES ('5', '20', 'M', null, null, '', '', '', '', '', null, null, null, '', null, null, '', '', '', '', '', null, null, '', '', null, '', '', '', null, null, '2017-06-09 21:49:17', '2017-06-09 21:49:17', '正常');

-- ----------------------------
-- Table structure for d_vehicle
-- ----------------------------
DROP TABLE IF EXISTS `d_vehicle`;
CREATE TABLE `d_vehicle` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `typeOfCar` varchar(20) DEFAULT NULL,
  `natureOfVehicle` varchar(20) DEFAULT NULL,
  `fullCar` varchar(20) DEFAULT NULL,
  `mortgage` varchar(20) DEFAULT NULL,
  `status` varchar(20) NOT NULL,
  `createtime` datetime NOT NULL,
  `updatetime` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of d_vehicle
-- ----------------------------
INSERT INTO `d_vehicle` VALUES ('2', '18', '123', '2', null, null, '正常', '2017-06-06 11:09:30', '2017-06-07 21:18:22');
INSERT INTO `d_vehicle` VALUES ('10', '18', '红旗', '1', null, null, '正常', '2017-06-07 22:13:47', '2017-06-07 22:13:47');
INSERT INTO `d_vehicle` VALUES ('11', '19', '红旗', '1', null, null, '正常', '2017-06-09 21:45:30', '2017-06-09 21:45:30');
INSERT INTO `d_vehicle` VALUES ('12', '20', '红旗', '1', null, null, '正常', '2017-06-09 21:49:17', '2017-06-09 21:49:17');
