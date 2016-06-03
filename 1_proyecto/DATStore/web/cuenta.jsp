<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Tienda Virtual DAT | Registro</title>
<%@include file="WEB-INF/jspf/_headercalls.jspf" %>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<script src="js/jquery.easydropdown.js"></script>
<script>
    target="";
    <c:if test="${usuario==null}">
    $(function(){
        $("#btncliente").click(function() {
            target="index.jsp";
            $("#tipo").val("cliente");
            grabar();
        });
        $("#btnvendedor").click(function() {
            target="vendedor/index.jsp";
            $("#tipo").val("vendedor");
            grabar();
        });
    });
    </c:if>
    <c:if test="${usuario!=null}">
    $(function(){
        $("#btnguardar").click(function() {
            target="Autenticar?accion=redirecthome";
            grabar();
        });
    });
    </c:if>
    
    function grabar(){
        $.ajax({
    <c:if test="${usuario==null}">
            url:"Usuario?accion=INS",
    </c:if>
    <c:if test="${usuario!=null}">
            url:"Usuario?accion=UPD",
    </c:if>
            data: {
                idUsuario:$("#idUsuario").val(),
                nombre:($("#nombre").val()=="Nombre")?"":$("#nombre").val(),
                apellido:($("#apellido").val()=="Apellido")?"":$("#apellido").val(),
                correo:($("#correo").val()=="E-Mail")?"":$("#correo").val(),
                pass: $("#pass").val(),
                pass2: $("#pass2").val(),
                tipo: $("#tipo").val(),
                estado: 'A'
            },
            type:'POST',
            success:function(data)
            {
                if (data==="OK")
                    window.location.href = target;
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
    <%@include file="WEB-INF/jspf/headmenu.jspf" %>
    
    <!-- Logo, busqueda y menu de categorías -->
    <%@include file="WEB-INF/jspf/headbottom.jspf" %>
    
    <div class="register_account">
        <div class="wrap">
        <c:if test="${usuario==null}">
            <h4 class="title">Crear una cuenta</h4>
        </c:if>
        <c:if test="${usuario!=null}">
            <h4 class="title">Modificar su cuenta</h4>
        </c:if>
            
            <div id="msg"></div>
                <form>
                    <div class="col_1_of_2 span_1_of_2">
                        <div><input id="nombre" type="text" <c:if test="${usuario==null}">value="Nombre"</c:if><c:if test="${usuario!=null}">value="${usuario.nombre}"</c:if>
                                    onfocus="if (this.value == 'Nombre') {this.value = '';}" onblur="if (this.value == '') {this.value = 'Nombre';}"></div>
                        <div><input id="apellido" type="text" <c:if test="${usuario==null}">value="Apellido"</c:if><c:if test="${usuario!=null}">value="${usuario.apellido}"</c:if>
                                    onfocus="if (this.value == 'Apellido') {this.value = '';}" onblur="if (this.value == '') {this.value = 'Apellido';}"></div>
                        <div><input id="correo" type="text" <c:if test="${usuario==null}">value="E-Mail"</c:if><c:if test="${usuario!=null}">value="${usuario.correo}"</c:if>
                                    onfocus="if (this.value == 'E-Mail') {this.value = '';}" onblur="if (this.value == '') {this.value = 'E-Mail';}"></div>
                    </div>
                    <div class="col_1_of_2 span_1_of_2">	
                        
                        <div class="xlabel" onclick='document.getElementById("pass").focus();'>
                            <table style="width:100%; table-layout: fixed;">
                                <tr><td style="width:125px;">Pasword: </td><td><input id="pass" style="width:100%;border: 0px solid;" type="password" value=""></td></tr>
                            </table>
                            
                        </div>
                        <div class="xlabel" onclick='document.getElementById("pass2").focus();'>
                            <table style="width:100%; table-layout: fixed;">
                                <tr><td style="width:125px;">Repetir Pasword: </td><td><input id="pass2" style="width:100%;border: 0px solid;" type="password" value=""></td></tr>
                            </table>
                            
                        </div>
                            <div style="color:#FFF;">_<input type="hidden" id="tipo" <c:if test="${usuario==null}">value=""</c:if><c:if test="${usuario!=null}">value="${usuario.tipo}"</c:if> /></div>
                        <div style="color:#FFF;">_<input type="hidden" id="idUsuario" <c:if test="${usuario==null}">value=""</c:if><c:if test="${usuario!=null}">value="${usuario.idUsuario}"</c:if> /></div>
                        <div style="color:#FFF;">_</div>
                        <div style="color:#FFF;">_</div>
                    </div>

              </form>
            <c:if test="${usuario==null}">
                <button id="btncliente" class="grey">Crear Cuenta de Cliente</button>
                <button id="btnvendedor" class="grey">Crear Cuenta de Vendedor</button>
            </c:if>
            <c:if test="${usuario!=null}">
                <button id="btnguardar" class="grey">Guardar</button>
            </c:if>
                
              <div class="clear"></div>
    </div>
    </div>
        <!-- Pie de página -->
        <%@include file="WEB-INF/jspf/footer.jspf" %>
</body>
</html>