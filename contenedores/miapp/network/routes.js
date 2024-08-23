const usuario = require('../components/usuario/interface')

const routes = function( server ) {
    server.use('/usuario', usuario)
}

module.exports = routes