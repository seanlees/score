<%@ page language="java" pageEncoding="UTF-8" %>
<%@include file="../../common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="${ctx}"/>
    <%@include file="../../common/common-css.jsp" %>
    <link rel="Stylesheet" href="${ctx}/js/autocomplete/jquery.autocomplete.css"/>
</head>

<body>
<div style="height: 100%;overflow-y: auto;">
    <br/> <br/>
    <form
            action="${pageContext.servletContext.contextPath }/background/order/add.html"
            method="post">
        <table class="ttab" height="100" width="85%" border="0"
               cellpadding="0" cellspacing="1" align="center">
            <tr>
                <td height="30" colspan="4">
                    <div align="center">
                        <font color="blue" size="8"><b>添加消费记录</b>
                        </font>
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">产品名称：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <select id="productSelect" name="productNo" style="width:170px;">
                            <option value="">请选择</option>
                            <c:forEach items="${products}" var="p">
                                <option value="${p.productNo}" data-price="${p.price}">${p.productName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </td>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">顾客编号：</div>
                </td>
                <td width="50%">
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input name="customerNo" style="height: 20px;width: 170px" onpaste="return false">
                        <span></span>
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">产品价格：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="shouldMoney"/>
                        单位：元
                    </div>
                </td>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">服务员工编号：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="employeeNo" onpaste="return false"/>
                        <span></span>
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">结算类型：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <select name="payType" style="height: 20px;width: 170px">
                            <c:forEach items="${PayType}" var="p">
                                <option value="${p.val}">${p.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </td>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">订单类型：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <select name="orderType" style="height: 20px;width: 170px">
                            <c:forEach items="${OrderType}" var="o">
                                <option value="${o.val}">${o.name}</option>
                            </c:forEach>
                        </select>
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">折扣价：</div>
                </td>
                <td colspan="3">
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="discount" value="1"
                               type="text"/>
                        默认为1即没有折扣，要添加折扣需输入折扣数，例如:9折输入0.9
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">赠送积分：</div>
                </td>
                <td colspan="3">
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="score" value="0"/>
                        默认不赠送积分，要赠送积分直接输入积分，例如：10积分输入10
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
<script type="text/javascript" src="${pageContext.servletContext.contextPath }/js/utils.js"></script>
<script type="text/javascript"
        src="${pageContext.servletContext.contextPath }/js/autocomplete/jquery.autocomplete.pack.js"></script>
<script type="text/javascript">
    $(function () {

        $("#productSelect").change(function () {
            $("input[name='shouldMoney']").val($(this).find("option:selected").data("price"));
        });

        util.customerTips("input[name='customerNo']", function (row, data) {
            $("input[name='customerNo']").val(row.customerNo);
            $("input[name='customerNo']").next("span").text(row.customerName);
        });

        util.employeeTips("input[name='employeeNo']", function (row, data) {
            $("input[name='employeeNo']").val(row.employeeNo);
            $("input[name='employeeNo']").next("span").text(row.employeeName);
        });

        //提交验证
        $("#submint_form").click(function () {
            //产品名称验证
            var orderName = $("#productSelect").val();
            if ($.trim(orderName) == "") {
                alert("必须填写产品名称");
                return;
            }

            var price = $("input[name='shouldMoney']").val();
            if ($.trim(price) == "") {
                alert("必须填写产品价格");
                return;
            }
            var regx = /^[0-9]+(.[0-9]{1,2})?$/;
            if (!regx.test(price)) {
                alert("金额必须为数字并且最多两位小数,格式为#.##,例如：8 或者 8.0 或者 8.00");
                return;
            }

            var discount = $("input[name='discount']").val();
            if ($.trim(discount) == "") {
                alert("必须填写产品价格");
                return;
            }
            regx = /(0(.[0-9]{1,2})?)|(1)$/;
            if (!regx.test(discount)) {
                alert("折扣必须为数字并且最多两位小数,格式为#.##,例如：0.88 或者 0.88 或者 0.88");
                return;
            }

            var score = $("input[name='score']").val();
            if ($.trim(score) == "") {
                alert("必须填写积分");
                return;
            }
            regx = /^[0-9]+$/;
            if (!regx.test(score) || score < 0 || score > 1000) {
                alert("积分必须为数字,并且不能大于1000积分");
                return;
            }

            $("form").submit();
        });


        $("input[name='customerNo']").keypress(function(e){
            noPermitInput(e);
        });

        $("input[name='employeeNo']").keypress(function(e){
            noPermitInput(e);
        });

        function noPermitInput(e) {
            var evt = window.event || e;
            if (window.navigator.userAgent.toLowerCase().indexOf("msie") >= 1) {
                evt.returnValue = false; //ie 禁止键盘输入
            } else {
                evt.preventDefault(); //fire fox 禁止键盘输入
            }
        }
    });


</script>
</body>
</html>
