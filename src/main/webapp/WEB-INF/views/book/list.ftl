<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>Authors list</h1>
<table>
    <tr>
        <td>Book title</td>
        <td>Author</td>
        <td>Genre</td>
        <td>Publisher</td>
        <td>Year</td>
        <td>City</td>
    </tr>
<#list books as book>
    <tr>
        <td>${book.bookName}</td>
        <td><a href="/author/${book.author_id}"></a>${book.author_id}</a></td> // сделать ссылку на автора
        <td>${book.genre_id}</td>
        <td>${book.publisher}</td>
        <td>${book.year}</td>
        <td>${book.city}</td>
        <td><a href="/book/delete/${book.id}">Delete</a></td>//добавить метод в контроллер
        <td><a href="/book/update/${book.id}">Update</a></td>//добавить метод в контроллер
    </tr>

</#list>
</table>
<a href="/book/add">Create Book</a>
<a href="/">Start page</a></body>
</html>