<c:import url="/WEB-INF/views/common/layout.jsp" charEncoding="UTF-8">
    <c:param name="title" value="REGION FORM" />
    <c:param name="body">
        <spring:hasBindErrors name="region">
            <script type="text/javascript">
                $(document).ready(function() {
                    $("div.control-group>div.controls>.error").parent().parent().addClass("error");
                });
            </script>
        </spring:hasBindErrors>
        <form:form method="post" action="." modelAttribute="region"
            cssClass="form-horizontal">
            <fieldset>
                <legend>region</legend>
                <div class="control-group">
                    <label class="control-label" for="regionName">region name</label>
                    <div class="controls">
                        <form:input path="regionName" cssClass="span5"
                            cssErrorClass="error" />
                        <form:errors path="regionName"
                            cssClass="error help-inline inline"
                            element="span" />
                    </div>
                </div>
                
                <form:hidden path="regionId" />
                <div class="form-actions">
                    <input type="submit" class="btn btn-primary"
                        value="Submit">&nbsp;
                    <button type="reset" class="btn">Cancel</button>
                </div>
            </fieldset>
        </form:form>
        <hr>
        <a href='${pageContext.request.contextPath}/region/list' class="btn">list</a>
    </c:param>
</c:import>

