package Project_Essential;

import java.util.HashMap;
import java.util.Set;

public class Get_all_key_Of_HashMap {
    public static void main(String[] args) {
        HashMap<String,String> hashMap=new HashMap<>();

        hashMap.put("first","first inserted");
        hashMap.put("second","second inserted");
        hashMap.put("third","third inserted");

        System.out.println(hashMap);
        Set<String> Keys=hashMap.keySet();
        for(String key:Keys){
            System.out.println(key);
            System.out.println(hashMap.get(key));
        }

    }
}
