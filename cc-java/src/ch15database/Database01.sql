/*
한 Apartment에 Tenant는 여럿 일수 있고, 각 Tenant 는 하나 이상의 Apartment 를 소유할 수 있다.
한 Apartment는 한 Building에 속하고, 각 Building은  어떤 Complex에 속한다.

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

-- --------------------------------------------------------------------------------
/* 
15.1 집을 하나 이상 대여한 모든 거주자 목록을 구라.

(4E) different check...

(6E)
14.1 Multiple Apartments: Write a SQL query to get a list of tenants who are renting more than one apartment.
                          Hints: #408
*/

SELECT *
FROM Tenants
    INNER JOIN (SELECT TenantID, count(*) 
                FROM AptTenants 
                GROUP BY TenantID HAVING count(*) > 1) AS C
    ON Tenants.TenantID = C.TenantID;