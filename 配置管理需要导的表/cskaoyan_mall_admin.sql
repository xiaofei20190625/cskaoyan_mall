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

 Date: 08/07/2019 17:17:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for cskaoyan_mall_admin
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_admin`;
CREATE TABLE `cskaoyan_mall_admin`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '管理员名称',
  `password` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '' COMMENT '管理员密码',
  `last_login_ip` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '' COMMENT '最近一次登录IP地址',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最近一次登录时间',
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '\'' COMMENT '头像图片',
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  `role_ids` varchar(127) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '[]' COMMENT '角色列表',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cskaoyan_mall_admin
-- ----------------------------
INSERT INTO `cskaoyan_mall_admin` VALUES (1, 'admin123', 'admin123', NULL, NULL, 'https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif', '2018-02-01 00:00:00', '2018-02-01 00:00:00', 0, '[1]');
INSERT INTO `cskaoyan_mall_admin` VALUES (4, 'promotion123', '123', '', NULL, '\'', '2019-01-07 15:16:59', '2019-01-07 15:17:34', 0, '[3]');
INSERT INTO `cskaoyan_mall_admin` VALUES (5, 'mall123', '123123', '', NULL, '\'', '2019-01-07 15:17:25', '2019-01-07 15:21:05', 0, '[2]');

-- ----------------------------
-- Table structure for cskaoyan_mall_permission
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_permission`;
CREATE TABLE `cskaoyan_mall_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_ids` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `permission` varchar(63) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '权限',
  `mothed` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `api` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `add_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '更新时间',
  `deleted` tinyint(1) NULL DEFAULT 0 COMMENT '逻辑删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 94 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '权限表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cskaoyan_mall_permission
-- ----------------------------
INSERT INTO `cskaoyan_mall_permission` VALUES (1, '1', '*', NULL, '', NULL, '2019-01-01 00:00:00', '2019-01-01 00:00:00', 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (2, NULL, 'admin:comment:delete', 'POST', '/admin/comment/delete', '删除', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (3, NULL, 'admin:comment:list', 'GET', '/admin/comment/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (4, NULL, 'admin:goods:read', 'GET', '/admin/goods/detail', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (5, NULL, 'admin:goods:update', 'POST', '/admin/goods/update', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (6, NULL, 'admin:goods:delete', 'POST', '/admin/goods/delete', '删除', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (7, NULL, 'admin:goods:create', 'POST', '/admin/goods/create', '上架', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (8, NULL, 'admin:goods:list', 'GET', '/admin/goods/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (9, NULL, 'admin:history:list', 'GET', '/admin/history/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (10, NULL, 'admin:address:list', 'GET', '/admin/address/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (11, NULL, 'admin:feedback:list', 'GET', '/admin/feedback/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (12, NULL, 'admin:user:list', 'GET', '/admin/user/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (13, NULL, 'admin:footprint:list', 'GET', 'admin:footprint:list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (14, NULL, 'admin:collect:list', 'GET', '/admin/collect/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (15, NULL, 'admin:role:permission:update', 'POST', '/admin/role/permissions', '权限变更', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (16, NULL, 'admin:role:update', 'POST', '/admin/role/update', '角色编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (17, NULL, 'admin:role:read', 'GET', '/admin/role/read', '角色详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (18, NULL, 'admin:role:delete', 'POST', '/admin/role/delete', '角色删除', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (19, NULL, 'admin:role:permission:get', 'GET', '/admin/role/permissions', '权限详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (20, NULL, 'admin:role:create', 'POST', '/admin/role/create', '角色添加', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (21, NULL, 'admin:role:list', 'GET', '/admin/role/list', '角色管理', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (23, NULL, 'admin:storage:list', 'GET', '/admin/storage/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (24, NULL, 'admin:storage:read', 'POST', '/admin/storage/read', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (25, NULL, 'admin:storage:delete', 'POST', '/admin/storage/delete', '删除', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (26, NULL, 'admin:storage:create', 'POST', '/admin/storage/create', '上传', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (27, NULL, 'admin:storage:update', 'POST', '/admin/storage/update', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (28, NULL, 'admin:admin:update', 'POST', '/admin/admin/update', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (29, NULL, 'admin:admin:delete', 'POST', '/admin/admin/delete', '删除', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (30, NULL, 'admin:admin:read', 'GET', '/admin/admin/read', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (31, NULL, 'admin:admin:list', 'GET', '/admin/admin/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (32, NULL, 'admin:admin:create', 'POST', '/admin/admin/create', '添加', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (33, NULL, 'admin:log:list', 'GET', '/admin/log/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (34, '3', 'admin:coupon:list', 'GET', '/admin/coupon/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (35, '3', 'admin:coupon:update', 'POST', '/admin/coupon/update', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (36, '3', 'admin:coupon:listuser', 'GET', '/admin/coupon/listuser', '查询用户', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (37, '3', 'admin:coupon:read', 'GET', '/admin/coupon/read', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (38, '3', 'admin:coupon:create', 'POST', '/admin/coupon/create', '添加', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (39, '3', 'admin:coupon:delete', 'POST', '/admin/coupon/delete', '删除', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (40, '3', 'admin:topic:list', 'GET', '/admin/topic/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (41, '3', 'admin:topic:read', 'GET', '/admin/topic/read', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (42, '3', 'admin:topic:delete', 'POST', '/admin/topic/delete', '删除', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (43, '3', 'admin:topic:create', 'POST', '/admin/topic/create', '添加', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (44, '3', 'admin:topic:update', 'POST', '/admin/topic/update', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (45, '3', 'admin:groupon:read', 'GET', '/admin/groupon/listRecord', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (46, '3', 'admin:groupon:create', 'POST', '/admin/groupon/create', '添加', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (47, '3', 'admin:groupon:list', 'GET', '/admin/groupon/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (48, '3', 'admin:groupon:update', 'POST', '/admin/groupon/update', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (49, '3', 'admin:groupon:delete', 'POST', '/admin/groupon/delete', '删除', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (50, '3', 'admin:ad:create', 'POSt', '/admin/ad/create', '添加', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (51, '3', 'admin:ad:delete', 'POST', '/admin/ad/delete', '删除', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (53, '3', 'admin:ad:list', 'GET', '/admin/ad/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (54, '3', 'admin:ad:read', 'GET', '/admin/ad/read', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (55, '3', 'admin:ad:update', 'POST', '/admin/ad/update', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (56, '2', 'admin:issue:update', 'POST', '/admin/issue/update', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (57, '2', 'admin:issue:delete', 'POST', '/admin/issue/delete', '删除', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (58, '2', 'admin:issue:list', 'GET', '/admin/issue/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (59, '2', 'admin:issue:create', 'POST', '/admin/issue/create', '添加', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (60, '2', 'admin:keyword:update', 'POST', '/admin/keyword/update', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (61, '2', 'admin:keyword:list', 'GET', '/admin/keyword/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (62, '2', 'admin:keyword:create', 'POST', '/admin/keyword/create', '添加', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (63, '2', 'admin:keyword:read', 'GET', '/admin/keyword/read', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (64, '2', 'admin:keyword:delete', 'POST', '/admin/keyword/delete', '删除', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (65, '2', 'admin:brand:update', 'POST', '/admin/brand/update', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (66, '2', 'admin:brand:list', 'GET', '/admin/brand/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (67, '2', 'admin:brand:delete', 'POST', '/admin/brand/delete', '删除', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (69, '2', 'admin:brand:read', 'GET', '/admin/brand/read', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (70, '2', 'admin:brand:create', 'POST', '/admin/brand/create', '添加', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (71, '2', 'admin:order:list', 'GET', '/admin/order/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (72, '2', 'admin:order:refund', 'POST', '/admin/order/refund', '订单退款', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (73, '2', 'admin:order:read', 'GET', '/admin/order/detail', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (74, '2', 'admin:order:ship', 'POST', '/admin/order/ship', '订单发货', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (75, '2', 'admin:order:reply', 'POST', '/admin/order/reply', '订单商品回复', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (76, '2', 'admin:category:create', 'POST', '/admin/category/create', '添加', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (77, '2', 'admin:category:delete', 'POST', '/admin/category/delete', '删除', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (78, '2', 'admin:category:read', 'GET', '/admin/category/read', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (79, '2', 'admin:category:update', 'POST', '/admin/category/update', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (80, '2', 'admin:category:list', 'GET', '/admin/category/list', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (81, '', 'admin:config:mall:list', 'GET', '/admin/config/mall', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (82, NULL, 'admin:config:mall:updateConfigs', 'POST', '/admin/config/mall', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (83, NULL, 'admin:config:express:list', 'GET', '/admin/config/express', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (84, NULL, 'admin:config:express:updateConfigs', 'POST', '/admin/config/express', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (85, NULL, 'admin:config:order:list', 'GET', '/admin/config/order', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (86, NULL, 'admin:config:order:updateConfigs', 'POST', '/admin/config/order', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (87, NULL, 'admin:config:wx:list', 'GET', '/admin/config/wx', '详情', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (88, NULL, 'admin:config:wx:updateConfigs', 'POST', '/admin/config/wx', '编辑', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (89, NULL, 'index:permission:write', 'POST', '/admin/index/write', '权限写', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (90, NULL, 'index:permission:read', 'GET', '/admin/index/read', '权限读', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (91, NULL, 'admin:stat:user', 'GET', '/admin/stat/user', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (92, NULL, 'admin:stat:order', 'GET', '/admin/stat/order', '查询', NULL, NULL, 0);
INSERT INTO `cskaoyan_mall_permission` VALUES (93, NULL, 'admin:stat:goods', 'GET', '/admin/stat/goods', '查询', NULL, NULL, 0);

-- ----------------------------
-- Table structure for cskaoyan_mall_system_permissions
-- ----------------------------
DROP TABLE IF EXISTS `cskaoyan_mall_system_permissions`;
CREATE TABLE `cskaoyan_mall_system_permissions`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `children_id` int(11) NULL DEFAULT NULL,
  `permission_ids` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 41 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cskaoyan_mall_system_permissions
-- ----------------------------
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (1, '商品管理', 0, NULL);
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (2, '用户管理', 0, NULL);
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (3, '系统管理', 0, NULL);
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (4, '推广管理', 0, NULL);
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (5, '商场管理', 0, NULL);
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (6, '配置管理', 0, NULL);
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (7, '其他', 0, NULL);
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (8, '统计管理', 0, NULL);
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (9, '评论管理', 1, '2,3');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (10, '商品管理', 1, '4,5,6,7,8');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (12, '搜索历史', 2, '9');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (13, '收货地址', 2, '10');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (14, '意见反馈', 2, '11');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (15, '会员管理', 2, '12');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (16, '用户足迹', 2, '13');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (17, '用户收藏', 2, '14');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (18, '角色管理', 3, '15,16,17,18,19,21');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (19, '对象存储', 3, '23,24,25,26,27');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (20, '管理员管理', 3, '29,30,31,32');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (21, '操作日志', 3, '33');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (22, '优惠券管理', 4, '34,35,36,37,38,39');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (23, '专题管理', 4, '40,41,42,43,44');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (24, '团购管理', 4, '45,46,47,48,49');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (25, '广告管理', 4, '50,51,53,54,55');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (26, '通用问题', 5, '56,57,58,59');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (27, '关键词', 5, '60,61,62,63,64');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (28, '品牌管理', 5, '65,66,67,68,69,70');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (29, '订单管理', 5, '71,72,73,74,75');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (30, '类目管理', 5, '76,77,78,79,80');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (31, '商场配置', 6, '81,82');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (32, '运费配置', 6, '83,84');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (33, '订单配置', 6, '85,86');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (34, '小程序配置', 6, '87,88');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (35, '权限测试', 7, '89,90');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (36, '用户统计', 8, '91');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (37, '订单统计', 8, '92');
INSERT INTO `cskaoyan_mall_system_permissions` VALUES (38, '商品统计', 8, '93');

-- ----------------------------
-- Table structure for system_permission
-- ----------------------------
DROP TABLE IF EXISTS `system_permission`;
CREATE TABLE `system_permission`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permission_id` int(11) NULL DEFAULT NULL,
  `system_id` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_permission
-- ----------------------------
INSERT INTO `system_permission` VALUES (1, 2, 9);
INSERT INTO `system_permission` VALUES (2, 3, 9);
INSERT INTO `system_permission` VALUES (3, 4, 10);
INSERT INTO `system_permission` VALUES (4, 5, 10);
INSERT INTO `system_permission` VALUES (5, 6, 10);
INSERT INTO `system_permission` VALUES (6, 7, 10);
INSERT INTO `system_permission` VALUES (7, 8, 10);
INSERT INTO `system_permission` VALUES (8, 9, 12);
INSERT INTO `system_permission` VALUES (9, 10, 13);
INSERT INTO `system_permission` VALUES (10, 11, 14);
INSERT INTO `system_permission` VALUES (11, 12, 15);
INSERT INTO `system_permission` VALUES (12, 13, 16);
INSERT INTO `system_permission` VALUES (13, 14, 17);
INSERT INTO `system_permission` VALUES (14, 15, 18);
INSERT INTO `system_permission` VALUES (15, 16, 18);
INSERT INTO `system_permission` VALUES (16, 17, 18);
INSERT INTO `system_permission` VALUES (17, 18, 18);
INSERT INTO `system_permission` VALUES (18, 19, 18);
INSERT INTO `system_permission` VALUES (19, 20, 18);
INSERT INTO `system_permission` VALUES (20, 21, 18);
INSERT INTO `system_permission` VALUES (21, 23, 19);
INSERT INTO `system_permission` VALUES (22, 24, 19);
INSERT INTO `system_permission` VALUES (23, 25, 19);
INSERT INTO `system_permission` VALUES (24, 26, 19);
INSERT INTO `system_permission` VALUES (25, 27, 19);
INSERT INTO `system_permission` VALUES (26, 28, 20);
INSERT INTO `system_permission` VALUES (27, 29, 20);
INSERT INTO `system_permission` VALUES (28, 30, 20);
INSERT INTO `system_permission` VALUES (29, 31, 20);
INSERT INTO `system_permission` VALUES (30, 32, 20);
INSERT INTO `system_permission` VALUES (31, 33, 21);
INSERT INTO `system_permission` VALUES (32, 34, 22);
INSERT INTO `system_permission` VALUES (33, 35, 22);
INSERT INTO `system_permission` VALUES (34, 36, 22);
INSERT INTO `system_permission` VALUES (35, 37, 22);
INSERT INTO `system_permission` VALUES (36, 38, 22);
INSERT INTO `system_permission` VALUES (37, 39, 22);
INSERT INTO `system_permission` VALUES (38, 40, 23);
INSERT INTO `system_permission` VALUES (39, 41, 23);
INSERT INTO `system_permission` VALUES (40, 42, 23);
INSERT INTO `system_permission` VALUES (41, 43, 23);
INSERT INTO `system_permission` VALUES (42, 44, 23);
INSERT INTO `system_permission` VALUES (43, 45, 24);
INSERT INTO `system_permission` VALUES (44, 46, 24);
INSERT INTO `system_permission` VALUES (45, 47, 24);
INSERT INTO `system_permission` VALUES (46, 48, 24);
INSERT INTO `system_permission` VALUES (47, 49, 24);
INSERT INTO `system_permission` VALUES (48, 50, 25);
INSERT INTO `system_permission` VALUES (49, 51, 25);
INSERT INTO `system_permission` VALUES (50, 53, 25);
INSERT INTO `system_permission` VALUES (51, 54, 25);
INSERT INTO `system_permission` VALUES (52, 55, 25);
INSERT INTO `system_permission` VALUES (53, 56, 26);
INSERT INTO `system_permission` VALUES (54, 57, 26);
INSERT INTO `system_permission` VALUES (55, 58, 26);
INSERT INTO `system_permission` VALUES (56, 59, 26);
INSERT INTO `system_permission` VALUES (57, 60, 27);
INSERT INTO `system_permission` VALUES (58, 61, 27);
INSERT INTO `system_permission` VALUES (59, 62, 27);
INSERT INTO `system_permission` VALUES (60, 63, 27);
INSERT INTO `system_permission` VALUES (61, 64, 27);
INSERT INTO `system_permission` VALUES (62, 65, 28);
INSERT INTO `system_permission` VALUES (63, 66, 28);
INSERT INTO `system_permission` VALUES (64, 67, 28);
INSERT INTO `system_permission` VALUES (65, 69, 28);
INSERT INTO `system_permission` VALUES (66, 70, 28);
INSERT INTO `system_permission` VALUES (67, 71, 29);
INSERT INTO `system_permission` VALUES (68, 72, 29);
INSERT INTO `system_permission` VALUES (69, 73, 29);
INSERT INTO `system_permission` VALUES (70, 74, 29);
INSERT INTO `system_permission` VALUES (71, 75, 29);
INSERT INTO `system_permission` VALUES (72, 76, 30);
INSERT INTO `system_permission` VALUES (73, 77, 30);
INSERT INTO `system_permission` VALUES (74, 78, 30);
INSERT INTO `system_permission` VALUES (75, 79, 30);
INSERT INTO `system_permission` VALUES (76, 80, 30);
INSERT INTO `system_permission` VALUES (77, 81, 31);
INSERT INTO `system_permission` VALUES (78, 82, 31);
INSERT INTO `system_permission` VALUES (79, 83, 32);
INSERT INTO `system_permission` VALUES (80, 84, 32);
INSERT INTO `system_permission` VALUES (81, 85, 33);
INSERT INTO `system_permission` VALUES (82, 86, 33);
INSERT INTO `system_permission` VALUES (83, 87, 34);
INSERT INTO `system_permission` VALUES (84, 88, 34);
INSERT INTO `system_permission` VALUES (85, 89, 35);
INSERT INTO `system_permission` VALUES (86, 90, 35);
INSERT INTO `system_permission` VALUES (87, 91, 36);
INSERT INTO `system_permission` VALUES (88, 92, 37);
INSERT INTO `system_permission` VALUES (89, 93, 38);

SET FOREIGN_KEY_CHECKS = 1;
