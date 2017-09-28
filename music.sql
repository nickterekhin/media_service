/*
 Navicat Premium Data Transfer

 Source Server         : Nick-localhost
 Source Server Type    : MySQL
 Source Server Version : 50716
 Source Host           : localhost
 Source Database       : music

 Target Server Type    : MySQL
 Target Server Version : 50716
 File Encoding         : utf-8

 Date: 09/28/2017 15:41:53 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `collaborator`
-- ----------------------------
DROP TABLE IF EXISTS `collaborator`;
CREATE TABLE `collaborator` (
  `id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `groups`
-- ----------------------------
DROP TABLE IF EXISTS `groups`;
CREATE TABLE `groups` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `groupName` varchar(50) NOT NULL,
  `permissions` int(11) DEFAULT NULL,
  `active` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `groups`
-- ----------------------------
BEGIN;
INSERT INTO `groups` VALUES ('1', 'SupperAdmin', '1', b'1'), ('2', 'Admin', '2', b'1'), ('3', 'Guest', '4', b'1'), ('4', 'Collaborator', '8', b'1');
COMMIT;

-- ----------------------------
--  Table structure for `permissions`
-- ----------------------------
DROP TABLE IF EXISTS `permissions`;
CREATE TABLE `permissions` (
  `id` bigint(11) NOT NULL,
  `Name` varchar(50) DEFAULT NULL,
  `active` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- ----------------------------
--  Table structure for `project`
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `OwnerId` bigint(20) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Slug` varchar(150) NOT NULL,
  `CreatedAt` datetime NOT NULL,
  `active` bit(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `project`
-- ----------------------------
BEGIN;
INSERT INTO `project` VALUES ('1', '2', 'test project', 'test_project', '2017-07-05 22:43:56', b'0'), ('2', '2', 'test project 2', 'test_project_2', '2017-07-18 15:04:50', b'0'), ('3', '2', 'test project 3', 'test_project_3', '2017-07-18 15:05:45', b'0'), ('4', '2', 'test', 'test', '2017-07-18 15:08:49', b'0');
COMMIT;

-- ----------------------------
--  Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `ugroup` bigint(11) NOT NULL,
  `userName` varchar(20) NOT NULL,
  `email` varchar(250) NOT NULL,
  `password` varchar(250) NOT NULL,
  `createdAt` datetime NOT NULL,
  `IP` varchar(16) DEFAULT NULL,
  `active` bit(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
--  Records of `users`
-- ----------------------------
BEGIN;
INSERT INTO `users` VALUES ('1', '1', 'NickTer', 'nick.terekhin@gmail.com', 'ef0b78cbdd4734fcbb9e7774cd79998a', '2017-06-03 22:01:15', null, b'1'), ('2', '4', 'NickTer4', 'nickter4@mail.com', '827ccb0eea8a706c4c34a16891f84e7b', '2017-07-05 20:14:59', null, b'1');
COMMIT;

-- ----------------------------
--  Table structure for `version`
-- ----------------------------
DROP TABLE IF EXISTS `version`;
CREATE TABLE `version` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

SET FOREIGN_KEY_CHECKS = 1;
