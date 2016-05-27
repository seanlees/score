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
            action="${pageContext.servletContext.contextPath }/background/customer/add.html"
            method="post">
        <table class="ttab" height="100" width="85%" border="0"
               cellpadding="0" cellspacing="1" align="center">
            <tr>
                <td height="30" colspan="4">
                    <div align="center">
                        <font color="blue" size="8"><b>添加会员</b>
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
                        <input style="height: 20px;width: 170px" name="customerName"/>
                        <font color="red">*会员的姓名</font>
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
                    <div align="right" class="STYLE1">办卡存入金额：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="cardMoney"/>
                        <font color="red">*必填</font>
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
                    <div align="right" class="STYLE1">会员卡号：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="cardNo"/>
                        <font color="red">*会员的卡号</font>
                    </div>
                </td>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">会员居住地址：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="address"/>
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">会员卡密码：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="cardPwd"/>
                    </div>
                </td>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">会员生日：</div>
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

            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">办卡操作人：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="operateManager"/>
                    </div>
                </td>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">办卡人提成金额：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="operateMoney"/>
                        推荐顾客进行办卡的工作者可以进行提成
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">会员卡类型：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <select name="cardType" style="width:170px">
                            <c:forEach items="${CardType}" var="ct">
                                <option value="${ct.val}">${ct.typeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                </td>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">办卡赠送金额：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="freeMoney"/>
                        可以根据情况对于办卡顾客赠送少许金额
                    </div>
                </td>
            </tr>
            <tr>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">会员积分：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input type="text" name="score" value="10" style="height: 20px;width: 170px"/>
                        首次办卡是否赠送积分
                    </div>
                </td>
                <td height="30" width="10%">
                    <div align="right" class="STYLE1">报警金额：</div>
                </td>
                <td>
                    <div align="left" class="STYLE1" style="padding-left:10px;">
                        <input style="height: 20px;width: 170px" name="alarmMoney"/>
                        当会员卡余额低于此值可以使用微信、短信进行提醒
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
            var username = $("input[name='customerName']").val();
            if ($.trim(username) == "") {
                alert("必须填写会员名称");
                return;
            }

            var money = $("input[name='cardMoney']").val();
            var regx = /^[0-9]+(.[0-9]{1,2})?$/;
            if ($.trim(money) == "") {
                alert("创建会员时必须输入首次开卡存入金额");
                return;
            }
            if (!regx.test(money)) {
                alert("金额必须为数字并且最多两位小数,格式为#.##,例如：9 或者 9.0 或者 9.00");
                return;
            }

            var cardno = $("input[name='cardNo']").val();
            if ($.trim(cardno) == "") {
                alert("会员卡号不能为空");
                return;
            }

            $("form").submit();
        });
    });
</script>
</body>
</html>
