<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <base href="<c:url value="/"/>">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="vendor/metisMenu/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Please register new account</h3>
                </div>
                <div class="panel-body">
                    <form:form role="form" action="user/create" method="post" modelAttribute="form">
                        <fieldset>
                        	<c:set var="salutationError"><form:errors path="salutation" cssClass="help-block" /></c:set>
                            <div class="form-group ${(not empty salutationError) ? 'has-error' : ''}">
							    <label class="control-label">Salutation</label>
							    <form:input path="salutation" class="form-control" placeholder="Salutation" type="text" />
							    <c:if test="${not empty salutationError}">
							    	${salutationError}
							    </c:if>
                            </div>
                            
                            <c:set var="firstNameError"><form:errors path="firstName" cssClass="help-block" /></c:set>
                            <div class="form-group ${(not empty firstNameError) ? 'has-error' : ''}">
							    <label class="control-label">First name</label>
							    <form:input path="firstName" class="form-control" placeholder="First name" type="text" />
							    <c:if test="${not empty firstNameError}">
							    	${firstNameError}
							    </c:if>
                            </div>
                            
                            <c:set var="lastNameError"><form:errors path="lastName" cssClass="help-block" /></c:set>
                            <div class="form-group ${(not empty lastNameError) ? 'has-error' : ''}">
							    <label class="control-label">Last name</label>
							    <form:input path="lastName" class="form-control" placeholder="Last name" type="text" />
							    <c:if test="${not empty lastNameError}">
							    	${lastNameError}
							    </c:if>
                            </div>
                            
                            <c:set var="streetError"><form:errors path="street" cssClass="help-block" /></c:set>
                            <div class="form-group ${(not empty streetError) ? 'has-error' : ''}">
							    <label class="control-label">Street</label>
							    <form:input path="street" class="form-control" placeholder="Street" type="text" />
							    <c:if test="${not empty streetError}">
							    	${streetError}
							    </c:if>
                            </div>
                            
                            <c:set var="houseNumberError"><form:errors path="houseNumber" cssClass="help-block" /></c:set>
                            <div class="form-group ${(not empty houseNumberError) ? 'has-error' : ''}">
							    <label class="control-label">House number</label>
							    <form:input path="houseNumber" class="form-control" placeholder="House number" type="text" />
							    <c:if test="${not empty houseNumberError}">
							    	${houseNumberError}
							    </c:if>
                            </div>
                            
                            <c:set var="cityError"><form:errors path="city" cssClass="help-block" /></c:set>
                            <div class="form-group ${(not empty cityError) ? 'has-error' : ''}">
							    <label class="control-label">City</label>
							    <form:input path="city" class="form-control" placeholder="City" type="text" />
							    <c:if test="${not empty cityError}">
							    	${cityError}
							    </c:if>
                            </div>
                            
                            <c:set var="countryError"><form:errors path="country" cssClass="help-block" /></c:set>
                            <div class="form-group ${(not empty countryError) ? 'has-error' : ''}">
							    <label class="control-label">Country</label>
							    <form:input path="country" class="form-control" placeholder="Country" type="text" />
							    <c:if test="${not empty countryError}">
							    	${countryError}
							    </c:if>
                            </div>
                            
                            <c:set var="emailError"><form:errors path="email" cssClass="help-block" /></c:set>
                            <div class="form-group ${(not empty emailError) ? 'has-error' : ''}">
							    <label class="control-label">E-mail address</label>
							    <form:input path="email" class="form-control" placeholder="E-mail address" type="text" />
							    <c:if test="${not empty emailError}">
							    	${emailError}
							    </c:if>
                            </div>
                            
                            <c:set var="passwordError"><form:errors path="password" cssClass="help-block" /></c:set>
                            <div class="form-group ${(not empty passwordError) ? 'has-error' : ''}">
							    <label class="control-label">Password</label>
							    <form:input path="password" class="form-control" placeholder="Password" type="password" />
							    <c:if test="${not empty passwordError}">
							    	${passwordError}
							    </c:if>
                            </div>
                            
                            <c:set var="retypePasswordError"><form:errors path="passwordValid" cssClass="help-block" /><form:errors path="retypePassword" cssClass="help-block" /></c:set>
                            <div class="form-group ${(not empty retypePasswordError) ? 'has-error' : ''}">
							    <label class="control-label">Retype password</label>
							    <form:input path="retypePassword" class="form-control" placeholder="Retype password" type="password" />
							    <c:if test="${not empty retypePasswordError}">
							    	${retypePasswordError}
							    </c:if>
                            </div>
                            
                            <!-- Change this to a button or input when using this as a form -->
                            <input type="submit" class="btn btn-lg btn-success btn-block" value="Register"/>
                            <a href="login" class="btn btn-default btn-block">Go back to login</a>
                        </fieldset>
                    </form:form>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="vendor/jquery/jquery.min.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>

<!-- Metis Menu Plugin JavaScript -->
<script src="vendor/metisMenu/metisMenu.min.js"></script>

<!-- Custom Theme JavaScript -->
<script src="dist/js/sb-admin-2.js"></script>

</body>

</html>
