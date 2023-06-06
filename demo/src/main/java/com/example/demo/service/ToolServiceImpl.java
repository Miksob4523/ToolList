package com.example.demo.service;
import java.util.List;
import java.util.Optional;
import com.example.demo.model.Tool;
import com.example.demo.repo.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ToolServiceImpl
        implements ToolService {

    @Autowired private ToolRepository toolRepo;

    @Override public List<Tool> getAllTools()
    {
        return toolRepo.findAll();
    }

    @Override public void save(Tool tool)
    {
        toolRepo.save(tool);
    }

    @Override public Tool getById(Long id)
    {
        Optional<Tool> optional = toolRepo.findById(id);
        Tool tool = null;
        if (optional.isPresent())
            tool = optional.get();
        else
            throw new RuntimeException(
                    "Tool not found for id : " + id);
        return tool;
    }

    @Override public void deleteViaId(long id)
    {
        toolRepo.deleteById(id);
    }
}