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
        if(event.data === "_success_login") {$('#Login-modal').modal('hide');}
        else if (event.data ==="_error_user") {$('#user').css("border-color","red");}
        else if (event.data ==="_error_pwd") {$('#pass').css("border-color","red");}
        else if (event.data == "_display_modal") {$('#Login-modal').modal('show');}
        else document.getElementById('messages').innerHTML += '<br />'
                + event.data;
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