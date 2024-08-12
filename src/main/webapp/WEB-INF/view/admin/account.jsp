<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
	<c:if test="${not empty addUserSuccess}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Add Successfully!',
						text : '${addUserSuccess}',
						icon : 'success',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
	</c:if>
	<c:if test="${not empty addUserFalse}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Add False!',
						text : '${addUserFalse}',
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
	<c:if test="${not empty updatePhoneFalse}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Update False!',
						text : '${updatePhoneFalse}',
						icon : 'error',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
	</c:if>
	<c:if test="${not empty updatePhoneSuccess}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Update Success!',
						text : '${updatePhoneSuccess}',
						icon : 'success',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
	</c:if>
	<c:if test="${not empty addPassFalse}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Add False!',
						text : '${addPassFalse}',
						icon : 'error',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
	</c:if>
	<c:if test="${not empty deleteError}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Delete False!',
						text : '${deleteError}',
						icon : 'error',
						timer : 6000,
						buttons : true,
						type : 'success'
					});
				}, 1000); // Delay to match data-delay attribute
			</script>
		</div>
	</c:if>
	<c:if test="${not empty deleteSuccess}">
		<div class="toast" data-delay="1000"
			style="position: fixed; top: 100px; left: 40px; z-index: 2000; width: 300px">
			<script>
				setTimeout(function() {
					Swal.fire({
						title : 'Delete Success!',
						text : '${deleteSuccess}',
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
					<h1 class="mt-4">Danh sách người dùng</h1>
					<div class="card mb-4">
						<div class="card-header">
							<button type="button" class="btn btn-success"
								data-bs-toggle="modal" data-bs-target="#exampleModalAdd">Thêm
								mới</button>
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
											<form:form
												action="${pageContext.request.contextPath}/ql-user/add"
												method="post" modelAttribute="userAdd">
												<div class="row">
													<div class="col-6">
														<label for="addname" class="col-form-label">Name:</label>
														<input type="text" class="form-control" id="addname"
															name="fullName" required="required">
													</div>
													<div class="col-6">
														<label for="addcost" class="col-form-label">Email:</label>
														<input type="email" class="form-control" id="addcost"
															name="email" required>
													</div>
												</div>
												<div class="row">
													<div class="col-6">
														<label for="addname" class="col-form-label">Số
															điện thoại:</label> <input type="number" class="form-control"
															id="addname" name="phoneNumber" required>
													</div>
													<div class="col-6">
														<label for="addcost" class="col-form-label">Địa
															chỉ:</label> <input type="text" class="form-control" id="addcost"
															name="address" required>
													</div>
												</div>
												<div class="row">
													<div class="col-6">
														<label for="addname" class="col-form-label">Tài
															khoản:</label> <input type="text" class="form-control"
															id="addname" name="userName" required>
													</div>
													<div class="col-6">
														<label for="addcost" class="col-form-label">Mật
															khẩu:</label> <input type="password" class="form-control"
															id="addcost" name="password" required>
													</div>
													<div class="col-6">
														<label for="ct_id" class="col-form-label">Vai trò:</label>
														<select class="form-control" id="ct_id" name="idRole"
															required>
															<option value="" selected>Chọn loại vai trò</option>
															<option value="1" label="Admin" />
															<option value="2" label="User" />
														</select>
													</div>
													<c:if test="${not empty error}">
														<p>${error }</p>
														<script>
															$(document).ready(function() {
										                    	alert("${error}");
										                    	$('#exampleModalAdd').modal('show'); // Hiển thị modal thêm mới lại
										                	});
														</script>
													</c:if>
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
										<th>Họ tên</th>
										<th>Email</th>
										<th>Số điện thoại</th>
										<!--                <th>Địa chỉ</th>-->
										<th>Tài khoản</th>
										<th>Vai trò</th>
										<th>Trạng thái</th>
										<th>Hành động</th>
									</tr>
								</thead>
								<tfoot>
									<tr>

									</tr>
								</tfoot>
								<tbody>
									<input type="hidden" value="${fn:length(list)}" id="dodai" />
									<c:forEach var="user" items="${list}">
										<c:if test="${user.deleteFlag == 1 }">
											<tr>
												<td>${user.fullName}</td>
												<td>${user.email}</td>
												<td>${user.phoneNumber}</td>
												<!-- <td>${user.address}</td> -->
												<td>${user.userName}</td>
												<td>${user.role.roleName}</td>
												<td><c:if test="${user.status == 1}">
														<span style="color: #1c7430; font-weight: bold">Hoạt
															động</span>
													</c:if> <c:if test="${user.status == 0}">
														<span style="color: red; font-weight: bold">Đã khoá</span>
													</c:if></td>
												<td style="width: 270px">
													<button type="button" style="width: 80px"
														class="btn btn-success" data-bs-toggle="modal"
														data-bs-target="#idModelMail${user.id}">Gửi</button>
													<button type="button" style="width: 80px"
														class="btn btn-primary" data-bs-toggle="modal"
														data-bs-target="#exampleModal${user.id}">Sửa</button>
													<button type="button" style="width: 80px"
														class="btn btn-warning" data-bs-toggle="modal"
														data-bs-target="#idModelDetail${user.id}">Chi
														tiết</button>
													<button type="button" style="width: 80px"
														class="btn btn-delete mt-1" data-bs-toggle="modal"
														data-bs-target="#idModelDel${user.id}">Xóa</button>

													<form
														action="${pageContext.request.contextPath}/ql-user/lock"
														method="post" style="display: inline;">
														<c:if test="${user.status == 1}">

															<input type="hidden" name="idUser" value="${user.id}">
															<button type="submit" class="btn btn-danger">Khóa</button>
														</c:if>
													</form>

													<form
														action="${pageContext.request.contextPath}/ql-user/lock"
														method="post">
														<c:if test="${user.status == 0}">

															<input type="hidden" name="idUser" value="${user.id}">
															<button type="submit" class="btn btn-success">Mở</button>
														</c:if>
													</form>


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
																	Người dùng : <span>${user.fullName}</span>
																	<form
																		action="${pageContext.request.contextPath}/ql-user/delete"
																		method="post">
																		<input type="hidden" name="idUser" value="${user.id}">
																		<div class="modal-footer" style="margin-top: 20px">
																			<button type="button" class="btn btn-secondary"
																				data-bs-dismiss="modal">Close</button>
																			<button type="submit" class="btn btn-danger">Xóa</button>
																		</div>
																	</form>
																</div>
															</div>
														</div>
													</div>

													<div class="modal fade" id="idModelMail${user.id}"
														tabindex="-1" aria-labelledby="exampleModalLabel"
														aria-hidden="true">
														<div class="modal-dialog">
															<div class="modal-content">
																<div class="modal-header">
																	<h5 class="modal-title" id="exampleModalLabel">
																		Gửi đến: <span>${user.email}</span>
																	</h5>
																	<button type="button" class="btn-close"
																		data-bs-dismiss="modal" aria-label="Close"></button>
																</div>
																<div class="modal-body">
																	<form
																		action="${pageContext.request.contextPath}/ql-user/send-mail"
																		method="post">
																		<input type="hidden" name="idUser" value="${user.id}">
																		<label for="addname" class="col-form-label">Nội
																			dung:</label>
																		<textarea rows="10" class="form-control" id="addname"
																			name="note"></textarea>
																		<div class="modal-footer" style="margin-top: 20px">
																			<button type="button" class="btn btn-secondary"
																				data-bs-dismiss="modal">Đóng</button>
																			<button type="submit" class="btn btn-success">Gửi</button>
																		</div>
																	</form>
																</div>
															</div>
														</div>
													</div>

													<div class="modal fade" id="idModelDetail${user.id}"
														tabindex="-1" aria-labelledby="exampleModalLabel"
														aria-hidden="true">
														<div class="modal-dialog modal-lg">
															<div class="modal-content">
																<div class="modal-header">
																	<h5 class="modal-title" id="exampleModalLabel">
																		Chi tiết : <span>${user.fullName}</span>
																	</h5>
																	<button type="button" class="btn-close"
																		data-bs-dismiss="modal" aria-label="Close"></button>
																</div>
																<div class="modal-body">
																	<div class="row">
																		<div class="col-6">
																			<h5>Họ tên :</h5>
																			<p>${user.fullName}</p>
																			<h5>Email:</h5>
																			<p>${user.email}</p>
																			<h5>Số điện thoại:</h5>
																			<p>${user.phoneNumber}</p>
																			<h5>Tài khoản:</h5>
																			<p>${user.userName}</p>
																		</div>
																		<div class="col-6">
																			<h5>Địa chỉ :</h5>
																			<p>${user.address}</p>
																			<h5>Vai trò:</h5>
																			<p>${user.role.roleName}</p>
																			<h5>Lần đăng nhập gần nhất:</h5>
																			<p>${user.created}</p>
																			<h5>Note:</h5>
																			<p>${user.note}</p>
																		</div>
																	</div>
																</div>
															</div>
														</div>
													</div>

													<div class="modal fade" id="exampleModal${user.id}"
														tabindex="-1" aria-labelledby="exampleModalLabel"
														aria-hidden="true">
														<div class="modal-dialog modal-lg">
															<div class="modal-content">
																<div class="modal-header">
																	<h5 class="modal-title" id="exampleModalLabell">Cập
																		nhật</h5>
																	<button type="button" class="btn-close"
																		data-bs-dismiss="modal" aria-label="Close"></button>
																</div>
																<div class="modal-body">
																	<form:form
																		action="${pageContext.request.contextPath}/ql-user/update"
																		method="post" modelAttribute="userUpdate">
																		<input type="hidden" name="id" value="${user.id}">
																		<div class="row">
																			<div class="col-6">
																				<label for="addname" class="col-form-label">Họ
																					và tên:</label> <input type="text" class="form-control"
																					id="addName" name="fullName"
																					value="${user.fullName }" required>
																			</div>
																			<div class="col-6">
																				<label for="addcost" class="col-form-label">Email:</label>
																				<input readonly type="email" class="form-control"
																					id="addemail" name="email" value="${user.email }"
																					required>
																			</div>
																		</div>
																		<div class="row">
																			<div class="col-6">
																				<label for="addname" class="col-form-label">Số
																					điện thoại:</label> <input type="number"
																					class="form-control" id="addphone"
																					name="phoneNumber" value="${user.phoneNumber }"
																					required>
																			</div>
																			<div class="col-6">
																				<label for="addcost" class="col-form-label">Địa
																					chỉ:</label> <input type="text" class="form-control"
																					id="addaddress" name="address"
																					value="${user.address }" required>
																			</div>
																		</div>
																		<div class="row">
																			<div class="col-6">
																				<label for="addname" class="col-form-label">Tài
																					khoản:</label> <input readonly type="text"
																					class="form-control" id="addUserName"
																					name="userName" value="${user.userName }" required>
																				<input readonly type="hidden" class="form-control"
																					name="idUser" required> <input readonly
																					type="hidden" class="form-control" name="password"
																					value="${user.password }" required> <input
																					readonly type="hidden" class="form-control"
																					name="status" required>
																			</div>
																			<div class="col-6">
																				<label for="ct_id" class="col-form-label">Vai
																					trò:</label> <select class="form-control" id="ct_id"
																					name="idRole" required>
																					<option value="" selected>Chọn loại vai
																						trò</option>
																					<c:forEach var="role" items="${roleList}">
																						<option value="${role.id}">${role.roleName}</option>
																					</c:forEach>
																				</select>
																			</div>
																		</div>
																		<div class="modal-footer">
																			<button type="button" class="btn btn-secondary"
																				data-bs-dismiss="modal">Đóng</button>
																			<button type="submit" class="btn btn-primary">Lưu</button>
																		</div>
																	</form:form>
																</div>
															</div>
														</div>
													</div>
												</td>
											</tr>
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

      function populateModal(button) {
    	  
    	    var fullName = button.getAttribute("data-fullname");
    	    var email = button.getAttribute("data-email");
    	    var phoneNumber = button.getAttribute("data-phonenumber");
    	    var address = button.getAttribute("data-address");
    	    var userName = button.getAttribute("data-username");
    	    var role = button.getAttribute("data-role");
    	    
    	    
    	    var modalId = button.getAttribute("data-bs-target");
    	    var modal = document.querySelector(modalId);
    	    
    	    
    	    modal.querySelector("#addName").value = fullName;
    	    modal.querySelector("#addemail").value = email;
    	    modal.querySelector("#addphone").value = phoneNumber;
    	    modal.querySelector("#addaddress").value = address;
    	    modal.querySelector("#addUserName").value = userName;
    	}


    </script>
			<footer th:replace="admin/fragments :: footer"
				class="py-4 bg-light mt-auto"> </footer>
		</div>
	</div>

	<script
		src="${pageContext.request.contextPath}/resources/static/admin1/js/JQuery3.3.1.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath}/resources/static/admin1/js/scripts.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/simple-datatables@latest"
		crossorigin="anonymous"></script>
	<script
		src="${pageContext.request.contextPath}/resources/static/admin1/js/datatables-simple-demo.js"></script>
</body>
</html>