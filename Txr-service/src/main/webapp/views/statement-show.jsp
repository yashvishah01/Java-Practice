<%@ page import="java.util.List"%>
<%@ page import="com.example.demo.model.*"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>account service</title>
<link href="css/bootstrap.css" rel="stylesheet">
</head>
<body class="container">
	<hr />
	<h1>Account Service - v10</h1>
	<hr />

	<nav>
		<ul class="nav nav-pills">
			<li class="nav-item"><a class="nav-link" href="txr.htm">Transfer</a></li>
			<li class="nav-item"><a class="nav-link" href="show.htm">Statement</a></li>
		</ul>
	</nav>

	<hr />

	<div class="row">
		<div class="col-8 col-sm-6 col-md-6">
			<div class="card card-body">
				<form action="show.htm" method="post">
					<div class="form-group">
						<label>From Acc</label>
						<table style="width: 100%">
							<tr>
								<th>Account Number</th>
								<th>Closing Balance</th>
								<th>Transaction Date</th>
							</tr>

							<%
								List<Txn> txnList = (List) request.getAttribute("txnList");
								for (Txn txn : txnList) {
							%>
							<tr>
								<td><%=txn.getAccount().getNumber()%></td>
								<td><%=txn.getClosingbalance()%></td>
								<td><%=txn.getDate()%></td>


							</tr>
							<%
								}
							%>


						</table>

					</div>

				</form>
			</div>
		</div>
	</div>


</body>
</html>