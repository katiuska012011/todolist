package com.kgonzalez.todolist.controllers;

import com.kgonzalez.todolist.models.Task;
import com.kgonzalez.todolist.services.TaskService;
import jakarta.ejb.TransactionAttribute;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

@WebServlet(name = "todoListServlet", value = "/task")
public class TaskServlet extends HttpServlet {
    Logger log = Logger.getLogger(TaskServlet.class.getName());
    @Inject
    private TaskService taskService;
    private String message;

    public void init() {
        message = "Task Controler!";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String descripcion = req.getParameter("description");
        String completed = req.getParameter("completed");
        String id = req.getParameter("id");
        if (Objects.isNull(descripcion) || descripcion.isEmpty()) {
            message = "the field can not be emty";
        } else {
            createTask(descripcion, completed);
            resp.sendRedirect(req.getContextPath() +"/index.jsp");
        }

        if(Objects.nonNull(id) || !id.isEmpty()){
            delete(id);
            resp.sendRedirect(req.getContextPath() +"/index.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Task> tasks = taskService.getAll();
        req.setAttribute("tasks", tasks);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }



    private void createTask(String des, String comp) {
        try {
            Task task = new Task(des, comp != null);
            taskService.add(task);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    private void delete(String atribute){
        Long id = Long.parseLong(atribute);
        taskService.deleteById(id);
    }

}
