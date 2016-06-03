<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Tienda Virtual DAT | Registro</title>
<%@include file="/WEB-INF/jspf/_headercalls.jspf" %>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script type="text/javascript" src="js/operacionescarrito.js"></script> 
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/jquery.easydropdown.js"></script>
</head>
<body> 
    <!-- Menú de la parte superior -->
    <%@include file="/WEB-INF/jspf/headmenu.jspf" %>
    
    <!-- Logo, busqueda y menu de categorías -->
    <%@include file="/WEB-INF/jspf/headbottom.jspf" %>
    
   <jsp:include page="Carrito?accion=singleprod&idProducto=${param.idProducto}" />
   
<div class="mens">    
    <div class="main">
        <div class="wrap">
            <c:forEach items="${categorias}" var="cat" >
                <c:forEach items="${cat.subcategorias}" var="subcat">
                    <c:if test="${subcat.idSubcategoria==producto.idSubcategoria}">
                        <ul class="breadcrumb breadcrumb__t"><a class="home" href="index.jsp">Inicio</a> / 
                            <a href="index.jsp?idCategoria=${cat.idCategoria}">${cat.descripcion}</a> / 
                            <a href="index.jsp?idSubcategoria=${subcat.idSubcategoria}">${subcat.descripcion}</a> / 
                            ${producto.nombre}</ul>
                    </c:if>
                </c:forEach>
            </c:forEach>
            <div class="cont span_2_of_3">
                <div class="grid images_3_of_2">
                    <div id="container">
                        <img src="${producto.imagen}" />
                    </div>
                </div>
                <div class="desc1 span_3_of_2">
                    <h3 class="m_3">${producto.nombre}</h3>
                    <p class="m_5">${producto.precio}</p>
                    <div class="btn_form">
                        <form>
                            <input type="submit" value="Agregar al Carrito" title="">
                        </form>
                    </div>
                    <p class="m_text2">${producto.descripcion}</p>
                </div>
                <div class="clear"></div>	
                <div class="toogle">
                   <h3 class="m_3">
                   
                       ${producto.idProducto}<br/>
        ${producto.idVendedor}<br/>
      ${producto.idSubcategoria}<br/>
        ${producto.nombre}<br/>
        ${producto.descripcion}<br/>
        ${producto.precio}<br/>
         ${producto.imagen}<br/>
         ${producto.stock}<br/>
         ${producto.vendidas}<br/>
         ${producto.marca}<br/>
         ${producto.modelo}<br/>
          ${producto.estado}<br/>
                   
                   </h3>
                   <p class="m_text">En construcción</p>
                </div>
                <div class="toogle">
                    <h3 class="m_3">Mas Información</h3>
                    <p class="m_text">En construcción.</p>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
     <table style="margin: auto;">
             <tr>
                <td>idProducto</td>
                 <td>nombre</td>
                <td>marca</td>
                <td>modelo </td>
                <td>cantidad</td>
                  <td>............</td>
              </tr>
                      
                <tr id="1">
                    
                 <td>${producto.idProducto}</td>
                <td>${producto.nombre}</td>
                <td>${producto.marca}</td>
                <td> ${producto.modelo}</td>
                 <td> <select name="cant" id="cant" >
                       
                          <option value="1">1</option>
                          <option value="2">2</option>
                          <option value="3">3</option>
                          <option value="4">4</option>
                          <option value="5">5</option>
                          <option value="6">6</option>
                          <option value="7">7</option>
                          <option value="8">8</option>
                          <option value="9">9</option>
                          <option value="10">10</option>
                      </select>
                 </td>
              
                
                   <td> ${producto.precio}</td>
                <td> <a href="" onclick="javascript:agregar('${producto.idProducto}','${producto.nombre}');">COMPRAR</a></td>
                </tr>
                 
               
                 
            
                 <tr><td colspan="3"><a href="carrito.jsp">IR AL CARRITO</a></td></tr>
              </table>
  
        <!-- Pie de página -->
        <%@include file="/WEB-INF/jspf/footer.jspf" %>
</body>
</html>