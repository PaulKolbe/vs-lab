package de.vslab.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoItemRepository extends JpaRepository<TodoItem, String> {

    TodoItem findByTodo(String name);
}
