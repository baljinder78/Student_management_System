# School management System 

 > Author:- *Baljinder Singh*

## About Project

Aim of project is to make a  management system for School to 
loging in as **admin**, **staff**, **Student** and use oprations
like Number of students, Number of staff members, 
Checking result and attendence of students and adding new
student ,new staff member then there is an option for signing up
to register your self to use those features.

### Languages used:-
> - Java(jdbc)
> - Mysql
### Ide used:-
>Intellij IDEA
### Modules
##### This project contains 2 moduldes:-
1. Login 
2. signup

##### The login module contains 3 more modules:-
1. Admin
2. Staff
3. Student

##### The features Each modules uses are:-
##### 1. Admin:-

     1. List of staff members
     2. List of Students
     3. View result of specific student
     4. Updating marks of student
     5. View attendence of student
     6. Update attendence of student
     7. Add staff member 
     8. Add students

##### 2. Staff:-

     1. List of student
     2. view result of student
     3. Update result of student
     4. View Attendence of student
     5. Update attendence of student
     6. Add student
    
    
##### 3. Student:-
     1. View Report 
     2. View Attendence
    
    
### Database
The database schema used in program is ***"login"***
##### The tables used in schemas are:-
##### 1. loginall :- 
>Stores all login information with columns 
###### Columns:-
     1. username 
     2. passcode
     3. id
     4. Pofession

##### 2. staffallinfo :-
>Stores all info of Staff members with colums
###### Columns:-
     1. Name
     2. Id (auto genrated,primary)
     3. Age
     4. Subject
     5. Stream


##### 3. studentallinfo :-
>Stores all info of Students with colums
###### Columns:-
     1. Name
     2. Id 
     3. Age
     4. address
     5. Stream



##### 4. studentattendence :- 
>Stors attendence of student with colums
###### Columns:-
     1. Name
     2. Id
     3. Present
     4. Absent
     5. Percentage:-derived ((Present*100/(Present+Absent)))

##### 5. studentresult:- 
>stores result of student with colums
###### Columns:-
    1. Name
    2. Id
    3. Physics
    4. Biology
    5. Maths
    6. Accounts
    7. Buiness Studies
    8. Chemistry
    9. Computer
    10. Total :- derived (Physics+Biology+Maths+Accounts+Buiness Studies+Chemistry+Computer)
    11. Percentage :-derived (Total*100)/400
     
    
