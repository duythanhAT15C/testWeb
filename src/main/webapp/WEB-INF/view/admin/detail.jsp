<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<c:if test="${not empty confirmSuccessfully}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Confirm SuccessFully!',
						text : '${confirmSuccessfully}',
						icon : 'success',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
		<c:set var="msgDetailId" scope="request" value="" />
	</c:if>
	<c:if test="${not empty undoSuccessfully}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Undo SuccessFully!',
						text : '${undoSuccessfully}',
						icon : 'success',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
		<c:set var="msgDetailId" scope="request" value="" />
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
							<a class="nav-link"
								href="${pageContext.request.contextPath}/admin/account">
								<div class="sb-nav-link-icon">
									<i class="fas fa-tachometer-alt"></i>
								</div> Quản lý người dùng
							</a> <a class="nav-link"
								href="${pageContext.request.contextPath}/admin/donation">
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
					<h1 class="mt-4">Chi tiết đợt quyên góp</h1>
					<div class="card mb-4">

						<div class="card-body">
							<!--Detail-->
							<div class="row">
								<div class="col-6">
									<label for="addname" class="col-form-label">Mã đợt
										quyên góp:</label> <input type="text" class="form-control"
										id="addname" name="code" value="${donationDetail.code}"
										readonly="readonly">
								</div>
								<div class="col-6">
									<label for="addcost" class="col-form-label">Tên đợt
										quyên góp:</label> <input type="text" class="form-control"
										id="addcost" name="name" value="${donationDetail.name}"
										readonly="readonly">
								</div>
							</div>
							<div class="row">
								<div class="col-6">
									<label for="addname" class="col-form-label">Ngày bắt
										đầu:</label> <input type="date" class="form-control" id="addname"
										name="start" value="${donationDetail.start}"
										readonly="readonly">
								</div>
								<div class="col-6">
									<label for="addcost" class="col-form-label">Ngày kết
										thúc:</label> <input type="date" class="form-control" id="addcost"
										name="end" value="${donationDetail.end}" readonly="readonly">
								</div>
							</div>
							<div class="row">
								<div class="col-6">
									<label for="addname" class="col-form-label">Tổng tiền
										quyên góp:</label> <input type="text" class="form-control"
										id="addname" name="start"
										value="${donationDetail.formatMoney} VNĐ" readonly="readonly">
								</div>
								<div class="col-6">
									<label for="addcost" class="col-form-label">Trạng thái:</label>
									<input type="text" class="form-control" id="addcost" name="end"
										value="${donationDetail.created}" readonly="readonly">
								</div>
							</div>
							<div class="row">
								<div class="col-6">
									<label for="addname" class="col-form-label">Tổ chức:</label> <input
										type="text" class="form-control" id="addname" name="tochuc"
										value="${donationDetail.tochuc}" readonly="readonly">
								</div>
								<div class="col-6">
									<label for="addcost" class="col-form-label">Số điện
										thoại:</label> <input type="number" class="form-control" id="addcost"
										name="sdt" value="${donationDetail.sdt}" readonly="readonly">
								</div>
								<div class="col-12">
									<label for="ct_id" class="col-form-label">Nội dung:</label>
									<textarea name="noidung" class="form-control" cols="50"
										readonly="readonly">${donationDetail.noidung}</textarea>
								</div>
							</div>
							<!--Detail-->
							<h3 class="mt-4">Danh sách những người quyên góp</h3>
							<table id="datatablesSimple">
								<thead>
									<tr style="background-color: gray !important;">
										<th>Họ Tên</th>
										<th>Tiền quyên góp</th>
										<th>Ngày quyên góp</th>
										<th>Nội dung</th>
										<th>Trạng thái</th>
										<th>Hành động</th>
									</tr>
								</thead>
								<tfoot>
									<tr>

									</tr>
								</tfoot>
								<tbody>
									<input type="hidden" th:value="${userDonationList.size()}"
										id="dodai" />
									<c:forEach var="userDonation" items="${userDonationList}">
										<tr>
											<td>${userDonation.name}</td>
											<td>${userDonation.formattedMoney}VNĐ</td>
											<td>${userDonation.donationDate }</td>
											<td>${userDonation.text }</td>
											<td>${userDonation.status }</td>
											<td style="display: flex; justify-content: space-between">

												<c:if test="${userDonation.status == 'Chờ xác nhận' || userDonation.status == 'Huỷ xác nhận'}">
													<button type="submit" style="width: 105px"
														class="btn btn-success" data-bs-toggle="modal"
														data-bs-target="#idModelConfirm${userDonation.id}">Xác
														nhận</button>
												</c:if> <c:if test="${userDonation.status == 'Đã xác nhận' }">
													<button type="submit" style="width: 150px"
														class="btn btn-danger" data-bs-toggle="modal"
														data-bs-target="#idModelUndo${userDonation.id}">Hủy
														xác nhận</button>
												</c:if>
											</td>
										</tr>
										<div class="modal fade" id="idModelConfirm${userDonation.id}"
											tabindex="-1" aria-labelledby="exampleModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">Xác
															nhận người dùng?</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-body">
														Người dùng : <span>${userDonation.name}</span>
														<form
															action="${pageContext.request.contextPath}/ql-donation/confirm"
															method="post">
															<input type="hidden" name="idUserDonationConfirm"
																value="${userDonation.id}"> <input type="hidden"
																name="idDonationConfirm" value="${donationDetail.id}">
															<div class="modal-footer" style="margin-top: 20px">
																<button type="button" class="btn btn-secondary"
																	data-bs-dismiss="modal">Close</button>
																<button type="submit" class="btn btn-danger">Xác
																	nhận</button>
															</div>
														</form>
													</div>
												</div>
											</div>
										</div>
										<div class="modal fade" id="idModelUndo${userDonation.id}"
											tabindex="-1" aria-labelledby="exampleModalLabel"
											aria-hidden="true">
											<div class="modal-dialog">
												<div class="modal-content">
													<div class="modal-header">
														<h5 class="modal-title" id="exampleModalLabel">Huỷ
															xác nhận người dùng?</h5>
														<button type="button" class="btn-close"
															data-bs-dismiss="modal" aria-label="Close"></button>
													</div>
													<div class="modal-body">
														Người dùng : <span>${userDonation.name}</span>
														<form
															action="${pageContext.request.contextPath}/ql-donation/undo"
															method="post">
															<input type="hidden" name="idUserDonationUndo"
																value="${userDonation.id}"> <input type="hidden"
																name="idDonationUndo" value="${donationDetail.id}">
															<div class="modal-footer" style="margin-top: 20px">
																<button type="button" class="btn btn-secondary"
																	data-bs-dismiss="modal">Close</button>
																<button type="submit" class="btn btn-danger">Huỷ
																	xác nhận</button>
															</div>
														</form>
													</div>
												</div>
											</div>
										</div>
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
			<footer class="py-4 bg-light mt-auto">
				<div class="container-fluid px-4"></div>
			</footer>
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