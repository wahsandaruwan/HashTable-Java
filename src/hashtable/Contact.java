package hashtable;

public class Contact {
    //Variables
    private String name;  
    private int num;  

    //Constructors
    public Contact(){
        
    }
    
    public Contact(String name, int num){ 
     //Assign values
     this.name = name;
     this.num = num;
    } 
    
    //Getters and Setters
    public String getName(){
        return name;
    }
    
    public int getNum(){
        return num;
    }
    
    public void setName(String name){
        this.name = name;
    }
    
    public void setNum(int num){
        this.num = num;
    }
}
