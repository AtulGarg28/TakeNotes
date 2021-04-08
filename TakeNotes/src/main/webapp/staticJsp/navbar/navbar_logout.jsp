<%@include file="../bootstrap-css.jsp"%>
<nav class="navbar navbar-expand-lg navbar-light navbar_colour">
	<div class="fo container-fluid">
		<a class="navbar-brand" href="index.jsp">Take Notes</a>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="addNotes.jsp">Add notes</a></li>
				<li class="nav-item"><a class="nav-link" href="showNote">Show
						notes</a></li>

				<li class="nav-item"><a class="nav-link disabled" href="#"
					tabindex="-1" aria-disabled="true">Disabled</a></li>
			</ul>
			<form class="d-flex" action="showNote">
				<input class="form-control me-2" type="search" placeholder="Search" name="search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
			<form class="d-flex" action="logout">
				<input class="btn btn-outline-success" style="margin-left: 10px;" type="submit" value="logout">
			</form>
		</div>
	</div>
</nav>