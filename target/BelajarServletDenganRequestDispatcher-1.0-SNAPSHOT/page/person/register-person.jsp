<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register Person</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>

    <style>
        .error{
            color:  red;
        }
    </style>

<body>
    <form>
        <table>
            <tr>
                <td>Kode Person</td>
                <td><input type="number" id="kode-person" name="kode-person" placeholder="Kode Person Anda"/></td>
                <td class="error" id="err-kode"></td>
            </tr>
            <tr>
                <td>Nama Person</td>
                <td><input type="text" id="nama-person" name="nama-person" placeholder="Nama Person Anda"/></td>
                <td class="error" id="err-nama"></td>
            </tr>
            <tr class="error" id="err-gender"></tr>
            <tr>
                <td>Gender Person</td>
                <td><input type="radio" id="gender-person-male" name="gender-person" value="Male"/>Male</td>
            </tr>
            <tr>
                <td>&nbsp;</td>
                <td><input type="radio" id="gender-person-female" name="gender-person" value="Female"/>Female</td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Daftar Person" style="width: 100%; padding: 0.2%;"/></td>
            </tr>
        </table>
    </form>
</body>
    <script>
        $(document).ready(function(){

            $('#err-gender').hide();

            $('form').submit(function(){
               var kode  = $('#kode-person').val() ;
               var nama = $('#nama-person').val();
               var gender = $('form :radio:checked').val();


               if(kode==='' || nama==='' || gender===undefined){

                   if(kode===''){
                      $('#err-kode').text('Field Kode masih kosong');
                   }else{
                      $('#err-kode').text('');
                   }

                   if(nama===''){
                      $('#err-nama').text('Field nama masih kosong');
                   }else{
                      $('#err-nama').text('');
                   }

                   if(gender===undefined){
                     $('#err-gender').text('Gender masih kosong');
                     $('#err-gender').show();
                   }else{
                     $('#err-gender').text('');
                     $('#err-gender').hide();
                   }

                   return false;
               }else{
                   $('form').attr('method','POST');
                   $('form').attr('action','/arief/register/person');
               }

            });
        });
    </script>
</html>
