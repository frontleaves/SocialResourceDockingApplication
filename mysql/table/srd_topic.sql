-- 话题
-- srd_topic
create table srd_topic
(
    id         bigint unsigned auto_increment comment '主键'
        primary key,
    user_id    bigint unsigned                     null comment '话题创建人（RAM用户创建以主用户为准）',
    name       varchar(20)                         not null comment '话题名字',
    created_at timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                           null comment '修改时间',
    constraint srd_topic_srd_user_id_fk
        foreign key (user_id) references srd_user (id)
            on delete set null
)
    comment '话题';