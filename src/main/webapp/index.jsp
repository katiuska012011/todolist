<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
          crossorigin="anonymous">
    <title>ToDo List App</title>
</head>
<body>

<div class="container">
    <div>
        <h1 class="text-center mt-5">To-Do List app</h1>
        <hr>
    </div>

    <div>
        <form action="task" method="post" >
            <div class="row">
              <div class="col-md-4">
                  <input type="text" class="form-control" placeholder="Description" name="description">
              </div>
                <div class="col-md-1">
                    <input class="form-check-input " type="checkbox" name="completed">
                </div>
                <button class="btn btn-primary col-md-1" type="submit">Add</button>
            </div>
        </form>
    </div>

    <div class="mt-5">
        <a href="task"> hello</a>
        <div class="alert alert-light" role="alert">
            <div class="row">
                <div class="col-md-12">
                    <a href="edit" class="float-sm-end btn btn-primary "> Edit</a>
                    <a href="delete" class="float-sm-end btn btn-danger"> Delete</a>
                </div>
            </div>
        </div>

    </div>
</div>
<br/>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
</body>
</html>