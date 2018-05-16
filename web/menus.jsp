<%-- 
    Document   : menu
    Created on : 20/11/2012, 08:04:48
    Author     : Heleno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Menu</title>
    </head>
    <body>
        <c:if test="${tipo == 'Secretaria'}">
            <a href="PesquisarCursoController">Manter Cursos</a> </br>
            <a href="PesquisarDisciplinaController?filtro=0">Manter Disciplinas</a> </br>
            <a href="PesquisarProfessorController">Manter Professores</a> </br>
            <a href="PesquisarAlunoController">Manter Alunos</a> </br>
            <a href="PesquisarTurmaController">Manter Turmas</a><br/>
        </c:if>
        ---<br/>
        <c:if test="${tipo == 'Aluno'}">
            <a href="PesquisarMatrizCurricularController?acao=prepararOperacao">Consultar Matriz Curricular</a> <br />
            <a href="PesquisarProfessorPorCursoController?acao=prepararOperacao"> Consultar Professores Vinculados a cada Curso</a> <br />
            <a href="PesquisarNotaFrequenciaController?acao=prepararOperacao"> Manter Nota e Frequência</a> <br />
            <a href="ConsultarNotaFrequenciaController?acao=prepararOperacao"> Calcular Resultado de Rendimento do Aluno</a> <br />
        </c:if>
        <c:if test="${tipo == 'Professor'}">
        --- Relatórios ---<br/>
            <a href="ReatorioCursosController?acao=prepararOperacao">Relatório de Cursos</a></br>
            <a href="RelatorioProfessorController?acao=prepararOperacao">Relatório de Professores Por Titulação</a></br>
            <a href="RelatorioDisciplinaPorCursoController?acao=prepararOperacao">Relatório de Disciplina Por Cursos</a></br>
            <a href="RelatorioAlunoAnoSemestreController?acao=prepararOperacao">Relatório de Aluno Ano/Semestre</a></br>
            <a href="RelatorioDiarioDeClasseController?acao=prepararOperacao">Diário de Classe</a></br>
            <a href="ReatorioHistoricoAlunoController?acao=prepararOperacao">Historico</a></br>
        </c:if>
    </body>
</html>
