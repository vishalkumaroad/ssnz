<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <%@include file="dashboard_header.jsp" %>
    </head>
    <body>

        <%-- SIDE BAR AND TOP BAR --%>
        <%@include file="dashboard_topbar.jsp" %>

        <main class="mt-5 pt-3">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-md-12">
                        <h4>${title}</h4>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-4 mb-3">
                        <div class="card bg-primary text-white h-100">
                            <div class="d-flex justify-content-between align-items-center py-5">
                                <div class="fs-5 ms-3">FUNDERS</div>
                                <div class="fs-4 me-3">${funderCount}</div>
                            </div>
                            <a href="${pageContext.request.contextPath}/funder/view-all" class="card-footer d-flex text-white" style="text-decoration: none;">
                                View Details
                                <span class="ms-auto">
                                    <i class="bi bi-chevron-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <div class="card bg-warning text-white h-100">
                            <div class="d-flex justify-content-between align-items-center py-5">
                                <div class="fs-5 ms-3">PROJECTS</div>
                                <div class="fs-4 me-3">${projectCount}</div>
                            </div>
                            <a href="${pageContext.request.contextPath}/project/view-all" class="card-footer d-flex text-white" style="text-decoration: none;">
                                View Details
                                <span class="ms-auto">
                                    <i class="bi bi-chevron-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                    <div class="col-md-4 mb-3">
                        <div class="card bg-success text-white h-100">
                            <div class="d-flex justify-content-between align-items-center py-5">
                                <div class="fs-5 ms-3">APPLICATIONS</div>
                                <div class="fs-4 me-3">${projectCount}</div>
                            </div>
                            <a href="${pageContext.request.contextPath}/project/view-all" class="card-footer d-flex text-white" style="text-decoration: none;">
                                View Details
                                <span class="ms-auto">
                                    <i class="bi bi-chevron-right"></i>
                                </span>
                            </a>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-md-6 mb-3">
                        <div class="card h-100">
                            <div class="card-header">
                                <span class="me-2"><i class="bi bi-bar-chart-fill"></i></span>
                                Area Chart Example
                            </div>
                            <div class="card-body">
                                <canvas class="chart" width="400" height="200"></canvas>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-6 mb-3">
                        <div class="card h-100">
                            <div class="card-header">
                                <span class="me-2"><i class="bi bi-bar-chart-fill"></i></span>
                                Area Chart Example
                            </div>
                            <div class="card-body">
                                <canvas class="chart" width="400" height="200"></canvas>
                            </div>
                        </div>
                    </div>
                </div>
        </main>


        <!-- Button trigger modal -->

        <%@include file="dashboard_footer.jsp" %>
    </body>
</html>
