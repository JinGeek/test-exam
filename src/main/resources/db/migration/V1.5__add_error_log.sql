CREATE TABLE `error_log`
(
    id             bigint(20) unsigned NOT NULL AUTO_INCREMENT comment '自增 ID',
    code        varchar(20)         not null comment '错误码',
    msg         varchar(5000)         not null comment '错误消息',
    `created_date` datetime DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    `updated_date` datetime DEFAULT NULL comment '修改时间',
    PRIMARY KEY (`id`)
);
