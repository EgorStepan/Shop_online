<!DOCTYPE html>
<html>
<head>
    <title>Shop</title>
</head>
<body>
<h1>Goods Info</h1>
<b>Название товара: </b>${goods.title}<br>
<b>Описание: </b>${goods.description}<br>
<b>Цена: </b>${goods.price}<br>
<b>Город: </b>${goods.city}<br>
<b>Продавец: </b>${goods.owner}<br>
<b>Id: </b>${goods.id}<br>
<hr>
<form action="/goods/delete/${goods.id}" method="post">
<input type="submit" value="Delete product">
</form>
</body>
</html>