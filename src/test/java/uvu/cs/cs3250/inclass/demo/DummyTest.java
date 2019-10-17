package uvu.cs.cs3250.inclass.demo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DummyTest {

	@Test
	public void testDummy() {
		List<String> names = new ArrayList<>();
		names.add("matt");
		names.add("john");
		names.add("mark");
		
		String allNames = concatAllNames(names);
//		String allNames = "";
//		for(String name:names) {
//			allNames += (name + ", ");
//		}
//		
//		allNames = allNames.substring(0, allNames.length()-2);
		assertEquals("matt, john, mark", allNames);
	}
	
	@Test
	public void testAnotherDummy() {
		List<String> names = new ArrayList<>();
		String allNames = concatAllNames(names);
		assertEquals("", allNames);
	}
	
	@Test 
	public void testOneName() {
		List<String> names = new ArrayList<>();
		names.add("matt");
		
		String allNames = concatAllNames(names);
		assertEquals("matt", allNames);
	}
	
	@Test 
	public void testNull() {
		String allNames = concatAllNames(null);
		assertEquals(null, allNames);
	}
	
	public static String concatAllNames(List<String> allNameList) {
		if (allNameList == null) {
			return null;
		}
		if (allNameList.size() == 0) {
			return "";
		}
		String allNames = allNameList.get(0);
		for(int n = 1; n<allNameList.size(); n++) {
			allNames += (", " + allNameList.get(n));
		}
		return allNames;
	}
}
