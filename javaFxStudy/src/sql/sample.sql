
SELECT *
FROM   tab;

SELECT *
FROM   fileboard;

CREATE TABLE fileboard(num NUMBER
                      ,author VARCHAR2(100)
                      ,title VARCHAR2(300)
                      ,filename VARCHAR2(300)
                      ,DAY VARCHAR2(20));

CREATE TABLE data_table(title VARCHAR2(100)
                       ,group_id NUMBER
                       ,start_date VARCHAR2(20)
                       ,end_date VARCHAR2(20));

CREATE TABLE emp AS
    SELECT *
    FROM   employees;

SELECT d.department_name
      ,COUNT(*) AS cnt
FROM   employees   e
      ,departments d
WHERE  e.department_id = d.department_id
GROUP  BY d.department_name;

CREATE TABLE admins(email VARCHAR2(30)
                   ,password VARCHAR2(30));

INSERT INTO admins
VALUES
    ('root'
    ,'root');

drop TABLE users purge;
CREATE TABLE users(id VARCHAR2(10)
                  ,first_name VARCHAR2(50)
                  ,last_name VARCHAR2(50)
                  ,email VARCHAR2(50)
                  ,gender VARCHAR2(10)
                  ,birth_date DATE);

CREATE sequence user_seq;

SELECT user_seq.nextval
FROM   dual;

INSERT INTO users
VALUES
    ('user1'
    ,'firstname'
    ,'lastname'
    ,'email'
    ,'Men'
    ,'2020/02/02');
INSERT INTO users
VALUES
    ('user2'
    ,'firstname2'
    ,'lastname2'
    ,'email2'
    ,'Men'
    ,'2011/02/02');
INSERT INTO users
VALUES
    ('user3'
    ,'firstname3'
    ,'lastname3'
    ,'email3'
    ,'Women'
    ,'2010/02/02');

UPDATE users
SET    id = 'user4'
WHERE  id IS NULL;

SELECT *
FROM   users;

DELETE FROM users
WHERE  id LIKE 'user%';
