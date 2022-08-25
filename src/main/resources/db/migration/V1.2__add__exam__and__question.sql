CREATE TABLE `exam`
(
    id             bigint(20) unsigned NOT NULL AUTO_INCREMENT comment '自增 ID',
    name           varchar(20)         not null comment '试卷名称',
    teacher_num    varchar(50)         not null comment '教师编号',
    `created_date` datetime DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    `updated_date` datetime DEFAULT NULL comment '修改时间',
    PRIMARY KEY (`id`)
);

CREATE TABLE `question`
(
    id             bigint(20) unsigned NOT NULL AUTO_INCREMENT comment '自增 ID',
    exam_id        bigint(20) unsigned not null comment '试卷 ID',
    content        varchar(50)         not null comment '题目内容',
    expected_value varchar(50)         not null comment '预期答案',
    `created_date` datetime DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    `updated_date` datetime DEFAULT NULL comment '修改时间',
    PRIMARY KEY (`id`)
);