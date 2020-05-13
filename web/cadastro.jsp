<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 12/05/2020
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Agenda</title>
    </head>
    <body>
        <h1>
            Novo Contato
        </h1>
        <form action="ContatoAdd" method="POST">
            <label for="nome">Nome*</label>
            <input type="text" name="nome" id="nome" placeholder="digite seu nome completo">
            <br>

            <br>
            <label for="telefone">Telefone*</label>
            <input type="tel" name="telefone" id="telefone" placeholder="digite seu telefone">
            <br>

            <br>
            <label for="email">E-mail*</label>
            <input type="email" name="email" id="email" placeholder="digite seu e-mail">
            <br>

            <br>
            <input type="submit" value="Cadastrar">
        </form>
        <b/>
        <p><a href="/">Voltar</a></p>
    </body>
</html>
