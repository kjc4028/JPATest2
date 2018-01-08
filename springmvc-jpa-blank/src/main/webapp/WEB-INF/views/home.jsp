<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
	<c:param name="title" value="HOME" />
	<c:param name="body">
		<h2>Hello!</h2>
		<p>
			${f:h(serverTime)} <br>
		</p>
		<ul>
			<%-- 	<li><a href='${pageContext.request.contextPath}/person/list/'>PERSON
					LIST</a></li>
			<li><a href='${pageContext.request.contextPath}/person/form/'>PERSON
					CREATE</a></li> --%>
			<li><a href='${pageContext.request.contextPath}/city/list/'>CITY
					LIST</a></li>
			<li><a href='${pageContext.request.contextPath}/city/form/'>CITY
					CREATE</a></li>
			<li><a href='${pageContext.request.contextPath}/region/list/'>REGION
					LIST</a></li>
			<li><a href='${pageContext.request.contextPath}/region/form/'>REGION
					CREATE</a></li>
		</ul>
	</c:param>
</c:import>

