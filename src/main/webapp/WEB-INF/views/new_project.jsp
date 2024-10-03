<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.n2n.ssnz.util.Constants" %>
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
                <form action="${pageContext.request.contextPath}/project/add-project" method="post">
                    <div class="row g-3">
                        <div class="col-md-5">
                            <label class="form-label"><span class="text-danger">*</span>Name:</label>
                            <input type="text" name="name" placeholder="project name here..." class="form-control" required>
                        </div>
                        <div class="col-md-5 offset-md-1">
                            <label class="form-label"><span class="text-danger">*</span>Description:</label>
                            <input type="text" name="description" placeholder="description here..." class="form-control" required>
                        </div>
                        <div class="col-md-5">
                            <label class="form-label"><span class="text-danger">*</span>Start Date:</label>
                            <div class="input-group date" id="startDatePicker">
                                <input type="text" id="startDate" placeholder="start date here..." name="startDate" class="form-control" required>
                                <span class="input-group-append" style="cursor: pointer;">
                                    <i class="input-group-text bg-white bi bi-calendar2-day border-secondary" style="height: 100%;"></i>
                                </span>
                            </div>
                        </div>
                        <div class="col-md-5 offset-md-1">
                            <label class="form-label"><span class="text-danger">*</span>End Date:</label>
                            <div class="input-group date" id="endDatePicker">
                                <input type="text" id="endDate" placeholder="end date here..." name="endDate" class="form-control" required>
                                <span class="input-group-append" style="cursor: pointer;">
                                    <i class="input-group-text bg-white bi bi-calendar2-day border-secondary" style="height: 100%;"></i>
                                </span>
                            </div>
                        </div>
                        <div class="col-md-5">
                            <label class="form-label"><span class="text-danger">*</span>Min Budget:</label>
                            <input type="number" name="minBudget" placeholder="min budget here..." class="form-control" required>
                        </div>
                        <div class="col-md-5 offset-md-1">
                            <label class="form-label"><span class="text-danger">*</span>Max Budget:</label>
                            <input type="number" name="maxBudget" placeholder="max budget here..." class="form-control" required>
                        </div>
                        <div class="col-md-5">
                            <label class="form-label"><span class="text-danger">*</span>Contact Email: </label>
                            <input type="email" name="contactEmail" placeholder="contact email here..." class="form-control" required>
                        </div>
                        <div class="col-md-5 offset-md-1">
                            <label class="form-label"><span class="text-danger">*</span>Contact Phone:</label>
                            <input type="text" name="contactPhoneNumber" placeholder="contact phone here..." class="form-control" required>
                        </div>
                        <div class="col-md-5">
                            <label class="form-label"><span class="text-danger">*</span>Location: </label>
                            <input type="text" name="location" placeholder="location here..." class="form-control" required>
                        </div>
                        <div class="col-md-5 offset-md-1">
                            <label class="form-label"><span class="text-danger">*</span>Country:</label>
                            <select class="form-select" required name="country">
                                <option>----- SELECT STATUS -----</option>
                            </select>
                        </div>
                        <div class="col-md-5">
                            <label class="form-label"><span class="text-danger">*</span>Status </label>
                            <select class="form-select" name="status" required>
                                <option selected disabled vaue="0" class="fw-bold">----- SELECT STATUS -----</option>
                                <c:forEach var="entry" items="${Constants.PROJECT_STATUS}">
                                    <option value="${entry.key}">${entry.value}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-5 offset-md-1">
                            <label class="form-label"><span class="text-danger">*</span>Year:</label>
                            <input type="number" name="year" placeholder="year here..." class="form-control" required>
                        </div>                       
                        <div class="col-md-5">
                            <label class="form-label"><span class="text-danger">*</span>Remainder Date:</label>
                            <div class="input-group date" id="remainderDatePicker" required>
                                <input type="text" id="remainderDate" placeholder="end date here..." name="remainderDate" class="form-control">
                                <span class="input-group-append" style="cursor: pointer;">
                                    <i class="input-group-text bg-white bi bi-calendar2-day border-secondary" style="height: 100%;"></i>
                                </span>
                            </div>
                        </div>
                        <div class="col-md-5 offset-md-1">
                            <label class="form-label"><span class="text-danger">*</span>Select Funder:</label>
                            <select class="form-select" name="funder.funderId" required>
                                <option selected disabled vaue="0" class="fw-bold">----- SELECT FUNDER -----</option>
                                <c:forEach var="funder" items="${allFunders}">
                                    <option value="${funder.funderId}">${funder.funderName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-11">
                            <label class="form-label"><span class="text-danger">*</span>Eligibility:</label>
                            <input type="text" name="eligibility" placeholder="eligibility here..." class="form-control" required>
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
