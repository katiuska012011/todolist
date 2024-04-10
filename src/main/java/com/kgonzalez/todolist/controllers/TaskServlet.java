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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String descripcion = req.getParameter("description");
        String completed = req.getParameter("completed");
        if (Objects.isNull(descripcion) || descripcion.isEmpty()) {
            message = "the field can not be emty";
        } else {
            createTask(descripcion, completed);
            message = "The Task has been succefully";
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   /*     List<Task> tasks = taskService.getAll();
        req.setAttribute("tasks", tasks);
        resp.sendRedirect("/index.jsp");*/
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    private void createTask(String des, String comp) {
        try {
            Task task = new Task(des, comp != null);
            taskService.add(task);
            log.info(task.toString());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}
