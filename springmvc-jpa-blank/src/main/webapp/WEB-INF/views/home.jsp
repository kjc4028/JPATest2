<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
	<c:param name="title" value="HOME" />
	<c:param name="body">
		<h2>Hello!</h2>
		<p>
			${f:h(serverTime)} <br>
		</p>
		<%-- 	<li><a href='${pageContext.request.contextPath}/person/list/'>PERSON
					LIST</a></li>
			<li><a href='${pageContext.request.contextPath}/person/form/'>PERSON
					CREATE</a></li> --%>

		<div class="navbar">
			<div class="nav">
				<a href='${pageContext.request.contextPath}/city/list/'
					class="btn btn-primary">CITY LIST</a> 
					<br>
					<a href='${pageContext.request.contextPath}/city/form/'
					class="btn btn-primary">CITY CREATE</a>
			</div>
			<div class="nav">
				<a href='${pageContext.request.contextPath}/region/list/'
					class="btn btn-primary">REGION LIST</a> 
					<br>
					<a href='${pageContext.request.contextPath}/region/form/'
					class="btn btn-primary">REGION CREATE</a>
			</div>
		</div>


	</c:param>
</c:import>

