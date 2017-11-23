DROP TABLE IF EXISTS USER;
DROP TABLE IF EXISTS USER_ROLES;


CREATE TABLE  USER (ID NUMBER(5) NOT NULL AUTO_INCREMENT,
  USERNAME VARCHAR(50),
  ENABLED TINYINT NOT NULL DEFAULT 1 ,
  EMAIL VARCHAR(50),
  PASSWORD VARCHAR(200),
  PHOTO_URL VARCHAR(100),
  FACESET_TOKEN VARCHAR(50),
  FACE_TOKEN VARCHAR(50),
  BIRTHDATE DATE,
  GENDER VARCHAR(50),
  COUNTRY_ID NUMBER(11),
  REGION_ID NUMBER(11),
  CITY_ID NUMBER(11),
  FIRST_NAME VARCHAR(100),
  LAST_NAME VARCHAR(100));


CREATE TABLE  ROLES (
  ROLE_ID NUMBER(11) NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(20) NOT NULL,
  PRIMARY KEY (ROLE_ID));


CREATE TABLE  USER_ROLE (
  ROLE_ID NUMBER(11) NOT NULL,
  ID NUMBER(11) NOT NULL,
  PRIMARY KEY (ROLE_ID, ID));


