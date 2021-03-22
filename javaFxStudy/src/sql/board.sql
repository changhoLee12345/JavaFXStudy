SELECT *
FROM   tab;

SELECT *
FROM   b_users
ORDER  BY 1;

CREATE TABLE board(title VARCHAR2(100)
                  ,password VARCHAR2(100)
                  ,publicity VARCHAR2(30)
                  ,exit_date DATE
                  ,content VARCHAR2(1000));
INSERT INTO board
VALUES
    ('test'
    ,'test'
    ,'공개'
    ,SYSDATE
    ,'샘플입력데이터');
INSERT INTO board
VALUES
    ('test2'
    ,'test'
    ,'비공개'
    ,SYSDATE
    ,'샘플입력데이터2');
INSERT INTO board
VALUES
    ('test3'
    ,'test'
    ,'공개'
    ,SYSDATE
    ,'샘플입력데이터3');

SELECT *
FROM   board;

drop TABLE boards purge;
CREATE TABLE boards(board_no NUMBER primary key
                   ,title VARCHAR2(100)
                   ,content VARCHAR2(1000)
                   ,writer VARCHAR2(100)
                   ,creation_date DATE);
SELECT *
FROM   boards;

INSERT INTO boards
VALUES
    (3
    ,'test3'
    ,'test3'
    ,'test3'
    ,SYSDATE);

CREATE TABLE admins(email VARCHAR2(30)
                   ,password VARCHAR2(30));
INSERT INTO admins
VALUES
    ('admin'
    ,'admin');

CREATE TABLE student_info(std_id NUMBER primary key
                         ,std_name VARCHAR2(100)
                         ,std_age NUMBER
                         ,std_phone VARCHAR2(20)
                         ,std_score NUMBER);

INSERT INTO student_info
VALUES
    (1
    ,'hong'
    ,20
    ,'1111'
    ,NULL);
INSERT INTO student_info
VALUES
    (2
    ,'hwang'
    ,20
    ,'4444'
    ,NULL);
INSERT INTO student_info
VALUES
    (3
    ,'park'
    ,20
    ,'3333'
    ,NULL);
