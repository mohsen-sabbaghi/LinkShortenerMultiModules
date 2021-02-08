<%--
  Created by IntelliJ IDEA.
  User: Mohsen
  Date: 2/6/2021
  Time: 6:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Link Shortener</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<h2>Link Shortener...</h2>
<hr>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-2"></div>
        <div class="col-md-8">
            <form method="post" action="/create/link">

                <div class="form-group">

                    <div class="form-group col-sm-6">
                        <label for="longUrl">Url:</label>
                        <input class="form-control" type="text" placeholder="Enter Url..." name="longUrl"
                               id="longUrl">
                    </div>

                    <div class="form-group col-sm-3">
                        <label for="desire_link">Your Desired Url:</label>
                        <input class="form-control" type="text" placeholder="Enter your choice Url..."
                               name="desire_link" id="desire_link">
                    </div>

                    <div class="form-group col-sm-3">
                        <label for="expired-date">Expired date:</label>
                        <input class="form-control" type="date" name="expired-date" id="expired-date">
                    </div>
                </div>
                <div class="row">
                    <div class="center">
                        <button type="submit" class="btn btn-primary">Make it Short!</button>
                    </div>
                </div>

            </form>
        </div>
        <div class="col-md-2"></div>
    </div>
</div>
</body>
</html>
