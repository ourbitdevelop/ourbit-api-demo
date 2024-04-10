import ourbit_spot_v3

hosts = "https://api.ourbit.com"
ourbit_key = "your apiKey"
ourbit_secret = "your secretKey"

# Market Data
"""get kline"""
data = ourbit_spot_v3.ourbit_market(ourbit_hosts=hosts)
params = {
    'symbol': 'BTCUSDT',
    'interval': '5m',
    'limit': 10
}
response = data.get_kline(params)
print(response)


# Spot Trade
"""place an order"""
trade = ourbit_spot_v3.ourbit_trade(ourbit_key=ourbit_key, ourbit_secret=ourbit_secret, ourbit_hosts=hosts)
params = {
    "symbol": "BTCUSDT",
    "side": "BUY",
    "type": "LIMIT",
    "quantity": 0.005,
    "price": "10000"
}
response = trade.post_order(params)
print(response)

"""get account selfSymbols"""
response = trade.get_selfSymbols()
print(response)

# Spot Account
"""get spot account information"""
account = ourbit_spot_v3.ourbit_account(ourbit_key=ourbit_key, ourbit_secret=ourbit_secret, ourbit_hosts=hosts)
response = account.get_account_info()
print(response)


# Capital
"""get currency information"""
capital = ourbit_spot_v3.ourbit_capital(ourbit_key=ourbit_key, ourbit_secret=ourbit_secret, ourbit_hosts=hosts)
response = capital.get_coinlist()
print(response)


# Sub-Account
"""get sub account information"""
sub_account = ourbit_spot_v3.ourbit_subaccount(ourbit_key=ourbit_key, ourbit_secret=ourbit_secret, ourbit_hosts=hosts)
response = sub_account.get_SubAccountList()
print(response)


# Rebate
"""get rebate record details"""
margin = ourbit_spot_v3.ourbit_rebate(ourbit_key=ourbit_key, ourbit_secret=ourbit_secret, ourbit_hosts=hosts)
response = margin.get_rebate_detail()
print(response)