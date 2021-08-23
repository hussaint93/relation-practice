package hibernate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Account")
public class AccountEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer account_Id;

	private String accountNumber;

	// first method with foreign key association
//	@OneToOne(mappedBy="account")
//	private EmployeeEntity employee;

	// second method with common join table
	// join table directly created in employee entity

	// third method with shared primary key
//	@OneToOne(mappedBy="account", cascade=CascadeType.ALL)
//	private EmployeeEntity employee;

	// fourth method with MapsId
//	@Id
//	private Integer accountId;

	// first methof for onetomany using foreign key
//	@ManyToOne
//	private EmployeeEntity employee;

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

//	public EmployeeEntity getEmployee() {
//		return employee;
//	}
//
//	public void setEmployee(EmployeeEntity employee) {
//		this.employee = employee;
//	}

}
