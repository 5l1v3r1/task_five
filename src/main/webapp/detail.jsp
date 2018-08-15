<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="/tags" prefix="date"%>
<html>
<head>
    <meta charset="utf-8">
    <title>无标题文档</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport" charset="UTF-8">
    <link rel="stylesheet" href="http://apps.bdimg.com/libs/bootstrap/3.3.4/css/bootstrap.min.css">
    <script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.4/js/bootstrap.min.js"></script>
    <link href="${pageContext.request.contextPath }/js&css/t11.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/js&css/base.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/js&css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../bootstrap-3.3.5-dist/css/bootstrap.css">
    <link href="${pageContext.request.contextPath }/js&css/Untitled-3.css" rel="stylesheet" type="text/css">
    <link href="${pageContext.request.contextPath }/js&css/Untitled-1base.css" rel="stylesheet" type="text/css">

</head>

<body>
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

<div class="container">

    <div class="nav-title">首页&gt;职业</div>
    <div class="nav-bar">
        <span class="">方向：</span>
        <a class="nav-bar-a a-selected" href="" style="color: black;">全部</a>
        <a class="nav-bar-a" href="" style="color: black;">前端开发</a>
        <a class="nav-bar-a" href="" style="color: black;">后端开发</a>
        <a class="nav-bar-a" href="" style="color: black;">移动开发</a>
        <a class="nav-bar-a" href="" style="color: black;">整站开发</a>
        <a class="nav-bar-a" href="" style="color: black;">运营维护</a>
    </div>

    <hr>
    <div style= "width:180px;height:20px;margin:0 auto;border:1px solid;">
        <date:date value="${date}"/>
    </div>
    <hr>

    <div class="caption">
        <h4>前端开发方向</h4>
    </div>

    <div class="row">
        <c:forEach items="${html}" var="h" varStatus="st">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="imges/${h.picture}"></div>
                        <div class="text">
                            <h4 class="">${h.name}</h4>
                            <p class="text-present">${h.introduce}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛 <img src="imges/${h.doorsill}"></div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度 <img src="imges/${h.doorsill}"><img src="imges/${h.doorsill}"></div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${h.growth}</span>年</div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${h.scarcity}</span>家公司需要</div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${h.studying}人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:${h.suggest}</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${h.name}</p>
                        <p class="flip-text">${h.specific}</p>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>

    <div class="caption">
        <h4>后端开发方向</h4>
    </div>

    <div class="row">
        <c:forEach items="${java}" var="j" varStatus="st">
        <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

            <div class="warp-border">
                <div class="clearfix">
                    <div class="icon-people"><img src="imges/${j.picture}"></div>
                    <div class="text">
                        <h4 class="">${j.name}</h4>
                        <p class="text-present">${j.introduce}</p>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">门槛 <img src="imges/${j.doorsill}"></div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">难易程度 <img src="imges/${j.doorsill}"><img src="imges/${j.doorsill}"></div>
                    </div>
                </div>
                <div class="warp-class2">
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${j.growth}</span>年</div>
                    </div>
                    <div class="warp-class2-text">
                        <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${j.scarcity}</span>家公司需要</div>
                    </div>
                </div>

                <div class="warp-class2">
                    <div class="leftWarp">
                        薪资待遇
                    </div>
                    <div class="rightWarp">
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                        <div class="rightWarp-class border-bottom">
                            <div class="rightWarp-year">0-1年</div>
                            <div class="rightWarp-wages">5k-10k/月</div>
                        </div>
                    </div>
                </div>

                <div class="warp-class2">
                    <b class="text-b">有${j.studying}人正在学</b>
                </div>
                <div class="warp-class2">
                    <p class="text-p">提示:${j.suggest}</p>
                </div>

                <div class="flip-container">
                    <p class="flip-title">${j.name}</p>
                    <p class="flip-text">${j.specific}</p>
                </div>
            </div>

        </div>
        </c:forEach>
    </div>

    <div class="caption">
        <h4>移动开发方向</h4>
    </div>

    <div class="row">
        <c:forEach items="${move}" var="m" varStatus="st">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="imges/${m.picture}"></div>
                        <div class="text">
                            <h4 class="">${m.name}</h4>
                            <p class="text-present">${m.introduce}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛 <img src="imges/${m.doorsill}"></div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度 <img src="imges/${m.doorsill}"><img src="imges/${m.doorsill}"></div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${m.growth}</span>年</div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${m.scarcity}</span>家公司需要</div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${m.studying}人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:${m.suggest}</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${m.name}</p>
                        <p class="flip-text">${m.specific}</p>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>

    <div class="caption">
        <h4>整站开发方向</h4>
    </div>

    <div class="row">
        <c:forEach items="${whole}" var="w" varStatus="st">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="imges/${w.picture}"></div>
                        <div class="text">
                            <h4 class="">${w.name}</h4>
                            <p class="text-present">${w.introduce}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛 <img src="imges/${w.doorsill}"></div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度 <img src="imges/${w.doorsill}"><img src="imges/${w.doorsill}"></div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${w.growth}</span>年</div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${w.scarcity}</span>家公司需要</div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${w.studying}人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:${w.suggest}</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${w.name}</p>
                        <p class="flip-text">${w.specific}</p>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>

    <div class="caption">
        <h4>运维开发方向</h4>
    </div>

    <div class="row">
        <c:forEach items="${run}" var="r" varStatus="st">
            <div class="col-md-4 col-sm-6 col-xs-12 top-margin">

                <div class="warp-border">
                    <div class="clearfix">
                        <div class="icon-people"><img src="imges/${r.picture}"></div>
                        <div class="text">
                            <h4 class="">${r.name}</h4>
                            <p class="text-present">${r.introduce}</p>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">门槛 <img src="imges/${r.doorsill}"></div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">难易程度 <img src="imges/${r.doorsill}"><img src="imges/${r.doorsill}"></div>
                        </div>
                    </div>
                    <div class="warp-class2">
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding">成长周期 <span class="iconfont-color">${r.growth}</span>年</div>
                        </div>
                        <div class="warp-class2-text">
                            <div class="iconfont text-padding text-border-left">稀缺程度 <span class="iconfont-color">${r.scarcity}</span>家公司需要</div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <div class="leftWarp">
                            薪资待遇
                        </div>
                        <div class="rightWarp">
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                            <div class="rightWarp-class">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                            <div class="rightWarp-class border-bottom">
                                <div class="rightWarp-year">0-1年</div>
                                <div class="rightWarp-wages">5k-10k/月</div>
                            </div>
                        </div>
                    </div>

                    <div class="warp-class2">
                        <b class="text-b">有${r.studying}人正在学</b>
                    </div>
                    <div class="warp-class2">
                        <p class="text-p">提示:${r.suggest}</p>
                    </div>

                    <div class="flip-container">
                        <p class="flip-title">${r.name}</p>
                        <p class="flip-text">${r.specific}</p>
                    </div>
                </div>

            </div>
        </c:forEach>
    </div>


</div>



<!--footer-->
<footer class="footer">
    <div class="container height">
        <div class="row">
            <div class="text-left col-sm-4">
                <span>技能树 &mdash; 改变你我</span>
                <p class="bottom">关于我们 | 联系我们 | 合作企业</p>
            </div>
            <div class="text-center col-sm-4">
                <p>旗下网站</p>
                <span>草船云孵化器     最强IT特训营</span>
                <span>葡萄藤轻游戏     桌游精灵</span>
            </div>
            <div class="text-right col-sm-4">
                <p>微信公众号</p>
                <img src="imges/2524.jpg">
            </div>
        </div>

    </div>

    <div class="footer-bottom">
        Copyright &copy; 2015技能树 www.jnshu.com  All Rights Reserved | 京ICP
    </div>
</footer>

</body>
</html>
