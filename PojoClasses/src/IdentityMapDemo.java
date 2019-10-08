 import java.util.HashMap; 
 import java.util.IdentityHashMap; 
 import java.util.Map;
 public class IdentityMapDemo 
 {
     public static void main(String[] args) 
     { 
         Map identityMap = new IdentityHashMap(); 
         Map hashMap = new HashMap(); 
         identityMap.put("a", 1); 
         identityMap.put(new String("a"), 2); 
         identityMap.put("a", 3);
         hashMap.put("a", 1); 
         hashMap.put(new String("a"), 2); 
         hashMap.put("a", 3);
         System.out.println("Identity Map KeySet Size :: " +  identityMap.keySet().size()); 
         System.out.println("Hash Map KeySet Size :: " + hashMap.keySet().size()); 
     } 
 }