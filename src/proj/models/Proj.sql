
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