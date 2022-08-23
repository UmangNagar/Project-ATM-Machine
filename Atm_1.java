import java.util.ArrayList;

class Person{
    String name;
    int account_number;
    int balance;
    int PIN;

    public Person(String name,int account_number,int balance,int PIN){

        this.name=name;
        this.account_number=account_number;
        this.balance=balance;
        this.PIN=PIN;
    }
}

class ATM{
           
       ArrayList<Person> accounts;
       public ATM(){
       accounts=new ArrayList<>();
       }
       private Person getPerson(String Enter_name,int account_number){
       Person p=null;
       for(int i=0;i<accounts.size();i++){
           Person curPerson=accounts.get(i);
           if(curPerson.name.equals(Enter_name) && curPerson.account_number==account_number){
               p=curPerson;
               break;
           }
   
       }
       return p;
}

    public void withdrawlCash(Person p,int Pin_Enter,int Cash){
      if(p.PIN==Pin_Enter){
       if(p.balance<Cash){
               System.out.println("Sorry You Dont Have this much Money in Your account : Avi Bal. is : "+p.balance);
       }else{
    p.balance=p.balance-Cash;
    System.out.println("Amount Recived of "+Cash+" Avi Bal. Is :"+p.balance);
    }


    }else{
    System.out.println("Sorry Wrong ATM PIN");
      }
    }
  
    public void withdrawlCash(String Enter_name,int Pin_Enter,int account_number,int Cash){
 
    Person p=getPerson(Enter_name,account_number);
    if(p==null){
    System.out.println("There is no Account with name "+Enter_name+" and Account number "+account_number);
    }
    withdrawlCash(p, Pin_Enter, Cash);
    }


    public void depositCash(Person p,int Pin_Enter,int Cash){
        if(p.PIN==Pin_Enter){
            p.balance=p.balance+Cash;
            System.out.println("Amount Deposit of "+Cash+" Avi Bal. Is :"+p.balance);
        }else{
            System.out.println("Sorry Wrong Pin");
        }
    }

    public void depositCash(String Enter_name,int account_number,int Pin_Enter,int Cash){
       Person p=getPerson(Enter_name, account_number);
        if(p==null){
            System.out.println("There is no Account with name "+Enter_name+" and Account number "+account_number);
        }
        depositCash(p, Pin_Enter, Cash);
    }
   
    public void getBalance(Person p,int Pin_Enter){

    if(p.PIN==Pin_Enter){
    System.out.println("Your Avi. Bal. Is :"+p.balance);
    }else{
    System.out.println("Sorry Wrong ATM PIN");
    }

    }
    public void getBalance(String Enter_name,int account_number,int Pin_Enter){
        Person p=getPerson(Enter_name, account_number);
        if(p==null){
            System.out.println("There is no Account with name "+Enter_name+" and Account number "+account_number);
        }
        getBalance(p, Pin_Enter);
    }

    public void changePin(Person p,int curr_Pin,int New_pin){

    if(p.PIN==curr_Pin){
    p.PIN=New_pin;
    System.out.println("ATM PIN Has Been Changed Sucessfully");
    }else{
    System.out.println("Sorry Wrong ATM PIN ");
    }
    }

    public void changePin(String Enter_name,int account_number,int Pin_Enter,int new_pin){
        Person p=getPerson(Enter_name, account_number);
        if(p==null){
            System.out.println("There is no Account with name "+Enter_name+" and Account number "+account_number);
        } 
        changePin(p, Pin_Enter,new_pin);
    }

}

public class Atm_1 {
    public static void main(String[] args) {
        ATM Bank=new ATM();

        Person p1=new Person("Ashish", 1, 1000, 1234);
        Bank.accounts.add(p1);

        Person p2=new Person("Umang", 2, 1500, 1235);
        Bank.accounts.add(p2);

        Bank.withdrawlCash(p1,1234,100);
        Bank.withdrawlCash("Ashish", 1234,1,200);

        Bank.depositCash(p1,1234,100);
        Bank.depositCash("Ashish",1,1234,100);

        Bank.getBalance(p2,1235);
        Bank.getBalance("Umang", 2, 1235);
        Bank.getBalance("Umang", 2, 1285);

        Bank.changePin(p1, 1234, 1111);
        Bank.changePin("Ashish",1, 1111, 1234);
        
      
        Bank.depositCash(p1,1111,100);
        
    }
}
