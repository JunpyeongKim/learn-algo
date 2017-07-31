/*
-- 한 Apartment에 Tenant는 여럿 일수 있고, 각 Tenant 는 하나 이상의 Apartment 를 소유할 수 있다.
-- 한 Apartment는 한 Building에 속하고, 각 Building은  어떤 Complex에 속한다.

Apartments
    AptID int
    UnitNumber varchar(100)
    BuildingID int

Buildings
    BuildingID int
    ComplexID int
    BuildingName varchar (100)
    Address varchar (500)

Tenants
    TenantID int
    TenantName varchar(100)

Complexes
    ComplexID int
    ComplexName varchar

AptTenants
    TenantID int
    AptID int

Requests
    RequestID int
    Status varchar
    AptID int
    Description varchar
*/

/*
-- 15.1 집을 하나 이상 대여한 모든 거주자 목록을 구라.
-- 14.1 Multiple Apartments: Write a SQL query to get a list of tenants who are renting more than one apartment.

-- 15.2 모든 건물 목록과, status 가 Open인 모든 Requests 레코드를 구하라
-- 14.2 Open Requests: Write a SQL query to get a list of all buildings and the number of open requests
--                     (Requests in which status equals 'Open' ).

-- 15.3 11번 건물은 현재 대규모 리모델링 공사중이다.
--       이 건물에 있는 모든 집에 대한 요청(Requests)상태를 Open에서 Close 로 변경하여라.
-- 14.3 Close All Requests: Building #11 is undergoing a major renovation.
--                          Implement a query to close all requests from apartments in this building.

15.4 Join 의 종류를 열거하라.
     각각이 어떻게 다르고, 어떤 상황에는 어떤 JOIN이 어울리는지 설명하라.
14.4 Joins: What are the different types of joins?
            Please explain how they differ and why certain types are better in certain situations.

15.5 비정규화란 무엇인가? 그 장단점을 설명하라.
14.5 Denormalization: What is denormalization? Explain the pros and cons.

6. 회사, 사람 그리고 직원 레코드를 저장하는 데이터베이스의 ER 다이어그램을 그려라

15.7 학생들의 성적을 저장하는 간단한 데이터베이스를 설계하고, 성적이 우수한 학생(상위 10%) 목록을 반환하는 질의문을 만들라.
     학생 목록은 평균 성적에 따라 내림차순으로 정렬되어야 한다.

14.7 Design Grade Database: Imagine a simple database storing information for students' grades.
                            Design what this database might look like
                            and provide a SQL query to return a list of the honor roll students(top 10%),
                            sorted by their grade point average.
*/
-- Explicit Join
SELECT CourseName, TeacherName
FROM Courses INNER JOIN Teachers
ON Courses.TeacherID = Teachers.TeacherID;

-- Implicit Join
SELECT CourseName, TeacherName
FROM Courses, Teachers
WHERE Courses.TeacherID = Teachers.TeacherID:

-- Schema 01
Courses: CourseID*, CourseName, TearchID
Tearchers: TearchID*, TearchName
Students: StudentID*, StudentName
StudentCourses: CourseID*, StudentID*

-- 1. 학생 등록: 모든 학생들의 목록을 뽑고 각 학생들이 얼마나 많은 강의를 수강하고 있는지 알아보는 질의
-- 2. 수강생 수 뽑기:





-- Schema 02
-- 한 Apartment에 Tenant는 여럿 일수 있고, 각 Tenant 는 하나 이상의 Apartment 를 소유할 수 있다.
-- 한 Apartment는 한 Building에 속하고, 각 Building은  어떤 Complex에 속한다.

Apartments
    AptID int
    UnitNumber varchar(100)
    BuildingID int

Buildings
    BuildingID int
    ComplexID int
    BuildingName varchar (100)
    Address varchar (500)

Tenants
    TenantID int
    TenantName varchar(100)

Complexes
    ComplexID int
    ComplexName varchar

AptTenants
    TenantID int
    AptID int

Requests
    RequestID int
    Status varchar
    AptID int
    Description varchar

-- --------------------------------------------------------------------------------
-- 모든 건물 목록과, status가 Open인 모든 Requests 레코드를 구하라.
-- Open Requests: Write a SQL query to get a list of all buildings and the number of open requests
--                (Requests in which status equals 'Open' ).

select BuildingName, ISNULL(Count, 0) as 'Count'
from Buildings
left join (select Apartments.BuildingID, count(*) as 'Count'
            from Requests inner join Apartments on Requests.AptID = Apartments.AptID
            where Requests.Status = 'Open'
            group by Apartments.BuildingID) as ReqCounts
on Buildings.BuildingID = ReqCounts.BuildingID;


select BuildingName, isnull(Count, 0) as 'Count'
from Buildings left join (select Apartments.BuildingID, count(*) as 'Count'
                            from Requests left join Apartments on Requests.AptID = Apartments.AptID
                            where Requests.status = 'Open'
                            group by Apartments.BuildingID) as ReqCount
               on Buildings.BuildingID = ReqCount.BuildingID


select Apartments.BuildingID, count(*) as 'Count'
from Requests left join Apartments on Requests.AptID = Apartments.AptID
where Requests.status = 'Open'
group by Apartments.BuildingID

-- TBD 4E
/*
4E의 문제가 조금 다르다. 검토 필요

15.1 Write a method to find the number of employees in each department.

15.2 What are the different types of joins? Please explain how they differ and why certain
types are better in certain situations.

15.3 What is denormalization? Explain the pros and cons.

15.4 Draw an entity-relationship diagram for a database with companies, people, and professionals
(people who work for companies).

15.5 Imagine a simple database storing information for students’ grades. Design what this
database might look like, and provide a SQL query to return a list of the honor roll
students (top 10%), sorted by their grade point average.
 */