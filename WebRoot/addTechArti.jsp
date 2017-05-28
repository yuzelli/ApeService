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
   <form class="am-form am-form-horizontal" action="addAtricle" method="post">
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
  
   </div>
       
  
               
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">用户ID</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="VexID" name="VexID" placeholder="请输入用户ID">

                  </div>
                </div>
                  <div class="am-form-group">
                    <label  class="am-u-sm-3 am-form-label">文章标题</label>
                    <div class="am-u-sm-9">
                      <input type="text" id="Title" name="Title" placeholder="请输入文章标题">

                    </div>
                  </div>
                    <div class="am-form-group">
                      <label  class="am-u-sm-3 am-form-label">文章类型</label>
                      <div class="am-u-sm-9">
                        <input type="text" id="Type" name="Type" placeholder="请输入文章类型">

                      </div>
                    </div>
                   <div class="am-form-group">
                        <label  class="am-u-sm-3 am-form-label">图片地址</label>
                        <div class="am-u-sm-9">
                          <input type="text" id="ImgUrl" name="ImgUrl" placeholder="请输入图片地址">
                          </div>
                        </div>
                      <div class="am-form-group">
                        <label  class="am-u-sm-3 am-form-label">用户名</label>
                        <div class="am-u-sm-9">
                          <input type="text" id="UserName" name="UserName" placeholder="请输入用户名">

                        </div>
                      <div class="am-form-group">
                        <label  class="am-u-sm-3 am-form-label">发布时间</label>
                        <div class="am-u-sm-9">
                          <input type="text" id="CreateTime" name="CreateTime" placeholder="请输入发布时间">

                        </div>
                         <div class="am-form-group">
                        <label  class="am-u-sm-3 am-form-label">回复数量</label>
                        <div class="am-u-sm-9">
                          <input type="text" id="Replies" name="Replies" placeholder="请输入回复数量">

                        </div>
                      </div>
                        <div class="am-form-group">
                          <label  class="am-u-sm-3 am-form-label">文章内容</label>
                          <div class="am-u-sm-9">
                            <input type="text" id="Content" name="Content" placeholder="请输入文章内容">

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
