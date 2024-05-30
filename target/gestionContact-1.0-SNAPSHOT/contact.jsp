<%@ page import="com.mycontact.classe.Contact" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <title>Liste des contacts</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <div class="container">
        <h1>Ajouter un contact</h1>
        <form action="/addContact" method="post">
            <div class="mb-3">
                <label for="nom" class="form-label">Nom:</label>
                <input type="text" class="form-control" id="nom" name="nom" required>
            </div>
            <div class="mb-3">
                <label for="prenom" class="form-label">Prénom:</label>
                <input type="text" class="form-control" id="prenom" name="prenom" required>
            </div>
            <div class="mb-3">
                <label for="competence" class="form-label">Compétence:</label>
                <input type="text" class="form-control" id="competence" name="competence" required>
            </div>
            <button type="submit" class="btn btn-primary">Ajouter</button>
        </form>

        <h1>Liste des contacts</h1>
        <table class="table table-striped">
            <thead>
                <tr>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Compétence</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Contact> contacts = (List<Contact>) request.getAttribute("contacts");
                    if (contacts != null && !contacts.isEmpty()) {
                        for (Contact contact : contacts) {
                %>
                <tr>
                    <td><%= contact.getNom() %></td>
                    <td><%= contact.getPrenom() %></td>
                    <td><%= contact.getCompetence() %></td>
                    <td>
                        <form action="/editContact" method="post" style="display:inline;">
                            <input type="hidden" name="index" value="<%= contacts.indexOf(contact) %>" />
                            <button type="submit" class="btn btn-warning">Modifier</button>
                        </form>
                        <form action="/deleteContact" method="post" style="display:inline;">
                            <input type="hidden" name="index" value="<%= contacts.indexOf(contact) %>" />
                            <button type="submit" class="btn btn-danger">Supprimer</button>
                        </form>
                    </td>
                </tr>
                <%
                        }
                    } else {
                %>
                <tr>
                    <td colspan="4">Aucun contact à afficher.</td>
                </tr>
                <%
                    }
                %>
            </tbody>
        </table>
        <a href="index.jsp"><button class="btn btn-primary">Retour</button></a>
    </div>
</body>
</html>
