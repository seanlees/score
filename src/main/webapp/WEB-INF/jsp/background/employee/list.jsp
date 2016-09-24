<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@include file="../../common/taglib.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@include file="../../common/common-css.jsp" %>
<%@include file="../../common/common-js.jsp" %>
<link rel="stylesheet" type="text/css"
	href="${pageContext.servletContext.contextPath }/css/fenyecss.css" />
    <style type="text/css">
        input {
            font-size: 12px
        }

        .clearfix:after{
            clear:both;
        }

        li {
            line-height: 35px;
            float: left;
            margin: 0px 10px;
        }

        ul {
            overflow: hidden;
            width: 100%;
        }
    </style>
</head>
<body>
<form id="fenye" name="fenye" action="${pageContext.servletContext.contextPath }/background/order/query.html" method="post">
<table width="100%">
  <tr>
    <td height="30" background="${pageContext.servletContext.contextPath }/images/tab_05.gif"><table width="100%">
      <tr>
        <td width="12" height="30"><img src="${pageContext.servletContext.contextPath }/images/tab_03.gif" width="12" height="30" /></td>
        <td><table width="100%">
          <tr>
            <td width="46%" valign="middle"><table width="100%">
              <tr>
                <td width="5%"><div align="center"><img src="${pageContext.servletContext.contextPath }/images/tb.gif" width="16" height="16" /></div></td>
                <td width="95%" class="STYLE1"><span class="STYLE3">你当前的位置</span>：消费管理-消费记录</td>
              </tr>
            </table></td>
            <td width="54%"><table align="right" >
              <tr>
                <td width="60"><table width="87%" >
                  <tr>
                    <td class="STYLE1"><div align="center">
                      <input type="checkbox" name="checkbox11" id="choseAll" onclick="selectAllCheckBox()" />
                    </div></td>
                    <td class="STYLE4">全选</td>
                  </tr>
                </table></td>
                <td width="52"></td>
                <td width="60"><table width="90%">
                  <tr>
                    <td class="STYLE1"><div align="center"><img src="${pageContext.servletContext.contextPath }/images/22.gif" width="14" height="14" /></div></td>
                    <td class="STYLE1"><a href="${pageContext.servletContext.contextPath }/background/order/addUI.html">新增</a></td>
                  </tr>
                </table></td>
              </tr>
            </table></td>
          </tr>
        </table></td>
        <td width="16"><img src="${pageContext.servletContext.contextPath }/images/tab_07.gif" width="16" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
  <td align="center">
  <!-- 这里的表单 name 必须是fenye -->
  	<div class="search_k" align="left">
		<fieldset class="search">
			<legend><img src="${pageContext.servletContext.contextPath }/images/search_btn.gif" align="middle"/>&nbsp;<span class="STYLE1" style="color: blue;">高级查找</span></legend>
			<div class="search_content">
				<ul class="clearfix">
                    <li>顾客名称：<input type="text" name="customerName" value="${param.customerName}" style="height: 20px"/>　　</li>
                    <li>消费时间：<input type="text" name="orderDate" value="${param.orderDate}" style="height: 20px"/>　　</li>
                    <%--<li>消费产品类型：<input type="text" name="payType" value="${param.payType}" style="height: 20px"/>　　</li>--%>
                    <li>结算类型：<select name="payType" style="width:150px">
                        <option value="-1">所有类型</option>
                        <c:forEach items="${PayType}" var="et">
                            <option value="${et.val}"
                                    <c:if test="${param.payType == et.val}">selected</c:if>>${et.name}</option>
                        </c:forEach>
                    </select></li>
                    <li>服务人姓名：<input type="text" name="employeeName" value="${param.employeeName}" style="height: 20px"/>　　</li>
                    <li><input type="submit" value="开始查询" class="input_btn_style1"/>&nbsp;&nbsp;
                        <input type="button" value="重置" class="input_btn_style1" onclick="clearText()"/></li>
                </ul>
			</div>
		</fieldset>
	</div>
  </td>
  </tr>
  <tr>
    <td><table class="listtable" width="100%">
      <tr>
        <td width="8" background="${pageContext.servletContext.contextPath }/images/tab_12.gif">&nbsp;</td>
        <td><table class="ttab" width="100%" cellspacing="1" onmouseover="changeto()"  onmouseout="changeback()">
          <tr>
            <td width="3%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif" >
              <input id="chose" type="checkbox" name="checkbox" onclick="selectAllCheckBox()" />
            </td>
 			<td width="8%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">消费订单号</td>
 			<td width="10%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">消费名称</td>
 			<td width="10%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">顾客名称</td>
 			<td width="12%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">顾客卡号</td>
 			<td width="10%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">服务人姓名</td>
            <td width="8%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif" ><span class="STYLE1">消费金额</span></td>
            <td width="8%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif" ><span class="STYLE1">结算类型</span></td>
            <%--<td width="10%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">消费赠送积分分值</td>--%>
            <td width="8%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">本次服务折扣</td>
            <td width="14%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">订单日期</td>
            <td width="15%" height="22" background="${pageContext.servletContext.contextPath }/images/bg.gif"  class="STYLE1">操作</td>
          </tr>

          <c:forEach var="order" items="${pageView.records}">
          <tr>
            <td height="20" >
              <input type="checkbox" name="check" value="${order.id}" />
            </td>
            <td height="20" ><span class="STYLE1">${order.orderNo}</span></td>
            <td height="20" ><span class="STYLE1">
               ${order.productName}
            </span></td>
            <td height="20" ><span class="STYLE1">${order.customerName}</span></td>
            <td height="20" ><span class="STYLE1">${order.cardNo}</span></td>
            <td height="20"><span class="STYLE1">${order.employeeName}</span></td>
            <td height="20" ><span class="STYLE1">${order.payMoney}</span></td>
            <td height="20" >
                <span class="STYLE1"><c:forEach items="${PayType}" var="p"><c:if test="${p.val == order.payType}">${p.name}</c:if></c:forEach> </span></td>
            <td height="20" ><span class="STYLE1"><c:if test="${order.discount == 1 or order.discount == null}">无折扣</c:if></span></td>
            <td height="20" ><span class="STYLE1">${order.orderDate}</span></td>
            <td height="20" ><span class="STYLE4">
            <sec:authorize ifAnyGranted="ROLE_sys_res_show">
              <img src="${pageContext.servletContext.contextPath }/images/del.gif" width="16" height="16"/>
              <a href="${pageContext.servletContext.contextPath }/background/order/getById.html?orderId=${order.id}&&typeKey=0">
                显示详情</a>
              &nbsp;&nbsp;
            </sec:authorize>
            <%--sec:authorize ifAnyGranted="ROLE_sys_res_edit">
              <img src="${pageContext.servletContext.contextPath }/images/edt.gif" width="16" height="16"/>
              <a href="${pageContext.servletContext.contextPath }/background/order/getById.html?orderId=${order.id}&&typeKey=1">
                编辑
              </a>
              &nbsp; &nbsp;
            </sec:authorize>--%>
            </span></td>
          </tr>
          </c:forEach>
        </table></td>
        <td width="8" background="${pageContext.servletContext.contextPath }/images/tab_15.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="35" background="${pageContext.servletContext.contextPath }/images/tab_19.gif"><%@include file="../../common/webfenye.jsp" %>
    </td>
  </tr>
</table>
</form>
</body>
</html>