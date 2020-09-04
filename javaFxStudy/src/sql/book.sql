select * from tab;


--도서정보.
drop table book purge;
create table book (
 book_title varchar2(100), --책제목
 author varchar2(100), --저자
 press varchar2(100), --출판사
 press_date varchar2(10), --출판일자
 price number, --가격
 isbn varchar2(12), --P20200504001
 creation_date date --생성일자.
);


