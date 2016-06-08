<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>字典管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		$(document).ready(function() {
			$("#value").focus();
			$("#inputForm").validate({
				submitHandler: function(form){
					loading('正在提交，请稍等...');
					form.submit();
				},
				errorContainer: "#messageBox",
				errorPlacement: function(error, element) {
					$("#messageBox").text("输入有误，请先更正。");
					if (element.is(":checkbox")||element.is(":radio")||element.parent().is(".input-append")){
						error.appendTo(element.parent().parent());
					} else {
						error.insertAfter(element);
					}
				}
			});
		});
	</script>
</head>
<body>
	<ul class="nav nav-tabs">
		<li><a href="${ctx}/sys/sysdatacode/">字典列表</a></li>
		<li class="active"><a href="${ctx}/sys/sysdatacode/form?id=${sysdatacode.id}">字典${not empty sysDatacode.id?'修改':'添加'}查看></a></li>
	</ul><br/>
	<form:form id="inputForm" modelAttribute="sysDatacode" action="${ctx}/sys/sysdatacode/save" method="post" class="form-horizontal">
		<form:hidden path="id"/>
		<sys:message content="${message}"/>

		<div class="control-group">
			<label class="control-label">标签:</label>
			<div class="controls">
				<form:input path="code" htmlEscape="false" maxlength="50" class="required"/>
			</div>
		</div>
		<div class="control-group">
			<label class="control-label">类型:</label>
			<div class="controls">
				<form:input path="codedesc" htmlEscape="false" maxlength="50" class="required abc"/>
			</div>
		</div>

		<div class="control-group">
			<label class="control-label">排序:</label>
			<div class="controls">
				<form:input path="sortno" htmlEscape="false" maxlength="11" class="required digits"/>
			</div>
		</div>

		<div class="form-actions">
			<shiro:hasPermission name="sys:sysdatacode:edit"><input id="btnSubmit" class="btn btn-primary" type="submit" value="保 存"/>&nbsp;</shiro:hasPermission>
			<input id="btnCancel" class="btn" type="button" value="返 回" onclick="history.go(-1)"/>
		</div>
	</form:form>
</body>
</html>