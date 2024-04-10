const Spot = require('../src/spot')
const apiKey = ''
const apiSecret = ''
const client = new Spot(apiKey, apiSecret, { baseURL: 'https://api.ourbit.com' })


client.BatchOrders({ batchOrders: [{ "type": "LIMIT", "price": "XX", "quantity": "XX", "symbol": "OBUSDT", "side": "BUY" }, { "type": "LIMIT", "price": "XX", "quantity": "XX", "symbol": "OBUSDT", "side": "BUY" }] })
    .then(response => client.logger.log(response.data))