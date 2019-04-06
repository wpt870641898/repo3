<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: wang
  Date: 2019/3/16
  Time: 11:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="/easyui/themes/bootstrap/easyui.css">
    <link rel="stylesheet" type="text/css" href="/easyui/themes/icon.css">
    <script type="text/javascript" src="/easyui/jquery.min.js"></script>
    <script type="text/javascript" src="/easyui/jquery.easyui.min.js"></script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',title:'North Title',split:true" style="height:100px;">
        <shiro:user>
            欢迎用户:<shiro:principal/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
        </shiro:user>
        <a href="/logout.html">退出</a>
    </div>
    <div data-options="region:'west',iconCls:'icon-reload',title:'菜单',split:true" style="width:10%;">
        <ul class="easyui-tree" id="leftMenu">
            <li>
                <span>系统管理</span>
                <ul>
                    <li ><span>用户管理</span></li>
                    <shiro:hasRole name="admin">
                        <li data-options="url:'/menu/go_edit.html'"><span>权限管理</span></li>
                    </shiro:hasRole>
                    <li data-options="url:'/menu/go_edit.html'"><span>角色管理</span></li>
                </ul>
            </li>
        </ul>

    </div>
    <div data-options="region:'center',title:'首页'" style="padding:5px;background:#eee;">
        <div id="tt" class="easyui-tabs" data-options="fit:true">
            <div title="欢迎页" style="padding: 20px;display: none;">
                欢迎
            </div>
        </div>h're
    </div>
    <script type="text/javascript">
            $("#leftMenu").tree({
                onClick:function(node){
                    if($("#leftMenu").tree("isLeaf",node.target)){
                        var tab = $("#tt").tabs("getTab",node.text);
                        if(tab){
                            $("#tt").tabs("select",node.text);
                        }else{
                            $("#tt").tabs('add',{
                                title:node.text,
                                closable:true,
                                href:node.url
                            })
                        }
                    }
                }
            })

    </script>
</body>
</html>
