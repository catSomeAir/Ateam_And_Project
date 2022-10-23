<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.css">
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11.4.10/dist/sweetalert2.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>


<style type="text/css">
@
-moz-keyframes quick_cart_pay_show { 0% {
	-webkit-transform: rotate(70deg);
	-ms-transform: rotate(70deg);
	transform: rotate(70deg);
	right: -100px;
}

50
%
{
-webkit-transform
:
rotate(
-20deg
);
-ms-transform
:
rotate(
-20deg
);
transform
:
rotate(
-20deg
);
right
:
20px;
}
100
%
{
-webkit-transform
:
rotate(
0deg
);
-ms-transform
:
rotate(
0deg
);
transform
:
rotate(
0deg
);
right
:
0;
}
}
@
-webkit-keyframes quick_cart_pay_show { 0% {
	-webkit-transform: rotate(70deg);
	transform: rotate(70deg);
	right: -100px;
}

50
%
{
-webkit-transform
:
rotate(
-20deg
);
transform
:
rotate(
-20deg
);
right
:
20px;
}
100
%
{
-webkit-transform
:
rotate(
0deg
);
transform
:
rotate(
0deg
);
right
:
0;
}
}
@
keyframes quick_cart_pay_show { 0% {
	-webkit-transform: rotate(70deg);
	transform: rotate(70deg);
	right: -100px;
}

50
%
{
-webkit-transform
:
rotate(
-20deg
);
transform
:
rotate(
-20deg
);
right
:
20px;
}
100
%
{
-webkit-transform
:
rotate(
0deg
);
transform
:
rotate(
0deg
);
right
:
0;
}
}
@
-webkit-keyframes quick_cart_pay_hide { 0% {
	-webkit-transform: translateX(0);
	transform: translateX(0);
}

100
%
{
-webkit-transform
:
translateX(
200px
);
transform
:
translateX(
200px
);
}
}
@
keyframes quick_cart_pay_hide { 0% {
	-webkit-transform: translateX(0);
	transform: translateX(0);
}

100
%
{
-webkit-transform
:
translateX(
200px
);
transform
:
translateX(
200px
);
}
}
@
keyframes fadeDown { 0% {
	-webkit-transform: rotate(0deg) translateY(0px);
	transform: rotate(0deg) translateY(0px);
	opacity: 1;
}

100
%
{
-webkit-transform
:
rotate(
5deg
)
translateY(
5px
);
transform
:
rotate(
5deg
)
translateY(
5px
);
opacity
:
0;
}
}
@
-webkit-keyframes fadeDown { 0% {
	-webkit-transform: rotate(0deg) translateY(0px);
	transform: rotate(0deg) translateY(0px);
	opacity: 1;
}

100
%
{
-webkit-transform
:
rotate(
5deg
)
translateY(
5px
);
transform
:
rotate(
5deg
)
translateY(
5px
);
opacity
:
0;
}
}
@
keyframes fadeUp { 0% {
	-webkit-transform: rotate(5deg) translateY(5px);
	transform: rotate(5deg) translateY(5px);
	opacity: 0;
}

100
%
{
-webkit-transform
:
rotate(
0deg
)
translateY(
0px
);
transform
:
rotate(
0deg
)
translateY(
0px
);
opacity
:
1;
}
}
@
-webkit-keyframes fadeUp { 0% {
	-webkit-transform: rotate(5deg) translateY(5px);
	transform: rotate(5deg) translateY(5px);
	opacity: 0;
}

100
%
{
-webkit-transform
:
rotate(
0deg
)
translateY(
0px
);
transform
:
rotate(
0deg
)
translateY(
0px
);
opacity
:
1;
}
}
.fadeDown {
	opacity: 0;
	position: relative;
	-webkit-animation: fadeDown 400ms ease-in-out;
	animation: fadeDown 400ms ease-in-out;
}

.fadeUp {
	opacity: 1 !important;
	position: relative;
	-webkit-animation: fadeUp 400ms ease-in-out;
	animation: fadeUp 400ms ease-in-out;
}

.animateOut {
	position: absolute !important;
	top: 0;
	left: 0;
	-webkit-animation: quick_cart_pay_hide 200ms ease-in forwards;
	animation: quick_cart_pay_hide 200ms ease-in forwards;
}

.quick-cart-product .hide {
	opacity: 0;
}

#quick-cart {
	bottom: 20px;
	padding-bottom: 60px;
	position: fixed;
	right: 10px;
	top: auto !important;
	z-index: 1000;
}

#quick-cart-pay {
	font-size: 100%;
	line-height: 123.07692%;
	font-family: "robotobold", sans-serif;
	border-radius: 50%;
	-webkit-transform: rotate(70deg);
	-ms-transform: rotate(70deg);
	transform: rotate(70deg);
	border: 2px solid #020E20;
	bottom: 0;
	cursor: pointer;
	display: block;
	position: absolute;
	text-decoration: none;
	right: -100px;
}

#quick-cart-pay>span {
	border-radius: 50%;
	transition: all 0.3s ease-in-out;
	background-color: #020E20;
	border: 2px solid #fff;
	color: #fff;
	display: block;
	height: 56px;
	padding-top: 15px;
	position: relative;
	text-align: center;
	text-transform: uppercase;
	width: 56px;
}

#quick-cart-pay.open {
	-webkit-animation: quick_cart_pay_show 1s ease-in-out forwards;
	animation: quick_cart_pay_show 1s ease-in-out forwards;
}

#quick-cart-pay.cart-ico strong {
	display: none;
}

#quick-cart-pay.cart-ico>span {
	background: #020E20
		url("data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE5cHgiIGhlaWdodD0iMThweCIgdmlld0JveD0iMCAwIDE5IDE4IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC02ODYuMDAwMDAwLCAtNDUwLjAwMDAwMCkiIGZpbGw9IiNGRkZGRkYiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg2NjAuMDAwMDAwLCAxNjUuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgwLjAwMDAwMCwgMjY5LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDI2LjAwMDAwMCwgMTYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xNi43NjU0Nzg0LDQuMjc1IEwxNS44NzU4NzQ5LDguNTkzMzYwNzEgTDQuNjk5ODQwNTksOS43MjQwOTgyMSBMMy40NzM5MDMwNCw0LjI3NSBMMTYuNzY1NDc4NCw0LjI3NSBaIE0xNi44MDQ1NDYzLDkuNzI4MDY3ODYgTDE4LjY3MzcyNTEsMy4wNTM1NzE0MyBMMy4xOTkxNTIwNywzLjA1MzU3MTQzIEwyLjUxMjI3NDYzLDAgTDMuMjYzMDc1NzJlLTA1LDAgTDMuMjYzMDc1NzJlLTA1LDEuMjIxNDI4NTcgTDEuNDUzMDgwMjUsMS4yMjE0Mjg1NyBMNC4wNjM1NDA4MywxMi44MjUgTDE2Ljk2ODAyNjQsMTIuODI1IEwxNi45NjgwMjY0LDExLjYwMzU3MTQgTDUuMTIyNzM1MjEsMTEuNjAzNTcxNCBMNC45NzAwMjMyNiwxMC45MjUzNzMyIEwxNi44MDQ1NDYzLDkuNzI4MDY3ODYgWiI+PC9wYXRoPgogICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNNy44MzEzODE3MywxNS4yNjc4NTcxIEM3LjgzMTM4MTczLDE2LjI3OTgxMDcgNi45NTQ5MTk1OSwxNy4xIDUuODczNTM2MywxNy4xIEM0Ljc5MjE1MzAxLDE3LjEgMy45MTU2OTA4NywxNi4yNzk4MTA3IDMuOTE1NjkwODcsMTUuMjY3ODU3MSBDMy45MTU2OTA4NywxNC4yNTU5MDM2IDQuNzkyMTUzMDEsMTMuNDM1NzE0MyA1Ljg3MzUzNjMsMTMuNDM1NzE0MyBDNi45NTQ5MTk1OSwxMy40MzU3MTQzIDcuODMxMzgxNzMsMTQuMjU1OTAzNiA3LjgzMTM4MTczLDE1LjI2Nzg1NzEiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTE1LjY2Mjc2MzUsMTUuMjY3ODU3MSBDMTUuNjYyNzYzNSwxNi4yNzk4MTA3IDE0Ljc4NjMwMTMsMTcuMSAxMy43MDQ5MTgsMTcuMSBDMTIuNjIzNTM0NywxNy4xIDExLjc0NzA3MjYsMTYuMjc5ODEwNyAxMS43NDcwNzI2LDE1LjI2Nzg1NzEgQzExLjc0NzA3MjYsMTQuMjU1OTAzNiAxMi42MjM1MzQ3LDEzLjQzNTcxNDMgMTMuNzA0OTE4LDEzLjQzNTcxNDMgQzE0Ljc4NjMwMTMsMTMuNDM1NzE0MyAxNS42NjI3NjM1LDE0LjI1NTkwMzYgMTUuNjYyNzYzNSwxNS4yNjc4NTcxIj48L3BhdGg+CiAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4=")
		no-repeat center 9px;
}

#quick-cart-pay:hover {
	border-color: #303030;
}

#quick-cart-pay:hover>span {
	background-color: #303030;
}

#quick-cart-pay #quick-cart-price {
	-webkit-transform: translateX(-50%);
	-ms-transform: translateX(-50%);
	transform: translateX(-50%);
	font-family: "robotobold", sans-serif;
	border-radius: 11px;
	background-color: #16161a;
	bottom: -4px;
	display: block;
	height: 21px;
	left: 50%;
	padding: 2px 8px 0;
	position: absolute;
}

#quick-cart-pay #quick-cart-pay-total-count {
	display: none;
}

.quick-cart-product {
	margin-bottom: 6px;
}

.quick-cart-product>div, #quick-cart-pay {
	box-shadow: rgba(0, 0, 0, 0.23) 0 6px 13px 0;
}

.quick-cart-animated-product>div {
	box-shadow: transparent 0 6px 13px 0;
}

.quick-cart-product {
	position: relative;
}

.quick-cart-product>div {
	transition: all 1s ease-in-out 0s;
	overflow: hidden;
	position: relative;
}

.quick-cart-product>div .s1, .quick-cart-product>div .s2 {
	font-family: "robotobold", sans-serif;
	font-size: 100%;
	line-height: 107.69231%;
	background-color: rgba(22, 22, 26, 0.5);
	bottom: 0;
	color: #fff;
	cursor: default;
	display: none;
	height: 100%;
	left: 0;
	padding-top: 23px;
	position: absolute;
	text-align: center;
	top: 0;
	width: 100%;
}

.quick-cart-product>div del {
	display: none;
}

#quick-cart .quick-cart-product>div, .quick-cart-product.run>div {
	border-radius: 50%;
	height: 60px !important;
	width: 60px !important;
}

#quick-cart .quick-cart-product>div .s1, .quick-cart-product.run>div .s1
	{
	display: block;
}

#quick-cart .quick-cart-product>div img, .quick-cart-product.run>div img
	{
	width: 100%;
}

#quick-cart .quick-cart-product>div:hover span.s1, .quick-cart-product.run>div:hover span.s1
	{
	display: none;
}

#quick-cart .quick-cart-product>div:hover span.s2, .quick-cart-product.run>div:hover span.s2
	{
	display: block;
}

.quick-cart-product.run>div {
	border-radius: 50%;
	height: 58px !important;
	width: 58px !important;
}

#quick-cart .quick-cart-product>div .s1, #quick-cart .quick-cart-product>div .s2
	{
	border-radius: 50%;
}

.quick-cart-product.animated {
	left: 0;
	position: absolute;
	top: 0;
	z-index: 2000;
}

.quick-cart-product.animated img {
	border-radius: 1px;
	display: block;
	position: relative;
}

.quick-cart-product .remove, .quick-cart-product .removeall:before,
	.quick-cart-product .count {
	border-radius: 10px;
	font-family: "robotobold", sans-serif;
	font-size: 76.92308%;
	line-height: 110.0%;
	background-color: #16161a;
	color: #fff;
	display: block;
	height: 20px;
	overflow: hidden;
	padding-top: 4px;
	position: absolute;
	right: 0;
	top: 0;
	text-align: center;
	width: 20px;
	z-index: 10;
}

.quick-cart-product .removeall {
	width: 20px;
	height: 20px;
	content: "Delete all";
}

.quick-cart-product .removeall:before {
	content: "Delete all";
}

.quick-cart-product .removeall:before {
	transition: all 0.3s ease-in-out;
	cursor: pointer;
	display: none;
	left: -62px;
	padding: 4px 7px 0;
	right: auto;
	width: auto;
	height: 16px;
}

.quick-cart-product .removeall:hover {
	background-color: #020E20;
}

.quick-cart-product.show-remove-all:hover .removeall:before {
	display: block;
}

.quick-cart-product .remove {
	background: #16161a
		url("data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjhweCIgaGVpZ2h0PSI4cHgiIHZpZXdCb3g9IjAgMCA4IDgiIHZlcnNpb249IjEuMSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgeG1sbnM6c2tldGNoPSJodHRwOi8vd3d3LmJvaGVtaWFuY29kaW5nLmNvbS9za2V0Y2gvbnMiPgogICAgPGcgc3Ryb2tlPSJub25lIiBzdHJva2Utd2lkdGg9IjEiIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTEyMTYuMDAwMDAwLCAtMTg5MS4wMDAwMDApIiBmaWxsPSIjRkZGRkZGIj4KICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTE0OC4wMDAwMDAsIDE4ODUuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg2Mi4wMDAwMDAsIDAuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTcuMTQyNjgzOTcsNiBMNiw3LjE0MjY4Mzk3IEw4Ljg1NzExNCw5Ljk5OTc5Nzk3IEw2LDEyLjg1NzMxNiBMNy4xNDI2ODM5NywxNCBMOS45OTk3OTc5NywxMS4xNDI4ODYgTDEyLjg1NzMxNiwxNCBMMTQsMTIuODU3MzE2IEwxMS4xNDI0ODE5LDkuOTk5Nzk3OTcgTDE0LDcuMTQyNjgzOTcgTDEyLjg1NzMxNiw2IEw5Ljk5OTc5Nzk3LDguODU3MTE0IEw3LjE0MjY4Mzk3LDYgTDcuMTQyNjgzOTcsNiBaIj48L3BhdGg+CiAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPg==")
		no-repeat center center;
	cursor: pointer;
	display: none;
	left: 0;
	right: auto;
}

.quick-cart-product .remove:hover {
	background-color: #020E20;
}

.quick-cart-product:hover .remove {
	display: block;
}

.quick-cart-product.remove-product {
	-webkit-animation: quick_cart_pay_hide 200ms ease-in-out forwards;
	animation: quick_cart_pay_hide 200ms ease-in-out forwards;
}

.cubic-btn {
	width: 10px;
	height: 10px;
	position: absolute;
}

.quick-cart-product-wrap {
	position: relative;
}

.img.animate {
	transition: all 0ms ease-out 0s;
	-webkit-transform: translateY(-30px);
	-ms-transform: translateY(-30px);
	transform: translateY(-30px);
	opacity: 0;
}

.img {
	transition: all 600ms ease-out 0s;
	-webkit-transform: translateY(0px);
	-ms-transform: translateY(0px);
	transform: translateY(0px);
	border-radius: 1px;
	background: transparent no-repeat center center;
	background-size: cover;
	border: 1px solid #e2e2e3;
	display: block;
	height: 0;
	opacity: 1;
}

header ._cont, .collection .settings, .collection-list a .variants,
	.product-detail .price-shipping, .product-detail .btn-and-quantity-wrap,
	.product-detail .btn-and-quantity, .spinner, .tabs .tab-labels,
	.detail-socials, .detail-socials .social-sharing, .homepage .main-services ol,
	.homepage .main-text .links, .socials ul, .cart .cart-products .product,
	.cart .cart-products .p-count-price, .cart .inputs, footer .top, footer .bottom,
	footer .bottom .left nav ul, .swatches, .swatch {
	display: block
}

header ._cont:after, .collection .settings:after, .collection-list a .variants:after,
	.product-detail .price-shipping:after, .product-detail .btn-and-quantity-wrap:after,
	.product-detail .btn-and-quantity:after, .spinner:after, .tabs .tab-labels:after,
	.detail-socials:after, .detail-socials .social-sharing:after, .homepage .main-services ol:after,
	.homepage .main-text .links:after, .socials ul:after, .cart .cart-products .product:after,
	.cart .cart-products .p-count-price:after, .cart .inputs:after, footer .top:after,
	footer .bottom:after, footer .bottom .left nav ul:after, .swatches:after,
	.swatch:after {
	clear: both;
	content: "";
	display: block;
	visibility: hidden;
	height: 0
}

/*@font-face {
    font-family: 'montserratlight';
    src: url("montserrat-light-webfont.eot");
    src: url("montserrat-light-webfont.eot?#iefix") format("embedded-opentype"), url("montserrat-light-webfont.woff") format("woff"), url("montserrat-light-webfont.ttf") format("truetype");
    font-weight: normal;
    font-style: normal
}
@font-face {
    font-family: 'montserratregular';
    src: url("montserrat-regular-webfont.eot");
    src: url("montserrat-regular-webfont.eot?#iefix") format("embedded-opentype"), url("montserrat-regular-webfont.woff") format("woff"), url("montserrat-regular-webfont.ttf") format("truetype");
    font-weight: normal;
    font-style: normal
}
@font-face {
    font-family: 'montserratbold';
    src: url("montserrat-bold-webfont.eot");
    src: url("montserrat-bold-webfont.eot?#iefix") format("embedded-opentype"), url("montserrat-bold-webfont.woff") format("woff"), url("montserrat-bold-webfont.ttf") format("truetype");
    font-weight: normal;
    font-style: normal
}
@font-face {
    font-family: 'robotolight';
    src: url("roboto-light-webfont.eot");
    src: url("roboto-light-webfont.eot?#iefix") format("embedded-opentype"), url("roboto-light-webfont.woff") format("woff"), url("roboto-light-webfont.ttf") format("truetype");
    font-weight: normal;
    font-style: normal
}
@font-face {
    font-family: 'robotoregular';
    src: url("roboto-regular-webfont.eot");
    src: url("roboto-regular-webfont.eot?#iefix") format("embedded-opentype"), url("roboto-regular-webfont.woff") format("woff"), url("roboto-regular-webfont.ttf") format("truetype");
    font-weight: normal;
    font-style: normal
}
@font-face {
    font-family: 'robotobold';
    src: url("roboto-bold-webfont.eot");
    src: url("roboto-bold-webfont.eot?#iefix") format("embedded-opentype"), url("roboto-bold-webfont.woff") format("woff"), url("roboto-bold-webfont.ttf") format("truetype");
    font-weight: normal;
    font-style: normal
}
@font-face {
    font-family: 'robotoblack';
    src: url("roboto-black-webfont.eot");
    src: url("roboto-black-webfont.eot?#iefix") format("embedded-opentype"), url("roboto-black-webfont.woff") format("woff"), url("roboto-black-webfont.ttf") format("truetype");
    font-weight: normal;
    font-style: normal
}*/
html, body, div, span, applet, object, iframe, h1, h2, h3, h4, h5, h6, p,
	blockquote, pre, a, abbr, acronym, address, big, cite, code, del, dfn,
	em, img, ins, kbd, q, s, samp, small, strike, strong, sub, sup, tt, var,
	b, u, i, center, dl, dt, dd, ol, ul, li, fieldset, form, label, legend,
	table, caption, tbody, tfoot, thead, tr, th, td, article, aside, canvas,
	details, embed, figure, figcaption, footer, header, hgroup, menu, nav,
	output, ruby, section, summary, time, mark, audio, video {
	margin: 0;
	padding: 0;
	border: 0;
	font: inherit;
	font-size: 100%;
	vertical-align: baseline
}

html {
	line-height: 1
}

ol, ul {
	list-style: none
}

table {
	border-collapse: collapse;
	border-spacing: 0
}

caption, th, td {
	text-align: left;
	font-weight: normal;
	vertical-align: middle
}

q, blockquote {
	quotes: none
}

q:before, q:after, blockquote:before, blockquote:after {
	content: "";
	content: none
}

a img {
	border: none
}

article, aside, details, figcaption, figure, footer, header, hgroup,
	main, menu, nav, section, summary {
	display: block
}

* {
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box;
	outline: 0 none
}

body {
	background-color: #fff;
	-webkit-font-smoothing: antialiased;
	-moz-osx-font-smoothing: grayscale;
}

img {
	max-width: 100%
}

img.float-left {
	float: left;
	margin: 0 20px 10px 0
}

img.float-right {
	float: right;
	margin: 0 0 10px 20px
}

a {
	color: inherit;
	text-decoration: inherit;
	cursor: inherit;
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	cursor: pointer
}

a:active, a:focus {
	outline: none
}

em {
	font-style: oblique
}

u {
	text-decoration: underline
}

del {
	text-decoration: line-through
}

sup, sub {
	font-size: smaller;
	line-height: normal
}

sup {
	vertical-align: super
}

sub {
	vertical-align: sub
}

button {
	cursor: pointer
}

input, textarea {
	outline: 0 none
}

textarea {
	resize: none
}

div.grid_info {
	background-color: #fff;
	bottom: 0;
	color: #16161a;
	display: block;
	left: 0;
	padding: 15px;
	position: fixed;
	top: auto !important;
	z-index: 99999
}

body {
	font-family: "montserratlight", sans-serif;
	background-color: #fff;
	color: #16161a;
	font-size: 81.25%;
	line-height: 184.61538%;
	overflow-x: hidden;
	position: relative
}

._cont {
	margin: 0 auto;
	width: 1110px
}

._cont2 {
	margin: 0 auto;
	width: 700px
}

header nav>ul>li>a:before, header nav>ul>li>a:after, .sorter .sorter-value:before,
	.sorter .sorter-value:after {
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjEwcHgiIGhlaWdodD0iNHB4IiB2aWV3Qm94PSIwIDAgMTAgNCIgdmVyc2lvbj0iMS4xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4bWxuczpza2V0Y2g9Imh0dHA6Ly93d3cuYm9oZW1pYW5jb2RpbmcuY29tL3NrZXRjaC9ucyI+CiAgICA8ZyBzdHJva2U9Im5vbmUiIHN0cm9rZS13aWR0aD0iMSIgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj4KICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMTQ3LjAwMDAwMCwgLTU2NS4wMDAwMDApIiBzdHJva2U9IiMxNjE2MWEiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgxMDAuMDAwMDAwLCAzNDAuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg5LjAwMDAwMCwgMjE4LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgIDxnPgogICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMzksNyBMNDMsMTEgTDQ3LDciIGlkPSJQYXRoLTY3LUNvcHkiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPg==')
		no-repeat center center
}

header nav>ul>li>a:before, .sorter .sorter-value:before {
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjEwcHgiIGhlaWdodD0iNHB4IiB2aWV3Qm94PSIwIDAgMTAgNCIgdmVyc2lvbj0iMS4xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4bWxuczpza2V0Y2g9Imh0dHA6Ly93d3cuYm9oZW1pYW5jb2RpbmcuY29tL3NrZXRjaC9ucyI+CiAgICA8ZyBzdHJva2U9Im5vbmUiIHN0cm9rZS13aWR0aD0iMSIgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj4KICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMTQ3LjAwMDAwMCwgLTU2NS4wMDAwMDApIiBzdHJva2U9IiMwODZmY2YiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgxMDAuMDAwMDAwLCAzNDAuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg5LjAwMDAwMCwgMjE4LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgIDxnPgogICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMzksNyBMNDMsMTEgTDQ3LDciIGlkPSJQYXRoLTY3LUNvcHkiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPg==')
		no-repeat center center
}

header nav>ul>li ul a:after {
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4NCjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+DQo8c3ZnIHZlcnNpb249IjEuMSIgaWQ9IlZyc3R2YV8xIiB4bWxuczpza2V0Y2g9Imh0dHA6Ly93d3cuYm9oZW1pYW5jb2RpbmcuY29tL3NrZXRjaC9ucyINCgkgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgeD0iMHB4IiB5PSIwcHgiIHdpZHRoPSI3cHgiIGhlaWdodD0iOHB4Ig0KCSB2aWV3Qm94PSIzIC0yIDcgOCIgZW5hYmxlLWJhY2tncm91bmQ9Im5ldyAzIC0yIDcgOCIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMTQ3LjAwMDAwMCwgLTU2NS4wMDAwMDApIj4NCgkJPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTAwLjAwMDAwMCwgMzQwLjAwMDAwMCkiPg0KCQkJPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoOS4wMDAwMDAsIDIxOC4wMDAwMDApIj4NCgkJCQk8Zz4NCgkJCQkJPHBhdGggaWQ9IlBhdGgtNjctQ29weSIgZmlsbD0ibm9uZSIgc3Ryb2tlPSIjRkZGRkZGIiBkPSJNNDEsMTNsNC00bC00LTQiLz4NCgkJCQk8L2c+DQoJCQk8L2c+DQoJCTwvZz4NCgk8L2c+DQo8L2c+DQo8L3N2Zz4NCg==')
		no-repeat center center
}

header {
	font-size: 100%;
	line-height: 130.76923%;
	position: relative;
	z-index: 1000
}

header .header {
	-moz-box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px,
		rgba(19, 20, 20, 0.06) 0 1px 1px;
	-webkit-box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px,
		rgba(19, 20, 20, 0.06) 0 1px 1px;
	box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px, rgba(19, 20, 20, 0.06) 0
		1px 1px;
	height: 74px
}

header .logo {
	font-family: "montserratbold", sans-serif;
	font-size: 107.69231%;
	line-height: 128.57143%;
	display: block;
	float: left;
	margin-top: 30px;
	letter-spacing: 4px;
	position: relative;
	text-transform: uppercase;
	z-index: 100
}

header nav {
	font-family: "montserratregular", sans-serif;
	left: 0;
	position: absolute;
	text-align: center;
	text-transform: uppercase;
	top: 31px;
	width: 100%;
	z-index: 1
}

header nav>ul>li {
	display: inline-block;
	margin-right: 19px
}

header nav>ul>li:last-child {
	margin-right: 0
}

header nav>ul>li:last-child.categories-open ul:after {
	left: 55%
}

header nav>ul>li>a {
	padding: 0 14px 20px 0;
	position: relative
}

header nav>ul>li>a:before, header nav>ul>li>a:after {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	content: "";
	height: 10px;
	margin-top: -15px;
	opacity: 1;
	position: absolute;
	right: 0;
	top: 50%;
	width: 10px
}

header nav>ul>li>a:before {
	opacity: 0
}

header nav>ul>li>a:hover {
	color: #020E20
}

header nav>ul>li>a:hover:before {
	opacity: 1
}

header nav>ul>li>a:hover:after {
	opacity: 0
}

header nav>ul>li ul {
	-moz-column-count: 2;
	-webkit-column-count: 2;
	column-count: 2;
	-moz-column-gap: 50px;
	-webkit-column-gap: 50px;
	column-gap: 50px;
	font-family: "montserratlight", sans-serif;
	font-size: 107.69231%;
	line-height: 121.42857%;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	background-color: rgba(13, 13, 26, 0.93);
	display: none;
	left: 50%;
	margin-left: -331px;
	padding: 13px 26px 20px;
	position: absolute;
	text-align: left;
	text-transform: none;
	top: 28px;
	width: 662px;
	z-index: 1000
}

header nav>ul>li ul:after {
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjEycHgiIGhlaWdodD0iN3B4IiB2aWV3Qm94PSIwIDAgMTIgNyIgdmVyc2lvbj0iMS4xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4bWxuczpza2V0Y2g9Imh0dHA6Ly93d3cuYm9oZW1pYW5jb2RpbmcuY29tL3NrZXRjaC9ucyI+CiAgICA8ZyBzdHJva2U9Im5vbmUiIHN0cm9rZS13aWR0aD0iMSIgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj4KICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMTE3NS4wMDAwMDAsIC0xMzAzLjAwMDAwMCkiIGZpbGw9IiMwQzBDMTkiIG9wYWNpdHk9IjAuOTM5OTk5OTk4Ij4KICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTMuMDAwMDAwLCAxMjQ2LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgPHBhdGggZD0iTTExNzgsNjMuNDg1MjgxNCBMMTE4My42NTY4NSw1Ny44Mjg0MjcxIEwxMTg5LjMxMzcxLDYzLjQ4NTI4MTQgTDExNzgsNjMuNDg1MjgxNCBaIiBpZD0iU2lwa2EtbWVudSI+PC9wYXRoPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4=')
		no-repeat left top;
	content: "";
	display: none;
	height: 7px;
	left: 44%;
	left: 43.5%;
	position: absolute;
	top: -6px;
	width: 14px
}

header nav>ul>li ul li {
	border-bottom: 1px solid #2e2e38
}

header nav>ul>li ul a {
	color: #fff;
	display: block;
	opacity: 1;
	padding: 10px 20px 11px 0;
	position: relative
}

header nav>ul>li ul a:after {
	content: "";
	display: block;
	height: 100%;
	position: absolute;
	right: 0;
	top: 0;
	width: 7px
}

header nav>ul>li ul a:hover {
	opacity: 0.65
}

header nav>ul>li.categories-open>a:after, header nav>ul>li.categories-open>a:before
	{
	-moz-transform: rotate(-180deg);
	-ms-transform: rotate(-180deg);
	-webkit-transform: rotate(-180deg);
	transform: rotate(-180deg)
}

header nav>ul>li.categories-open>a:hover:after, header nav>ul>li.categories-open>a:hover:before
	{
	-moz-transform: rotate(-180deg);
	-ms-transform: rotate(-180deg);
	-webkit-transform: rotate(-180deg);
	transform: rotate(-180deg)
}

header nav>ul>li.categories-open ul {
	display: block
}

header nav>ul>li.categories-open ul:after {
	display: block
}

header form {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	-moz-border-radius: 19px;
	-webkit-border-radius: 19px;
	border-radius: 19px;
	border: 1px solid #fff;
	float: right;
	margin-top: 19px;
	overflow: hidden;
	position: relative;
	z-index: 100
}

header form .find-input {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	font-family: "montserratlight", sans-serif;
	font-size: 100%;
	line-height: 130.76923%;
	color: #16161a;
	border: 0 none;
	margin-right: 0;
	overflow: hidden;
	padding: 10px 0;
	width: 0
}

header form button {
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE0cHgiIGhlaWdodD0iMTE0cHgiIHZpZXdCb3g9IjAgMCAxNCAxMTQiIHZlcnNpb249IjEuMSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgeG1sbnM6c2tldGNoPSJodHRwOi8vd3d3LmJvaGVtaWFuY29kaW5nLmNvbS9za2V0Y2gvbnMiPgogICAgPGcgc3Ryb2tlPSJub25lIiBzdHJva2Utd2lkdGg9IjEiIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTQ5NC4wMDAwMDAsIC0xMjk3LjAwMDAwMCkiIGZpbGw9IiMxNjE2MTkiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMy4wMDAwMDAsIDEyNDYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICA8cGF0aCBkPSJNNTA1Ljc1MDA0NCw1MSBDNTAyLjg1MDczMSw1MSA1MDAuNSw1My4zNTA2NDM3IDUwMC41LDU2LjI0OTk1NjMgQzUwMC41LDU3LjQ2Mjk2ODggNTAwLjkxNTMxOSw1OC41NzY3NTYzIDUwMS42MDY2MTIsNTkuNDY1NDA2MyBMNDk3LjE5MjMyNSw2My44Nzk3Mzc1IEM0OTcuMDY0MTM4LDY0LjAwNzkyNSA0OTcsNjQuMTc1MzU2MiA0OTcsNjQuMzQzNzA2MyBDNDk3LDY0LjUxMTY2MjUgNDk3LjA2NDEzOCw2NC42Nzk1MzEzIDQ5Ny4xOTIzMjUsNjQuODA3NzE4OCBDNDk3LjMyMDQ2OSw2NC45MzU5MDYyIDQ5Ny40ODgzODEsNjUgNDk3LjY1NjI5NCw2NSBDNDk3LjgyNDE2Miw2NSA0OTcuOTkyMDc1LDY0LjkzNTkwNjIgNDk4LjEyMDI2Myw2NC44MDc3MTg4IEw1MDIuNTM0NTUsNjAuMzkzNDMxMiBDNTAzLjQyMzI0NCw2MS4wODQ3MjUgNTA0LjUzNzAzMSw2MS40OTk5NTYzIDUwNS43NTAwNDQsNjEuNDk5OTU2MyBDNTA4LjY0OTMxMiw2MS40OTk5NTYzIDUxMS4wMDAwNDQsNTkuMTQ5MjY4NyA1MTEuMDAwMDQ0LDU2LjI0OTk1NjMgQzUxMS4wMDAwNDQsNTMuMzUwNjQzNyA1MDguNjQ5MzEyLDUxIDUwNS43NTAwNDQsNTEgTDUwNS43NTAwNDQsNTEgWiBNNTA1Ljc1MDA0NCw2MC4xODc1IEM1MDMuNTc4NzMxLDYwLjE4NzUgNTAxLjgxMjU0NCw1OC40MjEyMjUgNTAxLjgxMjU0NCw1Ni4yNDk5NTYzIEM1MDEuODEyNTQ0LDU0LjA3ODY4NzUgNTAzLjU3ODczMSw1Mi4zMTI0NTYzIDUwNS43NTAwNDQsNTIuMzEyNDU2MyBDNTA3LjkyMTI2OSw1Mi4zMTI0NTYzIDUwOS42ODc1LDU0LjA3ODY4NzUgNTA5LjY4NzUsNTYuMjQ5OTU2MyBDNTA5LjY4NzUsNTguNDIxMjI1IDUwNy45MjEyNjksNjAuMTg3NSA1MDUuNzUwMDQ0LDYwLjE4NzUgTDUwNS43NTAwNDQsNjAuMTg3NSBaIj48L3BhdGg+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+CiAgICA8ZyBzdHJva2U9Im5vbmUiIHN0cm9rZS13aWR0aD0iMSIgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIiB0cmFuc2Zvcm09InRyYW5zbGF0ZSgwLDEwMCkiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC00OTQuMDAwMDAwLCAtMTI5Ny4wMDAwMDApIiBmaWxsPSIjMDg2ZmNmIj4KICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTMuMDAwMDAwLCAxMjQ2LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgPHBhdGggZD0iTTUwNS43NTAwNDQsNTEgQzUwMi44NTA3MzEsNTEgNTAwLjUsNTMuMzUwNjQzNyA1MDAuNSw1Ni4yNDk5NTYzIEM1MDAuNSw1Ny40NjI5Njg4IDUwMC45MTUzMTksNTguNTc2NzU2MyA1MDEuNjA2NjEyLDU5LjQ2NTQwNjMgTDQ5Ny4xOTIzMjUsNjMuODc5NzM3NSBDNDk3LjA2NDEzOCw2NC4wMDc5MjUgNDk3LDY0LjE3NTM1NjIgNDk3LDY0LjM0MzcwNjMgQzQ5Nyw2NC41MTE2NjI1IDQ5Ny4wNjQxMzgsNjQuNjc5NTMxMyA0OTcuMTkyMzI1LDY0LjgwNzcxODggQzQ5Ny4zMjA0NjksNjQuOTM1OTA2MiA0OTcuNDg4MzgxLDY1IDQ5Ny42NTYyOTQsNjUgQzQ5Ny44MjQxNjIsNjUgNDk3Ljk5MjA3NSw2NC45MzU5MDYyIDQ5OC4xMjAyNjMsNjQuODA3NzE4OCBMNTAyLjUzNDU1LDYwLjM5MzQzMTIgQzUwMy40MjMyNDQsNjEuMDg0NzI1IDUwNC41MzcwMzEsNjEuNDk5OTU2MyA1MDUuNzUwMDQ0LDYxLjQ5OTk1NjMgQzUwOC42NDkzMTIsNjEuNDk5OTU2MyA1MTEuMDAwMDQ0LDU5LjE0OTI2ODcgNTExLjAwMDA0NCw1Ni4yNDk5NTYzIEM1MTEuMDAwMDQ0LDUzLjM1MDY0MzcgNTA4LjY0OTMxMiw1MSA1MDUuNzUwMDQ0LDUxIEw1MDUuNzUwMDQ0LDUxIFogTTUwNS43NTAwNDQsNjAuMTg3NSBDNTAzLjU3ODczMSw2MC4xODc1IDUwMS44MTI1NDQsNTguNDIxMjI1IDUwMS44MTI1NDQsNTYuMjQ5OTU2MyBDNTAxLjgxMjU0NCw1NC4wNzg2ODc1IDUwMy41Nzg3MzEsNTIuMzEyNDU2MyA1MDUuNzUwMDQ0LDUyLjMxMjQ1NjMgQzUwNy45MjEyNjksNTIuMzEyNDU2MyA1MDkuNjg3NSw1NC4wNzg2ODc1IDUwOS42ODc1LDU2LjI0OTk1NjMgQzUwOS42ODc1LDU4LjQyMTIyNSA1MDcuOTIxMjY5LDYwLjE4NzUgNTA1Ljc1MDA0NCw2MC4xODc1IEw1MDUuNzUwMDQ0LDYwLjE4NzUgWiI+PC9wYXRoPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4=')
		no-repeat left top;
	border: 0 none;
	height: 14px;
	margin-right: 15px;
	position: relative;
	overflow: hidden;
	top: 1px;
	text-indent: -1000px;
	width: 14px
}

header form button:hover {
	background-position: left bottom
}

header form.open {
	border-color: #d2d4d6
}

header form.open input {
	padding: 10px 15px;
	width: 157px
}

header #customer_login_link {
	display: inline-block;
	float: right;
	margin: 30px 26px 0 0;
	position: relative;
	z-index: 100
}

header #customer_login_link:hover {
	color: #020E20
}

header #nav-icon {
	display: none
}

.breadcrumb {
	margin-top: 15px
}

.breadcrumb li {
	display: inline-block
}

.breadcrumb a {
	color: #b5b6bd;
	display: inline-block;
	margin-right: 5px;
	padding-right: 14px;
	position: relative
}

.btn-fill:hover{
	color: #ffffff !important;
}

.breadcrumb a:hover {
	color: #020E20
}

.breadcrumb a:after {
	color: #b5b6bd;
	position: absolute;
	right: 0
}

.text {
	margin: 0 auto;
	padding: 90px 0 165px;
	width: 700px
}

.text h1 {
	font-family: "montserratbold", sans-serif;
	font-size: 369.23077%;
	line-height: 125%;
	margin-bottom: 60px
}

.text h2 {
	font-family: "montserratregular", sans-serif;
	font-size: 184.61538%;
	line-height: 133.33333%;
	margin: 55px 0 17px
}

.text p {
	font-size: 138.46154%;
	line-height: 177.77778%;
	margin: 17px 0 28px
}

.text strong {
	font-family: "montserratbold", sans-serif
}

.text em {
	font-style: italic
}

.text *:last-child {
	margin-bottom: 0
}

.text ul {
	font-size: 115.38462%;
	line-height: 173.33333%;
	margin: 17px 0 28px 40px
}

.text ul li {
	list-style-type: disc;
	padding: 7px 0 7px 7px
}

.text ol {
	font-size: 115.38462%;
	line-height: 173.33333%;
	margin: 17px 0 28px 40px
}

.text ol li {
	list-style-type: decimal;
	padding: 7px 0 7px 7px
}

.collection {
	padding-top: 15px
}

.collection.search {
	padding-top: 0
}

.collection h1 {
	font-family: "montserratbold", sans-serif;
	font-size: 369.23077%;
	line-height: 116.66667%;
	color: #020E20;
	padding-bottom: 13px;
	text-align: center
}

.collection .description {
	font-size: 107.69231%;
	line-height: 171.42857%;
	margin: 0 auto;
	max-width: 700px;
	padding-bottom: 13px;
	text-align: center
}

.collection .head {
	-moz-box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px,
		rgba(19, 20, 20, 0.06) 0 1px 1px;
	-webkit-box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px,
		rgba(19, 20, 20, 0.06) 0 1px 1px;
	box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px, rgba(19, 20, 20, 0.06) 0
		1px 1px;
	padding-bottom: 30px;
	position: relative;
	z-index: 100
}

.collection .products {
	background-color: #f7f7fa;
	padding: 28px 0 110px
}

.collection .settings {
	font-size: 107.69231%;
	line-height: 121.42857%;
	color: #b5b6bd;
	position: relative
}

.collection .settings .sort {
	float: right
}

.collection .settings .sort .sorter {
	margin-left: 5px
}

.collection .settings .count {
	float: left
}

.collection .no-products {
	font-size: 115.38462%;
	line-height: 120%;
	font-family: "montserratregular", sans-serif;
	padding-top: 70px;
	text-align: center
}

.more-products {
	padding-top: 40px;
	text-align: center
}

.more-products span {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	font-size: 107.69231%;
	line-height: 121.42857%;
	font-family: "montserratbold", sans-serif;
	-moz-border-radius: 26px;
	-webkit-border-radius: 26px;
	border-radius: 26px;
	-moz-box-shadow: rgba(17, 17, 18, 0.1) 0 2px 4px, rgba(19, 20, 20, 0.07)
		0 1px 1px;
	-webkit-box-shadow: rgba(17, 17, 18, 0.1) 0 2px 4px,
		rgba(19, 20, 20, 0.07) 0 1px 1px;
	box-shadow: rgba(17, 17, 18, 0.1) 0 2px 4px, rgba(19, 20, 20, 0.07) 0
		1px 1px;
	background-color: #020E20;
	color: #fff;
	cursor: pointer;
	display: inline-block;
	padding: 16px 26px
}

.more-products span:hover {
	background-color: #a9a9a9
}

.more-products.hidden {
	display: none
}

.sorter {
	display: inline-block;
	position: relative
}

.sorter:after {
	-moz-transition: opacity 0.3s ease-in-out 0s;
	-o-transition: opacity 0.3s ease-in-out 0s;
	-webkit-transition: opacity 0.3s ease-in-out;
	-webkit-transition-delay: 0s;
	transition: opacity 0.3s ease-in-out 0s;
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjEycHgiIGhlaWdodD0iN3B4IiB2aWV3Qm94PSIwIDAgMTIgNyIgdmVyc2lvbj0iMS4xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4bWxuczpza2V0Y2g9Imh0dHA6Ly93d3cuYm9oZW1pYW5jb2RpbmcuY29tL3NrZXRjaC9ucyI+CiAgICA8ZyBzdHJva2U9Im5vbmUiIHN0cm9rZS13aWR0aD0iMSIgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj4KICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMTE3NS4wMDAwMDAsIC0xMzAzLjAwMDAwMCkiIGZpbGw9IiMwQzBDMTkiIG9wYWNpdHk9IjAuOTM5OTk5OTk4Ij4KICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTMuMDAwMDAwLCAxMjQ2LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgPHBhdGggZD0iTTExNzgsNjMuNDg1MjgxNCBMMTE4My42NTY4NSw1Ny44Mjg0MjcxIEwxMTg5LjMxMzcxLDYzLjQ4NTI4MTQgTDExNzgsNjMuNDg1MjgxNCBaIiBpZD0iU2lwa2EtbWVudSI+PC9wYXRoPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4=')
		no-repeat left top;
	content: "";
	display: block;
	height: 7px;
	opacity: 0;
	position: absolute;
	right: 38px;
	top: 20px;
	width: 12px
}

.sorter .sorter-value {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	background-position: right 8px;
	color: #16161a;
	cursor: pointer;
	display: inline-block;
	padding-right: 14px;
	position: relative
}

.sorter .sorter-value:before, .sorter .sorter-value:after {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	content: "";
	height: 10px;
	margin-top: -5px;
	opacity: 1;
	position: absolute;
	right: 0;
	top: 50%;
	width: 10px
}

.sorter .sorter-value:before {
	opacity: 0
}

.sorter .sorter-value:hover {
	color: #020E20
}

.sorter .sorter-value:hover:before {
	opacity: 1
}

.sorter .sorter-value:hover:after {
	opacity: 0
}

.sorter .sorter-options {
	-moz-transition: opacity 0.3s ease-in-out 0s, max-height 0s ease-in-out
		0.3s;
	-o-transition: opacity 0.3s ease-in-out 0s, max-height 0s ease-in-out
		0.3s;
	-webkit-transition: opacity 0.3s ease-in-out, max-height 0s ease-in-out;
	-webkit-transition-delay: 0s, 0.3s;
	transition: opacity 0.3s ease-in-out 0s, max-height 0s ease-in-out 0.3s;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	background-color: rgba(13, 13, 26, 0.93);
	color: #fff;
	max-height: 0;
	opacity: 0;
	overflow: hidden;
	padding: 0 12px;
	position: absolute;
	right: 0;
	top: 26px;
	z-index: 100
}

.sorter .sorter-options>div {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	border-bottom: 1px solid #2e2e38;
	cursor: pointer;
	padding: 11px 0;
	white-space: nowrap
}

.sorter .sorter-options>div:first-child {
	padding-top: 12px
}

.sorter .sorter-options>div:last-child {
	border-bottom: 0 none;
	padding-bottom: 14px
}

.sorter .sorter-options>div:hover {
	opacity: 0.65
}

.sorter .sorter-options>div.active {
	color: #5d5e66
}

.sorter .sorter-options>div.active:hover {
	opacity: 1
}

.sorter.open .sorter-value:before, .sorter.open .sorter-value:after {
	-moz-transform: rotate(-180deg);
	-ms-transform: rotate(-180deg);
	-webkit-transform: rotate(-180deg);
	transform: rotate(-180deg)
}

.sorter.open .sorter-options {
	-moz-transition: opacity 0.3s ease-in-out 0s, max-height 0s ease-in-out
		0s;
	-o-transition: opacity 0.3s ease-in-out 0s, max-height 0s ease-in-out 0s;
	-webkit-transition: opacity 0.3s ease-in-out, max-height 0s ease-in-out;
	-webkit-transition-delay: 0s, 0s;
	transition: opacity 0.3s ease-in-out 0s, max-height 0s ease-in-out 0s;
	max-height: 1000px;
	opacity: 1
}

.sorter.open:after {
	opacity: 0.93
}

.collection-list {
	max-width: 100%;
	margin-left: auto;
	margin-right: auto;
	margin-top: 18px
}

.collection-list:after {
	content: " ";
	display: block;
	clear: both
}

.collection-list.cols-4 a {
	width: 23.72881%;
	float: left;
	margin-right: 1.69492%
}

.collection-list.cols-4 a:nth-child(4n) {
	float: right;
	margin-right: 0
}

.collection-list.cols-4 a:nth-child(4n+1) {
	clear: both
}

.collection-list.cols-3 a {
	width: 32.20339%;
	float: left;
	margin-right: 1.69492%
}

.collection-list.cols-3 a:nth-child(3n) {
	float: right;
	margin-right: 0
}

.collection-list.cols-3 a:nth-child(3n+1) {
	clear: both
}

.collection-list.cols-2 a {
	width: 49.15254%;
	float: left;
	margin-right: 1.69492%
}

.collection-list.cols-2 a:nth-child(2n) {
	float: right;
	margin-right: 0
}

.collection-list.cols-2 a:nth-child(2n+1) {
	clear: both
}

.collection-list a {
	font-size: 100%;
	line-height: 123.07692%;
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	cursor: pointer;
	display: block;
	margin-bottom: 3.44828%;
	position: relative
}

.collection-list a .img {
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	-moz-box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px,
		rgba(19, 20, 20, 0.06) 0 1px 1px;
	-webkit-box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px,
		rgba(19, 20, 20, 0.06) 0 1px 1px;
	box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px, rgba(19, 20, 20, 0.06) 0
		1px 1px;
	background-color: rgba(64, 64, 82, 0.1) !important;
	border: 1px solid rgba(64, 64, 82, 0.1);
	display: block;
	height: 0;
	overflow: hidden;
	padding-bottom: 133%;
	position: relative
}

.collection-list a .img .i {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	background: transparent no-repeat center center;
	-moz-background-size: cover;
	-o-background-size: cover;
	-webkit-background-size: cover;
	background-size: cover;
	display: block;
	height: 100%;
	left: 0;
	opacity: 1;
	position: absolute;
	top: 0;
	width: 100%
}

.collection-list a .img .second, .collection-list a .img .hide {
	opacity: 0
}

.collection-list a .img .show {
	opacity: 1
}

.collection-list a .text {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	background-color: rgba(13, 13, 26, 0.93);
	bottom: -10px;
	color: #fff;
	display: block;
	left: 3%;
	max-width: 94%;
	padding: 6px 10px 3px;
	position: absolute
}

.collection-list a .text strong {
	font-family: "robotoregular", sans-serif;
	display: block
}

.collection-list a .text>span {
	font-family: "robotoblack", sans-serif;
	display: block;
	margin-bottom: 2px
}

.collection-list a .text>span>span {
	font-family: "robotoregular", sans-serif;
	opacity: 0.5
}

.collection-list a:hover>span {
	background-color: #0d0d1a
}

.collection-list a:hover .variants {
	height: 27px
}

.collection-list a .variants {
	-moz-transition: all 200ms cubic-bezier(0.64, 0.57, 0.67, 1.53) 0s;
	-o-transition: all 200ms cubic-bezier(0.64, 0.57, 0.67, 1.53) 0s;
	-webkit-transition: all 200ms cubic-bezier(0.64, 0.57, 0.67, 1.53);
	-webkit-transition-delay: 0s;
	transition: all 200ms cubic-bezier(0.64, 0.57, 0.67, 1.53) 0s;
	font-family: "robotoregular", sans-serif;
	height: 0;
	overflow: hidden
}

.collection-list a .variants .variant {
	float: left;
	margin: 5px 0 2px;
	width: 50%
}

.collection-list a .variants .variant:nth-child(even) {
	text-align: right
}

.collection-list a .variants .var {
	display: inline-block
}

.collection-list a .variants .var.color {
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	border: 1px solid #5d5e66;
	height: 16px;
	padding: 3px;
	width: 16px
}

.collection-list a .variants .var.blue .c {
	background-color: #020E20 !important
}

.collection-list a .variants .var.yellow .c {
	background-color: #f5c81f !important
}

.collection-list a .variants .var.red .c {
	background-color: #d9332e !important
}

.collection-list a .variants .var .c {
	height: 100%;
	width: 100%
}

.collection-list a .variants .var:not(:last-child) .t:after {
	content: ", "
}

.collection-list a.hidden {
	display: none
}

.homepage-banners {
	background-color: #f7f7fa
}

.homepage-banners a .text {
	display: inline-block;
	padding: 6px 10px;
	width: auto
}

.homepage-banners a .text>strong {
	font-family: "robotoblack", sans-serif
}

.homepage-banners a .text>span {
	font-family: "robotoregular", sans-serif;
	margin: 6px 0 0
}

.homepage-banners a .img {
	padding-bottom: 45%
}

.homepage-banners a .descr {
	-moz-transition: all 200ms cubic-bezier(0.64, 0.57, 0.67, 1.53) 0s;
	-o-transition: all 200ms cubic-bezier(0.64, 0.57, 0.67, 1.53) 0s;
	-webkit-transition: all 200ms cubic-bezier(0.64, 0.57, 0.67, 1.53);
	-webkit-transition-delay: 0s;
	transition: all 200ms cubic-bezier(0.64, 0.57, 0.67, 1.53) 0s;
	font-family: "robotoregular", sans-serif;
	max-height: 0;
	max-width: 0;
	overflow: hidden
}

.homepage-banners a .descr>span {
	display: block;
	padding-top: 5px
}

.homepage-banners a:hover .descr {
	max-height: 100px;
	max-width: 600px
}

.product-detail {
	padding-top: 15px
}

.product-detail .shadow {
	-moz-box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px,
		rgba(19, 20, 20, 0.06) 0 1px 1px;
	-webkit-box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px,
		rgba(19, 20, 20, 0.06) 0 1px 1px;
	box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px, rgba(19, 20, 20, 0.06) 0
		1px 1px;
	margin-bottom: 2px
}

.product-detail .cols {
	max-width: 100%;
	margin-left: auto;
	margin-right: auto;
	padding: 35px 0 58px
}

.product-detail .cols:after {
	content: " ";
	display: block;
	clear: both
}

.product-detail .left-col {
	width: 48.27586%;
	float: left;
	margin-right: 3.44828%;
	max-width: 100%;
	margin-left: auto;
	margin-right: auto
}

.product-detail .left-col:after {
	content: " ";
	display: block;
	clear: both
}

.product-detail .left-col .thumbs {
	width: 15.25424%;
	float: left;
	margin-right: 1.69492%
}

.product-detail .left-col .thumbs a {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	-moz-border-radius: 1px;
	-webkit-border-radius: 1px;
	border-radius: 1px;
	border: 1px solid #e2e2e3;
	display: block;
	margin-bottom: 8px;
	position: relative;
	width: 100%
}

.product-detail .left-col .thumbs a.active {
	border-color: #020E20
}

.product-detail .left-col .thumbs a.active:hover {
	border-color: #020E20
}

.product-detail .left-col .thumbs a:hover {
	border-color: #b5b6bd
}

.product-detail .left-col .thumbs img {
	display: block;
	width: 100%
}

.product-detail .left-col .big {
	width: 83.05085%;
	float: right;
	margin-right: 0
}

.product-detail .left-col .big .img {
	-moz-transition: all 600ms ease-out 0s;
	-o-transition: all 600ms ease-out 0s;
	-webkit-transition: all 600ms ease-out;
	-webkit-transition-delay: 0s;
	transition: all 600ms ease-out 0s;
	-moz-transform: translateY(0px);
	-ms-transform: translateY(0px);
	-webkit-transform: translateY(0px);
	transform: translateY(0px);
	-moz-border-radius: 1px;
	-webkit-border-radius: 1px;
	border-radius: 1px;
	background: transparent no-repeat center center;
	-moz-background-size: cover;
	-o-background-size: cover;
	-webkit-background-size: cover;
	background-size: cover;
	border: 1px solid #e2e2e3;
	display: block;
	height: 0;
	opacity: 1;
	padding-bottom: 133%
}

.product-detail .left-col .big .img.animate {
	-moz-transition: all 0ms ease-out 0s;
	-o-transition: all 0ms ease-out 0s;
	-webkit-transition: all 0ms ease-out;
	-webkit-transition-delay: 0s;
	transition: all 0ms ease-out 0s;
	-moz-transform: translateY(-30px);
	-ms-transform: translateY(-30px);
	-webkit-transform: translateY(-30px);
	transform: translateY(-30px);
	opacity: 0
}

.product-detail .left-col .big #banner-gallery {
	display: none
}

.product-detail .right-col {
	width: 48.27586%;
	float: right;
	margin-right: 0
}

.product-detail h1 {
	font-size: 184.61538%;
	line-height: 141.66667%;
	font-family: "montserratregular", sans-serif
}

.product-detail a {
	font-size: 100%;
	line-height: 123.07692%;
	color: #b5b6bd;
	text-decoration: underline
}

.product-detail a:hover {
	color: #020E20
}

.product-detail .price-shipping {
	border-bottom: 1px solid #edeff2;
	padding-bottom: 14px
}

.product-detail .price-shipping a {
	display: block;
	float: left;
	margin: 19px 0 0 25px
}

.product-detail .price {
	font-size: 369.23077%;
	line-height: 108.33333%;
	font-family: "montserratbold", sans-serif;
	color: #086fcf;
	float: left;
	letter-spacing: -2px
}

.product-detail .price del {
	font-size: 54.16667%;
	line-height: 200%;
	font-family: "montserratregular", sans-serif;
	color: #b5b6bd
}

.product-detail #AddToCartForm {
	margin-top: 40px
}

.product-detail .btn-and-quantity {
	float: left
}

.product-detail #AddToCart {
	font-family: "montserratbold", sans-serif;
	-moz-border-radius: 25px;
	-webkit-border-radius: 25px;
	border-radius: 25px;
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	font-size: 107.69231%;
	line-height: 128.57143%;
	background: #020E20
		/* url('https://cdn-icons-png.flaticon.com/512/18/18625.png') no-repeat 26px center */;
	/* background-size:26px; */
	border: 0 none;
	color: #fff;
	float: right;
	height: 50px;
	padding: 14px 26px 14px 53px
}

.product-detail #AddToCart:hover {
	background-color: #a9a9a9
}

.product-detail .spinner {
	float: right
}

.product-detail .spinner:before {
	background: transparent
		url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAoAAAAyCAIAAADqed0qAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAACsSURBVDhP7ZNbEsIgDAC9/2HVSnkUWnAVZhwlBA/Q/QqzhKaQXIrKqUU0ndI+1DmX27IO9Wq980HWx5FJJZC1dcH5jUDQOZNq+DYI2oeN7BoL+mEsv1RjQV/vpkW9jjGZ1bVFr431IcS2+NFUtBj7Lrnx0b2DpkUHLz1y8IcG7fCKVlql3/GlQbsWmFwqaE8CkwedtMOkmYDsYSvCpJFBGwOYDBFoI1g5tUApTxJ40LZNFr4gAAAAAElFTkSuQmCC')
		no-repeat left top;
	content: "";
	display: block;
	height: 50px;
	left: -6px;
	position: absolute;
	top: 0;
	width: 10px
}

.related {
	background-color: #f7f7fa;
	padding: 40px 0 85px
}

.related h2 {
	font-size: 184.61538%;
	line-height: 150%;
	font-family: "montserratregular", sans-serif;
	text-align: center
}

.related .collection-list {
	margin-top: 26px
}

.swatches .guide {
	float: left;
	margin: 36px 0 0 20px
}

.spinner {
	-moz-border-radius: 25px;
	-webkit-border-radius: 25px;
	border-radius: 25px;
	border: 1px solid #edeff2;
	height: 50px;
	margin-left: 10px;
	padding: 15px 16px 0;
	position: relative
}

.spinner.is-hidden {
	display: none
}

.spinner .btn {
	cursor: pointer;
	display: block;
	float: left;
	height: 10px;
	margin-top: 4px;
	position: relative;
	width: 10px
}

.spinner .btn:before {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	background-color: #020E20;
	content: "";
	display: block;
	height: 2px;
	left: 0;
	margin-top: -1px;
	position: absolute;
	top: 50%;
	width: 100%
}

.spinner .btn.plus:after {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	background-color: #020E20;
	bottom: 0;
	content: "";
	display: block;
	height: 100%;
	left: 50%;
	margin-left: -1px;
	position: absolute;
	top: 0;
	width: 2px
}

.spinner .btn:hover:before, .spinner .btn:hover:after {
	background-color: #0084ff
}

.spinner input {
	font-family: "montserratlight", sans-serif;
	border: 0 none;
	color: #16161a;
	display: block;
	float: left;
	font-size: 14px;
	height: 17px !important;
	line-height: 17px !important;
	margin-left: 1px;
	padding-bottom: 0;
	padding-top: 0;
	text-align: right;
	width: 30px
}

.spinner .q {
	font-size: 107.69231%;
	line-height: 121.42857%;
	display: block;
	float: left;
	margin: 1px 20px 0 3px
}

.tabs {
	margin: 30px 0
}

.tabs .tab-labels {
	position: relative;
	top: 1px;
	z-index: 100
}

.tabs .tab-labels span {
	font-family: "montserratbold", sans-serif;
	font-size: 100%;
	line-height: 123.07692%;
	-moz-border-radius: 1px;
	-webkit-border-radius: 1px;
	border-radius: 1px;
	border: 1px solid #fff;
	border-bottom: 0 none;
	color: #020E20;
	cursor: pointer;
	display: block;
	float: left;
	padding: 7px 15px 9px;
	text-transform: uppercase
}

.tabs .tab-labels span.active {
	background-color: #fff;
	border-color: #edeff2;
	color: #16161a
}

.tabs .tab-slides {
	font-size: 100%;
	line-height: 184.61538%;
	border-top: 1px solid #edeff2;
	padding-top: 10px;
	position: relative
}

.tabs .tab-slides>div {
	display: none
}

.tabs .tab-slides>div.active {
	display: block
}

.social-sharing-btn-wrapper {
	display: none
}

.detail-socials .social-sharing {
	float: right;
	margin: 12px 0
}

.detail-socials a {
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	border-radius: 50%;
	background: transparent no-repeat center center;
	border: 1px solid #edeff2;
	display: block;
	float: left;
	height: 26px;
	margin-right: 7px;
	width: 26px
}

.detail-socials a:hover {
	border-color: #b5b6bd
}

.detail-socials a:last-child {
	margin-right: 0
}

.detail-socials .icon, .detail-socials .share-title, .detail-socials .share-count
	{
	display: none
}

.detail-socials .share-facebook {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjI3cHgiIGhlaWdodD0iMjZweCIgdmlld0JveD0iMCAwIDI3IDI2IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC01NjEuMDAwMDAwLCAtNzY5LjAwMDAwMCkiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg4My4wMDAwMDAsIDE1Ny4wMDAwMDApIj4KICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDQ0NS4wMDAwMDAsIDYxMi4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgzMy40Mjg1NzEsIDAuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xMS4yMTE3OTE2LDE5LjQyNzY0NzUgTDExLjIxMTc5MTYsMTMuMjcyMTY2OCBMOS45NDExNzY0NywxMy4yNzIxNjY4IEw5Ljk0MTE3NjQ3LDExLjE1MDg3MTMgTDExLjIxMTc5MTYsMTEuMTUwODcxMyBMMTEuMjExNzkxNiw5Ljg3NzI1MzEzIEMxMS4yMTE3OTE2LDguMTQ2NzAzNjEgMTEuOTI5MjYwNCw3LjExNzY0NzA2IDEzLjk2NzY3NCw3LjExNzY0NzA2IEwxNS42NjQ3MTA1LDcuMTE3NjQ3MDYgTDE1LjY2NDcxMDUsOS4yMzkxODI4MiBMMTQuNjAzOTQyNiw5LjIzOTE4MjgyIEMxMy44MTA0Mzg3LDkuMjM5MTgyODIgMTMuNzU3OTQ2OSw5LjUzNTYzNTY3IDEzLjc1Nzk0NjksMTAuMDg4OTAyMiBMMTMuNzU1MDY0LDExLjE1MDYzMSBMMTUuNjc2NzIyMywxMS4xNTA2MzEgTDE1LjQ1MTg2MDIsMTMuMjcxOTI2NiBMMTMuNzU1MDY0LDEzLjI3MTkyNjYgTDEzLjc1NTA2NCwxOS40Mjc2NDc1IEwxMS4yMTE3OTE2LDE5LjQyNzY0NzUgWiIgZmlsbD0iI0I1QjdCRCI+PC9wYXRoPgogICAgICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgPC9nPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+')
}

.detail-socials .share-twitter {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjI2cHgiIGhlaWdodD0iMjZweCIgdmlld0JveD0iMCAwIDI2IDI2IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC01MjguMDAwMDAwLCAtNzY5LjAwMDAwMCkiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg4My4wMDAwMDAsIDE1Ny4wMDAwMDApIj4KICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDQ0NS4wMDAwMDAsIDYxMi4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMTUuMDU2NDI4NCw4LjUyNzIxNjk1IEMxMy45ODgxODAyLDguOTE2MDI1MDEgMTMuMzEzMDQ3Myw5LjkxODI4NTggMTMuMzg5OTYxMiwxMS4wMTU1ODg2IEwxMy40MTU1OTkxLDExLjQzODk1NzMgTDEyLjk4ODI5OTgsMTEuMzg3MTE2MyBDMTEuNDMyOTMwNSwxMS4xODgzOTIxIDEwLjA3NDExODcsMTAuNTE0NDU4MiA4LjkyMDQxMDY4LDkuMzgyNTk0NjkgTDguMzU2Mzc1NjMsOC44MjA5ODMwNCBMOC4yMTEwOTM4OCw5LjIzNTcxMTY0IEM3LjkwMzQzODM5LDEwLjE2MDIxMDggOC4wOTk5OTYwNiwxMS4xMzY1NTExIDguNzQwOTQ0OTgsMTEuNzkzMjA0NyBDOS4wODI3ODQ0MSwxMi4xNTYwOTIyIDkuMDA1ODcwNTQsMTIuMjA3OTMzMyA4LjQxNjE5NzUzLDExLjk5MTkyODggQzguMjExMDkzODgsMTEuOTIyODA3NCA4LjAzMTYyODE4LDExLjg3MDk2NjMgOC4wMTQ1MzYyMSwxMS44OTY4ODY4IEM3Ljk1NDcxNDMxLDExLjk1NzM2ODEgOC4xNTk4MTc5NiwxMi43NDM2MjQ0IDguMzIyMTkxNjksMTMuMDU0NjcwOCBDOC41NDQzODczMiwxMy40ODY2Nzk4IDguOTk3MzI0NTUsMTMuOTEwMDQ4NiA5LjQ5Mjk5MTcyLDE0LjE2MDYxMzggTDkuOTExNzQ1MDIsMTQuMzU5MzM3OSBMOS40MTYwNzc4NSwxNC4zNjc5NzgxIEM4LjkzNzUwMjY1LDE0LjM2Nzk3ODEgOC45MjA0MTA2OCwxNC4zNzY2MTgzIDguOTcxNjg2NiwxNC41NTgwNjIgQzkuMTQyNjA2MzEsMTUuMTE5NjczNyA5LjgxNzczOTE3LDE1LjcxNTg0NiAxMC41Njk3ODU5LDE1Ljk3NTA1MTQgTDExLjA5OTYzNywxNi4xNTY0OTUyIEwxMC42MzgxNTM4LDE2LjQzMjk4MDkgQzkuOTU0NDc0OTQsMTYuODMwNDI5MSA5LjE1MTE1MjMsMTcuMDU1MDczOCA4LjM0NzgyOTY1LDE3LjA3MjM1NDIgQzcuOTYzMjYwMjksMTcuMDgwOTk0MyA3LjY0NzA1ODgyLDE3LjExNTU1NTEgNy42NDcwNTg4MiwxNy4xNDE0NzU2IEM3LjY0NzA1ODgyLDE3LjIyNzg3NzQgOC42ODk2NjkwNywxNy43MTE3Mjc0IDkuMjk2NDM0MDUsMTcuOTAxODExNCBDMTEuMTE2NzI5LDE4LjQ2MzQyMyAxMy4yNzg4NjM0LDE4LjIyMTQ5OCAxNC45MDI2MDA2LDE3LjI2MjQzODEgQzE2LjA1NjMwODcsMTYuNTc5ODYzOSAxNy4yMTAwMTY3LDE1LjIyMzM1NTggMTcuNzQ4NDEzOCwxMy45MTAwNDg2IEMxOC4wMzg5Nzc0LDEzLjIxMDE5NDEgMTguMzI5NTQwOSwxMS45MzE0NDc1IDE4LjMyOTU0MDksMTEuMzE3OTk0OCBDMTguMzI5NTQwOSwxMC45MjA1NDY2IDE4LjM1NTE3ODgsMTAuODY4NzA1NSAxOC44MzM3NTQsMTAuMzkzNDk1NyBDMTkuMTE1NzcxNSwxMC4xMTcwMDk5IDE5LjM4MDY5NzEsOS44MTQ2MDM2NSAxOS40MzE5NzMsOS43MjgyMDE4NiBDMTkuNTE3NDMyOSw5LjU2NDAzODQ1IDE5LjUwODg4NjksOS41NjQwMzg0NSAxOS4wNzMwNDE2LDkuNzEwOTIxNSBDMTguMzQ2NjMyOCw5Ljk3MDEyNjg3IDE4LjI0NDA4MSw5LjkzNTU2NjE2IDE4LjYwMzAxMjQsOS41NDY3NTgwOSBDMTguODY3OTM4LDkuMjcwMjcyMzYgMTkuMTg0MTM5NCw4Ljc2OTE0MTk3IDE5LjE4NDEzOTQsOC42MjIyNTg5MiBDMTkuMTg0MTM5NCw4LjU5NjMzODM4IDE5LjA1NTk0OTYsOC42Mzk1MzkyOCAxOC45MTA2Njc5LDguNzE3MzAwODkgQzE4Ljc1Njg0MDEsOC44MDM3MDI2OCAxOC40MTUwMDA3LDguOTMzMzA1MzcgMTguMTU4NjIxMiw5LjAxMTA2Njk4IEwxNy42OTcxMzc5LDkuMTU3OTUwMDMgTDE3LjI3ODM4NDYsOC44NzI4MjQxMiBDMTcuMDQ3NjQzLDguNzE3MzAwODkgMTYuNzIyODk1Niw4LjU0NDQ5NzMxIDE2LjU1MTk3NTksOC40OTI2NTYyMyBDMTYuMTE2MTMwNiw4LjM3MTY5MzczIDE1LjQ0OTU0MzcsOC4zODg5NzQwOCAxNS4wNTY0Mjg0LDguNTI3MjE2OTUgTDE1LjA1NjQyODQsOC41MjcyMTY5NSBaIiBmaWxsPSIjQjVCN0JEIj48L3BhdGg+CiAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPg==')
}

.detail-socials .share-pinterest {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjI2cHgiIGhlaWdodD0iMjZweCIgdmlld0JveD0iMCAwIDI2IDI2IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC01OTQuMDAwMDAwLCAtNzY5LjAwMDAwMCkiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg4My4wMDAwMDAsIDE1Ny4wMDAwMDApIj4KICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDQ0NS4wMDAwMDAsIDYxMi4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg2Ni4wMDAwMDAsIDAuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xMy40MzcwNjg3LDYuMTE3NjQ3MDYgQzkuNzE2MzUwOTQsNi4xMTc2NDcwNiA3Ljg0MDMzNjEzLDguNzg1MjQyODcgNy44NDAzMzYxMywxMS4wMDk3NzYgQzcuODQwMzM2MTMsMTIuMzU2NzA3NSA4LjM1MDI4NDQzLDEzLjU1NDk5NDYgOS40NDQwMjQ4MSwxNC4wMDE1MzY0IEM5LjYyMzM3MjE0LDE0LjA3NDg1ODQgOS43ODQwMTkzMywxNC4wMDQwNTg4IDkuODM2MDMxOCwxMy44MDU0ODk1IEM5Ljg3MjIxNDM4LDEzLjY2ODA2NTIgOS45NTc4MDAxMSwxMy4zMjEzNzM0IDkuOTk1OTgzMTcsMTMuMTc2OTkxIEMxMC4wNDg0MzA1LDEyLjk4MDU5NjEgMTAuMDI4MDc3OCwxMi45MTE3MTAxIDkuODgzMzQ3NDgsMTIuNzQwNTM4NiBDOS41Njc5Njc1NiwxMi4zNjg1MzY0IDkuMzY2NDQxLDExLjg4Njk0MjcgOS4zNjY0NDEsMTEuMjA0Nzc5MiBDOS4zNjY0NDEsOS4yMjU2OTYyNiAxMC44NDcxNDM3LDcuNDUzOTY3MzEgMTMuMjIyMTQ3Niw3LjQ1Mzk2NzMxIEMxNS4zMjUxNzM0LDcuNDUzOTY3MzEgMTYuNDgwNTgwNyw4LjczODk3MDkyIDE2LjQ4MDU4MDcsMTAuNDU1MTIxMyBDMTYuNDgwNTgwNywxMi43MTMxNDA3IDE1LjQ4MTI5NzcsMTQuNjE4OTAxOCAxMy45OTc4MTE4LDE0LjYxODkwMTggQzEzLjE3ODU3MiwxNC42MTg5MDE4IDEyLjU2NTI5NDYsMTMuOTQxMzQ4MSAxMi43NjE4NjM0LDEzLjExMDM2NjQgQzEyLjk5NzIyNDIsMTIuMTE4MzAyNSAxMy40NTMxNTk1LDExLjA0NzYxMTEgMTMuNDUzMTU5NSwxMC4zMzE1MjY1IEMxMy40NTMxNTk1LDkuNjkwNTAzMyAxMy4xMDkwNzcxLDkuMTU1ODUzNDMgMTIuMzk2OTkzNCw5LjE1NTg1MzQzIEMxMS41NTk0ODgzLDkuMTU1ODUzNDMgMTAuODg2NzE4NCwxMC4wMjIyMzUgMTAuODg2NzE4NCwxMS4xODI4NjA5IEMxMC44ODY3MTg0LDExLjkyMjA4MTYgMTEuMTM2NTE3NCwxMi40MjIwMjc1IDExLjEzNjUxNzQsMTIuNDIyMDI3NSBDMTEuMTM2NTE3NCwxMi40MjIwMjc1IDEwLjI3OTQ0MjQsMTYuMDUzNDE5NSAxMC4xMjkyMzI1LDE2LjY4OTM5OCBDOS44MzAwMzAzNiwxNy45NTU5NjI0IDEwLjA4NDI2NTIsMTkuNTA4NTk1NCAxMC4xMDU3NDg2LDE5LjY2NTQxNTUgQzEwLjExODM2MDMsMTkuNzU4MzA3NCAxMC4yMzc3ODAzLDE5Ljc4MDM5OTYgMTAuMjkxODgwMiwxOS43MTAyMDg5IEMxMC4zNjkxMTYxLDE5LjYwOTQwMjEgMTEuMzY2NTcyNSwxOC4zNzc5NzY2IDExLjcwNTY5NzMsMTcuMTQ3NTA3OCBDMTEuODAxNjMzMywxNi43OTkwNzY0IDEyLjI1NjUyNDksMTQuOTk0OTA0OSAxMi4yNTY1MjQ5LDE0Ljk5NDkwNDkgQzEyLjUyODU5MDEsMTUuNTEzODk4OSAxMy4zMjM4MjQyLDE1Ljk3MTA1MTkgMTQuMTY5NTA1MSwxNS45NzEwNTE5IEMxNi42ODY5NzgsMTUuOTcxMDUxOSAxOC4zOTQ5NTI1LDEzLjY3NTk4MDIgMTguMzk0OTUyNSwxMC42MDM5Mzk2IEMxOC4zOTQ5NTI1LDguMjgxMDM1MDggMTYuNDI3NDM3NSw2LjExNzY0NzA2IDEzLjQzNzA2ODcsNi4xMTc2NDcwNiBMMTMuNDM3MDY4Nyw2LjExNzY0NzA2IFoiIGZpbGw9IiNCNUI3QkQiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPg==')
}

@
-moz-keyframes quick_cart_pay_show { 0% {
	-moz-transform: rotate(70deg);
	transform: rotate(70deg);
	right: -100px
}

50
%
{
-moz-transform
:
rotate(
-20deg
);
transform
:
rotate(
-20deg
);
right
:
20px
}
100
%
{
-moz-transform
:
rotate(
0deg
);
transform
:
rotate(
0deg
);
right
:
0
}
}
@
-webkit-keyframes quick_cart_pay_show { 0% {
	-webkit-transform: rotate(70deg);
	transform: rotate(70deg);
	right: -100px
}

50
%
{
-webkit-transform
:
rotate(
-20deg
);
transform
:
rotate(
-20deg
);
right
:
20px
}
100
%
{
-webkit-transform
:
rotate(
0deg
);
transform
:
rotate(
0deg
);
right
:
0
}
}
@
keyframes quick_cart_pay_show { 0% {
	-moz-transform: rotate(70deg);
	-ms-transform: rotate(70deg);
	-webkit-transform: rotate(70deg);
	transform: rotate(70deg);
	right: -100px
}

50
%
{
-moz-transform
:
rotate(
-20deg
);
-ms-transform
:
rotate(
-20deg
);
-webkit-transform
:
rotate(
-20deg
);
transform
:
rotate(
-20deg
);
right
:
20px
}
100
%
{
-moz-transform
:
rotate(
0deg
);
-ms-transform
:
rotate(
0deg
);
-webkit-transform
:
rotate(
0deg
);
transform
:
rotate(
0deg
);
right
:
0
}
}
@
-moz-keyframes quick_cart_pay_hide { 0% {
	-moz-transform: rotate(0deg);
	transform: rotate(0deg);
	right: 0
}

100
%
{
-moz-transform
:
rotate(
70deg
);
transform
:
rotate(
70deg
);
right
:
-100px
}
}
@
-webkit-keyframes quick_cart_pay_hide { 0% {
	-webkit-transform: rotate(0deg);
	transform: rotate(0deg);
	right: 0
}

100
%
{
-webkit-transform
:
rotate(
70deg
);
transform
:
rotate(
70deg
);
right
:
-100px
}
}
@
keyframes quick_cart_pay_hide { 0% {
	-moz-transform: rotate(0deg);
	-ms-transform: rotate(0deg);
	-webkit-transform: rotate(0deg);
	transform: rotate(0deg);
	right: 0
}

100
%
{
-moz-transform
:
rotate(
70deg
);
-ms-transform
:
rotate(
70deg
);
-webkit-transform
:
rotate(
70deg
);
transform
:
rotate(
70deg
);
right
:
-100px
}
}
.homepage .bg {
	background-color: #f7f7fa;
	background-repeat: no-repeat;
	background-position: center -130px
}

.homepage .collection-list {
	margin-top: 0;
	padding: 310px 0 40px
}

.homepage .homepage-banners {
	padding: 40px 0 0
}

.homepage .more-products {
	padding-top: 0;
	position: relative;
	top: 24px
}

.homepage .main-services {
	padding: 74px 0 44px
}

.homepage .main-services li {
	display: block;
	float: left;
	width: 33.33333%
}

.homepage .main-services li:nth-child(2) {
	text-align: center
}

.homepage .main-services li:nth-child(3) {
	text-align: right
}

.homepage .main-services span {
	font-family: "montserratregular", sans-serif;
	font-size: 138.46154%;
	line-height: 144.44444%;
	background: transparent no-repeat left center;
	color: #020E20;
	display: inline-block
}

.homepage .main-services .shipping {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjMycHgiIGhlaWdodD0iMjJweCIgdmlld0JveD0iMCAwIDMyIDIyIiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC01ODcuMDAwMDAwLCAtMTI5NC4wMDAwMDApIiBzdHJva2U9IiMwODZGQ0YiIHN0cm9rZS13aWR0aD0iMiI+CiAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zLjAwMDAwMCwgMTI0Ni4wMDAwMDApIj4KICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDU5MS4wMDAwMDAsIDQ5LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0yNywxNyBMMzAsMTcgTDMwLDEwIEwyOCw0IEwxOSw0IEwxOSwxNyBMMjEsMTciPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMjcsMTcgQzI3LDE4LjY1NyAyNS42NTcsMjAgMjQsMjAgQzIyLjM0MywyMCAyMSwxOC42NTcgMjEsMTcgQzIxLDE1LjM0MyAyMi4zNDMsMTQgMjQsMTQgQzI1LjY1NywxNCAyNywxNS4zNDMgMjcsMTcgTDI3LDE3IFoiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMTAsMTcgTDE5LDE3IEwxOSwwIEwwLDAgTDAsMTcgTDQsMTciPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMTAsMTcgQzEwLDE4LjY1NyA4LjY1NywyMCA3LDIwIEM1LjM0MywyMCA0LDE4LjY1NyA0LDE3IEM0LDE1LjM0MyA1LjM0MywxNCA3LDE0IEM4LjY1NywxNCAxMCwxNS4zNDMgMTAsMTcgTDEwLDE3IFoiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMTUsNCBMOSwxMCBMNSw2Ij48L3BhdGg+CiAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPg==');
	padding-left: 40px
}

.homepage .main-services .brands {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjI2cHgiIGhlaWdodD0iMjdweCIgdmlld0JveD0iMCAwIDI2IDI3IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC02NTIuMDAwMDAwLCAtMTI5Mi4wMDAwMDApIiBzdHJva2U9IiMwODZGQ0YiIHN0cm9rZS13aWR0aD0iMiI+CiAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zLjAwMDAwMCwgMTI0Ni4wMDAwMDApIj4KICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDY1Ny4wMDAwMDAsIDQ3LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xMi4zNTQ5LDE3LjExNDIgTDE2LjI3NTksMjMuMDAwMiBMMTcuNjYzOSwxOS42NzIyIEwyMS4yNjg5LDE5LjY3MzIgTDE3LjU3NzksMTQuMTMyMiI+PC9wYXRoPgogICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik05LjY0NTEsMTcuMTE0MiBMNS43MjQxLDIzLjAwMDIgTDQuMzM2MSwxOS42NzIyIEwwLjczMTEsMTkuNjczMiBMNC40MjIxLDE0LjEzMjIiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMTIuMjM0MiwwLjQ5MDYgTDE0LjAyNzIsMS43ODQ2IEwxNi4yMDkyLDIuMTM3NiBDMTcuMTA2MiwyLjI4MjYgMTcuODA5MiwyLjk4NTYgMTcuOTU0MiwzLjg4MjYgTDE4LjMwNzIsNi4wNjQ2IEwxOS42MDEyLDcuODU3NiBDMjAuMTMzMiw4LjU5NDYgMjAuMTMzMiw5LjU4OTYgMTkuNjAxMiwxMC4zMjU2IEwxOC4zMDcyLDEyLjExODYgTDE3Ljk1NDIsMTQuMzAxNiBDMTcuODA5MiwxNS4xOTg2IDE3LjEwNjIsMTUuOTAxNiAxNi4yMDkyLDE2LjA0NjYgTDE0LjAyNzIsMTYuMzk5NiBMMTIuMjM0MiwxNy42OTI2IEMxMS40OTcyLDE4LjIyNDYgMTAuNTAzMiwxOC4yMjQ2IDkuNzY2MiwxNy42OTI2IEw3Ljk3MzIsMTYuMzk5NiBMNS43OTEyLDE2LjA0NjYgQzQuODkzMiwxNS45MDE2IDQuMTkwMiwxNS4xOTg2IDQuMDQ1MiwxNC4zMDE2IEwzLjY5MjIsMTIuMTE4NiBMMi4zOTkyLDEwLjMyNTYgQzEuODY3Miw5LjU4OTYgMS44NjcyLDguNTk0NiAyLjM5OTIsNy44NTc2IEwzLjY5MjIsNi4wNjQ2IEw0LjA0NTIsMy44ODI2IEM0LjE5MDIsMi45ODU2IDQuODkzMiwyLjI4MjYgNS43OTEyLDIuMTM3NiBMNy45NzMyLDEuNzg0NiBMOS43NjYyLDAuNDkwNiBDMTAuNTAzMiwtMC4wNDE0IDExLjQ5NzIsLTAuMDQxNCAxMi4yMzQyLDAuNDkwNiBMMTIuMjM0MiwwLjQ5MDYgWiI+PC9wYXRoPgogICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4=');
	padding-left: 32px
}

.homepage .main-services .support {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjI1cHgiIGhlaWdodD0iMjdweCIgdmlld0JveD0iMCAwIDI1IDI3IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC03MTUuMDAwMDAwLCAtMTI5MS4wMDAwMDApIj4KICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTMuMDAwMDAwLCAxMjQ2LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoNzE5LjAwMDAwMCwgNDYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTEwLDkuMzI3IEMxMS42NTcsOS4zMjcgMTMsMTAuNjcgMTMsMTIuMzI3IEMxMywxMy45ODQgMTEuNjU3LDE1LjMyNyAxMCwxNS4zMjcgQzguMzQzLDE1LjMyNyA3LDEzLjk4NCA3LDEyLjMyNyBDNywxMC42NyA4LjM0Myw5LjMyNyAxMCw5LjMyNyBMMTAsOS4zMjcgWiIgc3Ryb2tlPSIjMDg2RkNGIiBzdHJva2Utd2lkdGg9IjIiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMTUuNSwxNS4zMjcgQzE2LjMyOCwxNS4zMjcgMTcsMTUuOTk5IDE3LDE2LjgyNyBDMTcsMTcuNjU1IDE2LjMyOCwxOC4zMjcgMTUuNSwxOC4zMjcgQzE0LjY3MiwxOC4zMjcgMTQsMTcuNjU1IDE0LDE2LjgyNyBDMTQsMTUuOTk5IDE0LjY3MiwxNS4zMjcgMTUuNSwxNS4zMjciIGZpbGw9IiMwODZGQ0YiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMTAsOS4zMjcgTDEwLDAiIHN0cm9rZT0iIzA4NkZDRiIgc3Ryb2tlLXdpZHRoPSIyIj48L3BhdGg+CiAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTEyLjI0NDksMTQuNTMxMSBMMTUuNDI4OSwxNi43MzUxIiBzdHJva2U9IiMwODZGQ0YiIHN0cm9rZS13aWR0aD0iMiI+PC9wYXRoPgogICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xNSwyNS4zMjcgTDE1LDIxLjMyNyBMMTYsMjEuMzI3IEMxOCwyMS4zMjcgMjAsMTkuMzA5IDIwLDE3LjMyNyBMMjAsMTUuMDc3IEMyMCwxNS4wNzcgMjEuMTA0LDE0Ljc4NiAyMS42OTQsMTQuNjE3IEMyMi40NTYsMTQuNCAyMi42MywxMy41NzIgMjIuMjgxLDEyLjg4OSBDMjEuOTcsMTIuMjggMTkuNTksNy41MDcgMTkuNTksNy41MDcgQzE5LjU5LDcuNTA3IDE4LjE5OSwwLjMyNyAxMCwwLjMyNyBDNC40NzcsMC4zMjcgMCw0LjgwNCAwLDEwLjMyNyBDMCwxNC4xMTIgMywxNi45MDEgMywyMC40NjMgTDMsMjUuMzI3IiBzdHJva2U9IiMwODZGQ0YiIHN0cm9rZS13aWR0aD0iMiI+PC9wYXRoPgogICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4=');
	padding-left: 33px
}

.homepage .main-text {
	-moz-box-shadow: rgba(17, 17, 18, 0.04) 0 4px 4px -2px,
		rgba(19, 20, 20, 0.06) 0 3px 1px -2px;
	-webkit-box-shadow: rgba(17, 17, 18, 0.04) 0 4px 4px -2px,
		rgba(19, 20, 20, 0.06) 0 3px 1px -2px;
	box-shadow: rgba(17, 17, 18, 0.04) 0 4px 4px -2px,
		rgba(19, 20, 20, 0.06) 0 3px 1px -2px;
	border-top: 1px solid #f7f7fa;
	padding-top: 56px;
	position: relative;
	text-align: center;
	z-index: 2
}

.homepage .main-text h1 {
	font-family: "montserratbold", sans-serif;
	font-size: 492.30769%;
	line-height: 106.25%;
	letter-spacing: 14px;
	margin-bottom: 34px
}

.homepage .main-text p {
	font-size: 107.69231%;
	line-height: 171.42857%
}

.homepage .main-text .links {
	padding: 44px 0 128px
}

.homepage .main-text .links .about {
	font-family: "montserratbold", sans-serif;
	font-size: 107.69231%;
	line-height: 128.57143%;
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE2cHgiIGhlaWdodD0iMTBweCIgdmlld0JveD0iMCAwIDE2IDEwIiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC00ODUuMDAwMDAwLCAtMTM5MC4wMDAwMDApIiBmaWxsPSIjMDg2RkNGIj4KICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMC4wMDAwMDAsIDk1Mi4wMDAwMDApIj4KICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDI4NS4wMDAwMDAsIDc2LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDAuMDAwMDAwLCAzNTguMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0yMTIuMzY0Njk0LDkuNzQ1NDg5NzkgTDIwOS4xNjQzMDYsMTIuOTQ1ODc3NCBMMjEwLjIxODgwMSwxNCBMMjE1LjIxODgwMSw5IEwyMTAuMjE4ODAxLDQgTDIwOS4xNjQzMDYsNS4wNTQxMjI1NiBMMjEyLjM2NDY5NCw4LjI1NDUxMDIxIEwyMDAsOC4yNTQ1MTAyMSBMMjAwLDkuNzQ1NDg5NzkgTDIxMi4zNjQ2OTQsOS43NDU0ODk3OSBMMjEyLjM2NDY5NCw5Ljc0NTQ4OTc5IFoiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPg==')
		no-repeat right center;
	color: #020E20;
	display: inline-block;
	float: left;
	letter-spacing: 1px;
	margin-top: 10px;
	padding-right: 21px;
	text-transform: uppercase
}

.homepage .main-text .links .about:hover {
	text-decoration: underline
}

.homepage .main-text .links .socials {
	display: block;
	float: right
}

.socials {
	color: #edeff2
}

.socials strong {
	opacity: 0.4
}

.socials ul {
	display: inline-block
}

.socials li {
	float: left;
	margin-left: 28px
}

.socials a {
	background: transparent no-repeat left top;
	display: inline-block;
	opacity: 0.65;
	overflow: hidden;
	position: relative;
	text-indent: 100px;
	top: 12px
}

.socials a:hover {
	opacity: 1
}

.socials .tw {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE2cHgiIGhlaWdodD0iMTRweCIgdmlld0JveD0iMCAwIDE2IDE0IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0xMDQ1LjAwMDAwMCwgLTE1OTEuMDAwMDAwKSIgZmlsbD0iI0ZGRkZGRiI+CiAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zLjAwMDAwMCwgMTI0Ni4wMDAwMDApIj4KICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDAuMDAwMDAwLCAxNDYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTA0MC4wMDAwMDAsIDE5MC4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICAgICAgPGc+CiAgICAgICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMTguMjIyNTA4OSw5Ljc1MDk3NjAxIEMxNi44MjU1Njg5LDEwLjI1OTQxNzMgMTUuOTQyNzAyOSwxMS41NzAwNjYgMTYuMDQzMjgyNiwxMy4wMDUwMDA0IEwxNi4wNzY4MDkxLDEzLjU1ODYzNjUgTDE1LjUxODAzMzEsMTMuNDkwODQ0MyBDMTMuNDg0MDg4NSwxMy4yMzA5NzQzIDExLjcwNzE4MDksMTIuMzQ5Njc2MSAxMC4xOTg0ODU4LDEwLjg2OTU0NjkgTDkuNDYwOTAxNDcsMTAuMTM1MTMxNyBMOS4yNzA5MTc2MywxMC42Nzc0NjkxIEM4Ljg2ODU5ODkyLDExLjg4NjQyOTUgOS4xMjU2MzU4OCwxMy4xNjMxODIyIDkuOTYzNzk5ODUsMTQuMDIxODgzIEMxMC40MTA4MjA2LDE0LjQ5NjQyODMgMTAuMzEwMjQxLDE0LjU2NDIyMDQgOS41MzkxMzAxLDE0LjI4MTc1MyBDOS4yNzA5MTc2MywxNC4xOTEzNjM1IDkuMDM2MjMxNzIsMTQuMTIzNTcxMyA5LjAxMzg4MDY4LDE0LjE1NzQ2NzQgQzguOTM1NjUyMDQsMTQuMjM2NTU4MyA5LjIwMzg2NDUxLDE1LjI2NDczOTYgOS40MTYxOTkzOSwxNS42NzE0OTI2IEM5LjcwNjc2MjksMTYuMjM2NDI3NCAxMC4yOTkwNjU0LDE2Ljc5MDA2MzUgMTAuOTQ3MjQ1NiwxNy4xMTc3MjU3IEwxMS40OTQ4NDYsMTcuMzc3NTk1NyBMMTAuODQ2NjY1OSwxNy4zODg4OTQ0IEMxMC4yMjA4MzY4LDE3LjM4ODg5NDQgMTAuMTk4NDg1OCwxNy40MDAxOTMxIDEwLjI2NTUzODksMTcuNjM3NDY1NyBDMTAuNDg5MDQ5MywxOC4zNzE4ODA5IDExLjM3MTkxNTMsMTkuMTUxNDkxIDEyLjM1NTM2MTEsMTkuNDkwNDUxOCBMMTMuMDQ4MjQzMywxOS43Mjc3MjQ0IEwxMi40NDQ3NjUyLDIwLjA4OTI4MjcgQzExLjU1MDcyMzYsMjAuNjA5MDIyNyAxMC41MDAyMjQ4LDIwLjkwMjc4ODggOS40NDk3MjU5NSwyMC45MjUzODYyIEM4Ljk0NjgyNzU2LDIwLjkzNjY4NDkgOC41MzMzMzMzMywyMC45ODE4Nzk3IDguNTMzMzMzMzMsMjEuMDE1Nzc1OCBDOC41MzMzMzMzMywyMS4xMjg3NjI3IDkuODk2NzQ2NzMsMjEuNzYxNDg5NyAxMC42OTAyMDg2LDIyLjAxMDA2MSBDMTMuMDcwNTk0MywyMi43NDQ0NzYyIDE1Ljg5ODAwMDgsMjIuNDI4MTEyOCAxOC4wMjEzNDk1LDIxLjE3Mzk1NzUgQzE5LjUzMDA0NDcsMjAuMjgxMzYwNSAyMS4wMzg3Mzk4LDE4LjUwNzQ2NTMgMjEuNzQyNzk3NiwxNi43OTAwNjM1IEMyMi4xMjI3NjUzLDE1Ljg3NDg2OTIgMjIuNTAyNzMyOSwxNC4yMDI2NjIyIDIyLjUwMjczMjksMTMuNDAwNDU0OCBDMjIuNTAyNzMyOSwxMi44ODA3MTQ4IDIyLjUzNjI1OTUsMTIuODEyOTIyNiAyMy4xNjIwODg2LDEyLjE5MTQ5NDMgQzIzLjUzMDg4MDcsMTEuODI5OTM2IDIzLjg3NzMyMTgsMTEuNDM0NDgxNyAyMy45NDQzNzUsMTEuMzIxNDk0NyBDMjQuMDU2MTMwMiwxMS4xMDY4MTk1IDI0LjA0NDk1NDYsMTEuMTA2ODE5NSAyMy40NzUwMDMxLDExLjI5ODg5NzMgQzIyLjUyNTA4NCwxMS42Mzc4NTgyIDIyLjM5MDk3NzcsMTEuNTkyNjYzNCAyMi44NjAzNDk2LDExLjA4NDIyMjEgQzIzLjIwNjc5MDcsMTAuNzIyNjYzOSAyMy42MjAyODQ5LDEwLjA2NzMzOTUgMjMuNjIwMjg0OSw5Ljg3NTI2MTY3IEMyMy42MjAyODQ5LDkuODQxMzY1NTggMjMuNDUyNjUyMSw5Ljg5Nzg1OTA2IDIzLjI2MjY2ODMsOS45OTk1NDczMiBDMjMuMDYxNTA4OSwxMC4xMTI1MzQzIDIyLjYxNDQ4ODEsMTAuMjgyMDE0NyAyMi4yNzkyMjI1LDEwLjM4MzcwMyBMMjEuNjc1NzQ0NSwxMC41NzU3ODA4IEwyMS4xMjgxNDQsMTAuMjAyOTIzOCBDMjAuODI2NDA1LDkuOTk5NTQ3MzIgMjAuNDAxNzM1Miw5Ljc3MzU3MzQgMjAuMTc4MjI0OCw5LjcwNTc4MTIzIEMxOS42MDgyNzMzLDkuNTQ3NTk5NDkgMTguNzM2NTgyOCw5LjU3MDE5Njg4IDE4LjIyMjUwODksOS43NTA5NzYwMSBMMTguMjIyNTA4OSw5Ljc1MDk3NjAxIFoiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgPC9nPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+');
	height: 14px;
	top: 10px;
	width: 16px
}

.socials .fb {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjlweCIgaGVpZ2h0PSIxOHB4IiB2aWV3Qm94PSIwIDAgOSAxOCIgdmVyc2lvbj0iMS4xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4bWxuczpza2V0Y2g9Imh0dHA6Ly93d3cuYm9oZW1pYW5jb2RpbmcuY29tL3NrZXRjaC9ucyI+CiAgICA8ZyBzdHJva2U9Im5vbmUiIHN0cm9rZS13aWR0aD0iMSIgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj4KICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMTA5My4wMDAwMDAsIC0xNTg5LjAwMDAwMCkiIGZpbGw9IiNGRkZGRkYiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMy4wMDAwMDAsIDEyNDYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgwLjAwMDAwMCwgMTQ2LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDEwNDAuMDAwMDAwLCAxOTAuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDQ0LjMwNzY5MiwgMC4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xMy43NDE0NDg5LDI0LjcwMzgyNTYgTDEzLjc0MTQ0ODksMTUuOTk5MzIwNiBMMTEuOTQ0NjYzOCwxNS45OTkzMjA2IEwxMS45NDQ2NjM4LDEyLjk5OTU4MjkgTDEzLjc0MTQ0ODksMTIuOTk5NTgyOSBMMTMuNzQxNDQ4OSwxMS4xOTg1NTEyIEMxMy43NDE0NDg5LDguNzUxMzY5OTUgMTQuNzU2MDI2MSw3LjI5NjE3NDQzIDE3LjYzODU2LDcuMjk2MTc0NDMgTDIwLjAzODM1MDIsNy4yOTYxNzQ0MyBMMjAuMDM4MzUwMiwxMC4yOTYyNTE5IEwxOC41MzgzMTE1LDEwLjI5NjI1MTkgQzE3LjQxNjIxMjUsMTAuMjk2MjUxOSAxNy4zNDE5ODM0LDEwLjcxNTQ2NzcgMTcuMzQxOTgzNCwxMS40OTc4NDU1IEwxNy4zMzc5MDY4LDEyLjk5OTI0MzEgTDIwLjA1NTMzNjIsMTIuOTk5MjQzMSBMMTkuNzM3MzU3MiwxNS45OTg5ODA4IEwxNy4zMzc5MDY4LDE1Ljk5ODk4MDggTDE3LjMzNzkwNjgsMjQuNzAzODI1NiBMMTMuNzQxNDQ4OSwyNC43MDM4MjU2IFoiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgPC9nPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+');
	height: 18px;
	width: 9px;
	top: 11px
}

.socials .in {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE3cHgiIGhlaWdodD0iMThweCIgdmlld0JveD0iMCAwIDE3IDE4IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0xMTMzLjAwMDAwMCwgLTE1ODkuMDAwMDAwKSIgZmlsbD0iI0ZGRkZGRiI+CiAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zLjAwMDAwMCwgMTI0Ni4wMDAwMDApIj4KICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDAuMDAwMDAwLCAxNDYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTA0MC4wMDAwMDAsIDE5MC4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoODguNjE1Mzg1LCAwLjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoNy4zODQ2MTUsIDcuMzg0NjE1KSI+CiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTE1LjEyNDk5NDcsMTYuNzUxMzgwOCBMMi4xMDU3NzQ1MywxNi43NTEzODA4IEMyLjA3MTE1ODIxLDE2Ljc0NTgwNSAyLjAzNjMwOTU3LDE2LjczOTA2NzYgMi4wMDE2OTMyNSwxNi43MzQ4ODU4IEMxLjI4NTkwMjE1LDE2LjY0Mjg4NTQgMC42ODQxODIyNzMsMTYuMDk2NDU4NyAwLjUyNDgwNzgxOSwxNS4zOTE1ODY4IEMwLjUwNjIyMTg3NywxNS4zMDkzNDQgMC40OTQzNzMzMzksMTUuMjI1OTM5NiAwLjQ3OTUwNDU4NSwxNS4xNDMyMzIyIEwwLjQ3OTUwNDU4NSwyLjA4ODIzNDA0IEMwLjQ4NDg0ODA0MywyLjA1Nzc5OTU2IDAuNDkxMTIwNzk5LDIuMDI3NTk3NDEgMC40OTUzMDI2MzYsMS45OTcxNjI5MyBDMC41OTc5ODk5NjYsMS4yNjY3MzU0IDEuMTMxNDA2NTEsMC42ODYxNTcwMyAxLjg1MjMwODc0LDAuNTIxOTAzNzY2IEMxLjkyOTkwNTA1LDAuNTA0MjQ3MTIgMi4wMDkxMjc2MywwLjQ5MzU2MDIwNCAyLjA4Nzg4NTU2LDAuNDc5Mzg4NDIzIEwxNS4xNDI4ODM3LDAuNDc5Mzg4NDIzIEMxNS4xNzMwODU4LDAuNDg0NzMxODgxIDE1LjIwMzA1NTcsMC40OTE0NjkyODUgMTUuMjMzNzIyNSwwLjQ5NTQxODc5OCBDMTUuOTcyMjgxMywwLjU5NjQ3OTg1OSAxNi41NzM3Njg5LDEuMTYyNDIxOCAxNi43MTYxODM3LDEuODkxNjg3NyBDMTYuNzMwMTIzMSwxLjk2Mjc3ODkzIDE2LjczOTg4MDgsMi4wMzQzMzQ4MSAxNi43NTEyNjQ2LDIuMTA1NjU4MzYgTDE2Ljc1MTI2NDYsMTUuMTI1MTEwOSBDMTYuNzM5NDE2MSwxNS4xOTc1OTYgMTYuNzI5MTkzOCwxNS4yNzEwMTA1IDE2LjcxNTI1NDQsMTUuMzQzMjYzNCBDMTYuNTg1Mzg1MSwxNi4wMTE2NjAzIDE2LjA0MjQ0MzMsMTYuNTY1OTg2IDE1LjM3Nzk5NTgsMTYuNzA3MDA2OSBDMTUuMjk0MzU5MSwxNi43MjUxMjgyIDE1LjIwOTU2MDcsMTYuNzM2OTc2NyAxNS4xMjQ5OTQ3LDE2Ljc1MTM4MDggWiBNMi4yMzk4MjU2Myw3LjA3NzE2NTU4IEwyLjIzOTgyNTYzLDcuMTIxMDc0ODYgQzIuMjM5ODI1NjMsOS41MjkxMTYgMi4yMzk1OTMzMSwxMS45MzcxNTcxIDIuMjQwMDU3OTYsMTQuMzQ1MTk4MyBDMi4yNDAwNTc5NiwxNC42OTE1OTM4IDIuNTM5OTg4NiwxNC45ODk0MzM1IDIuODg2Mzg0MSwxNC45ODk0MzM1IEM2LjcwNDg2NTkyLDE0Ljk4OTY2NTggMTAuNTIzMTE1NCwxNC45ODk2NjU4IDE0LjM0MTU5NzIsMTQuOTg5NDMzNSBDMTQuNjkxMjQ1MywxNC45ODk0MzM1IDE0Ljk4OTU0OTcsMTQuNjkyMDU4NCAxNC45ODk1NDk3LDE0LjM0MzEwNzMgQzE0Ljk4OTc4MiwxMS45Mzc4NTQxIDE0Ljk4OTU0OTcsOS41MzI4MzMxOSAxNC45ODk1NDk3LDcuMTI3ODEyMjcgTDE0Ljk4OTU0OTcsNy4wNzc4NjI1NSBMMTMuNDM2MjI5NSw3LjA3Nzg2MjU1IEMxMy42NTU1NDM3LDcuNzc4Nzg0ODkgMTMuNzIyOTE3Nyw4LjQ5MTc4ODEgMTMuNjM2OTU3Nyw5LjIxODQ5ODQ0IEMxMy41NTA1MzMxLDkuOTQ1NDQxMSAxMy4zMTYzNTAyLDEwLjYyMTk2OTQgMTIuOTM0ODczNywxMS4yNDY2ODk0IEMxMi41NTMxNjUsMTEuODcyMTA2MyAxMi4wNTgzMTQyLDEyLjM5MDE4OTUgMTEuNDUyNDEyNSwxMi44MDI1NjUxIEM5Ljg4MTkwMDQxLDEzLjg3MjE4NiA3LjgxNDIxNDM0LDEzLjk2NjI3NzQgNi4xNDc3NTIzLDEzLjAzMDkzOTggQzUuMzA1MzQ0NDcsMTIuNTU4NjI0NiA0LjY0MzkxNzI2LDExLjg5OTk4NTIgNC4xODI3NTM1NywxMS4wNTEzMDQ3IEMzLjQ5NDg0MTM4LDkuNzg0OTA1MDMgMy4zODQ5NTIsOC40NTU3Nzc4NCAzLjc4ODQ5OTI3LDcuMDc2NzAwOTMgQzMuMjczMjA0MDIsNy4wNzcxNjU1OCAyLjc1OTk5OTY5LDcuMDc3MTY1NTggMi4yMzk4MjU2Myw3LjA3NzE2NTU4IFogTTguNjE1NTAwNzgsNS4zMTgwMDYxNSBDNi44MTA4MDU3OSw1LjMxNjg0NDUzIDUuMzQzNjc3OTgsNi43Njg4NzEyNiA1LjMxODM1NDYzLDguNTY1NDM0OSBDNS4yOTIzMzQzMSwxMC40MTAzMjIgNi43NjkyMTk3NSwxMS44NzI4MDMzIDguNTM5NzYzMDYsMTEuOTEwOTA0NSBDMTAuMzgyMDk0NiwxMS45NTAzOTk2IDExLjg3MjIyMjUsMTAuNDc4MzkzIDExLjkxMTAyMDcsOC42ODgxMDIxMSBDMTEuOTUwNzQ4MSw2Ljg0MTgyMTA4IDEwLjQ2MTU0OTUsNS4zMTY4NDQ1MyA4LjYxNTUwMDc4LDUuMzE4MDA2MTUgWiBNMTMuNTYwMDU4NCw0LjY1NzA0MzU4IEwxMy41NjAwNTg0LDQuNjU0MDIzMzYgQzEzLjgyNzY5NTksNC42NTQwMjMzNiAxNC4wOTYyNjI4LDQuNjU5MTM0NSAxNC4zNjQxMzI3LDQuNjUyNjI5NDIgQzE0LjcwODY2OTYsNC42NDQwMzM0MiAxNC45ODkzMTczLDQuMzQ4NzQ5MjYgMTQuOTg5MzE3Myw0LjAwMzc0NzcxIEMxNC45ODk1NDk3LDMuNDkwMDc4NzMgMTQuOTg5NTQ5NywyLjk3NjE3NzQzIDE0Ljk4OTMxNzMsMi40NjI1MDg0NSBDMTQuOTg5MzE3MywyLjA5NDA0MjE1IDE0LjY5Nzc1MDQsMS44MDA4NDg5MSAxNC4zMjk3NDg3LDEuODAwNjE2NTkgQzEzLjgxNzQ3MzcsMS44MDAzODQyNiAxMy4zMDUxOTg2LDEuODAwMTUxOTQgMTIuNzkyNjkxMywxLjgwMDYxNjU5IEMxMi40MjU2MTg5LDEuODAxMDgxMjQgMTIuMTMzMTIyNywyLjA5NDk3MTQ1IDEyLjEzMjg5MDMsMi40NjM0Mzc3NSBDMTIuMTMyNjU4LDIuOTcyNjkyNTcgMTIuMTMxMjY0MSwzLjQ4MTk0NzM4IDEyLjEzNDc0ODksMy45OTE0MzQ1MiBDMTIuMTM1MjEzNiw0LjA2NzQwNDU2IDEyLjE0OTYxNzcsNC4xNDYzOTQ4MiAxMi4xNzM3Nzk0LDQuMjE4NDE1MzQgQzEyLjI2NTc3OTgsNC40ODk1Mzc3NyAxMi41MTQxMzQ1LDQuNjU1ODgxOTYgMTIuODE4MjQ3LDQuNjU3Mjc1OSBDMTMuMDY1NDQsNC42NTc3NDA1NSAxMy4zMTI2MzMsNC42NTcwNDM1OCAxMy41NjAwNTg0LDQuNjU3MDQzNTggWiI+PC9wYXRoPgogICAgICAgICAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4=');
	height: 18px;
	width: 17px
}

.socials .pi {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE0cHgiIGhlaWdodD0iMThweCIgdmlld0JveD0iMCAwIDE0IDE4IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0xMTc5LjAwMDAwMCwgLTE1ODkuMDAwMDAwKSIgZmlsbD0iI0ZGRkZGRiI+CiAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zLjAwMDAwMCwgMTI0Ni4wMDAwMDApIj4KICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDAuMDAwMDAwLCAxNDYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTA0MC4wMDAwMDAsIDE5MC4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTMyLjkyMzA3NywgMC4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xNi40MTc3MDg4LDcuMDg1NTQ2NDMgQzExLjU1MjE1NDgsNy4wODU1NDY0MyA5LjA5ODkwNDY3LDEwLjU3Mzk0MSA5LjA5ODkwNDY3LDEzLjQ4Mjk0NTggQzkuMDk4OTA0NjcsMTUuMjQ0MzE3NyA5Ljc2NTc2MDEzLDE2LjgxMTMwODcgMTEuMTk2MDM2LDE3LjM5NTI0NzkgQzExLjQzMDU2NzEsMTcuNDkxMTMwNCAxMS42NDA2NDQyLDE3LjM5ODU0NjQgMTEuNzA4NjYwNSwxNy4xMzg4Nzg4IEMxMS43NTU5NzYyLDE2Ljk1OTE3MDIgMTEuODY3ODk2LDE2LjUwNTgwNCAxMS45MTc4Mjc3LDE2LjMxNjk5NjIgQzExLjk4NjQxMjcsMTYuMDYwMTcyMSAxMS45NTk3OTc2LDE1Ljk3MDA5MDMgMTEuNzcwNTM0OSwxNS43NDYyNTA3IEMxMS4zNTgxMTUsMTUuMjU5Nzg2MyAxMS4wOTQ1ODAzLDE0LjYzMDAxIDExLjA5NDU4MDMsMTMuNzM3OTUwMSBDMTEuMDk0NTgwMywxMS4xNDk5MTg1IDEzLjAzMDg4MzgsOC44MzMwNDIxNCAxNi4xMzY2NTgyLDguODMzMDQyMTQgQzE4Ljg4Njc2ODcsOC44MzMwNDIxNCAyMC4zOTc2ODYsMTAuNTEzNDMxNSAyMC4zOTc2ODYsMTIuNzU3NjI4MiBDMjAuMzk3Njg2LDE1LjcxMDQyMjggMTkuMDkwOTMxNCwxOC4yMDI1NzE4IDE3LjE1MDk4ODIsMTguMjAyNTcxOCBDMTYuMDc5Njc0NiwxOC4yMDI1NzE4IDE1LjI3NzY5NjUsMTcuMzE2NTQwMSAxNS41MzQ3NDgsMTYuMjI5ODcxNyBDMTUuODQyNTI3NSwxNC45MzI1NTc0IDE2LjQzODc1MDYsMTMuNTMyNDIyNSAxNi40Mzg3NTA2LDEyLjU5NjAwNDEgQzE2LjQzODc1MDYsMTEuNzU3NzQzMSAxNS45ODg3OTY2LDExLjA1ODU4NTUgMTUuMDU3NjEwMywxMS4wNTg1ODU1IEMxMy45NjI0MTE0LDExLjA1ODU4NTUgMTMuMDgyNjM1MywxMi4xOTE1NDYgMTMuMDgyNjM1MywxMy43MDkyODc3IEMxMy4wODI2MzUzLDE0LjY3NTk2MDggMTMuNDA5Mjk1NSwxNS4zMjk3MzYyIDEzLjQwOTI5NTUsMTUuMzI5NzM2MiBDMTMuNDA5Mjk1NSwxNS4zMjk3MzYyIDEyLjI4ODUwNTIsMjAuMDc4NDc5NiAxMi4wOTIwNzY4LDIwLjkxMDE0MzggQzExLjcwMDgxMjUsMjIuNTY2NDIwMyAxMi4wMzMyNzM0LDI0LjU5Njc4NjUgMTIuMDYxMzY3MSwyNC44MDE4NTkxIEMxMi4wNzc4NTk0LDI0LjkyMzMzMyAxMi4yMzQwMjM5LDI0Ljk1MjIyMjkgMTIuMzA0NzcsMjQuODYwNDM1IEMxMi40MDU3NzA3LDI0LjcyODYxMDcgMTMuNzEwMTM2OCwyMy4xMTgyODUgMTQuMTUzNjA3NywyMS41MDkyMTA0IEMxNC4yNzkwNjI1LDIxLjA1MzU2OTUgMTQuODczOTIwOCwxOC42OTQyNjgzIDE0Ljg3MzkyMDgsMTguNjk0MjY4MyBDMTUuMjI5Njk4MywxOS4zNzI5NTI3IDE2LjI2OTYxOTgsMTkuOTcwNzY4MiAxNy4zNzU1MTAyLDE5Ljk3MDc2ODIgQzIwLjY2NzU5MDIsMTkuOTcwNzY4MiAyMi45MDEwOTUzLDE2Ljk2OTUyMDUgMjIuOTAxMDk1MywxMi45NTIyMzY3IEMyMi45MDEwOTUzLDkuOTE0NTkyMzEgMjAuMzI4MTkxMSw3LjA4NTU0NjQzIDE2LjQxNzcwODgsNy4wODU1NDY0MyBMMTYuNDE3NzA4OCw3LjA4NTU0NjQzIFoiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgPC9nPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+');
	height: 18px;
	width: 14px
}

.socials.dark {
	color: #b5b6bd
}

.socials.dark strong {
	opacity: 1
}

.socials.dark a {
	opacity: 1
}

.socials.dark .tw {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE2cHgiIGhlaWdodD0iMTRweCIgdmlld0JveD0iMCAwIDE2IDE0IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0xMDQ1LjAwMDAwMCwgLTE1OTEuMDAwMDAwKSIgZmlsbD0iI0I1QjZCRCI+CiAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zLjAwMDAwMCwgMTI0Ni4wMDAwMDApIj4KICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDAuMDAwMDAwLCAxNDYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTA0MC4wMDAwMDAsIDE5MC4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICAgICAgPGc+CiAgICAgICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMTguMjIyNTA4OSw5Ljc1MDk3NjAxIEMxNi44MjU1Njg5LDEwLjI1OTQxNzMgMTUuOTQyNzAyOSwxMS41NzAwNjYgMTYuMDQzMjgyNiwxMy4wMDUwMDA0IEwxNi4wNzY4MDkxLDEzLjU1ODYzNjUgTDE1LjUxODAzMzEsMTMuNDkwODQ0MyBDMTMuNDg0MDg4NSwxMy4yMzA5NzQzIDExLjcwNzE4MDksMTIuMzQ5Njc2MSAxMC4xOTg0ODU4LDEwLjg2OTU0NjkgTDkuNDYwOTAxNDcsMTAuMTM1MTMxNyBMOS4yNzA5MTc2MywxMC42Nzc0NjkxIEM4Ljg2ODU5ODkyLDExLjg4NjQyOTUgOS4xMjU2MzU4OCwxMy4xNjMxODIyIDkuOTYzNzk5ODUsMTQuMDIxODgzIEMxMC40MTA4MjA2LDE0LjQ5NjQyODMgMTAuMzEwMjQxLDE0LjU2NDIyMDQgOS41MzkxMzAxLDE0LjI4MTc1MyBDOS4yNzA5MTc2MywxNC4xOTEzNjM1IDkuMDM2MjMxNzIsMTQuMTIzNTcxMyA5LjAxMzg4MDY4LDE0LjE1NzQ2NzQgQzguOTM1NjUyMDQsMTQuMjM2NTU4MyA5LjIwMzg2NDUxLDE1LjI2NDczOTYgOS40MTYxOTkzOSwxNS42NzE0OTI2IEM5LjcwNjc2MjksMTYuMjM2NDI3NCAxMC4yOTkwNjU0LDE2Ljc5MDA2MzUgMTAuOTQ3MjQ1NiwxNy4xMTc3MjU3IEwxMS40OTQ4NDYsMTcuMzc3NTk1NyBMMTAuODQ2NjY1OSwxNy4zODg4OTQ0IEMxMC4yMjA4MzY4LDE3LjM4ODg5NDQgMTAuMTk4NDg1OCwxNy40MDAxOTMxIDEwLjI2NTUzODksMTcuNjM3NDY1NyBDMTAuNDg5MDQ5MywxOC4zNzE4ODA5IDExLjM3MTkxNTMsMTkuMTUxNDkxIDEyLjM1NTM2MTEsMTkuNDkwNDUxOCBMMTMuMDQ4MjQzMywxOS43Mjc3MjQ0IEwxMi40NDQ3NjUyLDIwLjA4OTI4MjcgQzExLjU1MDcyMzYsMjAuNjA5MDIyNyAxMC41MDAyMjQ4LDIwLjkwMjc4ODggOS40NDk3MjU5NSwyMC45MjUzODYyIEM4Ljk0NjgyNzU2LDIwLjkzNjY4NDkgOC41MzMzMzMzMywyMC45ODE4Nzk3IDguNTMzMzMzMzMsMjEuMDE1Nzc1OCBDOC41MzMzMzMzMywyMS4xMjg3NjI3IDkuODk2NzQ2NzMsMjEuNzYxNDg5NyAxMC42OTAyMDg2LDIyLjAxMDA2MSBDMTMuMDcwNTk0MywyMi43NDQ0NzYyIDE1Ljg5ODAwMDgsMjIuNDI4MTEyOCAxOC4wMjEzNDk1LDIxLjE3Mzk1NzUgQzE5LjUzMDA0NDcsMjAuMjgxMzYwNSAyMS4wMzg3Mzk4LDE4LjUwNzQ2NTMgMjEuNzQyNzk3NiwxNi43OTAwNjM1IEMyMi4xMjI3NjUzLDE1Ljg3NDg2OTIgMjIuNTAyNzMyOSwxNC4yMDI2NjIyIDIyLjUwMjczMjksMTMuNDAwNDU0OCBDMjIuNTAyNzMyOSwxMi44ODA3MTQ4IDIyLjUzNjI1OTUsMTIuODEyOTIyNiAyMy4xNjIwODg2LDEyLjE5MTQ5NDMgQzIzLjUzMDg4MDcsMTEuODI5OTM2IDIzLjg3NzMyMTgsMTEuNDM0NDgxNyAyMy45NDQzNzUsMTEuMzIxNDk0NyBDMjQuMDU2MTMwMiwxMS4xMDY4MTk1IDI0LjA0NDk1NDYsMTEuMTA2ODE5NSAyMy40NzUwMDMxLDExLjI5ODg5NzMgQzIyLjUyNTA4NCwxMS42Mzc4NTgyIDIyLjM5MDk3NzcsMTEuNTkyNjYzNCAyMi44NjAzNDk2LDExLjA4NDIyMjEgQzIzLjIwNjc5MDcsMTAuNzIyNjYzOSAyMy42MjAyODQ5LDEwLjA2NzMzOTUgMjMuNjIwMjg0OSw5Ljg3NTI2MTY3IEMyMy42MjAyODQ5LDkuODQxMzY1NTggMjMuNDUyNjUyMSw5Ljg5Nzg1OTA2IDIzLjI2MjY2ODMsOS45OTk1NDczMiBDMjMuMDYxNTA4OSwxMC4xMTI1MzQzIDIyLjYxNDQ4ODEsMTAuMjgyMDE0NyAyMi4yNzkyMjI1LDEwLjM4MzcwMyBMMjEuNjc1NzQ0NSwxMC41NzU3ODA4IEwyMS4xMjgxNDQsMTAuMjAyOTIzOCBDMjAuODI2NDA1LDkuOTk5NTQ3MzIgMjAuNDAxNzM1Miw5Ljc3MzU3MzQgMjAuMTc4MjI0OCw5LjcwNTc4MTIzIEMxOS42MDgyNzMzLDkuNTQ3NTk5NDkgMTguNzM2NTgyOCw5LjU3MDE5Njg4IDE4LjIyMjUwODksOS43NTA5NzYwMSBMMTguMjIyNTA4OSw5Ljc1MDk3NjAxIFoiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgPC9nPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+')
}

.socials.dark .fb {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+DQo8c3ZnIHdpZHRoPSI5cHgiIGhlaWdodD0iMThweCIgdmlld0JveD0iMCAwIDkgMTgiIHZlcnNpb249IjEuMSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgeG1sbnM6c2tldGNoPSJodHRwOi8vd3d3LmJvaGVtaWFuY29kaW5nLmNvbS9za2V0Y2gvbnMiPg0KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPg0KICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMTA5My4wMDAwMDAsIC0xNTg5LjAwMDAwMCkiIGZpbGw9IiNCNUI2QkQiPg0KICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTMuMDAwMDAwLCAxMjQ2LjAwMDAwMCkiPg0KICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDAuMDAwMDAwLCAxNDYuMDAwMDAwKSI+DQogICAgICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDEwNDAuMDAwMDAwLCAxOTAuMDAwMDAwKSI+DQogICAgICAgICAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg0NC4zMDc2OTIsIDAuMDAwMDAwKSI+DQogICAgICAgICAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTEzLjc0MTQ0ODksMjQuNzAzODI1NiBMMTMuNzQxNDQ4OSwxNS45OTkzMjA2IEwxMS45NDQ2NjM4LDE1Ljk5OTMyMDYgTDExLjk0NDY2MzgsMTIuOTk5NTgyOSBMMTMuNzQxNDQ4OSwxMi45OTk1ODI5IEwxMy43NDE0NDg5LDExLjE5ODU1MTIgQzEzLjc0MTQ0ODksOC43NTEzNjk5NSAxNC43NTYwMjYxLDcuMjk2MTc0NDMgMTcuNjM4NTYsNy4yOTYxNzQ0MyBMMjAuMDM4MzUwMiw3LjI5NjE3NDQzIEwyMC4wMzgzNTAyLDEwLjI5NjI1MTkgTDE4LjUzODMxMTUsMTAuMjk2MjUxOSBDMTcuNDE2MjEyNSwxMC4yOTYyNTE5IDE3LjM0MTk4MzQsMTAuNzE1NDY3NyAxNy4zNDE5ODM0LDExLjQ5Nzg0NTUgTDE3LjMzNzkwNjgsMTIuOTk5MjQzMSBMMjAuMDU1MzM2MiwxMi45OTkyNDMxIEwxOS43MzczNTcyLDE1Ljk5ODk4MDggTDE3LjMzNzkwNjgsMTUuOTk4OTgwOCBMMTcuMzM3OTA2OCwyNC43MDM4MjU2IEwxMy43NDE0NDg5LDI0LjcwMzgyNTYgWiIvPg0KICAgICAgICAgICAgICAgICAgICAgICAgPC9nPg0KICAgICAgICAgICAgICAgICAgICA8L2c+DQogICAgICAgICAgICAgICAgPC9nPg0KICAgICAgICAgICAgPC9nPg0KICAgICAgICA8L2c+DQogICAgPC9nPg0KPC9zdmc+')
}

.socials.dark .in {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE3cHgiIGhlaWdodD0iMThweCIgdmlld0JveD0iMCAwIDE3IDE4IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0xMTMzLjAwMDAwMCwgLTE1ODkuMDAwMDAwKSIgZmlsbD0iI0I1QjZCRCI+CiAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zLjAwMDAwMCwgMTI0Ni4wMDAwMDApIj4KICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDAuMDAwMDAwLCAxNDYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTA0MC4wMDAwMDAsIDE5MC4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoODguNjE1Mzg1LCAwLjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoNy4zODQ2MTUsIDcuMzg0NjE1KSI+CiAgICAgICAgICAgICAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTE1LjEyNDk5NDcsMTYuNzUxMzgwOCBMMi4xMDU3NzQ1MywxNi43NTEzODA4IEMyLjA3MTE1ODIxLDE2Ljc0NTgwNSAyLjAzNjMwOTU3LDE2LjczOTA2NzYgMi4wMDE2OTMyNSwxNi43MzQ4ODU4IEMxLjI4NTkwMjE1LDE2LjY0Mjg4NTQgMC42ODQxODIyNzMsMTYuMDk2NDU4NyAwLjUyNDgwNzgxOSwxNS4zOTE1ODY4IEMwLjUwNjIyMTg3NywxNS4zMDkzNDQgMC40OTQzNzMzMzksMTUuMjI1OTM5NiAwLjQ3OTUwNDU4NSwxNS4xNDMyMzIyIEwwLjQ3OTUwNDU4NSwyLjA4ODIzNDA0IEMwLjQ4NDg0ODA0MywyLjA1Nzc5OTU2IDAuNDkxMTIwNzk5LDIuMDI3NTk3NDEgMC40OTUzMDI2MzYsMS45OTcxNjI5MyBDMC41OTc5ODk5NjYsMS4yNjY3MzU0IDEuMTMxNDA2NTEsMC42ODYxNTcwMyAxLjg1MjMwODc0LDAuNTIxOTAzNzY2IEMxLjkyOTkwNTA1LDAuNTA0MjQ3MTIgMi4wMDkxMjc2MywwLjQ5MzU2MDIwNCAyLjA4Nzg4NTU2LDAuNDc5Mzg4NDIzIEwxNS4xNDI4ODM3LDAuNDc5Mzg4NDIzIEMxNS4xNzMwODU4LDAuNDg0NzMxODgxIDE1LjIwMzA1NTcsMC40OTE0NjkyODUgMTUuMjMzNzIyNSwwLjQ5NTQxODc5OCBDMTUuOTcyMjgxMywwLjU5NjQ3OTg1OSAxNi41NzM3Njg5LDEuMTYyNDIxOCAxNi43MTYxODM3LDEuODkxNjg3NyBDMTYuNzMwMTIzMSwxLjk2Mjc3ODkzIDE2LjczOTg4MDgsMi4wMzQzMzQ4MSAxNi43NTEyNjQ2LDIuMTA1NjU4MzYgTDE2Ljc1MTI2NDYsMTUuMTI1MTEwOSBDMTYuNzM5NDE2MSwxNS4xOTc1OTYgMTYuNzI5MTkzOCwxNS4yNzEwMTA1IDE2LjcxNTI1NDQsMTUuMzQzMjYzNCBDMTYuNTg1Mzg1MSwxNi4wMTE2NjAzIDE2LjA0MjQ0MzMsMTYuNTY1OTg2IDE1LjM3Nzk5NTgsMTYuNzA3MDA2OSBDMTUuMjk0MzU5MSwxNi43MjUxMjgyIDE1LjIwOTU2MDcsMTYuNzM2OTc2NyAxNS4xMjQ5OTQ3LDE2Ljc1MTM4MDggWiBNMi4yMzk4MjU2Myw3LjA3NzE2NTU4IEwyLjIzOTgyNTYzLDcuMTIxMDc0ODYgQzIuMjM5ODI1NjMsOS41MjkxMTYgMi4yMzk1OTMzMSwxMS45MzcxNTcxIDIuMjQwMDU3OTYsMTQuMzQ1MTk4MyBDMi4yNDAwNTc5NiwxNC42OTE1OTM4IDIuNTM5OTg4NiwxNC45ODk0MzM1IDIuODg2Mzg0MSwxNC45ODk0MzM1IEM2LjcwNDg2NTkyLDE0Ljk4OTY2NTggMTAuNTIzMTE1NCwxNC45ODk2NjU4IDE0LjM0MTU5NzIsMTQuOTg5NDMzNSBDMTQuNjkxMjQ1MywxNC45ODk0MzM1IDE0Ljk4OTU0OTcsMTQuNjkyMDU4NCAxNC45ODk1NDk3LDE0LjM0MzEwNzMgQzE0Ljk4OTc4MiwxMS45Mzc4NTQxIDE0Ljk4OTU0OTcsOS41MzI4MzMxOSAxNC45ODk1NDk3LDcuMTI3ODEyMjcgTDE0Ljk4OTU0OTcsNy4wNzc4NjI1NSBMMTMuNDM2MjI5NSw3LjA3Nzg2MjU1IEMxMy42NTU1NDM3LDcuNzc4Nzg0ODkgMTMuNzIyOTE3Nyw4LjQ5MTc4ODEgMTMuNjM2OTU3Nyw5LjIxODQ5ODQ0IEMxMy41NTA1MzMxLDkuOTQ1NDQxMSAxMy4zMTYzNTAyLDEwLjYyMTk2OTQgMTIuOTM0ODczNywxMS4yNDY2ODk0IEMxMi41NTMxNjUsMTEuODcyMTA2MyAxMi4wNTgzMTQyLDEyLjM5MDE4OTUgMTEuNDUyNDEyNSwxMi44MDI1NjUxIEM5Ljg4MTkwMDQxLDEzLjg3MjE4NiA3LjgxNDIxNDM0LDEzLjk2NjI3NzQgNi4xNDc3NTIzLDEzLjAzMDkzOTggQzUuMzA1MzQ0NDcsMTIuNTU4NjI0NiA0LjY0MzkxNzI2LDExLjg5OTk4NTIgNC4xODI3NTM1NywxMS4wNTEzMDQ3IEMzLjQ5NDg0MTM4LDkuNzg0OTA1MDMgMy4zODQ5NTIsOC40NTU3Nzc4NCAzLjc4ODQ5OTI3LDcuMDc2NzAwOTMgQzMuMjczMjA0MDIsNy4wNzcxNjU1OCAyLjc1OTk5OTY5LDcuMDc3MTY1NTggMi4yMzk4MjU2Myw3LjA3NzE2NTU4IFogTTguNjE1NTAwNzgsNS4zMTgwMDYxNSBDNi44MTA4MDU3OSw1LjMxNjg0NDUzIDUuMzQzNjc3OTgsNi43Njg4NzEyNiA1LjMxODM1NDYzLDguNTY1NDM0OSBDNS4yOTIzMzQzMSwxMC40MTAzMjIgNi43NjkyMTk3NSwxMS44NzI4MDMzIDguNTM5NzYzMDYsMTEuOTEwOTA0NSBDMTAuMzgyMDk0NiwxMS45NTAzOTk2IDExLjg3MjIyMjUsMTAuNDc4MzkzIDExLjkxMTAyMDcsOC42ODgxMDIxMSBDMTEuOTUwNzQ4MSw2Ljg0MTgyMTA4IDEwLjQ2MTU0OTUsNS4zMTY4NDQ1MyA4LjYxNTUwMDc4LDUuMzE4MDA2MTUgWiBNMTMuNTYwMDU4NCw0LjY1NzA0MzU4IEwxMy41NjAwNTg0LDQuNjU0MDIzMzYgQzEzLjgyNzY5NTksNC42NTQwMjMzNiAxNC4wOTYyNjI4LDQuNjU5MTM0NSAxNC4zNjQxMzI3LDQuNjUyNjI5NDIgQzE0LjcwODY2OTYsNC42NDQwMzM0MiAxNC45ODkzMTczLDQuMzQ4NzQ5MjYgMTQuOTg5MzE3Myw0LjAwMzc0NzcxIEMxNC45ODk1NDk3LDMuNDkwMDc4NzMgMTQuOTg5NTQ5NywyLjk3NjE3NzQzIDE0Ljk4OTMxNzMsMi40NjI1MDg0NSBDMTQuOTg5MzE3MywyLjA5NDA0MjE1IDE0LjY5Nzc1MDQsMS44MDA4NDg5MSAxNC4zMjk3NDg3LDEuODAwNjE2NTkgQzEzLjgxNzQ3MzcsMS44MDAzODQyNiAxMy4zMDUxOTg2LDEuODAwMTUxOTQgMTIuNzkyNjkxMywxLjgwMDYxNjU5IEMxMi40MjU2MTg5LDEuODAxMDgxMjQgMTIuMTMzMTIyNywyLjA5NDk3MTQ1IDEyLjEzMjg5MDMsMi40NjM0Mzc3NSBDMTIuMTMyNjU4LDIuOTcyNjkyNTcgMTIuMTMxMjY0MSwzLjQ4MTk0NzM4IDEyLjEzNDc0ODksMy45OTE0MzQ1MiBDMTIuMTM1MjEzNiw0LjA2NzQwNDU2IDEyLjE0OTYxNzcsNC4xNDYzOTQ4MiAxMi4xNzM3Nzk0LDQuMjE4NDE1MzQgQzEyLjI2NTc3OTgsNC40ODk1Mzc3NyAxMi41MTQxMzQ1LDQuNjU1ODgxOTYgMTIuODE4MjQ3LDQuNjU3Mjc1OSBDMTMuMDY1NDQsNC42NTc3NDA1NSAxMy4zMTI2MzMsNC42NTcwNDM1OCAxMy41NjAwNTg0LDQuNjU3MDQzNTggWiI+PC9wYXRoPgogICAgICAgICAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4=')
}

.socials.dark .pi {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE0cHgiIGhlaWdodD0iMThweCIgdmlld0JveD0iMCAwIDE0IDE4IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0xMTc5LjAwMDAwMCwgLTE1ODkuMDAwMDAwKSIgZmlsbD0iI0I1QjZCRCI+CiAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zLjAwMDAwMCwgMTI0Ni4wMDAwMDApIj4KICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDAuMDAwMDAwLCAxNDYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTA0MC4wMDAwMDAsIDE5MC4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTMyLjkyMzA3NywgMC4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xNi40MTc3MDg4LDcuMDg1NTQ2NDMgQzExLjU1MjE1NDgsNy4wODU1NDY0MyA5LjA5ODkwNDY3LDEwLjU3Mzk0MSA5LjA5ODkwNDY3LDEzLjQ4Mjk0NTggQzkuMDk4OTA0NjcsMTUuMjQ0MzE3NyA5Ljc2NTc2MDEzLDE2LjgxMTMwODcgMTEuMTk2MDM2LDE3LjM5NTI0NzkgQzExLjQzMDU2NzEsMTcuNDkxMTMwNCAxMS42NDA2NDQyLDE3LjM5ODU0NjQgMTEuNzA4NjYwNSwxNy4xMzg4Nzg4IEMxMS43NTU5NzYyLDE2Ljk1OTE3MDIgMTEuODY3ODk2LDE2LjUwNTgwNCAxMS45MTc4Mjc3LDE2LjMxNjk5NjIgQzExLjk4NjQxMjcsMTYuMDYwMTcyMSAxMS45NTk3OTc2LDE1Ljk3MDA5MDMgMTEuNzcwNTM0OSwxNS43NDYyNTA3IEMxMS4zNTgxMTUsMTUuMjU5Nzg2MyAxMS4wOTQ1ODAzLDE0LjYzMDAxIDExLjA5NDU4MDMsMTMuNzM3OTUwMSBDMTEuMDk0NTgwMywxMS4xNDk5MTg1IDEzLjAzMDg4MzgsOC44MzMwNDIxNCAxNi4xMzY2NTgyLDguODMzMDQyMTQgQzE4Ljg4Njc2ODcsOC44MzMwNDIxNCAyMC4zOTc2ODYsMTAuNTEzNDMxNSAyMC4zOTc2ODYsMTIuNzU3NjI4MiBDMjAuMzk3Njg2LDE1LjcxMDQyMjggMTkuMDkwOTMxNCwxOC4yMDI1NzE4IDE3LjE1MDk4ODIsMTguMjAyNTcxOCBDMTYuMDc5Njc0NiwxOC4yMDI1NzE4IDE1LjI3NzY5NjUsMTcuMzE2NTQwMSAxNS41MzQ3NDgsMTYuMjI5ODcxNyBDMTUuODQyNTI3NSwxNC45MzI1NTc0IDE2LjQzODc1MDYsMTMuNTMyNDIyNSAxNi40Mzg3NTA2LDEyLjU5NjAwNDEgQzE2LjQzODc1MDYsMTEuNzU3NzQzMSAxNS45ODg3OTY2LDExLjA1ODU4NTUgMTUuMDU3NjEwMywxMS4wNTg1ODU1IEMxMy45NjI0MTE0LDExLjA1ODU4NTUgMTMuMDgyNjM1MywxMi4xOTE1NDYgMTMuMDgyNjM1MywxMy43MDkyODc3IEMxMy4wODI2MzUzLDE0LjY3NTk2MDggMTMuNDA5Mjk1NSwxNS4zMjk3MzYyIDEzLjQwOTI5NTUsMTUuMzI5NzM2MiBDMTMuNDA5Mjk1NSwxNS4zMjk3MzYyIDEyLjI4ODUwNTIsMjAuMDc4NDc5NiAxMi4wOTIwNzY4LDIwLjkxMDE0MzggQzExLjcwMDgxMjUsMjIuNTY2NDIwMyAxMi4wMzMyNzM0LDI0LjU5Njc4NjUgMTIuMDYxMzY3MSwyNC44MDE4NTkxIEMxMi4wNzc4NTk0LDI0LjkyMzMzMyAxMi4yMzQwMjM5LDI0Ljk1MjIyMjkgMTIuMzA0NzcsMjQuODYwNDM1IEMxMi40MDU3NzA3LDI0LjcyODYxMDcgMTMuNzEwMTM2OCwyMy4xMTgyODUgMTQuMTUzNjA3NywyMS41MDkyMTA0IEMxNC4yNzkwNjI1LDIxLjA1MzU2OTUgMTQuODczOTIwOCwxOC42OTQyNjgzIDE0Ljg3MzkyMDgsMTguNjk0MjY4MyBDMTUuMjI5Njk4MywxOS4zNzI5NTI3IDE2LjI2OTYxOTgsMTkuOTcwNzY4MiAxNy4zNzU1MTAyLDE5Ljk3MDc2ODIgQzIwLjY2NzU5MDIsMTkuOTcwNzY4MiAyMi45MDEwOTUzLDE2Ljk2OTUyMDUgMjIuOTAxMDk1MywxMi45NTIyMzY3IEMyMi45MDEwOTUzLDkuOTE0NTkyMzEgMjAuMzI4MTkxMSw3LjA4NTU0NjQzIDE2LjQxNzcwODgsNy4wODU1NDY0MyBMMTYuNDE3NzA4OCw3LjA4NTU0NjQzIFoiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgPC9nPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+')
}

.cart {
	padding: 80px 0 58px
}

.cart h1 {
	font-size: 107.69231%;
	line-height: 128.57143%;
	font-family: "montserratregular", sans-serif;
	-moz-box-shadow: rgba(17, 17, 18, 0.04) 0 4px 4px -2px,
		rgba(19, 20, 20, 0.06) 0 3px 1px -2px;
	-webkit-box-shadow: rgba(17, 17, 18, 0.04) 0 4px 4px -2px,
		rgba(19, 20, 20, 0.06) 0 3px 1px -2px;
	box-shadow: rgba(17, 17, 18, 0.04) 0 4px 4px -2px,
		rgba(19, 20, 20, 0.06) 0 3px 1px -2px;
	color: #020E20;
	margin-bottom: 18px;
	padding-bottom: 15px;
	text-align: center
}

.cart h1 span {
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE5cHgiIGhlaWdodD0iMThweCIgdmlld0JveD0iMCAwIDE5IDE4IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC02ODYuMDAwMDAwLCAtNDUwLjAwMDAwMCkiIGZpbGw9IiMwODZmY2YiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg2NjAuMDAwMDAwLCAxNjUuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgwLjAwMDAwMCwgMjY5LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDI2LjAwMDAwMCwgMTYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xNi43NjU0Nzg0LDQuMjc1IEwxNS44NzU4NzQ5LDguNTkzMzYwNzEgTDQuNjk5ODQwNTksOS43MjQwOTgyMSBMMy40NzM5MDMwNCw0LjI3NSBMMTYuNzY1NDc4NCw0LjI3NSBaIE0xNi44MDQ1NDYzLDkuNzI4MDY3ODYgTDE4LjY3MzcyNTEsMy4wNTM1NzE0MyBMMy4xOTkxNTIwNywzLjA1MzU3MTQzIEwyLjUxMjI3NDYzLDAgTDMuMjYzMDc1NzJlLTA1LDAgTDMuMjYzMDc1NzJlLTA1LDEuMjIxNDI4NTcgTDEuNDUzMDgwMjUsMS4yMjE0Mjg1NyBMNC4wNjM1NDA4MywxMi44MjUgTDE2Ljk2ODAyNjQsMTIuODI1IEwxNi45NjgwMjY0LDExLjYwMzU3MTQgTDUuMTIyNzM1MjEsMTEuNjAzNTcxNCBMNC45NzAwMjMyNiwxMC45MjUzNzMyIEwxNi44MDQ1NDYzLDkuNzI4MDY3ODYgWiI+PC9wYXRoPgogICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNNy44MzEzODE3MywxNS4yNjc4NTcxIEM3LjgzMTM4MTczLDE2LjI3OTgxMDcgNi45NTQ5MTk1OSwxNy4xIDUuODczNTM2MywxNy4xIEM0Ljc5MjE1MzAxLDE3LjEgMy45MTU2OTA4NywxNi4yNzk4MTA3IDMuOTE1NjkwODcsMTUuMjY3ODU3MSBDMy45MTU2OTA4NywxNC4yNTU5MDM2IDQuNzkyMTUzMDEsMTMuNDM1NzE0MyA1Ljg3MzUzNjMsMTMuNDM1NzE0MyBDNi45NTQ5MTk1OSwxMy40MzU3MTQzIDcuODMxMzgxNzMsMTQuMjU1OTAzNiA3LjgzMTM4MTczLDE1LjI2Nzg1NzEiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTE1LjY2Mjc2MzUsMTUuMjY3ODU3MSBDMTUuNjYyNzYzNSwxNi4yNzk4MTA3IDE0Ljc4NjMwMTMsMTcuMSAxMy43MDQ5MTgsMTcuMSBDMTIuNjIzNTM0NywxNy4xIDExLjc0NzA3MjYsMTYuMjc5ODEwNyAxMS43NDcwNzI2LDE1LjI2Nzg1NzEgQzExLjc0NzA3MjYsMTQuMjU1OTAzNiAxMi42MjM1MzQ3LDEzLjQzNTcxNDMgMTMuNzA0OTE4LDEzLjQzNTcxNDMgQzE0Ljc4NjMwMTMsMTMuNDM1NzE0MyAxNS42NjI3NjM1LDE0LjI1NTkwMzYgMTUuNjYyNzYzNSwxNS4yNjc4NTcxIj48L3BhdGg+CiAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4=')
		no-repeat left center;
	display: inline-block;
	padding-left: 22px
}

.cart .cart-products .product {
	border-bottom: 1px solid #edeff2;
	margin-bottom: 15px;
	padding-bottom: 15px
}

.cart .cart-products .product:last-child {
	border-bottom: 0 none;
	margin-bottom: 0;
	padding-bottom: 0
}

.cart .cart-products .p-ico {
	float: left;
	width: 20%
}

.cart .cart-products .p-ico img {
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	border: 1px solid #d8d7d7;
	display: block;
	width: 100%
}

.cart .cart-products .p-text {
	font-size: 92.30769%;
	line-height: 133.33333%;
	font-family: "montserratregular", sans-serif;
	float: left;
	margin-left: 2%;
	width: 78%
}

.cart .cart-products .p-text small {
	font-family: "montserratlight", sans-serif;
	color: #b5b6bd
}

.cart .cart-products .p-text a:hover {
	color: #020E20
}

.cart .cart-products small {
	display: block
}

.cart .cart-products .p-count {
	float: left;
	margin-right: 2%;
	width: 65%
}

.cart .cart-products .p-price {
	font-size: 116.66667%;
	line-height: 114.28571%;
	font-family: "montserratbold", sans-serif;
	color: #020E20;
	float: left;
	text-align: right;
	width: 33%
}

.cart .price-total {
	font-size: 107.69231%;
	line-height: 128.57143%;
	border-top: 2px solid #b5b6bd;
	margin-top: 15px;
	padding-top: 10px;
	text-align: right
}

.cart .price-total strong {
	font-family: "montserratbold", sans-serif;
	color: #020E20
}

.cart .spinner {
	display: inline-block;
	height: 34px;
	margin-left: 0;
	margin-top: 6px;
	padding: 7px 10px 0
}

.cart .inputs {
	margin-top: 20px
}

.cart .inputs input {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	-moz-border-radius: 25px;
	-webkit-border-radius: 25px;
	border-radius: 25px;
	font-size: 107.69231%;
	line-height: 128.57143%;
	font-family: "montserratbold", sans-serif;
	-moz-box-shadow: rgba(17, 17, 18, 0.1) 0 2px 4px, rgba(19, 20, 20, 0.07)
		0 1px 1px;
	-webkit-box-shadow: rgba(17, 17, 18, 0.1) 0 2px 4px,
		rgba(19, 20, 20, 0.07) 0 1px 1px;
	box-shadow: rgba(17, 17, 18, 0.1) 0 2px 4px, rgba(19, 20, 20, 0.07) 0
		1px 1px;
	background-color: #020E20;
	border: 0 none;
	color: #fff;
	cursor: pointer;
	float: right;
	height: 50px;
	padding: 0 44px;
	-webkit-appearance: none
}

.cart .inputs input:hover {
	background-color: #0084ff
}

.cart .inputs input.checkout {
	background: #020E20
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4NCjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+DQo8c3ZnIHZlcnNpb249IjEuMSIgaWQ9IlZyc3R2YV8xIiB4bWxuczpza2V0Y2g9Imh0dHA6Ly93d3cuYm9oZW1pYW5jb2RpbmcuY29tL3NrZXRjaC9ucyINCgkgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgeD0iMHB4IiB5PSIwcHgiIHdpZHRoPSI3cHgiIGhlaWdodD0iOHB4Ig0KCSB2aWV3Qm94PSIzIC0yIDcgOCIgZW5hYmxlLWJhY2tncm91bmQ9Im5ldyAzIC0yIDcgOCIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMTQ3LjAwMDAwMCwgLTU2NS4wMDAwMDApIj4NCgkJPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTAwLjAwMDAwMCwgMzQwLjAwMDAwMCkiPg0KCQkJPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoOS4wMDAwMDAsIDIxOC4wMDAwMDApIj4NCgkJCQk8Zz4NCgkJCQkJPHBhdGggaWQ9IlBhdGgtNjctQ29weSIgZmlsbD0ibm9uZSIgc3Ryb2tlPSIjRkZGRkZGIiBkPSJNNDEsMTNsNC00bC00LTQiLz4NCgkJCQk8L2c+DQoJCQk8L2c+DQoJCTwvZz4NCgk8L2c+DQo8L2c+DQo8L3N2Zz4NCg==')
		no-repeat 86% 22px;
	background-position: right 42px top 22px;
	padding-right: 62px
}

.cart .inputs input.update-cart {
	background-color: #b5b6bd;
	float: left
}

.cart .inputs input.update-cart:hover {
	background-color: #5d5e66
}

.cart .note {
	font-size: 92.30769%;
	line-height: 133.33333%;
	color: #b5b6bd;
	margin-top: 16px;
	text-align: center
}

#sign-in-popup {
	background-color: rgba(13, 13, 26, 0.7);
	bottom: 0;
	display: none;
	height: 100%;
	left: 0;
	position: absolute;
	top: 0;
	width: 100%;
	z-index: 4000
}

#sign-in-popup.show {
	display: block
}

#sign-in-popup .box {
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	-moz-box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px,
		rgba(19, 20, 20, 0.06) 0 1px 1px;
	-webkit-box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px,
		rgba(19, 20, 20, 0.06) 0 1px 1px;
	box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px, rgba(19, 20, 20, 0.06) 0
		1px 1px;
	background-color: #fff;
	margin: 168px auto 0;
	margin-top: 18vh;
	max-width: 420px;
	position: relative;
	width: 100%
}

#sign-in-popup .top {
	-moz-box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px,
		rgba(19, 20, 20, 0.06) 0 1px 1px;
	-webkit-box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px,
		rgba(19, 20, 20, 0.06) 0 1px 1px;
	box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px, rgba(19, 20, 20, 0.06) 0
		1px 1px;
	padding: 25px 50px 0
}

#sign-in-popup .bottom {
	-moz-border-radius-bottomleft: 2px;
	-webkit-border-bottom-left-radius: 2px;
	border-bottom-left-radius: 2px;
	-moz-border-radius-bottomright: 2px;
	-webkit-border-bottom-right-radius: 2px;
	border-bottom-right-radius: 2px;
	background-color: #f7f7fa;
	margin-top: 2px;
	padding: 25px 50px
}

#sign-in-popup #close-sign-in {
	cursor: pointer;
	height: 14px;
	position: absolute;
	top: 10px;
	right: 10px;
	width: 14px
}

#sign-in-popup #close-sign-in:before, #sign-in-popup #close-sign-in:after
	{
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjEycHgiIGhlaWdodD0iMTNweCIgdmlld0JveD0iMCAwIDEyIDEzIiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC04MjcuMDAwMDAwLCAtMTc4LjAwMDAwMCkiIGZpbGw9IiMxNjE2MTkiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg0MzAuMDAwMDAwLCAxNjguMDAwMDAwKSI+CiAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgzOTYuMDAwMDAwLCAxMC4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICA8cmVjdCB0cmFuc2Zvcm09InRyYW5zbGF0ZSg3LjAwMDAwMCwgNi41MDAwMDApIHJvdGF0ZSgtMzE1LjAwMDAwMCkgdHJhbnNsYXRlKC03LjAwMDAwMCwgLTYuNTAwMDAwKSAiIHg9Ii0xIiB5PSI2IiB3aWR0aD0iMTYiIGhlaWdodD0iMSIgcng9IjEiPjwvcmVjdD4KICAgICAgICAgICAgICAgICAgICA8cmVjdCB0cmFuc2Zvcm09InRyYW5zbGF0ZSg3LjAwMDAwMCwgNi41MDAwMDApIHNjYWxlKC0xLCAxKSByb3RhdGUoLTMxNS4wMDAwMDApIHRyYW5zbGF0ZSgtNy4wMDAwMDAsIC02LjUwMDAwMCkgIiB4PSItMSIgeT0iNiIgd2lkdGg9IjE2IiBoZWlnaHQ9IjEiIHJ4PSIxIj48L3JlY3Q+CiAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPg==')
		no-repeat left top;
	content: "";
	display: block;
	height: 14px;
	left: 0;
	position: absolute;
	top: 0;
	width: 14px
}

#sign-in-popup #close-sign-in:after {
	background-image:
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjEycHgiIGhlaWdodD0iMTNweCIgdmlld0JveD0iMCAwIDEyIDEzIiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC04MjcuMDAwMDAwLCAtMTc4LjAwMDAwMCkiIGZpbGw9IiMwODZmY2YiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg0MzAuMDAwMDAwLCAxNjguMDAwMDAwKSI+CiAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgzOTYuMDAwMDAwLCAxMC4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICA8cmVjdCB0cmFuc2Zvcm09InRyYW5zbGF0ZSg3LjAwMDAwMCwgNi41MDAwMDApIHJvdGF0ZSgtMzE1LjAwMDAwMCkgdHJhbnNsYXRlKC03LjAwMDAwMCwgLTYuNTAwMDAwKSAiIHg9Ii0xIiB5PSI2IiB3aWR0aD0iMTYiIGhlaWdodD0iMSIgcng9IjEiPjwvcmVjdD4KICAgICAgICAgICAgICAgICAgICA8cmVjdCB0cmFuc2Zvcm09InRyYW5zbGF0ZSg3LjAwMDAwMCwgNi41MDAwMDApIHNjYWxlKC0xLCAxKSByb3RhdGUoLTMxNS4wMDAwMDApIHRyYW5zbGF0ZSgtNy4wMDAwMDAsIC02LjUwMDAwMCkgIiB4PSItMSIgeT0iNiIgd2lkdGg9IjE2IiBoZWlnaHQ9IjEiIHJ4PSIxIj48L3JlY3Q+CiAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPg==');
	opacity: 0
}

#sign-in-popup #close-sign-in:hover:before {
	opacity: 0
}

#sign-in-popup #close-sign-in:hover:after {
	opacity: 1
}

#sign-in-popup h2 {
	font-family: "montserratregular", sans-serif;
	font-size: 184.61538%;
	line-height: 141.66667%;
	margin-bottom: 21px;
	text-align: center
}

#sign-in-popup h3 {
	font-size: 107.69231%;
	line-height: 128.57143%;
	padding: 40px 0 28px;
	position: relative;
	text-align: center
}

#sign-in-popup #toggle-reset-passw {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	color: #020E20;
	cursor: pointer
}

#sign-in-popup #toggle-reset-passw:before {
	background: transparent
		url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAA4AAAAICAIAAABGc1mbAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAABtSURBVChTjc0xDoAgEERR739PCEQLYAG10m9ARGLhZood9iVMx+/5oCEIqaWbkYpErS1hqU/3vChnY2bnhLAM+qEcrF28jyEkwkLtdaXNieQYV8Iy6Is2h0hpa6H2elLKUPixuJz3lqI5AZQyJ+l3Ra7j0zsYAAAAAElFTkSuQmCC')
		no-repeat left top;
	bottom: -1px;
	content: "";
	display: block;
	height: 8px;
	margin-left: -7px;
	opacity: 0;
	position: absolute;
	left: 50%;
	width: 14px
}

#sign-in-popup #toggle-reset-passw:hover {
	text-decoration: underline
}

#sign-in-popup #toggle-reset-passw.show:before {
	opacity: 1
}

#sign-in-popup .label {
	position: relative
}

#sign-in-popup .label.error .input {
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE4cHgiIGhlaWdodD0iMThweCIgdmlld0JveD0iMCAwIDE4IDE4IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0xMzkyLjAwMDAwMCwgLTMzNy4wMDAwMDApIj4KICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTA3LjAwMDAwMCwgMjg5LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMC4wMDAwMDAsIDI0LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDk5OS4wMDAwMDAsIDAuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDI4Ny4wMDAwMDAsIDI1LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTcuNjM4Nzg0LDkuNTY4MDgzMiBMOC45MTg3ODQsOS41NjgwODMyIEw4LjkxODc4NCw0LjQ0ODA4MzIgTDcuNjM4Nzg0LDQuNDQ4MDgzMiBMNy42Mzg3ODQsOS41NjgwODMyIEw3LjYzODc4NCw5LjU2ODA4MzIgWiIgaWQ9IkZpbGwtMSIgZmlsbD0iI0Q5MzMyRCI+PC9wYXRoPgogICAgICAgICAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTcuNjM4Nzg0LDEwLjg0ODA4MzIgTDguOTE4Nzg0LDEwLjg0ODA4MzIgTDguOTE4Nzg0LDEyLjEyODA4MzIgTDcuNjM4Nzg0LDEyLjEyODA4MzIgTDcuNjM4Nzg0LDEwLjg0ODA4MzIgTDcuNjM4Nzg0LDEwLjg0ODA4MzIgWiIgaWQ9IkZpbGwtMiIgZmlsbD0iI0Q5MzMyRCI+PC9wYXRoPgogICAgICAgICAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTAuNTk4Nzg0LDguMjg4MDcwNCBDMC41OTg3ODQsNC4wNDY3OTA0IDQuMDM3NTA0LDAuNjA4MDcwNCA4LjI3ODc4NCwwLjYwODA3MDQgQzEyLjUyMDA2NCwwLjYwODA3MDQgMTUuOTU4Nzg0LDQuMDQ2NzkwNCAxNS45NTg3ODQsOC4yODgwNzA0IEMxNS45NTg3ODQsMTIuNTI5MzUwNCAxMi41MjAwNjQsMTUuOTY4MDcwNCA4LjI3ODc4NCwxNS45NjgwNzA0IEM0LjAzNzUwNCwxNS45NjgwNzA0IDAuNTk4Nzg0LDEyLjUyOTM1MDQgMC41OTg3ODQsOC4yODgwNzA0IEwwLjU5ODc4NCw4LjI4ODA3MDQgWiIgaWQ9IlN0cm9rZS0zIiBzdHJva2U9IiNEOTMzMkQiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgPC9nPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+')
		no-repeat 95% center;
	background-position: right 16px center
}

#sign-in-popup .label.success .input {
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE4cHgiIGhlaWdodD0iMThweCIgdmlld0JveD0iMCAwIDE4IDE4IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0xMDAuMDAwMDAwLCAtMTI5NC4wMDAwMDApIj4KICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTMuMDAwMDAwLCAxMjQ2LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTAzLjAwMDAwMCwgNDguMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTE3LjI5MDQsMy45NjY3NCBMOS4yOTA0LDExLjk2NjcxMzMgTDUuOTU3MDY2NjcsOC42MzMzOCIgaWQ9IlN0cm9rZS0xIiBzdHJva2U9IiMxMDkxNDYiIHN0cm9rZS13aWR0aD0iMiI+PC9wYXRoPgogICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xNi40MzA4LDcuNjU0NTggQzE2LjU1MjgsOC4xODQ1OCAxNi42MjM0NjY3LDguNzMzOTEzMzMgMTYuNjIzNDY2Nyw5LjI5OTkxMzMzIEMxNi42MjM0NjY3LDEzLjM0Mzg4NjcgMTMuMzM0MTMzMywxNi42MzMyMiA5LjI5MDEzMzMzLDE2LjYzMzIyIEM1LjI0NjgsMTYuNjMzMjIgMS45NTY4LDEzLjM0Mzg4NjcgMS45NTY4LDkuMjk5OTEzMzMgQzEuOTU2OCw1LjI1NjU4IDUuMjQ2OCwxLjk2NjU4IDkuMjkwMTMzMzMsMS45NjY1OCBDMTEuMjcwOCwxLjk2NjU4IDEzLjA2ODEzMzMsMi43NTkyNDY2NyAxNC4zODg4LDQuMDM5OTEzMzMgTDE1LjMzMTQ2NjcsMy4wOTc5MTMzMyBDMTMuNzY4OCwxLjU3NTkxMzMzIDExLjYzODgsMC42MzMyNDY2NjcgOS4yOTAxMzMzMywwLjYzMzI0NjY2NyBDNC41MTE0NjY2NywwLjYzMzI0NjY2NyAwLjYyMzQ2NjY2Nyw0LjUyMTI0NjY3IDAuNjIzNDY2NjY3LDkuMjk5OTEzMzMgQzAuNjIzNDY2NjY3LDE0LjA3OTIyIDQuNTExNDY2NjcsMTcuOTY2NTUzMyA5LjI5MDEzMzMzLDE3Ljk2NjU1MzMgQzE0LjA2ODgsMTcuOTY2NTUzMyAxNy45NTY4LDE0LjA3OTIyIDE3Ljk1NjgsOS4yOTk5MTMzMyBDMTcuOTU2OCw4LjM0NzI0NjY3IDE3Ljc5NjgsNy40MzI1OCAxNy41MTE0NjY3LDYuNTczOTEzMzMgTDE2LjQzMDgsNy42NTQ1OCBMMTYuNDMwOCw3LjY1NDU4IFoiIGlkPSJGaWxsLTIiIGZpbGw9IiMxMDkxNDYiPjwvcGF0aD4KICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgPC9nPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+')
		no-repeat 95% center;
	background-position: right 16px center
}

#sign-in-popup .label span.error {
	font-size: 92.30769%;
	line-height: 125%;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	background-color: #0d0d1a;
	color: #fff;
	display: block;
	padding: 6px;
	position: absolute;
	right: 10px;
	top: 39px
}

#sign-in-popup .label span.error:after {
	border-bottom: 5px solid #0d0d1a;
	border-left: 5px solid transparent;
	border-right: 5px solid transparent;
	content: "";
	display: block;
	height: 0;
	right: 10px;
	position: absolute;
	top: -5px;
	width: 0
}

#sign-in-popup label {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	font-size: 107.69231%;
	line-height: 128.57143%;
	background-color: #fff;
	color: #b5b6bd;
	height: 18px;
	left: 9px;
	padding: 0 4px;
	position: absolute;
	top: 16px
}

#sign-in-popup .filled {
	font-size: 92.30769%;
	line-height: 125%;
	color: #16161a;
	height: 15px;
	left: 24px;
	top: -8px
}

#sign-in-popup .bottom label {
	background-color: #f7f7fa
}

#sign-in-popup form .input {
	font-family: "montserratlight", sans-serif;
	font-size: 107.69231%;
	line-height: 128.57143%;
	-moz-border-radius: 24px;
	-webkit-border-radius: 24px;
	border-radius: 24px;
	background-color: transparent;
	border: 1px solid #d2d4d6;
	color: #16161a;
	display: block;
	height: 48px;
	margin-bottom: 20px;
	padding: 14px 12px 16px;
	width: 100%;
	-webkit-appearance: none
}

#sign-in-popup form .input:-moz-placeholder {
	color: #b5b6bd;
	opacity: 1
}

#sign-in-popup form .input::-moz-placeholder {
	color: #b5b6bd;
	opacity: 1
}

#sign-in-popup form .input:-ms-input-placeholder {
	color: #b5b6bd;
	opacity: 1
}

#sign-in-popup form .input::-webkit-input-placeholder {
	color: #b5b6bd;
	opacity: 1
}

#sign-in-popup form .btn {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	-moz-border-radius: 25px;
	-webkit-border-radius: 25px;
	border-radius: 25px;
	font-size: 107.69231%;
	line-height: 128.57143%;
	font-family: "montserratbold", sans-serif;
	-moz-box-shadow: rgba(17, 17, 18, 0.1) 0 2px 4px, rgba(19, 20, 20, 0.07)
		0 1px 1px;
	-webkit-box-shadow: rgba(17, 17, 18, 0.1) 0 2px 4px,
		rgba(19, 20, 20, 0.07) 0 1px 1px;
	box-shadow: rgba(17, 17, 18, 0.1) 0 2px 4px, rgba(19, 20, 20, 0.07) 0
		1px 1px;
	background-color: #020E20;
	border: 0 none;
	color: #fff;
	cursor: pointer;
	height: 50px;
	padding: 0;
	width: 100%;
	-webkit-appearance: none
}

#sign-in-popup form .btn:hover {
	background-color: #0084ff
}

#sign-in-popup #reset-passw-form {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	max-height: 0;
	overflow: hidden
}

#sign-in-popup #reset-passw-form.show {
	max-height: 200px
}

footer {
	background-color: #16161a;
	color: #fff;
	padding: 42px 0 66px
}

footer ._cont {
	position: relative
}

footer .left {
	float: left;
	width: 50%
}

footer .right {
	float: right;
	text-align: right;
	width: 50%
}

footer .top .left {
	font-size: 138.46154%;
	line-height: 188.88889%;
	padding-top: 8px
}

footer .top .left .phone {
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE3cHgiIGhlaWdodD0iMTdweCIgdmlld0JveD0iMCAwIDE3IDE3IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC04NC4wMDAwMDAsIC0xNDUyLjAwMDAwMCkiIGZpbGw9IiNGRkZGRkYiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMy4wMDAwMDAsIDEyNDYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgwLjAwMDAwMCwgMTQ2LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDg3LjAwMDAwMCwgNDQuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgICAgIDxnPgogICAgICAgICAgICAgICAgICAgICAgICAgICAgPHBhdGggZD0iTTIuNDUxNDI3MTQsMTYuNDk5MTkwMiBMMS40NDAyMzY2MSwxNy4yMzkzODE2IEMwLjUwMTEwOTEyMywxNy45MjY3MDIzIDAuMTE1NDA1MjA2LDE5LjExMzI0OTEgMC40NzkxODI0NzEsMjAuMTkxODM4NCBDMi4zNDM3MTcyNywyNS43MTE2OTk4IDYuODYyMzM4NjgsMzAuMTYzODY2IDEyLjU2NjczMDQsMzIuMTAwNzU5OSBDMTMuNTY2NjM3LDMyLjQ0MDc1OCAxNC43NDI0MDU2LDMyLjE4MDQwNDYgMTUuNDg0OTYyNiwzMS40NTg4NjI2IEwxNi42NDE0MzMyLDMwLjMzNTUyNjkgQzE2Ljg4MDU3NDgsMzAuMTAyNTAxNCAxNy4wMTI3MTE3LDI5Ljc5NjA0NzYgMTcuMDEyNzExNywyOS40NzE2ODI5IEMxNy4wMTI3MTE3LDI5LjAwODk1NTUgMTYuNzQ0NzE5MywyOC41ODkxMjggMTYuMzEyNjYxNywyOC4zNzYyOTA2IEwxMi45ODkzNjM0LDI2LjczNzIzMzcgQzEyLjg1NTM2NzIsMjYuNjcxMzc1OSAxMi42OTE5NDMxLDI2LjcyOTQxNjkgMTIuNjI5MzY4OCwyNi43ODQ2ODgxIEwxMi4yNDExNjQ1LDI3LjEyNjcxNzQgQzExLjI4Mzg5MywyNy45Njk5NDI0IDEwLjIwNzgyNTIsMjcuNzUyMzI0NyA5LjA1MDcxMzQ1LDI3LjE4MDEwMTIgQzcuNTYwMDIxNjYsMjYuNDQyODY0IDYuMzY1MzM5NjgsMjUuMjk3ODYzIDUuNTk4NDE5NzYsMjMuODY4ODEyMiBDNC45OTExNDEyNSwyMi43Mzg0NTk5IDQuNzc0ODgyOTIsMjEuNzYwNjY3NyA1LjY3MTM3NTI1LDIwLjgyNTA1NzMgTDYuMDI2NDk3MjYsMjAuNDUzNjY5IEM2LjA2NTI4NTYzLDIwLjQxMzI5MjcgNi4xMTE2MzkzNSwyMC4zNDQ0ODA2IDYuMTExNjM5MzUsMjAuMjQ2MzA5NSBDNi4xMTE2MzkzNSwyMC4xOTc2MjQxIDYuMDk5NjUwMjEsMjAuMTUwOTY5NyA2LjA3NjU2OTUzLDIwLjEwNzcwMDYgTDQuMzY3ODkzNDgsMTYuOTE5Njk0OCBDNC4xNDYyNTQ3NywxNi41MDU0NjgyIDMuNzA4NjE5MzEsMTYuMjQ4NSAzLjIyNjU1MzUzLDE2LjI0ODUgQzIuOTQyOTE3NTMsMTYuMjQ4NSAyLjY3NDkyNTEyLDE2LjMzNTQ2OTEgMi40NTE0MjcxNCwxNi40OTkxOTAyIFoiPjwvcGF0aD4KICAgICAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgPC9nPgogICAgICAgIDwvZz4KICAgIDwvZz4KPC9zdmc+')
		no-repeat left 9px;
	display: inline-block;
	margin-right: 75px;
	padding-left: 26px
}

footer .top .left a.mail {
	display: inline-block;
	padding-left: 28px;
	position: relative
}

footer .top .left a.mail:before {
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjIwcHgiIGhlaWdodD0iMTE2cHgiIHZpZXdCb3g9IjAgMCAyMCAxMTYiIHZlcnNpb249IjEuMSIgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgeG1sbnM6c2tldGNoPSJodHRwOi8vd3d3LmJvaGVtaWFuY29kaW5nLmNvbS9za2V0Y2gvbnMiPgogICAgPGcgc3Ryb2tlPSJub25lIiBzdHJva2Utd2lkdGg9IjEiIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCI+CiAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTMzNy4wMDAwMDAsIC0xNDUzLjAwMDAwMCkiIGZpbGw9IiNGRkZGRkYiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMy4wMDAwMDAsIDEyNDYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgwLjAwMDAwMCwgMTQ2LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDg3LjAwMDAwMCwgNDQuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDI1My4wMDAwMDAsIDAuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMS4yNSwxNyBDMC41NTk2ODc1LDE3IDAsMTcuNTUxMDc0OCAwLDE4LjIzMDc2NDUgTDAsMzEuNzY5MTc0IEMwLDMyLjQ0ODkyNTIgMC41NTk2ODc1LDMzIDEuMjUsMzMgTDE4Ljc1LDMzIEMxOS40NDAzMTI1LDMzIDIwLDMyLjQ0ODkyNTIgMjAsMzEuNzY5MTc0IEwyMCwxOC4yMzA3NjQ1IEMyMCwxNy41NTEwNzQ4IDE5LjQ0MDMxMjUsMTcgMTguNzUsMTcgTDEuMjUsMTcgTDEuMjUsMTcgWiBNMTguMTI1LDE4Ljg0NjE0NjcgTDE4LjEyNSwxOS4zMjkzNDQ5IEwxMCwyNi4wNDIwNTc1IEwxLjg3NSwxOS4zMjkzNDQ5IEwxLjg3NSwxOC44NDYxNDY3IEwxOC4xMjUsMTguODQ2MTQ2NyBMMTguMTI1LDE4Ljg0NjE0NjcgWiBNMS44NzUsMzEuMTUzNzkxNyBMMS44NzUsMjEuNzM5MTgxOCBMOS4xOTY1LDI3Ljc4ODE0MzEgQzkuNDI5MzEyNSwyNy45ODA0NTAxIDkuNzE0Njg3NSwyOC4wNzY4ODA1IDEwLDI4LjA3Njg4MDUgQzEwLjI4NTMxMjUsMjguMDc2ODgwNSAxMC41NzA2ODc1LDI3Ljk4MDQ1MDEgMTAuODAzNSwyNy43ODgxNDMxIEwxOC4xMjUsMjEuNzM5MTgxOCBMMTguMTI1LDMxLjE1Mzc5MTcgTDEuODc1LDMxLjE1Mzc5MTcgTDEuODc1LDMxLjE1Mzc5MTcgWiI+PC9wYXRoPgogICAgICAgICAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICAgICAgPC9nPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgogICAgPGcgc3Ryb2tlPSJub25lIiBzdHJva2Utd2lkdGg9IjEiIGZpbGw9Im5vbmUiIGZpbGwtcnVsZT0iZXZlbm9kZCIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMCwxMDApIj4KICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMzM3LjAwMDAwMCwgLTE0NTMuMDAwMDAwKSIgZmlsbD0iIzA4NmZjZiI+CiAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0zLjAwMDAwMCwgMTI0Ni4wMDAwMDApIj4KICAgICAgICAgICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKDAuMDAwMDAwLCAxNDYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoODcuMDAwMDAwLCA0NC4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMjUzLjAwMDAwMCwgMC4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICAgICAgICAgIDxwYXRoIGQ9Ik0xLjI1LDE3IEMwLjU1OTY4NzUsMTcgMCwxNy41NTEwNzQ4IDAsMTguMjMwNzY0NSBMMCwzMS43NjkxNzQgQzAsMzIuNDQ4OTI1MiAwLjU1OTY4NzUsMzMgMS4yNSwzMyBMMTguNzUsMzMgQzE5LjQ0MDMxMjUsMzMgMjAsMzIuNDQ4OTI1MiAyMCwzMS43NjkxNzQgTDIwLDE4LjIzMDc2NDUgQzIwLDE3LjU1MTA3NDggMTkuNDQwMzEyNSwxNyAxOC43NSwxNyBMMS4yNSwxNyBMMS4yNSwxNyBaIE0xOC4xMjUsMTguODQ2MTQ2NyBMMTguMTI1LDE5LjMyOTM0NDkgTDEwLDI2LjA0MjA1NzUgTDEuODc1LDE5LjMyOTM0NDkgTDEuODc1LDE4Ljg0NjE0NjcgTDE4LjEyNSwxOC44NDYxNDY3IEwxOC4xMjUsMTguODQ2MTQ2NyBaIE0xLjg3NSwzMS4xNTM3OTE3IEwxLjg3NSwyMS43MzkxODE4IEw5LjE5NjUsMjcuNzg4MTQzMSBDOS40MjkzMTI1LDI3Ljk4MDQ1MDEgOS43MTQ2ODc1LDI4LjA3Njg4MDUgMTAsMjguMDc2ODgwNSBDMTAuMjg1MzEyNSwyOC4wNzY4ODA1IDEwLjU3MDY4NzUsMjcuOTgwNDUwMSAxMC44MDM1LDI3Ljc4ODE0MzEgTDE4LjEyNSwyMS43MzkxODE4IEwxOC4xMjUsMzEuMTUzNzkxNyBMMS44NzUsMzEuMTUzNzkxNyBMMS44NzUsMzEuMTUzNzkxNyBaIj48L3BhdGg+CiAgICAgICAgICAgICAgICAgICAgICAgIDwvZz4KICAgICAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPg==')
		no-repeat left top;
	content: "";
	height: 16px;
	left: 0;
	position: absolute;
	top: 10px;
	width: 20px
}

footer .top .left a.mail:hover {
	color: rgba(255, 255, 255, 0.7)
}

footer .top form {
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	border: 1px solid #46464a;
	display: inline-block
}

footer .top form input {
	font-family: "montserratlight", sans-serif;
	font-size: 107.69231%;
	line-height: 121.42857%;
	background-color: transparent;
	border: 0 none;
	color: #fff;
	padding: 15px 12px;
	width: 320px
}

footer .top form input:-moz-placeholder {
	color: #46464a;
	opacity: 1
}

footer .top form input::-moz-placeholder {
	color: #46464a;
	opacity: 1
}

footer .top form input:-ms-input-placeholder {
	color: #46464a;
	opacity: 1
}

footer .top form input::-webkit-input-placeholder {
	color: #46464a;
	opacity: 1
}

footer .top form button {
	font-family: "montserratbold", sans-serif;
	font-size: 107.69231%;
	line-height: 121.42857%;
	background-color: transparent;
	border: 0 none;
	color: #fff;
	margin-right: 4px
}

footer .top form button:hover {
	color: rgba(255, 255, 255, 0.7)
}

footer .bottom {
	font-size: 107.69231%;
	line-height: 128.57143%;
	padding-top: 101px
}

footer .bottom .left nav li {
	float: left;
	list-style-type: none
}

footer .bottom .left nav li a {
	display: inline-block
}

footer .bottom .left a {
	display: inline-block;
	opacity: 0.64;
	text-decoration: underline
}

footer .bottom .left a:hover {
	opacity: 1
}

footer .bottom .left li {
	margin-right: 32px
}

footer .bottom .left li:last-child {
	margin-right: 0
}

footer .socials {
	bottom: 0;
	position: absolute;
	right: 0
}

.flash-message {
	-moz-transition: all 0.3s ease-in-out 0s;
	-o-transition: all 0.3s ease-in-out 0s;
	-webkit-transition: all 0.3s ease-in-out;
	-webkit-transition-delay: 0s;
	transition: all 0.3s ease-in-out 0s;
	display: block;
	left: 0;
	position: fixed;
	text-align: center;
	top: 92px;
	width: 100%
}

.flash-message.remove {
	opacity: 0.5;
	top: -50px
}

.flash-message div {
	font-size: 92.30769%;
	line-height: 125%;
	background-color: #16161a;
	color: #fff;
	display: inline-block;
	padding: 10px 12px
}

.flash-message span {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjEycHgiIGhlaWdodD0iMTNweCIgdmlld0JveD0iMCAwIDEyIDEzIiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC04MjcuMDAwMDAwLCAtMTc4LjAwMDAwMCkiIGZpbGw9IiNmZmZmZmYiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSg0MzAuMDAwMDAwLCAxNjguMDAwMDAwKSI+CiAgICAgICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgzOTYuMDAwMDAwLCAxMC4wMDAwMDApIj4KICAgICAgICAgICAgICAgICAgICA8cmVjdCB0cmFuc2Zvcm09InRyYW5zbGF0ZSg3LjAwMDAwMCwgNi41MDAwMDApIHJvdGF0ZSgtMzE1LjAwMDAwMCkgdHJhbnNsYXRlKC03LjAwMDAwMCwgLTYuNTAwMDAwKSAiIHg9Ii0xIiB5PSI2IiB3aWR0aD0iMTYiIGhlaWdodD0iMSIgcng9IjEiPjwvcmVjdD4KICAgICAgICAgICAgICAgICAgICA8cmVjdCB0cmFuc2Zvcm09InRyYW5zbGF0ZSg3LjAwMDAwMCwgNi41MDAwMDApIHNjYWxlKC0xLCAxKSByb3RhdGUoLTMxNS4wMDAwMDApIHRyYW5zbGF0ZSgtNy4wMDAwMDAsIC02LjUwMDAwMCkgIiB4PSItMSIgeT0iNiIgd2lkdGg9IjE2IiBoZWlnaHQ9IjEiIHJ4PSIxIj48L3JlY3Q+CiAgICAgICAgICAgICAgICA8L2c+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPg==')
		no-repeat left top;
	content: "";
	cursor: pointer;
	display: inline-block;
	height: 14px;
	margin-left: 28px;
	position: relative;
	top: 2px;
	width: 14px
}

.flash-message span:hover {
	opacity: 0.7
}

@media only screen and (min-width: 1200px) {
	div.grid_info:after {
		content: "> 1200px"
	}
}

@media only screen and (min-width: 1600px) {
	div.grid_info:after {
		content: "> 1600px"
	}
}

@media only screen and (max-width: 1200px) {
	div.grid_info:after {
		content: "< 1200px"
	}
	._cont {
		width: 89%
	}
}

@media only screen and (max-width: 1170px) {
	div.grid_info:after {
		content: "< 1170px"
	}
	footer .top .left {
		font-size: 107.69231%;
		line-height: 242.85714%
	}
	footer .top .left .phone {
		margin-right: 45px
	}
	footer .top form input {
		width: 280px
	}
}

@media only screen and (max-width: 850px) {
	div.grid_info:after {
		content: "< 850px"
	}
	header .logo {
		letter-spacing: 2px
	}
	._cont, .text {
		width: 90%
	}
	.text {
		padding: 160px 0 120px
	}
	.text h1 {
		font-size: 276.92308%;
		line-height: 116.66667%;
		margin-bottom: 40px
	}
	.text h2 {
		font-size: 161.53846%;
		line-height: 133.33333%
	}
	.text p {
		font-size: 130.76923%;
		line-height: 164.70588%
	}
	.text ul {
		font-size: 107.69231%;
		line-height: 171.42857%
	}
	.text ul li:before {
		top: 17px
	}
	.text ol {
		font-size: 107.69231%;
		line-height: 171.42857%
	}
	.collection .settings {
		font-size: 100%;
		line-height: 123.07692%
	}
	.collection-list a {
		font-size: 92.30769%;
		line-height: 125%
	}
	.homepage .collection-list.featured {
		padding-top: 200px
	}
	footer {
		padding: 21px 0 26px
	}
	footer .left, footer .right {
		float: none;
		text-align: center;
		width: 100%
	}
	footer .top .left {
		font-size: 92.30769%;
		line-height: 283.33333%
	}
	footer .top .left .phone {
		-moz-background-size: auto 12px;
		-o-background-size: auto 12px;
		-webkit-background-size: auto 12px;
		background-size: auto 12px;
		background-position: left 12px;
		margin-right: 25px;
		padding-left: 16px
	}
	footer .top .left a.mail {
		padding-left: 19px
	}
	footer .top .left a.mail:before {
		-moz-background-size: 100%;
		-o-background-size: 100%;
		-webkit-background-size: 100%;
		background-size: 100%;
		height: 12px;
		top: 12px;
		width: 15px
	}
	footer .top .right {
		margin-bottom: 7px
	}
	footer .top form input {
		font-size: 92.30769%;
		line-height: 141.66667%;
		padding: 12px;
		width: 224px
	}
	footer .top form button {
		font-size: 92.30769%;
		line-height: 141.66667%;
		margin-right: 4px
	}
	footer .bottom {
		font-size: 92.30769%;
		line-height: 150%;
		padding-top: 55px
	}
	footer .bottom .left nav li {
		display: inline-block;
		float: none;
		margin-right: 36px
	}
	footer .socials {
		font-size: 92.30769%;
		line-height: 141.66667%;
		bottom: auto;
		margin-bottom: 24px;
		position: static;
		right: auto;
		text-align: center
	}
	footer .socials li {
		margin: 0 23px
	}
	footer .socials strong {
		display: block;
		margin-bottom: 12px
	}
	footer .socials .tw {
		top: 14px
	}
}

@media only screen and (max-width: 760px) {
	div.grid_info:after {
		content: "< 760px"
	}
	.text, ._cont2 {
		width: 90%
	}
	header nav>ul>li ul {
		left: 0;
		margin: 0 5%;
		width: 90%
	}
	.spinner .q {
		margin-right: 10px
	}
	.product-detail #AddToCart {
		background-position: -1000px center;
		padding: 14px 16px
	}
	.homepage .main-services {
		padding: 54px 0 24px
	}
	.homepage .main-services li {
		float: none;
		padding: 10px 0;
		text-align: center;
		width: 100%
	}
	.homepage .main-services li:nth-child(3) {
		text-align: center
	}
	.homepage .main-text {
		padding-top: 35px
	}
	.homepage .main-text h1 {
		font-size: 276.92308%;
		line-height: 108.33333%;
		margin-bottom: 22px
	}
	.homepage .main-text .links {
		padding: 14px 0 30px;
		text-align: center
	}
	.homepage .main-text .links .about {
		float: none
	}
	.homepage .main-text .links .socials {
		float: none
	}
	.homepage .main-text .links .socials strong {
		display: block;
		margin: 35px 0 5px
	}
	.homepage .main-text .links .socials li {
		margin: 0 22px
	}
	.homepage .main-text .links .socials li a {
		-moz-transform: scale(1.22);
		-ms-transform: scale(1.22);
		-webkit-transform: scale(1.22);
		transform: scale(1.22)
	}
	.homepage .collection-list.featured {
		padding-top: 160px
	}
	.homepage .homepage-banners.collection-list a {
		float: none;
		margin-bottom: 25px;
		width: 100%
	}
}

@media only screen and (max-width: 600px) {
	div.grid_info:after {
		content: "< 600px"
	}
	header .header #customer_login_link:after, header .header nav>ul>li a:after
		{
		background: transparent
			url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4NCjwhRE9DVFlQRSBzdmcgUFVCTElDICItLy9XM0MvL0RURCBTVkcgMS4xLy9FTiIgImh0dHA6Ly93d3cudzMub3JnL0dyYXBoaWNzL1NWRy8xLjEvRFREL3N2ZzExLmR0ZCI+DQo8c3ZnIHZlcnNpb249IjEuMSIgaWQ9IlZyc3R2YV8xIiB4bWxuczpza2V0Y2g9Imh0dHA6Ly93d3cuYm9oZW1pYW5jb2RpbmcuY29tL3NrZXRjaC9ucyINCgkgeG1sbnM9Imh0dHA6Ly93d3cudzMub3JnLzIwMDAvc3ZnIiB4bWxuczp4bGluaz0iaHR0cDovL3d3dy53My5vcmcvMTk5OS94bGluayIgeD0iMHB4IiB5PSIwcHgiIHdpZHRoPSI3cHgiIGhlaWdodD0iOHB4Ig0KCSB2aWV3Qm94PSIzIC0yIDcgOCIgZW5hYmxlLWJhY2tncm91bmQ9Im5ldyAzIC0yIDcgOCIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+DQo8Zz4NCgk8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMTQ3LjAwMDAwMCwgLTU2NS4wMDAwMDApIj4NCgkJPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTAwLjAwMDAwMCwgMzQwLjAwMDAwMCkiPg0KCQkJPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoOS4wMDAwMDAsIDIxOC4wMDAwMDApIj4NCgkJCQk8Zz4NCgkJCQkJPHBhdGggaWQ9IlBhdGgtNjctQ29weSIgZmlsbD0ibm9uZSIgc3Ryb2tlPSIjRkZGRkZGIiBkPSJNNDEsMTNsNC00bC00LTQiLz4NCgkJCQk8L2c+DQoJCQk8L2c+DQoJCTwvZz4NCgk8L2c+DQo8L2c+DQo8L3N2Zz4NCg==')
			no-repeat center center;
		content: "";
		display: block;
		height: 100%;
		margin-top: 0;
		position: absolute;
		right: 26px;
		top: 0;
		width: 7px
	}
	header ._cont {
		width: 100%
	}
	header form, header #customer_login_link, header nav {
		display: none
	}
	header .header {
		-moz-box-shadow: none;
		-webkit-box-shadow: none;
		box-shadow: none;
		height: auto
	}
	header .header form {
		-moz-border-radius: 0;
		-webkit-border-radius: 0;
		border-radius: 0;
		background-color: #16161a;
		border: 0 none;
		border-bottom: 1px solid #2e2e38;
		display: block;
		float: none;
		height: 54px;
		left: 0;
		margin-top: 0;
		padding: 8px 5% 0;
		width: 100%
	}
	header .header form .find-input {
		font-size: 92.30769%;
		line-height: 141.66667%;
		background-color: #16161a;
		color: #fff;
		padding-left: 0;
		width: 91%;
		width: calc(100% - 27px)
	}
	header .header form .find-input:-moz-placeholder {
		color: #b5b6bd
	}
	header .header form .find-input::-moz-placeholder {
		color: #b5b6bd
	}
	header .header form .find-input:-ms-input-placeholder {
		color: #b5b6bd
	}
	header .header form .find-input::-webkit-input-placeholder {
		color: #b5b6bd
	}
	header .header form button {
		background-image:
			url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE0cHgiIGhlaWdodD0iMTRweCIgdmlld0JveD0iMCAwIDE0IDE0IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC00OTQuMDAwMDAwLCAtMTI5Ny4wMDAwMDApIiBmaWxsPSIjRkZGRkZGIj4KICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTMuMDAwMDAwLCAxMjQ2LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgPHBhdGggZD0iTTUwNS43NTAwNDQsNTEgQzUwMi44NTA3MzEsNTEgNTAwLjUsNTMuMzUwNjQzNyA1MDAuNSw1Ni4yNDk5NTYzIEM1MDAuNSw1Ny40NjI5Njg4IDUwMC45MTUzMTksNTguNTc2NzU2MyA1MDEuNjA2NjEyLDU5LjQ2NTQwNjMgTDQ5Ny4xOTIzMjUsNjMuODc5NzM3NSBDNDk3LjA2NDEzOCw2NC4wMDc5MjUgNDk3LDY0LjE3NTM1NjIgNDk3LDY0LjM0MzcwNjMgQzQ5Nyw2NC41MTE2NjI1IDQ5Ny4wNjQxMzgsNjQuNjc5NTMxMyA0OTcuMTkyMzI1LDY0LjgwNzcxODggQzQ5Ny4zMjA0NjksNjQuOTM1OTA2MiA0OTcuNDg4MzgxLDY1IDQ5Ny42NTYyOTQsNjUgQzQ5Ny44MjQxNjIsNjUgNDk3Ljk5MjA3NSw2NC45MzU5MDYyIDQ5OC4xMjAyNjMsNjQuODA3NzE4OCBMNTAyLjUzNDU1LDYwLjM5MzQzMTIgQzUwMy40MjMyNDQsNjEuMDg0NzI1IDUwNC41MzcwMzEsNjEuNDk5OTU2MyA1MDUuNzUwMDQ0LDYxLjQ5OTk1NjMgQzUwOC42NDkzMTIsNjEuNDk5OTU2MyA1MTEuMDAwMDQ0LDU5LjE0OTI2ODcgNTExLjAwMDA0NCw1Ni4yNDk5NTYzIEM1MTEuMDAwMDQ0LDUzLjM1MDY0MzcgNTA4LjY0OTMxMiw1MSA1MDUuNzUwMDQ0LDUxIEw1MDUuNzUwMDQ0LDUxIFogTTUwNS43NTAwNDQsNjAuMTg3NSBDNTAzLjU3ODczMSw2MC4xODc1IDUwMS44MTI1NDQsNTguNDIxMjI1IDUwMS44MTI1NDQsNTYuMjQ5OTU2MyBDNTAxLjgxMjU0NCw1NC4wNzg2ODc1IDUwMy41Nzg3MzEsNTIuMzEyNDU2MyA1MDUuNzUwMDQ0LDUyLjMxMjQ1NjMgQzUwNy45MjEyNjksNTIuMzEyNDU2MyA1MDkuNjg3NSw1NC4wNzg2ODc1IDUwOS42ODc1LDU2LjI0OTk1NjMgQzUwOS42ODc1LDU4LjQyMTIyNSA1MDcuOTIxMjY5LDYwLjE4NzUgNTA1Ljc1MDA0NCw2MC4xODc1IEw1MDUuNzUwMDQ0LDYwLjE4NzUgWiI+PC9wYXRoPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4=');
		margin-right: 0
	}
	header .header #customer_login_link {
		font-size: 92.30769%;
		line-height: 141.66667%;
		background-color: #16161a;
		border-bottom: 1px solid #2e2e38;
		color: #fff;
		display: block;
		float: none;
		height: 54px;
		left: 0;
		margin: 0;
		opacity: 1;
		padding: 18px 5% 0;
		width: 100%;
		z-index: 1000
	}
	header .header #customer_login_link:hover {
		color: #fff
	}
	header .header nav {
		font-family: "montserratlight", sans-serif;
		font-size: 92.30769%;
		line-height: 141.66667%;
		background-color: #16161a;
		display: block;
		position: static;
		text-transform: none;
		z-index: 1000
	}
	header .header nav>ul>li {
		display: block;
		margin: 0
	}
	header .header nav>ul>li a {
		border-bottom: 1px solid #2e2e38;
		color: #fff;
		display: block;
		height: 54px;
		opacity: 1;
		padding: 18px 5% 0;
		text-align: left
	}
	header .header nav>ul>li a:hover {
		color: #fff
	}
	header .header nav>ul>li a:hover:before {
		opacity: 0
	}
	header .header nav>ul>li a:hover:after {
		opacity: 1
	}
	header .header nav>ul>li a:after {
		-moz-transform: rotate(90deg);
		-ms-transform: rotate(90deg);
		-webkit-transform: rotate(90deg);
		transform: rotate(90deg);
		right: 28px
	}
	header .header nav>ul>li ul {
		-moz-transition: 0.1s;
		-o-transition: 0.1s;
		-webkit-transition: 0.1s;
		transition: 0.1s;
		-moz-column-count: 1;
		-webkit-column-count: 1;
		column-count: 1;
		-moz-column-gap: 0;
		-webkit-column-gap: 0;
		column-gap: 0;
		-moz-border-radius: 0;
		-webkit-border-radius: 0;
		border-radius: 0;
		background-color: transparent;
		left: auto;
		margin: 0;
		max-height: 0;
		overflow: hidden;
		padding: 0;
		position: static;
		top: auto;
		width: 100%
	}
	header .header nav>ul>li ul li {
		background: transparent
			url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4KPHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IgoJIHZpZXdCb3g9IjAgMCAxNSAxMDAiIHdpZHRoPSIxNSIgaGVpZ2h0PSIxMDAiIGVuYWJsZS1iYWNrZ3JvdW5kPSJuZXcgMCAwIDE1IDEwMCIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CiAgICA8bGluZSB4MT0iMCIgeTE9IjAiIHgyPSIwIiB5Mj0iMTAwIiBzdHJva2U9IiMyZTJlMzgiIHN0cm9rZS13aWR0aD0iMSIgLz4KICAgIDxsaW5lIHgxPSIwIiB5MT0iNTAiIHgyPSIxNSIgeTI9IjUwIiBzdHJva2U9IiMyZTJlMzgiIHN0cm9rZS13aWR0aD0iMSIgLz4KPC9zdmc+')
			no-repeat 27px center;
		border-bottom: 0 none;
		padding-left: 50px;
		position: relative
	}
	header .header nav>ul>li ul li:first-child:after {
		background-color: #16161a;
		content: "";
		display: block;
		height: 8px;
		left: 0;
		position: absolute;
		top: 0;
		width: 100%
	}
	header .header nav>ul>li ul li:last-child {
		background-image:
			url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0idXRmLTgiPz4KPCFET0NUWVBFIHN2ZyBQVUJMSUMgIi0vL1czQy8vRFREIFNWRyAxLjEvL0VOIiAiaHR0cDovL3d3dy53My5vcmcvR3JhcGhpY3MvU1ZHLzEuMS9EVEQvc3ZnMTEuZHRkIj4KPHN2ZyB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHg9IjBweCIgeT0iMHB4IgoJIHZpZXdCb3g9IjAgMCAxNSAxMDAiIHdpZHRoPSIxNSIgaGVpZ2h0PSIxMDAiIGVuYWJsZS1iYWNrZ3JvdW5kPSJuZXcgMCAwIDE1IDEwMCIgeG1sOnNwYWNlPSJwcmVzZXJ2ZSI+CiAgICA8bGluZSB4MT0iMCIgeTE9IjAiIHgyPSIwIiB5Mj0iNTAiIHN0cm9rZT0iIzJlMmUzOCIgc3Ryb2tlLXdpZHRoPSIxIiAvPgogICAgPGxpbmUgeDE9IjAiIHkxPSI1MCIgeDI9IjE1IiB5Mj0iNTAiIHN0cm9rZT0iIzJlMmUzOCIgc3Ryb2tlLXdpZHRoPSIxIiAvPgo8L3N2Zz4=')
	}
	header .header nav>ul>li ul a {
		padding-left: 0
	}
	header .header nav>ul>li ul a:hover {
		opacity: 1
	}
	header .header nav>ul>li.categories-open a:after {
		-moz-transform: rotate(-90deg);
		-ms-transform: rotate(-90deg);
		-webkit-transform: rotate(-90deg);
		transform: rotate(-90deg)
	}
	header .header nav>ul>li.categories-open a:hover:after {
		-moz-transform: rotate(-90deg);
		-ms-transform: rotate(-90deg);
		-webkit-transform: rotate(-90deg);
		transform: rotate(-90deg)
	}
	header .header nav>ul>li.categories-open ul {
		-moz-transition: all 0.3s ease-in-out;
		-o-transition: all 0.3s ease-in-out;
		-webkit-transition: all 0.3s ease-in-out;
		transition: all 0.3s ease-in-out;
		max-height: 2000px
	}
	header .header nav>ul>li.categories-open ul:after {
		display: none
	}
	header .header nav>ul>li.categories-open ul a:after {
		-moz-transform: rotate(0deg);
		-ms-transform: rotate(0deg);
		-webkit-transform: rotate(0deg);
		transform: rotate(0deg)
	}
	header .header nav>ul>li.categories-open ul a:hover:after {
		-moz-transform: rotate(0deg);
		-ms-transform: rotate(0deg);
		-webkit-transform: rotate(0deg);
		transform: rotate(0deg)
	}
	header .shadow {
		-moz-box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px,
			rgba(19, 20, 20, 0.06) 0 1px 1px;
		-webkit-box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px,
			rgba(19, 20, 20, 0.06) 0 1px 1px;
		box-shadow: rgba(17, 17, 18, 0.04) 0 2px 4px, rgba(19, 20, 20, 0.06) 0
			1px 1px;
		height: 52px;
		position: relative
	}
	header .logo {
		letter-spacing: 1px;
		margin-left: 4.5%;
		margin-top: 18px
	}
	header #nav-icon {
		-moz-transition: all 0.3s ease-in-out;
		-o-transition: all 0.3s ease-in-out;
		-webkit-transition: all 0.3s ease-in-out;
		transition: all 0.3s ease-in-out;
		cursor: pointer;
		display: inline-block;
		height: 15px;
		position: relative;
		width: 16px;
		-webkit-transform: rotate(0deg);
		-moz-transform: rotate(0deg);
		-o-transform: rotate(0deg);
		transform: rotate(0deg)
	}
	header #nav-icon span {
		-moz-transition: all 0.3s ease-in-out;
		-o-transition: all 0.3s ease-in-out;
		-webkit-transition: all 0.3s ease-in-out;
		transition: all 0.3s ease-in-out;
		background-color: #16161a;
		display: block;
		height: 1px;
		left: 0;
		opacity: 1;
		position: absolute;
		width: 100%;
		-webkit-transform: rotate(0deg);
		-moz-transform: rotate(0deg);
		-o-transform: rotate(0deg);
		transform: rotate(0deg)
	}
	header #nav-icon span:nth-child(1) {
		top: 2px
	}
	header #nav-icon span:nth-child(2), header #nav-icon span:nth-child(3) {
		top: 7px
	}
	header #nav-icon span:nth-child(4) {
		top: 12px
	}
	header #nav-icon:hover span:nth-child(1) {
		top: 0
	}
	header #nav-icon:hover span:nth-child(4) {
		top: 14px
	}
	.show-menu #nav-icon span:nth-child(1) {
		top: 18px;
		width: 0%;
		left: 50%
	}
	.show-menu #nav-icon span:nth-child(2) {
		-webkit-transform: rotate(45deg);
		-moz-transform: rotate(45deg);
		-o-transform: rotate(45deg);
		transform: rotate(45deg)
	}
	.show-menu #nav-icon span:nth-child(3) {
		-webkit-transform: rotate(-45deg);
		-moz-transform: rotate(-45deg);
		-o-transform: rotate(-45deg);
		transform: rotate(-45deg)
	}
	.show-menu #nav-icon span:nth-child(4) {
		top: 18px;
		width: 0%;
		left: 50%
	}
	header #nav-icon {
		position: absolute;
		right: 4.5%;
		top: 20px
	}
	header #nav-icon:before {
		font-size: 107.69231%;
		line-height: 128.57143%;
		content: "Menu";
		right: 0;
		padding-right: 24px;
		position: absolute;
		top: -2px
	}
	header .mobile-menu {
		-moz-transition: 0.1s;
		-o-transition: 0.1s;
		-webkit-transition: 0.1s;
		transition: 0.1s;
		max-height: 0;
		overflow: hidden
	}
	.show-menu header #nav-icon:before {
		font-size: 107.69231%;
		line-height: 128.57143%;
		content: "Close"
	}
	.show-menu header .shadow:after {
		background: transparent
			url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjEycHgiIGhlaWdodD0iN3B4IiB2aWV3Qm94PSIwIDAgMTIgNyIgdmVyc2lvbj0iMS4xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4bWxuczpza2V0Y2g9Imh0dHA6Ly93d3cuYm9oZW1pYW5jb2RpbmcuY29tL3NrZXRjaC9ucyI+CiAgICA8ZyBzdHJva2U9Im5vbmUiIHN0cm9rZS13aWR0aD0iMSIgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj4KICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMTE3NS4wMDAwMDAsIC0xMzAzLjAwMDAwMCkiIGZpbGw9IiMwQzBDMTkiIG9wYWNpdHk9IjAuOTM5OTk5OTk4Ij4KICAgICAgICAgICAgPGcgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoLTMuMDAwMDAwLCAxMjQ2LjAwMDAwMCkiPgogICAgICAgICAgICAgICAgPHBhdGggZD0iTTExNzgsNjMuNDg1MjgxNCBMMTE4My42NTY4NSw1Ny44Mjg0MjcxIEwxMTg5LjMxMzcxLDYzLjQ4NTI4MTQgTDExNzgsNjMuNDg1MjgxNCBaIiBpZD0iU2lwa2EtbWVudSI+PC9wYXRoPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4=')
			no-repeat left top;
		bottom: -1px;
		content: "";
		display: block;
		height: 7px;
		position: absolute;
		right: 38px;
		width: 12px
	}
	.show-menu header .mobile-menu {
		-moz-transition: 2s;
		-o-transition: 2s;
		-webkit-transition: 2s;
		transition: 2s;
		max-height: 5000px
	}
	.breadcrumb {
		display: none
	}
	.text {
		padding: 20px 0 96px
	}
	.text h1 {
		font-size: 184.61538%;
		line-height: 133.33333%;
		margin-bottom: 25px
	}
	.text h2 {
		font-size: 138.46154%;
		line-height: 133.33333%;
		margin: 35px 0 17px
	}
	.text p {
		font-size: 107.69231%;
		line-height: 171.42857%;
		margin: 17px 0 23px
	}
	.text ul {
		font-size: 100%;
		line-height: 169.23077%;
		margin-left: 15px
	}
	.text ul li:before {
		top: 16px
	}
	.text ol {
		font-size: 100%;
		line-height: 169.23077%;
		margin-left: 15px
	}
	.collection {
		padding-top: 30px
	}
	.collection h1 {
		font-size: 276.92308%;
		line-height: 116.66667%
	}
	.collection .description {
		font-size: 92.30769%;
		line-height: 200%;
		text-align: justify;
		-ms-text-align-last: center;
		-moz-text-align-last: center;
		-webkit-text-align-last: center;
		text-align-last: center
	}
	.collection .head {
		padding-bottom: 15px
	}
	.collection .settings .count {
		float: left;
		left: auto;
		position: relative;
		width: auto
	}
	.collection .settings .view {
		display: none
	}
	.collection .products {
		padding: 16px 0 60px
	}
	.collection .more-products {
		padding-top: 20px
	}
	.collection-list {
		margin-top: 26px
	}
	.collection-list.cols-4 a, .collection-list.cols-3 a {
		width: 48.27586%;
		float: left;
		margin-right: 3.44828%;
		margin-bottom: 5.26316%
	}
	.collection-list.cols-4 a:nth-child(3n), .collection-list.cols-3 a:nth-child(3n)
		{
		width: 48.27586%;
		float: left;
		margin-right: 3.44828%
	}
	.collection-list.cols-4 a:nth-child(3n+1), .collection-list.cols-3 a:nth-child(3n+1)
		{
		clear: none
	}
	.collection-list.cols-4 a:nth-child(2n), .collection-list.cols-3 a:nth-child(2n)
		{
		float: right;
		margin-right: 0
	}
	.collection-list.cols-4 a:nth-child(2n+1), .collection-list.cols-3 a:nth-child(2n+1)
		{
		clear: both
	}
	.collection-list a>span {
		left: 0;
		max-width: 100%
	}
	.collection-list a>span strong {
		font-family: "robotolight", sans-serif
	}
	.collection-list a .variants .variant {
		float: none;
		width: auto
	}
	.collection-list a .variants .variant:nth-child(2n) {
		text-align: left
	}
	.product-detail {
		padding-top: 0
	}
	.product-detail .detail-top {
		width: 100%
	}
	.product-detail .left-col {
		float: none;
		position: relative;
		width: 100%
	}
	.product-detail .left-col .thumbs {
		bottom: -30px;
		float: none;
		left: 0;
		position: absolute;
		text-align: center;
		width: 100%;
		z-index: 100
	}
	.product-detail .left-col .thumbs a {
		border: 2px solid #e2e2e3;
		display: inline-block;
		height: 43px;
		margin: 0 8px 8px 0;
		width: 38px
	}
	.product-detail .left-col .thumbs a span {
		background-color: #fff;
		border: 2px solid #fff;
		display: block;
		height: 39px;
		overflow: hidden;
		width: 34px
	}
	.product-detail .left-col .big {
		float: none;
		width: 100%
	}
	.product-detail .left-col .big #big-image {
		display: none
	}
	.product-detail .left-col .big #banner-gallery {
		display: block;
		position: relative;
		max-width: 1024px;
		margin: 0 auto;
		border-top: 1px solid #c6c6c6;
		border-bottom: 1px solid #c6c6c6;
		overflow: hidden
	}
	.product-detail .left-col .big #banner-gallery .swipe {
		overflow: hidden;
		visibility: hidden;
		position: relative
	}
	.product-detail .left-col .big #banner-gallery .swipe-wrap {
		overflow: hidden;
		position: relative
	}
	.product-detail .left-col .big #banner-gallery .swipe-wrap>div {
		background: transparent no-repeat center center;
		-moz-background-size: cover;
		-o-background-size: cover;
		-webkit-background-size: cover;
		background-size: cover;
		float: left;
		padding-bottom: 33%;
		width: 100%;
		position: relative
	}
	.product-detail .left-col .big .navigation-module {
		width: 100%;
		padding: 12px 0;
		text-align: center
	}
	.product-detail .left-col .big .navigation-module .navigation-module__item
		{
		width: 12px;
		height: 12px;
		display: inline-block;
		vertical-align: middle;
		margin: 0 6px;
		background-color: #cacaca;
		border: 1px solid transparent;
		-moz-border-radius: 50%;
		-webkit-border-radius: 50%;
		border-radius: 50%;
		text-indent: -999px;
		overflow: hidden
	}
	.product-detail .left-col .big .navigation-module .navigation-module__item.is-active
		{
		background-color: #b25c62
	}
	.product-detail .right-col {
		float: none;
		margin: 0 auto;
		width: 90%
	}
	.product-detail .cols {
		padding: 0 0 20px
	}
	.product-detail h1 {
		font-size: 107.69231%;
		line-height: 171.42857%;
		margin: 25px 0 2px;
		text-align: center
	}
	.product-detail .price-shipping {
		padding-bottom: 10px;
		text-align: center
	}
	.product-detail .price-shipping a {
		display: inline;
		float: none;
		margin: 0
	}
	.product-detail .price {
		font-size: 276.92308%;
		line-height: 111.11111%;
		display: block;
		float: none;
		text-align: center
	}
	.product-detail .swatches {
		margin: 10px 0 30px
	}
	.product-detail .swatches .guide {
		float: none;
		margin: -25px 0 0;
		text-align: center
	}
	.product-detail .swatch {
		float: none;
		margin-right: 0;
		text-align: center
	}
	.product-detail .swatch .swatch-element {
		display: inline-block;
		float: none;
		margin: 7px 8px 25px 0
	}
	.product-detail .btn-and-quantity {
		float: none;
		text-align: center
	}
	.product-detail .spinner {
		float: none;
		margin: 0 auto 10px;
		width: 200px
	}
	.product-detail .spinner input {
		width: 60px
	}
	.product-detail .spinner .q {
		margin-right: 20px;
		width: 61px
	}
	.product-detail .spinner:before {
		background: transparent
			url('data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAMwAAAAKCAIAAAB38SYMAAAAAXNSR0IArs4c6QAAAARnQU1BAACxjwv8YQUAAAAJcEhZcwAADsMAAA7DAcdvqGQAAADhSURBVFhH7ZVtC4MgFEb3///r1puZadkOU2QEKw32xe5BBC/hDZ+DPrZDrFuaTo3aeO9jSRA+oARioId1LpZ+cCIZIJee5qYbmGNJuD1JiZy751yyANoqPbEvs7Un5gq1QvRJg/zHLVeyAPua2fZKv9qBPsbQdFlXeUvrhFgJl4gJmrgJnegRoDTvMskSNJmt40mma9sr1OYPnk1f6+iGcXeuLCnuPqtpECixEi4REzRxX75JLkp2Nzjlb8+CYRTjWjhEJMsleSaGlSKSFRA8E8NKEcnKQC8xrBSRTPgz2/YGSZmvkaSZcu8AAAAASUVORK5CYII=')
			no-repeat center top;
		bottom: -5px;
		height: 10px;
		left: 0;
		top: auto;
		width: 100%
	}
	.product-detail #AddToCart {
		background-position: 47px center;
		float: none;
		padding: 14px 26px 14px 53px;
		width: 200px
	}
	.related {
		padding: 28px 0 58px
	}
	.related h2 {
		font-size: 107.69231%;
		line-height: 171.42857%
	}
	.detail-socials .social-sharing {
		-moz-transition: all 0.3s ease-in-out;
		-o-transition: all 0.3s ease-in-out;
		-webkit-transition: all 0.3s ease-in-out;
		transition: all 0.3s ease-in-out;
		-moz-box-shadow: rgba(17, 17, 18, 0.08) 0 -2px 10px;
		-webkit-box-shadow: rgba(17, 17, 18, 0.08) 0 -2px 10px;
		box-shadow: rgba(17, 17, 18, 0.08) 0 -2px 10px;
		background-color: #fff;
		bottom: -60px;
		float: none;
		height: 50px;
		left: 0;
		margin: 0;
		padding: 12px 5% 0;
		position: fixed;
		top: auto !important;
		width: 100%;
		z-index: 1000
	}
	.detail-socials .social-sharing a {
		margin-right: 20px
	}
	.detail-socials.open .social-sharing {
		bottom: 0
	}
	.social-sharing-btn-wrapper {
		font-family: "montserratregular", sans-serif;
		font-size: 92.30769%;
		line-height: 133.33333%;
		display: block
	}
	.social-sharing-btn-wrapper span {
		background: transparent
			url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjE1cHgiIGhlaWdodD0iMTdweCIgdmlld0JveD0iMCAwIDE1IDE3IiB2ZXJzaW9uPSIxLjEiIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgeG1sbnM6eGxpbms9Imh0dHA6Ly93d3cudzMub3JnLzE5OTkveGxpbmsiIHhtbG5zOnNrZXRjaD0iaHR0cDovL3d3dy5ib2hlbWlhbmNvZGluZy5jb20vc2tldGNoL25zIj4KICAgIDxnIHN0cm9rZT0ibm9uZSIgc3Ryb2tlLXdpZHRoPSIxIiBmaWxsPSJub25lIiBmaWxsLXJ1bGU9ImV2ZW5vZGQiPgogICAgICAgIDxnIHRyYW5zZm9ybT0idHJhbnNsYXRlKC0yMC4wMDAwMDAsIC0xMjI5LjAwMDAwMCkiIGZpbGw9IiMwODZGQ0YiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgyMC4wMDAwMDAsIDEyMjkuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMTMuMjgxMjQ0NywxNyBMMS4wNjI0Nzg3NSwxNyBDMC40NzY1MjU5MzcsMTcgMCwxNi41MjM0Njg4IDAsMTUuOTM3NSBMMCw2LjM3NSBDMCw1Ljc4OTU2MjUgMC40NzY1MjU5MzcsNS4zMTI1IDEuMDYyNDc4NzUsNS4zMTI1IEwzLjk4NDM2OTY5LDUuMzEyNSBDNC40MjQ1NjM0NCw1LjMxMjUgNC43ODEyNDQ2OSw1LjY2OTUgNC43ODEyNDQ2OSw2LjEwOTM3NSBDNC43ODEyNDQ2OSw2LjU0OTI1IDQuNDI0NTYzNDQsNi45MDYyNSAzLjk4NDM2OTY5LDYuOTA2MjUgTDEuNTkzNzUsNi45MDYyNSBMMS41OTM3NSwxNS40MDYyNSBMMTIuNzQ5OTk0NywxNS40MDYyNSBMMTIuNzQ5OTk0Nyw2LjkwNjI1IEwxMC4zNTkzNjk3LDYuOTA2MjUgQzkuOTE5MTc1OTQsNi45MDYyNSA5LjU2MjQ5NDY5LDYuNTQ5MjUgOS41NjI0OTQ2OSw2LjEwOTM3NSBDOS41NjI0OTQ2OSw1LjY2OTUgOS45MTkxNzU5NCw1LjMxMjUgMTAuMzU5MzY5Nyw1LjMxMjUgTDEzLjI4MTI0NDcsNS4zMTI1IEMxMy44NjcyMTM0LDUuMzEyNSAxNC4zNDM3NDQ3LDUuNzg5NTYyNSAxNC4zNDM3NDQ3LDYuMzc1IEwxNC4zNDM3NDQ3LDE1LjkzNzUgQzE0LjM0Mzc0NDcsMTYuNTIzNDY4OCAxMy44NjcyMTM0LDE3IDEzLjI4MTI0NDcsMTcgTDEzLjI4MTI0NDcsMTcgWiBNOS44MjgxMTk2OSw0LjI1IEM5LjYwODEyOTA2LDQuMjUgOS40MDg5MTAzMSw0LjE2MDc1IDkuMjY0NzI5MDYsNC4wMTY3ODEyNSBMNy45Njg3NDQ2OSwyLjcyMDUzMTI1IEw3Ljk2ODc0NDY5LDExLjQyMTg3NSBDNy45Njg3NDQ2OSwxMS44NjE3NSA3LjYxMjA2MzQ0LDEyLjIxODc1IDcuMTcxODY5NjksMTIuMjE4NzUgQzYuNzMxNjc1OTQsMTIuMjE4NzUgNi4zNzQ5OTQ2OSwxMS44NjE3NSA2LjM3NDk5NDY5LDExLjQyMTg3NSBMNi4zNzQ5OTQ2OSwyLjcyMDUzMTI1IEw1LjA3OTAxMDMxLDQuMDE2NzgxMjUgQzQuOTM0ODI5MDYsNC4xNjA3NSA0LjczNTYxMDMxLDQuMjUgNC41MTU2MTk2OSw0LjI1IEM0LjA3NTQyNTk0LDQuMjUgMy43MTg3NDQ2OSwzLjg5MyAzLjcxODc0NDY5LDMuNDUzMTI1IEMzLjcxODc0NDY5LDMuMjMzMTg3NSAzLjgwNzk5NDY5LDMuMDMzOTY4NzUgMy45NTIyMjkwNiwyLjg5IEw2LjYwODQ3OTA2LDAuMjMzNzUgQzYuNzUyNjYwMzEsMC4wODkyNSA2Ljk1MTg3OTA2LDAgNy4xNzE4Njk2OSwwIEM3LjM5MTg2MDMxLDAgNy41OTEwNzkwNiwwLjA4OTI1IDcuNzM1MjYwMzEsMC4yMzM3NSBMMTAuMzkxNTEwMywyLjg5IEMxMC41MzU3NDQ3LDMuMDMzOTY4NzUgMTAuNjI0OTk0NywzLjIzMzE4NzUgMTAuNjI0OTk0NywzLjQ1MzEyNSBDMTAuNjI0OTk0NywzLjg5MyAxMC4yNjgzMTM0LDQuMjUgOS44MjgxMTk2OSw0LjI1IEw5LjgyODExOTY5LDQuMjUgWiI+PC9wYXRoPgogICAgICAgICAgICA8L2c+CiAgICAgICAgPC9nPgogICAgPC9nPgo8L3N2Zz4=')
			no-repeat left top;
		color: #020E20;
		cursor: pointer;
		display: inline-block;
		padding: 3px 0 0 21px
	}
	.social-sharing-btn-wrapper span:hover {
		color: #0084ff
	}
	#quick-cart .quick-cart-product {
		display: none
	}
	#quick-cart #quick-cart-pay #quick-cart-pay-total-count {
		-moz-border-radius: 50%;
		-webkit-border-radius: 50%;
		border-radius: 50%;
		font-family: "robotobold", sans-serif;
		font-size: 76.92308%;
		line-height: 110.0%;
		background-color: #16161a;
		color: #fff;
		display: block;
		height: 20px;
		overflow: hidden;
		padding-top: 4px;
		position: absolute;
		right: -4px;
		top: -4px;
		text-align: center;
		width: 20px;
		z-index: 100
	}
	.cart {
		padding-top: 30px
	}
	.cart .inputs {
		text-align: center
	}
	.cart .inputs input {
		float: none;
		margin-bottom: 15px
	}
	.cart .inputs input.update-cart {
		float: none;
		margin-bottom: 0
	}
	#sign-in-popup .box {
		margin-top: 0
	}
	.homepage .collection-list.featured {
		padding: 120px 0 0 0
	}
	.homepage .collection-list.featured a:nth-child(3) {
		display: none
	}
}

@media only screen and (max-width: 450px) {
	div.grid_info:after {
		content: "< 450px"
	}
	.collection-list.cols-4 a, .collection-list.cols-3 a {
		margin-bottom: 7.14286%
	}
	#sign-in-popup form .btn {
		font-size: 100%;
		line-height: 138.46154%
	}
	.homepage .collection-list.featured {
		padding-top: 80px
	}
	footer .top form input {
		width: 218px
	}
}

@media only screen and (max-width: 320px) {
	div.grid_info:after {
		content: "< 320px"
	}
}

.homepage .bg {
	-moz-background-size: 1920px auto;
	-o-background-size: 1920px auto;
	-webkit-background-size: 1920px auto;
	background-size: 1920px auto
}

@media only screen and (max-width: 1600px) {
	.homepage .bg {
		-moz-background-size: 100% auto;
		-o-background-size: 100% auto;
		-webkit-background-size: 100% auto;
		background-size: 100% auto
	}
}

@media only screen and (max-width: 1200px) {
	.homepage .bg {
		background-position: center -50px
	}
}

@media only screen and (max-width: 850px) {
	.homepage .bg {
		background-position: center -50px
	}
}

@media only screen and (max-width: 600px) {
	.homepage .bg {
		background-position: center -80px
	}
}

@media only screen and (max-width: 320px) {
	.homepage .bg {
		background-position: center -70px
	}
}

.swatches {
	margin: 17px 0 80px
}

.selector-wrapper, #productSelect {
	display: none
}

.swatch {
	float: left;
	margin-right: 40px
}

.swatch:nth-last-child(2) {
	margin-right: 0
}

.swatch .header {
	font-family: "montserratbold", sans-serif;
	text-transform: uppercase
}

.swatch input {
	display: none
}

.swatch .swatch-element {
	float: left;
	margin: 5px 8px 0 0;
	position: relative
}

.swatch .color label {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	border-radius: 50%;
	border: 1px solid;
	cursor: pointer;
	display: block;
	height: 42px;
	padding: 7px 0 0 7px;
	width: 42px
}

.swatch .color label span {
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	border-radius: 50%;
	display: block;
	height: 26px;
	position: relative;
	width: 26px
}

.swatch .color label span:after {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	background: transparent
		url('data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiBlbmNvZGluZz0iVVRGLTgiIHN0YW5kYWxvbmU9Im5vIj8+Cjxzdmcgd2lkdGg9IjEycHgiIGhlaWdodD0iOXB4IiB2aWV3Qm94PSIwIDAgMTIgOSIgdmVyc2lvbj0iMS4xIiB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHhtbG5zOnhsaW5rPSJodHRwOi8vd3d3LnczLm9yZy8xOTk5L3hsaW5rIiB4bWxuczpza2V0Y2g9Imh0dHA6Ly93d3cuYm9oZW1pYW5jb2RpbmcuY29tL3NrZXRjaC9ucyI+CiAgICA8ZyBzdHJva2U9Im5vbmUiIHN0cm9rZS13aWR0aD0iMSIgZmlsbD0ibm9uZSIgZmlsbC1ydWxlPSJldmVub2RkIj4KICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMTIzMS4wMDAwMDAsIC0xMzAyLjAwMDAwMCkiIGZpbGw9IiNGRkZGRkYiPgogICAgICAgICAgICA8ZyB0cmFuc2Zvcm09InRyYW5zbGF0ZSgtMy4wMDAwMDAsIDEyNDYuMDAwMDAwKSI+CiAgICAgICAgICAgICAgICA8cGF0aCBkPSJNMTIzNS45MzgzNyw1OC40NTA1ODYxIEwxMjM0LjUyMTE2LDU5LjM5NTUzMDcgTDEyMzcuNTQ4NDgsNjMuOTM2NzE1OCBMMTI0NS45MjIyNSw1OC4zNTM5MTk4IEwxMjQ0Ljk3NzczLDU2LjkzNjcxNTggTDEyMzguMDIxMTYsNjEuNTc0NTY3MSBMMTIzNS45MzgzNyw1OC40NTA1ODYxIEwxMjM1LjkzODM3LDU4LjQ1MDU4NjEgWiIgaWQ9ImZhamZrYSIgc2tldGNoOnR5cGU9Ik1TU2hhcGVHcm91cCIgdHJhbnNmb3JtPSJ0cmFuc2xhdGUoMTI0MC4yMjE3MDYsIDYwLjQzNjcxNikgcm90YXRlKC0xMC4wMDAwMDApIHRyYW5zbGF0ZSgtMTI0MC4yMjE3MDYsIC02MC40MzY3MTYpIj48L3BhdGg+CiAgICAgICAgICAgIDwvZz4KICAgICAgICA8L2c+CiAgICA8L2c+Cjwvc3ZnPg==')
		no-repeat center center;
	bottom: 0;
	content: "";
	display: block;
	height: 100%;
	left: 0;
	opacity: 0;
	position: absolute;
	top: 0;
	width: 100%
}

.swatch .plain label {
	-moz-transition: all 0.3s ease-in-out;
	-o-transition: all 0.3s ease-in-out;
	-webkit-transition: all 0.3s ease-in-out;
	transition: all 0.3s ease-in-out;
	-moz-border-radius: 50%;
	-webkit-border-radius: 50%;
	border-radius: 50%;
	font-family: "montserratbold", sans-serif;
	border: 1px solid #020E20;
	color: #020E20;
	cursor: pointer;
	display: block;
	height: 42px;
	padding-top: 8px;
	text-align: center;
	width: 42px
}

.swatch .color input:checked+label span:after {
	opacity: 1
}

.swatch input:not(:checked)+label {
	border-color: #edeff2 !important
}

.swatch input:not(:checked)+label:hover {
	border-color: #b5b6bd !important
}

.swatch .plain input:not(:checked)+label {
	color: #16161a !important
}

.swatch .blue input:checked+label {
	border-color: #020E20 !important
}

.swatch .yellow input:checked+label {
	border-color: #f5c81f !important
}

.swatch .red input:checked+label {
	border-color: #d9332e !important
}

.swatch .blue label span {
	background-color: #020E20 !important
}

.swatch .yellow label span {
	background-color: #f5c81f !important
}

.swatch .red label span {
	background-color: #d9332e !important
}

.crossed-out {
	position: absolute;
	width: 100%;
	height: 100%;
	left: 0;
	top: 0
}

.swatch .swatch-element .crossed-out {
	display: none
}

.swatch .swatch-element.soldout .crossed-out {
	display: block
}

.swatch .swatch-element.soldout label {
	filter: alpha(opacity = 60);
	-khtml-opacity: 0.6;
	-moz-opacity: 0.6;
	opacity: 0.6
}

.swatch .tooltip {
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	text-align: center;
	background-color: rgba(22, 22, 26, 0.93);
	color: #fff;
	bottom: 100%;
	padding: 10px;
	display: block;
	position: absolute;
	width: 100px;
	left: -23px;
	margin-bottom: 15px;
	filter: alpha(opacity = 0);
	-khtml-opacity: 0;
	-moz-opacity: 0;
	opacity: 0;
	visibility: hidden;
	-webkit-transform: translateY(10px);
	-moz-transform: translateY(10px);
	-ms-transform: translateY(10px);
	-o-transform: translateY(10px);
	transform: translateY(10px);
	-webkit-transition: all .25s ease-out;
	-moz-transition: all .25s ease-out;
	-ms-transition: all .25s ease-out;
	-o-transition: all .25s ease-out;
	transition: all .25s ease-out;
	-webkit-box-shadow: 2px 2px 6px rgba(0, 0, 0, 0.28);
	-moz-box-shadow: 2px 2px 6px rgba(0, 0, 0, 0.28);
	-ms-box-shadow: 2px 2px 6px rgba(0, 0, 0, 0.28);
	-o-box-shadow: 2px 2px 6px rgba(0, 0, 0, 0.28);
	box-shadow: 2px 2px 6px rgba(0, 0, 0, 0.28);
	z-index: 10000;
	-moz-box-sizing: border-box;
	-webkit-box-sizing: border-box;
	box-sizing: border-box
}

.swatch .tooltip:before {
	bottom: -20px;
	content: " ";
	display: block;
	height: 20px;
	left: 0;
	position: absolute;
	width: 100%
}

.swatch .tooltip:after {
	border-left: solid transparent 10px;
	border-right: solid transparent 10px;
	border-top: solid rgba(22, 22, 26, 0.93) 10px;
	bottom: -10px;
	content: " ";
	height: 0;
	left: 50%;
	margin-left: -13px;
	position: absolute;
	width: 0
}

.swatch .swatch-element:hover .tooltip {
	filter: alpha(opacity = 100);
	-khtml-opacity: 1;
	-moz-opacity: 1;
	opacity: 1;
	visibility: visible;
	-webkit-transform: translateY(0px);
	-moz-transform: translateY(0px);
	-ms-transform: translateY(0px);
	-o-transform: translateY(0px);
	transform: translateY(0px)
}

.swatch.error {
	background-color: #E8D2D2 !important;
	color: #333 !important;
	padding: 1em;
	border-radius: 5px
}

.swatch.error p {
	margin: 0.7em 0
}

.swatch.error p:first-child {
	margin-top: 0
}

.swatch.error p:last-child {
	margin-bottom: 0
}

.swatch.error code {
	font-family: monospace
}
</style>
<style type="text/css">
/**
 * Oscuro: #283035
 * Azul: #03658c
 * Detalle: #c7cacb
 * Fondo: #dee1e3
 ----------------------------------*/
* {
	margin: 0;
	padding: 0;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	box-sizing: border-box;
}

a {
	color: #03658c;
	text-decoration: none;
}

ul {
	list-style-type: none;
}

body {
	font-family: 'Roboto', Arial, Helvetica, Sans-serif, Verdana;
	/* background: #dee1e3; */
}

/** ====================
 * Lista de Comentarios
 =======================*/
.comments-container {
	margin: 60px auto 15px;
	width: 768px;
}

.comments-container h1 {
	font-size: 36px;
	color: #283035;
	font-weight: 400;
}

.comments-container h1 a {
	font-size: 18px;
	font-weight: 700;
}

.comments-list {
	margin-top: 30px;
	position: relative;
}

/**
 * Lineas / Detalles
 -----------------------*/
.comments-list:before {
	content: '';
	width: 2px;
	height: 100%;
	background: #c7cacb;
	position: absolute;
	left: 32px;
	top: 0;
}

.comments-list:after {
	content: '';
	position: absolute;
	background: #c7cacb;
	bottom: 0;
	left: 27px;
	width: 7px;
	height: 7px;
	border: 3px solid #dee1e3;
	-webkit-border-radius: 50%;
	-moz-border-radius: 50%;
	border-radius: 50%;
}

.reply-list:before, .reply-list:after {
	display: none;
}

.reply-list li:before {
	content: '';
	width: 60px;
	height: 2px;
	background: #c7cacb;
	position: absolute;
	top: 25px;
	left: -55px;
}

.comments-list li {
	margin-bottom: 15px;
	display: block;
	position: relative;
}

.comments-list li:after {
	content: '';
	display: block;
	clear: both;
	height: 0;
	width: 0;
}

.reply-list {
	padding-left: 88px;
	clear: both;
	margin-top: 15px;
}
/**
 * Avatar
 ---------------------------*/
.comments-list .comment-avatar {
	width: 65px;
	height: 65px;
	position: relative;
	z-index: 99;
	float: left;
	border: 3px solid #FFF;
	-webkit-border-radius: 4px;
	-moz-border-radius: 4px;
	border-radius: 4px;
	-webkit-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
	-moz-box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
	box-shadow: 0 1px 2px rgba(0, 0, 0, 0.2);
	overflow: hidden;
}

.comments-list .comment-avatar img {
	width: 100%;
	height: 100%;
}

.reply-list .comment-avatar {
	width: 50px;
	height: 50px;
}

.comment-main-level:after {
	content: '';
	width: 0;
	height: 0;
	display: block;
	clear: both;
}
/**
 * Caja del Comentario
 ---------------------------*/
.comments-list .comment-box {
	width: 680px;
	float: right;
	position: relative;
	-webkit-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.15);
	-moz-box-shadow: 0 1px 1px rgba(0, 0, 0, 0.15);
	box-shadow: 0 1px 1px rgba(0, 0, 0, 0.15);
}

.comments-list .comment-box:before, .comments-list .comment-box:after {
	content: '';
	height: 0;
	width: 0;
	position: absolute;
	display: block;
	border-width: 10px 12px 10px 0;
	border-style: solid;
	border-color: transparent #FCFCFC;
	top: 8px;
	left: -11px;
}

.comments-list .comment-box:before {
	border-width: 11px 13px 11px 0;
	border-color: transparent rgba(0, 0, 0, 0.05);
	left: -12px;
}

.reply-list .comment-box {
	width: 610px;
}

.comment-box .comment-head {
	background: #FCFCFC;
	padding: 10px 20px;
	border-bottom: 1px solid #E5E5E5;
	overflow: hidden;
	-webkit-border-radius: 4px 4px 0 0;
	-moz-border-radius: 4px 4px 0 0;
	border-radius: 4px 4px 0 0;
}

.comment-box .comment-head i {
	float: right;
	margin-left: 14px;
	position: relative;
	top: 2px;
	color: #A6A6A6;
	cursor: pointer;
	-webkit-transition: color 0.3s ease;
	-o-transition: color 0.3s ease;
	transition: color 0.3s ease;
}

.comment-box .comment-head i:hover {
	color: #03658c;
}

.comment-box .comment-name {
	color: #283035;
	font-size: 14px;
	font-weight: 700;
	float: left;
	margin-right: 10px;
}

.comment-box .comment-name a {
	color: #283035;
}

.comment-box .comment-head span {
	float: left;
	color: #999;
	font-size: 13px;
	position: relative;
	top: 1px;
}

.comment-box .comment-content {
	background: #FFF;
	padding: 12px;
	font-size: 15px;
	-webkit-border-radius: 0 0 4px 4px;
	-moz-border-radius: 0 0 4px 4px;
	border-radius: 0 0 4px 4px;
}

.comment-box .comment-name.by-author, .comment-box .comment-name.by-authore,
	.comment-box .comment-name.by-author a, comment-box .comment-name.by-authore a
	{
	color: #03658c;
}

.comment-box .comment-name.by-author:before {
	content: '질문';
	background: #03658c;
	color: #FFF;
	font-size: 12px;
	padding: 3px 5px;
	font-weight: 700;
	margin-left: 10px;
	margin-right: 10px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
}

.comment-box .comment-name.by-authore:before {
	content: '의견';
	background: #020e20;
	color: #FFF;
	font-size: 12px;
	padding: 3px 5px;
	font-weight: 700;
	margin-left: 10px;
	-webkit-border-radius: 3px;
	-moz-border-radius: 3px;
	border-radius: 3px;
}

/** =====================
 * Responsive
 ========================*/
@media only screen and (max-width: 766px) {
	.comments-container {
		width: 480px;
	}
	.comments-list .comment-box {
		width: 390px;
	}
	.reply-list .comment-box {
		width: 320px;
	}
}
</style>
<script type="text/javascript">
//Hey you! Thanks for checking this pen. :) I open source it as library. https://github.com/greenwoodents/quickbeam.js

var Quickbeam = (function () {
  // Instance stores a reference to the Singleton
  var instance;

  function init(att) {
    // Singleton
    var els = {};
    var self = {};

    //Select attributes
    var cart = document.querySelector('#quick-cart');
    var cartPay = document.querySelector('#quick-cart-pay');
    var cartPrice = document.querySelector('#quick-cart-price');

    var addToCart = document.querySelector('[quickbeam="add-to-cart"]');
    var ProductImage = document.querySelector('[quickbeam="image"]');
    var price = document.querySelector('[quickbeam="price"]');

    var variantId;
    var imageUrl;
    var count;
    var color = '#000';

    var last_removed_variant;
    var last_removed_variant_count;


    (function main() {

      window.onresize = function(event) {
        setPayButtonAction();
      };

      setPayButtonAction();

      if (cartPay.length > 0) {return false;}

      if (att.animationLib === 'gsap') {
        if (typeof TweenMax !== 'function') {throw "GSAP is not loaded."}
      }

      if (price) {
        price = price.innerHTML;
      }

      if (ProductImage) {
        imageUrl = ProductImage.getAttribute('src');

        if (!imageUrl) {
          var patt = /url\(\s*(['"]?)(.*?)\1\s*\)/i
          imageUrl = ProductImage.getAttribute('style').match(patt)[2];
        }
      }

      [].forEach.call(document.querySelectorAll('.quickbeam-variant'), function(el){
        if (el.checked) {
          variantId = parseInt(el.getAttribute('quickbeam-value'));
        }
      });


      //Add event listeners
      var listeners = {
        '.quick-cart-product-remove': function(el){
            var id = el.getAttribute("data-id");
            var product = el.parentNode;
            var productCount = product.querySelector('.count');
            var count = parseInt(productCount.innerText);
            var imgWrap = product.querySelector('div');

            if (!(product && cart)) {return false}

            count--;

            if (count <= 0) {
              //Animation
              product.classList.add("remove-product");
              window.setTimeout(function() {
                product.classList.remove("remove-product");
                removeProduct(product);
              }, 1000);
            } else {
              productCount.innerText = count;

              var clone = imgWrap.cloneNode(true);
              clone.classList.add('animateOut')
              imgWrap.parentNode.appendChild(clone);

              window.setTimeout(function() {
                clone.parentNode.removeChild(clone);
              }, 1000);


              if (count <= 1) {
                productCount.classList.add("hide");
              }
            }

            if (last_removed_variant == id) {
              last_removed_variant_count++;
            } else {
              last_removed_variant = id;
              last_removed_variant_count = 1;
            }

            if (3 == last_removed_variant_count && count > 1) {
              product.classList.add("show-remove-all");
            }


            ajaxRemoveProduct({quantity: count, id: id});
          },

          '.quick-cart-product-removeall': function(el) {
              var id = el.getAttribute("data-id");
              var product = el.parentNode;

              if (!(product && cart)) {return false}

              product.classList.add("remove-product");
              window.setTimeout(function() {
                removeProduct(product_box);
              }, 200);

              ajaxRemoveProduct({quantity: 0, id: id});
          }
      }

      //Event delegation for cart
      cart.addEventListener("click",function(e) {
        //calling callback if item of object have a match.
        for (var key in listeners) {
          if (listeners.hasOwnProperty(key) && e.target && e.target.matches(key)) {
            listeners[key].apply(null, [e.target]);
          }
        }
      });

      if (addToCart) {
        //Buy button listener.
        addToCart.addEventListener('click', start, false);
      }

      function start(e){
        e.preventDefault();
        this.blur();

        // display pay button if is not
        if (!(cartPay.classList.contains('open'))) {
          cartPay.classList.add("open");
        }

        count = parseInt(document.querySelector('.quantity-selector').value);

        addProduct();

        animateProduct();

        if (ProductImage) {
          ProductImage.classList.add("animate");
          window.setTimeout(function(){
            ProductImage.classList.remove("animate");
          }, 400);
        }
      }

      return false;
    })();

    //Procedure for creating product in cart and displaying after animation.
    function addProduct() {
      var variant;

      //Calling select variant from attributes or falling back to default select variant.
      if (typeof att.variantSelector === 'function') {
        variant = att.variantSelector.call();
        if (typeof variant !== string) {
          console.error("variantSelector not returning a string.");
          variant = '';
        }
      } else {
        [].forEach.call(document.querySelectorAll('.quickbeam-variant'), function(el){
          if (el.checked) {
            variantId = parseInt(el.getAttribute('quickbeam-value'));
            variant = el.getAttribute('value');
          }
        });
      }

      if (typeof variant === 'undefined') {
        console.error("Not able to select variant");
        variant = '';
      }

      var cart_product = document.querySelector("#quick-cart-product-" + variantId) || false;

      if (cart && ProductImage && cart_product == false ) {
        //Create product box
        var element = createProductBox({
          id: variantId,
          price: price,
          image: imageUrl,
          size: variant,
          color: color
        });
        //Append element to cart
        cart.insertBefore(element, cart.firstChild);
        //Display created element
        displayProductBox(element, 1000);
      }
    }

    // Function for creating DOM element from pre-set template.
    // Private function
    // Arguments: variantId, price, swatchesContent
    // Returning created DOM element.
    function createProductBox(data) {
      var template = '<div class="quick-cart-product-wrap">'+
                        '<img src="' + data.image + '">'+
                        '<span class=" s1" style="background-color: '+data.color+'; opacity: .5">'+ data.price.trim() +'</span>'+
                        '<span class=" s2">'+ data.size.trim() +'</span>'+
                      '</div>'+
                      '<span class="count hide fadeUp" id="quick-cart-product-count-'+ data.id +'">0</span>'+
                      '<span class="quick-cart-product-remove remove" data-id="'+ data.id +'"></span>'+
                      '<span class="quick-cart-product-removeall removeall" data-id="'+ data.id +'"></span>';

      var div = document.createElement("div");
      div.classList.add("quick-cart-product");
      div.classList.add("quick-cart-product-static");
      div.setAttribute("id", "quick-cart-product-" + data.id);
      div.style.opacity = 0;
      div.innerHTML = template;

      return div;
    }

    // Function for displaying product box.
    // private function
    // Arguments: createde element, delay of display.
    function displayProductBox(el, delay) {
      //Defaults
      delay = typeof delay !== 'undefined' ? delay : 0;

      window.setTimeout(function(){
        el.style.opacity = 1;
      }, delay);
    }

    //requst animation frame animation function
    function animate(item) {
      var duration = item.time,
      end = +new Date() + duration;

      var step = function() {

        var current = +new Date(),
            remaining = end - current;

        if(remaining < 60) {
          item.run(1);  //1 = progress is at 100%
          return;

        } else {
          var rate = 1 - remaining/duration;
          item.run(rate);
        }

        requestAnimationFrame(step);
      }
      step();
    }

    //Procedure for animating process of adding product box to cart using bezire curve.
    //Private
    function animateProduct() {
      // create and append copy of large image.
      var element = createAnimatedObject();
      var c = getAnimationCoordinations(element);

      if (att.animationLib === 'gsap') {
        gsapAnimation(element, c);
      } else {
        fallbackAnimation(element, c);
      }
    }

    function gsapAnimation(element, c) {
      element.style.position = 'absolute';
      element.classList.add("run");

      var countBox = document.getElementById("quick-cart-product-count-" + variantId);
      if (countBox) {
        countBox.classList.remove('fadeUp')
        countBox.classList.add('fadeDown')
      }

      TweenMax.to(element, 1, {bezier:{type:"soft", values:c.through}, ease:Power1.easeInOut});

      setTimeout(function(){
        element.style.opacity = 0;
        document.body.removeChild(element);

        setTimeout(function(){
          ajaxAddProductToCart();
        },100)
      }, 1000);
    }

    //Vanilla JS Animation
    function fallbackAnimation(element, c) {
      var cordeIndex = 0;
      var coord = function (x,y) {
        if(!x) var x=0; if(!y) var y=0;
        return {x: x, y: y};
      };

      var bezier = function(t, p0, p1, p2, p3){
        var cX = 3 * (p1.x - p0.x),
            bX = 3 * (p2.x - p1.x) - cX,
            aX = p3.x - p0.x - cX - bX;

        var cY = 3 * (p1.y - p0.y),
            bY = 3 * (p2.y - p1.y) - cY,
            aY = p3.y - p0.y - cY - bY;

        var x = (aX * Math.pow(t, 3)) + (bX * Math.pow(t, 2)) + (cX * t) + p0.x;
        var y = (aY * Math.pow(t, 3)) + (bY * Math.pow(t, 2)) + (cY * t) + p0.y;

        return {x: x, y: y};
      };
      //Coordinations
      //Start
      var P1 = coord(c.start.x,c.start.y);
      //HELPERS
      var P2 = coord(c.start.x-300,c.final.y);
      var P3 = coord(c.start.x+500,c.start.y+500);
      //final destination
      var P4 = coord(c.final.x,c.final.y);

      //Actaully animate.
      var stage = 0;
      element.style.position = 'absolute';
      element.classList.add("run");
      animate({
        time: 1000,

        run: function(t) {
          if(t == 1) {
            setTimeout(function(){
              element.style.opacity = 0;
              document.body.removeChild(element);

              setTimeout(function(){
                ajaxAddProductToCart();
              },1000)
            }, 500);

          }
          //find position on bezier curve
          var curpos = bezier(t,P1,P2,P3,P4)

          var trans = "translate("+Math.round(curpos.x)+"px,"+Math.round(curpos.y)+"px)";

          element.style.webkitTransform = trans;
          element.style.transform = trans;
        }
      });
    }

    // Function for creating DOM element from pre-set template.
    // Private function
    // Arguments: none
    // Returning created DOM element.
    function createAnimatedObject(data) {
      var width = ProductImage.offsetWidth - 2;
      var height = Math.round(parseInt(ProductImage.offsetWidth - 2) * 1.33);
      var offset = ProductImage.getBoundingClientRect();

      var template =  '<div style="width:'+ width +'px; height:'+ height +'px;">'+
                      '<img src="'+ imageUrl +'">'+
                      '<span class="s1" style="background-color: '+color+'; opacity: .5; transition: 1000ms"></span>'+
                      '<span class="s2"></span>'+
                      '</div>';

      // Animace pridani produktu k produktovemu boxu
      var div = document.createElement("div");
      div.classList.add("quick-cart-product");
      div.classList.add("quick-cart-product");
      div.classList.add("animated");
      div.setAttribute("id", "quick-cart-product-animated");

      if (att.animationLib === 'gsap') {
        var trans = "translate("+ offset.left +"px,"+ offset.top +"px)";
        div.style.webkitTransform = trans;
        div.style.transform = trans;
      }

      //Apend template
      div.innerHTML = template;
      //Append child to body
      document.body.appendChild(div);
      //return
      return div;
    }

    // Function for calculating animation coordinations
    // Private function
    // Arguments: element from DOM.
    // Returning object { start:{x,y}, finish: {x,y} }.
    function getAnimationCoordinations(element) {
      var child = element.querySelector('div');
      // Calc of start and finish positions of animation.
      var start = ProductImage.getBoundingClientRect();
      var final = document.querySelector("#quick-cart-product-" + variantId).getBoundingClientRect();
      var fTop = final.top;
      // adding scroll heihft to Y
      var doc = document.documentElement;
      var left = (window.pageXOffset || doc.scrollLeft) - (doc.clientLeft || 0);
      var top = (window.pageYOffset || doc.scrollTop)  - (doc.clientTop || 0);

      var throughX = parseInt(start.left) - parseInt(child.style.width) * 1.4;
      var throughY = (fTop + top) - parseInt(child.style.height) / 3;

      return {
        start: {
          x: start.left,
          y: start.top
        },
        through: [
          {x:throughX, y:throughY},
          {x:final.left, y:fTop + top}
        ],
        final: {
          x: final.left,
          y: fTop + top
        }
      }
    }

    // Function for adding product to shopify cart using AJAX
    // Private function
    // Arguments:
    // Returning nothing, procedure.
    function ajaxAddProductToCart() {
      var product_box = document.getElementById("quick-cart-product-" + variantId);

      var product_count_box = document.getElementById("quick-cart-product-count-" + variantId);
      var product_count = parseInt(product_count_box.innerText);
      var cartPay_total_count = document.getElementById("quick-cart-pay-total-count");
      var cartPay_total_count_value = parseInt(cartPay_total_count.innerText);
      product_count += count;
      product_count_box.innerText = product_count;
      if (product_count > 1) {
        product_count_box.classList.remove("hide");
      }
      // aktualizace celkoveho poctu ks pro mobilni vzhled
      cartPay_total_count_value += count;
      cartPay_total_count.innerText = cartPay_total_count_value;


      var countBox = document.getElementById("quick-cart-product-count-" + variantId);
      countBox.classList.remove('fadeDown')
      countBox.classList.add('fadeUp')

      if (count < 0) {
        count = 1;
      }

      if (product_box) {
        product_box.classList.remove("show-remove-all");
        last_removed_variant_count = 0;
      }

      var ajax = new XMLHttpRequest();
      ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
          ajaxUpdateCart();
        }
      };
      ajax.open("POST", "/cart/add.js", true);
      ajax.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
      ajax.send(JSON.stringify({quantity: count, id: variantId}));
    }

    function ajaxRemoveProduct(data) {
      var ajax = new XMLHttpRequest();

      ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
          ajaxUpdateCart();
        }
      };
      ajax.open("POST", "/cart/change.js", true);
      ajax.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
      ajax.send(JSON.stringify(data));
    }

    function ajaxRemoveAllProducts(data) {
      var ajax = new XMLHttpRequest();
      ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
          ajaxUpdateCart();
        }
      };
      ajax.open("POST", "/cart/change.js", true);
      ajax.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
      ajax.send(JSON.stringify(data));
    }

    // Function for updating cart with quantity of actual item and orice
    // Private function
    // Arguments:
    // Returning nothing
    function ajaxUpdateCart() {
      var ajax = new XMLHttpRequest();
      ajax.onreadystatechange = function() {
        if (ajax.readyState == 4 && ajax.status == 200) {
          var response = JSON.parse(ajax.responseText);
          cartPrice.innerText = Shopify.formatMoney(response.total_price);
          // Zobrazeni tlacitka na nakup
          if (response.total_price <= 0) {
            cartPay.classList.remove("open");
          }
        }
      };
      ajax.open("GET", "/cart.js", true);
      ajax.setRequestHeader("Content-Type", "application/json;charset=UTF-8");
      ajax.send();
    }

    // Function for removing html of product from cart
    // Private function
    function removeProduct(product_box) {
      cart.removeChild(product_box);
    }

    // procedure for changing cart link destionation depending on size of screen.
    function setPayButtonAction() {
      if (cartPay) {
        // Cart is fixed in right bottom of screen
        var window_w = window.innerWidth || document.documentElement.clientWidth || document.body.clientWidth;

        if (window_w > 600) {
          cartPay.setAttribute("href", "/checkout");
          cartPay.classList.remove("cart-ico");
        } else {
          cartPay.setAttribute("href", "/cart");
          cartPay.classList.add("cart-ico");
        }
      }
    }
    //public methods
    return self;
  };

  return {
    // Get the Singleton instance if one exists
    // or create one if it doesn't
    init: function (att) {
      if ( !instance ) {
        instance = init(att);
      }
      return instance;
    }
  };

})();


// Usage:
var cart = Quickbeam.init({
  'animationLib': 'gsap'
});
</script>
</head>
<body>
	<div class="breadcrumb" role="navigation" aria-label="Breadcrumbs">
		<div class="_cont">
			<ol>
				<li><h3 style="font-size: 20px;">${vo.category_name }</h3></li>
			</ol>
		</div>
		<section aria-label="Main content" role="main" class="product-detail">
			<div itemscope itemtype="http://schema.org/Product">
				<meta itemprop="url"
					content="http://html-koder-test.myshopify.com/products/tommy-hilfiger-t-shirt-new-york">
				<meta itemprop="image"
					content="//cdn.shopify.com/s/files/1/1047/6452/products/product_grande.png?v=1446769025">
				<div class="shadow">
					<div class="_cont detail-top">
						<div class="cols">
							<div class="left-col">
								<!-- 최근 본 설명서 -->
								<div class="thumbs">
									<a class="thumb-image active"
										href="//cdn.shopify.com/s/files/1/1047/6452/products/product_1024x1024.png?v=1446769025"
										data-index="0"> <span><img style="width: 400px;"
											src="//cdn.shopify.com/s/files/1/1047/6452/products/product_150x150.png?v=1446769025"
											alt="Tommy Hilfiger T-Shirt New York"></span>
									</a> <a class="thumb-image active"
										href="//cdn.shopify.com/s/files/1/1047/6452/products/product_1024x1024.png?v=1446769025"
										data-index="0"> <span><img style="width: 400px;"
											src="//cdn.shopify.com/s/files/1/1047/6452/products/product_150x150.png?v=1446769025"
											alt="Tommy Hilfiger T-Shirt New York"></span>
									</a> <a class="thumb-image active"
										href="//cdn.shopify.com/s/files/1/1047/6452/products/product_1024x1024.png?v=1446769025"
										data-index="0"> <span><img style="width: 400px;"
											src="//cdn.shopify.com/s/files/1/1047/6452/products/product_150x150.png?v=1446769025"
											alt="Tommy Hilfiger T-Shirt New York"></span>
									</a>
								</div>
								<div class="big">
									<span id="big-image" class="img" quickbeam="image"
										style="background-image: url(${vo.filepath}); background-size: 420px;"></span>
									<div id="banner-gallery" class="swipe">
										<div class="swipe-wrap">
											<div
												style="background-image: url('//cdn.shopify.com/s/files/1/1047/6452/products/product_large.png?v=1446769025')"></div>
											<div
												style="background-image: url('//cdn.shopify.com/s/files/1/1047/6452/products/tricko1_large.jpg?v=1447104179')"></div>
											<div
												style="background-image: url('//cdn.shopify.com/s/files/1/1047/6452/products/tricko2_large.jpg?v=1447104180')"></div>
											<div
												style="background-image: url('//cdn.shopify.com/s/files/1/1047/6452/products/tricko3_large.jpg?v=1447104182')"></div>
										</div>
									</div>
									<div class="detail-socials">
										<div class="social-sharing"
											data-permalink="http://html-koder-test.myshopify.com/products/tommy-hilfiger-t-shirt-new-york">
											<a target="_blank" class="share-facebook" title="Share"></a>
											<a target="_blank" class="share-twitter" title="Tweet"></a> <a
												target="_blank" class="share-pinterest" title="Pin it"></a>
										</div>
									</div>
								</div>
							</div>
							<div class="right-col">
								<div itemprop="offers" itemscope
									itemtype="http://schema.org/Offer">
									<meta itemprop="priceCurrency" content="USD">
									<link itemprop="availability" href="http://schema.org/InStock">
									<div class="price-shipping">
										<div style="font-size: 32px; margin-right: 12px;"
											class="price" id="price-preview" quickbeam="price"
											quickbeam-price="800">${vo.brand_name}</div>
										<h1 itemprop="name"
											style="text-align: left; margin-top: 34px;">${vo.model_name}</h1>
									</div>
									<%-- <a style="font-size: 20px; text-align: left;">( ${vo.model_code} )</a> --%>
									</br>
									<p style="font-size: 20px; text-align: left;">모델코드 :
										${vo.model_code}</p>
									</br>
				
									<!-- <form method="post" enctype="multipart/form-data" id="AddToCartForm"> -->
									<form id="AddToCartForm">
										<select name="id" id="productSelect" quickbeam="product"
											class="product-single__variants">
											<option selected="selected" data-sku="" value="7924994501">
												M / Blue - $800.00 USD</option>
											<option data-sku="" value="7924995077">M / Red -
												$850.00 USD</option>
											<option data-sku="" value="7924994437">L / Blue -
												$850.00 USD</option>
											<option data-sku="" value="7924994693">L / Yellow -
												$850.00 USD</option>
											<option data-sku="" value="7924995013">L / Red -
												$850.00 USD</option>
											<option data-sku="" value="7924994373">XL / Blue -
												$900.00 USD</option>
											<option data-sku="" value="7924994629">XL / Yellow -
												$850.00 USD</option>
											<option data-sku="" value="7924830021">XXL / Blue -
												$950.00 USD</option>
											<option data-sku="" value="7924994885">XXL / Red -
												$850.00 USD</option>
										</select>
										<div class="btn-and-quantity-wrap">
											<div class="btn-and-quantity">
												<div class="spinner">
													<!-- <span class="btn minus" data-id="2721888517"></span> -->
													<!-- <input type="hidden" id="product_id" name="product_id" value="2721888517"> -->
													<span class="q" style="margin: 0 auto; cursor: pointer;">도움이됐어요
														<i class="fa-regular fa-thumbs-up"></i>
													</span>
													<!-- <span class="btn plus" data-id="2721888517"></span> -->
												</div>
												<div id="AddToCart" quickbeam="add-to-cart">
													<span id="AddToCartText" style="cursor: pointer;">AS센터정보&nbsp;&nbsp;&nbsp;&nbsp;</span>
												</div>
											</div>
										</div>
									</form>
									<div style="margin-top: 70px;" class="tabs">
										<div class="tab-labels">
											<span data-id="1" class="active">Info</span> <span
												data-id="2">Brand</span>
										</div>
										<div class="tab-slides">
											<div id="tab-slide-1" itemprop="description"
												class="slide active">We open source it for you
												https://github.com/greenwoodents/quickbeam.js if you want to
												use it on your ecommerce.</div>
											<div id="tab-slide-2" class="slide">Tony Hunfinger</div>
										</div>
									</div>
									<div class="social-sharing-btn-wrapper">
										<span id="social_sharing_btn">Share</span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
		<section style="padding: 60px;">
			<div style="margin-left: 60px;">
				<object data='${manualvo.filepath }' type="application/pdf"
					width="1100" height="1100">

					<iframe src='${manualvo.filepath }' width="1100" height="1100">
						<p>This browser does not support PDF!</p>
					</iframe>
				</object>
			</div>
		</section>



		<!-- 댓글관리 -->
		<section
			style="background: #dee1e3; padding-top: 50px; padding-bottom: 50px;">
			<!-- Contenedor Principal -->
			
							
			
			<div class="comments-container">
				<h1 style="text-align: left;">의견 및 질문</h1>
				<!-- 새 글쓰기 -->
				<c:if test="${loginInfo !=null }">
					<ul class="comments-list reply-space">
							<li>
								<!-- Avatar -->
								<div class="comment-avatar">
									<c:if test="${loginInfo.filepath == null }">
									 <img src='img/noneprofile.png' alt="1"/>
									</c:if>
									<c:if test="${loginInfo.filepath != null}">
									<img src="${loginInfo.filepath }" alt="">
									</c:if>
									
								</div> <!-- Contenedor del Comentario -->
								<div class="comment-box">
									<div class="comment-head" style="padding-left:0px !important; padding-right:0px !important;">
										
										<input id="comment_insert" type="text" style="width: 86%; border:none; border-bottom: 1px solid gray;" placeholder="새 글을 입력해주세요">
											 <%-- <a onclick="reply_cancel('reply-space${status.index}')" contenteditable="false" class="btn-fill" style="margin-left: 6px; background-color: #a9a9a9; border: 1px solid #a9a9a9; color: #e9e9e9; box-shadow: 2px 2px 3px black;">취소</a> --%>
											 <a onclick="insert(${loginInfo.email})"  class="btn-fill" style="box-shadow: 2px 2px 3px black; color: #e9e9e9" >등록</a>
										

									</div>
									
								</div>
							</li>
					</ul>
					<hr>
				</c:if>	
				<ul id="comments-list" class="comments-list">
				
				
				<!-- ------------------------------------------------------------------------------------------- -->
				
				
				
				
				
				
					<c:forEach items="${commentlist }" var="commentvo" varStatus="status">

						<li>

							<div class="comment-main-level">
								<!-- Avatar -->
								<div class="comment-avatar">
									<img src="${commentvo.filepath}" alt="">
								</div>
								<!-- Contenedor del Comentario -->
								<div class="comment-box">
									<div class="comment-head">
										<c:if test="${commentvo.cmt_code eq 'o' }">

											<h6 class="comment-name by-author">
												<a style="padding-right: 0 !important;">${commentvo.email} > </a>
											</h6>
										</c:if>
										<c:if test="${commentvo.cmt_code eq 'q' }">

											<h6 class="comment-name by-authore">
												<a>${commentvo.email}</a>
											</h6>
										</c:if>
										<span >${commentvo.writedate }</span> 
										<c:if test="${loginInfo.email == commentvo.email }">
										<div style="width: 100%; text-align: right;"><a>수정</a><a>삭제</a></div>
										</c:if>
									</div>
									<div class="comment-content"
										style="text-align: left; padding-left: 30px; padding-right: 10px;">
										${commentvo.content }
										</br>
										<a style="margin-top: 20px;" onclick="reply('reply-space${status.index}')">답글</a>
									</div>
									
								</div>
								
								
								
								<!-- ------------------------------------------------------------------------------------------- -->
								
								
								
							</div> <!-- Respuestas de los comentarios -->
							<ul id="reply-space${status.index}" style="display: none;" class="comments-list reply-list reply-space">
									<li>
										<!-- Avatar -->
										<div class="comment-avatar">
											<img src="${loginInfo.filepath }" alt="">
										</div> <!-- Contenedor del Comentario -->
										<div class="comment-box">
											<div class="comment-head" style="padding-left:0px !important; padding-right:0px !important;">
												
												<input id="reply-content${status.index}" type="text" style="width: 75%; border:none; border-bottom: 1px solid black;" placeholder="댓글을 입력해주세요">
													 <a onclick="reply_cancel('reply-space${status.index}')" contenteditable="false" class="btn-fill" style="margin-left: 6px; background-color: #a9a9a9; border: 1px solid #a9a9a9; color: #e9e9e9; box-shadow: 2px 2px 3px black;">취소</a>
													 <a onclick="reply_commit('reply-content${status.index}','${commentvo.board_id}','${vo.model_code }')"  class="btn-fill" style="box-shadow: 2px 2px 3px black; color: #e9e9e9" >등록</a>
												
 
											</div>
											
										</div>
									</li>
							</ul>
							
							
							<ul class="comments-list reply-list">
								<c:forEach items="${commentvo.replylist }" var="replyvo" varStatus="replystatus">
									<li>
										<!-- Avatar -->
										<div class="comment-avatar">
											<img src="${replyvo.filepath }" alt="">
										</div> <!-- Contenedor del Comentario -->
										<div class="comment-box">
											<div class="comment-head">
												<h6 class="comment-name">
													<a>${replyvo.email}</a>
												</h6>
											
													<span>${replyvo.writedate }</span>
													
											<c:if test="${loginInfo!=null && loginInfo.email == replyvo.email }">
												<div style="width: 100%; text-align: right;"><a id="reply_modify_button${replystatus.index }" onclick="reply_modify('reply_id${replystatus.index }','reply_modify_id${replystatus.index }','${replyvo.content }','reply_modify_button${replystatus.index }','reply_delete_button${replystatus.index }' )">수정</a><a id="reply_delete_button${replystatus.index }" onclick="reply_delete('reply_delete_button${replystatus.index }','${replyvo.rep_no}', 'reply_modify_id${replystatus.index }')" >삭제</a></div>
											</c:if>

											</div>
											<div class="comment-content"
												style="text-align: left; padding-left: 30px; padding-right: 10px;">
												<a style="display: block;" id="reply_id${replystatus.index }">${replyvo.content }</a>
												<input id="reply_modify_id${replystatus.index }" type="text" value="" style="display:none; border-top:none !important; border-left:none !important; border-right:none !important; border-bottom: 1px solid gray;">
												</div>
											
											
										</div>
									</li>
								</c:forEach>
								
								
							</ul>
						</li>
					</c:forEach>
					
				</ul>
			</div>
		</section>
	</div>
	
	<script type="text/javascript">

document.addEventListener("click", reply);
document.addEventListener("click", reply_cancel);
document.addEventListener("click", reply_commit);
document.addEventListener("click", reply_modify);
document.addEventListener("click", reply_delete);
/* document.addEventListener("click", insert); */
/* 답글 등록 */
function reply_commit(content_id, board_id, model_code){
	console.log(content_id);
	const content = document.getElementById(content_id).value;
	console.log(content);
	 location.href='/pj_web/coment_insert_web.mo?board_id='+board_id+'&content='+ content +'&email=${loginInfo.email}&model_code='+model_code;
	return;
	}
/* 답글쓰기 */
function reply(id){
	console.log(id);
	 document.getElementById(id).style.display = "block";
return;
}

/* 답글쓰기 취소 */
function reply_cancel(id){
	console.log(id);
	 document.getElementById(id).style.display = "none";
return;
}

//댓글수정
function reply_modify(a_tag, input_tag, modify_content, modify_button, delete_button){
	var a_tag = document.getElementById(a_tag);
	var input_tag = document.getElementById(input_tag);
	var modify_button = document.getElementById(modify_button);
	var delete_button = document.getElementById(delete_button);
	
	
	if(modify_button.textContent == "수정"){
		input_tag.value = modify_content;
		modify_button.innerText="취소";
		delete_button.innerText="저장"
		a_tag.style.display = "none";
		input_tag.style.display = "block";
	}else{
		modify_button.innerText="수정";
		delete_button.innerText="삭제";
		a_tag.value = modify_content;
		input_tag.style.display = "none";
		a_tag.style.display = "block";
	}
	
}

//댓글삭제 , 수정저장

function reply_delete(delete_button, rep_no, modify_content){
	var delete_button = document.getElementById(delete_button);
	var modify_content = document.getElementById(modify_content);
	const modify_contente = modify_content.value;
	if(delete_button.textContent == "삭제"){
		Swal.fire({
			   title: '정말 삭제 하시겠습니까??',
			   text: '다시 되돌릴 수 없습니다.',
			   icon: 'warning',
			   
			   showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
			   confirmButtonColor: '#020e20', // confrim 버튼 색깔 지정
			   cancelButtonColor: '#da9a9a9', // cancel 버튼 색깔 지정
			   confirmButtonText: '확인', // confirm 버튼 텍스트 지정
			   cancelButtonText: '취소', // cancel 버튼 텍스트 지정
			   
			   reverseButtons: false, // 버튼 순서 거꾸로
			   
			}).then(result => {
			   // 만약 Promise리턴을 받으면,
			   if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
			   
			      Swal.fire('삭제가 완료되었습니다.', '', 'success').then(result =>{
			    	  
			      location.href = "/pj_web/comment_reply_delete_web?rep_no="+rep_no+"&model_code=${vo.model_code}";
			      });
			   }
			});
		
	}else{
	
		Swal.fire({
			   title: '수정하시겠습니까??',
			   text: '다시 수정이 가능합니다.',
			   icon: 'qeustion',
			   
			   showCancelButton: true, // cancel버튼 보이기. 기본은 원래 없음
			   confirmButtonColor: '#020e20', // confrim 버튼 색깔 지정
			   cancelButtonColor: '#da9a9a9', // cancel 버튼 색깔 지정
			   confirmButtonText: '확인', // confirm 버튼 텍스트 지정
			   cancelButtonText: '취소', // cancel 버튼 텍스트 지정
			   
			   reverseButtons: false, // 버튼 순서 거꾸로
			   
			}).then(result => {
			   // 만약 Promise리턴을 받으면,
			   if (result.isConfirmed) { // 만약 모달창에서 confirm 버튼을 눌렀다면
			   
				   location.href="/pj_web/comment_reply_update_web?rep_no="+rep_no+"&model_code=${vo.model_code}&content="+modify_contente;
			   }
			});
		
		
	}
	
}


/* 	#(#AddToCartText).click(function(){
		location.href='/pj_web/as_list_web?brand_name='+vo.brand_name;
	}); */

</script>
<script type="text/javascript">
$('#AddToCart').click(function(){
	/* window.open('https://www.samsungsvc.co.kr', '_blank');  */
	/* location.href='/pj_web/as_list_web?brand_name='+${vo.brand_name}; */
	
	window.open('https://map.kakao.com/link/search/${vo.brand_name} 서비스센터', '_blank');
});
//새글쓰기
function insert(email){
	const comment_content = document.getElementById('comment_insert').value;
	console.log(comment_content);
	const model_code = '${vo.model_code}';
	console.log(model_code);
/* 	const email = ${loginInfo.email};
	console.log(email); */
	location.href="/pj_web/comment_insert_web?content="+comment_content+"&model_code="+model_code+"&cmt_code=o&email="+email;

}


</script>
</body>

</html>