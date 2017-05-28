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
            <form class="am-form-inline" role="form" action="selSomeUser" method="post">
              <div class="am-form-group">
               用户ID：<input type="text" class="am-form-field" id="userId" name="userId" placeholder="用户ID">
              </div>
 
               
              <input type="submit" class="am-btn am-btn-primary" value="查询"></button>
            </form>

          <!-- Row end -->
          <!-- Row start -->
          <div class="am-g">
            <div class="am-u-sm-12">

              <table class="am-table am-table-striped am-table-hover table-main">
                 <tr>
           			<th>用户ID</th>
            		<th>手机号</th>
            		<th>密码</th>
            		<th>头像</th>
            		<th>姓名</th>
           			<th>性别</th>
           			<th>年龄</th>
           			<th>学位</th>
           			<th>学校</th>
           			<th>期望薪资</th>
           			<th>工作经验</th>
           			<th>优势</th>
           			 
         		</tr>
         		<tbody>
                  <tr>
                 
                   <td>${userInfo.userId }</td>
                   <td>${userInfo.userPhoneNum }</td>
                   <td>${userInfo.userPassword }</td>
                   <td>${userInfo.userHeadImg }</td>
                   <td>${userInfo.userTrueName }</td>
                   <td>${userInfo.userGender }</td>
                   <td>${userInfo.userAge }</td>
                   <td>${userInfo.userDegree }</td>
                   <td>${userInfo.userSchool }</td>
                   <td>${userInfo.userExpactMonney }</td>
                   <td>${userInfo.userExperence }</td>
                   <td>${userInfo.userAdvantage }</td>
                 
                                  
                     
                    <td>  <a href="changeUser.jsp?userId=${userInfo.userId }">编辑</a> 
                    <a onclick="return confirm('您确定要删除？')" href="delUserInfo?userId=${userInfo.userId }">删除</a> 
                    </td>
                </tr>
                </tbody>
                
              
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
