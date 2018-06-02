package com.sd.isp.employee
import com.sd.isp.beans.employee.EmployeeB

public class Employee {
	 String  name
	 String  surName
	 String  ruc
	 String  address
	 Integer cellphone
	 	 
	 static constraints = {
		 name 	   blank:false, size:3..50
		 surName   blank: false, size:3..50
		 ruc       blank:false, size:1..10
		 address   blank:false, size:1..100
		 cellphone blank:false, size:1..10
	 }
	 
	 public Employee(EmployeeB employee){
		 this.id 	    = employee.getId()
		 this.name 	    = employee.getName()
		 this.surName   = employee.getSurName()
		 this.ruc       = employee.getRuc()
		 this.address   = employee.getAddress()
		 this.cellphone = Integer.parseInt(employee.getCellphone())
	 }
}