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
          <div class="am-g tpl-amazeui-form">


            <div class="am-u-sm-12 am-u-md-9">
              <form class="am-form am-form-horizontal" action="addUserInfo" method="post">

         <!--        <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">ID</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="id" name="id" placeholder="输入id">
                  </div> 
                </div>-->
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">用户电话</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="UserPhoneNum" name="UserPhoneNum" placeholder="输入用户电话">

                  </div>
                </div>
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">用户密码</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="UserPassword" name="UserPassword" placeholder="请输入用户密码">

                  </div>
                </div>
                  <div class="am-form-group">
                    <label  class="am-u-sm-3 am-form-label">用户头像url</label>
                    <div class="am-u-sm-9">
                      <input type="text" id="UserHeadImg" name="UserHeadImg" placeholder="请输入头像url">

                    </div>
                  </div>
                    <div class="am-form-group">
                      <label  class="am-u-sm-3 am-form-label">用户姓名</label>
                      <div class="am-u-sm-9">
                        <input type="text" id="UserTrueName" name="UserTrueName" placeholder="请输入用户真实姓名">

                      </div>
                    </div>
                   <div class="am-form-group">
                        <label  class="am-u-sm-3 am-form-label">用户性别</label>
                        <div class="am-u-sm-9">
                          <input type="text" id="UserGender" name="UserGender" placeholder="请输入用户性别">
                          </div>
                        </div>
                      <div class="am-form-group">
                        <label  class="am-u-sm-3 am-form-label">用户年龄</label>
                        <div class="am-u-sm-9">
                          <input type="text" id="UserAge" name="UserAge" placeholder="请输入用户年龄">

                        </div>
                       
                      </div>
                      <div class="am-form-group">
                          <label  class="am-u-sm-3 am-form-label">学位</label>
                          <div class="am-u-sm-9">
                            <input type="text" id="UserDegree" name="UserDegree" placeholder="请输入用户学位">
                          </div>
                	</div>
                	  
                	  <div class="am-form-group">
                          <label  class="am-u-sm-3 am-form-label">毕业学校</label>
                          <div class="am-u-sm-9">
                            <input type="text" id="UserSchool" name="UserSchool" placeholder="请输入毕业学校">
                          </div>
                	</div>
                	  <div class="am-form-group">
                          <label  class="am-u-sm-3 am-form-label">期望薪资</label>
                          <div class="am-u-sm-9">
                            <input type="text" id="UserExpactMonney" name="UserExpactMonney" placeholder="请输入期望薪资">
                          </div>
                	</div>
                	<div class="am-form-group">
                          <label  class="am-u-sm-3 am-form-label">工作经验</label>
                          <div class="am-u-sm-9">
                            <input type="text" id="UserExperence" name="UserExperence" placeholder="请输入工作经验">
                          </div>
                	</div>
                	<div class="am-form-group">
                          <label  class="am-u-sm-3 am-form-label">个人优势</label>
                          <div class="am-u-sm-9">
                            <input type="text" id="UserAdvantage" name="UserAdvantage" placeholder="请输入个人优势">
                          </div>
                	</div>


                <div class="am-form-group">
                  <div class="am-u-sm-9 am-u-sm-push-3">
                    <input type="submit" class="am-btn am-btn-primary" value="确认增加"></button>
                    <a href=""><button type="button" class="am-btn am-btn-default am-radius">返回</button></a>
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
