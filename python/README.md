# Ourbit Python Demo

Before you use the demo, you need to generate your apikey & apisecret, then enter them first.

* <https://www.ourbit.com/user/openapi>

## Spot V2、V3 Demo 

Fill in the corresponding function according to the parameters mentioned in the API documentation and execute it. => `print()`

**Rest API V2 doc**   `URL = 'https://www.ourbit.com'`

* <https://ourbitdevelop.github.io/apidocs/spot_v2_cn/#5ea2e0cde2>

**Rest API V3 doc**   `URL = 'https://api.ourbit.com'`

* <https://ourbitdevelop.github.io/apidocs/spot_v3_cn/#45fa4e00db>


> ### Example(Spot V3) :

Use test_v3.py as a test example

```python
import ourbit_spot_v3
import time

hosts = "https://api.ourbit.com"
# ourbit_key = "your apiKey"
# ourbit_secret = "your secretKey"

# Market Data
"""get kline"""
data = ourbit_spot_v3.ourbit_market(ourbit_hosts=hosts)
params = {
    'symbol': 'BTCUSDT', 
    'interval': '5m', 
    'limit': 10
}
response= data.get_kline(params)
print(response)
```

## Spot Websocket Demo 

According to the information you want to subscribe, change the content of the params according to the websocket documentation, ex: "op" or "symbol".   Execute the entire python file after adjusting the parameters.

**WebSocket doc**   `URL = 'wss://wbs.ourbit.com/raw/ws'`

* <https://ourbitdevelop.github.io/apidocs/spot_v2_cn/#websocket-api>


> ### Example(Spot WebSocket) :
```python
import json
import websocket

BASE_URL = 'wss://wbs.ourbit.com/raw/ws'

def on_message(ws, message):
    print(message)

def on_error(ws, error):
    print(error)

def on_close(ws):
    print("Connection closed ....")

def on_open(ws):
    params = {        
        "op": "sub.symbol",
        "symbol": "ETH_USDT",       
    }    
    print(json.dumps(params))    
    ws.send(json.dumps(params))


if __name__ == "__main__":
    websocket.enableTrace(True)
    ws = websocket.WebSocketApp(BASE_URL,
                                on_message=on_message,
                                on_error=on_error,
                                on_close=on_close,
                                )
    ws.on_open = on_open
    ws.run_forever(ping_timeout=10)

```
