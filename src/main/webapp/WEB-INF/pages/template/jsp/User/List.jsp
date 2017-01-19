
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div data-ng-controller="userController" data-ng-init="userList()">
	<div class="panel panel-default">
		<div class="panel-heading">
			<ol class="breadcrumb">
				<li><a data-ng-href="<c:url value="/User/home"/>">Home</a></li>
				<li class="active">User List</li>
			</ol>
		</div>
		<div class="panel-body">
			<table class="table">
				<thead>
					<tr>
						<th>Username</th>
						<th>Name</th>
						<th>Role</th>
						<th>Active</th>
						<th>Delete</th>
					</tr>
				</thead>
				<tr data-ng-repeat="user in userList">
					<td ><a data-ng-bind="user.username" data-ng-click="saveUserName(user.username)" data-ng-href="<c:url value="/User/editView"/>"></a></td>
					<td data-ng-bind="user.name"></td>
					<td data-ng-bind="user.role.description"></td>
					<td data-ng-bind="user.status"></td>
					<td data-ng-show="user.role.description!='Admin'"><button  class="btn btn-info" data-ng-click="deleteUser(user.username)" data-ng-disabled="myForm.$invalid">Delete</button>
								</td>
				</tr>
				<tbody>
				</tbody>
			</table>
		</div>
	</div>
</div>

