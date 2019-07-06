/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80011
 Source Host           : localhost:3306
 Source Schema         : j14_mall

 Target Server Type    : MySQL
 Target Server Version : 80011
 File Encoding         : 65001

 Date: 06/07/2019 09:18:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cskaoyan_mall_expressconfig
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_expressconfig`;
CREATE TABLE `cskaoyan_mall_expressconfig`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `litemall_express_freight_min` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `litemall_express_freight_value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cskaoyan_mall_expressconfig
-- ----------------------------
INSERT INTO `cskaoyan_mall_expressconfig` VALUES (1, NULL, NULL);
INSERT INTO `cskaoyan_mall_expressconfig` VALUES (2, NULL, NULL);

-- ----------------------------
-- Table structure for cskaoyan_mall_mallconfig
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_mallconfig`;
CREATE TABLE `cskaoyan_mall_mallconfig`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `litemall_mall_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `litemall_mall_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `litemall_mall_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `litemall_mall_qq` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cskaoyan_mall_mallconfig
-- ----------------------------
INSERT INTO `cskaoyan_mall_mallconfig` VALUES (11, '1', '1', '1', '1');

-- ----------------------------
-- Table structure for cskaoyan_mall_orderconfig
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_orderconfig`;
CREATE TABLE `cskaoyan_mall_orderconfig`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `litemall_order_comment` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `litemall_order_unconfirm` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `litemall_order_unpaid` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for cskaoyan_mall_wxconfig
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_wxconfig`;
CREATE TABLE `cskaoyan_mall_wxconfig`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `litemall_wx_catlog_goods` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `litemall_wx_catlog_list` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `litemall_wx_index_brand` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `litemall_wx_index_hot` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `litemall_wx_index_new` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `litemall_wx_index_topic` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `litemall_wx_share` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
