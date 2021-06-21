<%--
  Created by IntelliJ IDEA.
  User: Frank
  Date: 2021/6/13
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="scripts/jquery-1.7.2.js"></script>
    <script type="text/javascript">
        $(function(){
            $(":input[name=lastName]").change(function(){
                var val = $(this).val();
                val = $.trim(val);
                var $this = $(this);
                if(val != ""){
                    $this.nextAll("font").remove();
                    var url = "emp-validateLastName";
                    var args = {"lastName":val,"time":new Date()};
                    $.post(url,args,function(data){
                        if(data == "1"){
                            $this.after("<font color='green'>&nbsp;&nbsp;LastName is available</font>")
                        }else if(data == "0"){
                            $this.after("<font color='red'>&nbsp;&nbsp;LastName is not available</font>")
                        }else{
                            alert("an error has occurred");
                        }
                    })
                }else{
                    alert("lastName cannot be null!");
                }
            })
        })
    </script>
</head>
<body>

<h4>Employee Input Page</h4>
<s:form action="emp-save" method="post">
    <s:if test="id != null">
        <s:textfield name="lastName" label="lastName" disabled="true"></s:textfield>
        <s:hidden name="id"></s:hidden>
<%--        Submit unsubmitted field by hidden label--%>
<%--        <s:hidden name="lastName"></s:hidden>--%>
<%--        <s:hidden name="createTime"></s:hidden>--%>
    </s:if>
    <s:else>
        <s:textfield name="lastName" label="LastName"></s:textfield>
    </s:else>
    <s:textfield name="email" label="Email"></s:textfield>
    <s:textfield name="birth" label="Birth"></s:textfield>
    <s:select list="#request.departments" listKey="id" listValue="department_name" name="department.id" label="Department"></s:select>
    <s:submit></s:submit>

</s:form>


</body>
</html>
