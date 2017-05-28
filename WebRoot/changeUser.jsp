<%@page import="bean.UserInfo"%>
<%@page import="bizimpl.UserInfoBizImpl"%>
<%@page import="biz.UserInfoBiz"%>
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
    int userid=Integer.parseInt(request.getParameter("userId"));
    UserInfoBiz biz = new UserInfoBizImpl();
    UserInfo userInfo = biz.findUserInfoByID(userid);
    
    
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
              <form class="am-form am-form-horizontal" action="updateUser" method="post">
                 <input type="hidden" name="userId" value="<%=userid%>">
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">用户电话</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="UserPhoneNum" name="UserPhoneNum" value="<%= userInfo.getUserPhoneNum() %>">
                  </div>
                </div>
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">用户密码</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="UserPassword" name="UserPassword" value="<%=userInfo.getUserPassword()%>" >

                  </div>
                </div>
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">用户头像</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="UserHeadImg" name="UserHeadImg" value="<%= userInfo.getUserHeadImg()%>" >

                  </div>
                </div>
                  <div class="am-form-group">
                    <label  class="am-u-sm-3 am-form-label">用户姓名</label>
                    <div class="am-u-sm-9">
                      <input type="text" id="UserTrueName" name="UserTrueName" value="<%= userInfo.getUserTrueName()%>" >

                    </div>
                  </div>
                    <div class="am-form-group">
                      <label  class="am-u-sm-3 am-form-label">用户性别</label>
                      <div class="am-u-sm-9">
                        <input type="text" id="UserGender" name="UserGender" value="<%=userInfo.getUserGender()%>" >

                      </div>
                    </div>
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">用户年龄</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="UserAge" name="UserAge" value="<%=userInfo.getUserAdvantage() %>" >
                  </div>
                </div>
                 <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">学位</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="UserDegree" name="UserDegree" value="<%=userInfo.getUserDegree()%>" >
                  </div>
                </div>
                 <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">毕业学校</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="UserSchool" name="UserSchool" value="<%= userInfo.getUserSchool()%>" >
                  </div>
                </div>
                 <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">期望薪资</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="UserExpactMonney" name="UserExpactMonney" value="<%= userInfo.getUserExpactMonney()%>" >
                  </div>
                </div>
                 <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">工作经验</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="UserExperence" name="UserExperence" value="<%=userInfo.getUserExperence() %>" >
                  </div>
                </div>
                 <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">个人优势</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="UserAdvantage" name="UserAdvantage" value="<%=userInfo.getUserAdvantage()%>" >
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
