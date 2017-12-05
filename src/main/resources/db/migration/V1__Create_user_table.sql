CREATE TABLE  USER (ID INT NOT NULL AUTO_INCREMENT,
  USERNAME VARCHAR(50),
  ENABLED TINYINT NOT NULL DEFAULT 1 ,
  EMAIL VARCHAR(50),
  PASSWORD VARCHAR(200),
  PHOTO_URL VARCHAR(100),
  FACESET_TOKEN VARCHAR(50),
  FACE_TOKEN VARCHAR(50),
  BIRTHDATE DATE,
  GENDER VARCHAR(50),
  COUNTRY_ID INT,
  REGION_ID INT,
  CITY_ID INT,
  PHONE_NUMBER VARCHAR(50),
  ABOUT VARCHAR(255),
  PROFESSION VARCHAR(100),
  JOB VARCHAR(100),
  FIRST_NAME VARCHAR(100),
  LAST_NAME VARCHAR(100),
  PRIMARY KEY ( ID ) );