-- 项目孵化
-- srd_incubation
create table srd_incubation
(
    id         bigint unsigned auto_increment comment '主键'
        primary key,
    user_id    bigint unsigned                     not null comment '用户主键',
    name       varchar(50)                         not null comment '项目名称',
    type       int unsigned                        not null comment '类别',
    `desc`     longtext                            not null comment '详细描述',
    state      tinyint   default 0                 not null comment '当前状态',
    company    bigint unsigned                     null comment '签约企业',
    contract   text                                null comment '签约合同',
    mooney     int                                 null comment '经济',
    created_at timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                           null comment '修改时间',
    signing_at timestamp                           null comment '签名时间',
    constraint srd_incubation_srd_resources_organization_id_fk
        foreign key (company) references srd_resources_organization (id),
    constraint srd_incubation_srd_user_id_fk
        foreign key (user_id) references srd_user (id)
)
    comment '项目孵化';