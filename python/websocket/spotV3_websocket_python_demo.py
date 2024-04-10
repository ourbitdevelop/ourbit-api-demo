import json
import websocket
from python.spot.v3 import ourbit_spot_v3
import threading, time

BASE_URL = 'wss://wbs.ourbit.com/ws'
hosts = 'https://api.ourbit.com'
ourbit_key = "your apiKey"
ourbit_secret = "your secretKey"

# listenKey = ourbit_spot_v3.ourbit_listenkey(ourbit_key=ourbit_key, ourbit_secret=ourbit_secret, ourbit_hosts=hosts)

""" 建立 ListenKey """
""" generate ListenKey """
#ListenKey = listenKey.post_listenKey()['listenKey']

""" 延長 ListenKey 有效期 """
""" Extend ListenKey validity """
# params = {'listenKey': ListenKey}
# print(listenKey.put_listenKey(params))

""" 刪除 ListneKey """
""" Delete ListenKey """
# params = {'listenKey': ListenKey}
# print(listenKey.delete_listenKey(params))

#BASE_URL = 'wss://wbs.ourbit.com/ws' + '?listenKey=' + ListenKey

def on_message(ws, message):
    print(message)


def on_error(ws, error):
    print('Connection error ....')
    print(error)


def on_close(ws):
    print("Connection closed ....")


def on_open(ws):
    """
    根據想訂閱信息, 依照websocket文檔更改"method"及"params"中的內容
    According to the information you want to subscribe,
    change the content of the "method" and "params" according to the websocket documentation,
    """
    params = {
        "method": "SUBSCRIPTION",
        "params":[
            "spot@public.deals.v3.api@BTCUSDT",
            # "spot@public.kline.v3.api@BTCUSDT@Min5",
            # "spot@public.increase.depth.v3.api@BTCUSDT",
            # "spot@public.limit.depth.v3.api@BTCUSDT@5",
            # "spot@public.bookTicker.v3.api@BTCUSDT",
            # "spot@private.account.v3.api",
            # "spot@private.orders.v3.api",
            # "spot@private.deals.v3.api"
        ]
    }
    print(json.dumps(params))
    ws.send(json.dumps(params))
    print('Opened ....')
    def send_ping():
        for i in range(1000):
            time.sleep(30)
            params = {"method": "ping"}
            ws.send(json.dumps(params))
    threading.Thread(target=send_ping).start()


if __name__ == "__main__":
    websocket.enableTrace(False)
    ws = websocket.WebSocketApp(BASE_URL,
                                on_message=on_message,
                                on_error=on_error,
                                on_close=on_close)
    ws.on_open = on_open
    ws.run_forever()
