SELECT *
FROM   tab;

SELECT *
FROM   book;

--��������.
drop TABLE book purge;
CREATE TABLE book(book_title VARCHAR2(100), --å����
                  author VARCHAR2(100), --����
                  press VARCHAR2(100), --���ǻ�
                  press_date VARCHAR2(10), --��������
                  price NUMBER, --����
                  isbn VARCHAR2(12), --P20200504001
                  creation_date DATE default sysdate --��������.
                  );
