<%
response.setStatus(500);


//获取异常类
Throwable ex = Exceptions.getThrowable(request);

//编译错误信息
StringBuilder sb = new StringBuilder("错误信息：\n");
if (ex != null) {
	if (ex instanceof BindException) {
		for (ObjectError e : ((BindException)ex).getGlobalErrors()){
			sb.append("☆" + e.getDefaultMessage() + "(" + e.getObjectName() + ")\n");
		}
		for (FieldError e : ((BindException)ex).getFieldErrors()){
			sb.append("☆" + e.getDefaultMessage() + "(" + e.getField() + ")\n");
		}
		LoggerFactory.getLogger("400.jsp").warn(ex.getMessage(), ex);
	}else if (ex instanceof ConstraintViolationException) {
		for (ConstraintViolation<?> v : ((ConstraintViolationException)ex).getConstraintViolations()) {
			sb.append("☆" + v.getMessage() + "(" + v.getPropertyPath() + ")\n");
		}
	} else {
		//sb.append(Exceptions.getStackTraceAsString(ex));
		sb.append("☆" + ex.getMessage());
	}
} else {
	sb.append("未知错误.\n\n");
}

%>


<%@page import="javax.validation.ConstraintViolation"%>
<%@page import="javax.validation.ConstraintViolationException"%>
<%@page import="org.springframework.validation.BindException"%>
<%@page import="org.springframework.validation.ObjectError"%>
<%@page import="org.springframework.validation.FieldError"%>
<%@page import="org.slf4j.Logger,org.slf4j.LoggerFactory"%>

<%@page import="com.tt.common.utils.Exceptions"%>
<%@page contentType="text/html;charset=UTF-8" isErrorPage="true"%>

<%
out.println(sb.toString());

%>


