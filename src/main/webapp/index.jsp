<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous"/>
    <title>ToDo List App</title>
</head>
<body>

<div class="container">
    <div>
        <h1 class="text-center mt-5">To-Do List app</h1>
        <hr/>
    </div>

    <div class="mt-5">
        <form action="task" method="post" >
            <div class="row">
              <div class="col-md-4">
                  <label>
                      <input type="text" class="form-control" placeholder="Description" name="description"/>
                  </label>
              </div>
                <div class="col-md-1 form-check">
                    <input class="form-check-input " type="checkbox" name="completed" id="check">
                    <label class="form-check-label" for="check">
                        Completed
                    </label>
                </div>
               <div class="col-md-4">
                   <button class="btn btn-primary" type="submit">Add</button>
               </div>
            </div>
        </form>
    </div>
    <a href="task" class="mt-4">See all taks</a>
   <table class="table">
    <thead>
    <tr>
        <th scope="col">Task</th>
        <th scope="col">Completed</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="task" items="${tasks}">
    <tr>
        <td><c:out value="${task.description}"/></td>
        <td><c:out value="${task.completed}"/></td>
        <td>
            <form action="task" method="post">
                <input type="hidden" name="id" value="${task.id}">
                <input type="submit" class="btn btn-danger" value="Delete">
            </form>
        </td>
    </tr>
    </c:forEach>
    </tbody>
    </table>
</div>
<br/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>