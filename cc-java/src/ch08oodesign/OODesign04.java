package ch08oodesign;

/**
 * 8.4 객체 지향 원칙에 따라 Parking lot을 설계하라.
 * --> 제공 기능: 사용자 가입/확장, 서적 검색, 읽기, 한명만/한권만 활성만
 * 
 * (6E)
 * 7.4 Parking Lot: Design a parking lot using object-oriented principles.
 */

/**
 * 주차장 기본 컨셉
 *  - ParkingLot은 총 5개의 층(Level)로 구성되어 있고,
 *  - 각 Level은 30개의 ParkingSpot(1/4개의 Large, 1/4개의 Bike, 나머지 Compact)이 Row당 10개씩의 ParkingSpot으로 이루어진 3개의 Row가 있다.
 *  - 각 Vehicle 용도로 할당된 스팟이 연속적으로 존재할 경우만 주차 가능으로 표시한다.
 *  - OODesing 원리에 따라 각각의 세부 기능(주차, 정보 프린트, 출차 등등)은 각 컴포넌트에게 Delegation 한다.
 * 
 * Custom 요소
 *  - Level 수, VehicleSize별/Row별 ParkingSpot 갯수 --> Row당 Spot 갯수에 따라 각 층당 Row 갯수가 정해진다.
 * 
 * 주차는 각 레벨에게 주차를 요청하고 레벨은 주차 가능한 스팟을 찾아 주차를 한다.
 *  - 가능 스팟 검색 : vehicle 의 사이즈와 필요한 스팟 갯수가 연속인 곳을 각 level 에서 검색
 *  - 주차 : 기본적으로 연속된 여러개의 스팟에 걸쳐서 주차되므로 각 스팟에 어떤 vehicle 가 주차되어 있는지 표시 + vehicle 은 어떤 스팟에 주차되어 있는지 정보를 가지고 있는다
 *  - 출차: vehicle 에서 스팟에게 출차를 요청하면 각 스팟은 레벨에게 가능한 스팟갯수를 늘려주고, 스팟에 등록된 vehicle 정보를 제거한다.
 */


public class OODesign04 {}