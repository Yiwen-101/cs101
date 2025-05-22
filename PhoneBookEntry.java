package PhoneBook;

public class PhoneBookEntry {
    private String firstname = "";
    private String lastname = "";
    private int phoneNumber = 0;
    
    
    
    public PhoneBookEntry() {}
    
    public PhoneBookEntry(String firstname, String lastname, int phoneNumber) {
    	this.firstname = firstname;
    	this.lastname = lastname;
    	this.phoneNumber = phoneNumber;
        	
    }

    
    
    
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getPhoneNumber() {
        return phoneNumber;
    }
    

    public void printMe() {
        System.out.println("Name: " + firstname + " " + lastname + ", Phone: " + phoneNumber);
    }
    
}

