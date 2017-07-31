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
-- 15.2 모든 건물 목록과, status 가 Open인 모든 Requests 레코드를 구하라
-- 14.2 Open Requests: Write a SQL query to get a list of all buildings and the number of open requests
--                     (Requests in which status equals 'Open' ).
--                     Hints:#411

// get a list of buildings
SELECT BuildingName
FROM Buildings;

// the number of open requests
SELECT BuildingID, count(*)
FROM Requests 
        INNER JOIN Apartments 
        ON Requests.AptID = Apartments.AptID
WHERE Status = 'Open'
GROUP BY BuildingID;

// 
SELECT BuildingName, ISNULL(Count, 0) AS 'Count'
FROM Buildings
        LEFT JOIN (SELECT Apartments.BuildingID, count(*) AS 'Count'
                    FROM Requests 
                            INNER JOIN Apartments 
                            ON Requests.AptID = Apartments.AptID
                    WHERE Requests.Status = 'Open'
                    GROUP BY Apartments.BuildingID) AS ReqCounts
        ON Buildings.BuildingID = ReqCounts.BiuldingID;
