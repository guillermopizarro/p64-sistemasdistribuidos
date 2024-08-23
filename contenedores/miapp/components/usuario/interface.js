const express = require('express')

const controller = require('./controller')
const response = require('../../network/response')

const routes = express.Router()

routes.post('/', function(req, res) {
    controller.insertar_usuario( req.body )
        .then( (data) => response.success(req, res, data, 201) )
        .catch( (error) => response.error(req, res, error, 400) )
})

routes.get('/', function(req, res) {
    controller.obtener_usuario( req.body )
        .then( (data) => response.success(req, res, data, 201) )
        .catch( (error) => response.error(req, res, error, 400) )
})

routes.put('/', function(req, res){
    controller.actualizar_usuario( req.body )
        .then( (data) => response.success(req, res, data, 201) )
        .catch( (error) => response.error(req, res, error, 400) )
})

routes.delete('/', function(req, res){
    controller.eliminar_usuario( req.body )
        .then( (data) => response.success(req, res, data, 201) )
        .catch( (error) => response.error(req, res, error, 400) )
})

module.exports = routes