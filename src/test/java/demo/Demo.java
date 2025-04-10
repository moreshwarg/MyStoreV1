package demo;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class Demo {

	public static void main(String[] args) {
		String str="Moreshwarrrr";
		char ch[]=str.toCharArray();
		HashMap<Character, Integer>hm=new HashMap<>();
		for(char w:ch) {
			if(hm.containsKey(w)) {
				hm.put(w, hm.get(w)+1);
			}
			else {
				hm.put(w, 1);
			}
		}
System.out.println(hm);
Set<Entry<Character,Integer>>kvs=hm.entrySet();
for(Entry<Character,Integer>kv:kvs) {
	if(kv.getValue()>=2) {
		System.out.println(kv.getKey());
	}
}
	}

}
