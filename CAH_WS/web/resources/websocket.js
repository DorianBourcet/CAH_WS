    function initWebSocket(ws){
    ws.onerror = function(event) {
        console.log('event onError');
        onError(event);
    };

    ws.onopen = function(event) {
        console.log('event onOpen');
        onOpen(event);
        ws.send('_new_client');
    };

    ws.onmessage = function(event) {
        console.log('event onMessage');
        onMessage(event);
    };
    }

    function onMessage(event) {
        
        var response = event.data;
        console.log(response.trim());
        switch(event.data){
            case "_success_login": {
                    $('#Login-modal').modal('hide');
                    $('#pass').css("border-color", "rgba(0, 0, 0, 0.14902)");
                    break;
            }
            case "_error_user": $('#user').css("border-color","red");break;
            case "_error_pwd": $('#pass').css("border-color","red");break;
            case "_display_modal": $('#Login-modal').modal('show');break;
            case "_success_subscribe": {
                    $('#user').css("border-color","green");
                    $('#pass').css("border-color","green");
                    $('#email').css("border-color","green");
                    break;
            }
            case "_error_subscribe_missing_datas": {
                    $('#user').css("border-color","red");
                    $('#pass').css("border-color","red");
                    $('#email').css("border-color","red");
                    break;
            }
            default: {
                    $('#messages').append("<br>"+event.data);
                    $('.screen').animate({scrollTop: $('.screen').prop("scrollHeight") - $('.screen').height() },100);
                    break;
            }
        }
    }

    function onOpen(event) {
        document.getElementById('messages').innerHTML = 'Now Connection established';
    }

    function onError(event) {
        alert(event.data);
    }

    /*function start() {
        var text = document.getElementById("userinput").value;

        webSocket.send(text);
        return false;
    }*/