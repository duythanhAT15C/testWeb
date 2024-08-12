<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no" />
<meta name="description" content="" />
<meta name="author" content="" />
<title>Quản trị</title>
<link
	href="https://cdn.jsdelivr.net/npm/simple-datatables@latest/dist/style.css"
	rel="stylesheet" />
<link
	href="${pageContext.request.contextPath}/resources/static/admin1/assets/css/styles.css"
	rel="stylesheet" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/js/all.min.js"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	crossorigin="anonymous"></script>
<script
	src="${pageContext.request.contextPath}/resources/static/admin1/assets/js/scripts.js"></script>
<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
	crossorigin="anonymous"></script>

<script
	src="${pageContext.request.contextPath}/resources/static/admin1/assets/js/datatables-simple-demo.js"></script>

<script
	src="https://cdn.ckeditor.com/ckeditor5/29.0.0/classic/ckeditor.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>

<body class="sb-nav-fixed">
	<c:if test="${not empty addDonationCodeAndDateFalse}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Add False!',
						text : '${addDonationCodeAndDateFalse}',
						icon : 'error',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
	</c:if>
	<c:if test="${not empty addDonationCodeFalse}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Add False!',
						text : '${addDonationCodeFalse}',
						icon : 'error',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
	</c:if>
	<c:if test="${not empty addDonationDateFalse}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Add False!',
						text : '${addDonationDateFalse}',
						icon : 'error',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
	</c:if>
	<c:if test="${not empty addDonationDateNowFalse}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Add False!',
						text : '${addDonationDateNowFalse}',
						icon : 'error',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
	</c:if>
	<c:if test="${not empty addPhoneFalse}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Add False!',
						text : '${addPhoneFalse}',
						icon : 'error',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
	</c:if>
	<c:if test="${not empty addDonationSuccess}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Add Successfull!',
						text : '${addDonationSuccess}',
						icon : 'success',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
	</c:if>
	<nav class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
		<nav th:fragment="html_nav"
			class="sb-topnav navbar navbar-expand navbar-dark bg-dark">
			<!-- Navbar Brand-->
			<a class="navbar-brand ps-3" href="/Assessment01/admin/">QUẢN TRỊ</a>
			<!-- Sidebar Toggle-->
			<button class="btn btn-link btn-sm order-1 order-lg-0 me-4 me-lg-0"
				id="sidebarToggle" th:href="#!">
				<i class="fas fa-bars"></i>
			</button>
			<!-- Navbar Search-->
			<form
				class="d-none d-md-inline-block form-inline ms-auto me-0 me-md-3 my-2 my-md-0">

			</form>
			<!-- Navbar-->
			<ul class="navbar-nav ms-auto ms-md-0 me-3 me-lg-4">
				<li class="nav-item dropdown"><a th:if="${session.admin}"
					class="nav-link dropdown-toggle" href="logout" role="button"><i
						class="fas fa-user fa-fw"></i><span> Logout</span></a>
					<ul class="dropdown-menu dropdown-menu-end"
						aria-labelledby="navbarDropdown1">
						<li><a class="dropdown-item" href="#">Settings</a></li>
						<li><a class="dropdown-item" href="#">Activity Log</a></li>
						<li>
							<hr class="dropdown-divider" />
						</li>
						<li><a class="dropdown-item" href="/logout">Logout</a></li>
					</ul></li>
			</ul>
		</nav>
	</nav>

	<div id="layoutSidenav">
		<div id="layoutSidenav_nav">
			<div th:fragment="html_menu" id="layoutSidenav_nav">
				<nav class="sb-sidenav accordion sb-sidenav-dark"
					id="sidenavAccordion">
					<div class="sb-sidenav-menu">
						<div class="nav">
							<a class="nav-link" href="account">
								<div class="sb-nav-link-icon">
									<i class="fas fa-tachometer-alt"></i>
								</div> Quản lý người dùng
							</a> <a class="nav-link" href="donation">
								<div class="sb-nav-link-icon">
									<i class="fas fa-tachometer-alt"></i>
								</div> Quản lý đợt quyên góp
							</a>
						</div>
					</div>

				</nav>
			</div>
		</div>

		<div id="layoutSidenav_content">
			<main>
				<div class="container-fluid px-4">
					<h1 class="mt-4">Danh sách đợt quyên góp</h1>
					<div class="card mb-4">
						<div class="card-header">
							<button type="button" class="btn btn-success"
								data-bs-toggle="modal" data-bs-target="#exampleModalAdd">
								Thêm mới</button>
							<!-- Modal Add-->
							<div class="modal fade" id="exampleModalAdd" tabindex="-1"
								aria-labelledby="exampleModalLabel" aria-hidden="true">
								<div class="modal-dialog modal-lg">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabelll">Thêm
												mới</h5>
											<button type="button" class="btn-close"
												data-bs-dismiss="modal" aria-label="Close"></button>
										</div>
										<div class="modal-body">
											<form:form method="post"
												action="${pageContext.request.contextPath}/ql-donation/add"
												modelAttribute="donationAdd">
												<div class="row">
													<div class="col-6">
														<label for="addname" class="col-form-label">Mã đợt
															quyên góp:</label> <input type="text" class="form-control"
															id="addname" name="code" required>
													</div>
													<div class="col-6">
														<label for="addcost" class="col-form-label">Tên
															đợt quyên góp:</label> <input type="text" class="form-control"
															id="addcost" name="name" required>
													</div>
												</div>
												<div class="row">
													<div class="col-6">
														<label for="addname" class="col-form-label">Ngày
															bắt đầu:</label> <input type="date" class="form-control"
															id="addname" name="start" required>
													</div>
													<div class="col-6">
														<label for="addcost" class="col-form-label">Ngày
															kết thúc:</label> <input type="date" class="form-control"
															id="addcost" name="end" required>
													</div>
												</div>
												<div class="row">
													<div class="col-6">
														<label for="addname" class="col-form-label">Tổ
															chức:</label> <input type="text" class="form-control"
															id="addname" name="tochuc" required>
													</div>
													<div class="col-6">
														<label for="addcost" class="col-form-label">Số
															điện thoại:</label> <input type="number" class="form-control"
															id="addcost" name="sdt" required>
													</div>
													<div class="col-12">
														<label for="ct_id" class="col-form-label">Nội
															dung:</label>
														<textarea name="noidung" class="form-control" cols="50"
															rows="5"></textarea>
													</div>
												</div>
												<div class="modal-footer">
													<button type="button" class="btn btn-secondary"
														data-bs-dismiss="modal">Đóng</button>
													<button type="submit" class="btn btn-primary">Thêm
													</button>
												</div>
											</form:form>
										</div>

									</div>
								</div>
							</div>
							<!-- Modal Add-->
						</div>
						<div class="card-body">
							<table id="datatablesSimple">
								<thead>
									<tr style="background-color: gray !important;">
										<th>Mã</th>
										<th>Tên</th>
										<th>Ngày bắt đầu</th>
										<th>Ngày kết thúc</th>
										<th>Tổ chức</th>
										<th>Số điện thoại</th>
										<th>Tổng tiền</th>
										<th>Trạng thái</th>
										<th style="width: 220px">Hành động</th>
									</tr>
								</thead>
								<tfoot>
									<tr>

									</tr>
								</tfoot>
								<tbody>
									<c:forEach var="user" items="${list}">
										<c:if test="${user.deleteFlag == 1 }">
											<tr>
												<td>${user.code}</td>
												<td>${user.name}</td>
												<td>${user.formatStartDate}</td>
												<td>${user.formatEndDate}</td>
												<td>${user.tochuc}</td>
												<td>${user.sdt}</td>
												<td>${user.formatMoney}VNĐ</td>
												<c:choose>
													<c:when test="${user.status == 1}">
														<td>Đang quyên góp</td>
													</c:when>
													<c:when test="${user.status == 2}">
														<td>Kết thúc quyên góp</td>
													</c:when>
													<c:when test="${user.status == 3}">
														<td>Đóng quyên góp</td>
													</c:when>
													<c:otherwise>
														<td>Mới tạo</td>
													</c:otherwise>
												</c:choose>
												<td style=""><c:choose>
														<c:when test="${user.status != 2 && user.status != 3}">
															<button type="button"
																style="width: 105px; margin-top: 5px"
																class="btn btn-primary" data-bs-toggle="modal"
																data-bs-target="#exampleModal${user.id}">Cập
																nhật</button>
														</c:when>
													</c:choose> <a style="width: 105px; margin-top: 5px"
													class="btn btn-warning" href="detail/${user.id}"> Chi
														tiết </a> <c:choose>
														<c:when test="${user.status == 0 }">
															<button type="button" style="width: 105px"
																class="btn btn-danger mt-1" data-bs-toggle="modal"
																data-bs-target="#idModelDel${user.id}">Xóa</button>
														</c:when>
													</c:choose>
													<form method="post"
														action="${pageContext.request.contextPath}/ql-donation/donate"
														style="margin-left: 110px; margin-top: -38px">
														<input type="hidden" class="form-control" id="id"
															name="idD" value="${user.id}">
														<c:choose>
															<c:when test="${user.status == 0}">
																<button type="submit" style="width: 105px"
																	class="btn btn-success">Quyên góp</button>
															</c:when>
														</c:choose>
													</form> <c:choose>
														<c:when test="${user.status == 1}">
															<form method="post" style="margin-top: 38px"
																action="${pageContext.request.contextPath}/ql-donation/teminate">
																<input type="hidden" class="form-control" id="id"
																	name="idD" value="${user.id}">
																<button type="submit"
																	style="width: 105px; margin-top: 5px"
																	class="btn btn-success">Kết thúc</button>
															</form>
															<form method="post" style="margin-top: 5px"
																action="${pageContext.request.contextPath}/ql-donation/close">
																<input type="hidden" class="form-control" id="id"
																	name="idD" value="${user.id}">
																<button type="submit" style="width: 105px"
																	class="btn btn-delete">Đóng</button>
															</form>
														</c:when>
													</c:choose>
													<div class="modal fade" id="idModelDel${user.id}"
														tabindex="-1" aria-labelledby="exampleModalLabel"
														aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<h5 class="modal-title" id="exampleModalLabel">Bạn
																		chắc chắn muốn xóa ?</h5>
																	<button type="button" class="btn-close"
																		data-bs-dismiss="modal" aria-label="Close"></button>
																</div>
																<div class="modal-body">
																	Đợt quyên góp : <span>${user.name}</span>
																	<form method="post"
																		action="${pageContext.request.contextPath}/ql-donation/delete">
																		<input type="hidden" name="idUserDonation"
																			value="${user.id}">
																		<div class="modal-footer" style="margin-top: 20px">
																			<button type="button" class="btn btn-secondary"
																				data-bs-dismiss="modal">Close</button>
																			<button type="submit" class="btn btn-danger">Xóa</button>

																		</div>
																	</form>
																</div>

															</div>
														</div>
													</div></td>
											</tr>
											<div class="modal fade" id="exampleModal${user.id}"
												tabindex="-1" aria-labelledby="exampleModalLabel"
												aria-hidden="true">
												<div class="modal-dialog modal-lg ">
													<div class="modal-content">
														<div class="modal-header">
															<h5 class="modal-title" id="exampleModalLabell">Cập
																nhật</h5>
															<button type="button" class="btn-close"
																data-bs-dismiss="modal" aria-label="Close"></button>
														</div>
														<div class="modal-body">
															<form:form method="post"
																action="${pageContext.request.contextPath}/ql-donation/update"
																modelAttribute="donationUpdate">
																<input type="hidden" name="id" value="${user.id }">
																<div class="row">
																	<div class="col-6">
																		<label for="addname" class="col-form-label">Mã
																			đợt quyên góp:</label> <input type="text"
																			class="form-control" id="addname" name="code"
																			value="${user.code }" required>
																	</div>
																	<div class="col-6">
																		<label for="addcost" class="col-form-label">Tên
																			đợt quyên góp:</label> <input type="text"
																			class="form-control" id="addcost" name="name"
																			value="${user.name }" required>
																	</div>
																</div>
																<div class="row">
																	<div class="col-6">
																		<label for="addname" class="col-form-label">Ngày
																			bắt đầu:</label> <input type="date" class="form-control"
																			id="addname" name="start" value="${user.start }"
																			required>
																	</div>
																	<div class="col-6">
																		<label for="addcost" class="col-form-label">Ngày
																			kết thúc:</label> <input type="date" class="form-control"
																			id="addcost" name="end" value="${user.end }" required>
																	</div>
																</div>
																<div class="row">
																	<div class="col-6">
																		<label for="addname" class="col-form-label">Tổ
																			chức:</label> <input type="text" class="form-control"
																			id="addname" name="tochuc" value="${user.tochuc }"
																			required>
																	</div>
																	<div class="col-6">
																		<label for="addcost" class="col-form-label">Số
																			điện thoại:</label> <input type="number" class="form-control"
																			id="addcost" name="sdt" value="${user.sdt }" required>
																	</div>
																	<div class="col-12">
																		<label for="ct_id" class="col-form-label">Nội
																			dung:</label>
																		<textarea name="noidung" class="form-control"
																			cols="50" rows="5">${user.noidung }</textarea>
																	</div>
																</div>
																<div class="modal-footer">
																	<button type="button" class="btn btn-secondary"
																		data-bs-dismiss="modal">Đóng</button>
																	<button type="submit" class="btn btn-primary">Lưu
																	</button>
																</div>
															</form:form>
														</div>

													</div>
												</div>
											</div>
										</c:if>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>

			</main>

			<script>

      ClassicEditor.create(document.querySelector('#editor')).then(eidt => {
        console.log("da" + eidt);
      })
              .catch(error => {
                console.error(error);
              });

    </script>
			<script>

      var dodai = document.getElementById("dodai").value;
      var a = parseInt(dodai);
      for(var i = 1;i<=a+10;i++){
        var name = "#editor"  + i
        ClassicEditor.create(document.querySelector(name)).then(eidt => {
          console.log("da" + eidt);
        })
                .catch(error => {
                  console.error(error);
                });
      }


    </script>
			<footer th:replace="admin/fragments :: footer"
				class="py-4 bg-light mt-auto"> </footer>
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath}/resources/static/admin1/assets/js/JQuery3.3.1.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath}/resources/static/admin1/assets/js/scripts.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath}/resources/static/admin1/assets/js/datatables-simple-demo.js"></script>
</body>
</html>