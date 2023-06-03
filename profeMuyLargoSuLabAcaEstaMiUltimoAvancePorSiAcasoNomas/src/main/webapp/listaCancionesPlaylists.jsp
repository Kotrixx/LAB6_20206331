<%@ page import="Beans.Tour" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.Cancion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:useBean type="java.util.ArrayList<Beans.Cancion>" scope="request" id="listaCancionesPlaylists"/>
<jsp:useBean type="java.util.ArrayList<Beans.ListaReproduccion>" scope="request" id="listaPlaylist"/>

<html>
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Playlists"/>
</jsp:include>
<body>
<div class='container'>
  <jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value="playlists"/>
  </jsp:include>
  <div class="pb-5 pt-4 px-3 titlecolor">
    <div class="col-lg-6">
      <h1 class='text-light'>Playlists <%=listaPlaylist.get(Integer.parseInt(request.getParameter("id"))-1).getNombre()%></h1>
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
        for (Cancion cancion : listaCancionesPlaylists) {
      %>
      <tr>
        <td><%=cancion.getIdCancion()%>
        </td>
        <td><%=cancion.getNombre_cancion()%>
        </td>
        <td><%=cancion.getBanda()%>
        </td>
        <td>
          <a class="btn btn-success" href="<%=request.getContextPath()%>/listaCanciones?idbanda=<%=cancion.getBanda()%>">Mas de la banda</a>
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
