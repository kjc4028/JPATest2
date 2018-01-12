<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
	<c:param name="title" value="CITY LIST" />
	<c:param name="body">
		<p>
			<a href='${pageContext.request.contextPath}/city/form/'
				class="btn btn-info">CREATE</a>
		</p>
		<table class="table table-striped table-bordered table-condensed">
			<tr>
				<th>CITY ID</th>
				<th>CITY NAME</th>
				<th>REGION ID</th>
				<th>&nbsp;</th>
			</tr>
						${cname.cityName} ${cname.cityId}		
			
			<c:forEach items="${list}" var="list">
			${list.cityName} ${list.cityId}
			</c:forEach>

			
			<c:forEach items="${page.content}" var="city">
				<tr>
					<td>${f:h(city.cityId)}</td>
					<td>${f:h(city.cityName)}</td>
					<td>
						<c:choose>
							<c:when test="${f:h(city.regionId.regionId) eq '0'}">기타</c:when>
							<c:when test="${f:h(city.regionId.regionId) eq '1'}">인천</c:when>
							<c:when test="${f:h(city.regionId.regionId) eq '2'}">서울</c:when>
							<c:when test="${f:h(city.regionId.regionId) eq '8'}">충청도</c:when>
							<c:otherwise>선택 안함</c:otherwise>
						</c:choose>
						</td>
					<td><a
						href='${pageContext.request.contextPath}/city/edit/${city.cityId}'
						class="btn btn-primary">수정</a> <a
						href='${pageContext.request.contextPath}/city/delete/${city.cityId}'
						class="btn">삭제</a></td>
				</tr>
			</c:forEach>
		</table>

		<p>${f:h(page.number + 1)}/${f:h(page.totalPages)}</p>
		<div class="pagination">
			<ul>
				<li><c:if test="${!page.isFirstPage()}">
						<a href='<c:url value="?page=0" />'>&laquo; first</a>
					</c:if></li>
				<li><c:if test="${page.hasPreviousPage()}">
						<a href='<c:url value="?page=${f:h(page.number - 1)}" />'>&lt;
							prev</a>
					</c:if></li>
				<li><c:if test="${page.hasNextPage()}">
						<a href='<c:url value="?page=${f:h(page.number + 1)}" />'>next
							&gt;</a>
					</c:if></li>
				<li><c:if test="${!page.isLastPage()}">
						<a href='<c:url value="?page=${f:h(page.totalPages - 1)}" />'>last
							&raquo;</a>
					</c:if></li>
			</ul>
		</div>
	</c:param>
</c:import>
