-- auto-generated definition
CREATE TABLE s_user
(
  id               INT AUTO_INCREMENT
  COMMENT '主键，用户id'
    PRIMARY KEY,
  user_name        VARCHAR(50)                         NOT NULL
  COMMENT '用户名',
  password         VARCHAR(128)                        NOT NULL
  COMMENT '密码md5',
  create_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '创建时间',
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '最后更新时间'
)
  COMMENT 'springboot 集成 shiro 用user表';

-- password: 123456
INSERT INTO hanif.s_user (user_name, password) VALUES ('hanif', '95bdb67f4ac0a47e020f29cd59e8f0c7');
INSERT INTO hanif.s_user (user_name, password) VALUES ('alice', 'a5aec45bc54bc1eefad14697e89713ab');


-- auto-generated definition
CREATE TABLE s_role
(
  id               INT AUTO_INCREMENT
  COMMENT '主键,角色id'
    PRIMARY KEY,
  role_name        VARCHAR(50)                         NOT NULL
  COMMENT '角色名',
  user_id          INT                                 NOT NULL
  COMMENT '用户id',
  create_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '创建时间',
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '最后更新时间',
  CONSTRAINT fk_role_user
  FOREIGN KEY (user_id) REFERENCES s_user (id)
)
  COMMENT 'springboot 集成 shiro 用role表';
CREATE INDEX fk_role_user
  ON s_role (user_id);

INSERT INTO hanif.s_role (role_name, user_id) VALUES ('admin', 1);
INSERT INTO hanif.s_role (role_name, user_id) VALUES ('guest', 2);


-- auto-generated definition
CREATE TABLE s_permission
(
  id               INT AUTO_INCREMENT
  COMMENT '主键，权限id'
    PRIMARY KEY,
  permission       VARCHAR(128)                        NOT NULL
  COMMENT '操作权限',
  role_id          INT                                 NOT NULL
  COMMENT '角色id',
  create_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '创建时间',
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '最后更新时间',
  CONSTRAINT fk_permission_role
  FOREIGN KEY (role_id) REFERENCES s_role (id)
)
  COMMENT 'springboot 集成 shiro 用permission表';
CREATE INDEX fk_permission_role
  ON s_permission (role_id);

INSERT INTO hanif.s_permission (permission, role_id) VALUES ('create', 1);
INSERT INTO hanif.s_permission (permission, role_id) VALUES ('delete', 1);
INSERT INTO hanif.s_permission (permission, role_id) VALUES ('update', 1);
INSERT INTO hanif.s_permission (permission, role_id) VALUES ('query', 1);
INSERT INTO hanif.s_permission (permission, role_id) VALUES ('query', 2);
INSERT INTO hanif.s_permission (permission, role_id) VALUES ('create', 2);