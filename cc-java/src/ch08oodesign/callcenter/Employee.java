package ch08oodesign.callcenter;


public abstract class Employee {
    private CallCenter callCenter;

    public Employee(CallCenter center) {
        callCenter = center;
    }
}
