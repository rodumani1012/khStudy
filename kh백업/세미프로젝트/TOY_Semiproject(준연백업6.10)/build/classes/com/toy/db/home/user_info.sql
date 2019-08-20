DROP
	TABLE
		USER_INFO;

DROP
	SEQUENCE USERSEQ;

CREATE
	SEQUENCE USERSEQ;

CREATE
	TABLE
		USER_INFO( USER_NUM NUMBER PRIMARY KEY,
		USER_ID VARCHAR2(100) NOT NULL UNIQUE,
		USER_PW VARCHAR2(50),
		USER_NAME VARCHAR2(25) NOT NULL,
		USER_EMAIL VARCHAR2(100) NOT NULL,
		USER_NICKNAME VARCHAR2(50) NOT NULL,
		USER_ENABLED VARCHAR2(2) DEFAULT 'N',
		USER_GRADE VARCHAR2(10) DEFAULT 'USER',
		USER_DATE_CREATE DATE NOT NULL,
		USER_DATE_UPDATE DATE,
		CONSTRAINT CHECK_ENABLED CHECK(USER_ENABLED IN ('Y',
		'N')),
		CONSTRAINT CHECK_GRADE CHECK(USER_GRADE IN ('ADMIN',
		'USER')) );

INSERT
	INTO
		USER_INFO
	VALUES(USERSEQ.NEXTVAL,
	'leegosoo11' ,
	'123',
	'위성빈',
	'leegosoo11@naver.com',
	'빈',
	'N',
	'USER',
	SYSDATE,
	NULL);
--INSERT
--	INTO
--		USER_INFO
--	VALUES(USERSEQ.NEXTVAL,
INSERT
	INTO
	USER_INFO
VALUES(USERSEQ.NEXTVAL,
--
--	'leegosoo11' ,
--	'123',
--	'위성빈',
--	'leegosoo11@naver.com',
--	'빈',
--	'song' ,
--	'123',
--	'송윤회',
--	'song@naver.com',
--	'개발자',
--
--	'N',
--	'USER',
--	SYSDATE,
--	NULL);
	'song' ,
	'123',
'송윤회',
	'song@naver.com',
	'개발자',
--
'N',
	'USER',
	SYSDATE,
	NULL);

	
SELECT
	*
FROM
	USER_INFO;