package com.soumya.hierarchy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Oracle LISTAGG in Java
 */


public class ListAggJava {

    private static Map<Integer, ListAggJava> empMap= new HashMap<>();

    private Integer empId;
    private String empName;
    private Integer mgrId;


    public Integer getMgrId() {
        return mgrId;
    }

    public static ListAggJava createEmp(Integer empId, String empName, Integer mgrId){
        ListAggJava e= new ListAggJava(empId, empName, mgrId);
        empMap.put(empId,e);
        return e;
    }

    private ListAggJava(Integer empId, String empName, Integer mgrId) {
        this.empId = empId;
        this.empName = empName;
        this.mgrId = mgrId;
    }

    private String getManagerName(Integer empId){
        if (ListAggJava.empMap.get(empId).getMgrId() == null) {
            return ListAggJava.empMap.get(empId).empName;
        }else {
            return getManagerName(ListAggJava.empMap.get(empId).getMgrId()) + "/" +
                    ListAggJava.empMap.get(empId).empName;
        }
    }
    @Override
    public String toString() {
        String displayManager = getManagerName(empId).equals(empName)?"":getManagerName(empId);
        return empId + "," +
                empName + "," +
                displayManager;

    }

    public static void main(String[] args) {
        List<ListAggJava> emps = new ArrayList<>();
        emps.add(ListAggJava.createEmp(1,"A",null));
        emps.add(ListAggJava.createEmp(2,"B",1));
        emps.add(ListAggJava.createEmp(4,"C",1));
        emps.add(ListAggJava.createEmp(3,"F",4));
        emps.add(ListAggJava.createEmp(5,"E",2));

        for(ListAggJava emp:emps){
            System.out.println(emp);
        }
    }


}
