<%@include file="../bootstrap-css.jsp"%>
<nav class="navbar navbar-expand-lg navbar-light navbar_colour">
	<div class="container-fluid">
		<a class="navbar-brand" href="index.jsp">Take Notes</a>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="addNotes.jsp">Add notes</a></li>
				<li class="nav-item"><a class="nav-link active" href="showNote">Show
						notes</a></li>
			</ul>
			<form class="d-flex" action="login.jsp" method="post">
				<button class="btn btn-outline-success" style="margin-left: 10px;"
					type="submit">Login</button>
			</form>
			
			<form class="d-flex" action="signIn.jsp" method="post">
				<button class="btn btn-outline-success" style="margin-left: 10px;"
					type="submit">Sign In</button>
			</form>
		</div>
	</div>
</nav>