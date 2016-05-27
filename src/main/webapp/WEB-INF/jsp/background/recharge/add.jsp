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
            action="${pageContext.servletContext.contextPath }/background/recharge/add.html"
            method="post">
        <table class="ttab" height="100" width="85%" border="0"
               cellpadding="0" cellspacing="1" align="center">
            <tr>
                <td height="30" colspan="4">
                    <div align="center">
                        <font color="blue" size="8"><b>会员充值</b>
                        </font>
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">会员姓名：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="customerName" onpaste="return false"/>
                        <input type="hidden" name="customerNo"/>
                        <font color="red">*会员的姓名(双击选择)</font>
                    </div>
                </td>r
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">会员卡号：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="cardNo" readonly/>
                        <font color="red">*会员的卡号</font>
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">充值金额：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="rechargeMoney"/>
                        <font color="red">*必填</font>
                    </div>
                </td>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">充值操作人：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="rechargeOperator" onpaste="return false"/>
                        <font color="red">*必选(双击选择)</font>
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">充值赠送积分：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input type="text" name="score" value="10" style="height: 20px;width: 170px"/>
                        充值是否赠送积分
                    </div>
                </td>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">充值赠送金额：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="freeMoney"/>
                       充值是否赠送金额，和充值金额分开，便于统计赠送总额
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

        util.customerTips("input[name='customerName']", function (row, data) {
            $("input[name='customerName']").val(row.customerName);
            $("input[name='customerNo']").val(row.customerNo);
            $("input[name='cardNo']").val(row.cardNo);
        });

        util.employeeTips("input[name='rechargeOperator']", function (row, data) {
            $("input[name='rechargeOperator']").val(row.employeeName);
        });

        //提交验证
        $("#submint_form").click(function () {
            //会员名称验证
            var username = $("input[name='customerName']").val();
            if ($.trim(username) == "") {
                alert("请双击选择会员名称");
                return;
            }

            var cardNo = $("input[name='cardNo']").val();
            if ($.trim(cardNo) == "") {
                alert("会员卡号为空，请双击选择会员名称,之后会出现会员卡号");
                return;
            }

            var money = $("input[name='rechargeMoney']").val();
            var regx = /^[0-9]+(.[0-9]{1,2})?$/;
            if ($.trim(money) == "") {
                alert("请输入充值金额!");
                return;
            }
            if (!regx.test(money)) {
                alert("金额必须为数字并且最多两位小数,格式为#.##,例如：9 或者 9.0 或者 9.00");
                return;
            }

            var operate = $("input[name='rechargeOperator']").val();
            if ($.trim(operate) == "") {
                alert("请双击选择充值操作人");
                return;
            }

            $("form").submit();
        });

        $("input[name='customerName']").keypress(function(e){
            noPermitInput(e);
        });

        $("input[name='rechargeOperator']").keypress(function(e){
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
