<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="dashboard_header.jsp" %>
        <style>
            input,select{
                border: 1px solid grey !important;
            }

            label{
                font-weight: bold !important;
            }
        </style>
    </head>
    <body>

        <%-- SIDE BAR AND TOP BAR --%>
        <%@include file="dashboard_topbar.jsp" %>

        <main class="mt-5 pt-3">
            <div class="container-fluid mt-4">
                <div class="row">
                    <div class="col-md-12">
                        <h4>${title}</h4>
                    </div>
                </div>
            </div>
            <div class="container mt-4">
                <form action="${pageContext.request.contextPath}/funder/add-funder-handler" method="post">
                    <div class="row g-3">
                        <div class="col-md-5">
                            <label class="form-label"><span class="text-danger">*</span>Name:</label>
                            <input type="text" name="funderName" placeholder="funder name here..." class="form-control" required>
                        </div>
                        <div class="col-md-5 offset-md-1">
                            <label class="form-label"><span class="text-danger">*</span>Type:</label>
                            <input type="text" name="funderType" placeholder="funder type here..." class="form-control" required>
                        </div>
                        <div class="col-md-5">
                            <label class="form-label"><span class="text-danger">*</span>Email:</label>
                            <input type="email" name="email" placeholder="funder email here..." class="form-control" required>
                        </div>
                        <div class="col-md-5 offset-md-1">
                            <label class="form-label"><span class="text-danger">*</span>Phone Number:</label>
                            <input type="text" name="phoneNumber" placeholder="funder phone number here..." class="form-control" required>
                        </div>
                        <div class="col-md-5">
                            <label class="form-label"><span class="text-danger">*</span>Website:</label>
                            <input type="text" name="website" placeholder="funder webiste here..." class="form-control" required>
                        </div>
                        <div class="col-md-5 offset-md-1">
                            <label class="form-label"><span class="text-danger">*</span>City:</label>
                            <input type="text" name="city" placeholder="funder city here..." class="form-control" required>
                        </div>
                        <div class="col-md-5">
                            <label class="form-label"><span class="text-danger">*</span>Country: </label>
                            <input type="text" name="country" placeholder="funder country here..." class="form-control" required>
                        </div>
                        <div class="col-md-5 offset-md-1">
                            <label class="form-label"><span class="text-danger">*</span>Funder Details:</label>
                            <input type="text" name="funderDetails" placeholder="funder details here..." class="form-control" required>
                        </div>
                    </div>
                    <div class="container mt-5 text-center">
                        <button type="submit" class="btn btn-primary"> Save </button>
                    </div>
                </form>
            </div>
        </main>

        <%@include file="dashboard_footer.jsp" %>
    </body>
</html>
