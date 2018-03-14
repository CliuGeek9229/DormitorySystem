/*
MySQL Data Transfer
Source Host: localhost
Source Database: db_dormitorysys
Target Host: localhost
Target Database: db_dormitorysys
Date: 2018/3/14 10:46:40
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for tb_announce
-- ----------------------------
DROP TABLE IF EXISTS `tb_announce`;
CREATE TABLE `tb_announce` (
  `id` int(10) NOT NULL auto_increment,
  `details` varchar(255) default NULL,
  `time` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Table structure for tb_applyexchange
-- ----------------------------
DROP TABLE IF EXISTS `tb_applyexchange`;
CREATE TABLE `tb_applyexchange` (
  `id` int(10) NOT NULL auto_increment,
  `stuID` varchar(20) default NULL,
  `realname` varchar(20) default NULL,
  `school` varchar(20) default NULL,
  `apartment` int(10) default NULL,
  `dormitory` int(10) default NULL,
  `targetApart` int(10) default NULL,
  `targetRoom` int(10) default NULL,
  `reason` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Table structure for tb_backlate
-- ----------------------------
DROP TABLE IF EXISTS `tb_backlate`;
CREATE TABLE `tb_backlate` (
  `id` int(10) NOT NULL auto_increment,
  `stuID` varchar(10) default NULL,
  `stuname` varchar(20) default NULL,
  `stuschool` varchar(10) default NULL,
  `stuapartent` int(5) default NULL,
  `studentdormity` int(8) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Table structure for tb_callfix
-- ----------------------------
DROP TABLE IF EXISTS `tb_callfix`;
CREATE TABLE `tb_callfix` (
  `id` int(10) NOT NULL auto_increment,
  `stuID` varchar(20) default NULL,
  `realname` varchar(20) default NULL,
  `school` varchar(20) default NULL,
  `apartment` int(10) default NULL,
  `dormitory` int(10) default NULL,
  `detail` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Table structure for tb_callstay
-- ----------------------------
DROP TABLE IF EXISTS `tb_callstay`;
CREATE TABLE `tb_callstay` (
  `id` int(10) NOT NULL auto_increment,
  `stuID` varchar(20) default NULL,
  `realname` varchar(20) default NULL,
  `apartment` int(10) default NULL,
  `dormitory` int(10) default NULL,
  `detail` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Table structure for tb_feedback
-- ----------------------------
DROP TABLE IF EXISTS `tb_feedback`;
CREATE TABLE `tb_feedback` (
  `id` int(10) NOT NULL auto_increment,
  `stuID` varchar(10) default NULL,
  `stuname` varchar(20) default NULL,
  `stuschool` varchar(10) default NULL,
  `stuapartment` int(5) default NULL,
  `studormitory` int(8) default NULL,
  `fbdetail` text,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Table structure for tb_lostinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_lostinfo`;
CREATE TABLE `tb_lostinfo` (
  `id` int(10) NOT NULL auto_increment,
  `stuID` varchar(20) default NULL,
  `realname` varchar(20) default NULL,
  `detail` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Table structure for tb_oldthing
-- ----------------------------
DROP TABLE IF EXISTS `tb_oldthing`;
CREATE TABLE `tb_oldthing` (
  `id` int(10) NOT NULL,
  `oldinfo` varchar(255) default NULL,
  `date` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Table structure for tb_room
-- ----------------------------
DROP TABLE IF EXISTS `tb_room`;
CREATE TABLE `tb_room` (
  `id` int(10) NOT NULL,
  `roomnum` varchar(20) default NULL,
  `apartment` varchar(30) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Table structure for tb_stuinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_stuinfo`;
CREATE TABLE `tb_stuinfo` (
  `stuID` varchar(15) NOT NULL,
  `stuPW` varchar(20) default NULL,
  `stuname` varchar(20) default NULL,
  `stusex` varchar(10) default NULL,
  `stuschool` varchar(10) default NULL,
  `stumajor` varchar(20) default NULL,
  `stuapartment` int(5) default NULL,
  `studormitory` int(8) default NULL,
  PRIMARY KEY  (`stuID`)
) ENGINE=InnoDB DEFAULT CHARSET=gb2312;

-- ----------------------------
-- Records 
-- ----------------------------
INSERT INTO `tb_announce` VALUES ('1', '有雨，大家记得收被子', '2017-03-17');
INSERT INTO `tb_announce` VALUES ('2', '太阳很好，大家记得晒被子', '2017-03-18');
INSERT INTO `tb_announce` VALUES ('3', '卫生状况良好，大家继续努力', '2017-03-20');
INSERT INTO `tb_applyexchange` VALUES ('1', '0131122589', '宋亚旭', '本区', '2', '604', '2', '654', 'hdjdj阿斯蒂芬');
INSERT INTO `tb_applyexchange` VALUES ('2', '0131122589', '宋亚旭', '本区', '2', '604', '2', '654', '阿斯蒂芬 ');
INSERT INTO `tb_applyexchange` VALUES ('3', '0131122589', '宋亚旭', '本区', '2', '604', '2', '654', '金融特惠');
INSERT INTO `tb_backlate` VALUES ('3', '0131123716', '刘聪', '本区', '2', '604');
INSERT INTO `tb_callfix` VALUES ('7', '0131123716', '刘聪', '本区', '2', '604', '暖气漏水');
INSERT INTO `tb_callfix` VALUES ('8', '0131122589', '宋亚旭', '本区', '2', '604', '回到家第四色华东交大经典款嗯嗯');
INSERT INTO `tb_callstay` VALUES ('2', '0131123716', '刘聪', '2', '604', '呀呀呀刚说完');
INSERT INTO `tb_feedback` VALUES ('5', '0131123716', '刘聪', '本区', '2', '604', '好的开始太少了还是不说了');
INSERT INTO `tb_lostinfo` VALUES ('1', '0131124948', '林文杰', '捡到钥匙一串，现已交给2号楼宿管，联系电话66666');
INSERT INTO `tb_lostinfo` VALUES ('2', '0131122589', '???', 'fguijgf');
INSERT INTO `tb_oldthing` VALUES ('1', '旧桌子一张，有意者请到本区二号楼333宿舍，电话666555', '2017-03-20');
INSERT INTO `tb_oldthing` VALUES ('2', '9成新椅子一把，有意者请到东区9号楼2323宿舍，联系电话2345829', '2017-03-26');
INSERT INTO `tb_room` VALUES ('1', '985', '2#');
INSERT INTO `tb_room` VALUES ('2', '654', '2#');
INSERT INTO `tb_room` VALUES ('3', '614', '9#');
INSERT INTO `tb_stuinfo` VALUES ('0131122589', '1234', '宋亚旭', '男', '本区', '计算机技术', '2', '604');
INSERT INTO `tb_stuinfo` VALUES ('0131123001', '1234', '张三', '男', '本区', '软件工程', '2', '666');
INSERT INTO `tb_stuinfo` VALUES ('0131123761', '12345', '刘聪', '男', '本区', '软件工程', '2', '604');
INSERT INTO `tb_stuinfo` VALUES ('0131124948', '1234', '林文杰', '男', '本区', '软件工程', '2', '604');
