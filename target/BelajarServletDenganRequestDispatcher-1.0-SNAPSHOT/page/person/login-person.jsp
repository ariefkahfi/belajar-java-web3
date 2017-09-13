<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Person Page</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
    <style>
        .error{
            color:  red;
        }
    </style>
<body>
    <h2>
        Login Person
    </h2>

    <form>
        <table>
            <tr>
                <td>Kode Person</td>
                <td><input type="number" id="kode-person" name="kode-person" placeholder="Kode Person Anda"/></td>
                <td class="error" id="err-kode"></td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Login"/></td>
            </tr>
        </table>
    </form>
</body>
    <script>
        $(document).ready(function(){
            $('form').submit(function(){
                var kode = $('#kode-person').val();
                if(kode===''){
                   $('#err-kode').text('Kode Person masih kosong');
                   return false;
                }else{
                   $('form').attr('method','POST');
                   $('form').attr('/arief/person/login');
                }
            });
        });
    </script>
</html>
