<%@ page import="com.mycontact.classe.Contact" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Edit Contact</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Modifier Contact</h1>
        <form action="/updateContact" method="post">
            <input type="hidden" name="index" value="${index}" />
            <div class="mb-3">
                <label for="nom" class="form-label">Nom:</label>
                <input type="text" class="form-control" id="nom" name="nom" value="${contact.nom}" required>
            </div>
            <div class="mb-3">
                <label for="prenom" class="form-label">Prénom:</label>
                <input type="text" class="form-control" id="prenom" name="prenom" value="${contact.prenom}" required>
            </div>
            <div class="mb-3">
                <label for="competence" class="form-label">Compétence:</label>
                <input type="text" class="form-control" id="competence" name="competence" value="${contact.competence}" required>
            </div>
            <button type="submit" class="btn btn-primary">Modifier</button>
        </form>
            <br>
        <a href="contacts"><button class="btn btn-secondary">Retour à la Liste</button></a>
    </div>
</body>
</html>
