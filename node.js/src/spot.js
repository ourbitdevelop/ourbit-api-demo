const APIBase = require('./APIBase')
const modules = require('./modules')
const { flowRight } = require('./helpers/utils')

class Spot extends flowRight(...Object.values(modules))(APIBase) {
  constructor (apiKey = '', apiSecret = '', options = {}) {
    options.baseURL = options.baseURL || 'https://api.ourbit.com'
    super({
      apiKey,
      apiSecret,
      ...options
    })
  }
}
module.exports = Spot