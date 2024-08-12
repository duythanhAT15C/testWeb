<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<title>Donation website &mdash; Website Donation</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description" content="" />
<meta name="keywords" content="" />
<meta name="author" content="Free-Template.co" />
<link rel="shortcut icon"
	href="${pageContext.request.contextPath}/resources/static/user/assets/images/house-32-237998.png">

<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/user/assets/css/custom-bs.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/user/assets/css/jquery.fancybox.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/user/assets/css/bootstrap-select.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/user/assets/fonts/icomoon/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/user/assets/fonts/line-icons/style.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/user/assets/css/owl.carousel.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/user/assets/css/animate.min.css">

<!-- MAIN CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/static/user/assets/css/style.css">

<script
	src="${pageContext.request.contextPath}/resources/static/user/assets/js/jquery.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/static/user/assets/js/bootstrap.bundle.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/static/user/assets/js/isotope.pkgd.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/static/user/assets/js/stickyfill.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/static/user/assets/js/jquery.fancybox.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/static/user/assets/js/jquery.easing.1.3.js"></script>

<script
	src="${pageContext.request.contextPath}/resources/static/user/assets/js/jquery.waypoints.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/static/user/assets/js/jquery.animateNumber.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/static/user/assets/js/owl.carousel.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/static/user/assets/js/bootstrap-select.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/static/user/assets/js/custom.js"></script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body id="top">

	<div id="overlayer"></div>
	<div class="loader">
		<div class="spinner-border text-primary" role="status">
			<span class="sr-only">Loading...</span>
		</div>
	</div>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

	<!-- 
	
		<c:if test="${not empty msg}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<div class="toast-body">
				<script>
                 swal({
                     title: 'Donate Successfully!',
                     text: 'Redirecting...',
                     icon: 'success',
                     timer: 3000,
                     buttons: true,
                     type: 'success'
                 })
            </script>
			</div>
		</div>
	</c:if>
	
	 -->

	<c:if test="${not empty msgDonate}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Donate Successfully!',
						text : '${msgDonate}',
						icon : 'success',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
	</c:if>
	<c:if test="${not empty msgDetailFalse}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Donate False!',
						text : '${msgDetailFalse}',
						icon : 'error',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
		<c:set var="msgDetailId" scope="request" value="" />
	</c:if>
	<c:if test="${not empty msgMoneyFalse}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Donate False!',
						text : '${msgMoneyFalse}',
						icon : 'error',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
		<c:set var="msgDetailId" scope="request" value="" />
	</c:if>
	<div class="site-wrap">

		<div class="site-mobile-menu site-navbar-target">
			<div class="site-mobile-menu-header">
				<div class="site-mobile-menu-close mt-3">
					<span class="icon-close2 js-menu-toggle"></span>
				</div>
			</div>
			<div class="site-mobile-menu-body"></div>
		</div>
		<!-- .site-mobile-menu -->


		<!-- NAVBAR -->
		<header class="site-navbar mt-3">
			<div class="container-fluid">
				<div class="row align-items-center">
					<div class="site-logo col-6">
						<a href="${pageContext.request.contextPath}/public/">Website
							Quyên Góp</a>
					</div>
					<div
						class="right-cta-menu text-right d-flex aligin-items-center col-6">
						<div class="ml-auto">
							<c:if test="${not empty sessionScope.user}">
								<a href="${'/user/info/'}${sessionScope.user.id}"
									class="btn btn-outline-white border-width-2 d-none d-lg-inline-block mr-2">
									<span>${sessionScope.user.fullName}</span>
								</a>
								<a href="logout"
									class="btn btn-primary border-width-2 d-none d-lg-inline-block">Đăng
									xuất</a>
							</c:if>
							<c:if test="${empty sessionScope.user}">
								<a href="login"
									class="btn btn-primary border-width-2 d-none d-lg-inline-block">
									<span class="mr-2 icon-lock_outline"></span>Đăng nhập
								</a>
							</c:if>

						</div>
					</div>
				</div>
			</div>
		</header>

		<!-- HOME -->
		<section class="section-hero overlay inner-page bg-image"
			style="background-image: url('${pageContext.request.contextPath}/resources/static/user/assets/images/hero_1.jpg');"
			id="home-section">
			<div class="container">
				<div class="row">
					<div class="col-md-7">
						<h1 class="text-white font-weight-bold">Danh sách các đợt
							quyên góp</h1>

					</div>
				</div>
			</div>
		</section>
		<section class="site-section">
			<div class="container">

				<div class="row mb-5 justify-content-center">
					<div class="col-md-7 text-center">
						<h2 class="section-title mb-2">Các đợt quyên góp</h2>
					</div>
				</div>

				<ul id="job-listings" class="job-listings mb-5">
					<c:forEach var="category" items="${list}">
						<c:if test="${category.deleteFlag == 1 && category != null}">
							<li style="margin-bottom: 20px"
								class="job-listing d-block d-sm-flex pb-3 pb-sm-0 align-items-center ">
								<div
									class="job-listing-about d-sm-flex custom-width w-100 justify-content-between mx-4">
									<div class="job-listing-position custom-width  mb-3 mb-sm-0"
										style="padding: 10px; width: 250px; flex: auto;">
										<h2 onclick="detail(${category.id})" style="cursor: pointer;">${category.name}</h2>
										<strong>${category.created} </strong>
									</div>
									<div
										class="job-listing-location mb-3 mb-sm-0 custom-width w-10 flex-hide-button-date"
										style="padding: 10px;">
										Ngày bắt đầu<br> <strong>${category.formatStartDate}</strong><br>
									</div>
									<div
										class="job-listing-location mb-3 mb-sm-0 custom-width w-10 flex-hide-button-date"
										style="padding: 10px;">
										Ngày kết thúc<br> <strong>${category.formatEndDate}</strong><br>
									</div>
									<div
										class="job-listing-location mb-3 mb-sm-0 custom-width w-25 ${category.status == 1 ? 'flex-show-button-organization-name' : 'flex-hide-button-organization-name'}"
										style="padding: 10px;">
										<div
											class="${category.status == 1 ? 'padding-show-button-organization-name' : 'padding-hide-button-organization-name'}">
											<span class="icon-room"></span> <span>${category.tochuc}</span><br>
											<strong>${category.sdt}</strong>
										</div>

									</div>
									<div>
										<c:choose>
											<c:when test="${category.status == 1 }">
												<div class="job-listing-meta custom-width w-20">

													<button type="button"
														style="color: white; margin-top: 15px" data-toggle="modal"
														data-target="#exampleModal${category.id }"
														class="btn btn-primary py-2 donate-btn">Quyên góp</button>
													<!-- 
										<p
										style="margin-top: 20px; background-color: white !important;"
										class="btn py-2">
										<span style="color: white">Quyên góp</span>
									</p>
									 -->
												</div>
											</c:when>
										</c:choose>
									</div>
								</div>

							</li>
						</c:if>
						<!-- Modal -->
						<div class="modal fade" id="exampleModal${category.id }"
							tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
							aria-hidden="true">
							<div class="modal-dialog" role="document">
								<div class="modal-content">
									<div class="modal-header">
										<h5 class="modal-title" id="exampleModalLabel">
											Quyên góp: ${category.name}<span></span>
										</h5>
										<button type="button" class="close" data-dismiss="modal"
											aria-label="Close">
											<span aria-hidden="true">&times;</span>
										</button>
									</div>
									<form:form method="post" modelAttribute="userDonation"
										action="${pageContext.request.contextPath}/public/donate">
										<div class="modal-body">
											<div class="row">

												<div class="col-12">
													<label for="addname" class="col-form-label">Họ tên:</label>
													<input type="text" class="form-control" id="addname"
														name="name" placeholder="" readonly="readonly"
														value="${sessionScope.user.fullName}"> <label
														for="addname" class="col-form-label">Số tiền quyên
														góp:</label> <input type="number" class="form-control"
														placeholder="" id="addname" name="money" required>
													<input type="hidden" class="form-control" placeholder=""
														id="addname" name="idUser"> <input type="hidden"
														class="form-control" placeholder="" id="addname"
														name="idDonation" value="${category.id}" required>
													<label for="addname" class="col-form-label">Lời
														nhắn:</label>
													<textarea rows="10" cols="3" class="form-control"
														name="text" style="white-space: none;">

                                                </textarea>
												</div>

											</div>
											<div class="modal-footer">
												<button type="button" class="btn btn-secondary"
													data-dismiss="modal">Đóng</button>
												<button type="submit" data-toggle="modal"
													data-target="#exampleModal" class="btn btn-primary">Quyên
													góp</button>
											</div>
										</div>
									</form:form>


								</div>
							</div>
						</div>
						<script>
						function detail(id) {
							window.location = '${pageContext.request.contextPath}/public/detail/' + id;
						}
						</script>
					</c:forEach>
				</ul>
				<div class="row mb-5 justify-content-center">
					<div class="col-md-7 text-center">
						<c:if test="${not empty donationNone}">
							<h5>${donationNone }</h5>
						</c:if>
					</div>
				</div>
				<div class="row pagination-wrap">
					<div class="col-md-6 text-center text-md-left mb-4 mb-md-0">
						<!-- Chỗ này để custom nếu cần -->
					</div>
					<div class="col-md-6 text-center text-md-right">
						<div class="custom-pagination ml-auto">
							<c:if test="${currentPage > 1}">
								<a id="prevPage" class="prev"
									href="?page=${currentPage - 1}&size=${pageSize}">Prev</a>
							</c:if>
							<c:if test="${currentPage < totalPages && empty donationNone}">
								<a id="nextPage" class="next"
									href="?page=${currentPage + 1}&size=${pageSize}">Next</a>
							</c:if>
						</div>
					</div>
				</div>


			</div>
		</section>

	</div>


</body>
</html>