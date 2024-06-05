import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Stream;

public class TrueCaller {
    /*
    1. Create a centralized hashmap which stored all the key number and value name of the person
    2. Create function sync for adding all the saved contacts of the user in the system
    3. Create an add number function
    4. Create lookup function to get name of the caller
     */
    private Map<String,String> centralRepo;
    public TrueCaller(){
        if(this.centralRepo==null){
            this.centralRepo = new HashMap<>();
        }
    }
    public boolean syncContacts(Map<String,String> contactsMap){
//        centralRepo.stream.
        for(Map.Entry<String, String> e : contactsMap.entrySet()){
            centralRepo.put(e.getKey(), e.getValue());
        }
        return true;
    }

    public void addNumber(String number,String name){
        centralRepo.put(number,name);
    }
    public String lookUp(String number){
        if(centralRepo.containsKey(number)){
            System.out.println("Lookup details for the number "+number+" name is : "+centralRepo.get(number));
            return centralRepo.get(number);
        }
        System.out.println("Number contact info not available!");
        return "";
    }

    public void printMap(){
        for(Map.Entry<String, String> e : centralRepo.entrySet()){
            System.out.println("Key: "+e.getKey()+" Value: "+e.getValue());
        }
        System.out.println();
    }
    public static void main(String[] args) {
        System.out.println("Truecaller System initiate");

        TrueCaller obj1 = new TrueCaller();
        Map<String,String> contacts = new HashMap<>();
        contacts.put("99491","Yash");
        contacts.put("89189","Sotu");
        contacts.put("51727","Saatwika");

        obj1.syncContacts(contacts);
        obj1.printMap();

        obj1.addNumber("12941","Raghav");
        obj1.printMap();

        obj1.lookUp("89189");

    }
}
