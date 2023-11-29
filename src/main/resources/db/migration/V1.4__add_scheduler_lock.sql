CREATE TABLE `scheduler_lock`
(
    id          bigint(20) unsigned NOT NULL AUTO_INCREMENT comment '自增 ID',
    name        varchar(20)         not null comment '学号',
    `execution_time` datetime DEFAULT CURRENT_TIMESTAMP comment '任务可执行事件',
    PRIMARY KEY (`id`)
) ;

insert into scheduler_lock (name, execution_time) values ('test1', now());
insert into scheduler_lock (name, execution_time) values ('test2', now());