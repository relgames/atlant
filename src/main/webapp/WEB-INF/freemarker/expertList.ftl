<#-- @ftlvariable name="lastUpdate" type="java.util.Date" -->
<#-- @ftlvariable name="experts" type="java.util.List<org.relgames.atlant.persistence.Expert>" -->
<#setting time_zone="Europe/Amsterdam">
<#import "/spring.ftl" as spring />
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="ru" lang="ru">
<head>
    <title>Топ экспертов</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
<p>Таблица обновляется раз в полчаса. Последнее обновление: ${lastUpdate?datetime} (время Амстердама, GMT+1)</p>

<table>
    <thead>
        <tr><td>Место</td><td>Фото</td><td>Имя</td><td>Голоса</td><td>;)</td></tr>
    </thead>
    <#list experts as expert>
    <tr>
        <td>${expert_index+1}</td>
        <td><img src="${expert.imageUrl}" alt="${expert.name}"/></td>
        <td>${expert.name}</td>
        <td>${expert.votes}</td>
        <td><a href="http://tut.by/questionary/scripts/helper.php?cmd=vote&questionaryId=2&scheduleId=3&questionId=${expert.id}&value=1">Голосовать</a></td>
    </tr>
    </#list>
    </table>
</body>
</html>
