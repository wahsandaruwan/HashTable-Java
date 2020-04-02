package hashtable;
//There are two main hash functions that represents Double Hashing

public class HashTable {
    private Contact[] contact; //for each contact
    int arraySize; 
    int size = 0; //Counter for number of elements in the hash table
    
    public HashTable(int noOfSlots){
        //Check if noOfSlots is a prime no.
        if(isPrime(noOfSlots)){
            //Set Array size
            contact = new Contact[noOfSlots];
            arraySize = noOfSlots;
        }
        else{
            //Get next prime num
            int primeCount = getNextPrime(noOfSlots);
            //Set Array size
            contact = new Contact[primeCount];
            arraySize = primeCount;
        }
    }
    
    //Check prime
    private boolean isPrime(int num){
        for(int i = 2; i*i <= num; i++){
            if(num % i == 0){
                return false;
            }
        }
        return true;
    }
    
    //Get next prime
    private int getNextPrime(int minNum){
        for(int i = minNum; true; i++){
            if(isPrime(i)){
                return i;
            }
        }
    }
    
    //Return ideal index position to insert or search
    private int hashFunc1(String name){
        int hashVal = name.hashCode();
        hashVal = hashVal % arraySize;
       
        if(hashVal < 0){
            hashVal += arraySize;
        }
        
        //Index position
        return hashVal;
    }
    
    //Return step size greater than 0
    private int hashFunc2(String name){
        int hashVal = name.hashCode();
        hashVal = hashVal % arraySize;
        
        if(hashVal < 0){
            hashVal += arraySize;
        }
        
        //Use prime number less than array size
        int haV = 3 - hashVal % 3;
        
        //Step size
        return haV;
    }
    
    //Insert Contact
    public void insert(String name, Contact conInfo){
        int hashVal = hashFunc1(name);
        int stepSize = hashFunc2(name);
        
        //Check the empty space to insert
        while(contact[hashVal] != null){
            hashVal = hashVal + stepSize;
            hashVal = hashVal % arraySize;
        }
        
        //Insert the word
        contact[hashVal] = conInfo;
        System.out.println("inserted record :"+ conInfo.getName()+" "+conInfo.getNum());
        size++;
    }
     
    //Search word
    public Contact search(String name){
        int hashVal = hashFunc1(name);
        int stepSize = hashFunc2(name);
        
        //Check the empty space to insert
        while(contact[hashVal] != null){
            if(contact[hashVal].getName() == name){
                //Return value
                return contact[hashVal];
            }
            hashVal = hashVal + stepSize;
            hashVal = hashVal % arraySize;
        }
      
        System.out.println(name+" is Does not exist!");
        //Return null
        return contact[hashVal];
    }
    
    //Remove Contact
    public Contact remove(String name){
        int hashVal = hashFunc1(name);
        int stepSize = hashFunc2(name);
        Contact c1 = new Contact();
        System.out.println("\n\n=============================================");
        System.out.println("Contact Removing!");
        System.out.println("=============================================");
        //Find the contact
        while(contact[hashVal] != null){
            if(contact[hashVal].getName() == name){
                //Pass it to the varibale
                c1 = contact[hashVal];
                //Assign null to it | remove
                contact[hashVal] = null;
                return c1;
            }
            hashVal = hashVal + stepSize;
            hashVal = hashVal % arraySize;
        }
        
        return c1;
    }
    
    //Print whole table
    public void printTable(){
        System.out.println("\n\n=============================================");
        System.out.println("Whole Table");
        System.out.println("=============================================");
        //Print one by one
        for(int i = 0; i < contact.length; i++){
            if(contact[i] != null){
                System.out.println((i+1)+"  |  Name : "+contact[i].getName()+" | Phone Number : "+contact[i].getNum());
            }
            else{
                System.out.println((i+1)+"  |  Empty");
            }
            System.out.println("---------------------------------------------");
        }
    }
}


