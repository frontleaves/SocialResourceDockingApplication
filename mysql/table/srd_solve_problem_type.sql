-- 题解类型
-- srd_solve_problem_type
create table srd_solve_problem_type
(
    id         int unsigned auto_increment
        primary key,
    name       varchar(20)                         not null comment '类型名字',
    `desc`     varchar(255)                        null comment '类型描述',
    created_at timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                           null comment '修改时间'
)
    comment '题解类型';