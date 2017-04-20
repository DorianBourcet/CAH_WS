/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$('#Login-modal').modal({
    backdrop: "static",
    show: false
});
$('#toggle').on('click', function(){
    $('#subscribe').toggleClass('invis');
    $('#login').toggleClass('invis');
    $('#email_field').toggleClass('invis');
    if($('#toggle').val() === "S'inscrire") {
        $('#toggle').val("Se connecter");
        $('#modal_title').html("Sign up")
    }
    else {
        $('#toggle').val("S'inscrire");
        $('#modal_title').html("Sign in")
    }
});