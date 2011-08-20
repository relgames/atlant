<#-- @ftlroot "" -->
<#-- @ftlvariable name="experts" type="java.util.List<org.relgames.atlant.persistence.Expert>" -->
<#import "/spring.ftl" as spring />
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ru" lang="ru">
<head>
    <title>Топ экспертов</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<#list experts as expert>
    <table>
        <tr>
            <td><img src="${expert.imageUrl}" alt="${expert.name}"/></td>
            <td>${expert.id}</td>
            <td>${expert.name}</td>
            <td>${expert.votes}</td>
        </tr>
    </table>
</#list></body>
</html>
