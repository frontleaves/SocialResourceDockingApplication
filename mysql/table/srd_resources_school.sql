-- 学校数据库
-- srd_resources_school
create table srd_resources_school
(
    id              bigint unsigned auto_increment comment '学校主键'
        primary key,
    name            varchar(255) not null comment '学校名称',
    type            int unsigned null comment '学校类型',
    locate_province varchar(255) not null comment '省份',
    locate_city     varchar(255) not null comment '城市',
    locate_area     varchar(255) not null comment '所在地区',
    locate_lat      double       not null comment '所在纬度',
    locate_lng      double       not null comment '所在经度',
    created_at      timestamp    not null comment '创建时间',
    updated_at      timestamp    not null comment '更新时间',
    constraint srd_resources_school_srd_resources_school_type_id_fk
        foreign key (type) references srd_resources_school_type (id)
            on delete set null
)
    comment '学校数据库';