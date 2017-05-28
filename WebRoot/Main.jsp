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
    	
  
   <div style="margin-left: 200px;margin-right: 200px;padding-top: 100px">
      <div style="width: 300px;float: left;height: 100px">
       <a href="index.jsp">全部职位</a>
      </div>
	 <div style="width: 300px;float: left;height: 100px">
	   <a href="techSearch.jsp">全部文章</a>
	 </div>
    
    <div  style="width: 300px;float: left;height: 100px">
     <a href="compAllSearch.jsp">全部公司</a>
    </div >
    <div  style="width: 300px;float: left;height: 100px" >
    <a href="userAllSearch.jsp">全部用户</a>
    </div>
     <div  style="width: 300px;float: left;height: 100px">
       <a href="searchAllArtiColl.jsp">文章收藏</a>
     </div>
      <div  style="width: 300px;float: left;height: 100px">
      <a href="searchAllJobColl.jsp">职位收藏</a>
      </div>
    <div  style="width: 300px;float: left;height: 100px">
      <a href="searchAllCompResu.jsp">公司职位发布</a>
    </div>
      
    <div style="width: 300px;float: left;height: 100px">
    <a href="searchAllCompPictu.jsp">公司图片</a>
    </div>
   </div>
 		  
  </body>
</html>
