SELECT *
FROM   tab;

CREATE TABLE board(title VARCHAR2(100)
                  ,password VARCHAR2(100)
                  ,publicity VARCHAR2(30)
                  ,exit_date DATE
                  ,content VARCHAR2(1000));

INSERT INTO board
VALUES
    ('test'
    ,'test'
    ,'����'
    ,SYSDATE
    ,'�����Էµ�����');
INSERT INTO board
VALUES
    ('test2'
    ,'test'
    ,'�����'
    ,SYSDATE
    ,'�����Էµ�����2');
INSERT INTO board
VALUES
    ('test3'
    ,'test'
    ,'����'
    ,SYSDATE
    ,'�����Էµ�����3');

SELECT *
FROM   board;

CREATE TABLE admins(email VARCHAR2(30)
                   ,password VARCHAR2(30));

INSERT INTO admins
VALUES
    ('admin'
    ,'admin');
