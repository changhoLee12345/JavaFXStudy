select * from tab;


--��������.
drop table book purge;
create table book (
 book_title varchar2(100), --å����
 author varchar2(100), --����
 press varchar2(100), --���ǻ�
 press_date varchar2(10), --��������
 price number, --����
 isbn varchar2(12), --P20200504001
 creation_date date --��������.
);


