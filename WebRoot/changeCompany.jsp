<%@page import="bean.Company"%>
<%@page import="bizimpl.CompanyBizImpl"%>
<%@page import="biz.CompanyBiz"%>
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
         int id=Integer.parseInt(request.getParameter("companyId"));
         CompanyBiz biz = new CompanyBizImpl();
         Company company = biz.findCompanyByID(id);
              
     
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
              <form class="am-form am-form-horizontal" action="updateCompany" method="post">
                 <input type="hidden" name="companyId" value="<%=company.getCompanyId()%>">
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">公司电话</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="CompanyNum" name="CompanyNum" value="<%=company.getCompanyNum()%>">
                  </div>
                </div>
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">公司密码</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="CompanyPassword" name="CompanyPassword" value="<%=company.getCompanyPassword()%>" >

                  </div>
                </div>
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">头像url</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="CompanyHeadImg" name="CompanyHeadImg" value="<%=company.getCompanyHeadImg()%>" >

                  </div>
                </div>
                  <div class="am-form-group">
                    <label  class="am-u-sm-3 am-form-label">公司名称</label>
                    <div class="am-u-sm-9">
                      <input type="text" id="CompanyName" name="CompanyName" value="<%=company.getCompanyName()%>" >

                    </div>
                  </div>
                    <div class="am-form-group">
                      <label  class="am-u-sm-3 am-form-label">公司地址</label>
                      <div class="am-u-sm-9">
                        <input type="text" id="CompanyAddress" name="CompanyAddress" value="<%=company.getCompanyAddress()%>" >

                      </div>
                    </div>
                <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">公司简介</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="CompanyIntroduce" name="CompanyIntroduce" value="<%=company.getCompanyIntroduce()%>" >
                  </div>
                </div>
                 <div class="am-form-group">
                  <label  class="am-u-sm-3 am-form-label">公司Scale</label>
                  <div class="am-u-sm-9">
                    <input type="text" id="CompanyScale" name="CompanyScale" value="<%=company.getCompanyScale()%>" >
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
