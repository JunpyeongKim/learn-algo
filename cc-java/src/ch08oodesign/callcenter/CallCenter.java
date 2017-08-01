package ch08oodesign.callcenter;

import java.util.ArrayList;
import java.util.List;

// Entry Point: CallCenter
public class CallCenter {
    private final int LEVELS = 3;

    private final int NUM_RESPONDENTS = 10;
    private final int NUM_MANAGERS = 4;
    private final int NUM_DIRECTORS = 2;

    List<List<Employee>> employeeLevels;
    List<List<Call>> callQueues;

    public CallCenter() {
        employeeLevels = new ArrayList<List<Employee>>(LEVELS);
        callQueues = new ArrayList<List<Call>>(LEVELS);

        // Create respondents
        ArrayList<Employee> respondents = new ArrayList<Employee>(NUM_RESPONDENTS);
        for (int i = 0; i < NUM_RESPONDENTS; i++) {
            respondents.add(new Respondent(this));
        }
        employeeLevels.add(respondents);

        // Create managers
        ArrayList<Employee> managers = new ArrayList<Employee>(NUM_MANAGERS);
        managers.add(new Manager(this));
        employeeLevels.add(managers);

        // Create directors
        ArrayList<Employee> directors = new ArrayList<Employee>(NUM_DIRECTORS);
        directors.add(new Director(this));
        employeeLevels.add(directors);
    }
}
