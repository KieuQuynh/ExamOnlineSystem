CREATE DATABASE ExamSys
GO 
USE ExamSys
GO 
CREATE TABLE answers (
  answer_id int NOT NULL IDENTITY,
  exam_id int NOT NULL,
  question varchar(45) NOT NULL,
  answer varchar(45) NOT NULL,
  correct_answer varchar(45) NOT NULL,
  status varchar(45) NOT NULL,
  PRIMARY KEY (answer_id)
) 

CREATE TABLE courses (
  course_name varchar(25) NOT NULL,
  total_marks INT NOT NULL,
  time varchar(45) NOT NULL,
  PRIMARY KEY (course_name)
) 

CREATE TABLE exams (
  exam_id int NOT NULL IDENTITY,
  std_id varchar(45) NOT NULL,
  course_name varchar(45) NOT NULL,
  total_marks varchar(45) NOT NULL,
  obt_marks varchar(45) DEFAULT NULL,
  date varchar(45) NOT NULL,
  start_time varchar(45) NOT NULL,
  end_time varchar(45) DEFAULT NULL,
  exam_time varchar(45) DEFAULT NULL,
  status varchar(45) DEFAULT NULL,
  PRIMARY KEY (exam_id)
) 
CREATE TABLE questions (
  question_id INT NOT NULL IDENTITY,
  course_name VARCHAR(45) NOT NULL,
  question varchar(255) NOT NULL,
  opt1 varchar(85) NOT NULL,
  opt2 varchar(85) NOT NULL,
  opt3 varchar(85) NOT NULL,
  opt4 varchar(85) NOT NULL,
  correct varchar(85) NOT NULL,
  PRIMARY KEY (question_id)
) 

CREATE TABLE test (
  name varchar(25) NOT NULL,
  age int DEFAULT NULL,
  PRIMARY KEY (name)
) 

CREATE TABLE users (
  user_id int NOT NULL IDENTITY,
  first_name varchar(45) NOT NULL,
  last_name varchar(45) DEFAULT NULL,
  user_name varchar(45) NOT NULL,
  email varchar(45) NOT NULL,
  password varchar(45) NOT NULL,
  user_type varchar(45) NOT NULL,
  contact_no varchar(45) DEFAULT NULL,
  city varchar(45) DEFAULT NULL,
  address varchar(45) DEFAULT NULL,
  PRIMARY KEY (user_id)
) 
INSERT INTO dbo.users
        ( 
          first_name ,
          last_name ,
          user_name ,
          email ,
          password ,
          user_type ,
          contact_no ,
          city ,
          address
        )
VALUES  ( 
          'Kieu' , -- first_name - varchar(45)
          'Quynh' , -- last_name - varchar(45)
          'admin' , -- user_name - varchar(45)
          '123@gmail.com' , -- email - varchar(45)
          'kieuhoangan' , -- password - varchar(45)
          'admin' , -- user_type - varchar(45)
          '1234' , -- contact_no - varchar(45)
          'hanoi' , -- city - varchar(45)
          'thachthat'  -- address - varchar(45)
        )
INSERT INTO dbo.users
        ( 
          first_name ,
          last_name ,
          user_name ,
          email ,
          password ,
          user_type ,
          contact_no ,
          city ,
          address
        )
VALUES  ( 
          'An' , -- first_name - varchar(45)
          'Hoàng' , -- last_name - varchar(45)
          'anhoang' , -- user_name - varchar(45)
          '123@gmail.com' , -- email - varchar(45)
          'kieuhoangan' , -- password - varchar(45)
          'student' , -- user_type - varchar(45)
          '1234' , -- contact_no - varchar(45)
          'hcm' , -- city - varchar(45)
          'hcm'  -- address - varchar(45)
        )
       
   
    INSERT INTO dbo.courses
            ( course_name, total_marks, time )
    VALUES  ( 'Java Core', -- course_name - varchar(25)
              100, -- total_marks - int
              '20'  -- time - varchar(45)
              )    
              
          