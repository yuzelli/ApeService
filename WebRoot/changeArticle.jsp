<%@page import="bean.Article"%>
<%@page import="bizimpl.ArticleBizImpl"%>
<%@page import="biz.ArticleBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>猿聘</title>
  <link rel="stylesheet" href="assets/css/amazeui.css" />
  <link rel="stylesheet" href="assets/css/common.min.css" />
  <link rel="stylesheet" href="assets/css/index.min.css" />
  </head>
  
  <body>
  <%
     	 request.setCharacterEncoding("utf-8");
         int articleId=Integer.parseInt(request.getParameter("articleId"));
         ArticleBiz biz = new ArticleBizImpl();
         Article article = biz.findArticleByID(articleId);
   %>
   <div class="layout">
    <!--===========layout-header================-->
    <div class="layout-header am-hide-sm-only">
    <div class="header-box" data-am-sticky>
        <!--header start-->
          <div class="container">
            <div class="header">
              <div class="am-g">
                <div class="am-u-lg-2 am-u-sm-12">
                  <div class="logo">
                    <a href=""><img src="assets/images/logo.png" alt="" /></a>
                  </div>
                </div>
                <div class="am-u-md-10">
				
                  <div class="header-right am-fr">
                    <div class="header-contact">


                      <div class="header_contacts--item">
  					
  												<span>最快捷的程序猿招聘平台</span>
  											
  										</div>
                    </div>
                   
                  </div>
                </div>
              </div>
            </div>
          </div>
        <!--header end-->
      </div>
    </div>
    <!-- Start here -->
    <div class="content-page">
      <!-- Start content -->
      <div class="content">
        <div class="card-box">
          <!-- Row start -->
          <div class="am-g tpl-amazeui-form">


            <div class="am-u-sm-12 am-u-md-9">
              <form class="am-form am-form-horizontal" action="updateArticle" method="post">
                 <input type="hidden" name="articleId" value="<%= articleId%>">
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">V2EXID</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="vexID" name="vexID" value="<%=article.getVexID()%>">
                  </div>
                </div>
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">标题</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="title" name="title" value="<%=article.getTitle()%>" >

                  </div>
                </div>
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">类型</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="type" name="type" value="<%=article.getType() %>" >

                  </div>
                </div>
                  <div class="am-form-group">
                    <label  class="am-u-sm-3 am-form-label">ImgUrl</label>
                    <div class="am-u-sm-9">
                      <input type="text" id="imgUrl" name="imgUrl" value="<%=article.getImgUrl() %>" >

                    </div>
                  </div>
                    <div class="am-form-group">
                      <label  class="am-u-sm-3 am-form-label">用户名</label>
                      <div class="am-u-sm-9">
                        <input type="text" id="userName" name="userName" value="<%=article.getUserName() %>" >

                      </div>
                    </div>
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">时间</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="createTime" name="createTime" value="<%=article.getCreateTime() %>" >
                  </div>
                </div>
                 <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">回复</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="replies" name="replies" value="<%=article.getReplies() %>" >
                  </div>
                </div>
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">内容</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="content" name="content" value="<%=article.getContent() %>" >
                  </div>
                </div>
                       
                        

                <div class="am-form-group">
                  <div class="am-u-sm-9 am-u-sm-push-3">
                    <input type="submit" class="am-btn am-btn-primary" value="确认修改"></button>
                    <a href=""><button type="button" class="am-btn am-btn-default am-radius" >返回</button></a>
                  </div>
                </div>
              </form>
            </div>
          </div>
          <!-- Row end -->

        </div>




      </div>


    </div>
  </div>
    
  
  <script src="assets/js/jquery-2.1.0.js" charset="utf-8"></script>
  <script src="assets/js/amazeui.js" charset="utf-8"></script>
  <script src="assets/js/common.js" charset="utf-8"></script>
  </body>
</html>
