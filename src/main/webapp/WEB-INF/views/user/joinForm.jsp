<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="err" uri="http://www.springframework.org/security/tags" %>
<err:errors name="userDto">
   	<c:if test="${errors.hasFieldErrors('username') } }">/>
   	</c:if>
</err:errors>
	  
<%@ include file="../layout/header.jsp" %>


<div class="container">
	<form>
	 <div class="form-group">
	    <label for="username">Username</label>
	    <input type="text" class="form-control" placeholder="Enter username" id="username">
	  </div>
	  
	  <div class="form-group">
	    <label for="password">Password</label>
	    <input type="text" class="form-control" placeholder="Enter password" id="password">
	    <c:out value="${valid_password}"/>
	  </div>
	  
	   <div class="form-group">
	    <label for="email">Email</label>
	    <input type="text" class="form-control" placeholder="Enter email" id="email">
	    <c:out value="${valid_email}"/>
	  </div>
	  
	</form>  
	<button id="btn-save" class="btn btn-primary">회원가입완료</button>
</div>

<script src= "/js/user.js"></script>
<%@ include file="../layout/footer.jsp" %>


