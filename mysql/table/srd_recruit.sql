-- 招募
-- srd_recruit
create table srd_recruit
(
    id          bigint unsigned auto_increment comment '组件'
        primary key,
    user_type   tinyint(1)                           not null comment '用户类型',
    user_id     bigint unsigned                      not null comment '用户主键',
    title       varchar(50)                          not null comment '招募标题',
    type        int unsigned                         null comment '招募类型',
    classify    json                                 null comment '分类',
    `desc`      longtext                             not null comment '招募描述',
    number      int        default 1                 not null comment '招募人数',
    recruited   json                                 null comment '已招入用户',
    price_type  tinyint(1) default 0                 not null comment '是否有金额',
    price_start int                                  not null comment '起始价格',
    price_end   int                                  not null comment '结束价格',
    created_at  timestamp  default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at  timestamp                            null comment '修改时间',
    constraint srd_recruit_srd_recruit_type_id_fk
        foreign key (type) references srd_recruit_type (id)
            on delete set null
)
    comment '招募';