<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="CITY FORM" />
    <c:param name="body">
        <spring:hasBindErrors name="city">
            <script type="text/javascript">
                $(document).ready(function() {
                    $("div.control-group>div.controls>.error").parent().parent().addClass("error");
                });
            </script>
        </spring:hasBindErrors>
        <form:form method="post" action="." modelAttribute="city"
            cssClass="form-horizontal">
            <fieldset>
                <legend>city</legend>
                <div class="control-group">
                    <label class="control-label" for="cityName">city name</label>
                    <div class="controls">
                        <form:input path="cityName" cssClass="span5"
                            cssErrorClass="error" />
                        <form:errors path="cityName"
                            cssClass="error help-inline inline"
                            element="span" />
                    </div>
                </div>
                
                <div class="control-group">
                    <label class="control-label" for="regionId.regionId">region ID</label>
                    <div class="controls">
                        <%--  <form:input path="regionId.regionId" cssClass="span3"
                            cssErrorClass="error" />  --%>
                            
                          <form:select path="regionId.regionId"  cssClass="span3" cssErrorClass="error">
                            <c:forEach items="${regionOption}" var="ro">
                            	<form:option value="${ro.regionId}">${ro.regionName}</form:option>
                            </c:forEach>
                         </form:select>
                            
                        <form:errors path="regionId.regionId"
                            cssClass="error help-inline inline"
                            element="span" />
                    </div>
                </div>
                <form:hidden path="cityId" />
                <div class="form-actions">
                    <input type="submit" class="btn btn-primary"
                        value="Submit">&nbsp;
                    <button type="reset" class="btn">Cancel</button>
                </div>
            </fieldset>
        </form:form>
        <hr>
        <a href='${pageContext.request.contextPath}/city/list' class="btn">list</a>
    </c:param>
</c:import>

