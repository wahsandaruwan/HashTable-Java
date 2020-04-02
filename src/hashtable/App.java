package hashtable;

public class App {
    public static void main(String[] args) {
        //Create objects per contact
        Contact c1 = new Contact("Himal",11111);
        Contact c2 = new Contact("Kasun",22222);
        Contact c3 = new Contact("Chamal",33333);
        Contact c4 = new Contact("Sanduni",44444);
        Contact c5 = new Contact("Ayesha",55555);
        
        //Create an object for Hash Table by assigning size
        HashTable table = new HashTable(13);
        
        //====Insert contacts====
        System.out.println("=============================================");
        System.out.println("Contact Insertion");
        System.out.println("=============================================");
        table.insert("Himal", c1);
        table.insert("Kasun", c2);
        table.insert("Chamal", c3);
        table.insert("Sanduni", c4);
        table.insert("Ayesha", c5);
        
        //====Print Table====
        table.printTable();
        
        //====Search Contacts====
        Contact search = new Contact();
        //Currently available contact
        System.out.println("\n\n=============================================");
        System.out.println("Searching Contacts");
        System.out.println("=============================================");
        search = table.search("Himal");
        System.out.println("Name : "+search.getName()+"  |  Phone Number : "+search.getNum());
        search = table.search("Sanduni");
        System.out.println("Name : "+search.getName()+"  |  Phone Number : "+search.getNum());
        
        //Currently not available contact
        search = table.search("Kamal");
        if(search != null){
            System.out.println("Name : "+search.getName()+"  |  Phone Number : "+search.getNum());
        }
        
        //====Remove Contact====
        Contact remove = new Contact();
        remove = table.remove("gfhgfhg");
        System.out.println("Name : "+remove.getName()+"  |  Phone Number : "+remove.getNum());
        
        //====Print Table====
        table.printTable();

    } 
}
