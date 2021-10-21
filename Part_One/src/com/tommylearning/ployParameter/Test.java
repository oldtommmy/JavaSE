package com.tommylearning.ployParameter;

public class Test {
    public static void main(String[] args) {
        Worker worker = new Worker("Tom",2000);
        Manager manager = new Manager("Daison",18000,100000);
        Test test = new Test();
        test.ShowEmpAnnual(worker);
        test.ShowEmpAnnual(manager);
        System.out.println("==============");
        test.testWorker(worker);
        test.testWorker(manager);
    }

    public void ShowEmpAnnual(Employee employee){
        System.out.println("Name:"+employee.getName()+" Annual:"+employee.getAnnual());
    }

    public void testWorker(Employee employee){
        if(employee instanceof Worker){
            Worker worker = (Worker) employee;
            worker.work();
        }else{
            Manager manager = (Manager) employee;
            manager.manage();
        }
    }


}
