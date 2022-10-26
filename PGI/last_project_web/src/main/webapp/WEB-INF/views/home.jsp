<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=utf-8" 
		pageEncoding="utf-8" %>
<html>

<head>
	<title>Home</title>
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Oswald:300,400,700);
@import url(https://fonts.googleapis.com/css?family=Source+Sans+Pro:200,300,400,600,700,900,200italic,300italic,400italic,600italic,700italic,900italic);

/* Override UGG site */
#main {width: 100%; padding:0;}
.content-asset p {margin:0 auto;}
.breadcrumb {display:none;}

/* Helpers */
/**************************/
.margin-top-10 {padding-top:10px;}
.margin-bot-10 {padding-bottom:10px;}

/* Typography */
/**************************/
#parallax-world-of-ugg h1 {font-family:'Oswald', sans-serif; font-size:24px; font-weight:400; text-transform: uppercase; color:black; padding:0; margin:0;}
#parallax-world-of-ugg h2 {font-family:'Oswald', sans-serif; font-size:70px; letter-spacing:10px; text-align:center; color:white; font-weight:400; text-transform:uppercase; z-index:10; opacity:.9;}
#parallax-world-of-ugg h3 {font-family:'Oswald', sans-serif; font-size:14px; line-height:0; font-weight:400; letter-spacing:8px; text-transform: uppercase; color:black;}
#parallax-world-of-ugg p {font-family:'Source Sans Pro', sans-serif; font-weight:400; font-size:14px; line-height:24px;}
.first-character {font-weight:400; float: left; font-size: 84px; line-height: 64px; padding-top: 4px; padding-right: 8px; padding-left: 3px; font-family: 'Source Sans Pro', sans-serif;}

.sc {color: #3b8595;}
.ny {color: #3d3c3a;}
.atw {color: #c48660;}

/* Section - Title */
/**************************/
#parallax-world-of-ugg .title {background: white; padding: 60px; margin:0 auto; text-align:center;}
#parallax-world-of-ugg .title h1 {font-size:35px; letter-spacing:8px;}

/* Section - Block */
/**************************/
#parallax-world-of-ugg .block {background: white; padding: 60px; width:820px; margin:0 auto; text-align:justify;}
#parallax-world-of-ugg .block-gray {background: #f2f2f2;padding: 60px;}
#parallax-world-of-ugg .section-overlay-mask {position: absolute; top: 0; left: 0; width: 100%; height: 100%; background-color: black; opacity: 0.70;}

/* Section - Parallax */
/**************************/
#parallax-world-of-ugg .parallax-one {padding-top: 200px; padding-bottom: 200px; overflow: hidden; position: relative; width: 100%; background-image: url(https://images.unsplash.com/photo-1415018255745-0ec3f7aee47b?dpr=1&auto=format&fit=crop&w=1500&h=938&q=80&cs=tinysrgb&crop=); background-attachment: fixed; background-size: cover; -moz-background-size: cover; -webkit-background-size: cover; background-repeat: no-repeat; background-position: top center;}
#parallax-world-of-ugg .parallax-two {padding-top: 200px; padding-bottom: 200px; overflow: hidden; position: relative; width: 100%; background-image: url(https://images.unsplash.com/photo-1432163230927-a32e4fd5a326?dpr=1&auto=format&fit=crop&w=1500&h=1000&q=80&cs=tinysrgb&crop=); background-attachment: fixed; background-size: cover; -moz-background-size: cover; -webkit-background-size: cover; background-repeat: no-repeat; background-position: center center;}
#parallax-world-of-ugg .parallax-three {padding-top: 200px; padding-bottom: 200px; overflow: hidden; position: relative; width: 100%; background-image: url(https://images.unsplash.com/photo-1440688807730-73e4e2169fb8?dpr=1&auto=format&fit=crop&w=1500&h=1001&q=80&cs=tinysrgb&crop=); background-attachment: fixed; background-size: cover; -moz-background-size: cover; -webkit-background-size: cover; background-repeat: no-repeat; background-position: center center;}

/* Extras */
/**************************/
#parallax-world-of-ugg .line-break {border-bottom:1px solid black; width: 150px; margin:0 auto;}

/* Media Queries */
/**************************/
@media screen and (max-width: 959px) and (min-width: 768px) {
  #parallax-world-of-ugg .block {padding: 40px; width:620px;}
}
@media screen and (max-width: 767px) {
  #parallax-world-of-ugg .block {padding: 30px; width:420px;}
  #parallax-world-of-ugg h2 {font-size:30px;}
  #parallax-world-of-ugg .block {padding: 30px;}
  #parallax-world-of-ugg .parallax-one, #parallax-world-of-ugg .parallax-two, #parallax-world-of-ugg .parallax-three {padding-top:100px; padding-bottom:100px;}
}
@media screen and (max-width: 479px) {
  #parallax-world-of-ugg .block {padding: 30px 15px; width:290px;}
}

</style>

<!-- 검색창  -->
<style type="text/css">
@import url(https://fonts.googleapis.com/css?family=Open+Sans);

body{
  background: #f2f2f2;
  font-family: 'Open Sans', sans-serif;
}

.search {
  width: 105%;
  position: relative;
  display: flex;
  border: 2px solid #020e20;
  border-radius: 15px;
  justify-content: flex-end;
  flex-direction: row;
}

.searchTerm {
  width: 80%;
  /* border: 3px solid #020E20; */
  /* border-right: none; */
  border-style: none;
  padding: 5px;
  height: 42px;
  border-radius: 15px;
  outline: none;
  color: #9DBFAF;
}

.searchTerm:focus{
  color: #020E20;
}

.searchButton {
  width: 51px;
  height: 52px;
  border-style: none;
  background: #ffffff00;
  text-align: center;
  color: #040e1d;
  cursor: pointer;
  font-size: 20px;
}

/*Resize the wrap to see the search bar change!*/
.wrap{
margin: 0px auto;

  width: 30%;
/*   position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%); */
}
/* .chat_icon{
position:fixed;
width: 290px;
height: 50px;
background-color: black;
color:white;
bottom: 0;
left: 1800px;
} */
  .chat_icon {
        position:fixed;
        bottom: 0;
		left: 1900px;
      /*   margin: 50px; */
        width:140px;
        height:90px;
        background:black;
        border-radius: 100%;
        color: white;
        line-height: 90px;
        cursor: pointer;
    }
    .chat_icon:after {
        content:"";
        background:black;
        border-top: 15px solid black;
        border-left: 15px solid transparent;
        border-right: 0px solid transparent;
        border-bottom: 0px solid transparent;
        position: absolute;
        top: 15px;
        left: 120px;
    }
</style>
</head>
<body style="padding: 0px">
<div id="parallax-world-of-ugg">
  
<section>
<!--   <div class="title">
    <h3>나의 설명서</h3>
    <h1>시작해볼까요</h1>
  </div> -->
  <div class="title">
  <div class="wrap">
  <form action="search_web.mo">
   <div class="search">
      <input type="text" name="search_text" class="searchTerm" placeholder="찾으시는 제품을 검색해주세요.">
      <button type="submit" class="searchButton">
        <i class="fa fa-search"></i>
     </button>
   </div>
   </form>
   </div>
</div>
</section>

<section>
    <div class="parallax-one">
      <h2>나에게 꼭 맞는, 손쉬운 사용</h2> 
    </div>
</section>

<section>
  <div class="block">
    <p><span class="first-character sc">사</span>용 설명서, 언박싱 하자마자 던져버리기 일수지만 정작 필요한 때 찾아보려하면 번거롭고 찾기 힘든 경우들이 많습니다. 우리는 이러한 번거로움을 해결하고 사용자의 패턴을 파악해서 더 편리하고 나에게 꼭 맞는 서비스를 제공하고자 나의설명서를 만들었습니다. 부족한게 많지만 더욱 정진하여 더 나은 퀄리티의 프로젝트를 진행하도록 하겠사오니 많은 관심과 격려 부탁드립니다.</p>
    <p class="line-break margin-top-10"></p>
    <p class="margin-top-10">사용 설명서, 언박싱 하자마자 던져버리기 일수지만 정작 필요한 때 찾아보려하면 번거롭고 찾기 힘든 경우들이 많습니다. 우리는 이러한 번거로움을 해결하고 사용자의 패턴을 파악해서 더 편리하고 나에게 꼭 맞는 서비스를 제공하고자 나의설명서를 만들었습니다. 부족한게 많지만 더욱 정진하여 더 나은 퀄리티의 프로젝트를 진행하도록 하겠사오니 많은 관심과 격려 부탁드립니다.</p>
  </div>
</section>

<section>
  <div class="parallax-two">
    <h2>열정과 패기</h2>
  </div>
</section>

<section>
  <div class="block">
    <p><span class="first-character ny">노</span>력하는자를 천재는 이길 수 없다 했습니다. 삶은 언제나 힘들지만은 않습니다. 하지만 힘들 때에는 참으로 괴롭기만 합니다. 그래서 힘이 들 때 힘이 되는 글과 희망을 주는 글로써 여러분들에게 작은 힘이 되어 드리고 싶습니다. 한창 힘이 들 때 한강 다리에 갔더니 이런 글이 있더군요. 바닥은 끝을 의미합니다. 하지만 방향을 바꾸면 바닥은 발판이 되기도 합니다. 바닥은 끝이 아닌 새로운 시작입니다.</p>
    <p class="line-break margin-top-10"></p>
    <p class="margin-top-10">세상이 아무리 힘들어도 분명히 꽃은 핍니다. 힘내세요 힘들 때 흘리는 땀 힘들어 흘리는 눈물 정상에 올랐을 때 그 눈물의 가치는 빛이 납니다. 마음이 힘들면 잠시 그 생각을 놓아두고 명상을 하고, 음악도 듣고, 영화를 보고, 여행도 하면서 이렇게 하다 보면 힘든 것은 자연스럽게 사라질 것입니다. 언제 그랬냐는 듯. 이자리에 계신 모든 분들에게 작은 힘이라도 되고 싶습니다.</p>
  </div>
</section>

<section>
  <div class="parallax-three">
    <h2>ENCHANTED FOREST</h2>
  </div>
</section>

<section>
  <div class="block">
    <p><span class="first-character atw">W</span>hen the New York fashion community notices your brand, the world soon follows. The widespread love for UGG extended to Europe in the mid-2000's along with the stylish casual movement and demand for premium casual fashion. UGG boots and shoes were now seen walking the streets of London, Paris and Amsterdam with regularity. To meet the rising demand from new fans, UGG opened flagship stores in the UK and an additional location in Moscow. As the love spread farther East, concept stores were opened in Beijing, Shanghai and Tokyo. UGG Australia is now an international brand that is loved by all. This love is a result of a magical combination of the amazing functional benefits of sheepskin and the heightened emotional feeling you get when you slip them on your feet. In short, you just feel better all over when you wear UGG boots, slippers, and shoes.</p>
    <p class="line-break margin-top-10"></p>
    <p class="margin-top-10">In 2011, UGG will go back to its roots and focus on bringing the active men that brought the brand to life back with new styles allowing them to love the brand again as well. Partnering with Super Bowl champion and NFL MVP Tom Brady, UGG will invite even more men to feel the love the rest of the world knows so well. UGG will also step into the world of high fashion with UGG Collection. The UGG Collection fuses the timeless craft of Italian shoemaking with the reliable magic of sheepskin, bringing the luxurious feel of UGG to high end fashion. As the love for UGG continues to spread across the world, we have continued to offer new and unexpected ways to experience the brand. The UGG journey continues on and the love for UGG continues to spread.</p>
  </div>
</section>
  
</div>
<div class="chat_icon" onclick="location='broadcasting'">채팅하기</div>
</body>
</html>
