DROP
	TABLE
		PROJECTBOARD;
		
		drop sequence projectseq;
		
		
	create sequence projectseq;	

CREATE
	TABLE
		PROJECTBOARD( 
		SEQ NUMBER PRIMARY KEY,
		MYNO VARCHAR2(100) NOT NULL,
		NAME VARCHAR2(100) NOT NULL,
		PW VARCHAR2(1000) NOT NULL,
		MONEY NUMBER NOT NULL );

SELECT * FROM PROJECTBOARD ORDER BY MYNO;

INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,1, '������', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,2, '������', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,3, '�����', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,4, '���ؿ�', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,5, '�ۿ���', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,6, '����ȸ', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,7, '��ġ��', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,8, '�ŵ���', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,9, '������', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,10, '�����', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,11, '���翵', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,12, '������', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,13, '������', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,14, '������', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,15, '�̽±�', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,16, '�̽¿�', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,17, '�̿���', '123123', 0);

INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,19, '������', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,20, '����ȣ', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,21, '������', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,22, '������', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,23, '���޳���', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,24, '������', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,25, '���ؿ�', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,26, '������', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,27, '������', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,28, 'ȫ����', '123123', 0);
INSERT INTO PROJECTBOARD VALUES(PROJECTSEQ.NEXTVAL,29, 'Ȳ���', '123123', 0);

