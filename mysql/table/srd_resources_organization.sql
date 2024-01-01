-- 企业列表
-- srd_resources_organization
create table srd_resources_organization
(
    id                 bigint unsigned not null comment '企业主键'
        primary key,
    name               varchar(255)    not null comment '企业全名',
    code_credit        varchar(18)     not null comment '统一社会信用代码',
    code_agency        varchar(10)     null comment '组织机构代码',
    type               int unsigned    null comment '企业类型',
    company_created_at timestamp       not null comment '营业期限（起始）',
    company_updated_at timestamp       not null comment '营业期限（结束）',
    created_at         timestamp       not null comment '创建时间',
    updated_at         timestamp       not null comment '修改时间',
    constraint srd_resources_company_srd_resources_company_type_id_fk
        foreign key (type) references srd_resources_organization_type (id)
            on delete set null
)
    comment '企业列表';