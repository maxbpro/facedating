CREATE TABLE  ROLES (
  ROLE_ID INT NOT NULL AUTO_INCREMENT,
  NAME VARCHAR(20) NOT NULL,
  PRIMARY KEY (ROLE_ID));


CREATE TABLE  USER_ROLE (
  ROLE_ID INT NOT NULL,
  ID INT NOT NULL,
  PRIMARY KEY (ROLE_ID, ID));

CREATE TABLE persistent_logins (
    username INT not null,
    series INT not null,
    token INT not null,
    last_used TIMESTAMP not null,
    PRIMARY KEY (series)
);
