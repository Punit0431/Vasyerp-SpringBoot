<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>

<head>
    <meta charset="ISO-8859-1">
    <title>Add Student</title>


     <!--Jquery Link-->
        <%-- <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script><script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.repeater/1.2.1/jquery.repeater.min.js"></script><script type="text/javascript">
         $(document).ready(function () {
            $('.repeater').repeater({
             initEmpty: false,
             show: function () {
                 $(this).slideDown();
                 },
                 hide: function (deleteElement) {
                     if(confirm('Are you sure you want to delete this element?')) {
                     $(this).slideUp(deleteElement);
                     }
                 },
             ready: function (setIndexes) {
             },
             isFirstItemUndeletable: true
             });
         });
	 --%>

<%-- //   $(document).ready(function()
 
//     {
// 	 var x = 0; //Initial field counter
// 	var list_maxField = 10; //Input fields increment limitation
	
//         //Once add button is clicked
// 	$('.list_add_button').click(function()
// 	    {
// 	    //Check maximum number of input fields
// 	    if(x < list_maxField){ 
// 	        x++; //Increment field counter
// 	        var list_fieldHTML = '<div class="row"><div class="form-group col-md-12"><div class="form-group"><input name="list['+x+'][]" type="text" placeholder="Type Item Name" class="form-control"/></div></div><div class="col-xs-7 col-sm-7 col-md-7"><div class="form-group"><input name="list['+x+'][]" type="text" placeholder="Type Item Quantity" class="form-control"/></div></div><div class="col-xs-1 col-sm-7 col-md-1"><a href="javascript:void(0);" class="list_remove_button btn btn-danger">-</a></div></div>'; //New input field html 
// 	        $('.list_wrapper').append(list_fieldHTML); //Add field html
// 	    }
//         });
    
//         //Once remove button is clicked
//         $('.list_wrapper').on('click', '.list_remove_button', function()
//         {
//            $(this).closest('div.row').remove(); //Remove field html
//            x--; //Decrement field counter
//         });
// });  --%>

	
	


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

        <h1 class="p-3"> Add Student </h1>

        <form:form action="/saveStudent" method="post" modelAttribute="Student">
            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="student_id">Student ID</label>
            		<div class="col-md-6">
            		    <form:input type="nunmber" path="student_id" id="student_id"
            		        class="form-control input-sm" required="required" />
            		</div>
            	</div>
               
            </div>
            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="stud_name">Student Name</label>
            		<div class="col-md-6">
            		    <form:input type="text" path="stud_name" id="stud_name"
            		        class="form-control input-sm" required="required" />
            		</div>
            	</div>
               
            </div>
             <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="Course"> Select Course </label>
            		<div class="col-md-6">
            		    <select name="courses[0].course_id"class="form-control" required>
                            
                            <c:forEach var = "data" items="${courseList}">
                                <option id="${data.course_id}"  value="${data.course_id}" >${data.courseName}</option>
                            </c:forEach>
                        </select>
            		</div>
            	</div>
               
            </div>
            <div class="row">
            	<div class="form-group col-md-12">
            		<label class="col-md-3" for="Course"> Select Course </label>
            		<div class="col-md-6">
            		    <select name="courses[1].course_id" class="form-control" required>
                            
                            <c:forEach var ="data" items="${courseList}">
                                <option id="${data.course_id}" value="${data.course_id}" >${data.courseName}</option>
                            </c:forEach>
                        </select>
            		</div>
            	</div>
               
            </div>

             

            <div class="row p-3">
            	<div class="col-md-2">
            		<button type="submit" value="Register" class="btn btn-success">Save</button>
            	</div>
            </div>

        </form:form>

    </div>

    <script th:inline="javascript">
            window.onload = function() {

                var msg = "${message}";
                console.log(msg);
                if (msg == "Save Failure") {
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