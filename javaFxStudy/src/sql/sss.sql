SELECT *
FROM   employees;

SELECT e.employee_id
      ,e.first_name
      ,e.last_name
      ,e.email
      ,d.department_name
FROM   employees   e
      ,departments d
WHERE  e.department_id = d.department_id
AND    d.department_name = #{department_name};

SELECT *
FROM   departments;

SELECT *
FROM   jobs;
SELECT *
FROM   admins;

SELECT *
FROM   users;

SELECT *
FROM   tab;

SELECT *
FROM   board
ORDER  BY 1;

SELECT *
FROM   b_board
ORDER  BY 1;

CREATE TABLE b_board(id VARCHAR2(10)
                    ,passwd VARCHAR2(20)
                    ,NAME VARCHAR2(30));

SELECT id       "id"
       ,password "password"
       ,NAME     "name"
       ,role     "role"
FROM   b_users;

SELECT *
FROM   b_users;

INSERT INTO b_users
VALUES
    ('user1'
    ,'user1'
    ,'user1'
    ,'user');
INSERT INTO b_users
VALUES
    ('user2'
    ,'user2'
    ,'user2'
    ,'user');

SELECT *
FROM   users; -- busersVO
