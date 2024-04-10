const Spot = require('../src/spot')
const client = new Spot(apiKey, apiSecret, { baseURL: 'https://api.ourbit.com' })


client.TickerPriceChange().then(response => client.logger.log(response.data))
  .catch(error => client.logger.error(error))

