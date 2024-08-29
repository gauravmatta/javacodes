package javaimplant.immutableclass;

import java.util.ArrayList;
import java.util.List;

final class ListImmutableClass {
	
	private final String name;
	private final List<Object> petNameList;
	
	ListImmutableClass(String name,List<Object> petNameList) {
		this.name=name;
		this.petNameList=new ArrayList<>(petNameList);
	}

	public String getName() {
		return name;
	}

	public List<Object> getPetNameList() {
		return new ArrayList<>(petNameList);
	}
	
	

}
