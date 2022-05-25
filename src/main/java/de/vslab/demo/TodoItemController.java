package de.vslab.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@EntityScan("de.hsesslingen.*")
@RestController
@RequestMapping("/todos/")
public class TodoItemController {

	TodoItemRepository todoItemsRepository;

	@GetMapping()
	public List<TodoItem> getTodoItems() {
		return todoItemsRepository.findAll();
	}

	@GetMapping("/{name}")
	public TodoItem getTodoItemByTodo(@PathVariable("name") String name) {
		return todoItemsRepository.findByTodo(name);
	}

	@PostMapping()
	public TodoItem createTodoItem(@RequestBody TodoItem todoItem) {
		return todoItemsRepository.save(todoItem);
	}

	@DeleteMapping("/{name}")
	public TodoItem deleteTodoItem(@PathVariable("name") String name) {
		return todoItemsRepository.getReferenceById(name);
	}

	@PutMapping()
	public TodoItem updateTodoItem(@RequestBody TodoItem todoItem) {
		TodoItem oldItem = todoItemsRepository.findByTodo(todoItem.getTodo());
		oldItem.setPriority(todoItem.getPriority());
		return todoItemsRepository.save(oldItem);
	}
}
