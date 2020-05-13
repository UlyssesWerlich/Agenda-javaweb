<%@ page import="app.Contato" %><%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 12/05/2020
  Time: 19:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Agenda</title>
    </head>
    <body>
        <h1>
            Alterar Contato
        </h1>

        <%
            Contato contato = (Contato) request.getAttribute("Contato");
        %>
        <form action="ContatoEdit" method="POST">
            <input type="hidden" value="<%= contato.getId() %>" name="id">
            <label for="nome">Nome*</label>
            <input type="text" value="<%= contato.getNome() %>" name="nome" id="nome" placeholder="digite seu nome completo">
            <br>

            <br>
            <label for="telefone">Telefone*</label>
            <input type="tel" value="<%= contato.getTelefone() %>" name="telefone" id="telefone" placeholder="digite seu telefone">
            <br>

            <br>
            <label for="email">e-mail*</label>
            <input type="email" value="<%= contato.getEmail() %>" name="email" id="email" placeholder="digite seu e-mail">
            <br>
            <br>
            <input type="submit" value="Atualizar">
        </form>
        <form action="ContatoRemove" method="POST">
            <input type="hidden" value="<%= contato.getId() %>" name="id">
            <input type="submit" value="Remover">
        </form>

        <b/>
        <p><a href="/">Voltar</a></p>
    </body>
</html>
