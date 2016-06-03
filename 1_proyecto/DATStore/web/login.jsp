<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>Tienda Virtual DAT | Login</title>
<%@include file="WEB-INF/jspf/_headercalls.jspf" %>
<!-- start menu -->
<link href="css/megamenu.css" rel="stylesheet" type="text/css" media="all" />
<script type="text/javascript" src="js/megamenu.js"></script>
<script>$(document).ready(function(){$(".megamenu").megamenu();});</script>
<!-- dropdown -->
<script src="js/jquery.easydropdown.js"></script>
<script>
    $(function(){
        $("#btnlogin").click(function() {
            login();
        });
    });
    
    function login(){
        $.ajax({
            url:"Autenticar?accion=login",
            data: {
                correo:$("#correo").val(),
                pass: $("#pass").val()
            },
            type:'GET',
            success:function(data)
            {
                if (data==="OK")
                    window.location.href = "Autenticar?accion=redirecthome";
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

    <div class="login">
        <div class="wrap">
            
            <div class="col_1_of_login span_1_of_login">
                <h4 class="title">Nuevo Usuario</h4>
                <p>¿No tiene una cuenta aún? Puede crear una nueva cuenta llenando un simple formulario. Una vez registrado, podrá utilizar nuestros servicios de compra y venta de productos<br/><br/><br/></p>
                
                <div class="button1">
                    <a href="cuenta.jsp"><input type="submit" name="Submit" value="Crear una cuenta"></a>
                </div>
                <div class="clear"></div>
            </div>
            <div class="col_1_of_login span_1_of_login">
                <div class="login-title">
                    <h4 class="title">Usuarios Registrados</h4>
                    <div id="msg"><c:if test="${not empty msgLogin}">${msgLogin}<c:remove var="msgLogin"/></c:if></div>
                    <div id="loginbox" class="loginbox">
                        <div name="login" id="login-form">
                            <div class="input">
                                <p id="login-form-username">
                                    <label for="correo">Email</label>
                                    <input id="correo" type="text" name="email" class="inputbox" size="18" autocomplete="off">
                                </p>
                                <p id="login-form-password">
                                    <label for="pass">Contraseña</label>
                                    <input id="pass" type="password" name="password" class="inputbox" size="18" autocomplete="off">
                                </p>
                                <div class="button1">
                                    <button name="Submit" id="btnlogin">Entrar</button>
                                </div>
                                <div class="clear"></div>
                            </div>
                        </div>
                        
                    </div>
                </div>
            </div>
            <div class="clear"></div>
        </div>
    </div>
        <!-- Pie de página -->
        <%@include file="WEB-INF/jspf/footer.jspf" %>
</body>
</html>

