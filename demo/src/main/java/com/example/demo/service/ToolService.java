package com.example.demo.service;


import com.example.demo.model.Tool;

import java.util.List;


public interface ToolService {
    List<Tool> getAllTools();
    void save(Tool tool);
    Tool getById(Long id);
    void deleteViaId(long id);
}