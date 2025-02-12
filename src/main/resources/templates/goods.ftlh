<@pageVisit pageName="home2" />
<!DOCTYPE html>
<html>
<head>
    <title>Shop</title>
</head>
<body>
<h1>Goods</h1><hr>
<#if user.email??>
<h3>Користувач: ${user.name}</h3>
<form action="/logout" method="post">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <input type="submit" value="Вийти"/><br>
</form>
<#else>
    <a href="/login">Увійти</a>
</#if>

<form action="/" method="get">
    Searching by title: <input type="text" name="title"><br>
    <input type="submit" value="Searching"/>

</form>
<hr>
<#list goods as good>
<div><p><b>${good.title}</b>${good.price} |  <a href="/goods/${good.id}">MoreInf</a></p>
</div>
<#else>
<h3>The list is empty</h3>

</#list>
<#if user.email??>
    <hr>
    <h3>Створити новий товар</h3>
    <form action="/goods/create" method="post" enctype="multipart/form-data">
        Назва товару: <input type="text" name="title" /><br />
        Опис: <input type="text" name="description" /><br />
        Ціна: <input type="number" name="price" /><br />
        Місто: <input type="text" name="city" /><br />
        Продавець: <input type="text" name="owner" /><br />

        <div id="file-inputs">
            <input type="file" name="files[]" class="file-input" /><br />
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Додати товар" />
    </form>

    <script>
        document.addEventListener('change', function(event) {
            if (event.target.classList.contains('file-input')) {
                if (event.target.files.length > 0) {
                    // Проверяем, есть ли уже пустое поле
                    const inputs = document.querySelectorAll('.file-input');
                    const lastInput = inputs[inputs.length - 1];
                    if (lastInput.value) {
                        // Создаем новое поле
                        const newInput = document.createElement('input');
                        newInput.type = 'file';
                        newInput.name = 'files[]';
                        newInput.classList.add('file-input');
                        document.getElementById('file-inputs').appendChild(newInput);
                        document.getElementById('file-inputs').appendChild(document.createElement('br'));
                    }
                }
            }
        });
    </script>
</#if>
</body>
</html>