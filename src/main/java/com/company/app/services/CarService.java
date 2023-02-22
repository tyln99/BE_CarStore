package com.company.app.services;

import com.company.app.model.Car;

import java.util.List;

public interface TodoService {
    List<Car> getTodos();

    Car getTodoById(Long id);

    Car insert(Car todo);

    void updateTodo(Long id, Car todo);

    void deleteTodo(Long todoId);
}
