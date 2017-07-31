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
-- 15.3 11번 건물은 현재 대규모 리모델링 공사중이다. 
--       이 건물에 있는 모든 집에 대한 요청(Requests)상태를 Open에서 Close 로 변경하여라.
-- 14.3 Close All Requests: Building #11 is undergoing a major renovation.
--                          Implement a query to close all requests from apartments in this building.
--                          Hints:#431

-- //
SELECT AptID FROM Apartments WHERE BuildingID = 11;

-- //
UPDATE Requests
SET Status = 'Closed'

-- //
UPDATE Requests
SET Status = 'Closed'
WHERE AptID IN (SELECT AptID FROM Apartments WHERE BuildingID = 11);