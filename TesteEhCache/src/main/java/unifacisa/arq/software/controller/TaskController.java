package unifacisa.arq.software.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import unifacisa.arq.software.model.Task;
import unifacisa.arq.software.service.TaskService;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;

    @GetMapping
    public List<Task> findAll(@RequestParam(required = false) boolean noCache) {
        return taskService.findAll(noCache);
    }

    @PutMapping("/{id}")
    public Task update(@PathVariable("id") long id, @RequestParam(required = false) boolean noCache) {
        return taskService.update(id, noCache);
    }

    @DeleteMapping("/cache")
    public void clearCache() {
        taskService.clearCache();
    }
}
