<%@ page import="Beans.Tour" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Beans.Cancion" %>
<%@ page import="java.util.List" %>
<%@ page import="Beans.ListaReproduccion" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:useBean type="java.util.ArrayList<Beans.ListaReproduccion>" scope="request" id="listaPlaylist"/>

<html>
<jsp:include page="/static/head.jsp">
  <jsp:param name="title" value="Lista de Tours"/>
</jsp:include>
<body>
<div class='container'>
  <jsp:include page="/includes/navbar.jsp">
    <jsp:param name="page" value="playlist"/>
  </jsp:include>
  <div class="pb-5 pt-4 px-3 titlecolor">
    <div class="col-lg-6">
      <h1 class='text-light'>Nueva Playlist</h1>
    </div>
  </div>
  <div class="tabla">
    <table class="table table-dark table-transparent table-hover">
      <thead>
      <th>#Nro</th>
      <th>Playlists</th>
      <th></th>
      <th></th>
      </thead>


      <tr>
        <form method="POST" action="<%=request.getContextPath()%>/Playlists">
          <div class="mb-3">
            <label class='text-light'  for="nombre">Nombre Playlist</label>
            <input type="text" class="form-control" name="jobTitle" id="nombre">
          </div>
          <a class="btn btn-danger" href="<%=request.getContextPath()%>/Playlists">Cancelar</a>
          <button type="submit" class="btn btn-primary">Crear</button>
        </form>
      </tr>



    </table>
  </div>

</div>
<jsp:include page="/static/scripts.jsp"/>
</body>
</html>
