<%@page import="dao.UserDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>
<%@page import="servlets.Conn"%>
<%@page import="dao.BranchDAO"%>
<%
if ((Integer) session.getAttribute("role") == 2)
%>
<%
if (session.getAttribute("branch_id") == null || session.getAttribute("role") == null
		|| session.getAttribute("email") == null)
	response.sendRedirect("index.jsp");
%>
<!doctype html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"
	integrity="sha384-AYmEC3Yw5cVb3ZcuHtOA93w35dYTsvhLPVnYs9eStHfGJvOvKxVfELGroGkvsg+p"
	crossorigin="anonymous" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-p34f1UUtsS3wqzfto5wAAmdvj+osOnFyQFpp4Ua3gs/ZVWx6oOypYoCJhGGScy+8"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="../css/style.css">
<link rel="stylesheet" href="../css/hospital.css">
<title>HOSPITAL MGT</title>
</head>

<body class="colBg">
	<%
	Conn dbconn = new Conn();
	Connection conn = dbconn.get_connection();
	BranchDAO branchDAO = new BranchDAO(conn);
	UserDAO users = new UserDAO(conn);
	ResultSet rsUsers = null;
	if ((Integer) session.getAttribute("role") == 1) {
		rsUsers = users.getAll();
	} else {
		rsUsers = users.getAllbyBranch((Integer) session.getAttribute("branch_id"));
	}
	ResultSet rs = branchDAO.getAll();
	%>
	<div class="sidebar">
		<div
			class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
			<a href="../home.jsp"
				class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">
				<span class="fs-5 d-none d-sm-inline">Menu</span>
			</a>
			<ul
				class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start"
				id="menu">
				<li class="nav-item"><a href="../home.jsp"
					class="nav-link align-middle px-0"> <i class="fas fa-home"></i>
						<span class="ms-1 d-none d-sm-inline">Home</span>
				</a></li>
				<li><a href="#submenu1" data-bs-toggle="collapse"
					class="nav-link px-0 align-middle"> <i class="fas fa-tasks"></i>
						<span class="ms-1 d-none d-sm-inline">Management</span>
				</a>
					<ul class="collapse show nav flex-column ms-1" id="submenu1"
						data-bs-parent="#menu">
						<li class="w-100"><a href="patientRegister.jsp"
							class="nav-link px-0"> <span class="d-none d-sm-inline">Patient
									Management</span>
						</a></li>
						<li><a href="doctorRegister.jsp" class="nav-link px-0"> <span
								class="d-none d-sm-inline">Doctor Management</span></a></li>
						<li><a href="wardRegister.jsp" class="nav-link px-0"> <span
								class="d-none d-sm-inline">Ward Management</span></a></li>
						<li><a href="branchRegister.jsp" class="nav-link px-0"> <span
								class="d-none d-sm-inline">Branch Management</span></a></li>
						<li><a href="userRegister.jsp" class="nav-link px-0"> <span
								class="d-none d-sm-inline">User Management</span></a></li>
						<li><a href="medicineRegister.jsp" class="nav-link px-0">
								<span class="d-none d-sm-inline">Medicine Management</span>
						</a></li>
					</ul></li>
				<li><a href="../stockmgmt.jsp"
					class="nav-link px-0 align-middle"> <i class="fas fa-cubes"></i>
						<span class="ms-1 d-none d-sm-inline">Stock</span></a></li>
				<li><a href="#submenu2" data-bs-toggle="collapse"
					class="nav-link px-0 align-middle "> <i
						class="fas fa-credit-card"></i> <span
						class="ms-1 d-none d-sm-inline">Payments</span></a>
					<ul class="collapse nav flex-column ms-1" id="submenu2"
						data-bs-parent="#menu">
						<li class="w-100"><a href="../payment/payment1.jsp"
							class="nav-link px-0"> <span class="d-none d-sm-inline">Make
									Bill Payment</span></a></li>
					</ul></li>
				<!-- <li>
                            <a href="#submenu3" data-bs-toggle="collapse" class="nav-link px-0 align-middle">
                                <i class="fs-4 bi-grid"></i> <span class="ms-1 d-none d-sm-inline">Products</span> </a>
                                <ul class="collapse nav flex-column ms-1" id="submenu3" data-bs-parent="#menu">
                                <li class="w-100">
                                    <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product</span> 1</a>
                                </li>
                                <li>
                                    <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product</span> 2</a>
                                </li>
                                <li>
                                    <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product</span> 3</a>
                                </li>
                                <li>
                                    <a href="#" class="nav-link px-0"> <span class="d-none d-sm-inline">Product</span> 4</a>
                                </li>
                            </ul>
                        </li> -->
				<li><a href="../hospitalization.jsp"
					class="nav-link px-0 align-middle"> <i
						class="fas fa-user-nurse"></i> <span
						class="ms-1 d-none d-sm-inline">Hospitalization</span>
				</a></li>
				<li><a href="../patientTransfer.jsp"
					class="nav-link px-0 align-middle"> <i
						class="fas fa-exchange-alt"></i> <span
						class="ms-1 d-none d-sm-inline">Patient Transfer</span>
				</a></li>
			</ul>
			<hr>
			<div class="dropdown pb-4">
				<a href="#"
					class="d-flex align-items-center text-white text-decoration-none dropdown-toggle"
					id="dropdownUser1" data-bs-toggle="dropdown" aria-expanded="false">
					<img src="https://github.com/mdo.png" alt="hugenerd" width="30"
					height="30" class="rounded-circle"> <span
					class="d-none d-sm-inline mx-1">User</span>
				</a>
				<ul class="dropdown-menu dropdown-menu-dark text-small shadow"
					aria-labelledby="dropdownUser1">
					<li><a class="dropdown-item" href="#">Profile</a></li>
					<li>
						<hr class="dropdown-divider">
					</li>
					<li><a class="dropdown-item" href="../logout">Sign out</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="main-content">
		<div class="topic">
			<h2>User Management</h2>
		</div>
		<div class="wrapper mt-lg-3">

			<div class="formContainer">
				<form action="../AddUser" method="post">
					<div class="row centerCont">
						<div class="col col-lg-6 col-md-10 col-xs-11">
							<div class="row centerCont">
								<div class="col col-lg-3">
									<label for="exampleFormControlInput1" class="form-label">Branch</label>
								</div>
								<div class="col col-lg-7">
									<select class="form-select" aria-label="Default select example"
										name="branch" required>
										<option selected hidden value="">Select a Branch</option>
										<%
										while (rs.next()) {
										%>
										<option value=<%out.println(rs.getInt("branch_id"));%>>
											<%
											out.println(rs.getString("branch_name"));
											%>
										</option>
										<%
										}
										%>

									</select>
								</div>
							</div>
						</div>
						<div class="col col-lg-6 col-md-10 col-xs-11">
							<div class="row centerCont">
								<div class="col col-lg-3">
									<label for="exampleFormControlInput1" class="form-label">Email</label>
								</div>
								<div class="col col-lg-7">
									<input type="email" name="email" class="form-control" required
										id="exampleFormControlInput1" placeholder="">
								</div>
							</div>
						</div>
					</div>
					<div class="row centerCont">
						<div class="col col-lg-6 col-md-10 col-xs-11">
							<div class="row centerCont">
								<div class="col col-lg-3">
									<label for="exampleFormControlInput1" class="form-label">Password</label>
								</div>
								<div class="col col-lg-7">
									<input type="password" class="form-control" required
										name="password" pattern="{6,}"
										title="Password Should be minimum 6 characters"
										id="exampleFormControlInput1" placeholder="">
								</div>
							</div>
						</div>
						<div class="col col-lg-6 col-md-10 col-xs-11">
							<div class="row centerCont">
								<div class="col col-lg-3">
									<label for="exampleFormControlInput1" class="form-label">Role</label>
								</div>
								<div class="col col-lg-7">
									<select class="form-select" aria-label="Default select example"
										required name="role">
										<option selected hidden value="">Select the Role</option>
										<option value="1">Admin</option>
										<option value="2">Branch Manager</option>
										<option value="3">Service Desk Manager</option>
									</select>
								</div>
							</div>
						</div>
					</div>

					<div class="row centerCont">
						<div class="d-grid gap-2 col-2 mx-auto pt-3">
							<button class="btn btnSubmit btn-sm "
								<%if ((Integer) session.getAttribute("role") == 3)
	out.print("disabled");%>>Create
								User</button>
						</div>
					</div>
				</form>
			</div>
			<div class="tblContainer">
				<div class="row centerCont">
					<div class="col col-lg-11 col-md-10 col-xs-11">


						<table class="table table-primary table-hover table-responsive">
							<thead>
								<tr class=" table-primary">
									<th scope="col">User Id</th>
									<th scope="col">Email</th>
									<th scope="col">Role</th>
									<th scope="col">Branch</th>

									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
								<%
								while (rsUsers.next()) {
								%>
								<tr class="table-light">
									<th scope="row">
										<%
										out.println(rsUsers.getInt("user_id"));
										%>
									</th>
									<td>
										<%
										out.println(rsUsers.getString("email"));
										%>
									</td>
									<td>
										<%
										out.println(rsUsers.getInt("role"));
										%>
									</td>
									<td>
										<%
										out.println(rsUsers.getString("branch_name"));
										%>
									</td>
									<td>
										<ul class="flexList">
											<li><a
												href="../edit/user.jsp?id=<%out.println(rsUsers.getInt("user_id"));%>">
													<button
														<%if ((Integer) session.getAttribute("role") == 3)
	out.print("disabled");%>>
														<i class="far fa-edit"></i>
													</button>
											</a></li>
											<li><a
												href="../AddUser?id=<%out.println(rsUsers.getInt("user_id"));%>">
													<button
														<%if ((Integer) session.getAttribute("role") == 3)
	out.print("disabled");%>>
														<i class="far fa-trash-alt"></i>
													</button></li>
											</a>
										</ul>
									</td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>



					</div>
				</div>
			</div>
		</div>
	</div>


	<footer class="bg-light text-center text-lg-start">
		<!-- Copyright -->
		<div class="text-center p-3"
			style="background-color: rgba(0, 0, 0, 0.2);">
			� 2021 Copyright: <a class="text-dark" href="https://dddd.xyz/">HOSPITAL
				MGT</a>
		</div>
		<!-- Copyright -->
	</footer>
</body>

</html>