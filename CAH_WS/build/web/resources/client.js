var room = null;
var required_action = null;

$(function(){
    var webSocket = new WebSocket(
        'ws://localhost:8080/CAH_WS/websocket');
    initWebSocket(webSocket);
    
    $('#login').on('click',function(){
        webSocket.send("LOGIN "+$('#user').val()+" "+$('#pass').val());
        $('#pass').val("");
    });
    $('#sndMessage').on('click',function(){
        var cmd = $('#someMessage').val().split(" ");
        webSocket.send(cmd[0]+" "+cmd[1]+" "+cmd[2]);
        $('#user').empty();
        $('#pass').empty();
    });
    $('#subscribe').on('click', function(){
        webSocket.send("SUBSCRIBE "+$('#user').val()+" "+$('#pass').val()+" "+$('#email').val());
        $('#user').empty();
        $('#pass').empty();
        $('#email').empty();
    });
    $('#logout').on('click', function(){
        webSocket.send("LOGOUT");
        $('#Login-modal').modal('show');
        $('#messages').html("");
    });
    $('#send').on('click', function(){
        //ENVOYER EMAIL ICI AVEC LA VALEUR DE $('#email').val()
        webSocket.send("FORGOT "+$('#email').val());
    });
    $('#send-new-password').on('click', function(){
        if($('#newPass').val() === $('#newPassConfirm').val()){
            webSocket.send("NEWPASS "+$('#newPass').val()+" "+$('#token').val());
            $('#newPass').css("border-color","green");
            $('#newPassConfirm').css("border-color","green");
        }
        else {
            $('#newPassConfirm').css("border-color","red");
        }
    });
});