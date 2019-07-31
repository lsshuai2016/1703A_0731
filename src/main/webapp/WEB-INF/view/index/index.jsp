<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
<title>CMS系统</title>

<!-- Bootstrap -->
<link rel="stylesheet" href="/resource/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css"
	href="/resource/css/cms.css?v=1.1" />
<style type="text/css">
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/view/common/top.jsp"></jsp:include>

	<div>
		<br/>
	</div>
	<div class="container">
		<div class="row">
			<!-- 栏目-->
			<div class="col-md-2 ">
				<ul class="list-group">
					<li class="list-group-item  text-center" id="channel">
						<a class="channel" href="/">热门</a>
					</li>

					<c:forEach items="${channels}" var="c">
						<li class="list-group-item text-center" id="channel${c.id }">
							<a class="channel" href="/?channelId=${c.id}">${c.name}</a>
						</li>
					</c:forEach>
				</ul>
			</div>

			<!-- 中间内容主体区 -->

			<div class="col-md-7 split min_h_500">
				<!-- 默认显示图片轮播+热点内容 -->
				<c:if test="${article.channelId ==null }">

					<div id="hot">
						<div id="carousel" class="carousel slide" data-ride="carousel">
							<ol class="carousel-indicators">
								<li data-target="#carousel" data-slide-to="0" class="active"></li>
								<li data-target="#carousel" data-slide-to="1"></li>
								<li data-target="#carousel" data-slide-to="2"></li>
								<li data-target="#carousel" data-slide-to="3"></li>
								<li data-target="#carousel" data-slide-to="4"></li>
								<li data-target="#carousel" data-slide-to="5"></li>
								<li data-target="#carousel" data-slide-to="6"></li>
								<li data-target="#carousel" data-slide-to="7"></li>
							</ol>
							<div class="carousel-inner">
								<div class="carousel-item active">
									<img class="d-block w-100" style="height: 320px;width: 630px;" src="/pic/b4cc043d-9c97-412b-a9ea-8d10e0781a70.jpg" alt="First slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" style="height: 320px;width: 630px;" src="/pic/cj.png" alt="Second slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" style="height: 320px;width: 630px;" src="/pic/u=2096365257,1124277237&fm=26&gp=0.jpg" alt="Third slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" style="height: 320px;width: 630px;" src="/pic/u=2881303562,336932824&fm=72.jpg" alt="Fourth slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" style="height: 320px;width: 630px;" src="/pic/u=3827029467,336250078&fm=26&gp=0.jpg" alt="Fifth slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" style="height: 320px;width: 630px;" src="/pic/u=43531180,868126625&fm=26&gp=0.jpg" alt="Sixth slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" style="height: 320px;width: 630px;" src="/pic/gx.png" alt="Seventh slide">
								</div>
								<div class="carousel-item">
									<img class="d-block w-100" style="height: 320px;width: 630px;" src="/pic/1658484c661f5bc89814af2527c3ccd3.jpg" alt="Eighth slide">
								</div>
							</div>
							<a class="carousel-control-prev" href="#carousel" role="button"
								data-slide="prev"> <span class="carousel-control-prev-icon"
								aria-hidden="true"></span> <span class="sr-only">Previous</span>
							</a> <a class="carousel-control-next" href="#carousel" role="button"
								data-slide="next"> <span class="carousel-control-next-icon"
								aria-hidden="true"></span> <span class="sr-only">Next</span>
							</a>
						</div>
						<br>
						<!-- 新闻热点 -->
						<c:forEach items="${hotArticles}" var="c">
							<div class="media">
								<img class="align-self-start mr-3" src="/pic/${c.picture }" alt="no pic">
								<div class="media-body">
									<h5 class="mt-0">
										<a href="javascript:detail(${c.id })" style="${styles.styles}">${c.title }</a>
									</h5>
									<p class="blog_item_footer">
										<span class="glyphicon glyphicon-user" title="作者"></span>
										作者：${c.username}&nbsp;&nbsp;&nbsp; 
										<span class="glyphicon glyphicon-time" title="发布时间"></span>
										发布：&nbsp;${c.updated }&nbsp;&nbsp;&nbsp;&nbsp;
									</p>
								</div>
							</div>
							<br />
						</c:forEach>
						
					</div>

				</c:if>
				
				<c:if test="${article.channelId!=null }">
				<!-- 分类 -->
				<div id="category">
					<ul class="nav">
						<!--栏目下所有 分类 -->
						<li class="nav-item" id="cat">
							<a class="nav-link" href="/?channelId=${article.channelId}">全部</a>
						</li>
						<c:forEach items="${categorys}" var="c">
							<li class="nav-item" id="cat${c.id }">
								<a class="nav-link" href="/?channelId=${c.channel_id}&categoryId=${c.id}">${c.name }</a>
							</li>
						</c:forEach>
					</ul>
				</div>
				<br />

				<!-- 文章 -->
				
					<div id="article">
						<c:forEach items="${articles}" var="c">
							<div class="media">
								<img class="align-self-start mr-3" src="/pic/${c.picture }"
									alt="no pic">
								<div class="media-body">
									<h5 class="mt-0">
										<a href="javascript:detail(${c.id })" style="${styles.styles}">${c.title }</a>
									</h5>
									<p class="blog_item_footer">
										<span class="glyphicon glyphicon-user" title="作者"></span>
										作者：${c.username}&nbsp;&nbsp;&nbsp; 
										<span class="glyphicon glyphicon-time" title="发布时间"></span>
										发布：&nbsp;${c.updated }&nbsp;&nbsp;&nbsp;&nbsp;
									</p>
								</div>
							</div>
							<br />
						</c:forEach>
						
					</div>

				</c:if>

			</div>

			<div class="col-md-3">
				<div class="card">
					<div class="card-header">最新文章</div>
					<div class="card-body">
						<ol>
							<c:forEach items="${lasts}" var="article">
								<li class="text-truncate"><a href="/article/${article.id}">${article.title}</a></li>
							</c:forEach>
						</ol>
					</div>
				</div>
				<div class="card">
					<div class="card-header">精品图片集</div>
					<div class="card-body">
						<c:forEach items="${pics }" var="p">
							<a href="javascript:getPic(${p.id })">
								<img alt="" src="/pic/${p.url }" width="50px" height="50px">
							</a>
						</c:forEach>
					</div>

						
					
				</div>

			</div>
		</div>
	</div>

	<br />

	<jsp:include page="/WEB-INF/view/common/footer.jsp" />

	<script type="text/javascript">
		//为左侧频道绑定点击事件
		$(function() {

		   //为栏目添加高亮的样式
		   $("#channel${article.channelId}").addClass('list-group-item-warning');
		   $("#cat${article.categoryId}").addClass('list-group-item-warning');


			//分页的点击事件

			$('.page-link').click(function(e) {

				//获取点击的的url
				var url = $(this).attr('data');
				// console.log(url);
				//在中间区域显示地址的内容
				$('#hot').load(url);
			});

		})
		//查看文章明细
		function detail(id) {

			//	 window.open("/getArticleDetail?id="+id);
			window.open("/article/get?id=" + id, "_blank")
		}
		//查看文章明细
		function getPic(id){
			window.open("/pics/select?id="+id,"_blank");
		}
	</script>
</body>
</html>