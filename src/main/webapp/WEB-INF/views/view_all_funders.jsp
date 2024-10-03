<%@page import="com.n2n.ssnz.util.Message"%>
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
                <div class="row">
                    <div class="col-md-12 mb-3">
                        <div class="card">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table id="example" class="table table-hover table-striped data-table" style="width: 100%" >
                                        <thead>
                                            <tr>
                                                <th>Name</th>
                                                <th>Type</th>
                                                <th>Phone</th>
                                                <th>City</th>
                                                <th>Details</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="funder" items="${funders}">
                                                <tr>
                                                    <td>${funder.funderName}</td>
                                                    <td>${funder.funderType}</td>
                                                    <td>${funder.phoneNumber}</td>
                                                    <td>${funder.city}</td>
                                                    <td>${funder.funderDetails}</td>
                                                </tr>
                                            </c:forEach>
                                        </tbody>
                                        <tfoot>
                                            <tr>
                                                <th>Name</th>
                                                <th>Type</th>
                                                <th>Phone</th>
                                                <th>City</th>
                                                <th>Details</th>
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>

        <!-- Message start -->
        <%
            Message m = (Message) session.getAttribute("message");
            if (m != null) {
        %>
        <script>
            swal("<%= m.getMessage()%>", "", "<%= m.getType()%>");
        </script>
        <%
                session.removeAttribute("message");
            }
        %>
        <!-- Message ends -->

        <%@include file="dashboard_footer.jsp" %>
    </body>
</html>
