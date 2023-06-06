package com.example.demo.controller;

import com.example.demo.model.Tool;
import com.example.demo.service.ToolServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ToolController {

    @Autowired
    private ToolServiceImpl toolsServiceImpl;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("alltoollist", toolsServiceImpl.getAllTools());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewTool(Model model) {
        Tool tool = new Tool();
        model.addAttribute("tool", tool);
        return "newtool";
    }

    @PostMapping("/save")
    public String saveTool(@ModelAttribute("tool") Tool tool) {
        toolsServiceImpl.save(tool);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Tool tool = toolsServiceImpl.getById(id);
        toolsServiceImpl.deleteViaId(id);
        model.addAttribute("tool", tool);
        return "update";
    }

    @GetMapping("/deleteTool/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
        toolsServiceImpl.deleteViaId(id);
        return "redirect:/";

    }
}