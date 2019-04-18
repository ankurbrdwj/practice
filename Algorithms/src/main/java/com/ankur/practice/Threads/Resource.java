package com.ankur.threads;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class Resource {

	public Resource() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> map=new ConcurrentHashMap<String,String>();
		map.put("Ankur", "Pratichi");map.put("Komal", "Kahtushyam");map.put("Puja", "Shri ram");
		map.put("Annu", "Bhutani");map.put("Papa", "mummy");map.put("Mummy g", "Papa g");
		map.put("Shiv", "Radha");map.put("Harendra", "Manju");map.put("Vishu", "Anju");

		for(Entry e: map.entrySet()){
			if(e.getValue()=="Kahtushyam"){
				e.setValue("KhatuShyam");
			}
			System.out.println(e.getKey()+" :: "+e.getValue());
		}
		
		
		
		Iterator <Entry<String, String>> entryItr = map.entrySet().iterator();
		while(entryItr.hasNext()) {
			Entry<String, String> x = entryItr.next();
			if (x.getValue().equalsIgnoreCase("KhatuShyam")) {
				//entryItr.remove();
			}
			System.out.println(map.get(x.getKey()));
		}
		
		
		Iterator<String>itr=map.keySet().iterator();
		while(itr.hasNext()){
			String key=itr.next();
			if(map.get(key)=="KhatuShyam")
				//map.put(key,"Khatushyam");
				map.remove(key);
			System.out.println(key+" :: "+map.get(key));
		}
	}

}
