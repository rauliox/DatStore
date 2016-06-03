<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Tienda Virtual DAT | Producto</title>
<%@include file="/WEB-INF/jspf/_headercalls.jspf" %>
<!-- start menu --> 
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/jquery.easydropdown.js"></script>
<script type="text/javascript">
    $(function(){
        $("#btnRegistro").click(function() {
            guardar();
        });
    });
    
    function guardar(){
        $.ajax({
            url:'Producto',
            data: $('#form_producto').serialize(),
            type:'POST',
            success:function(data)
            {
                if (data==="OK")
                    window.location.href = "vendedor/productos.jsp";
                else $("#msg").html(data);
            },
            error: function (xhr, ajaxOptions, thrownError) {
                $("#msg").html(xhr.status+"<br/>"+thrownError);
            }
        });
    }
</script>
</head>
    <body>
    <!-- Menú de la parte superior -->
    <%@include file="/WEB-INF/jspf/headmenu.jspf" %>
    
    <!-- Logo, busqueda y menu de categorías -->
    <%@include file="/WEB-INF/jspf/headbottom.jspf" %>
    
    <div class="register_account">
        <div class="wrap">
            <c:choose>
                <c:when test="${codigo != null}">
                    <h4 class="title">Modificar producto</h4>
                </c:when>
                <c:otherwise>
                    <h4 class="title">Crear un producto</h4>
                </c:otherwise>
            </c:choose>
   
            <c:set var="codigo" value="${producto.idProducto}" />
            <div id="msg"></div>
            <form id="form_producto" action="Producto" method="post">
                <c:choose>
                    <c:when test="${codigo != null}">
                        <input type="hidden" value="UPD" name="accion" />
                        <input type="hidden" value="${codigo}" name="codigo" />
                    </c:when>
                    <c:otherwise>
                        <input type="hidden" value="INS" name="accion" />
                    </c:otherwise>
                </c:choose>        
            <!--<input type="hidden" name="accion" value="nuevoProducto"/>-->
            

            <!--<div id="caja" style="margin: auto; width: 200px" >               -->
                <div class="col_1_of_2 span_1_of_2" style="width:45%">
                    <div>Categoría
                            <select style="width:100%" name="categoria" id="categoria">
                                    <option value="sel">Seleccionar</option>
                                    <c:forEach items="${listaCategoria}" var="categoria" >
                                        <option <c:if test="${producto.idSubcategoria.equals(categoria.idSubCategoria)}">selected</c:if> value="${categoria.idSubCategoria}">${categoria.descripcion}</option>
                                    </c:forEach>
                            </select></div>

                    <div>Nombre<input style="width: 100%"  type="text" name="nombre" id="nombre" value="${producto.nombre}" /></div>
                    <div>Marca<input style="width: 100%" type="text" name="marca" id="marca" value="${producto.marca}"/></div>
                    <div>Modelo<input style="width: 100%" type="text" name="modelo" id="modelo" value="${producto.modelo}" /></div>
                        
                </div>
                <div class="col_1_of_2 span_1_of_2" style="width:45%; padding-left:30px;">
                    <div>URL imagen<input style="width: 100%" type="text" name="imagen" id="imagen" value="${producto.imagen}" /></div>
                    <div>Precio<input style="width: 100%" type="text" name="precio" id="precio" value="${producto.precio}" /></div>
                    <div>Stock<input style="width: 100%" type="text" name="stock" id="stock"  value="${producto.stock}" /></div>
                    <c:if test="${not empty producto}">
                        <input type="hidden" name="vendidas" id="vendidas"  value="${producto.vendidas}" />
                    </c:if>
                    <c:if test="${empty producto}">
                        <input type="hidden" name="vendidas" id="vendidas"  value="0" />
                    </c:if>
                    
                    <div>Descripción<textarea style="width: 100%" name="descripcion" id="descripcion">${producto.descripcion}</textarea></div>
                </div>
            </form>
            <div class="button1" style="margin-top:0px;margin-right:40px;">
                <button id="btnRegistro" name="Submit">Registrar</button>
            </div>
            
        </div>
    </div>
    </body>
</html>
