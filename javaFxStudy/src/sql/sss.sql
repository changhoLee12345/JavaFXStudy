SELECT *
FROM   tab;

SELECT *
FROM   book;

drop table book purge;
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
FROM   product;
