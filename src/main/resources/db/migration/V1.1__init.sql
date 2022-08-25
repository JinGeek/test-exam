CREATE TABLE `actor`
(
    id             bigint(20) unsigned NOT NULL AUTO_INCREMENT comment '自增 ID',
    actor_id       varchar(50)         not null comment '用户 ID',
    phone          varchar(20)         not null comment '手机号',
    actor_type     varchar(8)          not null comment '用户类型',
    password       varchar(100)         not null comment '密码',
    `created_date` datetime DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    `updated_date` datetime DEFAULT NULL comment '修改时间',
    PRIMARY KEY (`id`)
);

CREATE TABLE `student`
(
    id             bigint(20) unsigned NOT NULL AUTO_INCREMENT comment '自增 ID',
    stu_num        varchar(50)         not null comment '学号',
    name           varchar(20)         not null comment '姓名',
    age            int(8)              not null comment '年龄',
    gender         varchar(8)          not null comment '性别',
    `created_date` datetime DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    `updated_date` datetime DEFAULT NULL comment '修改时间',
    PRIMARY KEY (`id`)
);


CREATE TABLE `teacher`
(
    id             bigint(20) unsigned NOT NULL AUTO_INCREMENT comment '自增 ID',
    teacher_num    varchar(50)         not null comment '教师编号',
    name           varchar(20)         not null comment '姓名',
    age            int(8)              not null comment '年龄',
    gender         varchar(8)          not null comment '性别',
    `created_date` datetime DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    `updated_date` datetime DEFAULT NULL comment '修改时间',
    PRIMARY KEY (`id`)
);