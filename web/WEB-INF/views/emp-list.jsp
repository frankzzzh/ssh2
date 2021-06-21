<%--
  Created by IntelliJ IDEA.
  User: Frank
  Date: 2021/6/11
  Time: 22:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="S" uri="/struts-tags" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".delete").click(function(){
                console.log("aaaa");
                const lastName = $(this).next(":hidden").val();
                const flag = confirm("Sure you wanna delete " + lastName + "?");
                if(flag){
                    const $tr = $(this).parent().parent();
                    const url = this.href;
                    const args = {"time": new Date()};
                    $.post(url,args,function(data){
                        if(data == "1"){
                            alert("Deleted");
                            <%--window.location.href="emp-delete?id=${id}";--%>
                            $tr.remove();
                        }else{
                            alert("Unsuccessful")
                        }
                    })
                }
                return false;
            })
        })


    </script>
</head>
<body>
<h4>Employee List Page</h4>
<s:if test="#request.employees == null || # request.employees.size() == 0">
    No employees info
</s:if>
<s:else>
    <table border="1" cellpadding="10" cellspacing="0">
        <tr>
            <td>ID</td>
            <td>LASTNAME</td>
            <td>EMAIL</td>
            <td>Birth</td>
            <td>CREATE_TIME</td>
            <td>DEPT</td>
            <td>DELETE</td>
            <td>Edit</td>

        </tr>
        <s:iterator value="#request.employees">
            <tr>
                <td>${id}</td>
                <td>${lastName}</td>
                <td>${email}</td>
                <td>
                    <s:date name="birth" format="yyyy-MM-dd"/>
                </td>
                <td>
                    <s:date name="createTime" format="yyyy-MM-dd hh:mm:ss"/>
                </td>
                <td>${department.department_name}</td>
                <td>
                    <a href="emp-delete?id=${id}" class="delete">delete</a>
                    <input type="hidden" value="${lastName}">
                </td>
                <td>
                    <a href="emp-input?id=${id}">Edit</a>
                    <input type="hidden" value="${lastName}">
                </td>
            </tr>
        </s:iterator>
    </table>
</s:else>
</body>
</html>
