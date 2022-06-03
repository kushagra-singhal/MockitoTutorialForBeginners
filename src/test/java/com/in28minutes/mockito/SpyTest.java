package com.in28minutes.mockito;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

	@Test
	public void creatingASpyOnArrayList() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Ranga");
		listSpy.add("in28Minutes");
		listSpy.add("practice");

		verify(listSpy).add("Ranga");
		verify(listSpy).add("in28Minutes");

		assertEquals(3, listSpy.size());
		assertEquals("Ranga", listSpy.get(0));
	}

	@Test
	public void creatingASpyOnArrayList_overridingSpecificMethods() {
		List<String> listSpy = spy(ArrayList.class);
		listSpy.add("Ranga");
		listSpy.add("in28Minutes");

		//stub(listSpy.size()).toReturn(-1);	// used when..thenReturn in place of stub..toReturn
		when(listSpy.size()).thenReturn(-1);  // from now on size method always return -1(overridden)

		assertEquals(-1, listSpy.size());
		assertEquals("Ranga", listSpy.get(0));
		assertEquals("Ranga", listSpy.get(0));


		// @Spy Annotation
	}

}