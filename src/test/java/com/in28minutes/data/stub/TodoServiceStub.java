package com.in28minutes.data.stub;

import com.in28minutes.data.api.TodoService;

import java.util.Arrays;
import java.util.List;

public class TodoServiceStub implements TodoService {
	public List<String> retrieveTodos(String user) {
		return Arrays.asList("Learn Spring MVC", "Learn Spring",
				"Learn to Dance"); 	// dummy implementation; sample todo service
	}

	public void deleteTodo(String todo) {

	}
}