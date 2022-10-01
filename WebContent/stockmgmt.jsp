<!doctype html>
<%@page import="dao.BranchDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.StockDAO"%>
<%@page import="dao.MedicineDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="servlets.Conn"%>
<html lang="en">
<%
if (session.getAttribute("branch_id") == null || session.getAttribute("role") == null
		|| session.getAttribute("email") == null)
	response.sendRedirect("index.jsp");
%>
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
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/hospital.css">
<title>Hospital MGT</title>
</head>

<body class="colBg">
	<%
	Conn dbconn = new Conn();
	Connection conn = dbconn.get_connection();
	MedicineDAO medicineDAO = new MedicineDAO(conn);
	StockDAO stockDAo = new StockDAO(conn);
	BranchDAO branchDAO = new BranchDAO(conn);
	ResultSet medicines = medicineDAO.getAll();
	ResultSet rs = branchDAO.getAll();
	
	ResultSet rsStocks = null;
	if ((Integer) session.getAttribute("role") == 1) {
		rsStocks = stockDAo.getAll();
	} else {
		rsStocks = stockDAo.getAllbyBranch((Integer) session.getAttribute("branch_id"));
	}
	%>
	<div class="sidebar">
		<div
			class="d-flex flex-column align-items-center align-items-sm-start px-3 pt-2 text-white min-vh-100">
			<a href="home.jsp"
				class="d-flex align-items-center pb-3 mb-md-0 me-md-auto text-white text-decoration-none">
				<span class="fs-5 d-none d-sm-inline">Menu</span>
			</a>
			<ul
				class="nav nav-pills flex-column mb-sm-auto mb-0 align-items-center align-items-sm-start"
				id="menu">
				<li class="nav-item"><a href="home.jsp"
					class="nav-link align-middle px-0"> <i class="fas fa-home"></i>
						<span class="ms-1 d-none d-sm-inline">Home</span>
				</a></li>
				<li><a href="#submenu1" data-bs-toggle="collapse"
					class="nav-link px-0 align-middle"> <i class="fas fa-tasks"></i>
						<span class="ms-1 d-none d-sm-inline">Management</span>
				</a>
					<ul class="collapse nav flex-column ms-1" id="submenu1"
						data-bs-parent="#menu">
						<li class="w-100"><a href="registration/patientRegister.jsp"
							class="nav-link px-0"> <span class="d-none d-sm-inline">Patients
									Management</span>
						</a></li>
						<li><a href="registration/doctorRegister.jsp"
							class="nav-link px-0"> <span class="d-none d-sm-inline">Doctors
									Management</span></a></li>
						<li><a href="registration/wardRegister.jsp"
							class="nav-link px-0"> <span class="d-none d-sm-inline">Wards
									Management</span></a></li>
						<li><a href="registration/branchRegister.jsp"
							class="nav-link px-0"> <span class="d-none d-sm-inline">Branches
									Management</span></a></li>
						<li><a href="registration/userRegister.jsp"
							class="nav-link px-0"> <span class="d-none d-sm-inline">Users
									Management</span></a></li>
						<li><a href="registration/medicineRegister.jsp"
							class="nav-link px-0"> <span class="d-none d-sm-inline">Medicines
									Management</span></a></li>
					</ul></li>
				<li><a href="stockmgmt.jsp" class="nav-link px-0 align-middle">
						<i class="fas fa-cubes"></i> <span class="ms-1 d-none d-sm-inline">Stocks</span>
				</a></li>
				<li><a href="#submenu2" data-bs-toggle="collapse"
					class="nav-link px-0 align-middle "> <i
						class="fas fa-credit-card"></i> <span
						class="ms-1 d-none d-sm-inline">Payments</span></a>
					<ul class="collapse nav flex-column ms-1" id="submenu2"
						data-bs-parent="#menu">
						<li class="w-100"><a href="payment/payment1.jsp"
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
				<li><a href="hospitalization.jsp"
					class="nav-link px-0 align-middle"> <i
						class="fas fa-user-nurse"></i> <span
						class="ms-1 d-none d-sm-inline">Hospitalization</span>
				</a></li>
				<li><a href="patientTransfer.jsp"
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
					<li><a class="dropdown-item" href="logout">Sign out</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="main-content">
		<div class="topic">
				<h2>
					Stock Management
				</hh2>
		</div>
		<div class="wrapper mt-lg-3">

			<div class="formContainer">
				<form action="stock" method="POST">
					<div class="row centerCont">
						<div class="col col-lg-6 col-md-10 col-xs-11">
							<div class="row centerCont">
								<div class="col col-lg-3">
									<label for="exampleFormControlInput1" class="form-label">Medicine
										Name</label>
								</div>
								<div class="col col-lg-7">
									<select class="form-select" aria-label="Default select example"
										name="medicine" required>
										<option selected hidden value="">Select the Medicine</option>
										<%
										while (medicines.next()) {
										%>
										<option
											value="<%out.print(medicines.getInt("medicine_id"));%>">
											<%
											out.println(medicines.getString("medicine_name"));
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
									<label for="qty" class="form-label">Quantity</label>
								</div>
								<div class="col col-lg-7">
									<input type="Number" class="form-control" name="qty" required
										onchange="calc()" id="qty" placeholder="">
								</div>
							</div>
						</div>
					</div>

					<div class="row centerCont">
						<div class="col col-lg-6 col-md-10 col-xs-11">
							<div class="row centerCont">
								<div class="col col-lg-3">
									<label for="uprice" class="form-label">Unit Price</label>
								</div>
								<div class="col col-lg-7">
									<input type="Number" class="form-control" name="uprice"
										required onchange="calc()" id="uprice" placeholder="">
								</div>
							</div>
						</div>
						<div class="col col-lg-6 col-md-10 col-xs-11">
							<div class="row centerCont">
								<div class="col col-lg-3">
									<label for="total" class="form-label">Total Amount</label>
								</div>
								<div class="col col-lg-7">
									<input type="Number" class="form-control" name="total"
										id="total" placeholder="">
								</div>
							</div>
						</div>
					</div>
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
										<option value=<%out.println(rs.getInt("branch_id"));%>
											<%if (rs.getInt("branch_id") == (Integer) session.getAttribute("branch_id"))
	out.print("selected");%>>
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
					</div>
					<div class="row centerCont">
						<div class="d-grid gap-2 col-2 mx-auto pt-3">
							<button class="btn btnSubmit btn-sm ">Add New Stock</button>
						</div>
					</div>
				</form>
			</div>
			<div class="tblContainer">
				<div class="row centerCont ">
					<div class="col col-lg-11 col-md-10 col-xs-11">


						<table class="table table-primary table-hover table-responsive">
							<thead>
								<tr class=" table-primary">
									<th scope="col">Medicine</th>
									<th scope="col">Unit Price</th>
									<th scope="col">Quantity</th>
									<th scope="col">Total Amount</th>
									<th scope="col">Branch</th>
									<th scope="col"></th>
								</tr>
							</thead>
							<tbody>
							<!--  MYSQL stocks get								 -->
							<%
								while (rsStocks.next()) {
								%>
								<tr class="table-light">
									<th scope="row"><%out.println(rsStocks.getString("medicine_name"));%></th>
									<td><%out.println(rsStocks.getFloat("unit_pirce"));%></td>
									<td><%out.println(rsStocks.getInt("qty"));%></td>
									<td><%out.println(rsStocks.getFloat("total"));%></td>
									<td><%out.println(rsStocks.getString("branch_name"));%></td>
									<td>
										<ul class="flexList">
											<li>
											<a
												href="stock?id=<%out.println(rsStocks.getInt("stock_id"));%>">
												<button>
													<i class="far fa-trash-alt"></i>
												</button>
												</a>
											</li>
										</ul>
									</td>
								</tr>
								<%} %>
							<!-- 	MYSQL stocks get end							 -->
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
			© 2021 Copyright: <a class="text-dark" href="https://combank.lk/">Hospital
				MGT</a>
		</div>
		<!-- Copyright -->
	</footer>
</body>
<script>
	function calc() {
		var uprice = document.getElementById("uprice").value;
		var qty = document.getElementById("qty").value;
		var total = document.getElementById("total").value;
		document.getElementById("total").value = uprice * qty;

	}
</script>
l>
	
	
