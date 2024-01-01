-- 题解模块
-- srd_solve_problem
create table srd_solve_problem
(
    id         bigint unsigned auto_increment comment '组件'
        primary key,
    user_id    bigint unsigned                     not null comment '用户主键',
    title      varchar(50)                         not null comment '题解标题',
    type       int unsigned                        null comment '题解类型',
    `desc`     longtext                            not null comment '题解描述',
    money      double    default 0                 not null comment '题解金额',
    solve_by   bigint unsigned                     null comment '解决用户',
    created_at timestamp default CURRENT_TIMESTAMP not null comment '创建时间',
    updated_at timestamp                           null comment '修改时间',
    solved_at  timestamp                           null comment '解决时间',
    constraint srd_solve_problem_srd_solve_problem_type_id_fk
        foreign key (type) references srd_solve_problem_type (id)
            on delete set null,
    constraint srd_solve_problem_srd_user_id_fk
        foreign key (solve_by) references srd_user (id),
    constraint srd_solve_problem_srd_user_id_fk_2
        foreign key (user_id) references srd_user (id)
)
    comment '题解模块';

