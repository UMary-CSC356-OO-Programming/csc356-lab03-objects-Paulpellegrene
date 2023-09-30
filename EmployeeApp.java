import java.util.Scanner;

class Employee
{
	/* Task 3B: Add instance variables */
	private String firstName, lastName;
	private int employeeId;
	private double salary;
  
   
	/* Task 3C: Add three constructors */
	    // Default constructor with no parameters
    public Employee() {
        this.firstName = "";
        this.lastName = "";
        this.employeeId = 0;
        this.salary = 0.0;
    }

    // Constructor with first and last names as parameters
    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = 0; // Default value for employeeId
        this.salary = 0.0;   // Default value for salary
    }

    // Constructor with all four parameters
    public Employee(String firstName, String lastName, int employeeId, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.salary = salary;
    }
   
   
	/* Task 3D: Add set (mutator) and get (accessor) meethods */
	    // Setter method for firstName
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter method for firstName
    public String getFirstName() {
        return firstName;
    }

    // Setter method for lastName
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter method for lastName
    public String getLastName() {
        return lastName;
    }

    // Setter method for employeeId
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    // Getter method for employeeId
    public int getEmployeeId() {
        return employeeId;
    }

    // Setter method for salary
    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Getter method for salary
    public double getSalary() {
        return salary;
    }

   
	/* Task 3F: Add toString method */
	public String toString() {
    return "Employee ID: " + employeeId +
           "\nFirst Name: " + firstName +
           "\nLast Name: " + lastName +
           "\nSalary: " + salary + "\n";
}
   
   
	/* Task 3G: Add equals method */
	public boolean equals(String compareLastName) {
        // Compare the provided last name with the last name of the employee
        return this.lastName.equalsIgnoreCase(compareLastName);
    }
   
}


public class EmployeeApp 
{
	public static final int MAX_EMPLOYEES = 5;
   
	public static void main(String[] args) 
	{
		Scanner keyboard = new Scanner( System.in );
		Employee[]  employees = new Employee[MAX_EMPLOYEES];
		Employee    currentEmployee;
		String      inputString;
		int         inputInt;
		double      inputDouble;
		char        choice;
		int         empCount=0;
      
		employees[empCount++] = new Employee( "Mitchum", "Robert", 120402, 34000.0 );
		employees[empCount++] = new Employee( "Ryan", "Cornelius" );
		employees[empCount++] = new Employee( "Asimov", "Isaac" );

		do 
		{
			System.out.println( "\n   Enter Selection\n   ===============" );
			System.out.println( "A> Add new Employee" );
			System.out.println( "E> Edit Employee" );
			System.out.println( "L> List Employees" );
			System.out.println( "Q> Quit" );
			System.out.print(  "   Select: " );
			inputString = keyboard.nextLine();
			choice = inputString.toUpperCase().charAt( 0 );
			System.out.println();

			switch( choice )
			{
				case 'A':
					if ( empCount < MAX_EMPLOYEES-1 )
					{
						// Create object for new Employee
						employees[empCount] = new Employee();
                
						// Task 3E: Prompt for user information and set the object 
						// parameters via the mutator methods
						System.out.println("Enter employee information:");
        
						System.out.print("First Name: ");
						String firstName = keyboard.nextLine();
						employees[empCount].setFirstName(firstName);
				
						System.out.print("Last Name: ");
						String lastName = keyboard.nextLine();
						employees[empCount].setLastName(lastName);
				
						System.out.print("Employee ID: ");
						int employeeId = keyboard.nextInt();
						employees[empCount].setEmployeeId(employeeId);
				
						System.out.print("Salary: ");
						double salary = keyboard.nextDouble();
						employees[empCount].setSalary(salary);
   
						empCount++;
					}
					keyboard.nextLine();
				break;
               
				case 'E':
					System.out.printf( "Enter Last Name of Employee to Edit: " );
					inputString = keyboard.nextLine();
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						// Verify that the employee entry has been allocated before Editing
						if ( employees[lp] != null )
						{
							if ( employees[lp].equals( inputString ) == true )
							{
								System.out.print( "Enter Employee ID    : " );
								inputInt = keyboard.nextInt();
								employees[lp].setEmployeeId( inputInt );
                  
								System.out.print( "Enter Employee Salary: " );
								inputDouble = keyboard.nextDouble();
								employees[lp].setSalary( inputDouble );
   
								keyboard.nextLine();
							}
						}
					}
				break;
              
				case 'L':
					for ( int lp=0; lp<MAX_EMPLOYEES; lp++ )
					{
						System.out.println( employees[lp] );
					}
				break;
			}
			keyboard.reset();
		} while( choice != 'Q' );
	}  
}
