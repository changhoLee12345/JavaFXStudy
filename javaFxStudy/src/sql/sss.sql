SELECT *
FROM   tab;

SELECT *
FROM   user_temp;

DELETE FROM user_temp
WHERE  user_id is null;

CREATE TABLE user_temp(user_id VARCHAR2(100)
                      ,user_name VARCHAR2(200)
                      ,user_pass VARCHAR2(100)
                      ,user_phone VARCHAR2(20)
                      ,user_gender VARCHAR2(10));

INSERT INTO user_temp
VALUES
    ('user2'
    ,'user_name2'
    ,'12342'
    ,'user_phone2'
    ,'¿©¼º¼º');

SELECT *
FROM   fileboard
ORDER  BY 1;

DELETE FROM fileboard;

SELECT e.employee_id eid
      ,p.employee_id pid
      ,p.emp_id
FROM   employees e
      ,emp       p
WHERE  e.employee_id = p.emp_id(+)
ORDER  BY e.employee_id;

SELECT e.employee_id eid
      ,p.employee_id pid
      ,p.emp_id
FROM   employees e
LEFT   OUTER JOIN emp p
ON     e.employee_id = p.emp_id
ORDER  BY e.employee_id;

DELETE FROM emp
WHERE  employee_id > 200;

ALTER TABLE emp add emp_id NUMBER;
UPDATE emp
SET    emp_id = employee_id;

INSERT INTO emp
    SELECT e.*
          ,101
    FROM   employees e
    WHERE  employee_id > 200;

CREATE TABLE emp_temp AS
    SELECT *
    FROM   employees;

SELECT *
FROM   emp
ORDER  BY 1;

SELECT *
FROM   schedule;

DELETE FROM schedule
WHERE  title = title;

INSERT INTO schedule
VALUES
    ('title'
    ,'appointIme'
    ,'mmeplace'
    ,'test....');
drop TABLE schedule purge;
CREATE TABLE schedule(title VARCHAR2(100)
                     ,appoint_time VARCHAR2(100)
                     ,meeting_place VARCHAR2(100)
                     ,content VARCHAR2(500));

SELECT *
FROM   book;

drop TABLE book purge;
CREATE TABLE book(book_no NUMBER
                 ,book_name VARCHAR2(100)
                 ,book_author VARCHAR2(100)
                 ,book_cont VARCHAR2(1000)
                 ,book_price NUMBER
                 ,book_rating NUMBER);
SELECT *
FROM   book;

SELECT *
FROM   comments;

DELETE FROM comments;

SELECT *
FROM   id_repository;

UPDATE id_repository
SET    VALUE = 0;

INSERT INTO id_repository
VALUES
    (0
    ,'COMMENT');

-- Create table
CREATE TABLE comments(id VARCHAR2(10)
                     ,NAME VARCHAR2(100)
                     ,content VARCHAR2(300)) tablespace users pctfree 10 initrans 1 maxtrans 255 storage(initial 64k NEXT 1m
                                                                                                         minextents 1
                                                                                                         maxextents
                                                                                                         unlimited);

-- Create table
CREATE TABLE id_repository(VALUE NUMBER
                          ,NAME VARCHAR2(30)) tablespace users pctfree 10 initrans 1 maxtrans 255 storage(initial 64k NEXT 1m
                                                                                                          minextents 1
                                                                                                          maxextents
                                                                                                          unlimited);

drop TABLE product purge;
CREATE TABLE product(item_no VARCHAR2(20) primary key
                    ,item VARCHAR2(100)
                    ,category VARCHAR2(10)
                    ,price NUMBER
                    ,link VARCHAR2(50)
                    ,content VARCHAR2(1000)
                    ,like_it NUMBER
                    ,alt VARCHAR2(100)
                    ,image VARCHAR2(100));

SELECT *
FROM   product
FOR    UPDATE;
