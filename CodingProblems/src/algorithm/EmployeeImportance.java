package algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeImportance {
	
	public static void main(String[] args) {
		List<Integer> emp1List = new ArrayList<>();
		emp1List.add(2);
		emp1List.add(3);
		
		List<Integer> emp2List = new ArrayList<>();
		emp2List.add(4);
		
		Employee emp1 = new Employee(1, 5, emp1List);
		Employee emp2 = new Employee(2, 3, emp2List);
		Employee emp3 = new Employee(3, 4, null);
		Employee emp4 = new Employee(4, 1, null);
		
		List<Employee> emps = new ArrayList<>();
		emps.add(emp1);
		emps.add(emp2);
		emps.add(emp3);
		emps.add(emp4);
		
		EmployeeImportance imp = new EmployeeImportance();
		int n = imp.getImportance2(emps, 1);
		System.out.println(n);
	}
	// calculate the total importance value of this employee and all his subordinates.
    public int getImportance(List<Employee> employees, int id) {
    	int[] res = new int[1];
    	
    	helper(employees, id, res);
    	
    	return res[0];
    }
    
    private void helper(List<Employee> employees, int subId, int[] res) {
    	
    	for (Employee emp : employees) {
    		
    		if (emp.id == subId) {
    			res[0] += emp.importance;
    			
    			if (emp.subordinates != null) 
    				for (int id : emp.subordinates) 
    					helper(employees, id, res);
    		}
    	}
    }
    
    HashMap<Integer, Employee> emap;
    public int getImportance2(List<Employee> employees, int id) {
    	
    	emap = new HashMap<>();
    	
    	for (Employee emp : employees) {
    		emap.put(emp.id, emp);
    	}
    	
    	return helper2(id);
    }
    
    private int helper2(int id) {
    	
    	Employee emp = emap.get(id);
    	int ans = emp.importance;
    	
    	if (emp.subordinates != null) {
        	for (int subId : emp.subordinates) 
        		ans += helper2(subId);
    	}
    	
    	return ans;
    }
}

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
    
    public Employee(int id, int importance, List<Integer> subordinates) {
    	this.id = id;
    	this.importance = importance;
    	this.subordinates = subordinates;
    }
};
