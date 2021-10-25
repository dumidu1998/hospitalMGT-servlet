<!doctype html>
<%@page import="dao.MedicineIssueDAO"%>
<%@page import="dao.StockDAO"%>
<%@page import="model.Patient"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="dao.PatientHospitalizationDAO"%>
<%@page import="java.sql.Connection"%>
<%@page import="servlets.Conn"%>
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
<title>Hospital MGT</title>
</head>

<body class="colBg">
	<%
	Conn dbconn = new Conn();
		Connection conn = dbconn.get_connection();
		PatientHospitalizationDAO hospitDAO = new PatientHospitalizationDAO(conn);
		MedicineIssueDAO medissueDAO = new MedicineIssueDAO(conn);
		StockDAO stockDAo = new StockDAO(conn);
		ResultSet patients = null;
		String patientName = "";
		ResultSet stocks = null;
		ResultSet issued = null;
		ResultSet issued2 = null;
		float totalmed = 0;
		if (request.getParameter("id") == null) {
			if ((Integer) session.getAttribute("role") == 1) {
		patients = hospitDAO.getAll();
		stocks = stockDAo.getAll();
			} else {
		stocks = stockDAo.getAllbyBranch((Integer) session.getAttribute("branch_id"));
		patients = hospitDAO.getAllbyBranch((Integer) session.getAttribute("branch_id"));
			}
		} else {
			issued = medissueDAO.getAllByHospitalizationId((Integer.parseInt(request.getParameter("id"))));
			issued2 = medissueDAO.getAllByHospitalizationId((Integer.parseInt(request.getParameter("id"))));
			stocks = stockDAo.getAllbyBranch((Integer) session.getAttribute("branch_id"));
			patientName = hospitDAO.getUserName(Integer.parseInt(request.getParameter("id")));
			while (issued2.next())
		totalmed += issued2.getInt("qty") * issued2.getFloat("price");
		}
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
					<ul class="collapse nav flex-column ms-1" id="submenu1"
						data-bs-parent="#menu">
						<li class="w-100"><a
							href="../registration/patientRegister.jsp" class="nav-link px-0">
								<span class="d-none d-sm-inline">Patient Management</span>
						</a></li>
						<li><a href="../registration/doctorRegister.jsp"
							class="nav-link px-0"> <span class="d-none d-sm-inline">Doctor
									Management</span></a></li>
						<li><a href="../registration/wardRegister.jsp"
							class="nav-link px-0"> <span class="d-none d-sm-inline">Ward
									Management</span></a></li>
						<li><a href="../registration/branchRegister.jsp"
							class="nav-link px-0"> <span class="d-none d-sm-inline">Branch
									Management</span></a></li>
						<li><a href="../registration/userRegister.jsp"
							class="nav-link px-0"> <span class="d-none d-sm-inline">User
									Management</span></a></li>
						<li><a href="../registration/medicineRegister.jsp"
							class="nav-link px-0"> <span class="d-none d-sm-inline">Medicine
									Management</span></a></li>
					</ul></li>
				<li><a href="../stockmgmt.jsp"
					class="nav-link px-0 align-middle"> <i class="fas fa-cubes"></i>
						<span class="ms-1 d-none d-sm-inline">Stock</span></a></li>
				<li><a href="#submenu2" data-bs-toggle="collapse"
					class="nav-link px-0 align-middle "> <i
						class="fas fa-credit-card"></i> <span
						class="ms-1 d-none d-sm-inline">Payments</span></a>
					<ul class="collapse show nav flex-column ms-1" id="submenu2"
						data-bs-parent="#menu">
						<li class="w-100"><a href="payment1.jsp"
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
					class="d-none d-sm-inline mx-1">loser</span>
				</a>
				<ul class="dropdown-menu dropdown-menu-dark text-small shadow"
					aria-labelledby="dropdownUser1">
					<li><a class="dropdown-item" href="#">New project...</a></li>
					<li><a class="dropdown-item" href="#">Settings</a></li>
					<li><a class="dropdown-item" href="#">Profile</a></li>
					<li>
						<hr class="dropdown-divider">
					</li>
					<li><a class="dropdown-item" href="#">Sign out</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="main-content">
		<div class="topic">
			<h2>Bill Payment</h2>
		</div>
		<div class="wrapper mt-lg-3">

			<div class="formContainer">
				<form action="" method="GET">
					<div class="row centerCont mt-5">
						<div class="col col-lg-6 col-md-10 col-xs-11">
							<div class="row centerCont">
								<div class="col col-lg-5">
									<label for="exampleFormControlInput1" class="form-label">Patient
										Name & Date of Hospitalized</label>
								</div>
								<div class="col col-lg-7">
									<select class="form-select" aria-label="Default select example"
										name="id" required>
										<option selected hidden value="">Select the Patient</option>
										<%
										if (request.getParameter("id") == null) {
											while (patients.next()) {
										%>
										<option
											value=<%out.println(patients.getInt("hospitalization_id"));%>>
											<%
											out.println(patients.getString("p_name"));
											%> -
											<%
											out.println(patients.getDate("date_admitted"));
											%>
										</option>
										<%
										}
										}
										%>
									</select>
								</div>
							</div>
						</div>
						<div class="col col-lg-6 col-md-10 col-xs-11">
							<div class="row centerCont">
								<div class="col col-lg-3"></div>
								<div class="col col-lg-7">
									<button class="btn btnSubmit btn-sm ">Search</button>
								</div>
							</div>
						</div>
				</form>
			</div>


			<h3 class="ms-5 mt-3">
				<%
				out.print(patientName);
				%>
			</h3>



			<div>
				<div class="row centerCont mt-5">
					<div class="col col-lg-11 col-md-10 col-xs-11 borTop">
						<div class="row centerCont mt-3">
							<div class="col col-lg-5">
								<h4>Medicines Issued</h4>
							</div>
							<div class="col col-lg-7"></div>
						</div>
					</div>
				</div>

				<div class="row centerCont mt-3">
					<div class="col col-lg-5 col-md-5 col-xs-11">
						<form action="../issuemedicine" method="POST">
							<input type="hidden" name="hosid"
								value="<%out.print(request.getParameter("id"));%>" />
							<div class="row centerCont">
								<div class="col col-lg-3">
									<label for="exampleFormControlInput1" class="form-label">Medicine</label>
								</div>
								<div class="col col-lg-6">
									<select class="form-select" aria-label="Default select example"
										name="stockid" required>
										<option selected hidden value="">Select the medicine</option>
										<%
										while (stocks.next()) {
										%>
										<option value=<%out.println(stocks.getInt("medicine_id"));%>>
											<%
											out.println(stocks.getString("medicine_name"));
											%>
										</option>
										<%
										}
										%>
									</select>
								</div>
							</div>
					</div>
					<div class="col col-lg-5 col-md-5 col-xs-11">
						<div class="row centerCont">
							<div class="col col-lg-3">
								<label for="exampleFormControlInput1" class="form-label">Quantity</label>
							</div>
							<div class="col col-lg-6">
								<input type="number" class="form-control" min="1" name="qty"
									id="exampleFormControlInput1" placeholder="">
							</div>
						</div>
					</div>
					<div class="col col-lg-2 col-md-2 col-xs-11">
						<div class="row centerCont">
							<div class="mx-auto">
								<button class="btn btnSubmit btn-sm ">Add</button>
							</div>
						</div>
					</div>
					</form>
				</div>
				<div class="row centerCont">
					<div class="col col-lg-11 col-md-10 col-xs-11">
						<div class="row centerCont">
							<div class="col col-lg-12 mt-4">
								<table class="table table-primary table-hover table-responsive">
									<thead>
										<tr class=" table-primary">
											<th scope="col">Medicine</th>
											<th scope="col">Unit Price</th>
											<th scope="col">Quantity</th>
											<th scope="col">Total Amount</th>
										</tr>
									</thead>
									<tbody>
										<%
										if (request.getParameter("id") != null) {
											while (issued.next()) {
										%>
										<tr class="table-light">
											<th scope="row">
												<%
												out.print(issued.getString("medicine_name"));
												%>
											</th>
											<td>
												<%
												out.print(issued.getFloat("price"));
												%>
											</td>
											<td>
												<%
												out.print(issued.getInt("qty"));
												%>
											</td>
											<td>
												<%
												out.print(issued.getInt("qty") * issued.getFloat("price"));
												%>
											</td>
										</tr>
										<%
										}
										}
										%>
									</tbody>
								</table>

							</div>
						</div>
					</div>
				</div>
			</div>

			<div>
				<form action="../checkout" method="post">
				<input type="hidden" name="hosid"
								value="<%out.print(request.getParameter("id"));%>" />
					<div class="row centerCont mt-5">
						<div class="col col-lg-6 col-md-10 col-xs-11">
							<div class="row centerCont">
								<div class="col col-lg-3"></div>
								<div class="col col-lg-7"></div>
							</div>
						</div>
						<div class="col col-lg-6 col-md-10 col-xs-11">
							<div class="row centerCont">
								<div class="col col-lg-3">
									<label for="exampleFormControlInput1" class="form-label">Total
										Medicine Fee</label>
								</div>
								<div class="col col-lg-7">
									<input type="number" class="form-control"
										value="<%out.print(totalmed);%>" name="totalmed" id="mfee"
										placeholder="">
								</div>
							</div>
						</div>
					</div>
					<div class="row centerCont mt-5">
						<div class="col col-lg-6 col-md-10 col-xs-11">
							<div class="row centerCont">
								<div class="col col-lg-3">
									<label for="exampleFormControlInput1" class="form-label">Doctor
										Fee</label>
								</div>
								<div class="col col-lg-7">
									<input type="number" class="form-control" step="0.1"
										name="docfee" required id="dfee" placeholder=""
										onchange="calg()">
								</div>
							</div>
						</div>
						<div class="col col-lg-6 col-md-10 col-xs-11">
							<div class="row centerCont">
								<div class="col col-lg-3">
									<label for="exampleFormControlInput1" class="form-label">Hospital
										Fee</label>
								</div>
								<div class="col col-lg-7">
									<input type="number" class="form-control" step="0.1"
										name="hosfee" required id="hfee" placeholder=""
										onchange="calg()">
								</div>
							</div>
						</div>
					</div>
					<div class="row centerCont">
						<div class="col col-lg-12 col-md-10 col-xs-11">
							<div class="row centerCont">
								<div class="col col-lg-2">
									<label for="exampleFormControlInput1" class="form-label">Remarks</label>
								</div>
								<div class="col col-lg-9">
									<textarea rows="4" cols="" class="form-control" name="remark"></textarea>
								</div>
							</div>
						</div>
					</div>
			</div>
			<div class="row mt-4 centerCont">
				<div class="col col-lg-6 col-md-10 col-xs-11">
					<div class="row centerCont">
						<div class="col col-lg-3">
							<label for="exampleFormControlInput1" class="form-label">Total
								Payable</label>
						</div>
						<div class="col col-lg-7">
							<input type="number" class="form-control" id="gtotal"
								name="gtotal" placeholder="">
						</div>
					</div>
				</div>
				<div class="col col-lg-6 col-md-10 col-xs-11">
					<div class="row centerCont">
						<div class="col col-lg-7"></div>
						<div class="col col-lg-3">
							<div class="d-grid gap-2 col-12 mx-auto ">
								<button class="btn btnSubmit btn-sm ">Complete Payment</button>
							</div>
						</div>
					</div>
				</div>
			</div>
			</form>
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
	</div>
</body>
<script type="text/javascript">
	function calg() {
		var hfee = document.getElementById("hfee").value;
		var dfee = document.getElementById("dfee").value;
		var mfee = document.getElementById("mfee").value;
		document.getElementById("gtotal").value = Number(hfee) + Number(dfee) + Number(mfee);
	}
</script>
</html>
<!--this is powered by infini team  -->
