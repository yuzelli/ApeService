<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html >
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
                  <a class="am-btn am-btn-danger" href="addJob.jsp" target="_blank">新增</a>
              </div>
              </div>
            </div>
            <form class="am-form-inline" role="form" action="SelSomeJobs" method="post">
              <div class="am-form-group">
                职位类别：<input type="text" class="am-form-field" id="jobtype" name="JobType" placeholder="职位类别">
              </div>

              <div class="am-form-group">
                薪资： <input type="text" class="am-form-field" id="jobsalary" name="JobCharge" placeholder=" 薪资">
              </div>
              <div class="am-form-group">
                所属城市：<input type="text" class="am-form-field" id="city" name="JobCity" placeholder="所属城市">
              </div>
              <div class="am-form-group">
                公司名：  <input type="text" class="am-form-field" id="companyname" name="CompanyId" placeholder="公司名">
              </div>
              <input type="submit" class="am-btn am-btn-primary" value="查询"></button>
            </form>

          <!-- Row end -->
          <!-- Row start -->
          <div class="am-g">
            <div class="am-u-sm-12">

              <table class="am-table am-table-striped am-table-hover table-main">
                <thead>
                <tr>
                  <th class="id">ID</th>
                  <th class="title">职位名称</th>
                  <th class="detail">职位详情</th>
                  <th class="type">职位类别</th>
                  <th class="salary">薪资</th>
                  <th class="city">所属城市</th>
                   <th class="companyname">公司名</th>
                  <th class="skill">所需技能</th>
                  <th class="dosome">操作</th>

                </tr>
                </thead>
                <tbody>
                  <c:forEach items="${ requestScope.list1}" var="job">
			<tr>
				<td>${job.jobId}</td>
				<td>${job.jobName}</td>
				<td>${job.jobDetail}</td>
				<td>${job.jobType}</td>
				<td>${job.jobCharge}</td>
				<td>${job.jobCity}</td>
				<td>${job.companyId}</td>
				<td>${job.jobTechnology}</td>
				                  <td>
                    <div class="am-btn-toolbar">
                      <div class="am-btn-group am-btn-group-xs">
                     <a href="DoLoadAction?ids=${job.jobId}">编辑</a> 
                     <a onclick="return confirm('您确定要删除？')" href="DelJobAction?ids=${job.jobId}">删除</a> 
                        
                      </div>
                    </div>
                  </td>
                  
			</tr>
		</c:forEach>
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
