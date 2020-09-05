SELECT *
FROM   tab;

SELECT *
FROM   book;

--도서정보.
drop TABLE book purge;
CREATE TABLE book(book_title VARCHAR2(100), --책제목
                  author VARCHAR2(100), --저자
                  press VARCHAR2(100), --출판사
                  press_date VARCHAR2(10), --출판일자
                  price NUMBER, --가격
                  isbn VARCHAR2(12), --P20200504001
                  creation_date DATE default sysdate --생성일자.
                  );
