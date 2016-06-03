<!DOCTYPE HTML>
<%@ page pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="cont span_2_of_3">
    <c:choose>
        <c:when test="${not empty busquedaProducto.subcategoria}">
            <h2 class="head">Subcategoría ${busquedaProducto.subcategoria}</h2>
        </c:when>
        <c:when test="${not empty busquedaProducto.categoria}">
            <h2 class="head">Categoría ${busquedaProducto.categoria}</h2>
        </c:when>
        <c:when test="${not empty busquedaProducto.busqueda}">
            <h2 class="head">Búsqueda: ${busquedaProducto.busqueda}</h2>
        </c:when>
        <c:otherwise>
            <h2 class="head">Todos los Productos</h2>
        </c:otherwise>
    </c:choose>
    <div class="mens-toolbar">
        <div class="sort">
            <div class="sort-by">
                <label>Ordenar por:</label>
                <select id="orden" name="orden" onchange="buscar('orden='+this.value);" >
                    <option value="posicion" <c:if test="${busquedaProducto.orden == 'posicion'}">selected</c:if>>Posición</option>
                    <option value="nombre" <c:if test="${busquedaProducto.orden=='nombre'}">selected</c:if>>Nombre</option>
                    <option value="precio" <c:if test="${busquedaProducto.orden=='precio'}">selected</c:if>>Precio</option>
                </select>
                <img style="cursor: pointer;" onclick="buscar('asc=${!busquedaProducto.asc}');"
                    <c:if test="${busquedaProducto.asc}">src="images/arrow2.gif"</c:if>
                    <c:if test="${!busquedaProducto.asc}">src="images/down-arrow2.gif"</c:if>
                        alt="" class="v-middle">
            </div>
        </div>
        <div class="pager">   
            <ul class="dc_pagination dc_paginationA dc_paginationA06">
                <li><a href="#" class="previous">Página</a></li>
                <c:forEach var="i" begin="1" end="${busquedaProducto.nroPaginas}">
                    <c:choose>
                        <c:when test="${i==busquedaProducto.pagina}">
                            <li>${i}</li>
                        </c:when>
                        <c:when test="${i!=busquedaProducto.pagina}">
                            <li><a href="javascript:void(0)" onclick="buscar('pagina=${i}');">${i}</a></li>
                        </c:when>
                    </c:choose>
                    
                </c:forEach>
            </ul>
            <div class="clear"></div>
        </div>
        <div class="clear"></div>
    </div>

    <c:set var="i" value="0" />
    <c:forEach items="${busquedaProducto.productos}" var="producto" varStatus="loop">
        <c:if test="${i==0}">
            <div class="top-box1">
        </c:if>
                <div class="col_1_of_3 span_1_of_3"> 
                    <a href="producto.jsp?idProducto=${producto.idProducto}">
                        <div class="inner_content clearfix">
                            <div class="product_image">
                                <img src="${producto.imagen}" alt=""/>
                            </div>
                            <div class="price">
                                <div class="cart-left">
                                    <p class="title">${producto.nombre}&nbsp;</p>
                                    <div class="price1">
                                        <span class="actual">S/.${producto.precio}</span>
                                    </div>
                                </div>
                                <div class="cart-right"> </div>
                                <div class="clear"></div>
                            </div>				
                        </div>
                    </a>
                </div>
        <c:if test="${(i==2) || (loop.last)}">
            </div>
        </c:if>
        <c:set var="i" value="${(i + 1)%3}" />
    </c:forEach>

</div>