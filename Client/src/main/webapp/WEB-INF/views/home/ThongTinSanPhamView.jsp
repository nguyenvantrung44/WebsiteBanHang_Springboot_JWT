<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
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

<title>Thế giới xe điện</title>
<style>
.breadcrumb-item+.breadcrumb-item::before {
	content: ">"
}

.breadcrumb {
	display: -ms-flexbox;
	display: flex;
	-ms-flex-wrap: wrap;
	flex-wrap: wrap;
	padding: .1rem 0rem !important;
	margin-bottom: 0rem;
	list-style: none;
	background-color: #ffffff;
	border-radius: .25rem
}

.single_product {
	padding-top: 66px;
	padding-bottom: 140px;
	background-color: #e5e5e5;
	margin-top: 0px;
	padding: 17px
}

.product_name {
	font-size: 20px;
	font-weight: 400;
	margin-top: 0px
}

.badge {
	display: inline-block;
	padding: 0.50em .4em;
	font-size: 75%;
	font-weight: 700;
	line-height: 1;
	text-align: center;
	white-space: nowrap;
	vertical-align: baseline;
	border-radius: .25rem
}

.product-rating {
	margin-top: 10px
}

.rating-review {
	color: #5b5b5b
}

.product_price {
	display: inline-block;
	font-size: 30px;
	font-weight: 500;
	margin-top: 9px;
	clear: left
}

.product_discount {
	display: inline-block;
	font-size: 17px;
	font-weight: 300;
	margin-top: 9px;
	clear: left;
	margin-left: 10px;
	color: red
}

.product_saved {
	display: inline-block;
	font-size: 15px;
	font-weight: 200;
	color: #999999;
	clear: left
}

.singleline {
	margin-top: 1rem;
	margin-bottom: .40rem;
	border: 0;
	border-top: 1px solid rgba(0, 0, 0, .1)
}

.product_info {
	color: #4d4d4d;
	display: inline-block
}

.product_options {
	margin-bottom: 10px
}

.product_description {
	padding-left: 0px
}

.product_quantity {
	width: 104px;
	height: 47px;
	border: solid 1px #e5e5e5;
	border-radius: 3px;
	overflow: hidden;
	padding-left: 8px;
	padding-top: -4px;
	padding-bottom: 44px;
	float: left;
	margin-right: 22px;
	margin-bottom: 11px
}

.order_info {
	margin-top: 18px
}

.shop-button {
	height: 47px
}

.product_fav i {
	line-height: 44px;
	color: #cccccc
}

.product_fav {
	display: inline-block;
	width: 52px;
	height: 46px;
	background: #FFFFFF;
	box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.1);
	border-radius: 11%;
	text-align: center;
	cursor: pointer;
	margin-left: 3px;
	-webkit-transition: all 200ms ease;
	-moz-transition: all 200ms ease;
	-ms-transition: all 200ms ease;
	-o-transition: all 200ms ease;
	transition: all 200ms ease
}

.br-dashed {
	border-radius: 5px;
	border: 1px dashed #dddddd;
	margin-top: 6px
}

.pr-info {
	margin-top: 2px;
	padding-left: 2px;
	margin-left: -14px;
	padding-left: 0px
}

.break-all {
	color: #5e5e5e
}

.image_selected {
	display: -webkit-box;
	display: -moz-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	width: calc(100% + 15px);
	height: 525px;
	-webkit-transform: translateX(-15px);
	-moz-transform: translateX(-15px);
	-ms-transform: translateX(-15px);
	-o-transform: translateX(-15px);
	transform: translateX(-15px);
	border: solid 1px #e8e8e8;
	box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.1);
	overflow: hidden;
	padding: 15px
}

.image_list li {
	display: -webkit-box;
	display: -moz-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 165px;
	border: solid 1px #e8e8e8;
	box-shadow: 0px 0px 0px rgba(0, 0, 0, 0.1) !important;
	margin-bottom: 15px;
	cursor: pointer;
	padding: 15px;
	-webkit-transition: all 200ms ease;
	-moz-transition: all 200ms ease;
	-ms-transition: all 200ms ease;
	-o-transition: all 200ms ease;
	transition: all 200ms ease;
	overflow: hidden
}

@media ( max-width : 390px) {
	.product_fav {
		display: none
	}
}

.bbb_combo {
	width: 100%;
	margin-right: 7%;
	padding-top: 21px;
	padding-left: 20px;
	padding-right: 20px;
	padding-bottom: 24px;
	border-radius: 5px;
	margin-top: 0px;
	text-align: -webkit-center
}

.bbb_combo_image {
	width: 170px;
	height: 170px;
	margin-bottom: 15px
}

.fs-10 {
	font-size: 10px
}

.step {
	background: #167af6;
	border-radius: 0.8em;
	-moz-border-radius: 0.8em;
	-webkit-border-radius: 6.8em;
	color: #ffffff;
	display: inline-block;
	font-weight: bold;
	line-height: 3.6em;
	margin-right: 5px;
	text-align: center;
	width: 3.6em;
	margin-top: 116px
}

.row-underline {
	content: "";
	display: block;
	border-bottom: 2px solid #3798db;
	margin: 0px 0px;
	margin-bottom: 20px;
	margin-top: 15px
}

.deal-text {
	margin-left: -10px;
	font-size: 25px;
	margin-bottom: 10px;
	color: #000;
	font-weight: 700
}

.padding-0 {
	padding-left: 0;
	padding-right: 0
}

.padding-2 {
	margin-right: 2px;
	margin-left: 2px
}

.vertical-line {
	display: inline-block;
	border-left: 3px solid #167af6;
	margin: 0 10px;
	height: 364px;
	margin-top: 4px
}

.p-rating {
	color: green
}

.combo-pricing-item {
	display: flex;
	flex-direction: column
}

.boxo-pricing-items {
	display: inline-flex
}

.combo-plus {
	margin-left: 10px;
	margin-right: 18px;
	margin-top: 10px
}

.add-both-cart-button {
	margin-left: 36px
}

.items_text {
	color: #b0b0b0
}

.combo_item_price {
	font-size: 18px
}

.p_specification {
	font-weight: 500;
	margin-left: 22px
}

.mt-10 {
	margin-top: 10px
}

@charset "utf-8";

@import
	url('https://fonts.googleapis.com/css?family=Montserrat:300,400,500,600,700,800,900|Rubik:300,400,500,700,900')
	;

* {
	margin: 0;
	padding: 0;
	-webkit-font-smoothing: antialiased;
	-webkit-text-shadow: rgba(0, 0, 0, .01) 0 0 1px;
	text-shadow: rgba(0, 0, 0, .01) 0 0 1px
}

body {
	font-family: 'Rubik', sans-serif;
	font-size: 14px;
	font-weight: 400;
	background: #FFFFFF;
	color: #000000
}

div {
	display: block;
	position: relative;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box
}

ul {
	list-style: none;
	margin-bottom: 0px
}

.single_product {
	padding-top: 16px;
	padding-bottom: 140px
}

.image_list li {
	display: -webkit-box;
	display: -moz-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: 165px;
	border: solid 1px #e8e8e8;
	box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.1);
	margin-bottom: 15px;
	cursor: pointer;
	padding: 15px;
	-webkit-transition: all 200ms ease;
	-moz-transition: all 200ms ease;
	-ms-transition: all 200ms ease;
	-o-transition: all 200ms ease;
	transition: all 200ms ease;
	overflow: hidden
}

.image_list li:last-child {
	margin-bottom: 0
}

.image_list li:hover {
	box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.3)
}

.image_list li img {
	max-width: 100%
}

.image_selected {
	display: -webkit-box;
	display: -moz-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	width: calc(100% + 15px);
	height: 525px;
	-webkit-transform: translateX(-15px);
	-moz-transform: translateX(-15px);
	-ms-transform: translateX(-15px);
	-o-transform: translateX(-15px);
	transform: translateX(-15px);
	border: solid 1px #e8e8e8;
	box-shadow: 0px 1px 5px rgba(0, 0, 0, 0.1);
	overflow: hidden;
	padding: 15px
}

.image_selected img {
	max-width: 100%
}

.product_category {
	font-size: 12px;
	color: rgba(0, 0, 0, 0.5)
}

.product_rating {
	margin-top: 7px
}

.product_rating i {
	margin-right: 4px
}

.product_rating i::before {
	font-size: 13px
}

.product_text {
	margin-top: 27px
}

.product_text p:last-child {
	margin-bottom: 0px
}

.order_info {
	margin-top: 16px
}

.product_quantity {
	width: 182px;
	height: 50px;
	border: solid 1px #e5e5e5;
	border-radius: 5px;
	overflow: hidden;
	padding-left: 25px;
	float: left;
	margin-right: 30px
}

.product_quantity span {
	display: block;
	height: 50px;
	font-size: 16px;
	font-weight: 300;
	line-height: 50px;
	float: left
}

.product_quantity input {
	display: block;
	width: 83px;
	height: 50px;
	border: none;
	outline: none;
	font-size: 23px;
	font-weight: 300;
	text-align: left;
	padding-left: 9px;
	line-height: 50px;
	float: left;
}

.quantity_buttons {
	position: absolute;
	top: 0;
	right: 0;
	height: 100%;
	width: 29px;
	border-left: solid 1px #e5e5e5
}

.quantity_inc, .quantity_dec {
	display: -webkit-box;
	display: -moz-box;
	display: -ms-flexbox;
	display: -webkit-flex;
	display: flex;
	flex-direction: column;
	align-items: center;
	width: 100%;
	height: 50%;
	cursor: pointer
}

.quantity_control i {
	font-size: 11px;
	color: rgba(0, 0, 0, 0.3);
	pointer-events: none
}

.quantity_control:active {
	border: solid 1px rgba(14, 140, 228, 0.2)
}

.quantity_inc {
	padding-bottom: 2px;
	justify-content: flex-end;
	border-top-right-radius: 5px
}

.quantity_dec {
	padding-top: 2px;
	justify-content: flex-start;
	border-bottom-right-radius: 5px
}
</style>
</head>

<html>
<body>
	<input type="hidden" value="${tk.tenTaiKhoan }" name="tenTaiKhoan">
	<c:set var="tentk" value="${tk.tenTaiKhoan }" scope="session"></c:set>
	<div class="container-fluid">
		<!-- _header.jsp  -->
		<div>
			<jsp:include page="../include/_header.jsp"></jsp:include>
		</div>
	</div>
	<div class="header_nav_main section">
		<div class="container">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12">
					<div>
						<jsp:include page="../include/menu2.jsp"></jsp:include>
					</div>
				</div>
			</div>
			<div id="menu-overlay" class=""></div>
			<section class="bread-crumb">
				<span class="crumb-border"></span>
				<div class="container ">
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<ul class="breadcrumb">
								<h1>Chi Tiết Sản Phẩm</h1>
							</ul>
						</div>
					</div>
				</div>
				<!---->
				<div class="super_container">

					<div class="single_product">
						<div class="container-fluid "
							style="background-color: #fff; padding: 11px;">
							<div class="row ">

								<div class="col-lg-4 order-lg-2 order-1">
									<div class="image_selected">
										<img src="${product.urlImage}" alt="">
									</div>
								</div>
								<div class="col-lg-6 order-3">
									<div class="product_description">

										<div class="product_name">${product.description}</div>
										<div class="product-rating">
											<span class="badge badge-success"><i
												class="fa fa-star"></i> 4.5 Sao</span> <span class="rating-review">
												1 Đã Bán</span>
										</div>
										<div>
											<h4>Còn ${product.quantily} Sản Phẩm</h4>
											<c:if test="${product.quantily==0}">
												<span style="color: red; font-size: 30px;">Hết Hàng</span>
											</c:if>
											<br /> <span class="product_price"> <fmt:setLocale
													value="vi-VN" /> <fmt:formatNumber value="${product.price}"
													type="currency" />
											</span>
										</div>

										<hr class="singleline">
										<div>
											<span class="product_info">Miễn Phí Vận Chuyển Khi
												Giao Hàng</span><br> <span class="product_info">Có hàng
												trong khoảng từ 2-3 ngày</span>
										</div>
										<hr class="singleline">
										<div class="order_info d-flex flex-row"></div>
										<form action="/home/addToCart" method="POST">
											<div class="row">
												<div class="col-xs-6" style="margin-left: 13px;">
													<div class="product_quantity">
														<span>Số lượng: </span> <input id="quantity_input"
															name="quantily" type="number" pattern="[0-9]*" min="1"
															max="5" value="1">
													</div>
													
												</div>
												<input type="hidden" name="id"
													value="${product.id}"> <input type="hidden"
													name="name" value="${product.name}"> <input
													type="hidden" name="urlImage" value="${product.urlImage}">
												<input type="hidden" name="price" value="${product.price}">
												<input type="hidden" name="action" value="add">
												<div class="col-xs-6">
													<c:if test="${product.quantily==0}">
														<input type="button" class="btn btn-danger shop-button"
															onclick="thongbao()" value="Thêm vào giỏ hàng">
													</c:if>
													<c:if test="${product.quantily>0}">
														<input type="submit" class="btn btn-primary shop-button"
															value="Thêm vào giỏ hàng">
													</c:if>
												</div>
												<script>
													function thongbao() {
														confirm("Sản phẩm tạm hết hàng!!!");
													}
												</script>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>

					</div>
				</div>
				<!---->

			</section>
			<div>
				<jsp:include page="../include/_footer.jsp"></jsp:include>
			</div>
		</div>
	</div>
	</div>
	</div>
</body>

</html>