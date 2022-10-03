

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Formulario</title>
    </head>
    <body>
        <h1>Formulario de contacto</h1>
          <form action="controlador" method="post">
            <ul>
                <li>
                    <label>ID:</label>
                    <input type="text" name="id">
                </li>
                <li>
                    <label>Nombre:</label>
                    <input type="text" name="nombre">
                </li>
                <li>
                    <label>Apellido:</label>
                    <input type="text" name="apellido">
                </li>
                <li>
                    <label >Edad:</label>
                    <input type="text" name="edad" >
                </li>
                 <li>
                    <label >correo:</label>
                    <input type="text" name="email" >
                </li>
                 <li>
                    <label >Curso:</label>
                    <input type="text" name="curso" >
                </li>


                <li> <input type="submit" value="Enviar"> </li>
            </ul>
        </form>
        
    </body>
</html>
