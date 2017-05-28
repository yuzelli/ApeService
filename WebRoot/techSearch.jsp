<%@page import="bean.Article"%>
<%@page import="bizimpl.ArticleBizImpl"%>
<%@page import="biz.ArticleBiz"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  
  
  <body >
  
  <%
 	 ArticleBiz biz = new ArticleBizImpl();
 	 List<Article> list = new ArrayList<Article>();
     list=biz.findAtricles();       
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
          <div class="am-g">
            <div class="am-u-sm-12 am-u-md-1">
              <div class="am-btn-toolbar">
                <div class="am-btn-group am-btn-group-xs">
                  <a class="am-btn am-btn-danger" href="addTechArti.jsp" target="_blank">新增</a>
              </div>
              </div>
            </div>
            <form class="am-form-inline" role="form" action="SelSomeArticle" method="post">
              <div class="am-form-group">
                文章ID：<input type="text" class="am-form-field" id="articleId" name="articleId" placeholder="文章ID">
              </div>

               
               
              <input type="submit" class="am-btn am-btn-primary" value="查询"></button>
            </form>

          <!-- Row end -->
          <!-- Row start -->
          <div class="am-g">
            <div class="am-u-sm-12">

              <table class="am-table am-table-striped am-table-hover table-main">
                 <tr>
           			<th>文章ID</th>
            		<th>V2EXID</th>
            		<th>标题</th>
            		<th>类型</th>
            		<th>ImgUrl</th>
           			<th>用户名</th>
           			<th>时间</th>
           			<th>回复</th>
           			<th>内容</th>
           			
         		</tr>
         		 <%
         		 if(list!=null){
         		 
             for(int i=0;i<list.size();i++){ %>
             
                 <tr>
                    <td><%=list.get(i).getArticleId() %></td>
                    <td><%=list.get(i).getVexID() %></td>
                    <td><%=list.get(i).getTitle() %></td>
                    <td><%=list.get(i).getType() %></td>
                    <td><%=list.get(i).getImgUrl() %></td>
                    <td><%=list.get(i).getUserName() %></td>
                    <td><%=list.get(i).getCreateTime() %></td>
                    <td><%=list.get(i).getReplies() %></td>
                    <td><%=list.get(i).getContent()%></td>
                     
                    <td>  <a href="changeArticle.jsp?articleId=<%=list.get(i).getArticleId()%>">编辑</a> 
                     <a onclick="return confirm('您确定要删除？')" href="DelArticle?ArticleId=<%=list.get(i).getArticleId() %>">删除</a> 
                     </td>
                 </tr>
             
             
             <%}}
         
         
          %>
                
              
              </table>

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
