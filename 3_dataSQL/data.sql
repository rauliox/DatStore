#Insercion Tabla: Estado,Categoria, sub categoria



INSERT INTO `dat`.`Estado` (`estado`, `descripcion`) VALUES ('1', 'Creada');
INSERT INTO `dat`.`Estado` (`estado`, `descripcion`) VALUES ('2', 'Aceptada');
INSERT INTO `dat`.`Estado` (`estado`, `descripcion`) VALUES ('3', 'Enviada');
INSERT INTO `dat`.`Estado` (`estado`, `descripcion`) VALUES ('4', 'Entregada');
INSERT INTO `dat`.`Estado` (`estado`, `descripcion`) VALUES ('X', 'Anulada');
INSERT INTO `dat`.`Estado` (`estado`, `descripcion`) VALUES ('N', 'No recibida');
INSERT INTO `dat`.`Estado` (`estado`, `descripcion`) VALUES ('R', 'Rechazada');
INSERT INTO `dat`.`Estado` (`estado`, `descripcion`) VALUES ('A', 'Activo');
INSERT INTO `dat`.`Estado` (`estado`, `descripcion`) VALUES ('E', 'Eliminado');

INSERT INTO `dat`.`Categoria` (`descripcion`, `estado`) VALUES ('Celulares', 'A');
INSERT INTO `dat`.`Categoria` (`descripcion`, `estado`) VALUES ('Audio', 'A');
INSERT INTO `dat`.`Categoria` (`descripcion`, `estado`) VALUES ('Televisores', 'A');
INSERT INTO `dat`.`Categoria` (`descripcion`, `estado`) VALUES ('Accesorios', 'E');

INSERT INTO `dat`.`Subcategoria` (`idCategoria`, `descripcion`, `estado`) VALUES ('1', 'Android', 'A');
INSERT INTO `dat`.`Subcategoria` (`idCategoria`, `descripcion`, `estado`) VALUES ('1', 'Apple', 'A');
INSERT INTO `dat`.`Subcategoria` (`idCategoria`, `descripcion`, `estado`) VALUES ('1', 'Doble Chip', 'A');
INSERT INTO `dat`.`Subcategoria` (`idCategoria`, `descripcion`, `estado`) VALUES ('1', 'Económicos', 'A');
INSERT INTO `dat`.`Subcategoria` (`idCategoria`, `descripcion`, `estado`) VALUES ('2', 'Audífonos', 'A');
INSERT INTO `dat`.`Subcategoria` (`idCategoria`, `descripcion`, `estado`) VALUES ('2', 'Parlantes', 'A');
INSERT INTO `dat`.`Subcategoria` (`idCategoria`, `descripcion`, `estado`) VALUES ('3', 'Pantalla Plana', 'A');
INSERT INTO `dat`.`Subcategoria` (`idCategoria`, `descripcion`, `estado`) VALUES ('3', 'Plasma', 'A');
INSERT INTO `dat`.`Subcategoria` (`idCategoria`, `descripcion`, `estado`) VALUES ('3', 'LCD', 'A');
INSERT INTO `dat`.`Subcategoria` (`idCategoria`, `descripcion`, `estado`) VALUES ('3', 'LED', 'E');
INSERT INTO `dat`.`Subcategoria` (`idCategoria`, `descripcion`, `estado`) VALUES ('4', 'Estuches', 'E');




#Insercion Tabla : Usuario

INSERT INTO `dat`.`Usuario` (`nombre`, `apellido`, `correo`, `pass`, `tipo`, `estado`) VALUES 
('María','Rosales','vendedor@vendedor.com',MD5('1234567'),'vendedor','A'),
('Carmen','Lara','carmen@vendedor.com',MD5('1234567'),'vendedor','A'),
('Rosa','Caral','rosa@vendedor.com',MD5('1234567'),'vendedor','A'),
('Marcos','Feria','pedro@vendedor.com',MD5('1234567'),'vendedor','A'),
('Nelly','Cardozo','nelly@vendedor.com',MD5('1234567'),'vendedor','A'),
('Pedro','Carrión','cliente@cliente.com',MD5('1234567'),'cliente','A'),
('Raul','Barrantes','raul@cliente.com',MD5('1234567'),'cliente','A'),
('Katy','Chumbe','katy@cliente.com',MD5('1234567'),'cliente','A'),
('Juan','Torrejon','juan@cliente.com',MD5('1234567'),'cliente','A'),
('Herman','Fields','Herman@cliente.com',MD5('1234567'),'cliente','A'),
('Daisy','Haynes','Daisy@cliente.com',MD5('1234567'),'cliente','A'),
('Ervin','Wheeler','Ervin@cliente.com',MD5('1234567'),'cliente','A'),
('Colleen','Miles','Colleen@cliente.com',MD5('1234567'),'cliente','A'),
('Gayle','Terry','Gayle@cliente.com',MD5('1234567'),'cliente','A'),
('Roman','Robinson','Roman@cliente.com',MD5('1234567'),'cliente','A'),
('Lorena','Holmes','Lorena@cliente.com',MD5('1234567'),'cliente','A'),
('Stanley','Clayton','Stanley@cliente.com',MD5('1234567'),'cliente','A'),
('Karen','Ballard','Karen@cliente.com',MD5('1234567'),'cliente','A'),
('Whitney','Simpson','Whitney@cliente.com',MD5('1234567'),'cliente','A'),
('Garry','Nash','Garry@cliente.com',MD5('1234567'),'cliente','A'),
('Beatrice','Daniels','Beatrice@cliente.com',MD5('1234567'),'cliente','A'),
('Gail','Brock','Gail@cliente.com',MD5('1234567'),'cliente','A'),
('Johanna','Torres','Johanna@cliente.com',MD5('1234567'),'cliente','A'),
('Woodrow','Perkins','Woodrow@cliente.com',MD5('1234567'),'cliente','A'),
('Celia','Mullins','Celia@cliente.com',MD5('1234567'),'cliente','A');



# datos Producto
INSERT INTO `dat`.`producto` (`idVendedor`, `idSubcategoria`, `nombre`, `descripcion`, `precio`, `imagen`, `stock`, `vendidas`, `marca`, `modelo`, `estado`) VALUES 
(2,5,'Beats Tour By Dr Dre','Experimenta la música exactamente del modo en que desea el cantante. Los auriculares Beats de alta definición están diseñados de un modo preciso para ofrecer todo el sonido de la música digital de hoy en día',420,'images/a6.jpg',4,15,'beats','DRE2014','A'),
(4,6,'Parlante 2.0 F&d','Controlador de rango completo por canal de 3ñ para un rendimiento de mejor sonido. Conductores blindados magnéticamente que virtualmente eliminan la interferencia del monitor y la pantalla de TV. Un sonido claro y natural',85,'images/p10.jpg',3,4,'F&D','R215','A'),
(4,9,'Tv Samsung 32','LA TV TIENE FUNCIONES TACTILES (PRENDER, APAGAR, CAMBIAR DE CANAL, VOLUMEN, ETC). LA BASE DE LA TV ES DURISIMA',690,'images/tv13.jpg',17,7,'Samsung','LN32B650','A'),
(3,2,'Iphone 4g16gb','El nuevo iPhone 4 trae una pantalla de 3.5 pulgadas IPS con 326 píxeles por pulgada (960 x 640 píxeles de resolución) y un ratio de contraste de 800:1 (cuatro veces más que su predecesor), multi-táctil, procesador Apple A4',1050,'images/i2.jpg',15,9,'Apple','Iphone','A'),
(2,3,'Lg Optimus L5','Sistema operativo Android, Chipset Qualcomm MSM7225A Snapdragon CPU 800 MHz Cortex-A5',519,'images/dc2.jpg',18,5,'LG','E455g','A'),
(3,11,'Funda de cuero','Color a juego interno,Cremalleras dobles,Protección resistente al agua,Proteja su ordenador portátil contra golpes y arañazos,Stretch - neopreno protege contra arañazos',80,'images/pic.jpg',0,10,'SKILL ','No especificada','E'),
(4,8,'Plasma Panasonic Viera','TV HD de 42 pulgadas, 16:9. Ranura para tarjeta SD. Resolución 1.024 x 768px HDTV. Contraste de 15.000:1. Pantalla HD de 1024 x 768 píxeles. 100 % Libre de plomo',1199,'images/tv11.jpg',7,11,'Panasonic','TH-4280PVL','A'),
(5,6,'Logitech Z505','Sienta un buen sonido Con 75 vatios reales (RMS) de sonido pleno y un potente subwoofer, este sistema hará que su música, sus películas y sus juegos cobren vida',240,'images/p9.jpg',2,4,'Logitech','Z505','A'),
(2,9,'Tv Lcd 17 Pulgadas ','Monitor de 17 pulgadas viewsonic optiquest q20w, tiene entradas VGA y DVI.',350,'images/tv3.jpg',8,25,'Viewsonic','Optiquest Q20w','A'),
(3,5,'Skullcandy Inkd 2 Supreme Sound','Audifonos Skullcandy Ink''d 2 Supreme Sound Ear Bud Headphone. color: negro morado rasta y rosado',60,'images/a9.jpg',9,18,'Skullcandy','INKD2','A'),
(1,6,'Sony Parlante Bluetooth','El SRS-BTX500 es el compañero de audio ideal. Su carcasa de acero incluye parlantes con fluido magnético y audio ClearPhase para lograr música impresionante, gran conectividad y una gran batería.',699,'images/p7.jpg',13,14,'Sony','Srs-btx500','A'),
(1,1,'Motorola Moto EXt1021','NUEVO MOTOROLA MOTO E , PROCESADOR DUAL CORE DE 1.2 GHZ LIBRE PARA CUALQUIER OPERADOR A NIVEL MUNDIAL',429,'images/an1.jpg',10,6,'Motorola','EXt1021','A'),
(4,6,'Mini Amplificador','100 WATTS RMS POR CANAL ,FUNCIONA CON CORRIENTE DE 100 VOLTIOS,PESO 29 KILOS',1000,'images/p6.jpg',25,9,'Hitachi','Hma-9500','A'),
(2,8,'Tv Plasma Lg 42 Pulgadas','TAMAÑO 42 PULG,PROPORCION WIDE,RESOLUCION MAX 1920X1080,FULL HD',800,'images/tv2.jpg',4,45,'Lg','42ly340c','A'),
(5,8,'Panasonic Viera 32 Pulgadas','Entrada de Audio Analógico (para HDMI/DVI). 3 Entradas de Video Compuesto. 1 Entrada de PC. 1 Entrada de Componente de Video (Y, PB, PR). 1 Entrada de Audio (para Componente de Video). Salida de Audio Digital. Opción de Lenguaje. Temporizador. Sintonizador de señal digital: para que puedas ver los canales HD de señal abierta',500,'images/tv12.jpg',5,19,'Panasonic','TC-L32C5L','A'),
(3,3,'Black 9000c','Android, Doble chip',150,'images/dc4.jpg',6,17,'No especificado','9000c','A'),
(2,11,'Mica protectora','Color Transparente ,Rápido y fácil de instalar  ,Protege de arañazos y rozaduras ,Materiales PET ',50,'images/pic.jpg',1,20,'SKILL ','No especificada','E'),
(4,4,'Moto W175','El Motorola W175 es un teléfono celular de banda dual GSM con formato candybar, de gama baja. Posee una pantalla STN de 65k colores, agenda telefónica, organizador y altoparlante.',200,'images/e1.jpg',40,14,'Motorola ','W175','A'),
(2,8,'Tv Plasma Lg Infinia 60','Tecnología Neo-Plasma Sub-Field 600HZ para imágenes más reales en escenas de mucho movimiento como películas de acción o deportes.',6250,'images/tv10.jpg',1,4,'LG','60PZ950B','A'),
(3,5,'Sennheiser Hd 202ii','Los auriculares HD202ii son ideales para DJs y amantes del buen sonido, Proporcionan alta fidelidad, gran aislamiento de ruido y unos bajos potentes.',119,'images/a8.jpg',12,9,'Sennheiser','HD202ii','A'),
(1,1,'Lg G2 Mini D 625 4g','El LG G2 Mini se coloca como una alternativa más compacta al LG G2, pero sin renunciar al diseño del modelo original, aspecto que también implica la continuidad de Rear Key, los botones principales localizados en la zona trasera de la carcasa.',924,'images/an8.jpg',3,4,'LG','G2','A'),
(5,3,'Verykool I607','2G Network GSM 850 / 900 / 1800 / 1900 - SIM 1 & SIM 2,SIM Dual SIM (Mini-SIM), Announced 2013, Status Available. Released 2013, BODY Dimensions 111 x 59 x 11 mm (4.37 x 2.32 x 0.43 in), Weight 82 g (2.89 oz), Keyboard QWERTY',200,'images/dc5.jpg',20,4,'verykool','i607','A'),
(3,2,'Iphone 5s 32gb','Protege tu información con el sensor de identidad por huella, sólo coloca tu dedo en el botón de inicio y automáticamente tendrás acceso a tu teléfono, así ocupas menos tiempo en colocar contraseñas o patrones.',2350,'images/i4.jpg',9,1,'Apple','Iphone','A'),
(3,1,'Samsung S4','Quinta generación del Galaxy S, esta vez conservando bastantes aspectos de diseño y hardware del Galaxy S4, pero agregando funcionalidades como monitor de ritmo cardíaco, sensor dactilar, y resistencia al agua',2000,'images/an4.jpg',10,1,'Samgung','Galaxy s4','A'),
(4,5,'Sony Mdr-zx310 Profesional','Ofrece graves potentes y unos agudos claros, es perfecto para amantes de la música.',73,'images/a3.jpg',2,5,'Sony','MDR-ZX310','A'),
(2,1,'S4 Htm Android 4.2','S4  1:1  ANDROID  4.2  CELULAR  5.0  PULGADAS  I9500  QUAD  CORE  1.2  GHZ  WIFI  MARCA  HTM  DUAL  SIM  CON  DOBLE  MODO  DE  ESPERA  SMARTPHONE.',299,'images/an9.jpg',20,1,'Htm','S4','A'),
(4,10,'Tv Led 55 Smart ','Te permite ver los deportes con las mejores características, cuenta con funciones increíbles que se pueden activar todas al mismo tiempo mediante un acceso directo. Mejora la imagen y el sonido a tu conveniencia.',1200,'images/tv4.jpg',54,2,'Samsung','XNU56','A'),
(3,9,'Samsung 32','TELEVISOR SAMSUNG 32" MODELO 4005, CON MODO FUTBOL, GARANTIA, ENTREGA A DOMICILIO',750,'images/tv15.jpg',19,8,'Samsung','Fh4005g','A'),
(3,10,'Lg Led 84 Ultra Hd Tv','EL PRIMER TELEVISOR DEL MUNDO ULTRA HD DE 84"',17000,'images/tv20.jpg',20,15,'LG','LG5647','A'),
(3,2,'Iphone 4g 8gb','El nuevo Apple iPhone 4 ahora es mas cuadrado, con una parte posterior plana en lugar de redondeada. Aún conserva la pantalla de 3.5 pulgadas, pero cuadriplica la cantidad de pixels a 640x960',800,'images/i1.jpg',10,20,'Apple','Iphone','A'),
(1,10,'Tv Led Smart Samsung','Disfruta al máximo de los deportes. Colores más vívidos que producen mejores imágenes. Descubre una realidad distinta en 3D SMART. FULL HD  MODO FUTBOL',3890,'images/tv18.jpg',8,8,'Samsung','UN55H6400KXZL','A'),
(5,1,'Alienware phone','Este dispositivo cuenta con una pantalla táctil AMOLED de 4.2 pulgadas, un procesador QualcommSnapdragon de 1.3 GHz, una cámara de 5 megapíxeles con autofocus y dual LED flash, además de la capacidad para reproducir vídeos de alta definición.',900,'images/an5.jpg',8,19,'Alienware','m5x','A'),
(1,6,'Technics Sb-101','PARLANTES TECHNICS SB-101 MADE IN JAPAN CON CROSSOVER',350,'images/p5.jpg',12,9,'Technics','Sb101','A'),
(5,10,'Televisor Led 32 Sintonizador Hd Miray','Televisor con marco delgado y diseño compacto. Cuenta con sintonizador incorporado, función de monitor de PC, ingreso a USB para reproductor multimedia (foto, música, vídeo). Salida de audio y vídeo.',749,'images/tv19.jpg',13,16,'Miray','LEDM-32B','A'),
(5,5,'Auricular Bluetooth Hv800','Nuevos Audifonos Inalmbricos Bluetooth Stereo  HV800 2014, EXELENTE CALIDAD DE SONIDO STEREO. CONEXION INALAMBRICA. Vibra cuando recibes llamadas. Responde y realiza llamadas',89,'images/a4.jpg',16,15,'No Especificado','W262','A'),
(5,3,'Doble Chip Blu Aria','S4  1:1  ANDROID  4.2  CELULAR  5.0  PULGADAS  I9500  QUAD  CORE  1.2  GHZ  WIFI  MARCA  HTM  DUAL  SIM  CON  DOBLE  MODO  DE  ESPERA  SMARTPHONE.',79,'images/dc3.jpg',13,18,'BLU','Aria','A'),
(4,6,'Parlantes Beats Pill','Experimenta la música exactamente del modo en que desea el cantante. Los parlantes Beats de alta definición están diseñados de un modo preciso para ofrecer todo el sonido de la música digital de hoy en día',560,'images/p1.jpg',19,11,'beats','Pill','A'),
(1,4,'Nokia 3210','Pulsando el botón de encendido en la parte superior del móvil, se enciende el teléfono. Tras teclear el código de seguridad PIN, se muestra la GUI, indicando el nivel de la señal (1-4 barras), nivel de batería y el operador de red. Pulsando el botón (-) se accede al menú principal del teléfono',2000,'images/e2.jpg',4,10,'Nokia','3210','A'),
(2,3,'Moto G','Pantalla 720p de 4.5 pulgadas, procesador quad-core Snapdragon 400, 1GB de RAM, 8GB o 16GB de almacenamiento interno, cámara trasera de 5 megapixels',700,'images/an3.jpg',30,3,'Motorola','Xt1033','A'),
(5,5,'Philips Shl3200 Dj Profesional','Los auriculares SHL3200 ofrecen el rendimiento que demandan los DJ más exigentes. Los controladores de neodimio de 40 mm ofrecen graves dinámicos, mientras que los auriculares intercambiables giran 165° para ofrecer una monitorización fácil. Equipados con una potencia de 2000 mW, los auriculares no presentan distorsiones incluso con un volumen alto.',69,'images/a7.jpg',16,10,'Philips','SHL3200','A'),
(2,1,'Huawei U8350 3g','Es un móvil Android con procesador mediano de 528Mhz que realiza bien las funciones del Huawei Boulder U8350',159,'images/an2.jpg',8,20,'Huawei','U8350','A'),
(4,2,'Iphone','Pantalla retroiluminada por LED sin mercurio,idrio de la pantalla sin arsénico,Sin retardantes de llama bromados,Sin PVC,Carcasa de aluminio reciclable, ',1800,'images/i5.jpg',20,21,'Apple','5S','A'),
(1,8,'Panasonic 42 Full Hd','Sintonizador NTSC.PANEL IPS - FULL HD (1920 - 1080). 3 entradas HDMI - 2 entradas de video compuesto - 1 entrada de video componente Y, PB, PR/ Entrada de audio análoga para HDMI & DVI /1 Entrada para PC, Ranura para Tarjeta de Memoria SD.',1700,'images/tv9.jpg',9,2,'Panasonic','TC-L42U22L','A'),
(4,5,'Beats Monster By Dr. Dre','Experimenta la música exactamente del modo en que desea el cantante. Los auriculares Beats de alta definición están diseñados de un modo preciso para ofrecer todo el sonido de la música digital de hoy en día, incluidos los géneros más exigentes desde el punto de vista del sonido.',900,'images/a2.jpg',1,7,'beats','DRE1000','A'),
(1,2,'Iphone 5s Apple 16gb','Toda la tecnología en apenas 0.76cm de grosor y 112 gramos de peso. Una perfecta integración que se refuerza por su carcasa de aluminio. Un cristal de zafiro que reluce en el botón de inicio y en la cámara iSight.',2199,'images/i3.jpg',4,10,'Apple','Iphone','A'),
(4,7,'Televisor Sony De 29','A la venta  televisor  Sony WEGA de 29" incluye control remoto',450,'images/tv5.jpg',8,1,'Sony','WEGA0110','A'),
(5,7,'Tv Pantalla Plana Sony Wega','lock/Timer de dos eventos ,Potencia de Audio 10 Watts x 2 con efectos SRS , Temperatura de color,Escaneo Mejorado para imágen DVD en Widescreen,Canal favorito,Cuadruple polo magnetico,Compensación de Apertura Vertical',600,'images/tv1.jpg',18,25,'Sony','Wega','A'),
(4,3,'Android 4.0 Ice Cream','Juego del fondo del MP3, altavoz estéreo, pantalla LCD, ',229,'images/dc1.jpg',6,9,'GFIVE','SparkA1','A'),
(3,7,'Televisor Miray 32','Ángulo de visión 178°, Frecuencia de actualización 120 Hz, Relación de aspecto 16:9, Resolución 1366x768 px',699,'images/tv7.jpg',4,8,'Miray','Ledm-32b','A'),
(5,1,'Samsung Omnia I900 16gb','El Samsung OMNIA es un smartphone con Windows Mobile 6.1 Professional, con una pantalla de 3.2 pulgadas WQVGA y personalización TouchWiz para la interfaz. Está diseñado tanto como un smartphone de alta gama como un dispositivo multimedia',280,'images/an6.jpg',16,7,'Samsung','I900','A'),
(1,10,'Tv Led Smart Modo Futbol','Disfruta al máximo de los deportes, colores más vívidos que producen mejores imágenes. Descubre una realidad distinta en 3D SMART. FULL HD  MODO FUTBOL',3890,'images/tv17.jpg',10,20,'Samsung','UN55H6400','A'),
(1,5,'Bluetooth S11- Flex','Ofrece graves potentes y unos agudos claros, es perfecto para amantes de la música.',139,'images/a10.jpg',14,15,'Flex','W273','A'),
(1,5,'Shl3300 Dj Profesional','Graves profundos, sonido definido. Con sistema de monitorización tipo DJ',80,'images/a1.jpg',4,3,'Phillips','Shl3300','A'),
(3,6,'Logitech Z506 75 Rms','Sienta un buen sonido 5.1. Con 75 vatios reales (RMS) de sonido pleno y un potente subwoofer, este sistema hará que su música, sus películas y sus juegos cobren vida',239,'images/p4.jpg',19,11,'Logitech','Z506','A'),
(2,9,'Samsung Smart Tv','En este mundo acelerado es difícil mantener la tecnología al día. Smart Evolution elimina esta preocupación y te ayuda a mantener tu Smart TV actualizado. El chipset de fácil instalación actualiza los principales componentes de tu televisor para garantizar que tengas la experiencia de entretenimiento más innovadora, sin necesidad de comprar un nuevo equipo.',3750,'images/tv14.jpg',12,3,'Samsung','F8000','A'),
(5,7,'Tv Digital Portatil','tv con sintonizador digital y analogo para que veas el peliculas en cualquier lado',260,'images/tv8.jpg',20,2,'Hitech','H20024','A'),
(5,1,'Samsung Galaxy Appeal 3g+','A veces, como a un teclado otras veces como una pantalla táctil. Con el teclado QWERTY deslizable en el Samsung Galaxy Appeal, puede hacer las dos cosas al mismo tiempo. Esta capacidad de entrada dual significa que es más fácil que nunca para que usted pueda mantenerse en contacto con amigos y familiares, ya sea que esté enviando mensajes de texto, compartir los medios de comunicación o simplemente mantenerse al día con sus redes sociales.',289,'images/an7.jpg',19,9,'Samsung','Appeal3g','A'),
(5,7,'Televisor 10.1','LEE FORMATOS DE MUSICA, VIDEO, FOTOS, VIENE CON CABLE PARA DVD EXTERNO',220,'images/tv6.jpg',3,7,'Hitachi','HT1001','A'),
(4,6,'Parlantes Rivera','02 PARLANTES RIVERA DE 15W',80,'images/p8.jpg',10,5,'Rivera','e65413','A'),
(3,5,'Philips Shl4300','Diseñados para ofrecer un sonido sin concesiones, los auriculares SHL4300 disponden de controladores de neodimio de 40 mm',75,'images/a5.jpg',7,16,'Phillips','Shl4300','A'),
(4,9,'Tv Lg 3d Smart','PRODUCTO NUEVO SELLADO EN CAJA CON GARANTIA, EMITIMOS FACTURA O BOLETA, HACEMOS CONTRAENTREGA A DOMICILIO PAGO EN EFECTIVO, REALIZAMOS ENVIOS A NIVEL NACIONAL PREVIO DEPOSITO EN CTA DEL BANCO DE CREDITO DEL PERU, AGRADECEMOS SU PREFERENCIA. SALUDOS CORDIALES',2950,'images/tv16.jpg',4,2,'LG','50lb6500','A'),
(5,1,'S5 Mini Sm-g800','El celular S5 Mini MTK 6572 es un smartphone de gama baja y tal como dice su nombre, es una versión Mini de las características que se pueden encontrar en otro smartphone.',284,'images/an10.jpg',1,1,'S5','MTK6572','A'),
(1,6,'Parlantes Aiwa','SON WOOFERS QUE PERTENECEN A UN AIWA NSX 990',50,'images/p3.jpg',14,3,'Aiwa','e264132','A'),
(1,5,'Rode Reporter','El Reporter es un micrófono diseñado para entrevistas y reportajes, que minimiza los ruidos indeseados de manipulación y viento, robusto y con un precio accesible, acompañado de la tradicional garantía de 10 años de Rode',449,'images/rr.jpg',50,25,'Reporte','Rode','A'),
(3,6,'Ewtto 500w','parlantes en caja nuevo para colocar memoria usb de gran potencia muy buen parlante puedes colocar tu usb o mermoria card',200,'images/p2.jpg',6,8,'Ewtto','e200123','A');



# datos orden

INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('10', '2014-07-28', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('16', '2014-07-27', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('10', '2014-06-20', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('9', '2014-06-19', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('12', '2014-06-18', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('16', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('19', '2014-06-16', 'E');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('13', '2014-07-29', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('14', '2014-07-26', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('16', '2014-06-20', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('16', '2014-06-19', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('6', '2014-06-18', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('18', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('14', '2014-06-16', 'E');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('17', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('12', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('12', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('14', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('15', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('17', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('16', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('11', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('13', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('20', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('13', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('14', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('17', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('17', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('16', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('17', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('14', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('10', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('9', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('12', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('12', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('15', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('8', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('12', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('16', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('18', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('19', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('13', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('8', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('17', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('18', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('14', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('10', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('8', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('14', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('18', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('18', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('12', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('11', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('6', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('14', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('17', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('19', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('17', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('6', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('18', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('10', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('6', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('8', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('14', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('20', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('10', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('10', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('19', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('18', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('10', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('6', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('9', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('6', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('15', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('19', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('20', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('10', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('9', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('17', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('15', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('17', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('9', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('13', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('15', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('6', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('16', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('19', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('12', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('12', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('19', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('8', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('20', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('17', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('8', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('13', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('9', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('20', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('15', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('9', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('19', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('18', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('16', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('11', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('6', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('20', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('11', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('8', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('18', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('12', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('11', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('16', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('8', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('14', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('18', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('18', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('19', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('20', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('15', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('19', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('14', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('8', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('14', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('18', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('12', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('19', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('18', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('11', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');
INSERT INTO `dat`.`Orden` (`idCliente`, `fechaCreada`, `estado`) VALUES ('7', '2014-06-17', 'A');


#datos OrdenxProducto

INSERT INTO `dat`.`ordenxproducto` (`idOrden`, `idProducto`, `cantidad`, `precio`, `fechaCreada`, `fechaEnviada`, `fechaEntregada`, `fechaAnulada`, `valoracion`, `comentarioCliente`, `comentarioVendedor`, `estado`) VALUES 
(1,1,1,420,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'1'),
(1,2,1,85,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'2'),
(1,3,1,690,'10/08/14 18:31','10/08/14 18:31',NULL,NULL,0,NULL,NULL,'3'),
(1,4,2,2100,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Todo bien....',NULL,'4'),
(1,5,1,519,'10/08/14 18:31',NULL,NULL,'10/08/14 18:31',0,NULL,NULL,'X'),
(1,6,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,2,'Deben mejorar su sistema de entregas',NULL,'N'),
(1,7,1,1199,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(1,8,1,240,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Todo perfecto. Envio rápido. ',NULL,'4'),
(1,9,2,700,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Todo correcto. ',NULL,'4'),
(2,1,1,420,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'1'),
(2,2,1,85,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'2'),
(2,3,1,690,'10/08/14 18:31','10/08/14 18:31',NULL,NULL,0,NULL,NULL,'3'),
(2,4,2,2100,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Una compra bien servida tiene poco recorrido. .. pero muy rápido. .. y buen precio. .. no barato. .. si mejor que tiendas locales ',NULL,'4'),
(2,5,1,519,'10/08/14 18:31',NULL,NULL,'10/08/14 18:31',0,NULL,NULL,'X'),
(2,6,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,2,'me informan que mi producto ha sido entregado, sin embargo este nunca llegó',NULL,'N'),
(2,7,1,1199,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(2,8,1,240,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'este modelo calidad precio funciona perfectamente ',NULL,'4'),
(2,9,2,700,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'La valoración de las estrellas es por falta de información del artículo. ',NULL,'4'),
(8,1,1,420,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'1'),
(8,2,1,85,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'2'),
(8,3,1,690,'10/08/14 18:31','10/08/14 18:31',NULL,NULL,0,NULL,NULL,'3'),
(8,4,2,2100,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Buena relacion Calidad precio. ',NULL,'4'),
(8,5,1,519,'10/08/14 18:31',NULL,NULL,'10/08/14 18:31',0,NULL,NULL,'X'),
(8,6,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,0,'nunca recibí mi pedido',NULL,'N'),
(8,7,1,1199,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(8,8,1,240,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Los acabados  son muy buenos, tiene el perfil muy fino ',NULL,'4'),
(8,9,2,700,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'la recomiendo a todo el mundo, relacion calidad precio muy buena ',NULL,'4'),
(9,1,1,420,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'1'),
(9,2,1,85,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'2'),
(9,3,1,690,'10/08/14 18:31','10/08/14 18:31',NULL,NULL,0,NULL,NULL,'3'),
(9,4,2,2100,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'El envío ha sido muy rápido y el material responde completamente a las especificaciones. Recomiendo a este vendedor. ',NULL,'4'),
(9,5,1,519,'10/08/14 18:31',NULL,NULL,'10/08/14 18:31',0,NULL,NULL,'X'),
(9,6,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,0,'El producto nunca llegó',NULL,'N'),
(9,7,1,1199,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(9,8,1,240,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'buen trato telefonico y aclaracion de dudas ',NULL,'4'),
(9,9,2,700,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Muy contento. Incluso tube un pequeña confusión al hacer el pedido y me lo arreglaron al momento. ',NULL,'4'),
(3,1,1,420,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Todo perfecto. Envio rápido. ',NULL,'4'),
(4,2,1,85,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Todo correcto. ',NULL,'4'),
(5,3,1,690,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Transacción perfecta y rápida. Todo perfecto. ',NULL,'4'),
(6,4,2,2100,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Todo genial rápido y de calidad. ',NULL,'4'),
(7,5,1,519,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Buen precio, servicio rápido y el producto tal y como se detalla en la web.Sin sorpresas',NULL,'4'),
(10,6,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Una compra bien servida tiene poco recorrido. .. pero muy rápido. .. y buen precio. .. no barato. .. si mejor que tiendas locales ',NULL,'4'),
(11,7,1,1199,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Seriedad y buena relación calidad precio. Se puede confiar en sus comentarios, no són publicidad engañosa. ',NULL,'4'),
(12,8,1,240,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'El aparato funciona bien para el uso que le doy. ',NULL,'4'),
(13,9,2,700,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'me ha dado todas las preferencias que queria para mi necesidad. ',NULL,'4'),
(14,10,1,60,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'este modelo calidad precio funciona perfectamente ',NULL,'4'),
(14,34,1,749,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'La valoración de las estrellas es por falta de información del artículo. ',NULL,'4'),
(15,38,4,8000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'LA COMPRA Y EL SERVICIO MUY BIEN ,PERO ME HE SENTIDO UN POCO ENGAÑADA ',NULL,'4'),
(16,11,1,699,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Muy buen producto, de marca reconocida y que tiene todas las prestaciones. ',NULL,'4'),
(16,28,1,750,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(17,26,1,299,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,0,'Me he sentido engañado',NULL,'N'),
(17,16,1,150,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,' lo compre en otro lado pero dejo esta informacion por si puede ser util. ',NULL,'4'),
(18,9,1,350,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Me enviaron la versión alemana del producto. ',NULL,'4'),
(18,33,1,350,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'no informa adecuadamente al cliente, me explico si dice que es un producto importado, pero nada mas ',NULL,'4'),
(18,56,1,260,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Los acabados  son muy buenos, tiene el perfil muy fino ',NULL,'4'),
(18,57,1,289,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'la recomiendo a todo el mundo, relacion calidad precio muy buena ',NULL,'4'),
(19,18,1,200,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'1'),
(20,34,4,2996,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,2,'Sigo esperando mi prodcuto',NULL,'N'),
(20,50,2,560,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'ya habia comprado aqui antes y el producto perfecto sin problemas ',NULL,'4'),
(21,26,7,2093,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'El envío ha sido muy rápido y el material responde completamente a las especificaciones. Recomiendo a este vendedor. ',NULL,'4'),
(22,40,3,207,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'excelente en todo ',NULL,'4'),
(22,38,2,4000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,2,'En este momento estoy tramitando la devolución de mi dinero',NULL,'N'),
(23,9,1,350,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Muy recomendables. ',NULL,'4'),
(23,24,1,2000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'buen trato telefonico y aclaracion de dudas ',NULL,'4'),
(23,55,1,3750,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Muy contento. Incluso tube un pequeña confusión al hacer el pedido y me lo arreglaron al momento. ',NULL,'4'),
(23,58,1,220,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'2'),
(24,9,1,350,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Todo correcto. ',NULL,'4'),
(24,64,1,449,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Transacción perfecta y rápida. Todo perfecto. ',NULL,'4'),
(24,29,7,119000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Todo genial rápido y de calidad. ',NULL,'4'),
(25,14,1,800,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Buen precio, servicio rápido y el producto tal y como se detalla en la web.Sin sorpresas',NULL,'4'),
(26,42,2,3600,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Una compra bien servida tiene poco recorrido. .. pero muy rápido. .. y buen precio. .. no barato. .. si mejor que tiendas locales ',NULL,'4'),
(26,7,1,1199,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Seriedad y buena relación calidad precio. Se puede confiar en sus comentarios, no són publicidad engañosa. ',NULL,'4'),
(26,63,3,150,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'El aparato funciona bien para el uso que le doy. ',NULL,'4'),
(27,37,1,560,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'me ha dado todas las preferencias que queria para mi necesidad. ',NULL,'4'),
(28,62,6,1704,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'este modelo calidad precio funciona perfectamente ',NULL,'4'),
(29,57,1,289,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'La valoración de las estrellas es por falta de información del artículo. ',NULL,'4'),
(30,64,1,449,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'LA COMPRA Y EL SERVICIO MUY BIEN ,PERO ME HE SENTIDO UN POCO ENGAÑADA ',NULL,'4'),
(31,52,1,139,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Muy buen producto, de marca reconocida y que tiene todas las prestaciones. ',NULL,'4'),
(32,4,1,1050,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(33,19,1,6250,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Buena relacion Calidad precio. ',NULL,'4'),
(34,4,1,1050,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,' lo compre en otro lado pero dejo esta informacion por si puede ser util. ',NULL,'4'),
(35,30,3,2400,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Me enviaron la versión alemana del producto. ',NULL,'4'),
(35,22,2,400,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'no informa adecuadamente al cliente, me explico si dice que es un producto importado, pero nada mas ',NULL,'4'),
(35,50,9,2520,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Los acabados  son muy buenos, tiene el perfil muy fino ',NULL,'4'),
(36,23,1,2350,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'la recomiendo a todo el mundo, relacion calidad precio muy buena ',NULL,'4'),
(36,28,4,3000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'lo pedí un viernes y el lunes ya lo tenía en casa ',NULL,'4'),
(37,48,1,229,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'creo que seguiré confiando con ustedes muy amables ',NULL,'4'),
(37,21,1,924,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'ya habia comprado aqui antes y el producto perfecto sin problemas ',NULL,'4'),
(37,45,1,2199,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'El envío ha sido muy rápido y el material responde completamente a las especificaciones. Recomiendo a este vendedor. ',NULL,'4'),
(38,56,5,1300,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'excelente en todo ',NULL,'4'),
(38,24,1,2000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Todo bien....',NULL,'4'),
(38,50,1,280,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Muy recomendables. ',NULL,'4'),
(38,6,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'buen trato telefonico y aclaracion de dudas ',NULL,'4'),
(39,36,1,79,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Muy contento. Incluso tube un pequeña confusión al hacer el pedido y me lo arreglaron al momento. ',NULL,'4'),
(39,31,1,3890,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'1'),
(39,52,1,139,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'2'),
(39,36,1,79,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Transacción perfecta y rápida. Todo perfecto. ',NULL,'4'),
(40,51,1,3890,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Todo genial rápido y de calidad. ',NULL,'4'),
(41,3,3,2070,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Buen precio, servicio rápido y el producto tal y como se detalla en la web.Sin sorpresas',NULL,'4'),
(42,24,1,2000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Una compra bien servida tiene poco recorrido. .. pero muy rápido. .. y buen precio. .. no barato. .. si mejor que tiendas locales ',NULL,'4'),
(43,9,1,350,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Seriedad y buena relación calidad precio. Se puede confiar en sus comentarios, no són publicidad engañosa. ',NULL,'4'),
(43,16,1,150,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'El aparato funciona bien para el uso que le doy. ',NULL,'4'),
(44,61,1,2950,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'me ha dado todas las preferencias que queria para mi necesidad. ',NULL,'4'),
(45,1,1,420,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'este modelo calidad precio funciona perfectamente ',NULL,'4'),
(46,33,1,350,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'La valoración de las estrellas es por falta de información del artículo. ',NULL,'4'),
(46,6,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'LA COMPRA Y EL SERVICIO MUY BIEN ,PERO ME HE SENTIDO UN POCO ENGAÑADA ',NULL,'4'),
(46,18,1,200,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Muy buen producto, de marca reconocida y que tiene todas las prestaciones. ',NULL,'4'),
(46,42,1,1800,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Esto fue un regalo para mis padres. El envío superrrrrápido. El producto, lo que prometian. Funciona de maravilla. No se puede pedir mas ',NULL,'4'),
(46,24,7,14000,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'1'),
(47,32,7,6300,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,' lo compre en otro lado pero dejo esta informacion por si puede ser util. ',NULL,'4'),
(47,58,1,220,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Me enviaron la versión alemana del producto. ',NULL,'4'),
(48,51,1,3890,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'no informa adecuadamente al cliente, me explico si dice que es un producto importado, pero nada mas ',NULL,'4'),
(48,20,1,119,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Los acabados  son muy buenos, tiene el perfil muy fino ',NULL,'4'),
(48,65,6,1200,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'la recomiendo a todo el mundo, relacion calidad precio muy buena ',NULL,'4'),
(48,19,1,6250,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'lo pedí un viernes y el lunes ya lo tenía en casa ',NULL,'4'),
(48,38,1,2000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'creo que seguiré confiando con ustedes muy amables ',NULL,'4'),
(49,14,2,1600,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'ya habia comprado aqui antes y el producto perfecto sin problemas ',NULL,'4'),
(49,6,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'El envío ha sido muy rápido y el material responde completamente a las especificaciones. Recomiendo a este vendedor. ',NULL,'4'),
(50,21,1,924,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,2,'Por farvor, ya no envíen el producto, ya no lo requiero',NULL,'N'),
(50,40,4,276,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(51,30,1,800,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Muy recomendables. ',NULL,'4'),
(51,27,2,2400,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'buen trato telefonico y aclaracion de dudas ',NULL,'4'),
(51,50,1,280,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Muy contento. Incluso tube un pequeña confusión al hacer el pedido y me lo arreglaron al momento. ',NULL,'4'),
(51,42,1,1800,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Todo perfecto. Envio rápido. ',NULL,'4'),
(52,54,8,1912,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Todo correcto. ',NULL,'4'),
(53,30,1,800,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Transacción perfecta y rápida. Todo perfecto. ',NULL,'4'),
(53,50,4,1120,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Todo genial rápido y de calidad. ',NULL,'4'),
(53,22,1,200,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Buen precio, servicio rápido y el producto tal y como se detalla en la web.Sin sorpresas',NULL,'4'),
(53,64,1,449,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Una compra bien servida tiene poco recorrido. .. pero muy rápido. .. y buen precio. .. no barato. .. si mejor que tiendas locales ',NULL,'4'),
(53,65,1,200,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Seriedad y buena relación calidad precio. Se puede confiar en sus comentarios, no són publicidad engañosa. ',NULL,'4'),
(54,61,1,2950,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'El aparato funciona bien para el uso que le doy. ',NULL,'4'),
(55,29,1,17000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'me ha dado todas las preferencias que queria para mi necesidad. ',NULL,'4'),
(56,25,1,73,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,0,'El producto nunca llegó',NULL,'N'),
(57,18,3,600,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'La valoración de las estrellas es por falta de información del artículo. ',NULL,'4'),
(58,63,1,50,'10/08/14 18:31','10/08/14 18:31',NULL,NULL,0,NULL,NULL,'3'),
(58,4,1,1050,'10/08/14 18:31','10/08/14 18:31',NULL,NULL,0,NULL,NULL,'3'),
(59,7,1,1199,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Esto fue un regalo para mis padres. El envío superrrrrápido. El producto, lo que prometian. Funciona de maravilla. No se puede pedir mas ',NULL,'4'),
(59,65,5,1000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Buena relacion Calidad precio. ',NULL,'4'),
(60,25,1,73,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,' lo compre en otro lado pero dejo esta informacion por si puede ser util. ',NULL,'4'),
(61,41,1,159,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Me enviaron la versión alemana del producto. ',NULL,'4'),
(62,20,1,119,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'no informa adecuadamente al cliente, me explico si dice que es un producto importado, pero nada mas ',NULL,'4'),
(62,9,1,350,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Los acabados  son muy buenos, tiene el perfil muy fino ',NULL,'4'),
(62,26,1,299,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(63,52,1,139,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'lo pedí un viernes y el lunes ya lo tenía en casa ',NULL,'4'),
(64,15,1,500,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'creo que seguiré confiando con ustedes muy amables ',NULL,'4'),
(65,57,1,289,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'ya habia comprado aqui antes y el producto perfecto sin problemas ',NULL,'4'),
(65,21,1,924,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'El envío ha sido muy rápido y el material responde completamente a las especificaciones. Recomiendo a este vendedor. ',NULL,'4'),
(66,42,1,1800,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'excelente en todo ',NULL,'4'),
(66,7,1,1199,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Todo bien....',NULL,'4'),
(66,37,8,4480,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Muy recomendables. ',NULL,'4'),
(66,51,1,3890,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'buen trato telefonico y aclaracion de dudas ',NULL,'4'),
(67,46,1,450,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Muy contento. Incluso tube un pequeña confusión al hacer el pedido y me lo arreglaron al momento. ',NULL,'4'),
(67,32,1,900,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Todo perfecto. Envio rápido. ',NULL,'4'),
(68,49,1,699,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Todo correcto. ',NULL,'4'),
(68,16,1,150,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Transacción perfecta y rápida. Todo perfecto. ',NULL,'4'),
(68,53,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Todo genial rápido y de calidad. ',NULL,'4'),
(68,51,1,3890,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Buen precio, servicio rápido y el producto tal y como se detalla en la web.Sin sorpresas',NULL,'4'),
(69,7,1,1199,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Una compra bien servida tiene poco recorrido. .. pero muy rápido. .. y buen precio. .. no barato. .. si mejor que tiendas locales ',NULL,'4'),
(69,36,1,79,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Seriedad y buena relación calidad precio. Se puede confiar en sus comentarios, no són publicidad engañosa. ',NULL,'4'),
(70,56,1,260,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'2'),
(71,31,1,3890,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'me ha dado todas las preferencias que queria para mi necesidad. ',NULL,'4'),
(72,6,7,560,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'este modelo calidad precio funciona perfectamente ',NULL,'4'),
(72,2,1,85,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(73,44,1,900,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'LA COMPRA Y EL SERVICIO MUY BIEN ,PERO ME HE SENTIDO UN POCO ENGAÑADA ',NULL,'4'),
(74,61,9,26550,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Muy buen producto, de marca reconocida y que tiene todas las prestaciones. ',NULL,'4'),
(75,6,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Esto fue un regalo para mis padres. El envío superrrrrápido. El producto, lo que prometian. Funciona de maravilla. No se puede pedir mas ',NULL,'4'),
(75,65,1,200,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Buena relacion Calidad precio. ',NULL,'4'),
(75,46,1,450,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,' lo compre en otro lado pero dejo esta informacion por si puede ser util. ',NULL,'4'),
(75,12,8,3432,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Me enviaron la versión alemana del producto. ',NULL,'4'),
(75,61,1,2950,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'no informa adecuadamente al cliente, me explico si dice que es un producto importado, pero nada mas ',NULL,'4'),
(75,33,1,350,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Los acabados  son muy buenos, tiene el perfil muy fino ',NULL,'4'),
(76,22,1,200,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'la recomiendo a todo el mundo, relacion calidad precio muy buena ',NULL,'4'),
(76,29,1,17000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'lo pedí un viernes y el lunes ya lo tenía en casa ',NULL,'4'),
(77,54,1,239,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'creo que seguiré confiando con ustedes muy amables ',NULL,'4'),
(78,24,1,2000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'ya habia comprado aqui antes y el producto perfecto sin problemas ',NULL,'4'),
(78,48,1,229,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'El envío ha sido muy rápido y el material responde completamente a las especificaciones. Recomiendo a este vendedor. ',NULL,'4'),
(78,26,1,299,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'excelente en todo ',NULL,'4'),
(78,37,1,560,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Todo bien....',NULL,'4'),
(78,40,1,69,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Muy recomendables. ',NULL,'4'),
(79,64,1,449,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'buen trato telefonico y aclaracion de dudas ',NULL,'4'),
(80,26,3,897,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Muy contento. Incluso tube un pequeña confusión al hacer el pedido y me lo arreglaron al momento. ',NULL,'4'),
(81,31,1,3890,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Todo perfecto. Envio rápido. ',NULL,'4'),
(82,32,8,7200,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Todo correcto. ',NULL,'4'),
(83,47,1,600,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Transacción perfecta y rápida. Todo perfecto. ',NULL,'4'),
(84,61,8,23600,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Todo genial rápido y de calidad. ',NULL,'4'),
(85,53,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Buen precio, servicio rápido y el producto tal y como se detalla en la web.Sin sorpresas',NULL,'4'),
(86,39,1,700,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Una compra bien servida tiene poco recorrido. .. pero muy rápido. .. y buen precio. .. no barato. .. si mejor que tiendas locales ',NULL,'4'),
(86,24,7,14000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Seriedad y buena relación calidad precio. Se puede confiar en sus comentarios, no són publicidad engañosa. ',NULL,'4'),
(87,63,1,50,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'El aparato funciona bien para el uso que le doy. ',NULL,'4'),
(88,23,1,2350,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,0,'Deben haber tenido algun problema.',NULL,'N'),
(88,32,1,900,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'este modelo calidad precio funciona perfectamente ',NULL,'4'),
(89,20,4,476,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'La valoración de las estrellas es por falta de información del artículo. ',NULL,'4'),
(89,5,2,1038,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'LA COMPRA Y EL SERVICIO MUY BIEN ,PERO ME HE SENTIDO UN POCO ENGAÑADA ',NULL,'4'),
(89,37,5,2800,'10/08/14 18:31',NULL,NULL,'10/08/14 18:31',0,NULL,NULL,'X'),
(90,28,1,750,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Esto fue un regalo para mis padres. El envío superrrrrápido. El producto, lo que prometian. Funciona de maravilla. No se puede pedir mas ',NULL,'4'),
(91,54,1,239,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Buena relacion Calidad precio. ',NULL,'4'),
(91,44,1,900,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,' lo compre en otro lado pero dejo esta informacion por si puede ser util. ',NULL,'4'),
(92,42,1,1800,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Me enviaron la versión alemana del producto. ',NULL,'4'),
(92,19,1,6250,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(93,51,1,3890,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Los acabados  son muy buenos, tiene el perfil muy fino ',NULL,'4'),
(93,53,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'la recomiendo a todo el mundo, relacion calidad precio muy buena ',NULL,'4'),
(94,15,1,500,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'lo pedí un viernes y el lunes ya lo tenía en casa ',NULL,'4'),
(94,48,8,1832,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'creo que seguiré confiando con ustedes muy amables ',NULL,'4'),
(95,11,1,699,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'ya habia comprado aqui antes y el producto perfecto sin problemas ',NULL,'4'),
(95,42,1,1800,'10/08/14 18:31',NULL,NULL,'10/08/14 18:31',0,NULL,NULL,'X'),
(95,13,6,6000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'excelente en todo ',NULL,'4'),
(95,44,1,900,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Todo bien....',NULL,'4'),
(96,53,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Muy recomendables. ',NULL,'4'),
(96,24,2,4000,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(97,52,1,139,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Muy contento. Incluso tube un pequeña confusión al hacer el pedido y me lo arreglaron al momento. ',NULL,'4'),
(97,19,1,6250,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Todo perfecto. Envio rápido. ',NULL,'4'),
(97,12,1,429,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Todo correcto. ',NULL,'4'),
(98,17,1,50,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Transacción perfecta y rápida. Todo perfecto. ',NULL,'4'),
(98,31,8,31120,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Todo genial rápido y de calidad. ',NULL,'4'),
(99,22,6,1200,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Buen precio, servicio rápido y el producto tal y como se detalla en la web.Sin sorpresas',NULL,'4'),
(100,58,1,220,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Una compra bien servida tiene poco recorrido. .. pero muy rápido. .. y buen precio. .. no barato. .. si mejor que tiendas locales ',NULL,'4'),
(100,37,1,560,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'1'),
(101,25,1,73,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'El aparato funciona bien para el uso que le doy. ',NULL,'4'),
(102,64,1,449,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'me ha dado todas las preferencias que queria para mi necesidad. ',NULL,'4'),
(103,22,1,200,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'este modelo calidad precio funciona perfectamente ',NULL,'4'),
(103,15,1,500,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'La valoración de las estrellas es por falta de información del artículo. ',NULL,'4'),
(104,35,1,89,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'LA COMPRA Y EL SERVICIO MUY BIEN ,PERO ME HE SENTIDO UN POCO ENGAÑADA ',NULL,'4'),
(105,60,1,75,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Muy buen producto, de marca reconocida y que tiene todas las prestaciones. ',NULL,'4'),
(105,59,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Esto fue un regalo para mis padres. El envío superrrrrápido. El producto, lo que prometian. Funciona de maravilla. No se puede pedir mas ',NULL,'4'),
(106,26,1,299,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Buena relacion Calidad precio. ',NULL,'4'),
(106,40,1,69,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,' lo compre en otro lado pero dejo esta informacion por si puede ser util. ',NULL,'4'),
(107,56,1,260,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Me enviaron la versión alemana del producto. ',NULL,'4'),
(108,56,1,260,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'no informa adecuadamente al cliente, me explico si dice que es un producto importado, pero nada mas ',NULL,'4'),
(108,13,1,1000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Los acabados  son muy buenos, tiene el perfil muy fino ',NULL,'4'),
(108,4,6,6300,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'la recomiendo a todo el mundo, relacion calidad precio muy buena ',NULL,'4'),
(108,24,1,2000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'lo pedí un viernes y el lunes ya lo tenía en casa ',NULL,'4'),
(108,23,4,9400,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'creo que seguiré confiando con ustedes muy amables ',NULL,'4'),
(108,42,1,1800,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(109,8,1,240,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(109,26,8,2392,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'2'),
(110,36,1,79,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Todo bien....',NULL,'4'),
(111,4,1,1050,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Muy recomendables. ',NULL,'4'),
(112,62,1,284,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'buen trato telefonico y aclaracion de dudas ',NULL,'4'),
(112,6,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Muy contento. Incluso tube un pequeña confusión al hacer el pedido y me lo arreglaron al momento. ',NULL,'4'),
(113,61,1,2950,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(114,35,1,89,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Todo correcto. ',NULL,'4'),
(114,14,3,2400,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Transacción perfecta y rápida. Todo perfecto. ',NULL,'4'),
(115,28,1,750,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Todo genial rápido y de calidad. ',NULL,'4'),
(116,8,1,240,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Buen precio, servicio rápido y el producto tal y como se detalla en la web.Sin sorpresas',NULL,'4'),
(117,22,1,200,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Una compra bien servida tiene poco recorrido. .. pero muy rápido. .. y buen precio. .. no barato. .. si mejor que tiendas locales ',NULL,'4'),
(117,39,1,700,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Seriedad y buena relación calidad precio. Se puede confiar en sus comentarios, no són publicidad engañosa. ',NULL,'4'),
(117,20,8,952,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'El aparato funciona bien para el uso que le doy. ',NULL,'4'),
(118,38,7,14000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'me ha dado todas las preferencias que queria para mi necesidad. ',NULL,'4'),
(119,28,1,750,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'este modelo calidad precio funciona perfectamente ',NULL,'4'),
(119,6,1,80,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'La valoración de las estrellas es por falta de información del artículo. ',NULL,'4'),
(119,41,1,159,'10/08/14 18:31',NULL,NULL,'10/08/14 18:31',0,NULL,NULL,'X'),
(120,1,5,2100,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Muy buen producto, de marca reconocida y que tiene todas las prestaciones. ',NULL,'4'),
(121,56,1,260,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Esto fue un regalo para mis padres. El envío superrrrrápido. El producto, lo que prometian. Funciona de maravilla. No se puede pedir mas ',NULL,'4'),
(121,55,1,3750,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'2'),
(121,54,1,239,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,' lo compre en otro lado pero dejo esta informacion por si puede ser util. ',NULL,'4'),
(122,44,1,900,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Me enviaron la versión alemana del producto. ',NULL,'4'),
(122,62,1,284,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'no informa adecuadamente al cliente, me explico si dice que es un producto importado, pero nada mas ',NULL,'4'),
(122,25,1,73,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Los acabados  son muy buenos, tiene el perfil muy fino ',NULL,'4'),
(122,16,1,150,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,'No podemos cumplir la orden, disculpe las molestias','R'),
(122,21,6,5544,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'lo pedí un viernes y el lunes ya lo tenía en casa ',NULL,'4'),
(123,43,1,1700,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'creo que seguiré confiando con ustedes muy amables ',NULL,'4'),
(123,43,8,13600,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'ya habia comprado aqui antes y el producto perfecto sin problemas ',NULL,'4'),
(124,4,9,9450,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'El envío ha sido muy rápido y el material responde completamente a las especificaciones. Recomiendo a este vendedor. ',NULL,'4'),
(125,43,1,1700,'10/08/14 18:31','10/08/14 18:31',NULL,NULL,0,NULL,NULL,'3'),
(126,61,1,2950,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Todo bien....',NULL,'4'),
(126,35,1,89,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Muy recomendables. ',NULL,'4'),
(126,36,1,79,'10/08/14 18:31',NULL,NULL,'10/08/14 18:31',0,NULL,NULL,'X'),
(127,31,1,3890,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Muy contento. Incluso tube un pequeña confusión al hacer el pedido y me lo arreglaron al momento. ',NULL,'4'),
(127,24,1,2000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Todo perfecto. Envio rápido. ',NULL,'4'),
(127,11,2,1398,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Todo correcto. ',NULL,'4'),
(127,65,1,200,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Transacción perfecta y rápida. Todo perfecto. ',NULL,'4'),
(127,13,1,1000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Todo genial rápido y de calidad. ',NULL,'4'),
(127,37,8,4480,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Buen precio, servicio rápido y el producto tal y como se detalla en la web.Sin sorpresas',NULL,'4'),
(128,7,1,1199,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'2'),
(128,26,1,299,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Seriedad y buena relación calidad precio. Se puede confiar en sus comentarios, no són publicidad engañosa. ',NULL,'4'),
(128,31,1,3890,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'El aparato funciona bien para el uso que le doy. ',NULL,'4'),
(129,56,8,2080,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'me ha dado todas las preferencias que queria para mi necesidad. ',NULL,'4'),
(130,51,1,3890,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'este modelo calidad precio funciona perfectamente ',NULL,'4'),
(131,22,1,200,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'2'),
(131,15,1,500,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,2,'Deben haber tenido algun problema.',NULL,'N'),
(131,46,1,450,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Muy buen producto, de marca reconocida y que tiene todas las prestaciones. ',NULL,'4'),
(132,45,1,2199,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Esto fue un regalo para mis padres. El envío superrrrrápido. El producto, lo que prometian. Funciona de maravilla. No se puede pedir mas ',NULL,'4'),
(132,47,1,600,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Buena relacion Calidad precio. ',NULL,'4'),
(132,52,1,139,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,' lo compre en otro lado pero dejo esta informacion por si puede ser util. ',NULL,'4'),
(133,17,1,50,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Me enviaron la versión alemana del producto. ',NULL,'4'),
(133,43,1,1700,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'no informa adecuadamente al cliente, me explico si dice que es un producto importado, pero nada mas ',NULL,'4'),
(134,29,1,17000,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'Los acabados  son muy buenos, tiene el perfil muy fino ',NULL,'4'),
(135,2,8,680,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'la recomiendo a todo el mundo, relacion calidad precio muy buena ',NULL,'4'),
(136,44,1,900,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'lo pedí un viernes y el lunes ya lo tenía en casa ',NULL,'4'),
(137,16,1,150,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'creo que seguiré confiando con ustedes muy amables ',NULL,'4'),
(138,40,5,345,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'ya habia comprado aqui antes y el producto perfecto sin problemas ',NULL,'4'),
(138,34,1,749,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'El envío ha sido muy rápido y el material responde completamente a las especificaciones. Recomiendo a este vendedor. ',NULL,'4'),
(139,15,1,500,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,4,'excelente en todo ',NULL,'4'),
(140,15,1,500,'10/08/14 18:31',NULL,NULL,NULL,0,NULL,NULL,'1'),
(141,7,1,1199,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Muy recomendables. ',NULL,'4'),
(141,64,1,449,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'buen trato telefonico y aclaracion de dudas ',NULL,'4'),
(142,40,1,69,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,5,'Muy contento. Incluso tube un pequeña confusión al hacer el pedido y me lo arreglaron al momento. ',NULL,'4'),
(142,62,1,284,'10/08/14 18:31','10/08/14 18:31','10/08/14 18:31',NULL,3,'Todo perfecto. Envio rápido. ',NULL,'4');