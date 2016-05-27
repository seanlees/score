<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../../common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <%@include file="../../common/common-css.jsp" %>
    <script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/My97DatePicker/WdatePicker.js"></script>
</head>

<body>
<div style="height: 100%;overflow-y: auto;">
    <br/> <br/>
    <form
            action="${pageContext.servletContext.contextPath }/background/employee/add.html"
            method="post">
        <table class="ttab" height="100" width="85%" border="0"
               cellpadding="0" cellspacing="1" align="center">
            <tr>
                <td height="30" colspan="4">
                    <div align="center">
                        <font color="blue" size="8"><b>添加雇员</b>
                        </font>
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">员工姓名：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="employeeName"/>
                        <font color="red">*员工的姓名</font>
                    </div>
                </td>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">性别：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <select name="sex" width="60px">
                            <option value="0">男</option>
                            <option value="1">女</option>
                        </select>
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">员工生日：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <%--<input style="height: 20px;width: 170px" name="birthDay"
                               type="text"/>--%>
                        <input type="text" name="birthDay" class="Wdate" style="height: 20px;width: 170px"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" />
                        会员生日(记录生日可以做活动)
                    </div>
                </td>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">手机号：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="mobile"/>
                        会员的手机号
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">员工类型：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <select name="type" style="width:170px">
                            <c:forEach items="${EmployeeType}" var="ct">
                                <option value="${ct.type}">${ct.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </td>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">开始工作日期：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <%--<input style="height: 20px;width: 170px" name="workDate"/>--%>
                        <input type="text" name="workDate" class="Wdate" style="height: 20px;width: 170px"
                               onclick="WdatePicker({dateFmt:'yyyy-MM-dd'})" readonly="readonly" />
                    </div>
                </td>
            </tr>
            <tr>
                <td colspan="4" style="padding: 10px">
                    <div align="center">
                        <input id="submint_form" type="button" value="　保　存　" class="input_btn_style1"/> <input
                            id="backBt" type="button" value="　返　回　" class="input_btn_style1"
                            onclick="javascript:window.location.href='javascript:history.go(-1)'"/>
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/jquery_1_7_2_min.js"></script>
<script type="text/javascript">
    $(function () {
        //提交验证
        $("#submint_form").click(function () {
            //会员名称验证
            var username = $("input[name='employeeName']").val();
            if ($.trim(username) == "") {
                alert("必须填写员工姓名");
                return;
            }

            $("form").submit();
        });
    });
</script>
</body>
</html>
