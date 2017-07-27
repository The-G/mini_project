
/* Drop Tables */

DROP TABLE member CASCADE CONSTRAINTS;

select * from member;


/* Create Tables */

CREATE TABLE member
(
	name varchar2(10),
	userid varchar2(10) NOT NULL,
	pwd varchar2(10) NOT NULL,
	nickname varchar2(20) NOT NULL,
	email varchar2(20),
	phone char(13),
	worstMovie varchar2(20),
	gender number(1),
	receiveEmail number(1),
	receiveSms number(1),
	PRIMARY KEY (userid)
);



