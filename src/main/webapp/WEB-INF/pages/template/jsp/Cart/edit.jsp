
<%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>



<div data-ng-controller="cartController" data-ng-init="findCart()">
	<div class="panel panel-default">
		<div class="panel-heading">
			<ol class="breadcrumb">
				<li><a href="<c:url value="/Cart/home"/>">Home</a></li>
				<li><a href="<c:url value="/Cart/ListView"/>">List</a></li>
				<li class="active"></li>
			</ol>
		</div>
		<div class="panel-body">
			<div class="container-center ">
				<form class="well" name="myForm" data-ng-submit="editCart()">
					<div class="container">
						<div class="form-group">
							<div class="col-sm-3">
								<input type="text" class="form-control input-group-lg reg_name"
									name="id" data-ng-value="cart.id.id"data-ng-model="cart.id.id" readonly="readonly" placeholder="id" required>
							</div>
							<div class="col-sm-3">
								<input type="number" class="form-control input-group-lg"
									name="cartAmount" data-ng-value="cart.cartDetails.cartAmount"data-ng-model="cart.cartDetails.cartAmount" placeholder="cart Amount*" required>
							</div>
						</div>

						<br /> <br />
						<div class="form-group">
							<div class="col-sm-3">
								<input type="number"
									class="form-control form-control-danger input-group-lg "
									name="linesAmount" data-ng-value="cart.cartDetails.linesAmount"data-ng-model="cart.cartDetails.linesAmount" required >
							</div>
							<div class="col-sm-3">
								<input type="number" class="form-control input-group-lg"
									name="shippingAmount"
									data-ng-value="cart.cartDetails.shippingAmount"data-ng-model="cart.cartDetails.shippingAmount" required>
							</div>
						</div>

						<br /> <br />
						<div class="form-group">
							<div class="col-sm-6">
								 <select name="status" data-ng-model="cart.cartDetails.status.id" data-ng-options="status.id as status.description for status in cartStatus"  class="form-control" required>
									
								
								</select>
							</div>
						</div>
						<br /> <br />
						<div class="form-group">
							<div class="col-sm-6">
								<select name="shipToId" data-ng-model="cart.cartDetails.shipTo.id" data-ng-options="ship.id as ship.name for ship in shipTos"
									class="form-control" required>


								</select>
							</div>
						</div>
						<br /> <br />


						<div class="form-group">
							<div class="col-sm-3">
								 <input
									id="createDate" class="form-control input-group-lg" type="text"
									name="createDate" data-ng-value="cart.audit.createDate| date: 'yyyy-MM-dd HH:mm:ss'"data-ng-model="cart.audit.createDate"
									 readonly="readonly" required>
							</div>
							<div class="col-sm-3">
								<input
									id="updateDate" class="form-control input-group-lg" type="text"
									name="updateDate" title="updateDate"
									 data-ng-value="cart.audit.updateDate| date: 'yyyy-MM-dd HH:mm:ss'"data-ng-model="cart.audit.updateDate" readonly="readonly" required>
							</div>
						</div>
						<br /> <br />
						<div class="form-group">
							<div class="col-sm-6 container-button">
								<button type="submit" class="btn btn-info"
									data-ng-click="submitted= true;"
									data-ng-disabled="myForm.$invalid">Submit</button>

							</div>
						</div>

					</div>
				</form>
			</div>
		</div>
	</div>
</div>



