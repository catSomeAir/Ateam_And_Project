<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!doctype html>
<html lang="ko">
<head>
<style>
body, html {
	width: 100%;
	height: 150%;
}

body {
	background: #F1F1F1;
}

@font-face {
	font-family: Roboto;
	src:
		url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/565097/Roboto-Regular.woff2")
		format("woff2"),
		url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/565097/Roboto-Regular.woff")
		format("woff"),
		url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/565097/Roboto-Regular.ttf")
		format("ttf");
	font-weight: 400;
	font-style: normal;
}

html, body, div, span, applet, object, iframe, title, h1, h2, h3, h4, h5,
	h6, p {
	margin: 0;
	padding: 0;
	border: 0;
	font-size: 100%;
	font: inherit;
	vertical-align: baseline;
	font-family: "Roboto";
}
/* The Collapsing Parallax */
.collapsing-parallax {
	position: fixed;
	height: 350px;
	width: 100%;
	background:
		url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/565097/background.png")
		center center no-repeat;
	background-color: rgb(33, 14, 61);
	background-size: cover;
	z-index: 99;
}

.toolbar-collapsing-parallax {
	height: 100%;
	width: 100%;
}
/* Collapsing Title */
.title-collapsing-parallax {
	position: absolute;
	display: table;
	height: 8vh;
	width: 50%;
	bottom: 0;
	left: 0;
	margin: 0 2em;
}

.title-collapsing-parallax .avatar {
	position: relative;
	display: table-cell;
	float: left;
	width: 52px;
	height: 52px;
	background:
		url("https://s3-us-west-2.amazonaws.com/s.cdpn.io/565097/profile.jpeg")
		center center no-repeat;
	background-size: cover;
	border-radius: 50%;
	margin-right: 0.9em;
}

.title-container {
	position: relative;
	display: table-cell;
	float: left;
}

title {
	display: block;
	height: auto;
	width: auto;
	color: white;
	-webkit-transform-origin: bottom left;
	transform-origin: bottom left;
	-webkit-transition: all .3s cubic-bezier(0.4, 0, 0.2, 1);
	transition: all .3s cubic-bezier(0.4, 0, 0.2, 1);
	-webkit-transition-property: color, bottom, transform;
	transition-property: color, bottom, transform;
}

title.main {
	font-size: 1.5em
}

title.secondary {
	font-size: 0.9em
}

.fab {
	position: absolute;
	bottom: -1.5em;
	right: 5vw;
}
/* The Fab */
.fab-button {
	display: table;
	cursor: pointer;
	background: #00cc99;
	border-radius: 50%;
	color: #fff;
	box-shadow: 0px 2px 5px 0px rgba(0, 0, 0, 0.16), 0px 2px 10px 0px
		rgba(0, 0, 0, 0.12);
}

.fab-button:hover {
	box-shadow: 0px 5px 11px 0px rgba(0, 0, 0, 0.18), 0px 4px 15px 0px
		rgba(0, 0, 0, 0.15);
}

.fab-button i {
	width: 10px;
	display: table-cell;
	left: 0;
	right: 0;
	vertical-align: middle;
	margin: 0 auto;
	transform: translateX(30%);
}

.fixed-button {
	position: fixed;
	top: 70%;
	right: 45%;
}

.fab-button.xSmall {
	width: 1.75rem;
	height: 1.75rem;
	font-size: 0.75rem;
}

.fab-button.small {
	width: 2.45rem;
	height: 2.45rem;
	font-size: 1.2rem;
}

.fab-button.medium {
	width: 2.85rem;
	height: 2.85rem;
	font-size: 1.2rem;
}

.fab-button.large {
	width: 3.45rem;
	height: 3.45rem;
	font-size: 1.6rem;
}

.fab-button.xLarge {
	width: 3.75rem;
	height: 3.75rem;
	font-size: 1.8rem;
}
/* Navigation Button w/ Animation */
.menu-trigger {
	cursor: pointer;
	position: absolute;
	top: 25px;
	left: 30px;
	width: 26px;
	height: 20px;
	-webkit-transition: 0.35s ease all;
	-moz-transition: 0.35s ease all;
	-o-transition: 0.35s ease all;
	transition: 0.35s ease all;
}

.menu-trigger>.bar {
	position: absolute;
	left: 0;
	right: 0;
	width: 100%;
	height: 2.3px;
	background-color: white;
	-webkit-transition: 0.36s ease-out all;
	-moz-transition: 0.36s ease-out all;
	-o-transition: 0.36s ease-out all;
	transition: 0.36s ease-out all;
}

.menu-trigger>.bar:first-child {
	top: 0;
}

.menu-trigger>.bar:nth-child(2) {
	top: 8px;
}

.menu-trigger>.bar:nth-child(3) {
	top: 16px;
}

.menu-trigger.active {
	transform: rotate(180deg);
}

.menu-trigger.active>.bar:first-child {
	transform-origin: 60% bottom;
	transform: rotate(40deg) scaleX(0.7) translateX(8px);
}

.menu-trigger.active>.bar:nth-child(3) {
	transform-origin: 60% top;
	transform: rotate(-40deg) scaleX(0.7) translateX(8px);
}

/* body content */
header.collapsing-parallax+.site-main {
	padding-top: 428px;
}

.site-main .inner {
	text-align: center;
}

.row {
	
}

.row::after, .row::before {
	content: '';
	display: block;
	clear: both;
	height: 0;
}

.cardview {
	display: inline-block;
	text-align: left;
	position: relative;
	width: 19%;
	max-height: 350px;
	margin: 0 15px 20px 15px;
	box-shadow: 0px 5px 10px 0px rgba(0, 0, 0, 0.18), 0px 4px 14px 0px
		rgba(0, 0, 0, 0.15);
}

.cardview img {
	display: block;
	position: relative;
	background-position: center center;
	background-size: cover;
	height: 400px;
	width: 100%;
	top: 0;
}

.cardview .content {
	position: relative;
	padding: 15px 20px;
}

.cardview h1 {
	font-size: 19px;
	font-weight: 500;
	margin: 0 0 12px 0;
}

.cardview p {
	font-size: 14px;
	margin: 0 15px 15px 0;
}

.cardview a {
	font-size: 14px;
	position: relative;
	text-decoration: none;
	color: #9e9ea2;
	text-transform: uppercase;
	padding: 10px 6px;
	-webkit-transition: 0.3s ease-in-out background;
	-moz-transition: 0.3s ease-in-out background;
	-o-transition: 0.3s ease-in-out background;
	transition: 0.3s ease-in-out background;
}

.cardview a:hover {
	background: rgba(0, 0, 0, 0.04);
	border-radius: 6px;
}

@media screen and (max-width: 830px) {
	.cardview {
		width: 44%;
	}
}

@media screen and (max-width: 590px) {
	.cardview {
		width: 80%;
	}
	@media screen and (max-width: 530px) {
		.cardview {
			width: 85%;
			margin: 15px auto;
		}
	}
}
</style>
</head>
<div class="title wow">
	<p>
		<span style="font-size: 30px; color: #000; font-weight: 500; margin-bottom: 100px;">내가 찜한 설명서</span>
	</p>
	<br />
</div>
<body>
	<main id="#content" class="site-main" role="main">
		<section class="inner">
			<div class="row">
				<div class="cardview">
					<img
						style="background-image: url(https://images.unsplash.com/photo-1509395062183-67c5ad6faff9?ixlib=rb-0.3.5&amp;q=85&amp;fm=jpg&amp;crop=entropy&amp;cs=srgb&amp;ixid=eyJhcHBfaWQiOjE0NTg5fQ&amp;s=c1bf7fae077ff9688f62d7a89487a343)" />
					<section class="content">
						<h1>이디야커피</h1>
						<p>모델코드</p>
					</section>
				</div>
				<div class="cardview">
					<img
						style="background-image: url(https://images.unsplash.com/photo-1488998427799-e3362cec87c3?ixlib=rb-0.3.5&amp;q=85&amp;fm=jpg&amp;crop=entropy&amp;cs=srgb&amp;ixid=eyJhcHBfaWQiOjE0NTg5fQ&amp;s=9f23ab4452326630cf9e4c878b929770)" />
					<section class="content">
						<h1>이디야커피</h1>
						<p>모델코드</p>
					</section>
				</div>
			</div>
			<div class="row">
				<div class="cardview">
					<img
						style="background-image: url(https://images.unsplash.com/photo-1513908957990-b2790723edbf?ixlib=rb-0.3.5&amp;q=85&amp;fm=jpg&amp;crop=entropy&amp;cs=srgb&amp;ixid=eyJhcHBfaWQiOjE0NTg5fQ&amp;s=55587f8407d25c2525015fe2df8a653f)" />
					<section class="content">
						<h1>이디야커피</h1>
						<p>모델코드</p>
					</section>
				</div>
				<div class="cardview">
					<img
						style="background-image: url(https://images.unsplash.com/photo-1488998427799-e3362cec87c3?ixlib=rb-0.3.5&amp;q=85&amp;fm=jpg&amp;crop=entropy&amp;cs=srgb&amp;ixid=eyJhcHBfaWQiOjE0NTg5fQ&amp;s=9f23ab4452326630cf9e4c878b929770)" />
					<section class="content">
						<h1>이디야커피</h1>
						<p>모델코드</p>
					</section>
				</div>
			</div>
			<div class="row">
				<div class="cardview">
					<img
						style="background-image: url(https://images.unsplash.com/photo-1488998427799-e3362cec87c3?ixlib=rb-0.3.5&amp;q=85&amp;fm=jpg&amp;crop=entropy&amp;cs=srgb&amp;ixid=eyJhcHBfaWQiOjE0NTg5fQ&amp;s=9f23ab4452326630cf9e4c878b929770)" />
					<section class="content">
						<h1>이디야커피</h1>
						<p>모델코드</p>
					</section>
				</div>
				<div class="cardview">
					<img
						style="background-image: url(https://images.unsplash.com/photo-1488998427799-e3362cec87c3?ixlib=rb-0.3.5&amp;q=85&amp;fm=jpg&amp;crop=entropy&amp;cs=srgb&amp;ixid=eyJhcHBfaWQiOjE0NTg5fQ&amp;s=9f23ab4452326630cf9e4c878b929770)" />
					<section class="content">
						<h1>이디야커피</h1>
						<p>모델코드</p>
					</section>
				</div>
			</div>
		</section>

	</main>
	<script type="text/javascript">
		/* by Ryan Tarson Twitter @rtarson 
		I'm going to look into dynamically
		change the algorithm based on height of $pMain
		but for now enjoy that liquid smooth parralax*/
		(function($) {
			var $pMain = $("#parallax_main"), $pToolbar = $pMain
					.find("#toolbar_main"), $pTitle = $pToolbar
					.find("#title_main"), $pNavTrigger = $pMain
					.find("#nav-button"), alpha = 0, scale = 1;
			$(window).scroll(function() {
				var st = $(window).scrollTop();
				if (st <= 0) {
					maxHeight = 350;
				} else if (st > 350) {
					alpha = 1;
					maxHeight = 70;
				} else {
					alpha = 0.0 + 1.2 * st / 350;
					scale = 1 - 0.20 * st / 350;
					maxHeight = 350 - 280 * ((st - 0)) / 350;
					console.log(maxHeight);
				}
				$pToolbar.css("background", "rgba(33,14,61," + alpha + ")");
				$pMain.css({
					'max-height' : maxHeight + "px"
				});
				$pTitle.css('transform', 'scale(' + scale + ')');
			});
			$pNavTrigger.click(function() {
				$(this).toggleClass('active');
			});
		})(jQuery);
	</script>
</body>
</html>