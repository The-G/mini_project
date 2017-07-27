
/* Drop Tables */

DROP TABLE keyword CASCADE CONSTRAINTS;
DROP TABLE movie_comment CASCADE CONSTRAINTS;
DROP TABLE movie CASCADE CONSTRAINTS;



/* Drop Sequences */

DROP SEQUENCE seq_movie;




/* Create Sequences */

CREATE SEQUENCE seq_movie;



/* Create Tables */

CREATE TABLE keyword
(
	keyword_ko varchar2(2000) NOT NULL,
	count number,
	keyword_jp varchar2(2000),
	keyword_en varchar2(2000),
	keyword_ch varchar2(2000),
	movie_id number NOT NULL
);


CREATE TABLE movie
(
	movie_id number NOT NULL,
	name varchar2(400) NOT NULL,
	release_date date NOT NULL,
	director varchar2(1000),
	crawling_daum_id number UNIQUE,
	img_url varchar2(4000),
	daum_info_link varchar2(4000),
	PRIMARY KEY (movie_id)
);


CREATE TABLE movie_comment
(
	url varchar2(2000),
	nickname varchar2(1000),
	score number,
	content varchar2(4000) UNIQUE,
	movie_id number NOT NULL
);



/* Create Foreign Keys */

ALTER TABLE keyword
	ADD FOREIGN KEY (movie_id)
	REFERENCES movie (movie_id)
;


ALTER TABLE movie_comment
	ADD FOREIGN KEY (movie_id)
	REFERENCES movie (movie_id)
;


select * from MOVIE_COMMENT;

SELECT nickname, score, content, movie_id
FROM   MOVIE_COMMENT
WHERE movie_id = 2;


select * from movie;
select * from MOVIE_COMMENT;


SELECT  nickname, score, content, movie_id
FROM    MOVIE_COMMENT
WHERE   movie_id = 127 and content is not null;

select * from KEYWORD;

INSERT INTO KEYWORD(keyword_ko, movie_id)
values('킹왕짱',1);


<<<<<<< HEAD
SELECT MOVIE_ID, NAME, RELEASE_DATE, CRAWLING_DAUM_ID, IMG_URL, DAUM_INFO_LINK
FROM   MOVIE
WHERE name LIKE '%스파이더맨%';


SELECT MOVIE_ID, NAME, RELEASE_DATE, CRAWLING_DAUM_ID, IMG_URL, DAUM_INFO_LINK
FROM   bigdata.MOVIE
WHERE name LIKE '%' || '스파이더맨' || '%';
		
-- Movie table
--MOVIE_ID 
--NAME
--RELEASE_DATE
--DIRECTOR 
--CRAWLING_DAUM_ID 
--IMG_URL
--DAUM_INFO_LINK

select keyword_ko from keyword where keyword_en is null;
select * from keyword;
commit
=======
>>>>>>> 1073de95a03fa81251d5bbe9490c9c3f5dfb4055
