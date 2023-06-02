<%@ page import="Beans.Tour" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaCanciones"/>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaCancionesXbanda"/>

<html>
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Lista de Tours"/>
</jsp:include>
<body>
<div class='container'>
  <jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value="tours"/>
  </jsp:include>
  <div class="pb-5 pt-4 px-3 titlecolor">
    <div class="col-lg-6">
      <%if(listaCancionesXbanda != null){%>
      <h1 class='text-light'>Lista de Canciones por banda</h1>
      <%}else{%>
      <h1 class='text-light'>Lista de Canciones</h1>
      <%}%>
    </div>
  </div>
  <div class="tabla">
    <table class="table table-dark table-transparent table-hover">
      <thead>
      <th>ID</th>
      <th>Cancion</th>
      <th>Banda</th>
      <th>Ver</th>
      </thead>
      <%
        for (Cancion cancion : listaCanciones) {
      %>
      <tr>
        <td><%=cancion.getIdCancion()%>
        </td>
        <td><%=cancion.getNombre_cancion()%>
        </td>
        <td><%=cancion.getBanda()%>
        </td>
        <td>
          <a class="nav-link" >Mas de la banda</a>
        </td>

      </tr>
      <%
        }
      %>
    </table>
  </div>

</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
