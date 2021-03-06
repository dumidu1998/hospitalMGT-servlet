<head> 
<% if(session.getAttribute("branch_id")!=null ||session.getAttribute("role")!=null||session.getAttribute("email")!=null)response.sendRedirect("home.jsp"); %>
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
<title>HOSPITAL MGT</title>
</head>
<body class="colBg">
	<div class="wrapper mt-lg-3">
		<div class="loginContainer">
			<div class="row centerCont">
				<div class="col col-lg-9 col-md-10 col-xs-11">
					<div class="row centerCont">
						<div class="col col-lg-6 col-xs-10">
							<div class="loginTxtBox">
								<h3>Welcome</h3>
								<h5>Hospital Management System</h5>
								<p>Please Login to access the HMS</p>
							</div>
						</div>
						<div class="col col-lg-6 col-xs-10">
							<form action="login" method="POST">
								<div class="loginBox">
									<h5>Login</h5>
									<input type="email" class="form-control"
										id="exampleFormControlInput1" placeholder="email" name="email">
									<input type="password" class="form-control"
										id="exampleFormControlInput1" placeholder="Password"
										name="pass">
									<div class="left-text">
										<div class="form-check">
											<input class="form-check-input" type="checkbox"
												name="flexcheckboxDefault" id="flexcheckboxDefault1">
											<label class="form-check-label" for="flexcheckboxDefault1">
												Keep me logged in </label>
											<%
											if (request.getParameter("invaliddata") != null) {
												out.print("<p class='text-danger'>Invalid Login Credentials</p>");
											}
											%>
										</div>
									</div>
									<button class="btn btnlogin btn-sm ">Login</button>
								</div>
							</form>
						</div>

					</div>
				</div>
			</div>
		</div>

	</div>
</body>