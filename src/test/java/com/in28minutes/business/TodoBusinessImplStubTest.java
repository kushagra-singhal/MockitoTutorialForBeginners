package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.stub.TodoServiceStub;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TodoBusinessImplStubTest {

	TodoService todoService = new TodoServiceStub();
	TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
	@Test
	public void testRetrieveTodosRelatedToSpring_usingAStub() {
		List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
		assertEquals(2, filteredTodos.size());
	}

	@Test
	public void testRetrieveTodosRelatedToSpring_checkingSpring(){
		List<String> fl = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		assertEquals("[Learn Spring MVC, Learn Spring]",fl.toString());
	}
			// OR
	@Test
	public void testRetrieveTodosRelatedToSpring_checkingSpring2(){
		List<String> fl2 = todoBusinessImpl.retrieveTodosRelatedToSpring("Spring");
		String word = fl2.toString();
		assertTrue(word.contains("Spring"));
	}
}
