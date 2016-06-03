<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingrese su comentario</title>
        <%@include file="/WEB-INF/jspf/_headercalls.jspf" %>
        <script type="text/javascript">
            function valorar(val){
                document.getElementById('valoracion').value=val;
                elementos=document.getElementsByName("val");
                for(i=0;i<elementos.length;i++)
                    if(i<(5-val))
                        elementos[i].innerHTML='☆';
                    else
                        elementos[i].innerHTML='★';
            }
        </script>
    </head>
    <body>
        <div style="color:blue;">Debug: hidden valoración:<input id="valoracion" type="text" readonly /></div>
        <table>
            <tr>
                <td>Valoración
                    <div class="rating">
                        <span name="val" onclick="valorar(5);">☆</span>
                        <span name="val" onclick="valorar(4);">☆</span>
                        <span name="val" onclick="valorar(3);">☆</span>
                        <span name="val" onclick="valorar(2);">☆</span>
                        <span name="val" onclick="valorar(1);">☆</span>
                    </div>
                </td>
                <td><input type='checkbox'id="norecibido"/>No recibí el producto </td>
                
            </tr>
            <tr>
                <td colspan='2'>Comentario:<textarea name="comentario"></textarea></td>
            </tr>
        
        </table>
    </body>
</html>
