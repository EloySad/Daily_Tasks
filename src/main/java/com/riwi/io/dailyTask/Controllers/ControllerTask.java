package com.riwi.io.dailyTask.Controllers;

import com.riwi.io.dailyTask.Models.TaskModel;
import com.riwi.io.dailyTask.Services.ServiceTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tasks")
public class ControllerTask {

    @Autowired
    private ServiceTask serviceTask;

    @GetMapping
    public String listDailyTasks(Model model) {
        model.addAttribute("tasks", serviceTask.getAllTasks());
        return "task";
    }

    @GetMapping("/new")
    public String showNewTaskForm(Model model) {
        model.addAttribute("task", new TaskModel());
        return "new-task";
    }

    @PostMapping
    public String loadTask(@ModelAttribute("task") TaskModel task) {
        serviceTask.loadNewTask(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditTaskForm(@PathVariable("id") Long id, Model model) {
        TaskModel task = serviceTask.getTaskById(id);
        if (task != null) {
            model.addAttribute("task", task);
            return "edit-task";
        } else {
            return "redirect:/tasks";
        }
    }

    @PostMapping("/update/{id}")
    public String updateTask(@PathVariable("id") Long id, @ModelAttribute("task") TaskModel updatedTask) {
        TaskModel existingTask = serviceTask.getTaskById(id);
        if (existingTask != null) {
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setStatus(updatedTask.getStatus());
            serviceTask.loadNewTask(existingTask);
        }
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        serviceTask.deleteTask(id);
        return "redirect:/tasks";
    }
}
