<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="webjars\bootstrap\5.1.3\css\bootstrap.min.css">
    <link rel="stylesheet" href="webjars\bootstrap-datepicker\1.9.0\css\bootstrap-datepicker.standalone.min.css">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add todo Page</title>
</head>
<body>
    <div class="container">
        <h1> Enter the Todo Details </h1>
        <form:form method="post" modelAttribute="todo">
            <fieldset class="mb-3">
                <form:label path="description">Description</form:label>
                <form:input type="text"  path="description" required="required"/>
                <form:errors path="description" cssClass="text-warning"/>
            </fieldset>

            <fieldset class="mb-3">
                 <form:label path="targetDate">Target Date</form:label>
                 <form:input type="text"  path="targetDate" required="required"/>
                 <form:errors path="targetDate" cssClass="text-warning"/>
            </fieldset>

            <form:input type="hidden"  path="id"/>
            <form:input type="hidden"  path="done"/>
            <input type="submit" class="btn btn-success"/>
        </form:form>
    </div>
</body>
<script src="webjars\bootstrap\5.1.3\js\bootstrap.min.js"></script>
<script src="webjars\jquery\3.6.0\jquery.min.js"></script>
<script src="webjars\bootstrap-datepicker\1.9.0\js\bootstrap-datepicker.min.js"></script>
<script type = "text/javascript">
$('#targetDate').datepicker({
    format: 'yyyy-mm-dd',
    startDate: '-3d'
});
</script>
</html>

