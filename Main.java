package PhoneBook;
import java.util.Scanner;

public class Main {
	public static void main(String [] args) {
		Scanner input = new Scanner(System.in);
		//count 用于记录当前有效联系人数量
		int count = 0;
		//创建一个5个格子，可以用来存放PhoneBookEntry形式数据的数组
		
		PhoneBookEntry []arr = new PhoneBookEntry[5];
		
		//用空白填满这些格子，这样就可以调用了（因为在PhoneBookEntry的class里，first name， last name，phone number都是空的）
		
		for (int i = 0; i < arr.length; i++) {
            arr[i] = new PhoneBookEntry();
        }
		
		
		
		int option;
        do {
            System.out.println("\n===== Phone Book Menu =====");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Display Contacts");
            System.out.println("5. Exit");
            System.out.println("6. Find max phone number");
            System.out.print("Enter your selection: ");
            option = input.nextInt();
            input.nextLine(); // Clear newline

            switch (option) {
                case 1:
                    if (count < arr.length) {
                        addEntry(arr, input);
                        count++;
                    } else {
                        System.out.println("⚠️ Phone book is full!");
                    }
                    break;
                case 2:
                    editEntry(arr, input, count);
                    break;
                case 3:
                    deleteEntry(arr, input, count);
                    count--;
                    break;
                case 4:
                    displayEntries(arr, count);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    break;
                case 6:
                	maxEntry(arr,input,count);
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (option != 5);		
	}
	
	//向框架里面填入东西
	public static void addEntry (PhoneBookEntry arr[], Scanner input) {
		//对于每个单元
		for (int i=0;i<arr.length;i++) {
			//如果发现first name是空的（因为first name是第一个）
			if (arr[i].getFirstname().equals("")){
				//询问
				System.out.print("Enter first name: ");
				//设置first name（这里不使用=，而是在class里面写好的setFirstname）
				//arr[i] = input.next(); 会出错，因为你是想设置对象里的值，不是替换整个对象。
				//正确的做法是：调用类里写好的 setter 方法，比如 arr[i].setFirstname(...)。
				arr[i].setFirstname(input.next());
				
				System.out.print("Enter last name: ");
				arr[i].setLastname(input.next());
				
				System.out.print("Enter phonenumber: ");
				arr[i].setPhoneNumber(input.nextInt());	
				
				System.out.println("✅ Contact added:");
                arr[i].printMe();
                break;
			}
		}			
	}
	public static void editEntry (PhoneBookEntry arr[], Scanner input, int count) {
		if (count == 0) {
            System.out.println("No contacts to edit.");
            return;
        }
		System.out.print("Enter the index to edit ");
		int index = input.nextInt();
		//如果index在已有对象的数量范围内才允许操作
		if (index >= 0 && index < count) {
			//arr[]里面记得替换成index
			System.out.print("Enter first name: ");
			arr[index].setFirstname(input.next());
			
			System.out.print("Enter last name: ");
			arr[index].setLastname(input.next());
			
			System.out.print("Enter phone number: ");
			arr[index].setPhoneNumber(input.nextInt());
			
			System.out.println("✅ Contact updated:");
            arr[index].printMe();
		}else {
            System.out.println("❌ Invalid index!");
        }
	}
		
	public static void deleteEntry(PhoneBookEntry arr[], Scanner input, int count) {
		if (count == 0) {
            System.out.println("No contacts to delete.");
            return;
        }
		System.out.print("Enter the index you want to delete");
		int index = input.nextInt();
		
		//把index之后所有的单元里的内容整体移到前一个单元
		for(int i=index ;i<count;i++) {
			arr[i] = arr[i+1];
		}
		//这样会导致最后一项和倒数第二项重复，于是把最后一项清空
		arr[count - 1] = new PhoneBookEntry();
	}
	
    public static void displayEntries(PhoneBookEntry[] arr, int count) {
        System.out.println("\n📒 Contact List:");
        for (int i = 0; i < count; i++) {
            System.out.print("Index [" + i + "]: ");
            arr[i].printMe();
        }		
	}
    
    public static void maxEntry(PhoneBookEntry[]arr, Scanner input, int count) {
    	int max = arr[0].getPhoneNumber();
    	for(int i=0; i<count;i++) {
    		if (arr[i+1].getPhoneNumber() > arr[i].getPhoneNumber()) {
    			max = arr[i+1].getPhoneNumber();
    			
    		}
    	System.out.print("Largest phone number:" + max);
    		
    		
    		
    	}
    	
    }
	
	

}
