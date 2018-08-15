<%@ page language="java" pageEncoding="UTF-8"%>
<div class="container  hidden-xs">
    <div class="row header-top">
        <p class="col-xs-12 col-sm-6 col-md-6 col-lg-6">客服电话:010-594-78634</p>
        <div class="col-xs-12 col-sm-6 col-md-6 col-lg-6 text-right">
            <div>
                <a href="#" target="_blank"> <img alt=""  src="${pageContext.request.contextPath }/imges/54537.png"></a>
                <a href="#" target="_blank"><img alt=""  src="${pageContext.request.contextPath }/imges/45678678.png"></a>
                <a href="#" target="_blank"> <img alt=""  src="${pageContext.request.contextPath }/imges/54375483543.png"></a>
            </div>
        </div>
    </div>
</div>

<nav class="navbar navbar-default">
    <div class="container">
        <div class="navbar-header">
            <a href="#" class="navbar-brand">
                <img src="${pageContext.request.contextPath }/imges/logo.png" alt="Brand" class="img-responsive">
            </a>
            <button data-target="#open-nav" data-toggle="collapse" class="navbar-toggle btn-primary collapsed" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <div id="open-nav" class="navbar-collapse collapse" aria-expanded="false" style="height: 1px;">
            <ul class="nav navbar-nav navbar-right text-center list-inline">
                <li><a href="${pageContext.request.contextPath}/index">首页</a></li>
                <li style="border-bottom: 4px solid #ffffff;"><a href="${pageContext.request.contextPath}/detail">职业</a></li>
                <li><a href="">推荐</a></li>
                <li><a href="${pageContext.request.contextPath}/upload">关于</a></li>
                <li><a href="${pageContext.request.contextPath}/login">登陆</a></li>
                <li><a href="${pageContext.request.contextPath}/register">注册</a></li>
                <li ><a href="#" style="color: red;font-size: 30px;">${welcome}</a></li>
            </ul>
        </div>

    </div>
</nav>