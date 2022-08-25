CREATE TABLE `exam_record`
(
    id             bigint(20) unsigned NOT NULL AUTO_INCREMENT comment '自增 ID',
    exam_id        bigint(20) unsigned not null comment '试卷 ID',
    stu_num        varchar(20)         not null comment '学号',
    score          decimal(10, 2)      not null comment '考试成绩',
    `created_date` datetime DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    `updated_date` datetime DEFAULT NULL comment '修改时间',
    PRIMARY KEY (`id`)
);

CREATE TABLE `answer_record`
(
    id             bigint(20) unsigned NOT NULL AUTO_INCREMENT comment '自增 ID',
    exam_record_id bigint(20) unsigned not null comment '考试 ID',
    question_id    bigint(20) unsigned not null comment '题目 ID',
    expected_value varchar(50)         not null comment '正确答案',
    answer_value   varchar(50)         not null comment '作答答案',
    `created_date` datetime DEFAULT CURRENT_TIMESTAMP comment '创建时间',
    `updated_date` datetime DEFAULT NULL comment '修改时间',
    PRIMARY KEY (`id`)
);