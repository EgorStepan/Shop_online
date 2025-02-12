<!DOCTYPE html>
<html>
<head>
    <title>Shop</title>
</head>
<body>
<h1>Goods Info</h1>
<#list images as img>
<img src="/image/${img.id}" height="60px"/><br><br>
</#list>
<b>Назва товару: </b>${goods.title}<br>
<b>Опис: </b>${goods.description}<br>
<b>Ціна: </b>${goods.price}<br>
<b>Місто: </b>${goods.city}<br>
<b>Продавець: </b>${goods.user.name}<br>
<b>Id: </b>${goods.id}<br>
<hr>
<form action="/goods/delete/${goods.id}" method="post">
<input type="hidden" name="_csrf" value="${_csrf.token}">
<input type="submit" value="Видалити товар">
</form>
</body>
</html>