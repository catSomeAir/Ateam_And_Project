<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#tabs {
	display: flex;  border-bottom: 1px solid #3367d6;
}
#tabs li {
	width: 140px;  line-height: 40px; 	color: #3367d6;
	border: 1px solid #3367d6;  border-bottom: none; cursor: pointer;
}
#tabs li:not(:first-child) { border-left: none; } 
#tabs li.active { background-color: #3367d6; color: #fff; }
#tab-content { width: 1200px; height: 550px; margin: 20px auto; }

.c3-axis, .c3-chart { font-size: 15px; }
#legend { display: flex;  justify-content: center; }
#legend li { display: flex; align-items: center; }
#legend li:not(:first-child) { margin-left:30px; }
.legend { width:15px; height: 15px; margin-right: 5px }

.tab { margin-bottom: 20px }
.year { width: 40px }
</style>
<link rel='stylesheet' href='https://cdnjs.cloudflare.com/ajax/libs/c3/0.7.20/c3.css'>
<link rel='stylesheet' href='css/yearpicker.css?<%=new java.util.Date()%>'>
<script src='https://cdnjs.cloudflare.com/ajax/libs/d3/5.16.0/d3.min.js'></script>
<script src='js/yearpicker.js'></script>
</head>
<body>
<h3>사원정보분석</h3>
<!-- 부서별 사원수 시각화, 채용인원 시각화 -->
<div class='w-px1200' style='margin: 0 auto'>
	<ul id='tabs'>
		<li>부서원수</li>
		<li>채용인원수</li>
	</ul>
</div>
<div id='tab-content'>
	<div class='tab'>
		<label><input type='radio' name='chart' value='bar' checked>막대그래프</label>
		<label><input type='radio' name='chart' value='donut'>도넛그래프</label>
	</div>
	<div class='tab'>
		<label><input type='checkbox' id='top3'>TOP3부서</label>
		<label><input type='radio' name='unit' value='year' checked>년도별</label>
		<label><input type='radio' name='unit' value='month'>월별</label>
		<label><input type='text' class='year' id='begin'>
				~ <input type='text' class='year' id='end'></label>
	</div>
	<div id='chart'></div>
	<ul id='legend'>
		<li><span class='legend'></span><span>0~9명</span></li>
		<li><span class='legend'></span><span>10~19명</span></li>
		<li><span class='legend'></span><span>20~29명</span></li>
		<li><span class='legend'></span><span>30~39명</span></li>
		<li><span class='legend'></span><span>40~49명</span></li>
		<li><span class='legend'></span><span>50~59명</span></li>
		<li><span class='legend'></span><span>60명이상</span></li>
	</ul>
</div>
<div class='loading center'><img src='img/loading.gif'></div>

<script src='https://cdnjs.cloudflare.com/ajax/libs/c3/0.7.20/c3.min.js'></script>
<script>
$(document).on('click', '.yearpicker-items', function(){
	init();
	hirement();
});

$('[name=chart]').change(function(){ //막대/도넛 선택 변경시
	init();
	department();
});
$('[name=unit], #top3').change(function(){ //년도별/월별 선택 변경시
	$('.year:eq(0)').closest('label').css('display'
					,  $('[name=unit]:checked').val()=='year' ? 'inline' : 'none' );
	init();
	hirement();
});

var thisYear = new Date().getFullYear();
$('#end').yearpicker({
	year: 2005, // thisYear,
	endYear: thisYear,
});
$('#begin').yearpicker({
	year: 2001, //thisYear-9,
	endYear: thisYear,
});

$(function(){
	$('#tabs li').eq(1).trigger('click');
	$('.legend').each(function(idx){
		$(this).css('background-color', colors[idx]);
	});
});

$('#tabs li').click(function(){
	if( $(this).hasClass('active') ) return;  //현재 선택된 탭을 다시 클릭한 경우
	
	$('#tabs li').removeClass();
	$(this).addClass('active');
	
	init();
	var idx = $(this).index();
	$('.tab').css('display', 'none');
	$('.tab').eq(idx).css('display', 'block');
	if( idx==0 )  			department();
	else if( idx==1 )		hirement();	
});

function init(){
	$('#legend').css('display', 'none');
	$('#chart').empty();
}

//부서원수 시각화
function department(){
	loading( true );
	$.ajax({
		url: 'visual/department',
		success: function( response ){
			//[['부서원수', 30, 20, 10, 40, 15, 25]] //선/막대그래프
			//[['Administration', 30],['Purchasing', 120], ... ] //파이/도넛그래프
			var count = [ '부서원수' ], name = [ '부서명' ], info = [] ;
			$(response).each(function(){
				count.push( this.COUNT );
				name.push( this.DEPARTMENT_NAME );
				
				info.push( new Array(this.DEPARTMENT_NAME, this.COUNT) );
			});
			//console.log( response )
			//console.log( count )
			//make_chart( [name, count] ); 	//선/막대그래프
			//make_chart( info ); 			//파이/도넛그래프
			if( $('[name=chart]:checked').val()=='bar' )
				bar_chart( [name, count] );
			else
				donut_chart(info);
				
			
			loading( false );
		},error: function(){
			loading( false );
		}
	});
}

function make_chart(info){
	//1.선그래프(기본)
	//line_chart(info);
	
	//2.파이그래프
	//pie_chart(info);
	
	//3.도넛그래프
	//donut_chart(info);
	
	//4.막대그래프
	bar_chart(info);
}

var colors = [ '#08d13b', '#5c08d1', '#f7dc0c', '#0c52f7'
				, '#f7820c', '#270cf7', '#0cebf7', '#f70c0c'
				, '#3b0cf7', '#f70c99', '#913c73', '#81a100' ];

//막대그래프
function bar_chart(info){
	c3.generate({
		bindto: '#chart',
		data: { columns:info, type:'bar', x:'부서명', labels:true,
				color: function(color, data){
					//return colors[data.index]; //막대에 대해 특정 색상 지정
					return colors[ Math.floor(data.value/10) ];
				},
		},
		axis: {
			x: { type:'category', tick:{ rotate: -60 } },
			y: { label:{ text:'부서원수', position:'outer-middle' } },
		},
		size: { height:450 },
		bar: { width:30 }, //막대의 너비
		grid: { y:{ show:true }, }, //y축 그리드
		legend: { hide:true }, //범례 안보이게
	});
	$('#legend').css('display', 'flex');
}

//부서원수 별로 색상 지정
//0~9미만은 1번째(인덱스0), 10~19: 2번째 색상(인덱스1) 
//, 20~29: 3번째 색상(인덱스2), 30~39: 4번째 색상(인덱스3) , ....


//도넛그래프
function donut_chart(info){
	c3.generate({
		bindto: '#chart',
		data: {
			columns: info,  type: 'donut'
		},
		size: { height:450 },
		padding: { bottom:50 },
		donut: {
			title: '부서원수',
			width: 100, //도넛의 굵기,
			label: {
				format: function(v, r, id){
					return (r*100).toFixed(1) + '%('+ v +'명)';
				}
			}
		}
	});
	$('#legend').css('display', 'none');
}

//파이그래프
function pie_chart(info){
	console.log( info )
	var chart = c3.generate({
	 	bindto: '#chart',
	 	data: { 
	 		columns: info,
        	type : 'pie',	 		
	 	},
	 	size: { height:450 },
	 	pie: {
	 		label: {
	 			format:function(value, ratio, id){
	 				return (ratio*100).toFixed(1) + '%('+ value +'명)';
	 			}
	 		},
	 	},
	 	padding: { bottom: 50 }, //그래프와 범례간 간격
	});
}

//선그래프
function line_chart(info){
	var chart = c3.generate({
	    data: {
	    	x: '부서명',
	        columns: info
	        //[ ['x', 30, 50, 100, 230, 300, 310]
	        //, ['data1', 30, 200, 100, 400, 150, 250] ]
	    },
	    axis: {
	        x: {
	            type: 'category' // this needed to load string x value
	        }
	    },
	    size: { height: 450 },
	});
	
}

//채용인원수 시각화
function hirement(){
	if( $('#top3').prop('checked') )
		hirement_top3_chart(); //상위3위부서에 대한 채용인원수
	else
		hirement_chart(); //전체사원 채용인원수
}

//상위3위부서에 대한 채용인원수 시각화
function hirement_top3_chart(){
	loading( true );
	var unit = $('[name=unit]:checked').val();
	$.ajax({
		type: 'post',
		contentType: 'application/json',
		data: JSON.stringify( { begin:$('#begin').val(), end:$('#end').val() } ),
		url: 'visual/hirement/top3/' + unit,
		success: function( response ){
			console.log( response );
			var info = new Array();
			if( unit=='year' ){	
				var years = new Array( '부서명' );
				for(var year=$('#begin').val(); year<=$('#end').val(); year++){
					years.push( year );
				}
				info.push( years );
				$(response).each(function(){
					years = new Array( this.DEPARTMENT_NAME );
					for(var year=$('#begin').val(); year<=$('#end').val(); year++){
						years.push( this['Y'+year] ? this['Y'+year] : 0 );
					}
					info.push( years );
				});
				/*
				info.push( ['부서명', 2001, 2002, 2003, 2004, 2005
							, 2006, 2007, 2008, 2022 ] );
				$(response).each(function(){
					info.push( new Array( this.DEPARTMENT_NAME, this.Y2001, this.Y2002
										, this.Y2003, this.Y2004, this.Y2005, this.Y2006
										, this.Y2007, this.Y2008, this.Y2022) );
				});
				*/
			}else{
				info.push( ['부서명', '01', '02', '03', '04', '05'
						, '06', '07', '08', '09', '10', '11', '12' ] );
				$(response).each(function(){
					info.push( new Array( this.DEPARTMENT_NAME, this.M01, this.M02
							, this.M03, this.M01, this.M05, this.M06
							, this.M07, this.M08, this.M09
							, this.M10, this.M11, this.M12) );
				});
			}
			console.log( info );
			make_chart_top3( info );
			loading( false );
		},error: function(){
			loading( false );
		}
	});
}

function make_chart_top3( info ){
	var unit = $('[name=unit]:checked').val();
	c3.generate({
		bindto: '#chart',
		data: { columns: info, x: info[0][0], labels: true
				, type: unit=='year' ? 'bar' : 'line',
		},
		size: { height:450 },
		bar: { width:20 },
		grid: { y:{show:true} },
		axis: {
			x: { type:'category' },
			y: { label:{ text: (unit=='year'? '년도' : '월')+ '별 채용인원수'
						, position:'outer-top'} },
		},
		padding: { bottom:50 },
		legend: { padding: 40,  item:{ tile: { width:15, height:15 } }, },
	});
	$('.c3-legend-item').css('font-size', '15px');
	$('.c3-line').css('stroke-width', '3px');
}

//전체사원에 대한 채용인원수 시각화
function hirement_chart(){
	loading( true );
	var unit = $('[name=unit]:checked').val();
	
	$.ajax({
		type: 'post', 
		contentType: 'application/json',
		data: JSON.stringify({ begin:$('#begin').val(), end:$('#end').val() }), 
		url: 'visual/hirement/' + unit,
		success: function( response ){
			console.log( response )
			var name = [ unit ], count = new Array( '채용인원수' );
			$(response).each(function(){
				name.push( this.UNIT );
				count.push( this.COUNT );
			});
			//make_chart_hirement( [ name, count ] );
			make_chart_hirement( new Array(name, count) );
			
			loading( false );
			
		},error: function(){
			loading( false );
		}
	});
}

//년도별/월별 채용인원수 막대그래프
function make_chart_hirement( info ){
	c3.generate({
		bindto: '#chart',
		data: { columns: info, type: 'bar', labels: true,
			x: info[0][0],
			color: function(c, d){ return colors[ Math.floor(d.value/10) ] },
		},
		axis: {
			x: { type:'category' },
			y: { label:{ text: info[1][0], position:'outer-top' } },
		},
		legend: { hide:true },
		grid: { y: { show:true } },
		bar: { width:30	},
		size: { height:450 },
	});
	$('#legend').css('display', 'flex');
}


</script>
</body>
</html>