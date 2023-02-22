<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>View Student List</title>

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

    <style>
        a{
            color: white;
        }
        a:hover {
            color: white;
            text-decoration: none;
        }
    </style>

</head>
<body>

    <div class="container">

        <h1 class="p-3"> Student List </h1>

        <form:form>

            <table class="table table-bordered">
            	<tr>
            		<th>Student id</th>
            		<th>First Name</th>
            		<th>Last Name</th>
            		<th>Mobile No</th>
            		<th>Email</th>
                    <th>Edit</th>   
            		<th>Delete</th>

            	<c:forEach var="Student" items="${studentVo}">
                    <tr>
                		<td>11${Student.student_id}</td>
                		<td>${Student.firstname}</td>
                        <td>${Student.lastname}</td>
                        <td>${Student.mobileNo}</td>
                        <td>${Student.email}</td>
                		
                		<td><button type="button" class="btn btn-success">
                		    <a href="/EditStudent/${Student.student_id}">Edit</a>
                		</button></td>
                		<td><button type="button" class="btn btn-danger">
                			<a href="/DeleteStudent/${Student.student_id}">Delete</a>
                		</button></td>
                	</tr>

            	</c:forEach>

            </table>

        </form:form>

        <button type="button" class="btn btn-primary btn-block">
        	<a href="/AddStudent">Add New Student</a>
        </button>

    </div>

    <script th:inline="javascript">
                window.onload = function() {

                    var msg = "${message}";
                    console.log(msg);
                    if (msg == "Data Saved") {
        				Command: toastr["success"]("Student added successfully!!")
        			} else if (msg == "Student Deleted") {
        				Command: toastr["success"]("Student deleted successfully!!")
        			} else if (msg == "Student not Deleted") {
        			    Command: toastr["error"]("Some error occurred, couldn't delete user")
        			} else if (msg == "Student Updated") {
        				Command: toastr["success"]("Student updated successfully!!")
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