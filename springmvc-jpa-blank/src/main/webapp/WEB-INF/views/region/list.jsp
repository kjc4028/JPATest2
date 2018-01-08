<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="REGION LIST" />
    <c:param name="body">
        <p>
            <a href='${pageContext.request.contextPath}/region/form/' class="btn btn-info">CREATE</a>
        </p>
        <table
            class="table table-striped table-bordered table-condensed">
            <tr>
                <th>REGION ID</th>
                <th>REGION NAME</th>
                <th>CITY LIST</th>
                <th>&nbsp;</th>
            </tr>
            <c:forEach items="${page.content}" var="region">
                <tr>
                    <td>${f:h(region.regionId)}</td>
                    <td>${f:h(region.regionName)}</td>
                    <td>
                    	<c:forEach items="${region.cityList}" var="li">${li.cityName} </c:forEach>
                    <td><a
                        href='${pageContext.request.contextPath}/region/edit/${region.regionId}'
                        class="btn btn-primary">수정</a> <a
                        href='${pageContext.request.contextPath}/region/delete/${region.regionId}'
                        class="btn">삭제</a></td>
                </tr>
            </c:forEach>
        </table>

        <p>${f:h(page.number + 1)}/${f:h(page.totalPages)}</p>
        <div class="pagination">
            <ul>
                <li><c:if test="${!page.isFirstPage()}">
                        <a href='<c:url value="?page=0" />'>&laquo;
                            first</a>
                    </c:if></li>
                <li><c:if test="${page.hasPreviousPage()}">
                        <a
                            href='<c:url value="?page=${f:h(page.number - 1)}" />'>&lt;
                            prev</a>
                    </c:if></li>
                <li><c:if test="${page.hasNextPage()}">
                        <a
                            href='<c:url value="?page=${f:h(page.number + 1)}" />'>next
                            &gt;</a>
                    </c:if></li>
                <li><c:if test="${!page.isLastPage()}">
                        <a
                            href='<c:url value="?page=${f:h(page.totalPages - 1)}" />'>last
                            &raquo;</a>
                    </c:if></li>
            </ul>
        </div>
    </c:param>
</c:import>
