<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="<c:url value="/resources/css/fontawesome-free-5.13.0-web/css/all.css"/>"
	rel='stylesheet' type='text/css' />
<link href="<c:url value="/resources/css/bootstrap.min.css"/>"
	rel='stylesheet' type='text/css' />
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel='stylesheet' type='text/css' />
<script src="<c:url value="/resources/js/jquery-3.3.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
<link href="<c:url value="/resources/css/css.css"/>" rel='stylesheet'
	type='text/css' />
<title>Đăng kí tài khoản</title>
</head>

<body>
	<!-- _header.jsp  -->
	<div>
		<jsp:include page="../include/_header.jsp"></jsp:include>
	</div>
	<div class="header_nav_main section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<div class="heade_menunav">
						<div class="wrap_main d-none d-lg-block d-xl-block">
							<div>
								<jsp:include page="../include/menu2.jsp"></jsp:include>
							</div>
						</div>
						<div id="menu-overlay" class=""></div>
						<section class="bread-crumb">
							<span class="crumb-border"></span>
							<div class="container ">
								<div class="row">
									<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
										<ul class="breadcrumb">
											<li class="home"><a href="/nhom3/home/trangchu"><span>Trang
														chủ</span></a> <span class="mr_lr">&nbsp;<i
													class="fas fa-chervon-right"></i>&nbsp;
											</span></li>

											<li><strong><span>Đăng ký tài khoản
														thành công</span></strong></li>

										</ul>
									</div>
								</div>
							</div>
						</section>
						<div class="container margin-bottom-20">
							<div
								class="wrap_background_aside padding-top-15 margin-bottom-40 text-center">
								<h1 class="title_base_cus text-center">ACTIVE ACCOUNT
									SUCCESSFULLY !!!</h1>
								<a class="btn btn-primary" href="/auth/login">LOGIN NOW</a>
								<a class="btn btn-danger" href="/home/trangchu">NOT NOW</a>
							</div>
						</div>

					</div>

				</div>
			</div>
		</div>
	</div>




</body>
</html>
