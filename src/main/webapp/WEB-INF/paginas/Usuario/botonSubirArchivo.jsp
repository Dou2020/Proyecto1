<!-- Este boton realiza la seleccion del archivo 
<form action="upload" method="post" enctype="multipart/form-data">
    <input type="text" name="description" />
    <input type="file" name="file" />
    <input type="submit" />
</form>
-->

<form action="lectura-archivo" method="post" enctype="multipart/form-data">
    <table>
        <tr>
            <td>
                    <label for="formFile" class="form-label"></label>
                    <input class="form-control" type="file" id="formFile" name="file">
            </td>
            <td>
                    <input class="btn btn-primary" type="submit" />
            </td>
        </tr>
    </table>
</form>