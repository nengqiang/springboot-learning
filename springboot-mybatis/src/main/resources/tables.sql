-- auto-generated definition
CREATE TABLE t_manage_employee
(
  id               INT(10) UNSIGNED AUTO_INCREMENT
  COMMENT '主键'
    PRIMARY KEY,
  emp_id           INT(10) UNSIGNED                    NOT NULL
  COMMENT '员工编号',
  emp_name         VARCHAR(20)                         NULL
  COMMENT '员工姓名',
  gender           CHAR                                NULL
  COMMENT '员工性别',
  email            VARCHAR(50)                         NULL
  COMMENT '员工邮箱',
  dept_id          INT(10) UNSIGNED                    NOT NULL
  COMMENT '员工部门编号',
  create_time      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '创建时间',
  last_update_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '最后修改时间',
  CONSTRAINT uk_emp_id
  UNIQUE (emp_id)
)
  COMMENT '员工管理系统员工信息表';
CREATE INDEX idx_emp_id
  ON t_manage_employee (emp_id);
