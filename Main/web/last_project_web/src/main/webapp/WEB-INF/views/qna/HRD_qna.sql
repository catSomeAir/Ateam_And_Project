/*상위카테고리*/
create table category_large (
id     number constraint category_id_pk primary key,
title  varchar2(100) not null
);
create sequence seq_category_large start with 1 increment by 1 nocache;
create or replace trigger trg_category_large
  before insert on category_large
  for each row
begin
  select seq_category_large.nextval into :new.id from dual;
end;
/
insert into category_large (title) values ('질문과 답변'); --1
insert into category_large (title) values ('개선 및 제안'); --2
insert into category_large (title) values ('자주묻는 질문'); --3

/*분야*/
create table category_medium (
id         number,
title      varchar2(300) not null,
large_id   number,
constraint medium_id_pk primary key(id),
constraint medium_large_id_fk foreign key(large_id) 
                references category_large(id)
);

create sequence seq_category_medium start with 1 increment by 1 nocache;
create or replace trigger trg_category_medium
  before insert on category_medium
  for each row
begin
  select seq_category_medium.nextval into :new.id from dual;
end;
/

select * from category_large;

insert into category_medium(title, large_id)
values ('실업자계좌제훈련/훈련상담/실업자국기직종훈련/국민내일배움카드/K-디지털트레이닝', 1);
insert into category_medium(title, large_id)
values ('근로자훈련/국민내일배움카드/K-디지털기초역량/중장년새출발카운슬링', 1);
insert into category_medium(title, large_id)
values ('사업주지원훈련/지역실업자/지산일', 1);
insert into category_medium(title, large_id)
values ('일학습병행제/과정평가형<', 1);
insert into category_medium(title, large_id)
values ('컨소시엄훈련/지역산업맞춤형/고용디딤돌/청년취업아카데미', 1);
insert into category_medium(title, large_id)
values ('지도점검/부정수급/전자민원서비스', 1);
insert into category_medium(title, large_id)
values ('HRD-Net 홈페이지/모바일 서비스/전자민원/지도점검/부정수급', 1);
insert into category_medium(title, large_id)
values ('통합심사/이수자평가/인증평가/훈련교사', 1);
commit;

insert into category_medium(title, large_id)
values ('프로그램 개선사항', 2);
insert into category_medium(title, large_id)
values ('제안', 2);

insert into category_medium(title, large_id)
values ('실업자/고용촉진', 3);
insert into category_medium(title, large_id)
values ('재직자', 3);
insert into category_medium(title, large_id)
values ('훈련기관 업무관련', 3);
insert into category_medium(title, large_id)
values ('공인인증서 안내', 3);
insert into category_medium(title, large_id)
values ('로그인/탈퇴', 3);
insert into category_medium(title, large_id)
values ('사업주훈련', 3);
insert into category_medium(title, large_id)
values ('기타', 3);
commit;

/*질문*/
create table qna (
id         number constraint qna_id_pk primary key,
title      varchar2(1000) not null,
content    varchar2(4000) not null,
writer     varchar2(50) constraint qna_writer_fk 
                          references member(userid) on delete cascade,
writedate  date default sysdate,
readcnt    number default 0,
field      number constraint qna_field_fk /*질문분야*/
                          references category_medium(id) on delete set null,
open       number default 0 /*0:공개, 1:비공개*/,
filepath   varchar2(1000)
);


create sequence seq_qna start with 1 increment by 1 nocache;
create or replace trigger trg_qna
  before insert on qna
  for each row
begin
  select seq_qna.nextval into :new.id from dual;
end;
/

/*답변*/
create table qna_answer (
id         number constraint qna_answer_id_pk primary key,
content    varchar2(4000) not null,
writer     varchar2(50) constraint qna_answer_writer_fk 
                          references member(userid) on delete set null,
writedate  date default sysdate,
qna_id     number constraint qna_answer_id_fk references qna(id) on delete cascade
);


desc qna_answer;

create sequence seq_qna_answer start with 1 increment by 1 nocache;
create or replace trigger trg_qna_answer
  before insert on qna_answer
  for each row
begin
  select seq_qna_answer.nextval into :new.id from dual;
end;
/



select row_number() over(order by id) no, name
		, (select decode( count(*), 0, '접수', '완료' ) 
			from qna_answer a where a.qna_id=q.id) status
		, q.* 
from qna q left outer join member m on q.writer=m.userid
order by no desc ;

select name, c.title field_title, q.* 
from qna q left outer join member m on q.writer=m.userid
left outer join category_medium c on q.field=c.id
;
select * from qna_answer;
