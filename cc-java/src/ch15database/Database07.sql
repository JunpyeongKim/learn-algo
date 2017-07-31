/*
15.7 학생들의 성적을 저장하는 간단한 데이터베이스를 설계하고, 성적이 우수한 학생(상위 10%) 목록을 반환하는 질의문을 만들라. 
     학생 목록은 평균 성적에 따라 내림차순으로 정렬되어야 한다.

14.7 Design Grade Database: Imagine a simple database storing information for students' grades.
                            Design what this database might look like 
                            and provide a SQL query to return a list of the honor roll students(top 10%), 
                            sorted by their grade point average.
                            Hints: #428, #442
*/

Students
    StudentID int
    StudentName varchar(100)
    Address varchar(500)

Courses
    CourseID int
    CourseName varchar(100)
    ProfessorID int

CourseEnrollment
    CourseID int
    StudentID int
    Grade float
    Term int

DECLARE @GPACutoff float;
SET @GPACutoff = (SELECT min(GPA) as 'GPAMin'
                    FROM (SELECT TOP 10 PERCENT AVG(CourseEnrollment.Grade) as GPA
                            FROM CourseEnrollment
                            GROUP BY CourseEnrollment.StudentID
                            ORDER BY GPA DESC) Grades);

SELECT StudentName, GPA
FROM (SELECT AVG(CourseEnrollment.Grade) AS GPA, CourseEnrollment.StudentID
        FROM CourseEnrollment
        GROUP BY CourseEnrollment.StudentID
        HAVING AVG(CourseEnrollment.Grade) >= @GPACutoff) Honors
    INNER JOIN Students
    ON Honors.StudentID = Students.StudentID;

