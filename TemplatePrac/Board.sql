CREATE TABLE managerhj
(
   NO INT(3) PRIMARY KEY AUTO_INCREMENT,
   age INT(3)  NULL ,
   NAME VARCHAR(100) NULL ,
   part VARCHAR(100)  NULL 
);

CREATE TABLE professorhj
(
   NO INT(3) PRIMARY KEY AUTO_INCREMENT,
   age INT(3)  NULL ,
   NAME VARCHAR(100)  NULL ,
   SUBJECT VARCHAR(100)  NULL 
);


CREATE TABLE studenthj
(
   NO INT(3) PRIMARY KEY AUTO_INCREMENT,
   age INT(3)  NULL,
   NAME VARCHAR(100)  NULL,
   hakbun INT(4)  NULL 
);

CREATE TABLE boardhj(
  NO INT AUTO_INCREMENT,
  title VARCHAR(100),
  content VARCHAR(500),
  author VARCHAR(100),
  nal VARCHAR(10),
  readcount INT,
  PRIMARY KEY (NO)
)

DROP TABLE student;
DROP TABLE manager;
DROP TABLE professor;
drop table boardhj;

SELECT * FROM studenthj;
SELECT * FROM managerhj;
SELECT * FROM professorhj;
select * from boardhj;
