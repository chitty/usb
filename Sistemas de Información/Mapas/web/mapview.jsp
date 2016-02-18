<!--
To change this template, choose Tools | Templates
and open the template in the editor.
-->
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title><bean:write name="ConsultarMapaForm" property="name" /></title>

        <link rel="stylesheet" href="estilo.css" type="text/css" />
        <link rel="stylesheet" href="stylemap.css" type="text/css" />
        <style type="text/css">
            #controlToggle li {
                list-style: none;
            }
            p {
                width: 550px;
            }

            /* avoid pink tiles */
            .olImageLoadError {
                background-color: transparent !important;
            }
        </style>
        <script src="OpenLayers-2.9/OpenLayers.js"></script>
        <script type="text/javascript">
            var map, drawControls;
            var tiled;
            var pureCoverage = false;
            var name = '<bean:write name="ConsultarMapaForm" property="name" />';
            // pink tile avoidance
            OpenLayers.IMAGE_RELOAD_ATTEMPTS = 5;
            // make OL compute scale according to WMS spec
            OpenLayers.DOTS_PER_INCH = 25.4 / 0.28;

            function init(){
                // if this is just a coverage or a group of them, disable a few items,
                // and default to jpeg format
                format = 'image/png';
                if(pureCoverage) {
                    document.getElementById('filterType').disabled = true;
                    document.getElementById('filter').disabled = true;
                    document.getElementById('antialiasSelector').disabled = true;
                    document.getElementById('updateFilterButton').disabled = true;
                    document.getElementById('resetFilterButton').disabled = true;
                    document.getElementById('jpeg').selected = true;
                    format = "image/jpeg";
                }

                var bounds = new OpenLayers.Bounds(
                5.904, 22.382,
                710.746, 393.382
            );
                var options = {
                    controls: [],
                    maxExtent: bounds,
                    maxResolution: 2.7532890625,
                    projection: "EPSG:4326",
                    units: 'degrees'
                };
                map = new OpenLayers.Map('map', options);

                // setup tiled layer
                tiled = new OpenLayers.Layer.WMS(
                "MYS", "http://localhost:8080/geoserver/wms",
                {
                    width: '800',
                    layers: 'cite:'+name,
                    styles: '',
                    srs: 'EPSG:4326',
                    height: '500',
                    format: format,
                    tiled: 'true',
                    tilesOrigin : map.maxExtent.left + ',' + map.maxExtent.bottom
                },
                {
                    buffer: 0,
                    displayOutsideMaxExtent: true
                }
            );

                var pointLayer = new OpenLayers.Layer.Vector("Point Layer");
                var lineLayer = new OpenLayers.Layer.Vector("Line Layer");
                var polygonLayer = new OpenLayers.Layer.Vector("Polygon Layer");

                map.addLayers([tiled, pointLayer, lineLayer, polygonLayer]);

                // build up all controls
                map.addControl(new OpenLayers.Control.PanZoomBar({
                    position: new OpenLayers.Pixel(2, 15)
                }));
                map.addControl(new OpenLayers.Control.Navigation());
                map.addControl(new OpenLayers.Control.Scale($('scale')));
                map.addControl(new OpenLayers.Control.MousePosition({element: $('location')}));
                map.zoomToExtent(bounds);
                map.addControl(new OpenLayers.Control.LayerSwitcher());
                map.addControl(new OpenLayers.Control.OverviewMap());


                drawControls = {
                    point: new OpenLayers.Control.DrawFeature(pointLayer,
                    OpenLayers.Handler.Point),
                    line: new OpenLayers.Control.DrawFeature(lineLayer,
                    OpenLayers.Handler.Path),
                    polygon: new OpenLayers.Control.DrawFeature(polygonLayer,
                    OpenLayers.Handler.Polygon)
                };

                for(var key in drawControls) {
                    map.addControl(drawControls[key]);
                }

                map.setCenter(new OpenLayers.LonLat(0, 0), 3);

                document.getElementById('noneToggle').checked = true;
            }

            function toggleControl(element) {
                for(key in drawControls) {
                    var control = drawControls[key];
                    if(element.value == key && element.checked) {
                        control.activate();
                    } else {
                        control.deactivate();
                    }
                }
            }
        </script>
    </head>
    <body onload="init()">
        <h1 id="title"><bean:write name="ConsultarMapaForm" property="name" /></h1>

        <div id="tags"></div>

        <p id="shortdesc"></p>

        <div id="map" class="smallmap"></div>
        <h2>Opciones:</h2>
        <ul id="controlToggle">
            <li>
                <input type="radio" name="type" value="none" id="noneToggle"
                       onclick="toggleControl(this);" checked="checked" />
                <label for="noneToggle">navegar</label>
            </li>
            <li>
                <input type="radio" name="type" value="point" id="pointToggle" onclick="toggleControl(this);" />
                <label for="pointToggle">dibujar punto</label>
            </li>
            <li>
                <input type="radio" name="type" value="line" id="lineToggle" onclick="toggleControl(this);" />
                <label for="lineToggle">dibujar linea</label>
            </li>
            <li>
                <input type="radio" name="type" value="polygon" id="polygonToggle" onclick="toggleControl(this);" />
                <label for="polygonToggle">dibujar poligono</label>
            </li>
        </ul>

        <div id="docs">
            <h2>Instrucciones:</h2>
            <p>Con la opcion de dibujar punto activada, haga click en el mapa para añadir un punto.</p>
            <p>Con la opcion de dibujar linea activada, haga click en el mapa para añadir una linea.
                Haga doble-click para finalizar de dibujar la linea.</p>
            <p>Con la opcion de dibujar poligono activada, haga click en el mapa para añadir puntos para construir
                un poligono. Haga doble-click para finalizar de dibujar el poligono.</p>
            <p>Mantenga la tecla shift presionada mientras dibuja una linea o poligono para marcar el mapa a pulso.<p>
        </div>
    </body>
</html>