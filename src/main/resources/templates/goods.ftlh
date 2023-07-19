<!DOCTYPE html>
<html>
<head>
    <title>Shop</title>
</head>
<body>
<h1>Goods</h1>
<hr>
<#list goods as good>
<div><p><b>${good.title}</b>${good.price} |  <a href="/goods/${good.id}">MoreInf</a></p>
</div>
</#list>
<hr>
<h3>Сoздать новый товар</h3>
<form action="/goods/create" method="post">
Название товара<input type="text" name="title"/><br></br>
Описание<input type="text" name="description"/><br></br>
Цена<input type="number" name="price"/><br></br>
Город<input type="text" name="city"/><br></br>
Продавец<input type="text" name="owner"/><br></br>
<input type="submit" value="Add product">
</form>
</body>
</html>