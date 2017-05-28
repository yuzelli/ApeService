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
   
      
       
          


           
 		  <form class="am-form am-form-horizontal" action="addCompResu" method="post">
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">用户ID</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="userId" name="userId" placeholder="请输入用户ID">

                  </div>
                </div>
                  <div class="am-form-group">
                    <label  class="am-u-sm-3 am-form-label">职位ID</label>
                    <div class="am-u-sm-9">
                      <input type="text" id="jobId" name="jobId" placeholder="文章ID">

                    </div>
                  </div>
                   <div class="am-form-group">
                    <label  class="am-u-sm-3 am-form-label">公司ID</label>
                    <div class="am-u-sm-9">
                      <input type="text" id="companyId" name="companyId" placeholder="文章ID">

                    </div>
                  </div>
                   
                <div class="am-form-group">
                  <div class="am-u-sm-9 am-u-sm-push-3">
                    <input type="submit" class="am-btn am-btn-primary" value="确认增加"></button>
                    <a href=""><button type="button" class="am-btn am-btn-default am-radius">返回</button></a>
                  </div>
                </div>
              </form>
  </body>
</html>
