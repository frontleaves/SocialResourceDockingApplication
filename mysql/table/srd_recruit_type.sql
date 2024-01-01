-- 招募类型
-- srd_recruit_type
create table srd_recruit_type
(
    id         int unsigned auto_increment comment '主键'
        primary key,
    user_id    bigint unsigned                     null comment '词条创建者',
    name       varchar(20)                         not null comment '词条名字',
    created_at timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                           null comment '修改时间',
    constraint srd_recruit_type_srd_user_id_fk
        foreign key (user_id) references srd_user (id)
            on delete set null
)
    comment '招募类型';