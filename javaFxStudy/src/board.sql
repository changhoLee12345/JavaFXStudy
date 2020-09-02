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

CREATE TABLE admins(email VARCHAR2(30)
                   ,password VARCHAR2(30));

INSERT INTO admins
VALUES
    ('admin'
    ,'admin');
