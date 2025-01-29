package com.example.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Integer>{
}
