 <%@ page contentType="text/html;charset=UTF-8" %>
 <%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<html>
<head>
	<title>字典管理</title>
	<meta name="decorator" content="default"/>
	<script type="text/javascript">
		function page(n,s){
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			//alert($("#pageNo").val(n));
			$("#searchForm").submit();
	    	return false;
	    }
	</script>
</head>
<body>

	<form:form id="searchForm" action="${ctx}/sys/sysdatacode/" method="post" class="breadcrumb form-search">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}"/>
		<input id="pageSize" name="pageSize" type="hidden" value="${page.pageSize}"/>
		<div>
			&nbsp;&nbsp;&nbsp;<input id="btnSubmit" class="btn btn-primary" type="submit" value="查询"/>&nbsp;&nbsp;
		</div>
	</form:form>
	<sys:message content="${message}"/>




	<table id="contentTable" class="table table-striped table-bordered table-condensed">
		<thead><tr><th>键值</th><th>标签</th><th>类型</th><th>描述</th><th>排序</th><th>操作</th></tr></thead>
		<tbody>
		<c:forEach items="${page.list}" var="sysDatacode">
			<tr>

				<td><a href="${ctx}/sys/sysDatacode/form?id=${sysDatacode.id}">${sysDatacode.code}</a></td>

				<td>${sysDatacode.sortno}</td>
				<td>
    				<a href="${ctx}/sys/sysdatacode/form?id=${sysDatacode.id}">修改</a>
					<a href="${ctx}/sys/sysdatacode/delete?id=${sysDatacode.id}" onclick="return confirmx('确认要删除该字典吗？', this.href)">删除</a>
				</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<div class="pagination">${page}</div>
</body>
</html>