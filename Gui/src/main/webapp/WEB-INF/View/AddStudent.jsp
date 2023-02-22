<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Add Anime</title>

    <link rel="stylesheet"
    	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet"
        href="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.css">
    <script
    	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script
    	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <script
        src="https://cdnjs.cloudflare.com/ajax/libs/toastr.js/latest/toastr.min.js"></script>

</head>
<body>

    <div class="container">

        <h1 class="p-3"> Add Student Details </h1>

        <form:form action="/SaveStudent" method="post" modelAttribute="AddStudent">

            <!-- For first name -->
            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="fname">FirstName</label>
            		<div class="col-md-6">
            		    <form:input type="text" path="fname" id="fname"
            		        class="form-control input-sm" required="required" />
            		</div>
            	</div>
            </div>
            <!-- For Last name -->
            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="lname">LastName</label>
            		<div class="col-md-6">
            		    <form:input type="text" path="lname" id="lname"
            		        class="form-control input-sm" required="required" />
            		</div>
            	</div>
            </div>

             <!-- For Mobile No -->
            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="mob">Mobile no.</label>
            		<div class="col-md-6">
            		    <form:input type="number" path="mob" id="mob"
            		        class="form-control input-sm" required="required" />
            		</div>
            	</div>
            </div>

            <!-- For Email -->
            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="email"> Email </label>
            		<div class="col-md-6">
            		    <form:input type="email" path="email" id="email"
            		        class="form-control input-sm" required="required" />
            		</div>
            	</div>
            </div>


            <div class="row p-2">
            	<div class="col-md-2">
            		<button type="submit" value="Submit" class="btn btn-success">Save</button>
            	</div>
            </div>

        </form:form>

    </div>

    <script th:inline="javascript">
            window.onload = function() {
                var msg = "${message}";
                console.log(msg);
                if (msg == "ata not Saved") {
    				Command: toastr["error"]("Something went wrong with the save.")
    			}
    			toastr.options = {
                      "closeButton": true,
                      "debug": false,
                      "newestOnTop": false,
                      "progressBar": true,
                      "positionClass": "toast-top-right",
                      "preventDuplicates": false,
                      "showDuration": "300",
                      "hideDuration": "1000",
                      "timeOut": "5000",
                      "extendedTimeOut": "1000",
                      "showEasing": "swing",
                      "hideEasing": "linear",
                      "showMethod": "fadeIn",
                      "hideMethod": "fadeOut"
                    }
    	    }
        </script>

</body>

</html>