/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50151
Source Host           : localhost:3306
Source Database       : ssh2_ss3

Target Server Type    : MYSQL
Target Server Version : 50151
File Encoding         : 65001

Date: 2012-06-18 22:29:13
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_authority`
-- ----------------------------
DROP TABLE IF EXISTS `t_authority`;
CREATE TABLE `t_authority` (
  `authority_id` int(11) NOT NULL AUTO_INCREMENT,
  `authority_name` varchar(255) DEFAULT NULL,
  `authority_desc` varchar(255) DEFAULT NULL,
  `module` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `issys` bit(1) DEFAULT NULL,
  PRIMARY KEY (`authority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_authority
-- ----------------------------
INSERT INTO `t_authority` VALUES ('1', 'ROLE_ADMIN', '系统管理员', '01', '', '\0');
INSERT INTO `t_authority` VALUES ('2', 'ROLE_USER', '普通会员', '01', '', '\0');

-- ----------------------------
-- Table structure for `t_authority_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_authority_resource`;
CREATE TABLE `t_authority_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) DEFAULT NULL,
  `authority_id` int(11) DEFAULT NULL,
  `resource_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK847CD33591E792EF` (`authority_id`),
  KEY `FK847CD335B97BEC45` (`resource_id`),
  CONSTRAINT `FK847CD33591E792EF` FOREIGN KEY (`authority_id`) REFERENCES `t_authority` (`authority_id`),
  CONSTRAINT `FK847CD335B97BEC45` FOREIGN KEY (`resource_id`) REFERENCES `t_resource` (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_authority_resource
-- ----------------------------
INSERT INTO `t_authority_resource` VALUES ('1', '', '1', '1');
INSERT INTO `t_authority_resource` VALUES ('2', '', '2', '2');
INSERT INTO `t_authority_resource` VALUES ('3', '', '1', '2');

-- ----------------------------
-- Table structure for `t_resource`
-- ----------------------------
DROP TABLE IF EXISTS `t_resource`;
CREATE TABLE `t_resource` (
  `resource_id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(255) DEFAULT NULL,
  `resource_desc` varchar(255) DEFAULT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `resource_string` varchar(255) DEFAULT NULL,
  `priority` bit(1) DEFAULT NULL,
  `enabled` int(11) DEFAULT NULL,
  `issys` int(11) DEFAULT NULL,
  `module` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`resource_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_resource
-- ----------------------------
INSERT INTO `t_resource` VALUES ('1', 'admin', '管理员管理', 'URL', '/admin/list.jsp', null, '1', '0', '01');
INSERT INTO `t_resource` VALUES ('2', 'user', '会员管理', 'URL', '/user/list.jsp', null, '1', '0', '01');

-- ----------------------------
-- Table structure for `t_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_role`;
CREATE TABLE `t_role` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  `role_desc` varchar(255) DEFAULT NULL,
  `module` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `issys` bit(1) DEFAULT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role
-- ----------------------------
INSERT INTO `t_role` VALUES ('1', 'ROLE_TEST1', '系统管理员', '01', '', '\0');
INSERT INTO `t_role` VALUES ('2', 'ROLE_TEST2', '普通会员', '01', '', '\0');

-- ----------------------------
-- Table structure for `t_role_authority`
-- ----------------------------
DROP TABLE IF EXISTS `t_role_authority`;
CREATE TABLE `t_role_authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `authority_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8A79DDE5256210C5` (`role_id`),
  KEY `FK8A79DDE591E792EF` (`authority_id`),
  CONSTRAINT `FK8A79DDE5256210C5` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`),
  CONSTRAINT `FK8A79DDE591E792EF` FOREIGN KEY (`authority_id`) REFERENCES `t_authority` (`authority_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_role_authority
-- ----------------------------
INSERT INTO `t_role_authority` VALUES ('1', '', '1', '1');
INSERT INTO `t_role_authority` VALUES ('2', '', '2', '2');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `account` varchar(255) DEFAULT NULL,
  `user_desc` varchar(255) DEFAULT NULL,
  `user_duty` varchar(255) DEFAULT NULL,
  `sub_system` varchar(255) DEFAULT NULL,
  `user_dept` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `issys` bit(1) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'admin', '123456', 'admin', '系统管理员', 'duty', '', 'sell', '', '');
INSERT INTO `t_user` VALUES ('2', 'clyhs', '123456', 'clyhs', '普通会员', 'duty', '', null, '', '\0');

-- ----------------------------
-- Table structure for `t_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_user_role`;
CREATE TABLE `t_user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `enabled` bit(1) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK331DEE5F256210C5` (`role_id`),
  KEY `FK331DEE5FCA8CD4A5` (`user_id`),
  CONSTRAINT `FK331DEE5F256210C5` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`role_id`),
  CONSTRAINT `FK331DEE5FCA8CD4A5` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user_role
-- ----------------------------
INSERT INTO `t_user_role` VALUES ('1', '', '1', '1');
INSERT INTO `t_user_role` VALUES ('2', '', '2', '2');
