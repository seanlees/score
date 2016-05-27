/*
 v1.0.0 新增消费记录表和消费记录表权限
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for rechargeinfo
-- ----------------------------
DROP TABLE IF EXISTS `rechargeinfo`;
CREATE TABLE `rechargeinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `rechargeMoney` decimal(10,2) DEFAULT NULL,
  `cardNo` varchar(255) DEFAULT NULL,
  `customerName` varchar(255) DEFAULT NULL,
  `rechargeOperator` varchar(255) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `rechargeDate` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `freeMoney` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- 插入资源
INSERT INTO `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) VALUES ('64', '会员充值', '65', 'sys_customer_recharge', '1', '/background/recharge/addUI.html', '58', '会员充值');
INSERT INTO `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) VALUES ('65', '会员充值管理', '1010', 'sys_recharge_manager', '0', 'recharge', '59', '会员充值管理');
INSERT INTO `resources` (`id`, `name`, `parentId`, `resKey`, `type`, `resUrl`, `level`, `description`) VALUES ('66', '充值记录', '65', 'sys_recharge_list', '1', '/background/recharge/query.html', '59', '充值记录');

-- 插入权限
INSERT INTO `resources_role` (`resc_id`, `role_id`) VALUES ('64', '1');
INSERT INTO `resources_role` (`resc_id`, `role_id`) VALUES ('65', '1');
INSERT INTO `resources_role` (`resc_id`, `role_id`) VALUES ('66', '1');

