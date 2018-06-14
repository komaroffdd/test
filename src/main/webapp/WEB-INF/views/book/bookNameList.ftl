<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<form name="bookName" action="/book/bookNameList/${book.bookName}" method="get">
    <input title="bookName" type="text">
</form>
<h1>Books list</h1>
<table>
    <tr>
        <td>Book title|</td>
        <td>Author id|</td>
        <td>Genre id|</td>
        <td>Publisher|</td>
        <td>Year|</td>
        <td>City|</td>
    </tr>
<#list bookName as book>
    <tr>
        <td>${book.id}</td>
        <td>${book.bookName}|</td>
        <td><a href="/author/${book.author_id}"></a>${book.author_id}</a></td>
        <td>|${book.genre_id}|</td>
        <td>${book.publisher}|</td>
        <td>${book.year}|</td>
        <td>${book.city}|</td>
    </tr>

</#list>
</table>
<a href="/book/list">List Book</a>
<br/>
<a href="/">Start page</a></body>
</body>
</html>
