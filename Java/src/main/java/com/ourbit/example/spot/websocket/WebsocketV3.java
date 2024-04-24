package com.ourbit.example.spot.websocket;

import com.ourbit.example.spot.api.v3.wslistenkey.CreateListenKey;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import okhttp3.*;
import okio.ByteString;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


@Getter
@Slf4j
public final class WebsocketV3 extends WebSocketListener {

    private WebSocket privateClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(0, TimeUnit.MILLISECONDS)
                .build();
        Map<String, String> params = new HashMap<>();
        params.put("recWindow", "60000");
        String listenKey = CreateListenKey.postUserDataStream(params).get("listenKey");

        Request request = new Request.Builder()
                .url("wss://wbs.ourbit.com/ws?listenKey=" + listenKey)
                .build();
        WebSocket webSocket = client.newWebSocket(request, this);

        //Trigger shutdown of the dispatcher's executor so this process can exit cleanly.
        client.dispatcher().executorService().shutdown();
        return webSocket;
    }

    private WebSocket publicClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .readTimeout(0, TimeUnit.MILLISECONDS)
                .build();

        Request request = new Request.Builder()
                .url("wss://wbs.ourbit.com/ws")
                .build();
        WebSocket webSocket = client.newWebSocket(request, this);

        //Trigger shutdown of the dispatcher's executor so this process can exit cleanly.
        client.dispatcher().executorService().shutdown();
        return webSocket;
    }

    @Override
    public void onOpen(WebSocket webSocket, Response response) {
        log.info("OURBIT-WS CONNECTED ....");
    }

    @Override
    public void onMessage(WebSocket webSocket, String text) {
        System.out.println(Instant.now().toEpochMilli() + "MESSAGE: " + text);
    }

    @Override
    public void onMessage(WebSocket webSocket, ByteString bytes) {
        System.out.println("MESSAGE: " + bytes.hex());
    }

    @Override
    public void onClosing(WebSocket webSocket, int code, String reason) {
        webSocket.close(1000, null);
        System.out.println("CLOSE: " + code + " " + reason);
    }

    @Override
    public void onFailure(WebSocket webSocket, Throwable t, Response response) {
        t.printStackTrace();
    }

    public static void main(String... args) {
        WebsocketV3 websocketV3 = new WebsocketV3();
        //sub public channel
        WebSocket publicClient = websocketV3.publicClient();
        publicClient.send("{\n" +
                "\"method\": \"SUBSCRIPTION\",\n" +
                "\"params\": [\n" +
                "\"spot@public.limit.depth.v3.api@BDPUSDT@5\"\n," +
                "\"spot@public.kline.v3.api@BTCUSDT@Min15\"\n," +
                "\"spot@public.deals.v3.api@BTCUSDT\"\n," +
                "\"spot@public.increase.depth.v3.api@BTCUSDT\"\n," +
                "\"spot@public.bookTicker.v3.api@BTCUSDT\"\n" +
                "]\n }");


        //sub private channel
        WebSocket privateClient = websocketV3.privateClient();
        privateClient.send("{\"id\":1,\"method\":\"SUBSCRIPTION\",\"params\":[\"spot@private.deals.v3.api\",\"spot@private.orders.v3.api\"]}");
        privateClient.send("{\"id\":1,\"method\":\"SUBSCRIPTION\",\"params\":[\"spot@private.account.v3.api\"]}");
    }


}