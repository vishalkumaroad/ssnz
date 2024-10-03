<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- top navigation bar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
    <div class="container-fluid">
        <button class="navbar-toggler" type="button" data-bs-toggle="offcanvas"  data-bs-target="#sidebar" aria-controls="offcanvasExample" >
            <span class="navbar-toggler-icon" data-bs-target="#sidebar"></span>
        </button>
        <a class="navbar-brand me-auto ms-lg-0 ms-3 text-uppercase fw-bold" href="${pageContext.request.contextPath}"><img src="<c:url value="/resources/images/ssnz-logo.jpg" />" style="height: 30px; width: 30px; border-radius: 50px; margin-right: 10px;" />SSNZ</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#topNavBar" aria-controls="topNavBar" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="topNavBar">
            <form class="d-flex ms-auto my-3 my-lg-0">
                <div class="input-group">
                    <input class="form-control" type="search" placeholder="Search..." aria-label="Search"/>
                    <button class="btn btn-primary" type="submit">
                        <i class="bi bi-search"></i>
                    </button>
                </div>
            </form>
            <ul class="navbar-nav">
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle ms-2" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false" >
                        <i class="bi bi-person-fill"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end">
                        <li><button type="button" class="dropdown-item" data-bs-toggle="modal" data-bs-target="#admin-profile">
                                <span class="bi bi-person-fill me-2"></span>Profile
                            </button>
                        </li>
                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/logout"><span class="bi bi-arrow-bar-right me-2"></span>Logout</a></li>
                    </ul>
                </li>
            </ul>
        </div>
    </div>
</nav>


<%-- SIDEBAR --%>

<div class="offcanvas offcanvas-start sidebar-nav bg-dark" tabindex="-1" id="sidebar">
    <div class="offcanvas-body p-0">
        <nav class="navbar-dark">
            <ul class="navbar-nav mt-3">
                <li>
                    <a href="${pageContext.request.contextPath}/dashboard" class="nav-link px-3 active">
                        <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                        <span>Dashboard</span>
                    </a>
                </li>
                <li class="my-2"><hr class="dropdown-divider bg-light" /></li>
                <li>
                    <div class="text-muted small fw-bold text-uppercase px-3 mb-2">
                        FUNDERS
                    </div>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/funder/new-funder" class="nav-link px-3 active">
                        <span class="me-2"><i class="bi bi-cloud-plus"></i></span>
                        <span>Add New Funder</span>
                    </a>
                    <a href="${pageContext.request.contextPath}/funder/view-all" class="nav-link px-3 active">
                        <span class="me-2"><i class="bi bi-ui-radios"></i></span>
                        <span>View All Funders</span>
                    </a>
                </li>
                <li class="my-2"><hr class="dropdown-divider bg-light" /></li>
                <li>
                    <div class="text-muted small fw-bold text-uppercase px-3 mb-2">
                        PROJECTS
                    </div>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/project/new-project" class="nav-link px-3 active">
                        <span class="me-2"><i class="bi bi-cloud-plus"></i></span>
                        <span>Add New Project</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/project/view-all"  class="nav-link px-3 active">
                        <span class="me-2"><i class="bi bi-ui-radios"></i></span>
                        <span>View All Projects</span>
                    </a>
                </li>
                <li class="my-2"><hr class="dropdown-divider bg-light" /></li>
            </ul>
        </nav>
    </div>
</div>


<!-- Modal -->
<div class="modal fade" id="admin-profile" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header bg-secondary">
                <div class="container">
                    <h1 class="modal-title fs-5 text-white" align="center">ADMIN PROFILE</h1>
                </div>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-warning" data-bs-dismiss="modal">Close</button>
                <button type="button" class="btn btn-primary">Save changes</button>
            </div>
        </div>
    </div>
</div>