<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Person</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

<body>

    <div>Kode Person : <span>${kode}</span></div>
    <div>Nama Person : ${nama}</div>
    <div>Gender : ${gender}</div>
    <form>
        <table>
            <tr>
                <td colspan="2"><input type="number" name="old-kode-person" readonly="readonly" value="${kode}"/></td>
            </tr>
            <tr>
                <td>Nama Person Baru :</td>
                <td><input type="text" name="new-name-person" id="new-name-person" placeholder="Nama Person Baru"/></td>
            </tr>
            <tr>
                <td>Gender :</td>
                <td><input type="radio" name="new-gender-person" id="new-gender-male-person" value="Male"/>Male</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="radio" name="new-gender-person" id="new-gender-female-person" value="Female"/>Female</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="submit" value="Update Data Person"/></td>
            </tr>
            <tr>
                <td colspan="2" id="err-form"></td>
            </tr>
        </table>
    </form>

</body>
    <script>
        $(document).ready(function(){
            $('form').submit(function () {
                var oldKode = $('div span').text();

                var newNama = $('#new-name-person').val();
                var newGender = $('form :radio:checked').val();

                if(newNama==='' || newGender===undefined){
                    $('#err-form').text('Masih ada form yang kosong');
                    return false;
                }else{
                    $('#err-form').text('');
                    $('form').attr('method','POST');
                    $('form').attr('action','/arief/person/list/update');
                }
            });
        });
    </script>
</html>
