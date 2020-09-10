DROP TABLE IF EXISTS SHORT_URL;
DROP TABLE IF EXISTS CARD;
DROP TABLE IF EXISTS USER cascade;
DROP TABLE IF EXISTS GROUPMANAGER;

CREATE TABLE USER (
  userid BIGINT(5) AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(50),
  email VARCHAR(50),
  roleType VARCHAR(10),
  password VARCHAR(50)
);

CREATE TABLE GROUPMANAGER (
  groupid BIGINT(5) AUTO_INCREMENT  PRIMARY KEY,
  userid BIGINT(5),
  groupCategory VARCHAR(50),
  groupname VARCHAR(10),
  FOREIGN KEY(userid) REFERENCES USER(userid)
);
  
CREATE TABLE SHORT_URL (
  surlid BIGINT(5) AUTO_INCREMENT  PRIMARY KEY,
  userid BIGINT(5),
  longurl CLOB,
  dateofexpiry DATETIME,
  shorturl VARCHAR(50),
  FOREIGN KEY(userid) REFERENCES USER(userid)
);


CREATE TABLE CARD (
  cardid BIGINT(5) AUTO_INCREMENT  PRIMARY KEY,
  userid BIGINT(5),
  groupid BIGINT(5),   
  title VARCHAR(50),
  description VARCHAR(50),
  icon VARCHAR(50),
  validate BIGINT(5),
  FOREIGN KEY(userid) REFERENCES USER(userid),
  FOREIGN KEY(groupid) REFERENCES GROUPMANAGER(groupid)
);