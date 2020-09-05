SELECT *
FROM   tab;

SELECT *
FROM   book;

-- 도서정보.
drop TABLE book purge;
CREATE TABLE book(book_title VARCHAR2(100)
                 ,author VARCHAR2(100)
                 ,press VARCHAR2(100)
                 ,press_date VARCHAR2(10)
                 ,price NUMBER
                 ,isbn VARCHAR2(12)
                 ,creation_date DATE DEFAULT SYSDATE);

-- 도서수량정보
drop TABLE book_onhand_info purge;
CREATE TABLE book_onhand_info(book_no NUMBER primary key
                             ,isbn VARCHAR2(12)
                             ,library_receipt_date DATE
                             ,on_receipt_price NUMBER
                             ,creation_date        DATE DEFAULT SYSDATE);

-- 도서입출정보
drop TABLE book_io_info purge;
CREATE TABLE book_io_info(book_no NUMBER
                         ,in_out_flag CHAR(1)
                         ,check_in_out_date DATE
                         ,due_date DATE
                         ,over_due_fare NUMBER
                         ,description VARCHAR2(100)
                         ,creation_date     DATE DEFAULT SYSDATE);

-- 회원정보
drop TABLE library_member_info purge;
CREATE TABLE library_member_info(member_id VARCHAR2(8) primary key
                                ,NAME VARCHAR2(100)
                                ,phone_no VARCHAR2(13)
                                ,creation_date DATE DEFAULT SYSDATE);
