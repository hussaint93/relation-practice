package hibernate;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity(name = "Employee")
public class EmployeeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer EmployeeId;

	private String firstName;
	private String lastName;
	private String email;

	// first method with foreign key association
//	@OneToOne
//	@JoinColumn(name="ACCOUNT_ID")
//	private AccountEntity account;

	// second method with common join table
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinTable(name="EMPLOYEE_ACCCOUNT", joinColumns = @JoinColumn(name="EMPLOYEE_ID"),
//	inverseJoinColumns = @JoinColumn(name="ACCOUNT_ID"))
//	private AccountEntity account;

	// third method with shared primary key
//	@OneToOne(cascade = CascadeType.ALL)
//	@PrimaryKeyJoinColumn
//	private AccountEntity account;

	// fourth method with MapsId
//	@OneToOne
//	@MapsId
//	private AccountEntity account;

	//first method for one to many using foreign key association 
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "EMPLOYEE_ID")
//	private Set<AccountEntity> accounts;
	
	//second method for one to many using join table
	@OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="EMPLOYEE_ACCOUNT", joinColumns={@JoinColumn(name="EMPLOYEE_ID", referencedColumnName="ID")}
    , inverseJoinColumns={@JoinColumn(name="ACCOUNT_ID", referencedColumnName="ID")})
    private Set<AccountEntity> accounts;

	public Integer getEmployeeId() {
		return EmployeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		EmployeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<AccountEntity> getAccounts() {
		return accounts;
	}

	public void setAccounts(Set<AccountEntity> accounts) {
		this.accounts = accounts;
	}

//	public AccountEntity getAccount() {
//		return account;
//	}
//
//	public void setAccount(AccountEntity account) {
//		this.account = account;
//	}

}
