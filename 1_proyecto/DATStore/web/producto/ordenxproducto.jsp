<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tienda Virtual DAT | Producto</title>
        
    </head>
    <body>
        <jsp:include page="/OrdenxProducto?accion=GET&idOrdenxProducto=${param.idOrdenxProducto}" />
        <div id="flujo">
            <div class="_1" style="float:left; width:20%; text-align: center;">
                <h3>Creado</h3>
                <h3>${ordenxProducto.fechaCreada}</h3>
            </div>
            <c:choose>
                <c:when test="${ordenxProducto.estado=='2' || ordenxProducto.estado=='3' || ordenxProducto.estado=='4' || ordenxProducto.estado=='N'}">
                    <div class="_2" style="float:left; width:20%; text-align: center;">
                        <h3>Aceptado</h3>
                        <h3>por el vendedor</h3>
                    </div>
                </c:when>
                <c:when test="${ordenxProducto.estado=='R'}">
                    <div class="_R" style="float:left; width:20%; text-align: center;">
                        <h3>Rechazado</h3>
                        <h3>por el vendedor</h3>
                    </div>
                </c:when>
                <c:when test="${ordenxProducto.estado=='X'}">
                    <div class="_X" style="float:left; width:20%; text-align: center;">
                        <h3>Anulado</h3>
                        <h3>${ordenxProducto.fechaAnulada}</h3>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="_NN" style="float:left; width:20%; text-align: center;">
                        <h3>Por Revisar</h3>
                        <h3>por el vendedor</h3>
                    </div>
                </c:otherwise>
            </c:choose>
            
            <c:choose>
                <c:when test="${ordenxProducto.estado=='3' || ordenxProducto.estado=='4' || ordenxProducto.estado=='N'}">
                    <div class="_3" style="float:left; width:20%; text-align: center;">
                        <h3>Enviado</h3>
                        <h3>${ordenxProducto.fechaEnviada}</h3>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="_NN" style="float:left; width:20%; text-align: center;">
                        <h3>No enviado</h3>
                        <h3>&nbsp;</h3>
                    </div>
                </c:otherwise>
            </c:choose>
            
            <c:choose>
                <c:when test="${ordenxProducto.estado=='4' || ordenxProducto.estado=='N'}">
                    <div class="_4" style="float:left; width:20%; text-align: center;">
                        <h3>Enviado</h3>
                        <h3>${ordenxProducto.fechaEntregada}</h3>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="_NN" style="float:left; width:20%; text-align: center;">
                        <h3>No entregado</h3>
                        <h3>&nbsp;</h3>
                    </div>
                </c:otherwise>
            </c:choose>


            <c:choose>
                <c:when test="${ordenxProducto.estado=='N'}">
                    <div class="_N" style="float:left; width:20%; text-align: center;">
                        <h3>No recibido</h3>
                        <h3>por el cliente</h3>
                    </div>
                </c:when>
                <c:otherwise>
                    <div class="_NN" style="float:left; width:20%; text-align: center;">
                        <h3>No hay quejas</h3>
                        <h3>del cliente</h3>
                    </div>
                </c:otherwise>
            </c:choose>

        </div>
        <div>
            <c:choose>
                <c:when test="${usuario.tipo=='vendedor' && ordenxProducto.estado=='1'}">
                    Comentario<textarea style="width:100%" id="comentario" >${ordenxProducto.comentario}</textarea>
                </c:when>
                <c:when test="${usuario.tipo=='cliente' && ordenxProducto.estado=='4'}">
                    <c:choose>
                        <c:when test="${ordenxProducto.valoracion>0}">
                            <c:set var="valoracion" value="${5-ordenxProducto.valoracion}"/>
                        </c:when>
                        <c:otherwise>
                            <c:set var="valoracion" value="${5}"/>
                        </c:otherwise>
                    </c:choose>
                    Valoración:
                    <div class="rating">
                        <c:forEach begin="1" end="5" var="i">
                            <c:choose>
                                <c:when test="${i<=valoracion}">
                                    <span name="val" onclick="valorar(${6-i});">☆</span>
                                </c:when>
                                <c:otherwise>
                                    <span name="val" onclick="valorar(${6-i});">★</span>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                    </div>
                    Comentario<textarea style="width:100%" id="comentario" >${ordenxProducto.comentario}</textarea>
                    <input id="valoracion" type="hidden" value="0" />
                </c:when>
                <c:otherwise>
                    <c:if test="${ordenxProducto.valoracion>0}">
                        <c:set var="valoracion" value="${5-ordenxProducto.valoracion}"/>
                        Valoración:
                        <div class="rating1">
                            <c:forEach begin="1" end="5" var="i">
                                <c:choose>
                                    <c:when test="${i<=valoracion}">
                                        <span>☆</span>
                                    </c:when>
                                    <c:otherwise>
                                        <span>★</span>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </div>
                    </c:if>
                    <c:if test="${not empty ordenxProducto.comentario}">
                        Comentario<textarea style="width:100%" readonly >${ordenxProducto.comentario}</textarea>
                    </c:if>
                </c:otherwise>
            </c:choose>
                            
            
        </div>
        <div name="botones">
            <c:choose>
                <c:when test="${usuario.tipo=='vendedor'}">
                    <c:choose>
                        <c:when test="${ordenxProducto.estado=='1'}">
                            <button class="cssbutton greyright" onclick="cambiarEstado('${ordenxProducto.idOrdenxProducto}','2','','')">
                                Aceptar orden
                            </button>
                            <button class="cssbutton redright" onclick="cambiarEstado('${ordenxProducto.idOrdenxProducto}','R','',$('#comentario').val())">
                                Rechazar orden
                            </button>
                        </c:when>
                        <c:when test="${ordenxProducto.estado=='2'}">
                            <button class="cssbutton greyright" onclick="cambiarEstado('${ordenxProducto.idOrdenxProducto}','3','','')">
                                Cambiar Orden a Enviada
                            </button>
                        </c:when>
                        <c:when test="${ordenxProducto.estado=='3'}">
                            <button class="cssbutton greyright" onclick="cambiarEstado('${ordenxProducto.idOrdenxProducto}','4','','')">
                                Cambiar Orden a Entregada
                            </button>
                        </c:when>
                        <c:when test="${ordenxProducto.estado=='4'}"></c:when>
                        <c:when test="${ordenxProducto.estado=='X'}"></c:when>
                        <c:when test="${ordenxProducto.estado=='R'}"></c:when>
                        <c:when test="${ordenxProducto.estado=='N'}"></c:when>
                    </c:choose>
                </c:when>
                <c:when test="${usuario.tipo=='cliente'}">
                    <c:choose>
                        <c:when test="${ordenxProducto.estado=='1'}">
                            <button class="cssbutton greyright" onclick="cambiarEstado('${ordenxProducto.idOrdenxProducto}','X','','')">
                                Anular producto
                            </button>
                        </c:when>
                        <c:when test="${ordenxProducto.estado=='2'}">
                            <button class="cssbutton greyright" onclick="cambiarEstado('${ordenxProducto.idOrdenxProducto}','X','','')">
                                Anular producto
                            </button>
                        </c:when>
                        <c:when test="${ordenxProducto.estado=='3'}"></c:when>
                        <c:when test="${ordenxProducto.estado=='4'}">
                            <button class="cssbutton greyright" onclick="cambiarEstado('${ordenxProducto.idOrdenxProducto}','4',$('#valoracion').val(),$('#comentario').val())">
                                Registrar Comentario
                            </button>
                            <button class="cssbutton redright" onclick="cambiarEstado('${ordenxProducto.idOrdenxProducto}','N',$('#valoracion').val(),$('#comentario').val())">
                                No recibí el pedido
                            </button>
                        </c:when>
                        <c:when test="${ordenxProducto.estado=='R'}"></c:when>
                        <c:when test="${ordenxProducto.estado=='X'}"></c:when>
                        <c:when test="${ordenxProducto.estado=='N'}"></c:when>
                    </c:choose>
                </c:when>
            </c:choose>
        </div>
        <div id="msg" style="width:100%"></div>
    </body>
</html>
