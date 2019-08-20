DROP TABLE NORMAL_BOARD;

DROP SEQUENCE BOARDSEQ;

CREATE SEQUENCE BOARDSEQ;

CREATE TABLE NORMAL_BOARD(
	
	NORMAL_NUM NUMBER PRIMARY KEY,
	USER_NUM NUMBER NOT NULL,
	USER_NICKNAME VARCHAR2(100) NOT NULL,
	NORMAL_TITLE VARCHAR2(250) NOT NULL,
	NORMAL_CONTENT VARCHAR2(4000) NOT NULL,
	NORMAL_CATEGORY VARCHAR2(50) NOT NULL,
	NORMAL_COUNT NUMBER NOT NULL,
	NORMAL_DATE_CREATE DATE NOT NULL,
	NORMAL_DATE_UPDATE DATE NULL,
	NORMAL_PREMIUM VARCHAR2(2) NULL,
	
	CONSTRAINT PAY_CHK_NORMAL_PREMIUM CHECK(NORMAL_PREMIUM IN ('Y','N')),
	
	CONSTRAINT USER_FK FOREIGN KEY (USER_NUM) REFERENCES USER_INFO(USER_NUM)
	);

SELECT * FROM NORMAL_BOARD;
DROP TABLE COMMENT_BOARD;

DROP SEQUENCE GROUPSQ;


	
SELECT * FROM NORMAL_BOARD WHERE NORMAL_CATEGORY = 'CREW';
