package ch08oodesign.callcenter;


public abstract class Employee {
    private CallHandler callCenter;

    public Employee(CallHandler center) {
        callCenter = center;
    }
}
