CREATE TABLE USER_ROLE (
  user_role_id varchar2(5),
  description varchar2(20)
);

CREATE TABLE USER (
  username varchar2(20) NOT NULL,
  password varchar2(20),
  name varchar2(100),
  user_role_id varchar2(5) NOT NULL,  
  active varchar2(1)
);