DROP
	TABLE
		PRJ_INFO;

DROP
	SEQUENCE PRJSEQ;



CREATE
	SEQUENCE PRJSEQ;

CREATE
	TABLE
		PRJ_INFO( PRJ_NUM NUMBER PRIMARY KEY,
		PRJ_NAME VARCHAR2(100) NOT NULL,
		PRJ_LOC VARCHAR2(500) NULL
		);

INSERT INTO PRJ_INFO VALUES(PRJSEQ.NEXTVAL, 'QQQQQQ', '경기도 안양시 만안구');
INSERT INTO PRJ_IN_USER VALUES(1,PRJSEQ.CURRVAL);

SELECT * FROM PRJ_INFO;

SELECT * FROM PRJ_INFO JOIN (SELECT PRJ_NUM FROM PRJ_IN_USER WHERE USER_NUM = 1) USING (PRJ_NUM);
